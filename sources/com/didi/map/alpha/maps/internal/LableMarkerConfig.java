package com.didi.map.alpha.maps.internal;

public class LableMarkerConfig {

    /* renamed from: a */
    private int f24517a;

    /* renamed from: b */
    private int f24518b;

    /* renamed from: c */
    private String f24519c;

    /* renamed from: d */
    private String f24520d;

    /* renamed from: e */
    private String f24521e;

    /* renamed from: f */
    private String f24522f;

    /* renamed from: g */
    private String f24523g;

    /* renamed from: h */
    private String f24524h;

    /* renamed from: i */
    private int f24525i;

    /* renamed from: j */
    private String f24526j;

    /* renamed from: k */
    private String f24527k;

    /* renamed from: l */
    private String f24528l;

    /* renamed from: m */
    private String f24529m;

    /* renamed from: n */
    private String f24530n;

    /* renamed from: o */
    private String f24531o;

    /* renamed from: p */
    private String f24532p;

    /* renamed from: q */
    private String f24533q;

    /* renamed from: r */
    private String f24534r;

    /* renamed from: s */
    private String f24535s;

    private LableMarkerConfig() {
    }

    public static LableMarkerConfig createMainRouteConfig() {
        LableMarkerConfig lableMarkerConfig = new LableMarkerConfig();
        lableMarkerConfig.f24517a = 18;
        lableMarkerConfig.f24518b = -591112;
        lableMarkerConfig.f24525i = -591112;
        lableMarkerConfig.f24519c = "map/lable_marker.9.png";
        lableMarkerConfig.f24520d = "map/lable_marker3.9.png";
        lableMarkerConfig.f24521e = "map/lable_marker_left.9.png";
        lableMarkerConfig.f24522f = "map/lable_marker_left3.9.png";
        lableMarkerConfig.f24523g = "map/lable_marker_right.9.png";
        lableMarkerConfig.f24524h = "map/lable_marker_right3.9.png";
        lableMarkerConfig.f24526j = "map/lable_marker_night.9.png";
        lableMarkerConfig.f24527k = "map/lable_marker_night3.9.png";
        lableMarkerConfig.f24528l = "map/lable_marker_left_night.9.png";
        lableMarkerConfig.f24529m = "map/lable_marker_left3_night.9.png";
        lableMarkerConfig.f24530n = "map/lable_marker_right_night.9.png";
        lableMarkerConfig.f24531o = "map/lable_marker_right3_night.9.png";
        return lableMarkerConfig;
    }

    public static LableMarkerConfig createOtherRouteConfig() {
        LableMarkerConfig lableMarkerConfig = new LableMarkerConfig();
        lableMarkerConfig.f24517a = 18;
        lableMarkerConfig.f24518b = -8618353;
        lableMarkerConfig.f24525i = -3222558;
        lableMarkerConfig.f24519c = "map/lable_marker_other_day.9.png";
        lableMarkerConfig.f24520d = "map/lable_marker_other_day3.9.png";
        lableMarkerConfig.f24521e = "map/lable_marker_other_left_day.9.png";
        lableMarkerConfig.f24522f = "map/lable_marker_other_left3_day.9.png";
        lableMarkerConfig.f24523g = "map/lable_marker_other_right_day.9.png";
        lableMarkerConfig.f24524h = "map/lable_marker_other_right3_day.9.png";
        lableMarkerConfig.f24526j = "map/lable_marker_other_night.9.png";
        lableMarkerConfig.f24527k = "map/lable_marker_other_night3.9.png";
        lableMarkerConfig.f24528l = "map/lable_marker_other_left_night.9.png";
        lableMarkerConfig.f24529m = "map/lable_marker_other_left3_night.9.png";
        lableMarkerConfig.f24530n = "map/lable_marker_other_right_night.9.png";
        lableMarkerConfig.f24531o = "map/lable_marker_other_right3_night.9.png";
        return lableMarkerConfig;
    }

    public static LableMarkerConfig createDynamicrRouteConfig() {
        LableMarkerConfig lableMarkerConfig = new LableMarkerConfig();
        lableMarkerConfig.f24517a = 18;
        lableMarkerConfig.f24518b = -8618353;
        lableMarkerConfig.f24525i = -3222558;
        lableMarkerConfig.f24519c = "map/lable_marker_other_day.9.png";
        lableMarkerConfig.f24520d = "map/lable_marker_other_day3.9.png";
        lableMarkerConfig.f24521e = "dynamic/multi_lable_marker_other_left_day.9.png";
        lableMarkerConfig.f24522f = "dynamic/multi_lable_marker_other_left3_day.9.png";
        lableMarkerConfig.f24523g = "dynamic/multi_lable_marker_other_right_day.9.png";
        lableMarkerConfig.f24524h = "dynamic/multi_lable_marker_other_right3_day.9.png";
        lableMarkerConfig.f24526j = "map/lable_marker_other_night.9.png";
        lableMarkerConfig.f24527k = "map/lable_marker_other_night3.9.png";
        lableMarkerConfig.f24528l = "dynamic/multi_lable_marker_left_night.9.png";
        lableMarkerConfig.f24529m = "dynamic/multi_lable_marker_left3_night.9.png";
        lableMarkerConfig.f24530n = "dynamic/multi_lable_marker_right_night.9.png";
        lableMarkerConfig.f24531o = "dynamic/multi_lable_marker_right3_night.9.png";
        return lableMarkerConfig;
    }

    public static LableMarkerConfig createIllegalParkConfig() {
        LableMarkerConfig lableMarkerConfig = new LableMarkerConfig();
        lableMarkerConfig.f24517a = 18;
        lableMarkerConfig.f24518b = -8618353;
        lableMarkerConfig.f24525i = -3222558;
        lableMarkerConfig.f24523g = "map/bubble_illegalpark_right.png";
        lableMarkerConfig.f24524h = "map/bubble_illegalpark_right3.png";
        lableMarkerConfig.f24530n = "map/bubble_illegalpark_right.png";
        lableMarkerConfig.f24531o = "map/bubble_illegalpark_right3.png";
        return lableMarkerConfig;
    }

    public int getFontSize() {
        return this.f24517a;
    }

    public int getFontColor() {
        return this.f24518b;
    }

    public String getFileName() {
        return this.f24519c;
    }

    public String getFileName2() {
        return this.f24520d;
    }

    public String getFileNameLeft() {
        return this.f24521e;
    }

    public String getFileNameLeft2() {
        return this.f24522f;
    }

    public String getFileNameRight() {
        return this.f24523g;
    }

    public String getFileNameRight2() {
        return this.f24524h;
    }

    public int getFontColorNight() {
        return this.f24525i;
    }

    public String getFileNameNight() {
        return this.f24526j;
    }

    public String getFileNameNight2() {
        return this.f24527k;
    }

    public String getFileNameLeftNight() {
        return this.f24528l;
    }

    public String getFileNameLeftNight2() {
        return this.f24529m;
    }

    public String getFileNameRightNight() {
        return this.f24530n;
    }

    public String getFileNameRightNight2() {
        return this.f24531o;
    }

    public String getFileNameLt() {
        return this.f24532p;
    }

    public String getFileNameLb() {
        return this.f24533q;
    }

    public String getFileNameRt() {
        return this.f24534r;
    }

    public String getFileNameRb() {
        return this.f24535s;
    }
}
