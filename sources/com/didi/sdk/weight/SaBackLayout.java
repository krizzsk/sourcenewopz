package com.didi.sdk.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.passenger.C10448R;
import com.didi.sdk.app.business.ISaStatusBarDelegate;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/sdk/weight/SaBackLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "back", "Landroid/view/View;", "viewContainer", "init", "", "setOnBackListener", "listener", "Landroid/view/View$OnClickListener;", "publicservice_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SaBackLayout.kt */
public final class SaBackLayout extends ConstraintLayout {

    /* renamed from: a */
    private View f38509a;

    /* renamed from: b */
    private ConstraintLayout f38510b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaBackLayout(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        m27296a(context, (AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attributeSet");
        m27296a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attributeSet");
        m27296a(context, attributeSet);
    }

    /* renamed from: a */
    private final void m27296a(Context context, AttributeSet attributeSet) {
        ConstraintLayout.inflate(context, R.layout.layout_sa_back, this);
        View findViewById = findViewById(R.id.viewContainer);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.viewContainer)");
        this.f38510b = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(R.id.saBack);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.saBack)");
        this.f38509a = findViewById2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.SaBackLayout);
        Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.SaBackLayout)");
        int dip2px = UiUtils.dip2px(context, 10.0f);
        int dip2px2 = UiUtils.dip2px(context, 10.0f) - dip2px;
        int dip2px3 = UiUtils.dip2px(context, 16.0f) - dip2px;
        int dip2px4 = UiUtils.dip2px(context, 10.0f) - dip2px;
        ISaStatusBarDelegate iSaStatusBarDelegate = (ISaStatusBarDelegate) ServiceLoader.load(ISaStatusBarDelegate.class).get();
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, (iSaStatusBarDelegate != null ? iSaStatusBarDelegate.getStatusBarHeight() : 0) + dip2px2);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, dip2px3);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(0, dip2px4);
        obtainStyledAttributes.recycle();
        View view = this.f38509a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.leftMargin = dimensionPixelSize2;
            layoutParams2.rightMargin = dimensionPixelSize3;
            layoutParams2.topMargin = dimensionPixelSize;
            layoutParams2.bottomMargin = dimensionPixelSize4;
            View view2 = this.f38509a;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME);
            }
            view2.setLayoutParams(layoutParams2);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setOnBackListener(View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(onClickListener, "listener");
        View view = this.f38509a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME);
        }
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
