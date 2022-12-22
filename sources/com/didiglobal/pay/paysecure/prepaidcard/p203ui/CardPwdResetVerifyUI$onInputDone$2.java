package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.prepaidcard.BottomDialog;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManagerFragment;
import com.didiglobal.pay.paysecure.prepaidcard.IPasswordCallback;
import com.didiglobal.pay.paysecure.prepaidcard.TrackerManager;
import com.didiglobal.pay.paysecure.prepaidcard.loading.LineLoading;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/ui/CardPwdResetVerifyUI$onInputDone$2", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "result", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CardPwdResetVerifyUI$onInputDone$2 */
/* compiled from: CardPwdResetVerifyUI.kt */
public final class CardPwdResetVerifyUI$onInputDone$2 implements RpcService.Callback<PaySecureResponse<Object>> {
    final /* synthetic */ IPasswordCallback $callback;
    final /* synthetic */ CardPwdManagerFragment $cardFragment;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ String $text;

    CardPwdResetVerifyUI$onInputDone$2(CardPwdManagerFragment cardPwdManagerFragment, IPasswordCallback iPasswordCallback, Fragment fragment, String str) {
        this.$cardFragment = cardPwdManagerFragment;
        this.$callback = iPasswordCallback;
        this.$fragment = fragment;
        this.$text = str;
    }

    public void onSuccess(PaySecureResponse<Object> paySecureResponse) {
        LineLoading cardLoading;
        CardPwdManagerFragment cardPwdManagerFragment = this.$cardFragment;
        if (!(cardPwdManagerFragment == null || (cardLoading = cardPwdManagerFragment.getCardLoading()) == null)) {
            cardLoading.hideLoading();
        }
        Integer valueOf = paySecureResponse != null ? Integer.valueOf(paySecureResponse.getErrno()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            IPasswordCallback iPasswordCallback = this.$callback;
            if (iPasswordCallback != null) {
                iPasswordCallback.onSuccess(4, new CardPwdResetVerifyUI$onInputDone$2$onSuccess$1(this));
                return;
            }
            return;
        }
        String str = "";
        if (valueOf != null && valueOf.intValue() == 505) {
            IPasswordCallback iPasswordCallback2 = this.$callback;
            if (iPasswordCallback2 != null) {
                String errmsg = paySecureResponse.getErrmsg();
                if (errmsg != null) {
                    str = errmsg;
                }
                iPasswordCallback2.onFail(4, str);
            }
            TrackerManager.Companion.trackOldPwdVerifyError();
        } else if (valueOf != null && valueOf.intValue() == 140005) {
            BottomDialog bottomDialog = new BottomDialog(paySecureResponse.getErrmsg(), new CardPwdResetVerifyUI$onInputDone$2$onSuccess$dialog$1(this));
            FragmentManager fragmentManager = this.$fragment.getFragmentManager();
            if (fragmentManager != null) {
                bottomDialog.show(fragmentManager, str);
                View view = this.$fragment.getView();
                if (view != null) {
                    view.postDelayed(new C17008x4104c71c(this, bottomDialog), 300);
                }
            }
            TrackerManager.Companion.trackOldPwdLimit();
        }
    }

    public void onFailure(IOException iOException) {
        LineLoading cardLoading;
        CardPwdManagerFragment cardPwdManagerFragment = this.$cardFragment;
        if (cardPwdManagerFragment != null && (cardLoading = cardPwdManagerFragment.getCardLoading()) != null) {
            cardLoading.hideLoading();
        }
    }
}
