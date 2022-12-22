package com.didiglobal.pay.paysecure.p204ui.fragment;

import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.base.AbsPaySecureBaseActivity;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.didiglobal.pay.paysecure.p204ui.view.CommonBottomDialog;
import com.didiglobal.pay.paysecure.p204ui.view.ConfirmDialogCallback;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment$showConfirmDialog$1", "Lcom/didiglobal/pay/paysecure/ui/view/ConfirmDialogCallback;", "onCancelClicked", "", "dialog", "Lcom/didiglobal/pay/paysecure/ui/view/CommonBottomDialog;", "onConfirmClicked", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$showConfirmDialog$1 */
/* compiled from: CreatePayPwdFragment.kt */
public final class CreatePayPwdFragment$showConfirmDialog$1 implements ConfirmDialogCallback {
    final /* synthetic */ CreatePayPwdFragment this$0;

    CreatePayPwdFragment$showConfirmDialog$1(CreatePayPwdFragment createPayPwdFragment) {
        this.this$0 = createPayPwdFragment;
    }

    public void onConfirmClicked(CommonBottomDialog commonBottomDialog) {
        if (commonBottomDialog != null) {
            commonBottomDialog.dismiss();
        }
        SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
        if (setPwdResultListener != null) {
            setPwdResultListener.onFailure("cancel", "");
        }
        PayPwdResultListener pwdResultListener = PaySecure.INSTANCE.getPwdResultListener();
        if (pwdResultListener != null) {
            pwdResultListener.onFailure("cancel", "");
        }
        new OmegaUtil("ibt_password_give_up_confirm_ck").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(this.this$0.getSourcePageId())).send();
        AbsPaySecureBaseActivity baseActivity = this.this$0.getBaseActivity();
        if (baseActivity != null) {
            baseActivity.finish();
        }
    }

    public void onCancelClicked(CommonBottomDialog commonBottomDialog) {
        if (commonBottomDialog != null) {
            commonBottomDialog.dismiss();
        }
    }
}
