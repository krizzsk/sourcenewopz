package com.didi.payment.pix.qrpayee.fragment;

import com.didi.payment.pix.qrpayee.widget.AmountEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/pix/qrpayee/fragment/QrCodeSetAmountFragment$initContentView$1", "Lcom/didi/payment/pix/qrpayee/widget/AmountEditText$IValueValidator;", "onValueChanged", "", "valid", "", "value", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: QrCodeSetAmountFragment.kt */
public final class QrCodeSetAmountFragment$initContentView$1 implements AmountEditText.IValueValidator {
    final /* synthetic */ QrCodeSetAmountFragment this$0;

    QrCodeSetAmountFragment$initContentView$1(QrCodeSetAmountFragment qrCodeSetAmountFragment) {
        this.this$0 = qrCodeSetAmountFragment;
    }

    public void onValueChanged(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.this$0.getConfirmBtn().setEnabled(z);
    }
}
