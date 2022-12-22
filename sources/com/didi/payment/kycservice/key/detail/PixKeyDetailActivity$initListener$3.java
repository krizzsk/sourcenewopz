package com.didi.payment.kycservice.key.detail;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.kycservice.key.detail.response.PixKeyDetailResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/key/detail/PixKeyDetailActivity$initListener$3", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyDetailActivity.kt */
public final class PixKeyDetailActivity$initListener$3 extends DoubleCheckOnClickListener {
    final /* synthetic */ PixKeyDetailActivity this$0;

    PixKeyDetailActivity$initListener$3(PixKeyDetailActivity pixKeyDetailActivity) {
        this.this$0 = pixKeyDetailActivity;
    }

    public void doClick(View view) {
        PixKeyDetailResp.UnbindingDlgInfo unbindingDlgInfo;
        PixKeyDetailResp.Data value = PixKeyDetailActivity.access$getVm(this.this$0).getBizData().getValue();
        String str = null;
        if (value == null) {
            unbindingDlgInfo = null;
        } else {
            unbindingDlgInfo = value.getDlgInfo();
        }
        if (unbindingDlgInfo != null) {
            PixKeyDetailActivity pixKeyDetailActivity = this.this$0;
            PixKeyDetailResp.UnbindingDlgInfo dlgInfo = value.getDlgInfo();
            Intrinsics.checkNotNull(dlgInfo);
            String access$getKeyVal$p = this.this$0.f30686o;
            if (access$getKeyVal$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyVal");
            } else {
                str = access$getKeyVal$p;
            }
            pixKeyDetailActivity.m21568a(dlgInfo, str, value.isDefault(), value.getStatus());
        }
    }
}
