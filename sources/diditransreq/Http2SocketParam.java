package diditransreq;

import android.text.TextUtils;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import didinet.Logger;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Http2SocketParam {

    /* renamed from: a */
    private static final String f57176a = "Http2Socket";

    /* renamed from: b */
    private static final String f57177b = "translist";

    /* renamed from: c */
    private static final String f57178c = "timeout";

    /* renamed from: d */
    private static final String f57179d = "compress_base";

    /* renamed from: e */
    private static final String f57180e = "updatetid";

    /* renamed from: f */
    private static final int f57181f = 0;

    /* renamed from: g */
    private static final int f57182g = 1;

    /* renamed from: h */
    private static Http2SocketParam f57183h = null;

    /* renamed from: n */
    private static final int f57184n = 30;

    /* renamed from: i */
    private int f57185i;

    /* renamed from: j */
    private int f57186j = 10;

    /* renamed from: k */
    private int f57187k = 0;

    /* renamed from: l */
    private int f57188l = 0;

    /* renamed from: m */
    private AtomicInteger f57189m = new AtomicInteger(1);

    /* renamed from: o */
    private Map<String, UrlItem> f57190o = new HashMap();

    /* renamed from: p */
    private boolean f57191p;

    private static class UrlItem {
        public static final int RATE_FAIL = 1;
        public static final int RATE_INIT = -1;
        public static final int RATE_SUCCESS = 0;
        float rate;
        volatile int rateStatus;
        String url;

        private UrlItem() {
            this.rateStatus = -1;
        }
    }

    private Http2SocketParam() {
        m40990c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c0, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m40990c() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f57191p     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            didinet.ApolloKeySwitcher r0 = didinet.ApolloKeySwitcher.getInstance()     // Catch:{ all -> 0x00c1 }
            java.lang.String r0 = r0.getHttpTransReqKey()     // Catch:{ all -> 0x00c1 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c1 }
            r2 = 0
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "Http2Socket"
            java.lang.String r1 = "Apollo key is empty!"
            didinet.Logger.m40928d(r0, r1)     // Catch:{ all -> 0x00c1 }
            r7.f57191p = r2     // Catch:{ all -> 0x00c1 }
            monitor-exit(r7)
            return
        L_0x0021:
            didinet.NetEngine r1 = didinet.NetEngine.getInstance()     // Catch:{ all -> 0x00c1 }
            didinet.ApolloAPI r1 = r1.getApolloAPI()     // Catch:{ all -> 0x00c1 }
            didinet.ApolloAPI$Toggle r0 = r1.getToggle(r0)     // Catch:{ all -> 0x00c1 }
            r1 = 1
            if (r0 == 0) goto L_0x00ac
            boolean r3 = r0.allow()     // Catch:{ all -> 0x00c1 }
            if (r3 == 0) goto L_0x00ac
            r7.f57191p = r1     // Catch:{ all -> 0x00c1 }
            java.lang.String r3 = "Http2Socket"
            java.lang.String r4 = "[%s] Apollo allow => true"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "Http2Socket"
            r5[r2] = r6     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x00c1 }
            didinet.Logger.m40928d(r3, r4)     // Catch:{ all -> 0x00c1 }
            didinet.ApolloAPI$Experiment r0 = r0.getExperiment()     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x009a
            java.lang.String r1 = "translist"
            java.lang.String r3 = ""
            java.lang.Object r1 = r0.getParam(r1, r3)     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00c1 }
            r7.m40989b(r1)     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = "timeout"
            r3 = 10
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c1 }
            java.lang.Object r1 = r0.getParam(r1, r3)     // Catch:{ all -> 0x00c1 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00c1 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00c1 }
            r7.f57186j = r1     // Catch:{ all -> 0x00c1 }
            r3 = 3
            if (r1 >= r3) goto L_0x0075
            r7.f57186j = r3     // Catch:{ all -> 0x00c1 }
        L_0x0075:
            java.lang.String r1 = "compress_base"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c1 }
            java.lang.Object r1 = r0.getParam(r1, r3)     // Catch:{ all -> 0x00c1 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00c1 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00c1 }
            r7.f57187k = r1     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = "updatetid"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c1 }
            java.lang.Object r0 = r0.getParam(r1, r2)     // Catch:{ all -> 0x00c1 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00c1 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00c1 }
            r7.f57188l = r0     // Catch:{ all -> 0x00c1 }
            goto L_0x00bf
        L_0x009a:
            java.lang.String r0 = "Http2Socket"
            java.lang.String r3 = "[%s] Apollo Experiment => null"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = "Http2Socket"
            r1[r2] = r4     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = java.lang.String.format(r3, r1)     // Catch:{ all -> 0x00c1 }
            didinet.Logger.m40928d(r0, r1)     // Catch:{ all -> 0x00c1 }
            goto L_0x00bf
        L_0x00ac:
            r7.f57191p = r2     // Catch:{ all -> 0x00c1 }
            java.lang.String r0 = "Http2Socket"
            java.lang.String r3 = "[%s] Apollo allow => false"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = "Http2Socket"
            r1[r2] = r4     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = java.lang.String.format(r3, r1)     // Catch:{ all -> 0x00c1 }
            didinet.Logger.m40928d(r0, r1)     // Catch:{ all -> 0x00c1 }
        L_0x00bf:
            monitor-exit(r7)
            return
        L_0x00c1:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: diditransreq.Http2SocketParam.m40990c():void");
    }

    /* renamed from: b */
    private void m40989b(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        Object[] objArr = new Object[2];
        objArr[0] = f57176a;
        objArr[1] = isEmpty ? "empty" : str;
        Logger.m40928d(f57176a, String.format("[%s] Apollo get translist value => %s", objArr));
        if (!isEmpty) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f57185i = jSONObject.optInt("type", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("l");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.f57190o.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String[] split = optJSONArray.optString(i, "").split(",");
                        if (split.length >= 2) {
                            UrlItem urlItem = new UrlItem();
                            urlItem.url = split[0];
                            try {
                                urlItem.rate = Float.parseFloat(split[1]);
                            } catch (NumberFormatException unused) {
                                urlItem.rate = 0.0f;
                            }
                            this.f57190o.put(urlItem.url, urlItem);
                        }
                    }
                }
            } catch (JSONException e) {
                Logger.m40931e(f57176a, "", e);
            }
        }
    }

    public static Http2SocketParam getParam() {
        if (f57183h == null) {
            synchronized (Http2SocketParam.class) {
                if (f57183h == null) {
                    f57183h = new Http2SocketParam();
                }
            }
        }
        return f57183h;
    }

    /* renamed from: a */
    private boolean m40987a(UrlItem urlItem) {
        if (urlItem.rateStatus == -1) {
            urlItem.rateStatus = m40986a(urlItem.rate) ^ true ? 1 : 0;
        }
        if (urlItem.rateStatus == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo170582a(String str) {
        if (this.f57191p) {
            int i = this.f57185i;
            if (i == 0) {
                return m40991c(str);
            }
            if (i == 1) {
                return !m40991c(str);
            }
        } else if (this.f57189m.get() < 30) {
            this.f57189m.incrementAndGet();
            m40990c();
        }
        return false;
    }

    /* renamed from: c */
    private boolean m40991c(String str) {
        UrlItem urlItem = this.f57190o.get(m40993e(str));
        if (urlItem != null) {
            boolean a = m40987a(urlItem);
            Logger.m40928d(f57176a, String.format("[%s] api mode： [%s] in the white list => %b", new Object[]{f57176a, str, Boolean.valueOf(a)}));
            return a;
        }
        UrlItem urlItem2 = this.f57190o.get(m40993e(m40992d(str)));
        boolean a2 = urlItem2 != null ? m40987a(urlItem2) : false;
        Logger.m40928d(f57176a, String.format("[%s] domain mode： [%s] in the white list => %b", new Object[]{f57176a, str, Boolean.valueOf(a2)}));
        return a2;
    }

    /* renamed from: d */
    private String m40992d(String str) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + HWMapConstant.HTTP.SEPARATOR + url.getHost() + "/*";
        } catch (Exception e) {
            Logger.m40931e(f57176a, "", e);
            return null;
        }
    }

    /* renamed from: e */
    private String m40993e(String str) {
        try {
            URL url = new URL(str);
            return url.getHost() + url.getPath();
        } catch (Exception e) {
            Logger.m40931e(f57176a, "", e);
            return null;
        }
    }

    /* renamed from: a */
    private boolean m40986a(float f) {
        return new Random().nextFloat() < f;
    }

    /* renamed from: a */
    private boolean m40988a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.equals("https://" + str2)) {
            if (str.equals("http://" + str2)) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo170581a() {
        return this.f57186j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo170583b() {
        return this.f57187k;
    }

    public int getUpdateTid() {
        return this.f57188l;
    }
}
