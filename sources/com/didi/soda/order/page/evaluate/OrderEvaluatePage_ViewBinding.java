package com.didi.soda.order.page.evaluate;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class OrderEvaluatePage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private OrderEvaluatePage f43529a;

    public OrderEvaluatePage_ViewBinding(OrderEvaluatePage orderEvaluatePage, View view) {
        this.f43529a = orderEvaluatePage;
        orderEvaluatePage.mEvaluateContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_order_evaluate_container, "field 'mEvaluateContainer'", FrameLayout.class);
    }

    public void unbind() {
        OrderEvaluatePage orderEvaluatePage = this.f43529a;
        if (orderEvaluatePage != null) {
            this.f43529a = null;
            orderEvaluatePage.mEvaluateContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
