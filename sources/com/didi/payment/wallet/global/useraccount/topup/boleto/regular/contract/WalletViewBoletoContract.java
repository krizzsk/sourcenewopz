package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract;

import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;

public interface WalletViewBoletoContract {

    public interface Presenter {
        void sendEmail(WalletBoletoResp walletBoletoResp);
    }

    public interface View {
        void onEmailSentSuccess();

        void onNetworkError();
    }
}
