package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.didi.payment.wallet.global.model.resp.CsHistoryListResp;

public class WalletStatusHistoryContract {

    public interface Presenter {
        void checkAccountStatus();

        void closeOrder(CsHistoryItem csHistoryItem, int i);

        void destroy();

        void getCancelReason(CsHistoryItem csHistoryItem, int i);

        void gotoPayResultPage();

        void handleBackClick();

        void handleItemClick(CsHistoryItem csHistoryItem, boolean z, int i);

        void loadHistoryData(boolean z, int i);

        void loadNextPage(int i);

        void prepayOrder(CsHistoryItem csHistoryItem, int i);
    }

    public interface View {
        void appendHistoryItem(CsHistoryListResp.DataModel dataModel);

        void clearHistoryItem();

        void dismissLoadingDialog();

        int getCurrentCategory();

        void hideEmptyView();

        void removeItem(int i);

        void showEmptyView(int i);

        void showLoadingDialog();
    }
}
