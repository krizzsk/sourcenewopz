package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;

public interface WalletTopUpChannelContract {

    public interface Presenter {
        void handleChannelClick(WalletTopUpChannelResp.ChannelBean channelBean);

        void handleConditionClick(String str);

        void handleVerifyClick(String str);

        void requestData();
    }

    public interface View {
        void onNetworkError();

        void refreshUI(WalletTopUpChannelResp.DataBean dataBean);

        void showHomelandCityErrorPage();
    }
}
