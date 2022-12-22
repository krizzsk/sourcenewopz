package com.didi.hawaii.mapsdkv2.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Constant {
    public static final int ANIMATE_MODE = 3;
    public static final int BUS = 1;
    public static final int CAR_FOLLOW_MODE = 2;
    public static final int CAR_NORMAL_MODE = 0;
    public static final int CAR_UP_FOLLOW_MODE = 1;

    /* renamed from: CN */
    public static final int f23806CN = 0;
    public static final int DEFAULT = 0;

    /* renamed from: EN */
    public static final int f23807EN = 1;

    /* renamed from: ES */
    public static final int f23808ES = 4;
    public static final int FPS_10 = 6;
    public static final int FPS_30 = 2;
    public static final int FPS_60 = 1;
    public static final int GESTURE_MODE = 1;
    public static final int MAP_MODE_JAMGRAY = 5;
    public static final int MAP_MODE_NAVIGATION = 3;
    public static final int MAP_MODE_NAVIGATION_HAWK_EYE = 10;
    public static final int MAP_MODE_NAVIGATION_JAMGRAY = 7;
    public static final int MAP_MODE_NAVIGATION_NIGHT = 9;
    public static final int MAP_MODE_NAVIGATION_NIGHT_TRAFFIC = 11;
    public static final int MAP_MODE_NAVIGATION_TRAFFIC = 8;
    public static final int MAP_MODE_NORMAL = 1;
    public static final int MAP_MODE_SAT = 2;
    public static final int MAP_MODE_SUBWAY = 4;
    public static final int MAP_MODE_TRAFFIC = 6;
    public static final int MAP_VERSION_2D = 4;
    public static final int MAP_VERSION_3D = 3;

    /* renamed from: PT */
    public static final int f23809PT = 3;

    /* renamed from: TW */
    public static final int f23810TW = 2;
    public static final int UNRESTRICTED_MODE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Fps {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FpsMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapLanguage {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapTheme {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapVersion {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NaviMode {
    }

    private Constant() {
    }
}
