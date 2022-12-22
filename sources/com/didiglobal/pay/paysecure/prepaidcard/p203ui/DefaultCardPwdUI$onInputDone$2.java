package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import androidx.fragment.app.Fragment;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManagerFragment;
import com.didiglobal.pay.paysecure.prepaidcard.IPasswordCallback;
import com.didiglobal.pay.paysecure.prepaidcard.TrackerManager;
import com.didiglobal.pay.paysecure.prepaidcard.loading.LineLoading;
import com.didiglobal.pay.paysecure.prepaidcard.resp.VerifyCardNoResp;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/ui/DefaultCardPwdUI$onInputDone$2", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.DefaultCardPwdUI$onInputDone$2 */
/* compiled from: ICardPwdUI.kt */
public final class DefaultCardPwdUI$onInputDone$2 implements RpcService.Callback<PaySecureResponse<VerifyCardNoResp>> {
    final /* synthetic */ IPasswordCallback $callback;
    final /* synthetic */ CardPwdManagerFragment $cardFragment;
    final /* synthetic */ Fragment $fragment;

    DefaultCardPwdUI$onInputDone$2(CardPwdManagerFragment cardPwdManagerFragment, IPasswordCallback iPasswordCallback, Fragment fragment) {
        this.$cardFragment = cardPwdManagerFragment;
        this.$callback = iPasswordCallback;
        this.$fragment = fragment;
    }

    public void onSuccess(PaySecureResponse<VerifyCardNoResp> paySecureResponse) {
        LineLoading cardLoading;
        CardPwdManagerFragment cardPwdManagerFragment = this.$cardFragment;
        if (!(cardPwdManagerFragment == null || (cardLoading = cardPwdManagerFragment.getCardLoading()) == null)) {
            cardLoading.hideLoading();
        }
        if (paySecureResponse == null || paySecureResponse.getErrno() != 0) {
            String str = null;
            ToastUtil.INSTANCE.showError(this.$fragment.getContext(), paySecureResponse != null ? paySecureResponse.getErrmsg() : null);
            IPasswordCallback iPasswordCallback = this.$callback;
            if (iPasswordCallback != null) {
                String string = this.$fragment.getString(R.string.Fintech_Payment_management_Incorrect_input_LSET);
                Intrinsics.checkExpressionValueIsNotNull(string, "fragment.getString(R.str…ent_Incorrect_input_LSET)");
                iPasswordCallback.onFail(1, string);
            }
            TrackerManager.Companion companion = TrackerManager.Companion;
            if (paySecureResponse != null) {
                str = paySecureResponse.getErrmsg();
            }
            companion.trackLast4NoError(str);
            return;
        }
        IPasswordCallback iPasswordCallback2 = this.$callback;
        if (iPasswordCallback2 != null) {
            iPasswordCallback2.onSuccess(1, new DefaultCardPwdUI$onInputDone$2$onSuccess$1(this));
        }
    }

    public void onFailure(IOException iOException) {
        LineLoading cardLoading;
        CardPwdManagerFragment cardPwdManagerFragment = this.$cardFragment;
        if (!(cardPwdManagerFragment == null || (cardLoading = cardPwdManagerFragment.getCardLoading()) == null)) {
            cardLoading.hideLoading();
        }
        IPasswordCallback iPasswordCallback = this.$callback;
        if (iPasswordCallback != null) {
            String string = this.$fragment.getString(R.string.Fintech_Payment_management_Incorrect_input_LSET);
            Intrinsics.checkExpressionValueIsNotNull(string, "fragment.getString(R.str…ent_Incorrect_input_LSET)");
            iPasswordCallback.onFail(1, string);
        }
    }
}
