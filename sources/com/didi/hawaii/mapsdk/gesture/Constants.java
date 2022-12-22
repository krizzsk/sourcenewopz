package com.didi.hawaii.mapsdk.gesture;

public final class Constants {
    public static final long DEFAULT_MULTI_TAP_TIME_THRESHOLD = 150;
    public static float DEFAULT_ROTATE_ANGLE_THRESHOLD = 5.4f;
    public static int DEFAULT_SCALE_SPAN_START = 4;
    public static final float DEFAULT_SHOVE_MAX_ANGLE = 20.0f;
    public static final float MAXIMUM_ANGULAR_VELOCITY = 20.0f;
    public static final float MAXIMUM_SCALE_FACTOR_CLAMP = 0.15f;
    public static final float MINIMUM_ANGULAR_ROTATE_VELOCITY = 1.0f;
    public static final float MINIMUM_ANGULAR_VELOCITY = 1.5f;
    public static final float MINIMUM_SCALE_FACTOR_CLAMP = 0.0f;
    public static int MINI_SAPN_SCALE_WHEN_MULTI_MOVE = 300;
    public static int MINI_SAPN_SCALE_WHEN_ROTATE = 4;
    public static final float MIN_FLING_VELOCITY = 512.0f;
    public static float ROTATION_THRESHOLD_INCREASE_WHEN_MULTI_MOVE = 30.8f;
    public static int ROTATION_THRESHOLD_INCREASE_WHEN_SCALING = 24;

    /* renamed from: a */
    static final String f23515a = "mMinSpan";

    /* renamed from: b */
    static final String f23516b = "mSpanSlop";

    /* renamed from: a */
    static void m16786a() {
        DEFAULT_ROTATE_ANGLE_THRESHOLD = 6.8f;
        MINI_SAPN_SCALE_WHEN_ROTATE = 400;
        ROTATION_THRESHOLD_INCREASE_WHEN_SCALING = 160;
    }
}
