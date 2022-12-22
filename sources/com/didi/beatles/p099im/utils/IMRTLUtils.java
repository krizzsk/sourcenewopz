package com.didi.beatles.p099im.utils;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.utils.IMRTLUtils */
public class IMRTLUtils {
    public static boolean isRTLLayout() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static void setCompoundDrawablesWithIntrinsicBoundsRTL(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (isRTLLayout()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable3, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }
}
