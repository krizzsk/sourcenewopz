package com.didi.soda.order.component.evaluatedetail;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class OrderEvaluateDetailComponent extends MvpComponent<OrderEvaluateDetailView, OrderEvaluateDetailPresenter> {
    public OrderEvaluateDetailComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public OrderEvaluateDetailView onCreateView() {
        return new OrderEvaluateDetailView();
    }

    /* access modifiers changed from: protected */
    public OrderEvaluateDetailPresenter onCreatePresenter() {
        return new OrderEvaluateDetailPresenter();
    }
}
