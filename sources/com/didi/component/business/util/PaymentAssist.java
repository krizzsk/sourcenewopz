package com.didi.component.business.util;

import com.didi.travel.psnger.model.response.EstimateItem;

@Deprecated
public class PaymentAssist {
    public EstimateItem mCarEstimateItem;
    public String mSelectPayments;
    public boolean showUpatePhone;

    private static class PaymentAssistHolder {
        /* access modifiers changed from: private */
        public static final PaymentAssist INSTANCE = new PaymentAssist();

        private PaymentAssistHolder() {
        }
    }

    private PaymentAssist() {
        this.showUpatePhone = true;
    }

    public static PaymentAssist getInstance() {
        return PaymentAssistHolder.INSTANCE;
    }
}
