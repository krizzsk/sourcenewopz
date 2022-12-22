package com.didichuxing.security.cardverify.presenter;

import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.contract.CreditCardVerifyContract;
import com.didichuxing.security.cardverify.model.CardModel;
import com.didichuxing.security.cardverify.model.bean.WithdrawVerifyResult;
import com.taxis99.R;
import java.io.IOException;

public class VerificationPresenter implements CreditCardVerifyContract.IPresenter {

    /* renamed from: a */
    private CardModel f48945a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CreditCardVerifyContract.IView f48946b;

    public VerificationPresenter(CreditCardVerifyContract.IView iView, DiCardVerifyParam diCardVerifyParam) {
        this.f48946b = iView;
        this.f48945a = new CardModel(iView.getContext(), diCardVerifyParam);
    }

    public void verifyCard(String str, String str2) {
        CreditCardVerifyContract.IView iView = this.f48946b;
        iView.showLoadingDialog(iView.getContext().getString(R.string.didi_security_card_verify_net_loading));
        this.f48945a.verifyWithdraw(str, str2, new RpcService.Callback<WithdrawVerifyResult>() {
            public void onSuccess(WithdrawVerifyResult withdrawVerifyResult) {
                VerificationPresenter.this.f48946b.dismissLoadingDialog();
                if (withdrawVerifyResult == null || withdrawVerifyResult.content == null) {
                    VerificationPresenter.this.f48946b.onVerifyException();
                    VerificationPresenter.this.f48946b.showToast(VerificationPresenter.this.f48946b.getContext().getString(R.string.didi_security_card_verify_net_serverbusy));
                    return;
                }
                int i = withdrawVerifyResult.content.code;
                String str = withdrawVerifyResult.content.frontMsg;
                switch (i) {
                    case 100001:
                        VerificationPresenter.this.f48946b.showToastCompleted(str);
                        VerificationPresenter.this.f48946b.onVerifySuccess();
                        return;
                    case 100002:
                    case 100003:
                        VerificationPresenter.this.f48946b.showToast(str);
                        VerificationPresenter.this.f48946b.onVerifyFailure();
                        return;
                    case 100004:
                        VerificationPresenter.this.f48946b.onVerifyMultiFailure(str, withdrawVerifyResult.getContactH5Url());
                        return;
                    default:
                        VerificationPresenter.this.f48946b.onVerifyException();
                        VerificationPresenter.this.f48946b.showToast(VerificationPresenter.this.f48946b.getContext().getString(R.string.didi_security_card_verify_net_serverbusy));
                        return;
                }
            }

            public void onFailure(IOException iOException) {
                VerificationPresenter.this.f48946b.onVerifyException();
                VerificationPresenter.this.f48946b.dismissLoadingDialog();
                VerificationPresenter.this.f48946b.showToast(VerificationPresenter.this.f48946b.getContext().getString(R.string.didi_security_card_verify_net_connerror));
            }
        });
    }
}
