package com.didichuxing.diface.biz.bioassay.fpp.util;

import android.content.Context;
import android.util.DisplayMetrics;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;

public class Screen {
    public static float LEFTMENU_UI_PERCENT = 0.15f;

    /* renamed from: a */
    private static final int f47239a = 30;

    /* renamed from: b */
    private static final int f47240b = 30;

    /* renamed from: c */
    private static final int f47241c = 50;
    public static float charHeight = 0.0f;

    /* renamed from: d */
    private static final int f47242d = 40;
    public static float density;
    public static float densityDpi;
    public static float drawHeight;
    public static float drawPaddingBottom;
    public static float drawPaddingLeft;
    public static float drawPaddingRight;
    public static float drawPaddingTop;
    public static int drawRows;
    public static float drawWidth;
    public static float lineHeight;
    public static float line_space;
    public static int mHeight;
    public static int mNotificationBarHeight;
    public static int mScreenHeight;
    public static int mScreenWidth;
    public static int mWidth;

    public static void initialize(Context context) {
        if (drawWidth == 0.0f || drawHeight == 0.0f || mWidth == 0 || mHeight == 0 || density == 0.0f) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f = displayMetrics.density;
            density = f;
            mNotificationBarHeight = (int) (f * 35.0f);
            mWidth = displayMetrics.widthPixels;
            mHeight = displayMetrics.heightPixels;
            mScreenWidth = displayMetrics.widthPixels;
            mScreenHeight = displayMetrics.heightPixels;
            densityDpi = (float) displayMetrics.densityDpi;
            float f2 = density;
            float f3 = f2 * 30.0f;
            drawPaddingLeft = f3;
            float f4 = 30.0f * f2;
            drawPaddingRight = f4;
            float f5 = 50.0f * f2;
            drawPaddingTop = f5;
            float f6 = f2 * 40.0f;
            drawPaddingBottom = f6;
            drawWidth = (((float) mWidth) - f3) - f4;
            drawHeight = (((float) mHeight) - f5) - f6;
        }
    }

    public static String clipImageUrl(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                return str;
            }
            if (str.endsWith(".jpg") || str.endsWith(IMPictureMimeType.PNG) || str.endsWith(".gif") || str.endsWith(".bmp")) {
                String substring = str.substring(str.length() - 4, str.length());
                int lastIndexOf = str.lastIndexOf(".");
                int lastIndexOf2 = str.lastIndexOf("/");
                if (lastIndexOf2 != -1) {
                    int i = lastIndexOf2 + 1;
                    String substring2 = str.substring(i, lastIndexOf);
                    if (substring2.endsWith("_m") || substring2.endsWith("_b") || substring2.endsWith("_s")) {
                        String substring3 = substring2.substring(0, substring2.length() - 2);
                        return str.substring(0, i) + substring3 + str2 + substring;
                    }
                    return str.substring(0, i) + substring2 + str2 + substring;
                }
            }
        }
        return null;
    }
}
