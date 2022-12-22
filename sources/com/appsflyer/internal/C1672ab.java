package com.appsflyer.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFDeepLinkManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.ab */
public final class C1672ab extends OneLinkHttpTask {

    /* renamed from: Ι */
    private static List<String> f1891 = Arrays.asList(new String[]{"onelink.me", "onelnk.com", "app.aflink.com"});

    /* renamed from: ı */
    private String f1892;

    /* renamed from: ǃ */
    private String f1893;

    /* renamed from: ι */
    public C1673b f1894;

    /* renamed from: com.appsflyer.internal.ab$b */
    public interface C1673b {
        /* renamed from: ı */
        void mo16037(String str);

        /* renamed from: ɩ */
        void mo16038(Map<String, String> map);
    }

    public C1672ab(Uri uri, AppsFlyerLibCore appsFlyerLibCore) {
        super(appsFlyerLibCore);
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            boolean z = false;
            for (String contains : f1891) {
                if (uri.getHost().contains(contains)) {
                    z = true;
                }
            }
            if (AFDeepLinkManager.f1727 != null) {
                StringBuilder sb = new StringBuilder("Validate custom domain URLs: ");
                sb.append(Arrays.asList(AFDeepLinkManager.f1727));
                AFLogger.afRDLog(sb.toString());
                for (String str : AFDeepLinkManager.f1727) {
                    if (uri.getHost().contains(str) && str != "") {
                        StringBuilder sb2 = new StringBuilder("DeepLink matches customDomain: ");
                        sb2.append(uri.toString());
                        AFLogger.afDebugLog(sb2.toString());
                        z = true;
                    }
                }
            }
            String[] split = uri.getPath().split("/");
            if (z && split.length == 3) {
                this.oneLinkId = split[1];
                this.f1893 = split[2];
                this.f1892 = uri.toString();
            }
        }
    }

    /* renamed from: ι */
    public final boolean mo16110() {
        return !TextUtils.isEmpty(this.oneLinkId) && !TextUtils.isEmpty(this.f1893) && !this.oneLinkId.equals("app");
    }

    public final void initRequest(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        httpsURLConnection.setRequestMethod("GET");
    }

    public final String getOneLinkUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl("https://%sonelink.%s/shortlink-sdk/v1"));
        sb.append("/");
        sb.append(this.oneLinkId);
        sb.append("?id=");
        sb.append(this.f1893);
        return sb.toString();
    }

    public final void handleResponse(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.f1894.mo16038(hashMap);
        } catch (JSONException e) {
            this.f1894.mo16037("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e);
        }
    }

    public final void onErrorResponse() {
        String str = this.f1892;
        if (str == null) {
            str = "Can't get one link data";
        }
        this.f1894.mo16037(str);
    }
}
