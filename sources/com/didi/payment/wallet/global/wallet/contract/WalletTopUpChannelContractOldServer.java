package com.didi.payment.wallet.global.wallet.contract;

import android.content.Context;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletUserProtocolsResp;

public interface WalletTopUpChannelContractOldServer {

    public interface Presenter {
        void handleChannelClick(WalletTopUpChannelRespOldServer.ChannelBean channelBean);

        void handleTACDialogBtnClick(WalletUserProtocolsResp.UnAcceptProtocol unAcceptProtocol);

        void requestData();

        void requestTACProtocolInfo(String str);
    }

    public interface View {
        void dismissLoadingDialog();

        Context getContext();

        void onNetworkError();

        void refreshUI(WalletTopUpChannelRespOldServer.DataBean dataBean);

        void showLoadingDialog();

        void showTACDialog(WalletUserProtocolsResp.DataBean dataBean);
    }
}
