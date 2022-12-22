package com.didi.payment.kycservice.kyc.fragment;

import androidx.lifecycle.Observer;
import com.didi.payment.kycservice.kyc.SignUpVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* compiled from: LiveData.kt */
public final class IDTypeFragment$subscribeUi$$inlined$observe$3<T> implements Observer<T> {
    final /* synthetic */ IDTypeFragment this$0;

    public IDTypeFragment$subscribeUi$$inlined$observe$3(IDTypeFragment iDTypeFragment) {
        this.this$0 = iDTypeFragment;
    }

    public final void onChanged(T t) {
        Boolean bool = (Boolean) t;
        SignUpVM access$getPixSignUpVM$p = this.this$0.f30806f;
        if (access$getPixSignUpVM$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            access$getPixSignUpVM$p = null;
        }
        access$getPixSignUpVM$p.isLoading().setValue(bool);
    }
}
