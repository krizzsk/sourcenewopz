package com.didi.payment.pix.refund;

import android.text.Editable;
import android.text.TextWatcher;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.pix.net.response.PixRefundExtrasResp;
import com.taxis99.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/payment/pix/refund/PixRefundEditFragment$initContentView$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixRefundEditFragment.kt */
public final class PixRefundEditFragment$initContentView$1 implements TextWatcher {
    final /* synthetic */ PixRefundEditFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    PixRefundEditFragment$initContentView$1(PixRefundEditFragment pixRefundEditFragment) {
        this.this$0 = pixRefundEditFragment;
    }

    public void afterTextChanged(Editable editable) {
        String valueOf = String.valueOf(editable);
        PixRefundExtrasResp.RefundOptions refundExtrasList = this.this$0.getRefundExtrasList();
        if (refundExtrasList != null) {
            PixRefundEditFragment pixRefundEditFragment = this.this$0;
            float parseFloatValue = pixRefundEditFragment.getNFloatParser().parseFloatValue(valueOf);
            boolean z = true;
            if (MathUtil.dollarToCent(parseFloatValue) > refundExtrasList.getMaxRefundAmount()) {
                String centToDollar = MathUtil.centToDollar(Double.valueOf((double) Math.min(refundExtrasList.getMaxRefundAmount(), refundExtrasList.getUserAvailableAmount())));
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = pixRefundEditFragment.getString(R.string.GRider_payment_Not_more_EcrK);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRider_payment_Not_more_EcrK)");
                String format = String.format(string, Arrays.copyOf(new Object[]{centToDollar}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                pixRefundEditFragment.getRefundAmountLabel().setText(TextHighlightUtil.highlight((CharSequence) Intrinsics.stringPlus(pixRefundEditFragment.getString(R.string.GRider_payment_Refund_amount_LMXa), format), pixRefundEditFragment.getResources().getColor(R.color.wallet_color_FF8040), false));
                pixRefundEditFragment.setInputAmountValid(false);
            } else {
                pixRefundEditFragment.getRefundAmountLabel().setText(pixRefundEditFragment.getString(R.string.GRider_payment_Refund_amount_LMXa));
                if (parseFloatValue <= 0.0f) {
                    z = false;
                }
                pixRefundEditFragment.setInputAmountValid(z);
            }
            pixRefundEditFragment.invalidConfirmBtn(pixRefundEditFragment.getInputAmountValid());
        }
    }
}
