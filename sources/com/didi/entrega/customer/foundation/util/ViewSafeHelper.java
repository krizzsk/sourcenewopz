package com.didi.entrega.customer.foundation.util;

import android.view.View;
import android.view.ViewGroup;

public final class ViewSafeHelper {
    public static boolean safeAddView(ViewGroup viewGroup, View view) {
        return safeAddView(viewGroup, view, (ViewGroup.LayoutParams) null);
    }

    public static boolean safeAddView(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null || viewGroup.indexOfChild(view) != -1) {
            return false;
        }
        if (view.getParent() != null) {
            safeRemoveView((ViewGroup) view.getParent(), view);
        }
        if (layoutParams == null) {
            viewGroup.addView(view);
            return true;
        }
        viewGroup.addView(view, layoutParams);
        return true;
    }

    public static boolean safeRemoveView(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || viewGroup.indexOfChild(view) == -1) {
            return false;
        }
        viewGroup.removeView(view);
        return true;
    }

    public static int safeIndexOfView(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return -1;
        }
        return viewGroup.indexOfChild(view);
    }
}
