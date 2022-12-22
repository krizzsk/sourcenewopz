package com.didi.payment.wallet.global.prepaidcard;

import com.didiglobal.pay.paysecure.prepaidcard.CommonPwdDialog;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/prepaidcard/VerifyPwdUtil$Companion$handlePwdVerify$2$1", "Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$IDismissResult;", "onDismissResult", "", "result", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VerifyPwdUtil.kt */
public final class VerifyPwdUtil$Companion$handlePwdVerify$2$1 implements CommonPwdDialog.IDismissResult {
    final /* synthetic */ IPwdVerify $callback;

    VerifyPwdUtil$Companion$handlePwdVerify$2$1(IPwdVerify iPwdVerify) {
        this.$callback = iPwdVerify;
    }

    public void onDismissResult(int i) {
        IPwdVerify iPwdVerify;
        if (i == 0) {
            IPwdVerify iPwdVerify2 = this.$callback;
            if (iPwdVerify2 != null) {
                iPwdVerify2.onFail();
            }
        } else if (i == 1 && (iPwdVerify = this.$callback) != null) {
            iPwdVerify.onSuccess(i);
        }
    }
}
