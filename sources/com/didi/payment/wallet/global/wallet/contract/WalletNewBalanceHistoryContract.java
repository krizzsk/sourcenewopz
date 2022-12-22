package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.WalletBalanceHistoryResp;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOption;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;
import java.util.List;

public interface WalletNewBalanceHistoryContract {

    public interface Presenter extends WalletCommonContract.Presenter {
        void onSelectedBalanceOption(WalletBalanceOption walletBalanceOption);

        void onSelectedBalanceTime(long j);

        void requestNextData(long j);

        void retryRequestData();
    }

    public interface View extends WalletCommonContract.ILoadingView {
        void onBalanceDataSuccessful(List<WalletBalanceHistoryResp.StatementBean> list, boolean z, WalletBalanceHistoryResp.TopUpBtn topUpBtn);

        void onBalanceMoreDataSuccessful(List<WalletBalanceHistoryResp.StatementBean> list, boolean z);

        void onBalanceOptionSuccessful(List<WalletBalanceOption> list);

        void onNetworkError();
    }
}
