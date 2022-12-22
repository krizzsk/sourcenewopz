package com.didi.soda.order.page.debtpay;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class DebtOrderPayPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private DebtOrderPayPage f43527a;

    public DebtOrderPayPage_ViewBinding(DebtOrderPayPage debtOrderPayPage, View view) {
        this.f43527a = debtOrderPayPage;
        debtOrderPayPage.mPayInfoContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_pay_info_container, "field 'mPayInfoContainer'", FrameLayout.class);
    }

    public void unbind() {
        DebtOrderPayPage debtOrderPayPage = this.f43527a;
        if (debtOrderPayPage != null) {
            this.f43527a = null;
            debtOrderPayPage.mPayInfoContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
