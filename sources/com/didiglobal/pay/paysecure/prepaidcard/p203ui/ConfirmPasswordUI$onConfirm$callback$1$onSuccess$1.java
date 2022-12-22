package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import android.content.Context;
import android.content.Intent;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.webview.BaseWebActivity;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.IActiveCardListener;
import com.didiglobal.pay.paysecure.prepaidcard.IConfirmLoading;
import com.didiglobal.pay.paysecure.prepaidcard.TrackerManager;
import com.didiglobal.pay.paysecure.prepaidcard.resp.ActiveCardResp;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/ui/ConfirmPasswordUI$onConfirm$callback$1$onSuccess$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/ActiveCardResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.ConfirmPasswordUI$onConfirm$callback$1$onSuccess$1 */
/* compiled from: ICardPwdUI.kt */
public final class ConfirmPasswordUI$onConfirm$callback$1$onSuccess$1 implements RpcService.Callback<PaySecureResponse<ActiveCardResp>> {
    final /* synthetic */ ConfirmPasswordUI$onConfirm$callback$1 this$0;

    ConfirmPasswordUI$onConfirm$callback$1$onSuccess$1(ConfirmPasswordUI$onConfirm$callback$1 confirmPasswordUI$onConfirm$callback$1) {
        this.this$0 = confirmPasswordUI$onConfirm$callback$1;
    }

    public void onSuccess(PaySecureResponse<ActiveCardResp> paySecureResponse) {
        String linkUrl;
        IConfirmLoading iConfirmLoading = this.this$0.$loading;
        if (iConfirmLoading != null) {
            iConfirmLoading.stopLoading();
        }
        if (paySecureResponse == null || paySecureResponse.getErrno() != 0) {
            ToastUtil.INSTANCE.showError(this.this$0.$fragment.getContext(), paySecureResponse != null ? paySecureResponse.getErrmsg() : null);
            IActiveCardListener activeListener = CardPwdManager.INSTANCE.getActiveListener();
            if (activeListener != null) {
                activeListener.onResult(2);
            }
            TrackerManager.Companion.trackActiveError();
            return;
        }
        ToastUtil.INSTANCE.showSuccess(this.this$0.$fragment.getContext(), (int) R.string.Fintech_Payment_Password_Activated_cards_luPJ);
        ActiveCardResp data = paySecureResponse.getData();
        if (!(data == null || (linkUrl = data.getLinkUrl()) == null)) {
            DRouter.build('d' + linkUrl).start(this.this$0.$fragment.getContext());
        }
        IActiveCardListener activeListener2 = CardPwdManager.INSTANCE.getActiveListener();
        if (activeListener2 != null) {
            activeListener2.onResult(1);
        }
        CardPwdManager.INSTANCE.finishActivity(this.this$0.$fragment);
        Intent intent = new Intent();
        intent.setAction(BaseWebActivity.ACTION_INTENT_BROADCAST_CLOSE);
        Context context = this.this$0.$fragment.getContext();
        if (context != null) {
            context.sendBroadcast(intent);
        }
        TrackerManager.Companion.trackActiveSuccess();
    }

    public void onFailure(IOException iOException) {
        IConfirmLoading iConfirmLoading = this.this$0.$loading;
        if (iConfirmLoading != null) {
            iConfirmLoading.stopLoading();
        }
        IActiveCardListener activeListener = CardPwdManager.INSTANCE.getActiveListener();
        if (activeListener != null) {
            activeListener.onResult(2);
        }
    }
}
