package com.didi.soda.business.widget;

import android.widget.TextView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessLittleStepper.kt */
final class BusinessLittleStepper$setUpAction$onClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BusinessLittleStepper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessLittleStepper$setUpAction$onClick$1(BusinessLittleStepper businessLittleStepper) {
        super(0);
        this.this$0 = businessLittleStepper;
    }

    public final void invoke() {
        LogUtil.m29100d(this.this$0.f39851a, "onUP click");
        if (this.this$0.getNeedExpand()) {
            this.this$0.getCountDownTimer().cancel();
            this.this$0.getCountDownTimer().start();
            this.this$0.expend();
            TextView access$getNumView$p = this.this$0.f39867q;
            TextView textView = null;
            if (access$getNumView$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numView");
                access$getNumView$p = null;
            }
            access$getNumView$p.setText(String.valueOf(this.this$0.getCurrentNum()));
            TextView access$getTv_up_num$p = this.this$0.f39853c;
            if (access$getTv_up_num$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
            } else {
                textView = access$getTv_up_num$p;
            }
            textView.setText(String.valueOf(this.this$0.getCurrentNum()));
        }
    }
}
