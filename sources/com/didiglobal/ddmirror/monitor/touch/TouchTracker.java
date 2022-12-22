package com.didiglobal.ddmirror.monitor.touch;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;

public class TouchTracker {
    private static Field sTouchTargetChildField;
    private static Field sTouchTargetField;

    public static View findTargetView(ViewGroup viewGroup, int[] iArr) {
        View view = null;
        if (ensureTargetField() && viewGroup != null) {
            View targetView = getTargetView(viewGroup);
            while (true) {
                View targetView2 = targetView instanceof ViewGroup ? getTargetView((ViewGroup) targetView) : null;
                if (targetView2 == null) {
                    break;
                }
                targetView = targetView2;
            }
            view = targetView;
        }
        return iArr != null ? filterView(view, iArr) : view;
    }

    private static boolean ensureTargetField() {
        if (sTouchTargetField == null) {
            try {
                Class<?> cls = Class.forName("android.view.ViewGroup");
                if (cls != null) {
                    Field declaredField = cls.getDeclaredField("mFirstTouchTarget");
                    sTouchTargetField = declaredField;
                    declaredField.setAccessible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (sTouchTargetField != null) {
                    Field declaredField2 = sTouchTargetField.getType().getDeclaredField("child");
                    sTouchTargetChildField = declaredField2;
                    declaredField2.setAccessible(true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (sTouchTargetField == null || sTouchTargetChildField == null) {
            return false;
        }
        return true;
    }

    private static View getTargetView(ViewGroup viewGroup) {
        try {
            Object obj = sTouchTargetField.get(viewGroup);
            if (obj == null) {
                return null;
            }
            Object obj2 = sTouchTargetChildField.get(obj);
            if (obj2 instanceof View) {
                return (View) obj2;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static View filterView(View view, int[] iArr) {
        if ((view instanceof AbsListView) || (view instanceof RecyclerView)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                Rect rect = new Rect();
                childAt.getGlobalVisibleRect(rect);
                if (rect.contains(iArr[0], iArr[1])) {
                    return childAt;
                }
            }
        } else if ((view instanceof ScrollView) || (view instanceof HorizontalScrollView)) {
            return null;
        }
        return view;
    }
}
