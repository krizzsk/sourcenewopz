package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import com.appsflyer.AFEvent;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.appsflyer.internal.model.event.Purchase;
import com.appsflyer.internal.model.event.SdkServices;
import com.appsflyer.internal.model.event.Validate;
import com.appsflyer.internal.referrer.Payload;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.x */
public final class C1720x implements Runnable {

    /* renamed from: ǃ */
    private static String f2036 = null;

    /* renamed from: ι */
    private static String f2037 = "https://%ssdk-services.%s/validate-android-signature";
    /* access modifiers changed from: private */

    /* renamed from: ı */
    public WeakReference<Context> f2038;

    /* renamed from: Ɩ */
    private String f2039;
    /* access modifiers changed from: private */

    /* renamed from: ȷ */
    public Map<String, String> f2040;

    /* renamed from: ɩ */
    private String f2041;

    /* renamed from: ɹ */
    private String f2042;

    /* renamed from: Ι */
    private final Intent f2043;

    /* renamed from: І */
    private String f2044;

    /* renamed from: і */
    private String f2045;

    /* renamed from: Ӏ */
    private String f2046;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(AppsFlyerLibCore.f1785);
        sb.append("/androidevent?buildnumber=5.4.0&app_id=");
        f2036 = sb.toString();
    }

    public C1720x(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, Intent intent) {
        this.f2038 = new WeakReference<>(context);
        this.f2041 = str;
        this.f2044 = str2;
        this.f2046 = str4;
        this.f2039 = str5;
        this.f2042 = str6;
        this.f2040 = map;
        this.f2045 = str3;
        this.f2043 = intent;
    }

    public final void run() {
        String str = this.f2041;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isTrackingStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = this.f2038.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.f2044);
                    hashMap.put("sig-data", this.f2046);
                    hashMap.put("signature", this.f2045);
                    final HashMap hashMap2 = new HashMap(hashMap);
                    new Thread(new Runnable() {
                        public final void run() {
                            C1720x xVar = C1720x.this;
                            C1720x.m1700(xVar, hashMap2, xVar.f2040, C1720x.this.f2038);
                        }
                    }).start();
                    hashMap.put("dev_key", this.f2041);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM));
                    String jSONObject = new JSONObject(hashMap).toString();
                    String url = ServerConfigHandler.getUrl(f2037);
                    if (C1683ai.f1911 == null) {
                        C1683ai.f1911 = new C1683ai();
                    }
                    C1683ai.f1911.mo16117("server_request", url, jSONObject);
                    HttpURLConnection r1 = m1699((Purchase) new SdkServices().params(hashMap).urlString(url));
                    int i = -1;
                    if (r1 != null) {
                        i = r1.getResponseCode();
                    }
                    String r4 = AppsFlyerLibCore.getInstance().mo16025(r1);
                    if (C1683ai.f1911 == null) {
                        C1683ai.f1911 = new C1683ai();
                    }
                    C1683ai.f1911.mo16117("server_response", url, String.valueOf(i), r4);
                    JSONObject jSONObject2 = new JSONObject(r4);
                    jSONObject2.put("code", i);
                    if (i == 200) {
                        StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                        sb.append(jSONObject2.toString());
                        AFLogger.afInfoLog(sb.toString());
                        m1702(jSONObject2.optBoolean("result"), this.f2046, this.f2039, this.f2042, jSONObject2.toString());
                    } else {
                        AFLogger.afInfoLog("Failed Validate request");
                        m1702(false, this.f2046, this.f2039, this.f2042, jSONObject2.toString());
                    }
                    if (r1 != null) {
                        r1.disconnect();
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    /* renamed from: ǃ */
    private static HttpURLConnection m1699(Purchase purchase) {
        StringBuilder sb = new StringBuilder("Calling ");
        sb.append(purchase.urlString());
        AFLogger.afDebugLog(sb.toString());
        return new C1675ad(purchase.trackingStopped(AppsFlyerLib.getInstance().isTrackingStopped())).mo16113();
    }

    /* renamed from: ι */
    private static void m1702(boolean z, String str, String str2, String str3, String str4) {
        if (AppsFlyerLibCore.f1787 != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" ");
            sb.append(str3);
            AFLogger.afDebugLog(sb.toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AppsFlyerLibCore.f1787.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AppsFlyerLibCore.f1787;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    /* renamed from: Ι */
    static /* synthetic */ void m1700(C1720x xVar, Map map, Map map2, WeakReference weakReference) {
        if (weakReference.get() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(f2036));
            sb.append(((Context) weakReference.get()).getPackageName());
            String obj = sb.toString();
            String string = AppsFlyerLibCore.getSharedPreferences((Context) weakReference.get()).getString(Payload.REFERRER, "");
            AFEvent key = new Validate((Context) weakReference.get()).key(xVar.f2041);
            key.f1735 = string;
            key.f1736 = xVar.f2043;
            Validate validate = (Validate) key;
            Map<String, Object> r1 = AppsFlyerLibCore.getInstance().mo16028((AFEvent) validate);
            r1.put("price", xVar.f2039);
            r1.put("currency", xVar.f2042);
            r1.put("receipt_data", map);
            if (map2 != null) {
                r1.put("extra_prms", map2);
            }
            String jSONObject = new JSONObject(r1).toString();
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai.f1911.mo16117("server_request", obj, jSONObject);
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection r6 = m1699((Purchase) validate.params(r1).urlString(obj));
                int i = -1;
                if (r6 != null) {
                    i = r6.getResponseCode();
                }
                String r9 = AppsFlyerLibCore.getInstance().mo16025(r6);
                if (C1683ai.f1911 == null) {
                    C1683ai.f1911 = new C1683ai();
                }
                C1683ai.f1911.mo16117("server_response", obj, String.valueOf(i), r9);
                StringBuilder sb2 = new StringBuilder("Validate-WH response - ");
                sb2.append(i);
                sb2.append(": ");
                sb2.append(new JSONObject(r9).toString());
                AFLogger.afInfoLog(sb2.toString());
                if (r6 != null) {
                    r6.disconnect();
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
