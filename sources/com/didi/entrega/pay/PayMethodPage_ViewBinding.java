package com.didi.entrega.pay;

import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class PayMethodPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PayMethodPage f21003a;

    public PayMethodPage_ViewBinding(PayMethodPage payMethodPage, View view) {
        this.f21003a = payMethodPage;
        payMethodPage.mContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_pay_method_container, "field 'mContainer'", RelativeLayout.class);
    }

    public void unbind() {
        PayMethodPage payMethodPage = this.f21003a;
        if (payMethodPage != null) {
            this.f21003a = null;
            payMethodPage.mContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
