package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInfoResp;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;

public interface WalletNewBalanceContract {

    public interface Presenter extends WalletCommonContract.Presenter {
        void onDetailsClicked(String str);

        void onServicesClicked();

        void onTabCashbackClicked();

        void onTabHistoryClicked();

        void onTabInterestClicked();

        void onVerifyNowClicked(String str);
    }

    public interface View extends WalletCommonContract.ILoadingView {
        void showBalanceCallback();

        void showBalanceHistory();

        void showBalanceInterest();

        void showVerifyDialog(AccountFreezeData accountFreezeData);

        void updateContent(WalletBalanceInfoResp.BalanceInfoData balanceInfoData, int i);
    }
}
