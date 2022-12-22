package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.didi.beatles.p099im.utils.view.IMCmViewUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IMCmViewUtil.class})
/* renamed from: com.didi.beatles.im.utils.IMViewUtilImpl */
public class IMViewUtilImpl implements IMCmViewUtil {
    public void setBackgroundCompat(View view, Drawable drawable) {
        IMViewUtil.setBackgroundCompat(view, drawable);
    }

    public int dp2px(Context context, float f) {
        return IMViewUtil.dp2px(context, f);
    }
}
