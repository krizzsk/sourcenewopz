package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;

public interface WalletNightlyLimitContract {

    public interface IPresenter {
        void destroy();

        void requestData();

        void submit(long j, long j2);
    }

    public interface IView extends WalletLoadingContract {
        void onChangeFailed(String str);

        void onChangeSuccess(QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo);

        void onNetworkError();

        void showSettingLimit(QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo);
    }
}
