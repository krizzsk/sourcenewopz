package com.didi.beatles.p099im.picture.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.TextView;

/* renamed from: com.didi.beatles.im.picture.utils.IMStringUtils */
public class IMStringUtils {
    public static boolean isCamera(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("相机胶卷")) || str.startsWith("CameraRoll") || str.startsWith("所有音频") || str.startsWith("All audio");
    }

    public static void modifyTextViewDrawable(TextView textView, Drawable drawable, int i) {
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        if (i == 0) {
            textView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (i == 1) {
            textView.setCompoundDrawables((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (i == 2) {
            textView.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            textView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        }
    }
}
