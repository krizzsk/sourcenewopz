package com.didi.map.global.flow.utils;

public class ZIndexUtil {
    public static final int ZINDEX_DRIVER = 70;
    public static final int ZINDEX_DRIVER_END_POINT = 130;
    public static final int ZINDEX_DRIVER_START_POINT = 131;
    public static final int ZINDEX_DRIVING_CAR_BUBBLE = 108;
    public static final int ZINDEX_DRIVING_CAR_POINT = 100;
    public static final int ZINDEX_DRIVING_END_POINT = 104;
    public static final int ZINDEX_DRIVING_OD_POINT = 102;
    public static final int ZINDEX_DRIVING_PASS_POINT = 102;
    public static final int ZINDEX_DRIVING_START_POINT = 106;
    public static final int ZINDEX_END_BUBBLE_POINT = 104;
    public static final int ZINDEX_END_POINT = 100;
    public static final int ZINDEX_GETON_STOP = 84;
    public static final int ZINDEX_LOCATION_ARROW = 99;
    public static final int ZINDEX_LOCATION_AVATAR = 98;
    public static final int ZINDEX_ORDER_END_POINT = 119;
    public static final int ZINDEX_ORDER_LINE = 116;
    public static final int ZINDEX_ORDER_REPLY_CAR = 121;
    public static final int ZINDEX_ORDER_START_POINT = 120;
    public static final int ZINDEX_ORDER_WAYPOINT_POINT = 118;
    public static final int ZINDEX_PAX_END_POINT = 132;
    public static final int ZINDEX_PAX_START_POINT = 133;
    public static final int ZINDEX_SECOND_POINTER_TIP_BUBBLE = 110;
    public static final int ZINDEX_START_BUBBLE_POINT = 106;
    public static final int ZINDEX_START_POINT = 102;
    public static final int ZINDEX_START_POINT_LOADING = 110;
    public static final int ZINDEX_TIPS = 96;
    public static final int ZINDEX_TYPE_CITY_REGION = 10;
    public static final int ZINDEX_TYPE_DEPARTURE_BUBBLE = 3;
    public static final int ZINDEX_TYPE_DEPARTURE_MARK = 4;
    public static final int ZINDEX_TYPE_DRIVER = 7;
    public static final int ZINDEX_TYPE_GRAY_ROUTE = 7;
    public static final int ZINDEX_TYPE_LOCATION_ARROW = 1;
    public static final int ZINDEX_TYPE_LOCATION_AVATAR = 2;
    public static final int ZINDEX_TYPE_RECOMMEND_DEPARTURE = 6;
    public static final int ZINDEX_TYPE_ROUTE = 8;
    public static final int ZINDEX_TYPE_START_END_NAME = 9;
    public static final int ZINDEX_TYPE_START_END_POINT = 5;
    public static final int ZINDEX_WAYPOINT = 90;

    /* renamed from: a */
    private static final int f27289a = 100;

    /* renamed from: b */
    private static final int f27290b = 95;

    /* renamed from: c */
    private static final int f27291c = 95;

    /* renamed from: d */
    private static final int f27292d = 75;

    /* renamed from: e */
    private static final int f27293e = 94;

    /* renamed from: f */
    private static final int f27294f = 65;

    /* renamed from: g */
    private static final int f27295g = 60;

    /* renamed from: h */
    private static final int f27296h = 120;

    /* renamed from: i */
    private static final int f27297i = 30;

    public static int getBiggestAssignedZIndex() {
        return 120;
    }

    public static int getSmallestAssignedZIndex() {
        return 30;
    }

    public static int getZIndex(int i) {
        switch (i) {
            case 1:
                return 99;
            case 2:
                return 98;
            case 3:
                return 100;
            case 4:
            case 5:
                return 95;
            case 6:
                return 75;
            case 7:
                return 70;
            case 8:
                return 65;
            case 9:
                return 94;
            case 10:
                return 60;
            default:
                return 0;
        }
    }
}
