package com.didi.map.global.component.departure.wheel.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collection;

public class WheelUtils {
    public static <V> boolean isEmpty(Collection<V> collection) {
        return collection == null || collection.size() == 0;
    }

    public static TextView findTextView(View view) {
        if (view instanceof TextView) {
            return (TextView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return null;
            }
            TextView findTextView = findTextView(viewGroup.getChildAt(i));
            if (findTextView != null) {
                return findTextView;
            }
            i++;
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
