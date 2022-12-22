package com.didi.component.mapflow.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class CustomLottieAnimationView extends LottieAnimationView {

    /* renamed from: b */
    private static final float f14197b = 0.45f;

    /* renamed from: a */
    private final Logger f14198a = LoggerFactory.getLogger(getClass());

    public CustomLottieAnimationView(Context context) {
        super(context);
    }

    public CustomLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        Logger logger = this.f14198a;
        logger.info("lmf>>onMeasure>>widthSpecSize>>" + size + ":", new Object[0]);
        if (size > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * f14197b), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
