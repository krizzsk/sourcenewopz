package com.didi.global.xbanner.utils;

import android.content.Context;
import android.graphics.Color;
import rui.config.RConfigConstants;

public class XBannerUtil {

    /* renamed from: a */
    private static float f22938a = 74.0f;

    /* renamed from: b */
    private static float f22939b = 167.0f;

    /* renamed from: c */
    private static float f22940c;

    /* renamed from: d */
    private static float f22941d;

    public static int getColor(String str) {
        try {
            if (!str.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
                str = RConfigConstants.KEYWORD_COLOR_SIGN + str;
            }
            return Color.parseColor(str);
        } catch (Exception unused) {
            return Color.parseColor("#ffffff");
        }
    }

    public static int getItemWidth(Context context) {
        return DisplayUtils.dip2px(context, 290.0f);
    }

    public static int getItemHeight(Context context) {
        return (int) (((double) getItemWidth(context)) * 0.25d);
    }

    public static int getDefaultItemHeight(Context context) {
        return DisplayUtils.dip2px(context, m16512a());
    }

    public static int getUnfoldItemHeight(Context context) {
        return (int) (((double) getItemWidth(context)) * 0.5d);
    }

    public static int getUnfoldDefaultItemHeight(Context context) {
        return DisplayUtils.dip2px(context, m16513b());
    }

    public static int getFullItemWidth(Context context) {
        return DisplayUtils.getScreenWidth(context);
    }

    public static int getFullItemWidthWithoutMargin(Context context) {
        return DisplayUtils.getScreenWidth(context) - DisplayUtils.dip2px(context, 20.0f);
    }

    /* renamed from: a */
    private static float m16512a() {
        float f = f22940c;
        return f <= 0.0f ? f22938a : f;
    }

    public static void setItemHeight(float f) {
        f22940c = f;
    }

    /* renamed from: b */
    private static float m16513b() {
        float f = f22941d;
        return f <= 0.0f ? f22939b : f;
    }

    public static void setItemUnfoldHeight(float f) {
        f22941d = f;
    }

    public static int px2dpFromServer(int i) {
        return i / 2;
    }
}
