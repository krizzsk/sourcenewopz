package com.didi.consume.channels.view;

import com.didi.consume.channels.model.CsTopUpChannelResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;

public interface CsTopUpChannelContract {

    public interface Presenter {
        void handleChannelClick(WalletTopUpChannelResp.ChannelBean channelBean);

        void handleConditionClick(String str);

        void requestData();
    }

    public interface View {
        void onNetworkError();

        void refreshUI(CsTopUpChannelResp.Data data);

        void showHomelandCityErrorPage();
    }
}
