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
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/ui/ConfirmPasswordUI$onConfirm$callback$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.ConfirmPasswordUI$onConfirm$callback$1 */
/* compiled from: ICardPwdUI.kt */
public final class ConfirmPasswordUI$onConfirm$callback$1 implements RpcService.Callback<PaySecureResponse<String>> {
    final /* synthetic */ CardPwdManagerFragment $cardFragment;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ IConfirmLoading $loading;
    final /* synthetic */ ConfirmPasswordUI this$0;

    ConfirmPasswordUI$onConfirm$callback$1(ConfirmPasswordUI confirmPasswordUI, CardPwdManagerFragment cardPwdManagerFragment, IConfirmLoading iConfirmLoading, Fragment fragment) {
        this.this$0 = confirmPasswordUI;
        this.$cardFragment = cardPwdManagerFragment;
        this.$loading = iConfirmLoading;
        this.$fragment = fragment;
    }

    public void onSuccess(PaySecureResponse<String> paySecureResponse) {
        EncryptPassword encryptPassword;
        EncryptPassword encryptPassword2;
        String str = null;
        Integer valueOf = paySecureResponse != null ? Integer.valueOf(paySecureResponse.getErrno()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            PrepaidCardRequest access$getRequest$p = this.this$0.f50413c;
            CardPwdManagerFragment cardPwdManagerFragment = this.$cardFragment;
            String cardId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getCardId() : null;
            CardPwdManagerFragment cardPwdManagerFragment2 = this.$cardFragment;
            String scene = cardPwdManagerFragment2 != null ? cardPwdManagerFragment2.getScene() : null;
            CardPwdManagerFragment cardPwdManagerFragment3 = this.$cardFragment;
            if (cardPwdManagerFragment3 != null) {
                str = cardPwdManagerFragment3.getSessionId();
            }
            access$getRequest$p.activateCard(cardId, scene, str, new ConfirmPasswordUI$onConfirm$callback$1$onSuccess$1(this));
        } else if (valueOf != null && valueOf.intValue() == 500) {
            PrepaidCardRequest access$getRequest$p2 = this.this$0.f50413c;
            CardPwdManagerFragment cardPwdManagerFragment4 = this.$cardFragment;
            String cardId2 = cardPwdManagerFragment4 != null ? cardPwdManagerFragment4.getCardId() : null;
            CardPwdManagerFragment cardPwdManagerFragment5 = this.$cardFragment;
            String encryptedPwdString = (cardPwdManagerFragment5 == null || (encryptPassword2 = cardPwdManagerFragment5.getEncryptPassword()) == null) ? null : encryptPassword2.getEncryptedPwdString();
            CardPwdManagerFragment cardPwdManagerFragment6 = this.$cardFragment;
            String encryptKey = (cardPwdManagerFragment6 == null || (encryptPassword = cardPwdManagerFragment6.getEncryptPassword()) == null) ? null : encryptPassword.getEncryptKey();
            CardPwdManagerFragment cardPwdManagerFragment7 = this.$cardFragment;
            String sessionId = cardPwdManagerFragment7 != null ? cardPwdManagerFragment7.getSessionId() : null;
            CardPwdManagerFragment cardPwdManagerFragment8 = this.$cardFragment;
            if (cardPwdManagerFragment8 != null) {
                str = cardPwdManagerFragment8.getScene();
            }
            access$getRequest$p2.setCardPassword(cardId2, encryptedPwdString, encryptKey, sessionId, str, this);
        } else if (valueOf != null && valueOf.intValue() == 140002) {
            IConfirmLoading iConfirmLoading = this.$loading;
            if (iConfirmLoading != null) {
                iConfirmLoading.stopLoading();
            }
            ToastUtil.INSTANCE.showError(this.$fragment.getContext(), paySecureResponse.getErrmsg());
            IActiveCardListener activeListener = CardPwdManager.INSTANCE.getActiveListener();
            if (activeListener != null) {
                activeListener.onResult(3);
            }
            CardPwdManager.INSTANCE.finishActivity(this.$fragment);
        } else {
            IConfirmLoading iConfirmLoading2 = this.$loading;
            if (iConfirmLoading2 != null) {
                iConfirmLoading2.stopLoading();
            }
            ToastUtil.INSTANCE.showError(this.$fragment.getContext(), paySecureResponse != null ? paySecureResponse.getErrmsg() : null);
            TrackerManager.Companion companion = TrackerManager.Companion;
            if (paySecureResponse != null) {
                str = paySecureResponse.getErrmsg();
            }
            companion.trackPrepaidLast4No("fin_prepaidcard_setpassword_err", 2, 1, "", str);
        }
    }

    public void onFailure(IOException iOException) {
        IConfirmLoading iConfirmLoading = this.$loading;
        if (iConfirmLoading != null) {
            iConfirmLoading.stopLoading();
        }
        IActiveCardListener activeListener = CardPwdManager.INSTANCE.getActiveListener();
        if (activeListener != null) {
            activeListener.onResult(2);
        }
    }
}
