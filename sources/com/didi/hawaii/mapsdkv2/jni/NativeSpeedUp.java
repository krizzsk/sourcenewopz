package com.didi.hawaii.mapsdkv2.jni;

public final class NativeSpeedUp {
    private NativeSpeedUp() {
    }

    public static double doubleEvaluateNative(double d, double d2, float f) {
        return MapEngineJNIBridge.DoubleEvaluateSpeedUp(d, d2, f);
    }

    public static float floatEvaluateNative(float f, float f2, float f3) {
        return MapEngineJNIBridge.FloatEvaluateSpeedUp(f, f2, f3);
    }
}
