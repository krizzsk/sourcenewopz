package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract;

import android.content.Context;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import java.util.List;

public interface WalletBoletoHistoryContract {

    public interface Presenter {
        void requestData();
    }

    public interface View {
        void displayBoletoHistory(List<WalletBoletoResp> list);

        Context getContext();

        void onNetworkError();
    }
}
