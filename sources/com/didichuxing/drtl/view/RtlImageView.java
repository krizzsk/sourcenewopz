package com.didichuxing.drtl.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.drtl.tookit.DrtlViewExKt;

public class RtlImageView extends ImageView {
    public static final String TAG = "RtlImageView";

    public RtlImageView(Context context) {
        super(context);
    }

    public RtlImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RtlImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public RtlImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        SystemUtils.log(6, TAG, "setImageResource: ", (Throwable) null, "com.didichuxing.drtl.view.RtlImageView", 39);
        setImageDrawable(getDrawable());
    }

    public void setImageDrawable(Drawable drawable) {
        DrtlViewExKt.autoMirrored(drawable);
        super.setImageDrawable(drawable);
        SystemUtils.log(6, TAG, "setImageDrawable: " + drawable, (Throwable) null, "com.didichuxing.drtl.view.RtlImageView", 47);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        SystemUtils.log(6, TAG, "setImageBitmap: ", (Throwable) null, "com.didichuxing.drtl.view.RtlImageView", 53);
    }
}
