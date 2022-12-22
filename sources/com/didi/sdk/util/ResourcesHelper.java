package com.didi.sdk.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public class ResourcesHelper {
    public static int getColor(Context context, int i) {
        return context.getResources().getColor(i);
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        return context.getResources().getColorStateList(i);
    }

    public static String getString(Context context, int i) {
        return context.getResources().getString(i);
    }

    public static String getString(Context context, int i, int i2, int i3) {
        return context.getResources().getString(i, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static String getString(Context context, int i, String str) {
        return context.getResources().getString(i, new Object[]{str});
    }

    public static String[] getStringArray(Context context, int i) {
        return context.getResources().getStringArray(i);
    }

    public static Drawable getDrawable(Context context, int i) {
        return context.getResources().getDrawable(i);
    }

    public static float getDimension(Context context, int i) {
        return context.getResources().getDimension(i);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int getDisplayMetrics(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int getDimensionPixelSize(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int getInteger(Context context, int i) {
        return context.getResources().getInteger(i);
    }

    public static XmlResourceParser getXml(Context context, int i) {
        return context.getResources().getXml(i);
    }

    public static Configuration getConfiguration(Context context) {
        return context.getResources().getConfiguration();
    }

    public static int[] getIntArray(Context context, int i) {
        return context.getResources().getIntArray(i);
    }
}
