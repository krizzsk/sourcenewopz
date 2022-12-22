package com.didiglobal.pay.paysecure.p204ui.fragment;

import com.didiglobal.pay.paysecure.util.UiUtils;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment$showConfirmDialog$1$onCancelClicked$1 */
/* compiled from: VerifyPayPwdFragment.kt */
final class VerifyPayPwdFragment$showConfirmDialog$1$onCancelClicked$1 implements Runnable {
    final /* synthetic */ VerifyPayPwdFragment$showConfirmDialog$1 this$0;

    VerifyPayPwdFragment$showConfirmDialog$1$onCancelClicked$1(VerifyPayPwdFragment$showConfirmDialog$1 verifyPayPwdFragment$showConfirmDialog$1) {
        this.this$0 = verifyPayPwdFragment$showConfirmDialog$1;
    }

    public final void run() {
        UiUtils.INSTANCE.showKeyboard(this.this$0.this$0.getContext(), VerifyPayPwdFragment.access$getMInputPwdView$p(this.this$0.this$0));
    }
}
