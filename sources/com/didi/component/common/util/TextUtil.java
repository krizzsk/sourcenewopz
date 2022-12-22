package com.didi.component.common.util;

import android.content.Context;
import android.widget.TextView;

public class TextUtil {
    public static int getTextWidth(Context context, String str, float f) {
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextSize(f);
        textView.measure(0, 0);
        return textView.getMeasuredWidth();
    }
}
