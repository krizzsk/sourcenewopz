package com.didiglobal.pay.paysecure.p204ui.fragment;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$verifyPwdCallback$1$onSuccess$1 */
/* compiled from: CreatePayPwdFragment.kt */
final class CreatePayPwdFragment$verifyPwdCallback$1$onSuccess$1 implements Runnable {
    final /* synthetic */ CreatePayPwdFragment$verifyPwdCallback$1 this$0;

    CreatePayPwdFragment$verifyPwdCallback$1$onSuccess$1(CreatePayPwdFragment$verifyPwdCallback$1 createPayPwdFragment$verifyPwdCallback$1) {
        this.this$0 = createPayPwdFragment$verifyPwdCallback$1;
    }

    public final void run() {
        CreatePayPwdFragment.access$getMInputPwdView$p(this.this$0.this$0).reset();
    }
}
