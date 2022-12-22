package com.didiglobal.pay.paysecure.prepaidcard;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didiglobal.pay.paysecure.prepaidcard.loading.ILoading;
import com.didiglobal.pay.paysecure.prepaidcard.loading.LineLoading;
import com.didiglobal.pay.paysecure.prepaidcard.net.PrepaidCardRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$onViewCreated$4", "Lcom/didiglobal/pay/paysecure/prepaidcard/InputListener;", "onInputChange", "", "onInputDone", "text", "", "onInputEmpty", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CommonPwdDialog.kt */
public final class CommonPwdDialog$onViewCreated$4 implements InputListener {
    final /* synthetic */ CommonPwdEditView $editView;
    final /* synthetic */ TextView $tvDesc;
    final /* synthetic */ View $vLoading;
    final /* synthetic */ CommonPwdDialog this$0;

    public void onInputChange() {
    }

    public void onInputEmpty() {
    }

    CommonPwdDialog$onViewCreated$4(CommonPwdDialog commonPwdDialog, View view, CommonPwdEditView commonPwdEditView, TextView textView) {
        this.this$0 = commonPwdDialog;
        this.$vLoading = view;
        this.$editView = commonPwdEditView;
        this.$tvDesc = textView;
    }

    public void onInputDone(String str) {
        this.this$0.getEncryptPassword().prepareEncrypt(str != null ? str : "");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            LineLoading cardLoading = this.this$0.getCardLoading();
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            ILoading.DefaultImpls.showLoading$default(cardLoading, activity, this.$vLoading, (String) null, 4, (Object) null);
        }
        new PrepaidCardRequest().verifyPassword(this.this$0.f50357d, this.this$0.getEncryptPassword().getEncryptedPwdString(), this.this$0.f50358e, this.this$0.f50359f, this.this$0.f50360g, this.this$0.getEncryptPassword().getEncryptKey(), "2", "", new CommonPwdDialog$onViewCreated$4$onInputDone$2(this));
        TrackerManager.Companion.trackInputCardPwdDone();
    }
}
