package com.didi.sdk.global.indexbar.utils;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;

@Deprecated
public class ViewUtil {
    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getTextHeight(TextPaint textPaint, String str) {
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static int getTextWidth(TextPaint textPaint, String str) {
        return (int) textPaint.measureText(str);
    }
}
