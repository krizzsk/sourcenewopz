package com.didichuxing.publicservice.resourcecontrol.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public class AssetResourcesHelper {
    public static Context appContext = ResourceManager.getManager().getApplication();

    public static Resources getResources() {
        Context context = appContext;
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getResources();
    }

    public static int getColor(int i) {
        Context context = appContext;
        if (context == null) {
            return 0;
        }
        return context.getApplicationContext().getResources().getColor(i);
    }

    public static ColorStateList getColorStateList(int i) {
        Context context = appContext;
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getResources().getColorStateList(i);
    }

    public static String getString(int i) {
        Context context = appContext;
        if (context == null) {
            return "";
        }
        return context.getApplicationContext().getResources().getString(i);
    }

    public static String getString(int i, int i2, int i3) {
        Context context = appContext;
        if (context == null) {
            return "";
        }
        return context.getApplicationContext().getResources().getString(i, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static String getString(int i, String str) {
        Context context = appContext;
        if (context == null) {
            return "";
        }
        return context.getApplicationContext().getResources().getString(i, new Object[]{str});
    }

    public static String[] getStringArray(int i) {
        Context context = appContext;
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getResources().getStringArray(i);
    }

    public static Drawable getDrawable(int i) {
        Context context = appContext;
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getResources().getDrawable(i);
    }

    public static float getDimension(int i) {
        Context context = appContext;
        if (context == null) {
            return 0.0f;
        }
        return context.getApplicationContext().getResources().getDimension(i);
    }

    public static DisplayMetrics getDisplayMetrics() {
        Context context = appContext;
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getResources().getDisplayMetrics();
    }

    public static int getDisplayMetrics(int i) {
        Context context = appContext;
        if (context == null) {
            return 0;
        }
        return context.getApplicationContext().getResources().getDimensionPixelSize(i);
    }

    public static int getDimensionPixelSize(int i) {
        Context context = appContext;
        if (context == null) {
            return 0;
        }
        return context.getApplicationContext().getResources().getDimensionPixelSize(i);
    }

    public static int getInteger(int i) {
        Context context = appContext;
        if (context == null) {
            return 0;
        }
        return context.getApplicationContext().getResources().getInteger(i);
    }

    public static XmlResourceParser getXml(int i) {
        Context context = appContext;
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getResources().getXml(i);
    }

    public static Configuration getConfiguration() {
        Context context = appContext;
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getResources().getConfiguration();
    }
}
