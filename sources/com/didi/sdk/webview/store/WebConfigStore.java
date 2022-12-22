package com.didi.sdk.webview.store;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.didi.onehybrid.util.C10393Util;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.store.DiskCache;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WebConfigStore extends BaseStore {

    /* renamed from: a */
    private static final String f38495a = "WebConfigStore";

    /* renamed from: c */
    private static List<String> f38496c = m27274a();

    /* renamed from: d */
    private static final String f38497d = "web_view_hos_white_list";

    /* renamed from: e */
    private static final String f38498e = "global_pax_hosts_whitelist";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<String> f38499b = null;

    private WebConfigStore() {
        super("framework-WebConfigStore");
    }

    public static WebConfigStore getInstance() {
        return (WebConfigStore) SingletonHolder.getInstance(WebConfigStore.class);
    }

    /* renamed from: a */
    private static List<String> m27274a() {
        ArrayList arrayList = new ArrayList();
        f38496c = arrayList;
        return arrayList;
    }

    public void getMisConfigFromApollo(Context context) {
        JSONObject jsonToggle = Apollo.getJsonToggle(f38498e);
        if (jsonToggle != null) {
            m27277a(jsonToggle, context);
        }
    }

    /* renamed from: a */
    private void m27277a(JSONObject jSONObject, final Context context) {
        List<String> a = m27276a(jSONObject);
        if (a != null) {
            this.f38499b = a;
        }
        if (this.f38499b != null) {
            SystemUtils.log(4, f38495a, "handleRespons_putAndSave:" + a.toString(), (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 99);
            SystemUtils.startThread(new Thread(new Runnable() {
                public void run() {
                    WebConfigStore webConfigStore = WebConfigStore.this;
                    webConfigStore.putAndSave(context, WebConfigStore.f38497d, webConfigStore.m27273a((List<String>) webConfigStore.f38499b));
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m27273a(List<String> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size() - 1; i++) {
            stringBuffer.append(list.get(i) + ",");
        }
        stringBuffer.append(list.get(list.size() - 1));
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private List<String> m27276a(JSONObject jSONObject) {
        String[] split;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("experiment");
                JSONObject jSONObject3 = jSONObject2 != null ? jSONObject2.getJSONObject("params") : null;
                String string = jSONObject3 != null ? jSONObject3.getString("whitelist") : null;
                if (!TextUtil.isEmpty(string) && (split = string.split(";")) != null && split.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String add : split) {
                        arrayList.add(add);
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<String> getMisConfigFromCache(Context context) {
        String[] split;
        SystemUtils.log(4, f38495a, "getMisConfigFromCache", (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 170);
        DiskCache.DEntry load = load(context, f38497d);
        if (load == null || load.data == null || load.data.length <= 0) {
            return null;
        }
        String str = new String(load.data);
        if (TextUtil.isEmpty(str) || (split = str.split(",")) == null || split.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String add : split) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public List<String> getWhiteList(Context context) {
        if (this.f38499b == null) {
            getMisConfigFromApollo(context);
        }
        if (this.f38499b == null) {
            SystemUtils.log(4, f38495a, "not have apolloWhiteList", (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 204);
            List<String> misConfigFromCache = getMisConfigFromCache(context);
            this.f38499b = misConfigFromCache;
            if (misConfigFromCache == null) {
                SystemUtils.log(4, f38495a, "not have CacheWhiteList return config:" + f38496c.toString(), (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 206);
                return f38496c;
            }
        }
        SystemUtils.log(4, f38495a, " return apolloWhiteList:" + this.f38499b.toString(), (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 210);
        return this.f38499b;
    }

    public boolean isWhiteUrl(String str, Context context) {
        IToggle toggle = Apollo.getToggle(f38498e);
        if (toggle == null || !f38498e.equals(toggle.getName())) {
            SystemUtils.log(4, f38495a, "apollo:has not global_pax_hosts_whitelist", (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 226);
            return false;
        } else if (!toggle.allow()) {
            SystemUtils.log(4, f38495a, "apollo:false", (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 229);
            return true;
        } else if (!C10393Util.isApkDebug(context) || !EnvPreferenceUtil.getBooleanSafely(DIDIApplication.getAppContext(), "evn_whiteurl_debug", false)) {
            SystemUtils.log(4, f38495a, "apollo:true", (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 241);
            return m27280a(str, context);
        } else {
            SystemUtils.log(4, f38495a, "isTest", (Throwable) null, "com.didi.sdk.webview.store.WebConfigStore", 235);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m27280a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() == null) {
                parse = Uri.parse("http://" + str);
            }
            String host = parse.getHost();
            if (TextUtil.isEmpty(host)) {
                return false;
            }
            String lowerCase = host.toLowerCase();
            for (String lowerCase2 : getWhiteList(context)) {
                String lowerCase3 = lowerCase2.toLowerCase();
                if ((lowerCase.endsWith("." + lowerCase3) || lowerCase.equals(lowerCase3)) && (Build.VERSION.SDK_INT >= 28 || m27278a(context, parse, lowerCase3))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private boolean m27278a(Context context, Uri uri, String str) {
        boolean z = false;
        if (uri == null || TextUtils.isEmpty(uri.getEncodedAuthority()) || TextUtils.isEmpty(str)) {
            return false;
        }
        String encodedAuthority = uri.getEncodedAuthority();
        int indexOf = encodedAuthority.indexOf(64);
        int indexOf2 = encodedAuthority.indexOf(92);
        String host = uri.getHost();
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf2 >= indexOf)) {
            host = Uri.decode(encodedAuthority.substring(0, indexOf2)).toLowerCase();
        }
        if (host.endsWith("." + str) || host.equals(str)) {
            z = true;
        }
        if (!z) {
            return z;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return true;
        }
        try {
            String uri2 = uri.toString();
            String substring = uri2.substring(uri2.indexOf("//") + 2, uri2.indexOf(path));
            return (z & TextUtils.equals(substring, host)) | m27279a(substring);
        } catch (Exception unused) {
            return z;
        }
    }

    /* renamed from: a */
    private boolean m27279a(String str) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("ibt_h5_special_host_config");
        if (toggle == null || (experiment = toggle.getExperiment()) == null) {
            return false;
        }
        String str2 = (String) experiment.getParam("configList", "");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str2.split(";");
        for (String equals : split) {
            if (TextUtils.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }
}
