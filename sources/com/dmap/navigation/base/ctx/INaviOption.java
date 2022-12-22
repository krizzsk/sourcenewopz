package com.dmap.navigation.base.ctx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface INaviOption {
    public static final int NAVI_MODE_FULL = 1;
    public static final int NAVI_MODE_LIGHT = 0;
    public static final int PASS_MODE_AUTO = 0;
    public static final int PASS_MODE_MANUAL = 1;
    public static final int SCENE_NORMAL = 9;
    public static final int SCENE_NORMAL_HEAT = 9001;
    public static final int SCENE_NORMAL_MARKET = 9002;
    public static final int SCENE_NORMAL_NONE = 9000;
    public static final int SCENE_NORMAL_NORMAL = 9006;
    public static final int SCENE_NORMAL_NORMAL_PSG = 9007;
    public static final int SCENE_NORMAL_NORMAL_RAPID_PSG = 9008;
    public static final int SCENE_NORMAL_ORDERCARD = 9003;
    public static final int SCENE_NORMAL_TOHOTAREA = 9004;
    public static final int SCENE_NORMAL_X = 9005;

    public interface INaviRouteStrategy {
        boolean getAcceptCharge();

        boolean getAutoRecommend();

        boolean getAvoidCharge();

        boolean getAvoidJam();

        boolean getAvoidRestrict();

        boolean getHighwayFirst();

        boolean getRapidArrival();

        boolean getRejectCharge();

        boolean getTimeFirst();

        void setAcceptCharge(boolean z);

        void setAutoRecommend(boolean z);

        void setAvoidCharge(boolean z);

        void setAvoidJam(boolean z);

        void setAvoidRestrict(boolean z);

        void setHighwayFirst(boolean z);

        void setRapidArrival(boolean z);

        void setRejectCharge(boolean z);

        void setTimeFirst(boolean z);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NaviMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PassMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scene {
    }

    int getConfidenceHigh();

    int getConfidenceLow();

    float getMainRouteLineWidth();

    int getNaviLocLevel();

    int getNaviMode();

    INaviRouteStrategy getNaviRouteStrategy();

    int getPassNavMode();

    int getScene();

    int getVehicleZIndex();

    boolean isGuideLineEnable();

    boolean isKeepTrafficEvent();

    boolean isLaneHovGrayEnable();

    boolean isMainRouteBubbleVisible();

    boolean isMainRouteVisible();

    boolean isMandatory();

    void setConfidenceHigh(int i);

    void setConfidenceLow(int i);

    void setDispatchId(String str);

    void setDispatchType(int i);

    void setDynamicRouteEnable(boolean z);

    void setGuideLineEnable(boolean z);

    void setKeepTrafficEvent(boolean z);

    void setLaneHovGrayEnable(boolean z);

    void setLanguage(int i);

    void setMainRouteBubbleVisible(boolean z);

    void setMainRouteLineWidth(float f);

    void setMainRouteVisible(boolean z);

    void setMultiRouteEnable(boolean z);

    void setNaviLocLevel(int i);

    void setPassNavMode(int i);

    void setRestrictToastEnable(boolean z);

    void setScene(int i);

    void setVehicleZIndex(int i);
}
