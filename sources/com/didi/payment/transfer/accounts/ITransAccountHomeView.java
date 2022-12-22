package com.didi.payment.transfer.accounts;

import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.common.IPageView;
import java.util.List;

public interface ITransAccountHomeView extends IPageView {
    void onHistoryDataLoadFail();

    void onHistoryDataLoaded(List<NNPayAccount> list);

    void toNewAccountPage();
}
