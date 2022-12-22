package com.didi.beatles.p099im.views.imageView;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.beatles.p099im.views.IMBezelImageView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.imageView.IMCircleImageView */
public class IMCircleImageView extends IMBezelImageView {
    public IMCircleImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMCircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMaskDrawable(getResources().getDrawable(R.drawable.im_default_circle_mask));
        setBorderDrawable(getResources().getDrawable(R.drawable.im_circle_avatar_border));
    }
}
