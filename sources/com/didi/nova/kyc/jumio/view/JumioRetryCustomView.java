package com.didi.nova.kyc.jumio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/view/JumioRetryCustomView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "errorRetryButton", "Landroid/view/View;", "partRetryButton", "retryLayout", "attachView", "", "container", "Landroid/view/ViewGroup;", "partListener", "Landroid/view/View$OnClickListener;", "errorListener", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioRetryCustomView.kt */
public final class JumioRetryCustomView extends RelativeLayout {

    /* renamed from: a */
    private View f29374a;

    /* renamed from: b */
    private View f29375b;

    /* renamed from: c */
    private View f29376c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JumioRetryCustomView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioRetryCustomView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioRetryCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f29374a = LayoutInflater.from(context).inflate(R.layout.jumio_scan_part_retry, this, true);
        this.f29375b = findViewById(R.id.partRetryButton);
        this.f29376c = findViewById(R.id.errorRetryButton);
    }

    public void attachView(ViewGroup viewGroup, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        viewGroup.addView(this);
        if (onClickListener != null) {
            View view = this.f29375b;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
            View view2 = this.f29375b;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            View view3 = this.f29376c;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        if (onClickListener2 != null) {
            View view4 = this.f29376c;
            if (view4 != null) {
                view4.setOnClickListener(onClickListener2);
            }
            View view5 = this.f29376c;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            View view6 = this.f29375b;
            if (view6 != null) {
                view6.setVisibility(8);
            }
        }
    }
}
