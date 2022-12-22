package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.WalletBalanceInterestResp;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;

public interface WalletNewBalanceInterestContract {

    public interface Presenter extends WalletCommonContract.Presenter {
        void onChartItemSelectedInDay(int i);

        void onChartItemSelectedInMonth(int i);

        void onChartItemSelectedInTotal(int i);

        void onInterestDayClicked();

        void onInterestMonthClicked();

        void onInterestTotalClicked();
    }

    public interface View extends WalletCommonContract.ILoadingView {
        int getType();

        void showChartInDay(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr);

        void showChartInMonth(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr);

        void showChartInTotal(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr);

        void showEmptyPage(WalletBalanceInterestResp.MetaInfo metaInfo);

        void showErrorPage();

        void showInterestInfo(WalletBalanceInterestResp.InterestInfo interestInfo, String str);

        void showIntroduction(WalletBalanceInterestResp.MetaInfo metaInfo);

        void updateMetaData(WalletBalanceInterestResp.MetaInfo metaInfo);
    }
}
