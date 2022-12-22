package com.didi.payment.kycservice.key.create.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.kycservice.widget.NewPixInputView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/payment/kycservice/key/create/fragment/CreateKeyByEmailFragment$initListener$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateKeyByEmailFragment.kt */
public final class CreateKeyByEmailFragment$initListener$3 implements TextWatcher {
    final /* synthetic */ CreateKeyByEmailFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    CreateKeyByEmailFragment$initListener$3(CreateKeyByEmailFragment createKeyByEmailFragment) {
        this.this$0 = createKeyByEmailFragment;
    }

    public void afterTextChanged(Editable editable) {
        TextView btnContinue = this.this$0.getBtnContinue();
        KycRegisterUtils kycRegisterUtils = KycRegisterUtils.INSTANCE;
        NewPixInputView access$getInputViewNew$p = this.this$0.f30651b;
        if (access$getInputViewNew$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputViewNew");
            access$getInputViewNew$p = null;
        }
        btnContinue.setEnabled(kycRegisterUtils.checkEmail(access$getInputViewNew$p.getInputStr()));
    }
}
