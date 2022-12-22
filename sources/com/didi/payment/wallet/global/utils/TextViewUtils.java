package com.didi.payment.wallet.global.utils;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.didichuxing.dfbasesdk.utils.ResUtils;

public class TextViewUtils {
    public static void setText(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    public static void appendDrawableLast(TextView textView, String str, int i) {
        Drawable drawable = ResUtils.getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(str + " ");
        spannableString.setSpan(imageSpan, spannableString.toString().length() + -1, spannableString.toString().length(), 33);
        textView.append(spannableString);
    }
}
