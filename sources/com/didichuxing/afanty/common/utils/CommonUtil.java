package com.didichuxing.afanty.common.utils;

import android.os.Build;
import android.webkit.WebView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class CommonUtil {

    /* renamed from: a */
    private static List<String> f45569a;

    public static int getAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String bytes4Human(long j) {
        if (j / 1000000000 > 0) {
            return "" + (((float) (j / 100000000)) / 10.0f) + "G";
        } else if (j / 1000000 > 0) {
            return "" + (((float) (j / 100000)) / 10.0f) + "M";
        } else if (j / 1000 > 0) {
            return "" + (((float) (j / 100)) / 10.0f) + "K";
        } else {
            return "" + j + "B";
        }
    }

    public static void toast_send_error(String str) {
        SystemUtils.showToast(Toast.makeText(SwarmUtil.getApplication(), str, 0));
    }

    public static boolean validateUrl(WebView webView) {
        if (webView != null) {
            String originalUrl = webView.getOriginalUrl();
            OLog.m32669i("validateUrl:" + originalUrl);
            if (isWhiteUrl(originalUrl)) {
                OLog.m32669i("validateUrl:true");
                return true;
            }
        }
        OLog.m32669i("validateUrl:false");
        return false;
    }

    /* renamed from: a */
    private static List<String> m32663a() {
        List<String> list = f45569a;
        if (list != null && list.size() > 0) {
            return f45569a;
        }
        f45569a = new ArrayList();
        IToggle toggle = Apollo.getToggle(Constants.AFANTY_CONFIG_TOGGLE_NAME);
        if (toggle == null) {
            return f45569a;
        }
        if (!toggle.allow()) {
            return f45569a;
        }
        IExperiment experiment = toggle.getExperiment();
        if (experiment == null) {
            return f45569a;
        }
        try {
            JSONArray jSONArray = new JSONArray((String) experiment.getParam(Constants.DOMAIN_WHITELIST_KEY, "[]"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                f45569a.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            OLog.m32668e(e.getMessage());
        }
        return f45569a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isWhiteUrl(java.lang.String r6) {
        /*
            java.util.List r0 = m32663a()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.net.URI r3 = new java.net.URI     // Catch:{ Exception -> 0x0068 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r4 = r3.getScheme()     // Catch:{ Exception -> 0x0068 }
            if (r4 != 0) goto L_0x0036
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0068 }
            r3.<init>()     // Catch:{ Exception -> 0x0068 }
            java.lang.String r4 = "http://"
            r3.append(r4)     // Catch:{ Exception -> 0x0068 }
            r3.append(r6)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x0068 }
            java.net.URI r3 = new java.net.URI     // Catch:{ Exception -> 0x0068 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0068 }
        L_0x0036:
            java.lang.String r3 = r3.getHost()     // Catch:{ Exception -> 0x0068 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0068 }
            if (r4 == 0) goto L_0x0041
            return r2
        L_0x0041:
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x0068 }
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ Exception -> 0x0068 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0068 }
            r4.<init>()     // Catch:{ Exception -> 0x0068 }
            java.lang.String r5 = "."
            r4.append(r5)     // Catch:{ Exception -> 0x0068 }
            r4.append(r1)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0068 }
            boolean r4 = r3.endsWith(r4)     // Catch:{ Exception -> 0x0068 }
            if (r4 != 0) goto L_0x0066
            boolean r1 = r3.equals(r1)     // Catch:{ Exception -> 0x0068 }
            if (r1 == 0) goto L_0x0008
        L_0x0066:
            r6 = 1
            return r6
        L_0x0068:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.afanty.common.utils.CommonUtil.isWhiteUrl(java.lang.String):boolean");
    }
}
