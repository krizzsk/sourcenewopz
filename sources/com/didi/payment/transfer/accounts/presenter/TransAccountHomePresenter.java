package com.didi.payment.transfer.accounts.presenter;

import android.content.Context;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.transfer.accounts.ITransAccountHomeView;
import com.didi.payment.transfer.common.AbsTransRpcSvrCallback;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.payment.transfer.net.TransBaseResp;
import com.didi.payment.transfer.net.TransferBizModel;
import java.io.IOException;

public class TransAccountHomePresenter extends ITransAccountHomePresenter {

    /* renamed from: a */
    private PayEventPublisher.OnEventListener<PayEventPublisher.NullEvent> f31301a = new PayEventPublisher.OnEventListener<PayEventPublisher.NullEvent>() {
        public void onEvent(String str, PayEventPublisher.NullEvent nullEvent) {
            if (PayEventKeys.FragmentForward.EVENT_FORWARD_TO_ADDNEW_ACCOUNT.equalsIgnoreCase(str)) {
                ((ITransAccountHomeView) TransAccountHomePresenter.this.mPageView).toNewAccountPage();
            }
        }
    };

    public TransAccountHomePresenter(Context context, ITransAccountHomeView iTransAccountHomeView) {
        super(context, iTransAccountHomeView);
    }

    public void onAdd() {
        super.onAdd();
        PayEventPublisher.getPublisher().subscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_ADDNEW_ACCOUNT, this.f31301a);
    }

    public void onRemove() {
        super.onRemove();
        PayEventPublisher.getPublisher().unsubscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_ADDNEW_ACCOUNT, this.f31301a);
    }

    public boolean loadTransferAccountRecords(int i) {
        showPageLoadding();
        TransferBizModel.getInstance(getContext()).loadHistoryTransAccounts(i, 0, 50, new AbsTransRpcSvrCallback<TransAccountRecordResp>(getContext(), false) {
            public void onHandleSuccess(TransAccountRecordResp transAccountRecordResp) {
                if (!TransBaseResp.isValid(transAccountRecordResp)) {
                    ((ITransAccountHomeView) TransAccountHomePresenter.this.mPageView).onHistoryDataLoadFail();
                } else {
                    ((ITransAccountHomeView) TransAccountHomePresenter.this.mPageView).onHistoryDataLoaded(transAccountRecordResp.data == null ? null : transAccountRecordResp.data.transAccounts);
                }
            }

            public void onHandleFailure(IOException iOException) {
                ((ITransAccountHomeView) TransAccountHomePresenter.this.mPageView).onHistoryDataLoadFail();
            }

            public void onTaskFinish() {
                TransAccountHomePresenter.this.dismissPageLoadding();
            }
        });
        return false;
    }
}
