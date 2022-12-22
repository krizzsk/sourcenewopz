package com.didi.payment.pix.refund;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.net.response.PixRefundExtrasResp;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/pix/refund/PixRefundEditFragment$initContentView$3", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixRefundEditFragment.kt */
public final class PixRefundEditFragment$initContentView$3 extends DoubleCheckOnClickListener {
    final /* synthetic */ PixRefundEditFragment this$0;

    PixRefundEditFragment$initContentView$3(PixRefundEditFragment pixRefundEditFragment) {
        this.this$0 = pixRefundEditFragment;
    }

    public void doClick(View view) {
        Editable text;
        String typeId;
        if (this.this$0.getSelectExtras() != null && (text = this.this$0.getRefundAmountEt().getText()) != null) {
            PixRefundEditFragment pixRefundEditFragment = this.this$0;
            if (!TextUtils.isEmpty(text.toString())) {
                float parseFloatValue = pixRefundEditFragment.getNFloatParser().parseFloatValue(text.toString());
                int dollarToCent = MathUtil.dollarToCent(parseFloatValue);
                PixRefundExtrasResp.ReasonEntry selectExtras = pixRefundEditFragment.getSelectExtras();
                if (!(selectExtras == null || (typeId = selectExtras.getTypeId()) == null)) {
                    PixRefundEditFragment.access$getVm(pixRefundEditFragment).doRefund(dollarToCent, pixRefundEditFragment.getMRefundOrderId(), typeId);
                }
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_refund_ck", "pix_refund_amount", String.valueOf(parseFloatValue));
            }
        }
    }
}
