package com.didi.soda.order.page.evaluationdetail;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class OrderEvaluateDetailPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private OrderEvaluateDetailPage f43531a;

    public OrderEvaluateDetailPage_ViewBinding(OrderEvaluateDetailPage orderEvaluateDetailPage, View view) {
        this.f43531a = orderEvaluateDetailPage;
        orderEvaluateDetailPage.mEvaluateDetailContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_order_evaluate_detail_container, "field 'mEvaluateDetailContainer'", FrameLayout.class);
    }

    public void unbind() {
        OrderEvaluateDetailPage orderEvaluateDetailPage = this.f43531a;
        if (orderEvaluateDetailPage != null) {
            this.f43531a = null;
            orderEvaluateDetailPage.mEvaluateDetailContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
