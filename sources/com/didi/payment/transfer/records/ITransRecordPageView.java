package com.didi.payment.transfer.records;

import com.didi.payment.transfer.common.IPageView;
import com.didi.payment.transfer.records.TransHistoryListResp;
import com.didi.payment.transfer.records.presenter.ITransRecordPresenter;

public interface ITransRecordPageView extends IPageView<ITransRecordPresenter> {
    void appendHistoryItem(TransHistoryListResp.DataModel dataModel);

    void loadHistoryRecords();

    void pageFinish();

    void showEmptyView(int i);
}
