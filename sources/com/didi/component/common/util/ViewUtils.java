package com.didi.component.common.util;

import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.TextView;
import com.didi.component.core.PresenterGroup;
import java.lang.reflect.Field;

public class ViewUtils {
    public static boolean isAccessibilityFocus(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isAccessibilityFocused();
        }
        try {
            Field declaredField = View.class.getClass().getDeclaredField("mPrivateFlags2");
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(view)).intValue();
            declaredField.setAccessible(false);
            if ((intValue & View.STATUS_BAR_TRANSIENT) != 0) {
                return true;
            }
            return false;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static View findViewById(PresenterGroup presenterGroup, int i) {
        if (presenterGroup == null || presenterGroup.getView() == null || presenterGroup.getView().getView() == null) {
            return null;
        }
        return presenterGroup.getView().getView().findViewById(i);
    }

    public static void expandViewTouchDelegate(View view, int i, int i2, int i3, int i4) {
        final View view2 = view;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        ((View) view.getParent()).post(new Runnable() {
            public void run() {
                Rect rect = new Rect();
                View.this.setEnabled(true);
                View.this.getHitRect(rect);
                rect.top -= i5;
                rect.bottom += i6;
                rect.left -= i7;
                rect.right += i8;
                TouchDelegate touchDelegate = new TouchDelegate(rect, View.this);
                if (View.class.isInstance(View.this.getParent())) {
                    ((View) View.this.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    public static void setText(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    public static void setText(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }
}
