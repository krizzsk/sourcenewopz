package com.didi.payment.transfer.accounts.presenter;

import android.content.Context;
import com.didi.payment.transfer.accounts.ITransAccountHomeView;
import com.didi.payment.transfer.common.AbsTransBasePresenter;

public abstract class ITransAccountHomePresenter extends AbsTransBasePresenter<ITransAccountHomeView> {
    public abstract boolean loadTransferAccountRecords(int i);

    public ITransAccountHomePresenter(Context context, ITransAccountHomeView iTransAccountHomeView) {
        super(context, iTransAccountHomeView);
    }
}
