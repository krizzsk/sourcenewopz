package com.didichuxing.omega.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.didichuxing.omega.sdk.analysis.AnalysisActivityListener;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;

public class ScreenShotUtil {
    public static String getScreenShot(View view, float f, float f2) {
        if (!OmegaConfig.DEBUG_MODEL) {
            return "";
        }
        Activity activity = null;
        if (view != null) {
            activity = UIAutoTracker.scanForActivity(view.getContext());
        }
        if (activity == null) {
            activity = AnalysisActivityListener.getCurActivity();
        }
        if (activity == null) {
            return "";
        }
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        Bitmap drawingCache = decorView.getDrawingCache();
        if (!(-1.0f == f && -1.0f == f2)) {
            drawRectangles(drawingCache, f, f2);
        }
        String bitMapCompress = UIAutoTracker.bitMapCompress(drawingCache);
        decorView.setDrawingCacheEnabled(false);
        return bitMapCompress;
    }

    private static void drawRectangles(Bitmap bitmap, float f, float f2) {
        if (bitmap != null) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10.0f);
            float width = (float) bitmap.getWidth();
            float height = (float) bitmap.getHeight();
            float dp2px = (float) dp2px(CommonUtil.getContext(), 30.0f);
            float f3 = dp2px / 2.0f;
            float f4 = f - f3;
            float f5 = 0.0f;
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            float f6 = f4 + dp2px > width ? (width - dp2px) - 11.0f : f4;
            float f7 = f6 + dp2px;
            float f8 = f2 - f3;
            if (f8 >= 0.0f) {
                f5 = f8;
            }
            float f9 = f5 + dp2px > height ? (height - dp2px) - 11.0f : f5;
            canvas.drawRect(f6, f9, f7, f9 + dp2px, paint);
        }
    }

    private static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
