package com.didi.payment.transfer.historyaccounts.presenter;

import android.content.Context;
import com.didi.payment.transfer.common.AbsTransBasePresenter;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.historyaccounts.ITransHistoryAccountView;

public abstract class ITransHistoryAccountPresenter extends AbsTransBasePresenter<ITransHistoryAccountView> {
    public abstract boolean loadTransferAccountRecords(int i);

    public abstract void toConfirmAmount(IConfirmTransferInfo iConfirmTransferInfo);

    public ITransHistoryAccountPresenter(Context context, ITransHistoryAccountView iTransHistoryAccountView) {
        super(context, iTransHistoryAccountView);
    }
}
