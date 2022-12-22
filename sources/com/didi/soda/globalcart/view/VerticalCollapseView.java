package com.didi.soda.globalcart.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/VerticalCollapseView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "statusListener", "Lcom/didi/soda/globalcart/view/VerticalCollapseView$StatusChangeListener;", "removeAnim", "", "setStatusListener", "smoothChangeStatus", "isExpand", "", "expendHeight", "collapsedHeight", "StatusChangeListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VerticalCollapseView.kt */
public final class VerticalCollapseView extends ScrollView {

    /* renamed from: a */
    private ValueAnimator f42348a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public StatusChangeListener f42349b;

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/VerticalCollapseView$StatusChangeListener;", "", "onAnimFinish", "", "onUpdate", "value", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: VerticalCollapseView.kt */
    public interface StatusChangeListener {
        void onAnimFinish();

        void onUpdate(float f);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final ValueAnimator getAnimator() {
        return this.f42348a;
    }

    public final void setAnimator(ValueAnimator valueAnimator) {
        this.f42348a = valueAnimator;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalCollapseView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalCollapseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalCollapseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    public final void smoothChangeStatus(boolean z, int i, int i2) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f42348a;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        if (z) {
            valueAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        } else {
            valueAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        }
        this.f42348a = valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(250);
        }
        ValueAnimator valueAnimator3 = this.f42348a;
        if (valueAnimator3 != null) {
            valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, i2) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    VerticalCollapseView.m29828a(VerticalCollapseView.this, this.f$1, this.f$2, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator4 = this.f42348a;
        if (valueAnimator4 != null) {
            valueAnimator4.addListener(new VerticalCollapseView$smoothChangeStatus$2(this));
        }
        ValueAnimator valueAnimator5 = this.f42348a;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29828a(VerticalCollapseView verticalCollapseView, int i, int i2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(verticalCollapseView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            StatusChangeListener statusChangeListener = verticalCollapseView.f42349b;
            if (statusChangeListener != null) {
                statusChangeListener.onUpdate(floatValue);
            }
            float f = (((float) (i - i2)) * floatValue) + ((float) i2);
            ViewGroup.LayoutParams layoutParams = verticalCollapseView.getLayoutParams();
            layoutParams.height = (int) f;
            Unit unit = Unit.INSTANCE;
            verticalCollapseView.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final void setStatusListener(StatusChangeListener statusChangeListener) {
        Intrinsics.checkNotNullParameter(statusChangeListener, "statusListener");
        this.f42349b = statusChangeListener;
    }

    public final void removeAnim() {
        ValueAnimator valueAnimator = this.f42348a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
