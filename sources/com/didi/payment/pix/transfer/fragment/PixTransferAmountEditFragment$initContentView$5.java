package com.didi.payment.pix.transfer.fragment;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/pix/transfer/fragment/PixTransferAmountEditFragment$initContentView$5", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
public final class PixTransferAmountEditFragment$initContentView$5 extends DoubleCheckOnClickListener {
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    PixTransferAmountEditFragment$initContentView$5(PixTransferAmountEditFragment pixTransferAmountEditFragment) {
        this.this$0 = pixTransferAmountEditFragment;
    }

    public void doClick(View view) {
        String unableAmountDesc;
        PixTransferOption.TransferOptionInfo access$getMTransferOption$p = this.this$0.f31243i;
        if (access$getMTransferOption$p != null && (unableAmountDesc = access$getMTransferOption$p.getUnableAmountDesc()) != null) {
            PixTransferAmountEditFragment pixTransferAmountEditFragment = this.this$0;
            String string = pixTransferAmountEditFragment.getString(R.string.wallet_dialog_ok_ok);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wallet_dialog_ok_ok)");
            pixTransferAmountEditFragment.m21995a(unableAmountDesc, string);
        }
    }
}
