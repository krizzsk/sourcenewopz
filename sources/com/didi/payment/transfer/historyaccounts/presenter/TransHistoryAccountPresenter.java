package com.didi.payment.transfer.historyaccounts.presenter;

import android.content.Context;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.accounts.presenter.TransAccountRecordResp;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.historyaccounts.ITransHistoryAccountView;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.List;

public class TransHistoryAccountPresenter extends ITransHistoryAccountPresenter {
    public TransHistoryAccountPresenter(Context context, ITransHistoryAccountView iTransHistoryAccountView) {
        super(context, iTransHistoryAccountView);
    }

    public boolean loadTransferAccountRecords(int i) {
        ((ITransHistoryAccountView) this.mPageView).onShowPageLoadding();
        TransferBizModel.getInstance(getContext()).loadHistoryTransAccounts(i, 0, 50, new RpcService.Callback<TransAccountRecordResp>() {
            public void onSuccess(TransAccountRecordResp transAccountRecordResp) {
                ((ITransHistoryAccountView) TransHistoryAccountPresenter.this.mPageView).onDismissPageLoadding();
                if (transAccountRecordResp == null || transAccountRecordResp.data == null) {
                    ((ITransHistoryAccountView) TransHistoryAccountPresenter.this.mPageView).updateHistoryTransAccount((List<NNPayAccount>) null);
                } else {
                    ((ITransHistoryAccountView) TransHistoryAccountPresenter.this.mPageView).updateHistoryTransAccount(transAccountRecordResp.data.transAccounts);
                }
            }

            public void onFailure(IOException iOException) {
                ((ITransHistoryAccountView) TransHistoryAccountPresenter.this.mPageView).onShowPageLoadding();
                ((ITransHistoryAccountView) TransHistoryAccountPresenter.this.mPageView).updateHistoryTransAccount((List<NNPayAccount>) null);
            }
        });
        return false;
    }

    public void toConfirmAmount(IConfirmTransferInfo iConfirmTransferInfo) {
        PayEventPublisher.getPublisher().publish(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, iConfirmTransferInfo);
    }
}
