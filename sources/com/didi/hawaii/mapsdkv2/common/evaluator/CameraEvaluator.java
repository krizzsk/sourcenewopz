package com.didi.hawaii.mapsdkv2.common.evaluator;

import android.animation.TypeEvaluator;
import com.didi.hawaii.mapsdkv2.core.Camera;
import com.didi.hawaii.mapsdkv2.jni.NativeSpeedUp;
import com.didi.map.outer.model.LatLng;

public final class CameraEvaluator implements TypeEvaluator<Camera> {

    /* renamed from: a */
    private Camera f23793a;

    /* renamed from: b */
    private final LatLngEvaluator f23794b = new LatLngEvaluator();

    /* renamed from: c */
    private final AngleEvaluator f23795c = AngleEvaluator.INSTANCE;

    /* renamed from: d */
    private boolean f23796d = false;

    public CameraEvaluator() {
    }

    public CameraEvaluator(boolean z) {
        this.f23796d = z;
    }

    public Camera evaluate(float f, Camera camera, Camera camera2) {
        LatLng center = camera2.getCenter();
        if (!this.f23796d) {
            center = this.f23794b.evaluate(f, camera.getCenter(), camera2.getCenter());
        }
        float floatEvaluateNative = NativeSpeedUp.floatEvaluateNative(camera.getScale(), camera2.getScale(), f);
        float rotate = camera2.getRotate();
        if (!this.f23796d) {
            rotate = this.f23795c.evaluate(f, (Number) Float.valueOf(camera.getRotate()), (Number) Float.valueOf(camera2.getRotate())).floatValue();
        }
        float floatEvaluateNative2 = NativeSpeedUp.floatEvaluateNative(camera.getSkew(), camera2.getSkew(), f);
        Camera camera3 = this.f23793a;
        if (camera3 != null) {
            camera3.set(center, floatEvaluateNative, rotate, floatEvaluateNative2);
        } else {
            this.f23793a = new Camera(center, floatEvaluateNative, rotate, floatEvaluateNative2);
        }
        return this.f23793a;
    }
}
