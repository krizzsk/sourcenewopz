package com.didi.sdk.apm.canvas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;

public class CanvasHelper {

    /* renamed from: a */
    private static final String f34989a = "CanvasHelper";

    public static int saveLayer(Canvas canvas, RectF rectF, Paint paint, int i) {
        if (Build.VERSION.SDK_INT < 28 || i == 31) {
            return canvas.saveLayer(rectF, paint, i);
        }
        Log.d(f34989a, "# current saveFlags is :" + i + ",after the replacement is ALL_SAVE_FLAG!");
        return canvas.saveLayer(rectF, paint);
    }
}
