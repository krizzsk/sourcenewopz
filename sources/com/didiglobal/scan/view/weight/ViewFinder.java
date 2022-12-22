package com.didiglobal.scan.view.weight;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.scan.delegate.IViewStyleDelegate;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0014J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didiglobal/scan/view/weight/ViewFinder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributes", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "loadingView", "Landroid/widget/ImageView;", "parentHeight", "parentWidth", "topMargin", "getDrawable", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimator", "stopAnimator", "updateMargin", "value", "", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ViewFinder.kt */
public final class ViewFinder extends FrameLayout {

    /* renamed from: a */
    private ImageView f51402a;

    /* renamed from: b */
    private int f51403b;

    /* renamed from: c */
    private int f51404c;

    /* renamed from: d */
    private int f51405d;

    /* renamed from: e */
    private ValueAnimator f51406e = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewFinder(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        m36804a(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewFinder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attributes");
        m36804a(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewFinder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attributes");
        m36804a(context);
    }

    private final int getDrawable() {
        IViewStyleDelegate iViewStyleDelegate = (IViewStyleDelegate) ServiceLoader.load(IViewStyleDelegate.class).get();
        return iViewStyleDelegate != null ? iViewStyleDelegate.getScanImg() : R.drawable.brazil_scan_bg;
    }

    /* renamed from: a */
    private final void m36804a(Context context) {
        ImageView imageView = new ImageView(context);
        this.f51402a = imageView;
        if (imageView != null) {
            imageView.setImageResource(getDrawable());
        }
        addView(this.f51402a, new ViewGroup.LayoutParams(-1, 100));
        this.f51406e.addUpdateListener(new ViewFinder$init$1(this));
        this.f51406e.addListener(new ViewFinder$init$2());
        ValueAnimator valueAnimator = this.f51406e;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "animator");
        valueAnimator.setDuration(2000);
        ValueAnimator valueAnimator2 = this.f51406e;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator2, "animator");
        valueAnimator2.setInterpolator(new LinearInterpolator());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36803a(float f) {
        int i = this.f51404c;
        if (i != 0) {
            this.f51405d = (int) (((float) (i - 100)) * f);
            ImageView imageView = this.f51402a;
            ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
            if (layoutParams != null && (layoutParams instanceof FrameLayout.LayoutParams)) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = this.f51405d;
            }
            ImageView imageView2 = this.f51402a;
            if (imageView2 != null) {
                imageView2.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f51403b = View.MeasureSpec.getSize(i);
        this.f51404c = View.MeasureSpec.getSize(i2);
    }

    public final void stopAnimator() {
        ValueAnimator valueAnimator = this.f51406e;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public final void startAnimator() {
        ValueAnimator valueAnimator = this.f51406e;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }
}
