package com.didi.sdk.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.sdk.webview.a */
/* compiled from: H5DeeplinkSaferyInterceptor */
class C13312a {
    /* renamed from: a */
    private static String m27185a() {
        return "https://page.didiglobal.com/global/silver-bullet-online/intercept-page-warn";
    }

    C13312a() {
    }

    /* renamed from: a */
    static String m27187a(String str, String str2) {
        if (m27193c(str2)) {
            m27188a(str, 2);
            if (m27196e()) {
                return m27185a();
            }
            return "";
        } else if (m27190b(str2)) {
            m27188a(str, 0);
            return "";
        } else {
            m27188a(str, 1);
            if (m27195d()) {
                return m27186a(str2);
            }
            return "";
        }
    }

    /* renamed from: a */
    private static String m27186a(String str) {
        Uri.Builder buildUpon = Uri.parse("https://page.didiglobal.com/global/silver-bullet-online/intercept-page-info").buildUpon();
        buildUpon.appendQueryParameter("deeplink_weburl", str);
        return buildUpon.build().toString();
    }

    /* renamed from: b */
    private static boolean m27190b(String str) {
        String[] b;
        if (str == null || (b = m27191b()) == null || b.length == 0) {
            return true;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        String lowerCase = host.toLowerCase();
        for (String equals : b) {
            if (lowerCase.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m27193c(String str) {
        String[] c;
        if (!(str == null || (c = m27194c()) == null || c.length == 0)) {
            String host = Uri.parse(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            String lowerCase = host.toLowerCase();
            for (String equals : c) {
                if (lowerCase.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m27189a(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        for (String equals : strArr) {
            if (host.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static String[] m27191b() {
        return m27192b("whitelist", "");
    }

    /* renamed from: c */
    private static String[] m27194c() {
        return m27192b("blacklist", "");
    }

    /* renamed from: b */
    private static String[] m27192b(String str, String str2) {
        String str3 = (String) Apollo.getToggle("deep_link_web_white_black_list").getExperiment().getParam(str, str2);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        return str3.split(",");
    }

    /* renamed from: d */
    private static boolean m27195d() {
        if (((Integer) Apollo.getToggle("deep_link_web_white_black_list").getExperiment().getParam("show_hint_page", 0)).intValue() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private static boolean m27196e() {
        if (((Integer) Apollo.getToggle("deep_link_web_white_black_list").getExperiment().getParam("show_block_page", 0)).intValue() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m27188a(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("hit_list_type", Integer.valueOf(i));
        hashMap.put("show_hint_page", Boolean.valueOf(m27195d()));
        hashMap.put("show_block_page", Boolean.valueOf(m27196e()));
        OmegaSDKAdapter.trackEvent("ibt_deeplink_web_safety_intercept_sw", (Map<String, Object>) hashMap);
    }
}
