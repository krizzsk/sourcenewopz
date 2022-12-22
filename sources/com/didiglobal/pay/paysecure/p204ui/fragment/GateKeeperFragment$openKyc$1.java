package com.didiglobal.pay.paysecure.p204ui.fragment;

import androidx.fragment.app.FragmentActivity;
import com.didiglobal.pay.paysecure.CertificationResultListener;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/ui/fragment/GateKeeperFragment$openKyc$1", "Lcom/didiglobal/pay/paysecure/CertificationResultListener;", "onFailure", "", "status", "", "desc", "onSuccess", "userVerificationParams", "retry", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment$openKyc$1 */
/* compiled from: GateKeeperFragment.kt */
public final class GateKeeperFragment$openKyc$1 implements CertificationResultListener {
    final /* synthetic */ GateKeeperFragment this$0;

    GateKeeperFragment$openKyc$1(GateKeeperFragment gateKeeperFragment) {
        this.this$0 = gateKeeperFragment;
    }

    public void onSuccess(String str) {
        Intrinsics.checkParameterIsNotNull(str, "userVerificationParams");
        OmegaUtil.Companion.trackEvent("ibt_password_secure_open_cert_en");
        this.this$0.m36272a(str);
    }

    public void onFailure(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, "desc");
        new OmegaUtil("ibt_password_secure_open_cert_fail_en").add("status", str).add("desc", str2).send();
        PayPwdResultListener pwdResultListener = PaySecure.INSTANCE.getPwdResultListener();
        if (pwdResultListener != null) {
            pwdResultListener.onFailure(str, "");
        }
        SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
        if (setPwdResultListener != null) {
            setPwdResultListener.onFailure(str, "");
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void retry() {
        OmegaUtil.Companion.trackEvent("ibt_password_secure_open_cert_retry_en");
        this.this$0.m36269a();
    }
}
