package com.didi.payment.wallet.global.riskcontrol.sms;

import android.widget.TextView;
import com.didi.payment.wallet.global.riskcontrol.sms.SmsEditView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/payment/wallet/global/riskcontrol/sms/SmsVerifyFragment$onViewCreated$2", "Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$IInputListener;", "onInputContinue", "", "onInputDone", "text", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SmsVerifyFragment.kt */
public final class SmsVerifyFragment$onViewCreated$2 implements SmsEditView.IInputListener {
    final /* synthetic */ SmsVerifyFragment this$0;

    SmsVerifyFragment$onViewCreated$2(SmsVerifyFragment smsVerifyFragment) {
        this.this$0 = smsVerifyFragment;
    }

    public void onInputDone(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView access$getTvSubmit$p = this.this$0.f31807b;
        if (access$getTvSubmit$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubmit");
            access$getTvSubmit$p = null;
        }
        access$getTvSubmit$p.setEnabled(true);
    }

    public void onInputContinue() {
        TextView access$getTvSubmit$p = this.this$0.f31807b;
        if (access$getTvSubmit$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubmit");
            access$getTvSubmit$p = null;
        }
        access$getTvSubmit$p.setEnabled(false);
    }
}
