package com.didiglobal.pay.paysecure.prepaidcard;

import android.app.Dialog;
import androidx.fragment.app.FragmentManager;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.prepaidcard.KeyboardUtil;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$onViewCreated$4$onInputDone$2", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CommonPwdDialog.kt */
public final class CommonPwdDialog$onViewCreated$4$onInputDone$2 implements RpcService.Callback<PaySecureResponse<Object>> {
    final /* synthetic */ CommonPwdDialog$onViewCreated$4 this$0;

    CommonPwdDialog$onViewCreated$4$onInputDone$2(CommonPwdDialog$onViewCreated$4 commonPwdDialog$onViewCreated$4) {
        this.this$0 = commonPwdDialog$onViewCreated$4;
    }

    public void onSuccess(PaySecureResponse<Object> paySecureResponse) {
        this.this$0.this$0.getCardLoading().hideLoading();
        Integer valueOf = paySecureResponse != null ? Integer.valueOf(paySecureResponse.getErrno()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.this$0.this$0.f50355b = 1;
            this.this$0.$editView.updateUI(0);
            Dialog dialog = this.this$0.this$0.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        } else if (valueOf != null && valueOf.intValue() == 505) {
            this.this$0.this$0.f50355b = 0;
            this.this$0.$editView.showError(new CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$1(this, paySecureResponse));
            KeyboardUtil.Companion companion = KeyboardUtil.Companion;
            CommonPwdEditView commonPwdEditView = this.this$0.$editView;
            Intrinsics.checkExpressionValueIsNotNull(commonPwdEditView, "editView");
            companion.showKeyboard(commonPwdEditView, 500);
            TrackerManager.Companion.trackInputCardPwdError(paySecureResponse.getErrmsg());
        } else if (valueOf != null && valueOf.intValue() == 140005) {
            BottomDialog bottomDialog = new BottomDialog(paySecureResponse.getErrmsg(), new CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$dialog$1(this));
            FragmentManager fragmentManager = this.this$0.this$0.getFragmentManager();
            if (fragmentManager != null) {
                bottomDialog.show(fragmentManager, "");
                this.this$0.$editView.postDelayed(new C17004xd513e6b7(this, bottomDialog), 300);
            }
            TrackerManager.Companion.trackInputCardPwdLimit();
        }
    }

    public void onFailure(IOException iOException) {
        this.this$0.this$0.getCardLoading().hideLoading();
        this.this$0.this$0.f50355b = 0;
    }
}
