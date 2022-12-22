package com.didi.rfusion.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.didi.rfusion.RFusion;

public final class RFResUtils {
    private RFResUtils() {
        throw new UnsupportedOperationException("can't instantiate this class");
    }

    public static Resources getResources() {
        return RFusion.getContext().getResources();
    }

    public static String getString(int i) {
        try {
            return getResources().getString(i);
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    public static String getString(Context context, int i) {
        try {
            return context.getResources().getString(i);
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    public static Drawable getDrawable(int i) {
        try {
            return ContextCompat.getDrawable(RFusion.getContext(), i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Drawable getDrawable(Context context, int i) {
        try {
            return ContextCompat.getDrawable(context, i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static float getDimens(int i) {
        try {
            return getResources().getDimension(i);
        } catch (Resources.NotFoundException unused) {
            return 0.0f;
        }
    }

    public static float getDimens(Context context, int i) {
        try {
            return context.getResources().getDimension(i);
        } catch (Resources.NotFoundException unused) {
            return 0.0f;
        }
    }

    public static int getDimensionPixelSize(int i) {
        try {
            return getResources().getDimensionPixelOffset(i);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getDimensionPixelSize(Context context, int i) {
        try {
            return context.getResources().getDimensionPixelOffset(i);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getColor(int i) {
        try {
            return ContextCompat.getColor(RFusion.getContext(), i);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getColor(Context context, int i) {
        try {
            return ContextCompat.getColor(context, i);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getAttrColor(int i) {
        TypedValue typedValue = new TypedValue();
        RFusion.getContext().getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    public static int getAttrColor(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    public static ColorStateList getColorStateList(int i) {
        try {
            return ContextCompat.getColorStateList(RFusion.getContext(), i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        try {
            return ContextCompat.getColorStateList(context, i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Typeface getFont(int i) {
        try {
            return ResourcesCompat.getFont(RFusion.getContext(), i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static Typeface getFont(Context context, int i) {
        try {
            return ResourcesCompat.getFont(context, i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
