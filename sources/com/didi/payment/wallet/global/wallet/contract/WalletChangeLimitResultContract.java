package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;

public interface WalletChangeLimitResultContract {

    public interface IPresenter {
        void destroy();

        void requestData();
    }

    public interface IView extends WalletLoadingContract {
        void showNetworkError();

        void showResult(QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo);
    }
}
