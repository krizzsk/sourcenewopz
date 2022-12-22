package com.didi.soda.customer.biz.helper;

import android.graphics.PointF;
import android.view.View;

public final class PointHelper {
    private PointHelper() {
    }

    public static PointF getPointF(View view) {
        if (view == null) {
            return new PointF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new PointF((float) iArr[0], (float) iArr[1]);
    }
}
