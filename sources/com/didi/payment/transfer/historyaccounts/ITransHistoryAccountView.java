package com.didi.payment.transfer.historyaccounts;

import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.common.IPageView;
import java.util.List;

public interface ITransHistoryAccountView extends IPageView {
    void updateHistoryTransAccount(List<NNPayAccount> list);
}
