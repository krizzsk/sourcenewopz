package com.didi.soda.address.edit;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.address.edit.component.EditAddressInfoComponent;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\u0012\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006/"}, mo175978d2 = {"Lcom/didi/soda/address/edit/EditAddressInfoPage;", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "()V", "mBackgroundView", "Landroid/view/View;", "getMBackgroundView", "()Landroid/view/View;", "setMBackgroundView", "(Landroid/view/View;)V", "mCartContainer", "Landroid/widget/FrameLayout;", "getMCartContainer", "()Landroid/widget/FrameLayout;", "setMCartContainer", "(Landroid/widget/FrameLayout;)V", "mEditAddressComponent", "Lcom/didi/soda/address/edit/component/EditAddressInfoComponent;", "getMEditAddressComponent", "()Lcom/didi/soda/address/edit/component/EditAddressInfoComponent;", "setMEditAddressComponent", "(Lcom/didi/soda/address/edit/component/EditAddressInfoComponent;)V", "mRootContainer", "getMRootContainer", "setMRootContainer", "backgroundToAlpha0", "", "backgroundToAlpha1", "getPopHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getPushHandler", "getStatusBarHeight", "", "getTouchIntercept", "", "onCreate", "view", "onDestroy", "onHandleBack", "onInflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPageChangeEnded", "onPageResult", "data", "Landroid/os/Bundle;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"addressEdit"})
/* compiled from: EditAddressInfoPage.kt */
public final class EditAddressInfoPage extends CustomerPage {

    /* renamed from: a */
    private EditAddressInfoComponent f38709a;
    public View mBackgroundView;
    public FrameLayout mCartContainer;
    public View mRootContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public boolean getTouchIntercept() {
        return false;
    }

    public final FrameLayout getMCartContainer() {
        FrameLayout frameLayout = this.mCartContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCartContainer");
        return null;
    }

    public final void setMCartContainer(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mCartContainer = frameLayout;
    }

    public final View getMBackgroundView() {
        View view = this.mBackgroundView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
        return null;
    }

    public final void setMBackgroundView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mBackgroundView = view;
    }

    public final View getMRootContainer() {
        View view = this.mRootContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
        return null;
    }

    public final void setMRootContainer(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mRootContainer = view;
    }

    public final EditAddressInfoComponent getMEditAddressComponent() {
        return this.f38709a;
    }

    public final void setMEditAddressComponent(EditAddressInfoComponent editAddressInfoComponent) {
        this.f38709a = editAddressInfoComponent;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        setMRootContainer(viewGroup);
        View inflate = layoutInflater.inflate(R.layout.customer_page_cart_edit_address_container, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.customer_v_cart_edit_address_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "container.findViewById(R…r_v_cart_edit_address_bg)");
        setMBackgroundView(findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_fl_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "container.findViewById(R…stomer_fl_cart_container)");
        setMCartContainer((FrameLayout) findViewById2);
        Intrinsics.checkNotNullExpressionValue(inflate, "container");
        return inflate;
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        EditAddressInfoPageKt.checkFromSaLandingPage(this);
        EditAddressInfoComponent editAddressInfoComponent = new EditAddressInfoComponent(getMCartContainer());
        addComponent(editAddressInfoComponent);
        editAddressInfoComponent.setBackAction(new EditAddressInfoPage$onCreate$1$1(this, editAddressInfoComponent));
        Unit unit = Unit.INSTANCE;
        this.f38709a = editAddressInfoComponent;
    }

    public ControllerChangeHandler getPopHandler() {
        return new EditPageChangeHandler(true);
    }

    public ControllerChangeHandler getPushHandler() {
        return new EditPageChangeHandler(true);
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
        m27424b();
    }

    public boolean onHandleBack() {
        m27422a();
        return super.onHandleBack();
    }

    public void onPageResult(Bundle bundle) {
        EditAddressInfoComponent mEditAddressComponent;
        if (bundle != null && (mEditAddressComponent = getMEditAddressComponent()) != null) {
            mEditAddressComponent.onPageResult(bundle);
        }
    }

    public void onDestroy() {
        View findViewById;
        super.onDestroy();
        if (getMRootContainer() != null && (findViewById = getMRootContainer().findViewById(R.id.customer_custom_main_drawer)) != null) {
            findViewById.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27422a() {
        getMBackgroundView().setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EditAddressInfoPage.m27423a(EditAddressInfoPage.this, valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27423a(EditAddressInfoPage editAddressInfoPage, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(editAddressInfoPage, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            editAddressInfoPage.getMBackgroundView().setAlpha(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* renamed from: b */
    private final void m27424b() {
        if (getMBackgroundView().getVisibility() == 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat.setDuration(200);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EditAddressInfoPage.m27425b(EditAddressInfoPage.this, valueAnimator);
                }
            });
            ofFloat.addListener(new EditAddressInfoPage$backgroundToAlpha0$2(this));
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27425b(EditAddressInfoPage editAddressInfoPage, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(editAddressInfoPage, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            if (floatValue == 0.0f) {
                editAddressInfoPage.getMBackgroundView().setVisibility(8);
            } else {
                editAddressInfoPage.getMBackgroundView().setAlpha(floatValue);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }
}
