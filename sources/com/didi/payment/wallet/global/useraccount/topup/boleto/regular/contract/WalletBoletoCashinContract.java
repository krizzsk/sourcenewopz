package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract;

import android.content.Context;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;

public interface WalletBoletoCashinContract {

    public interface Presenter {
        void submitBoleto(Long l);
    }

    public interface View {
        void displayBoleto(WalletBoletoResp walletBoletoResp);

        Context getContext();

        void onNetworkError();
    }
}
