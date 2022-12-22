package com.didiglobal.pay.paysecure.p204ui.fragment;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.p204ui.view.ErrorDialogCallback;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didiglobal/pay/paysecure/ui/fragment/GateKeeperFragment$getErrorDialogCallback$1", "Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialogCallback;", "onCloseDialog", "", "dialog", "Landroid/app/Dialog;", "onNegativeClicked", "onPositiveClicked", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment$getErrorDialogCallback$1 */
/* compiled from: GateKeeperFragment.kt */
public final class GateKeeperFragment$getErrorDialogCallback$1 implements ErrorDialogCallback {
    final /* synthetic */ GateKeeperFragment this$0;

    public void onCloseDialog(Dialog dialog) {
    }

    GateKeeperFragment$getErrorDialogCallback$1(GateKeeperFragment gateKeeperFragment) {
        this.this$0 = gateKeeperFragment;
    }

    public void onPositiveClicked(Dialog dialog) {
        SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
        if (setPwdResultListener != null) {
            setPwdResultListener.onFailure("gatekeeper_failed", "");
        }
        PayPwdResultListener pwdResultListener = PaySecure.INSTANCE.getPwdResultListener();
        if (pwdResultListener != null) {
            pwdResultListener.onFailure("gatekeeper_failed", "");
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void onNegativeClicked(Dialog dialog) {
        SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
        if (setPwdResultListener != null) {
            setPwdResultListener.onFailure("gatekeeper_failed", "");
        }
        PayPwdResultListener pwdResultListener = PaySecure.INSTANCE.getPwdResultListener();
        if (pwdResultListener != null) {
            pwdResultListener.onFailure("gatekeeper_failed", "");
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
