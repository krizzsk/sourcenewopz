package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.didi.payment.wallet.global.model.resp.CsHistoryListResp;

public class WalletTopupHistoryContract {

    public interface Presenter {
        void handleBackClick();

        void handleItemClick(CsHistoryItem csHistoryItem);

        void loadHistoryData(boolean z);

        void loadNextPage();
    }

    public interface View {
        void appendHistoryItem(CsHistoryListResp.DataModel dataModel);

        void clearHistoryItem();

        void dismissLoadingDialog();

        void showEmptyView(int i);

        void showLoadingDialog();
    }
}
