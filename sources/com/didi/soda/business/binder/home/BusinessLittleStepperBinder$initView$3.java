package com.didi.soda.business.binder.home;

import android.view.View;
import com.didi.soda.business.widget.BusinessLittleStepper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/business/binder/home/BusinessLittleStepperBinder$initView$3", "Lcom/didi/soda/business/widget/BusinessLittleStepper$StepperListener;", "onRecovery", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessLittleStepperBinder.kt */
public final class BusinessLittleStepperBinder$initView$3 implements BusinessLittleStepper.StepperListener {
    final /* synthetic */ BusinessLittleStepperBinder this$0;

    BusinessLittleStepperBinder$initView$3(BusinessLittleStepperBinder businessLittleStepperBinder) {
        this.this$0 = businessLittleStepperBinder;
    }

    public void onRecovery() {
        View access$getMask$p = this.this$0.f39354f;
        if (access$getMask$p != null) {
            access$getMask$p.setVisibility(8);
        }
        LogUtil.m29100d(this.this$0.f39349a, "binder onRecovery");
    }
}
