package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ&\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeShopStatusExceptionMaskView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mStatusTv", "Landroid/widget/TextView;", "setData", "", "timeDesc", "", "statusDesc", "setLayoutMarginAndPadding", "horizontalMargin", "", "verticalMargin", "horizontalPadding", "verticalPadding", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeShopStatusExceptionMaskView.kt */
public final class HomeShopStatusExceptionMaskView extends RelativeLayout {

    /* renamed from: a */
    private TextView f43139a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeShopStatusExceptionMaskView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeShopStatusExceptionMaskView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeShopStatusExceptionMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = LayoutInflater.from(context).inflate(R.layout.customer_home_shop_exception_status_mask_layout, this).findViewById(R.id.customer_tv_status);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_status)");
        this.f43139a = (TextView) findViewById;
    }

    public final void setData(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || charSequence2.length() == 0) {
                this.f43139a.setVisibility(8);
                this.f43139a.setText("");
                setVisibility(8);
                return;
            }
        }
        this.f43139a.setVisibility(0);
        setVisibility(0);
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            this.f43139a.setText(charSequence);
        } else {
            this.f43139a.setText(str2);
        }
    }

    public final void setLayoutMarginAndPadding(int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = this.f43139a.getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.leftMargin = i;
            layoutParams2.rightMargin = i;
            layoutParams2.topMargin = i2;
            layoutParams2.bottomMargin = i2;
            this.f43139a.setLayoutParams(layoutParams2);
            this.f43139a.setPadding(i3, i4, i3, i4);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
}
