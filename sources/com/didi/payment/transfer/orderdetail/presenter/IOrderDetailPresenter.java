package com.didi.payment.transfer.orderdetail.presenter;

import android.content.Context;
import com.didi.payment.transfer.common.AbsTransBasePresenter;
import com.didi.payment.transfer.orderdetail.ITransOrderDetailView;

public abstract class IOrderDetailPresenter extends AbsTransBasePresenter<ITransOrderDetailView> {

    /* renamed from: a */
    int f31465a = 0;

    /* renamed from: b */
    int f31466b = 1;

    public enum OperationType {
        CANCEL_TRANSFER,
        REMIND_RECIEVER
    }

    public abstract void executeTask();

    public abstract void handleBackClick();

    public abstract void handleEnterHistory();

    public abstract boolean isSupportCountdonw();

    public abstract void onOperationButtonClick(OperationType operationType);

    public abstract void trackOmega(int i);

    public IOrderDetailPresenter(Context context, ITransOrderDetailView iTransOrderDetailView) {
        super(context, iTransOrderDetailView);
    }
}
