package com.didi.hawaii.mapsdkv2.common;

public class MapTransform {
    public static float normalizeRotate(float f) {
        float f2 = f % 360.0f;
        return f2 < 0.0f ? f2 + 360.0f : f2;
    }
}
