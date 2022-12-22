package com.didiglobal.pay.paysecure.prepaidcard;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: CommonPwdEditView.kt */
final class CommonPwdEditView$showError$2 implements Runnable {
    final /* synthetic */ Function0 $callback;
    final /* synthetic */ CommonPwdEditView this$0;

    CommonPwdEditView$showError$2(CommonPwdEditView commonPwdEditView, Function0 function0) {
        this.this$0 = commonPwdEditView;
        this.$callback = function0;
    }

    public final void run() {
        this.this$0.setText("");
        this.this$0.updateUI(0);
        this.$callback.invoke();
    }
}
