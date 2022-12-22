package didihttp;

import android.text.TextUtils;
import android.util.Log;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didiglobal.privacy.domainmonitor.urlconnection.HttpURLConnectionHooker;
import didihttp.internal.URLFilter;
import didihttp.internal.huc.DidiHttpURLConnection;
import didihttp.internal.huc.DidiHttpsURLConnection;
import didinet.ApolloAPI;
import didinet.Logger;
import didinet.NetEngine;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DidiUrlFactory implements Cloneable, URLStreamHandlerFactory {

    /* renamed from: a */
    private static final String f56413a = "DidiUrlFactory";

    /* renamed from: e */
    private static List<String> f56414e = new CopyOnWriteArrayList();

    /* renamed from: f */
    private static URLStreamHandler f56415f = null;

    /* renamed from: g */
    private static URLStreamHandler f56416g = null;

    /* renamed from: i */
    private static final int f56417i = 30;

    /* renamed from: j */
    private static final int f56418j = 1;

    /* renamed from: l */
    private static Map<String, UrlModule> f56419l = new ConcurrentHashMap();

    /* renamed from: b */
    private DidiHttpClient f56420b;

    /* renamed from: c */
    private URLFilter f56421c;

    /* renamed from: d */
    private boolean f56422d;

    /* renamed from: h */
    private AtomicInteger f56423h = new AtomicInteger(0);

    /* renamed from: k */
    private int f56424k;

    static {
        try {
            URL url = new URL("http://localhost");
            URL url2 = new URL("https://localhost");
            f56415f = m40590a(url);
            f56416g = m40590a(url2);
        } catch (Throwable th) {
            Logger.m40928d(f56413a, "static initializer: " + Log.getStackTraceString(th));
        }
    }

    public static void addBlackList(String str) {
        if (!f56414e.contains(str)) {
            f56414e.add(str);
        }
        if (!f56419l.containsKey(str)) {
            UrlModule urlModule = new UrlModule();
            urlModule.url = str;
            urlModule.rate = 1.0f;
            f56419l.put(str, urlModule);
        }
    }

    /* renamed from: a */
    private static URLStreamHandler m40590a(URL url) {
        Field field;
        Field[] declaredFields = URL.class.getDeclaredFields();
        int i = 0;
        while (true) {
            if (i < declaredFields.length) {
                if (Modifier.isTransient(declaredFields[i].getModifiers()) && declaredFields[i].getType().equals(URLStreamHandler.class)) {
                    field = declaredFields[i];
                    break;
                }
                i++;
            } else {
                field = null;
                break;
            }
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return (URLStreamHandler) field.get(url);
        } catch (Throwable th) {
            Logger.m40929d(f56413a, "", th);
            return null;
        }
    }

    public DidiUrlFactory(DidiHttpClient didiHttpClient) {
        this.f56420b = didiHttpClient;
        m40591a();
    }

    /* renamed from: a */
    private void m40591a() {
        ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
        this.f56422d = apolloAPI.getToggle("hook_uc").allow();
        Logger.m40928d(f56413a, "hookEnabled is " + this.f56422d);
        if (this.f56422d) {
            String str = (String) apolloAPI.getToggle("hook_uc").getExperiment().getParam("bl", "");
            int intValue = ((Integer) apolloAPI.getToggle("hook_uc").getExperiment().getParam("enable_domain", 0)).intValue();
            this.f56424k = intValue;
            if (intValue == 1) {
                m40596b(str);
            } else {
                m40592a(str);
            }
        }
    }

    /* renamed from: a */
    private void m40592a(String str) {
        Logger.m40928d(f56413a, String.format("blacklist [%s]", new Object[]{str}));
        f56414e.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("l");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        f56414e.add(optString);
                    }
                }
            } catch (JSONException e) {
                Logger.m40928d(f56413a, "parseParam:" + Log.getStackTraceString(e));
            }
        }
    }

    /* renamed from: b */
    private void m40596b(String str) {
        Logger.m40928d(f56413a, String.format("new blacklist [%s]", new Object[]{str}));
        f56414e.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("l");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    f56419l.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String[] split = optJSONArray.optString(i, "").split(",");
                        if (split.length == 1) {
                            UrlModule urlModule = new UrlModule();
                            urlModule.url = split[0];
                            urlModule.rate = 1.0f;
                            f56419l.put(urlModule.url, urlModule);
                        } else if (split.length >= 2) {
                            UrlModule urlModule2 = new UrlModule();
                            urlModule2.url = split[0];
                            try {
                                urlModule2.rate = Float.parseFloat(split[1]);
                            } catch (NumberFormatException unused) {
                                urlModule2.rate = 0.0f;
                            }
                            f56419l.put(urlModule2.url, urlModule2);
                        }
                    }
                    Logger.m40928d(f56413a, "blurls size:" + f56419l.size());
                }
            } catch (JSONException e) {
                Logger.m40928d(f56413a, "parseParamNew:" + Log.getStackTraceString(e));
            }
        }
    }

    public DidiHttpClient client() {
        return this.f56420b;
    }

    public DidiUrlFactory setClient(DidiHttpClient didiHttpClient) {
        this.f56420b = didiHttpClient;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo169576a(URLFilter uRLFilter) {
        this.f56421c = uRLFilter;
    }

    public DidiUrlFactory clone() {
        return new DidiUrlFactory(this.f56420b);
    }

    public HttpURLConnection open(URL url) throws IOException {
        return HttpURLConnectionHooker.wrapConnection(mo169575a(url, this.f56420b.proxy()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo169575a(URL url, Proxy proxy) throws IOException {
        String protocol = url.getProtocol();
        URLStreamHandler uRLStreamHandler = "https".equals(protocol) ? f56416g : f56415f;
        if ((!this.f56422d || this.f56424k == 1 || m40597c(m40595b(url))) && ((!this.f56422d || this.f56424k != 1 || m40598d(url.toString())) && uRLStreamHandler != null)) {
            if (!this.f56422d && this.f56423h.get() < 30) {
                this.f56423h.incrementAndGet();
                m40591a();
            }
            Logger.m40928d(f56413a, "use default StreamHandler");
            return (HttpURLConnection) new URL((URL) null, url.toString(), uRLStreamHandler).openConnection();
        }
        DidiHttpClient build = this.f56420b.newBuilder().proxy(proxy).build();
        if (protocol.equals("http")) {
            return new DidiHttpURLConnection(url, build, this.f56421c);
        }
        if (protocol.equals("https")) {
            return new DidiHttpsURLConnection(url, build, this.f56421c);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    /* renamed from: b */
    private String m40595b(URL url) {
        return url.getHost() + url.getPath();
    }

    /* renamed from: c */
    private boolean m40597c(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.m40928d(f56413a, "url is empty.");
            return false;
        }
        for (String contains : f56414e) {
            if (str.contains(contains)) {
                Logger.m40928d(f56413a, String.format("[%s] in blacklist", new Object[]{str}));
                return true;
            }
        }
        Logger.m40928d(f56413a, String.format("[%s] not in blacklist", new Object[]{str}));
        return false;
    }

    /* renamed from: d */
    private boolean m40598d(String str) {
        UrlModule urlModule = f56419l.get(m40600f(str));
        if (urlModule != null) {
            boolean a = m40594a(urlModule);
            Logger.m40928d(f56413a, String.format("[%s] api mode： [%s] in the black list => %b", new Object[]{f56413a, str, Boolean.valueOf(a)}));
            return a;
        }
        UrlModule urlModule2 = f56419l.get(m40600f(m40599e(str)));
        boolean a2 = urlModule2 != null ? m40594a(urlModule2) : false;
        Logger.m40928d(f56413a, String.format("[%s] domain mode： [%s] in the black list => %b", new Object[]{f56413a, str, Boolean.valueOf(a2)}));
        return a2;
    }

    /* renamed from: a */
    private boolean m40594a(UrlModule urlModule) {
        if (urlModule.rateStatus == -1) {
            urlModule.rateStatus = m40593a(urlModule.rate) ^ true ? 1 : 0;
        }
        if (urlModule.rateStatus == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private String m40599e(String str) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + HWMapConstant.HTTP.SEPARATOR + url.getHost() + "/*";
        } catch (Exception e) {
            Logger.m40931e(f56413a, "", e);
            return null;
        }
    }

    /* renamed from: f */
    private String m40600f(String str) {
        try {
            URL url = new URL(str);
            return url.getHost() + url.getPath();
        } catch (Exception e) {
            Logger.m40931e(f56413a, "", e);
            return null;
        }
    }

    /* renamed from: a */
    private boolean m40593a(float f) {
        return new Random().nextFloat() < f;
    }

    public URLStreamHandler createURLStreamHandler(final String str) {
        if (str.equals("http") || str.equals("https")) {
            return new URLStreamHandler() {
                /* access modifiers changed from: protected */
                public URLConnection openConnection(URL url) throws IOException {
                    return DidiUrlFactory.this.open(url);
                }

                /* access modifiers changed from: protected */
                public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
                    return HttpURLConnectionHooker.wrapConnection(DidiUrlFactory.this.mo169575a(url, proxy));
                }

                /* access modifiers changed from: protected */
                public int getDefaultPort() {
                    if (str.equals("http")) {
                        return 80;
                    }
                    if (str.equals("https")) {
                        return 443;
                    }
                    throw new AssertionError();
                }
            };
        }
        return null;
    }

    private static class UrlModule {
        public static final int RATE_FAIL = 1;
        public static final int RATE_INIT = -1;
        public static final int RATE_SUCCESS = 0;
        float rate;
        volatile int rateStatus;
        String url;

        private UrlModule() {
            this.rateStatus = -1;
        }
    }
}
