package com.didi.soda.bill.component.bill;

import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/bill/component/bill/CustomerBillPresenterV2$showLoading$1", "Lcom/didi/soda/customer/widget/dialog/SodaWindowFactory$DialogKeyBackListener;", "handleBack", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPresenterV2.kt */
public final class CustomerBillPresenterV2$showLoading$1 implements SodaWindowFactory.DialogKeyBackListener {
    final /* synthetic */ CustomerBillPresenterV2 this$0;

    CustomerBillPresenterV2$showLoading$1(CustomerBillPresenterV2 customerBillPresenterV2) {
        this.this$0 = customerBillPresenterV2;
    }

    public boolean handleBack() {
        DialogUtil.hideLoadingDialog();
        this.this$0.getScopeContext().getNavigator().finish();
        return true;
    }
}
