package com.didi.payment.transfer.records.presenter;

import android.content.Context;
import com.didi.payment.transfer.common.AbsTransBasePresenter;
import com.didi.payment.transfer.records.ITransRecordPageView;
import com.didi.payment.transfer.records.TransHistoryListResp;

public abstract class ITransRecordPresenter extends AbsTransBasePresenter<ITransRecordPageView> {
    public abstract void handleBackClick();

    public abstract void handleItemClick(TransHistoryListResp.HistoryItem historyItem);

    public abstract void loadHistoryData(boolean z);

    public abstract void loadNextPage();

    public ITransRecordPresenter(Context context, ITransRecordPageView iTransRecordPageView) {
        super(context, iTransRecordPageView);
    }
}
