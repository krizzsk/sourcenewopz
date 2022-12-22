package com.didi.entrega.customer.foundation.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.didi.entrega.customer.app.GlobalContext;

public final class ResourceHelper {
    private ResourceHelper() {
    }

    public static String getString(int i) {
        Context context = GlobalContext.getContext();
        if (context == null) {
            return "";
        }
        return context.getString(i);
    }

    public static String getString(int i, Object... objArr) {
        Context context = GlobalContext.getContext();
        if (context == null) {
            return "";
        }
        return context.getString(i, objArr);
    }

    public static String getPlurals(int i, int i2) {
        Context context = GlobalContext.getContext();
        if (context == null) {
            return "";
        }
        return context.getResources().getQuantityString(i, i2, new Object[]{Integer.valueOf(i2)});
    }

    public static int getColor(int i) {
        Context context = GlobalContext.getContext();
        if (context == null) {
            return 0;
        }
        return context.getResources().getColor(i);
    }

    public static int getDimensionPixelSize(int i) {
        Context context = GlobalContext.getContext();
        if (context == null) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(i);
    }

    public static Typeface getFont(int i) {
        if (GlobalContext.getContext() == null) {
            return null;
        }
        try {
            return ResourcesCompat.getFont(GlobalContext.getContext(), i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
