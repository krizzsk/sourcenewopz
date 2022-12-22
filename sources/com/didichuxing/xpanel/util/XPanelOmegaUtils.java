package com.didichuxing.xpanel.util;

import com.didichuxing.xpanel.IXPanelOmegaListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.log.MisLogHelper;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class XPanelOmegaUtils {
    public static final String X_PANEL_BUTTON_CK = "xpanel_button_ck";
    public static final String X_PANEL_CARD_ALL_SW = "xpanel_card_all_sw";
    public static final String X_PANEL_CARD_CK = "xpanel_card_ck";
    public static final String X_PANEL_CARD_EFF_CK = "xpanel_card_eff_ck";
    public static final String X_PANEL_CARD_EFF_SW = "xpanel_card_eff_sw";
    public static final String X_PANEL_CARD_SCROLL = "xpanel_card_scroll";
    public static final String X_PANEL_CARD_SW = "xpanel_card_sw";
    public static final String X_PANEL_CARD_SW_TIME = "xpanel_card_sw_time";
    public static final String X_PANEL_CDN_DOWNLOAD = "xpanel_cdn_download";
    public static String X_PANEL_COUNTRY = "";
    public static final String X_PANEL_IMG_DOWNLOAD = "xpanel_img_download";
    public static final String X_PANEL_IMG_DOWNLOAD_RET = "xpanel_img_download_ret";
    public static final String X_PANEL_PULL_UP = "xpanel_pull_up";
    public static final String X_PANEL_SHOW = "xpanel_sw";
    public static final String X_PANEL_SHOW_TIME = "xpanel_sw_time";
    public static final String X_PANEL_SUBCARD_SW = "xpanel_subcard_sw";
    public static final String X_PANEL_SUBCARD_SW_TIME = "xpanel_subcard_sw_time";
    public static final String X_PANEL_SUB_CLICK = "xpanel_subcard_ck";
    public static final String X_PANEL_TRY_PULL_DOWN = "xpanel_try_pull_down";
    public static final String X_PANEL_WEEX_RENDER = "xpanel_weex_render";
    public static final String X_PANEL_XML_CACHE = "xpanel_xml_cache";

    /* renamed from: a */
    private static final String f49593a = "XPanelOmegaUtils";

    /* renamed from: b */
    private static boolean f49594b = true;

    /* renamed from: c */
    private static IXPanelOmegaListener f49595c;

    public static void initXPanelOmega() {
        f49594b = XPanelApolloUtil.isXPanelOmegaEnable();
    }

    public static void trackEvent(String str) {
        trackEvent(str, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        if (f49594b) {
            IXPanelOmegaListener iXPanelOmegaListener = f49595c;
            if (iXPanelOmegaListener != null) {
                HashMap<String, Object> commonParams = iXPanelOmegaListener.getCommonParams();
                if (map == null) {
                    map = commonParams;
                } else if (commonParams != null) {
                    map.putAll(commonParams);
                }
            }
            if (shouldTrack(str, map)) {
                MisLogHelper.misCardLog(str, map);
                OmegaSDKAdapter.trackEvent(str, map);
            }
        }
    }

    public static void initXPanelOmegaUtil(IXPanelOmegaListener iXPanelOmegaListener) {
        if (f49595c == null) {
            f49595c = iXPanelOmegaListener;
        }
    }

    public static int getCardIdByObject(XPanelCardData xPanelCardData) {
        IXPanelOmegaListener iXPanelOmegaListener = f49595c;
        if (iXPanelOmegaListener != null) {
            return iXPanelOmegaListener.getCardIdByObject(xPanelCardData);
        }
        return -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean shouldTrack(java.lang.String r3, java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            int r0 = r3.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1747007670: goto L_0x0057;
                case -1623722846: goto L_0x004c;
                case -1186313404: goto L_0x0041;
                case -1186312896: goto L_0x0036;
                case 633469598: goto L_0x002b;
                case 742266330: goto L_0x0020;
                case 1140676521: goto L_0x0015;
                case 1556416108: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0062
        L_0x000a:
            java.lang.String r0 = "xpanel_card_sw_time"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0062
            r3 = 2
            goto L_0x0063
        L_0x0015:
            java.lang.String r0 = "xpanel_card_scroll"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0062
            r3 = 5
            goto L_0x0063
        L_0x0020:
            java.lang.String r0 = "xpanel_card_eff_sw"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0062
            r3 = 1
            goto L_0x0063
        L_0x002b:
            java.lang.String r0 = "xpanel_card_all_sw"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0062
            r3 = 7
            goto L_0x0063
        L_0x0036:
            java.lang.String r0 = "xpanel_card_sw"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0062
            r3 = 0
            goto L_0x0063
        L_0x0041:
            java.lang.String r0 = "xpanel_card_ck"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0062
            r3 = 3
            goto L_0x0063
        L_0x004c:
            java.lang.String r0 = "xpanel_button_ck"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0062
            r3 = 4
            goto L_0x0063
        L_0x0057:
            java.lang.String r0 = "xpanel_subcard_ck"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0062
            r3 = 6
            goto L_0x0063
        L_0x0062:
            r3 = -1
        L_0x0063:
            switch(r3) {
                case 0: goto L_0x0067;
                case 1: goto L_0x0067;
                case 2: goto L_0x0067;
                case 3: goto L_0x0067;
                case 4: goto L_0x0067;
                case 5: goto L_0x0067;
                case 6: goto L_0x0067;
                case 7: goto L_0x0067;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x0079
        L_0x0067:
            if (r4 != 0) goto L_0x006a
            return r2
        L_0x006a:
            java.lang.String r3 = "card_id"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0079
            r1 = 0
        L_0x0079:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.util.XPanelOmegaUtils.shouldTrack(java.lang.String, java.util.Map):boolean");
    }

    public static Object getVaule(Map<String, Object> map, String str) {
        return (map == null || map.get(str) == null) ? "null" : map.get(str);
    }
}
