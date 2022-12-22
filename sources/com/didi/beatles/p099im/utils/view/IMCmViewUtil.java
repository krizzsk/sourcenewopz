package com.didi.beatles.p099im.utils.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: com.didi.beatles.im.utils.view.IMCmViewUtil */
public interface IMCmViewUtil {
    public static final IMCmViewUtil empty = new IMCmViewUtil() {
        public int dp2px(Context context, float f) {
            return 0;
        }

        public void setBackgroundCompat(View view, Drawable drawable) {
        }
    };

    int dp2px(Context context, float f);

    void setBackgroundCompat(View view, Drawable drawable);
}
