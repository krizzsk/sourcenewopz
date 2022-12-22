package com.didi.hawaii.mapsdkv2.common.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.didi.hawaii.mapsdkv2.jni.NativeSpeedUp;

public class PointFEvaluator implements TypeEvaluator<PointF> {

    /* renamed from: a */
    private PointF f23798a;

    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float floatEvaluateNative = NativeSpeedUp.floatEvaluateNative(pointF.x, pointF2.x, f);
        float floatEvaluateNative2 = NativeSpeedUp.floatEvaluateNative(pointF.y, pointF2.y, f);
        PointF pointF3 = this.f23798a;
        if (pointF3 != null) {
            pointF3.set(floatEvaluateNative, floatEvaluateNative2);
        } else {
            this.f23798a = new PointF(floatEvaluateNative, floatEvaluateNative2);
        }
        return this.f23798a;
    }
}
