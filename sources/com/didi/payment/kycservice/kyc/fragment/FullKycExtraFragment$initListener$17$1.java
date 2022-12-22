package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.widget.NewPixInputView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/FullKycExtraFragment$initListener$17$1", "Lcom/didi/drouter/router/RouterCallback$ActivityCallback;", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FullKycExtraFragment.kt */
public final class FullKycExtraFragment$initListener$17$1 extends RouterCallback.ActivityCallback {
    final /* synthetic */ String $phone;
    final /* synthetic */ FullKycExtraFragment this$0;

    FullKycExtraFragment$initListener$17$1(FullKycExtraFragment fullKycExtraFragment, String str) {
        this.this$0 = fullKycExtraFragment;
        this.$phone = str;
    }

    public void onActivityResult(int i, Intent intent) {
        String stringExtra;
        String str = "";
        if (!(intent == null || (stringExtra = intent.getStringExtra("result")) == null)) {
            str = stringExtra;
        }
        if (!TextUtils.isEmpty(str)) {
            NewPixInputView access$getMCityInput$p = this.this$0.f30783m;
            NewPixInputView newPixInputView = null;
            if (access$getMCityInput$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                access$getMCityInput$p = null;
            }
            access$getMCityInput$p.setInputStr(str);
            Context context = this.this$0.getContext();
            if (context != null) {
                String str2 = this.$phone;
                FullKycExtraFragment fullKycExtraFragment = this.this$0;
                KycSPUtils.Companion companion = KycSPUtils.Companion;
                Intrinsics.checkNotNullExpressionValue(str2, "phone");
                NewPixInputView access$getMCityInput$p2 = fullKycExtraFragment.f30783m;
                if (access$getMCityInput$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                } else {
                    newPixInputView = access$getMCityInput$p2;
                }
                companion.putCity(context, str2, newPixInputView.getInputStr());
            }
        }
    }
}
