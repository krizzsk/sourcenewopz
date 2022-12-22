package com.didi.payment.pix.refund;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/pix/refund/PixOrderRefundActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "()V", "fragmentContainer", "Landroid/view/ViewGroup;", "getFragmentContainer", "()Landroid/view/ViewGroup;", "setFragmentContainer", "(Landroid/view/ViewGroup;)V", "refundOrderId", "", "getRefundOrderId", "()Ljava/lang/String;", "setRefundOrderId", "(Ljava/lang/String;)V", "", "getTitleBarView", "Landroid/view/View;", "initViewModels", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseIntent", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixOrderRefundActivity.kt */
public final class PixOrderRefundActivity extends WBaseActivity<WBaseViewModel> {

    /* renamed from: a */
    private String f31195a = "";
    public ViewGroup fragmentContainer;

    /* renamed from: b */
    private final void m21950b() {
    }

    public int getFragmentContainer() {
        return R.id.fragment_container;
    }

    /* renamed from: getFragmentContainer  reason: collision with other method in class */
    public final ViewGroup m46602getFragmentContainer() {
        ViewGroup viewGroup = this.fragmentContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        return null;
    }

    public final void setFragmentContainer(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.fragmentContainer = viewGroup;
    }

    public final String getRefundOrderId() {
        return this.f31195a;
    }

    public final void setRefundOrderId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f31195a = str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.pix_order_refund_layout);
        m21949a();
        m21951c();
        m21950b();
    }

    /* renamed from: a */
    private final void m21949a() {
        String stringExtra = getIntent().getStringExtra("order_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f31195a = stringExtra;
    }

    /* renamed from: c */
    private final void m21951c() {
        View findViewById = findViewById(R.id.fragment_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fragment_container)");
        setFragmentContainer((ViewGroup) findViewById);
        Bundle bundle = new Bundle();
        bundle.putString("order_id", this.f31195a);
        attachRootFragment((Class<?>) PixRefundEditFragment.class, bundle, getFragmentContainer());
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return super.getTitleBarView();
    }
}
