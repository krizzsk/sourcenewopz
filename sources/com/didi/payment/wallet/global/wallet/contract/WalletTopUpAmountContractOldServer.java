package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;

public interface WalletTopUpAmountContractOldServer {

    public interface Presenter {
        void handleTopUpClick(WalletTopUpChannelResp.ExtraDataMexicoOnlineItem extraDataMexicoOnlineItem);

        void requestData();
    }

    public interface View {
        void onNetworkError();

        void refreshUI(WalletTopUpChannelResp.ExtraDataMexicoOnline extraDataMexicoOnline);
    }
}
