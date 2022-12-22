package com.didi.soda.customer.widget.goodsV2;

import android.graphics.PointF;

public final class BezierCurve {
    private BezierCurve() {
    }

    public static PointF bezier(float f, PointF pointF, PointF pointF2, PointF pointF3) {
        float f2 = 1.0f - f;
        PointF pointF4 = new PointF();
        float f3 = f2 * f2;
        float f4 = 2.0f * f * f2;
        float f5 = f * f;
        pointF4.x = (pointF.x * f3) + (pointF2.x * f4) + (pointF3.x * f5);
        pointF4.y = (f3 * pointF.y) + (f4 * pointF2.y) + (f5 * pointF3.y);
        return pointF4;
    }

    public static PointF bezier(float f, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        float f2 = 1.0f - f;
        PointF pointF5 = new PointF();
        float f3 = f2 * f2 * f2;
        float f4 = 3.0f * f2;
        float f5 = f2 * f4 * f;
        float f6 = f4 * f * f;
        float f7 = f * f * f;
        pointF5.x = (pointF.x * f3) + (pointF2.x * f5) + (pointF3.x * f6) + (pointF4.x * f7);
        pointF5.y = (f3 * pointF.y) + (f5 * pointF2.y) + (f6 * pointF3.y) + (f7 * pointF4.y);
        return pointF5;
    }
}
