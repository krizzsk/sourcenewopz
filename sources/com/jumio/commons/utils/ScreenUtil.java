package com.jumio.commons.utils;

import android.content.Context;
import android.util.TypedValue;

public class ScreenUtil {
    public static float dipToPx(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static int pxToDp(Context context, int i) {
        return (int) (((float) i) / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static float spToPx(Context context, float f) {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static int dpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int pxToDp(Context context, float f) {
        return ((int) f) / (context.getResources().getDisplayMetrics().densityDpi / 160);
    }
}
