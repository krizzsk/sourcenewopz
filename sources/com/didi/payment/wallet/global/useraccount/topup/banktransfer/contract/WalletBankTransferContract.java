package com.didi.payment.wallet.global.useraccount.topup.banktransfer.contract;

import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;

public interface WalletBankTransferContract {

    public interface Presenter {
        void requestData();
    }

    public interface View {
        void onNetworkError();

        void refreshUI(WalletTopUpChannelResp.ExtraDataBrazilBankTransfer extraDataBrazilBankTransfer);
    }
}
