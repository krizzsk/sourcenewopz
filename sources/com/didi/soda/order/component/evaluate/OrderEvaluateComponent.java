package com.didi.soda.order.component.evaluate;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;

public class OrderEvaluateComponent extends MvpComponent<OrderEvaluateView, OrderEvaluatePresenter> {

    /* renamed from: a */
    private OrderEvaluatePresenter f43387a;

    public OrderEvaluateComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void goBack() {
        this.f43387a.closePage(false, (OrderEvaluationResultEntity) null);
    }

    /* access modifiers changed from: protected */
    public OrderEvaluateView onCreateView() {
        return new OrderEvaluateView();
    }

    /* access modifiers changed from: protected */
    public OrderEvaluatePresenter onCreatePresenter() {
        OrderEvaluatePresenter orderEvaluatePresenter = new OrderEvaluatePresenter();
        this.f43387a = orderEvaluatePresenter;
        return orderEvaluatePresenter;
    }
}
