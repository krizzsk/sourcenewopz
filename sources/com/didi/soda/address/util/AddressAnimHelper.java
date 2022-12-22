package com.didi.soda.address.util;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00014B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006JO\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00190\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190%J\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\u000e\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0019J\u0006\u0010,\u001a\u00020\u0019J\u0006\u0010-\u001a\u00020\u0019J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u00020*H\u0003J\u0006\u00100\u001a\u00020\u0019J\u001a\u00101\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u00010\u00032\u0006\u00103\u001a\u00020\fH\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n¨\u00065"}, mo175978d2 = {"Lcom/didi/soda/address/util/AddressAnimHelper;", "", "pinView", "Landroid/view/View;", "barView", "layout", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "getBarView", "()Landroid/view/View;", "setBarView", "(Landroid/view/View;)V", "gonaGone", "", "getGonaGone", "()Z", "gonaVisible", "getGonaVisible", "isLoading", "setLoading", "(Z)V", "getLayout", "setLayout", "getPinView", "setPinView", "addressUpORDown", "", "addressView", "from", "", "to", "updateAction", "Lkotlin/Function1;", "Landroid/animation/ValueAnimator;", "Lkotlin/ParameterName;", "name", "valueAnimtor", "endAction", "Lkotlin/Function0;", "hideLoading", "onAddressDownPin", "onAddressDragDownPin", "endListener", "Lcom/didi/soda/address/util/AddressAnimHelper$AnimListener;", "onAddressUpPin", "onDragEndPin", "onDragStartPin", "pinBeat", "animListener", "pinLoading", "scale", "target", "isGonaVisible", "AnimListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressAnimHelper.kt */
public final class AddressAnimHelper {

    /* renamed from: a */
    private View f38802a;

    /* renamed from: b */
    private View f38803b;

    /* renamed from: c */
    private View f38804c;

    /* renamed from: d */
    private final boolean f38805d;

    /* renamed from: e */
    private final boolean f38806e = true;

    /* renamed from: f */
    private boolean f38807f;

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/address/util/AddressAnimHelper$AnimListener;", "", "onAnimEnd", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AddressAnimHelper.kt */
    public interface AnimListener {
        void onAnimEnd();
    }

    public final View getPinView() {
        return this.f38802a;
    }

    public final void setPinView(View view) {
        this.f38802a = view;
    }

    public final View getBarView() {
        return this.f38803b;
    }

    public final void setBarView(View view) {
        this.f38803b = view;
    }

    public final View getLayout() {
        return this.f38804c;
    }

    public final void setLayout(View view) {
        this.f38804c = view;
    }

    public final boolean getGonaGone() {
        return this.f38805d;
    }

    public final boolean getGonaVisible() {
        return this.f38806e;
    }

    public final boolean isLoading() {
        return this.f38807f;
    }

    public final void setLoading(boolean z) {
        this.f38807f = z;
    }

    public AddressAnimHelper(View view, View view2, View view3) {
        this.f38803b = view2;
        this.f38802a = view;
        this.f38804c = view3;
    }

    public final void onDragEndPin() {
        m27501a(this.f38802a, this.f38805d);
        m27501a(this.f38803b, this.f38806e);
    }

    public final void onDragStartPin() {
        m27501a(this.f38803b, this.f38805d);
        m27501a(this.f38802a, this.f38806e);
    }

    public final void onAddressDownPin() {
        View view = this.f38802a;
        if (view != null) {
            m27500a(view, (AnimListener) new AddressAnimHelper$onAddressDownPin$1$1(this));
        }
    }

    public final void onAddressDragDownPin(AnimListener animListener) {
        Intrinsics.checkNotNullParameter(animListener, "endListener");
        View view = this.f38802a;
        if (view != null) {
            m27500a(view, animListener);
        }
    }

    public final void onAddressUpPin() {
        m27501a(this.f38802a, this.f38806e);
        m27501a(this.f38803b, this.f38805d);
    }

    /* renamed from: a */
    private final void m27500a(View view, AnimListener animListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{view.getY(), view.getY() - ((float) ((view.getHeight() / 3) * 2)), view.getY()}).setDuration(400);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AddressAnimHelper.m27498a(View.this, valueAnimator);
            }
        });
        duration.addListener(new AddressAnimHelper$pinBeat$2(animListener));
        duration.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27498a(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$pinView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            view.setY(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final void pinLoading() {
        this.f38807f = true;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.6f);
        translateAnimation.setDuration(200);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setRepeatCount(-1);
        View view = this.f38803b;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.f38802a;
        if (view2 != null) {
            view2.startAnimation(translateAnimation);
        }
    }

    public final void hideLoading() {
        this.f38807f = false;
        m27501a(this.f38802a, this.f38805d);
        m27501a(this.f38803b, this.f38806e);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27501a(View view, boolean z) {
        float f;
        float f2;
        if (view != null) {
            view.setVisibility(0);
        }
        if (z) {
            f2 = 0.1f;
            f = 1.0f;
        } else {
            f2 = 1.0f;
            f = 0.1f;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f, f2, f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400);
        scaleAnimation.setAnimationListener(new AddressAnimHelper$scale$1(z, view));
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    public final void addressUpORDown(View view, float f, float f2, Function1<? super ValueAnimator, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "addressView");
        Intrinsics.checkNotNullParameter(function1, "updateAction");
        Intrinsics.checkNotNullParameter(function0, "endAction");
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{f, f2}).setDuration(400);
        duration.addListener(new AddressAnimHelper$addressUpORDown$1(function0));
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view) {
            public final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AddressAnimHelper.m27502a(Function1.this, this.f$1, valueAnimator);
            }
        });
        duration.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27502a(Function1 function1, View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(function1, "$updateAction");
        Intrinsics.checkNotNullParameter(view, "$addressView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
            function1.invoke(valueAnimator);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) floatValue;
            view.post(new Runnable(layoutParams) {
                public final /* synthetic */ ViewGroup.LayoutParams f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AddressAnimHelper.m27499a(View.this, this.f$1);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27499a(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "$addressView");
        view.setLayoutParams(layoutParams);
    }
}
