package com.didi.nova.assembly.p127ui.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.nova.assembly.p127ui.shimmer.ShimmerViewHelper;

/* renamed from: com.didi.nova.assembly.ui.shimmer.ShimmerTextView */
public class ShimmerTextView extends TextView implements ShimmerViewBase {

    /* renamed from: a */
    private ShimmerViewHelper f29307a;

    public ShimmerTextView(Context context) {
        super(context);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), (AttributeSet) null);
        this.f29307a = shimmerViewHelper;
        shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f29307a = shimmerViewHelper;
        shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f29307a = shimmerViewHelper;
        shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
    }

    public float getGradientX() {
        return this.f29307a.getGradientX();
    }

    public void setGradientX(float f) {
        this.f29307a.setGradientX(f);
    }

    public boolean isShimmering() {
        return this.f29307a.isShimmering();
    }

    public void setShimmering(boolean z) {
        this.f29307a.setShimmering(z);
    }

    public boolean isSetUp() {
        return this.f29307a.isSetUp();
    }

    public void setAnimationSetupCallback(ShimmerViewHelper.AnimationSetupCallback animationSetupCallback) {
        this.f29307a.setAnimationSetupCallback(animationSetupCallback);
    }

    public int getPrimaryColor() {
        return this.f29307a.getPrimaryColor();
    }

    public void setPrimaryColor(int i) {
        this.f29307a.setPrimaryColor(i);
    }

    public int getReflectionColor() {
        return this.f29307a.getReflectionColor();
    }

    public void setReflectionColor(int i) {
        this.f29307a.setReflectionColor(i);
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
        ShimmerViewHelper shimmerViewHelper = this.f29307a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        ShimmerViewHelper shimmerViewHelper = this.f29307a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ShimmerViewHelper shimmerViewHelper = this.f29307a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.onSizeChanged();
        }
    }

    public void onDraw(Canvas canvas) {
        ShimmerViewHelper shimmerViewHelper = this.f29307a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.onDraw();
        }
        super.onDraw(canvas);
    }
}
