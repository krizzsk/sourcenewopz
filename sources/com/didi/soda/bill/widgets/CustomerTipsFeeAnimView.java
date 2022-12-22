package com.didi.soda.bill.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

public class CustomerTipsFeeAnimView extends LottieAnimationView {
    public CustomerTipsFeeAnimView(Context context) {
        super(context);
    }

    public CustomerTipsFeeAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerTipsFeeAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimation();
        setImageDrawable((Drawable) null);
    }
}
