package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import androidx.fragment.app.Fragment;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManagerFragment;
import com.didiglobal.pay.paysecure.prepaidcard.EncryptPassword;
import com.didiglobal.pay.paysecure.prepaidcard.IActiveCardListener;
import com.didiglobal.pay.paysecure.prepaidcard.IConfirmLoading;
import com.didiglobal.pay.paysecure.prepaidcard.TrackerManager;
import com.didiglobal.pay.paysecure.prepaidcard.net.PrepaidCardRequest;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/ui/CardPwdResetReConfirmUI$onConfirm$callback$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CardPwdResetReConfirmUI$onConfirm$callback$1 */
/* compiled from: CardPwdResetVerifyUI.kt */
public final class CardPwdResetReConfirmUI$onConfirm$callback$1 implements RpcService.Callback<PaySecureResponse<String>> {
    final /* synthetic */ CardPwdManagerFragment $cardFragment;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ IConfirmLoading $loading;
    final /* synthetic */ CardPwdResetReConfirmUI this$0;

    CardPwdResetReConfirmUI$onConfirm$callback$1(CardPwdResetReConfirmUI cardPwdResetReConfirmUI, IConfirmLoading iConfirmLoading, Fragment fragment, CardPwdManagerFragment cardPwdManagerFragment) {
        this.this$0 = cardPwdResetReConfirmUI;
        this.$loading = iConfirmLoading;
        this.$fragment = fragment;
        this.$cardFragment = cardPwdManagerFragment;
    }

    public void onSuccess(PaySecureResponse<String> paySecureResponse) {
        EncryptPassword encryptPassword;
        EncryptPassword encryptPassword2;
        IConfirmLoading iConfirmLoading = this.$loading;
        if (iConfirmLoading != null) {
            iConfirmLoading.stopLoading();
        }
        String str = null;
        Integer valueOf = paySecureResponse != null ? Integer.valueOf(paySecureResponse.getErrno()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            ToastUtil.INSTANCE.showSuccess(this.$fragment.getContext(), (int) R.string.Fintech_Payment_Password_Successfully_modified_Wwog);
            IActiveCardListener activeListener = CardPwdManager.INSTANCE.getActiveListener();
            if (activeListener != null) {
                activeListener.onResult(1);
            }
            CardPwdManager.INSTANCE.finishActivity(this.$fragment);
        } else if (valueOf != null && valueOf.intValue() == 500) {
            PrepaidCardRequest request = this.this$0.getRequest();
            CardPwdManagerFragment cardPwdManagerFragment = this.$cardFragment;
            String cardId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getCardId() : null;
            CardPwdManagerFragment cardPwdManagerFragment2 = this.$cardFragment;
            String encryptedPwdString = (cardPwdManagerFragment2 == null || (encryptPassword2 = cardPwdManagerFragment2.getEncryptPassword()) == null) ? null : encryptPassword2.getEncryptedPwdString();
            CardPwdManagerFragment cardPwdManagerFragment3 = this.$cardFragment;
            String encryptKey = (cardPwdManagerFragment3 == null || (encryptPassword = cardPwdManagerFragment3.getEncryptPassword()) == null) ? null : encryptPassword.getEncryptKey();
            CardPwdManagerFragment cardPwdManagerFragment4 = this.$cardFragment;
            String sessionId = cardPwdManagerFragment4 != null ? cardPwdManagerFragment4.getSessionId() : null;
            CardPwdManagerFragment cardPwdManagerFragment5 = this.$cardFragment;
            if (cardPwdManagerFragment5 != null) {
                str = cardPwdManagerFragment5.getScene();
            }
            request.setCardPassword(cardId, encryptedPwdString, encryptKey, sessionId, str, this);
        } else if (valueOf != null && valueOf.intValue() == 140002) {
            ToastUtil.INSTANCE.showError(this.$fragment.getContext(), paySecureResponse.getErrmsg());
            IActiveCardListener activeListener2 = CardPwdManager.INSTANCE.getActiveListener();
            if (activeListener2 != null) {
                activeListener2.onResult(3);
            }
            CardPwdManager.INSTANCE.finishActivity(this.$fragment);
        } else {
            ToastUtil.INSTANCE.showError(this.$fragment.getContext(), paySecureResponse != null ? paySecureResponse.getErrmsg() : null);
            TrackerManager.Companion companion = TrackerManager.Companion;
            if (paySecureResponse != null) {
                str = paySecureResponse.getErrmsg();
            }
            companion.trackPrepaidLast4No("fin_prepaidcard_newpin_err", (Integer) null, 2, (String) null, str);
        }
    }

    public void onFailure(IOException iOException) {
        IConfirmLoading iConfirmLoading = this.$loading;
        if (iConfirmLoading != null) {
            iConfirmLoading.stopLoading();
        }
    }
}
