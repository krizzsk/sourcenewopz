package com.didiglobal.dittoview.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

public class DittoOmegaUtils {
    public static final String X_PANEL_IMG_DOWNLOAD = "xpanel_img_download";
    public static final String X_PANEL_IMG_DOWNLOAD_RET = "xpanel_img_download_ret";

    /* renamed from: a */
    private static final String f49902a = "DittoOmegaUtils";

    /* renamed from: b */
    private static boolean f49903b = true;

    public static void initXPanelOmega() {
        f49903b = m35999a();
    }

    public static void trackEvent(String str) {
        trackEvent(str, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        if (f49903b) {
            OmegaSDKAdapter.trackEvent(str, map);
        }
    }

    /* renamed from: a */
    private static boolean m35999a() {
        return m36000a("", true);
    }

    /* renamed from: a */
    private static boolean m36000a(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception unused) {
        }
        return z;
    }
}
