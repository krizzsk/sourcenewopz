package com.didi.nova.kyc.jumio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.payment.base.utils.UIUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/view/FaceGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBottomBar", "Landroid/widget/TextView;", "mMainView", "Landroid/view/View;", "mRootView", "attachView", "", "container", "Landroid/view/ViewGroup;", "onClickListener", "Landroid/view/View$OnClickListener;", "getBottomBar", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FaceGuideView.kt */
public final class FaceGuideView extends RelativeLayout {

    /* renamed from: a */
    private View f29359a;

    /* renamed from: b */
    private TextView f29360b;

    /* renamed from: c */
    private View f29361c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FaceGuideView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FaceGuideView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FaceGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.face_guide_layout, this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…guide_layout, this, true)");
        this.f29359a = inflate;
        View findViewById = inflate.findViewById(R.id.face_guide_confirm_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R…d.face_guide_confirm_btn)");
        this.f29360b = (TextView) findViewById;
        View findViewById2 = this.f29359a.findViewById(R.id.main_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.main_layout)");
        this.f29361c = findViewById2;
    }

    public void attachView(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.f29360b.setOnClickListener(onClickListener);
        viewGroup.addView(this);
        View view = this.f29361c;
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = UIUtil.dip2px(getContext(), 110.0f);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public TextView getBottomBar() {
        return this.f29360b;
    }
}
