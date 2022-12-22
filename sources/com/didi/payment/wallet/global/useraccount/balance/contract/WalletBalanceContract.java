package com.didi.payment.wallet.global.useraccount.balance.contract;

import com.didi.payment.wallet.global.useraccount.balance.model.BalanceResp;
import java.util.List;

public interface WalletBalanceContract {

    public interface Presenter {
        void requestData();

        void requestMoreData();

        void retryRequestData();
    }

    public interface View {
        void dismissLoadingFirstTime();

        void onBalanceDataSuccessful(List<BalanceResp.StatementBean> list, boolean z);

        void onBalanceMoreDataSuccessful(List<BalanceResp.StatementBean> list, boolean z);

        void onNetworkError();

        void showLoadingFirstTime();
    }
}
