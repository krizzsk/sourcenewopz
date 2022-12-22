package com.didi.sdk.util;

public class NewUISwitchUtils {
    public static final int ESTIMATE_NEW_UI_HORIZONTAL = 5;
    public static final int ESTIMATE_NEW_UI_VERTICAL = 6;
    public static final int HOME_NEW_UI_NO_DRAG = 2;
    public static final int HOME_NEW_UI_WITH_DRAG = 1;
    public static final int OLD_UI = 0;
    public static final int TRIP_NEW_UI_A = 7;
    public static final int TRIP_NEW_UI_B = 8;
    public static final int TYPE_NEW_ESTIMATE_AB_H = 0;
    public static final int TYPE_NEW_ESTIMATE_AB_V = 1;

    /* renamed from: a */
    private static final int f37668a = 0;

    /* renamed from: b */
    private static final int f37669b = 1;

    /* renamed from: c */
    private static final int f37670c = 2;

    /* renamed from: d */
    private static final int f37671d = 3;

    /* renamed from: e */
    private static final int f37672e = 4;

    /* renamed from: f */
    private static final int f37673f = 1;

    /* renamed from: g */
    private static final int f37674g = 2;

    /* renamed from: h */
    private static final int f37675h = 3;

    /* renamed from: i */
    private static final String f37676i = "type";

    /* renamed from: j */
    private static final String f37677j = "streetscape";

    /* renamed from: k */
    private static final String f37678k = "flag";

    /* renamed from: a */
    private static int m26720a() {
        return 6;
    }

    public static int getEstimateNewAbStatus() {
        return 1;
    }

    public static int getEstimateNewUIDragStatus() {
        return 6;
    }

    @Deprecated
    public static int getHomeNewUIDragStatus() {
        return 2;
    }

    @Deprecated
    public static boolean isEstimateNewUI() {
        return true;
    }

    @Deprecated
    public static boolean isHomeNewUI() {
        return true;
    }

    public static boolean isNeedShowMapBubbleInConfirm() {
        return false;
    }

    @Deprecated
    public static boolean isRealEstimateNewUI() {
        return true;
    }

    public static boolean isNewUIShowCarInBubblePage() {
        return ((Integer) GlobalApolloUtils.getParamByStatus("EyeBall_Car_Show", "flag", 0, true)).intValue() == 1;
    }

    @Deprecated
    public static int getConfRefreshDistance() {
        return ((Integer) GlobalApolloUtils.getParamByStatus("refresh_product_conf_distance_filter", "mainMenu", 200, true)).intValue();
    }
}
