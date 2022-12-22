package com.didi.soda.order.page.evaluate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.base.pages.changehandler.CustomerVerticalChangeHandler;
import com.didi.soda.order.component.evaluate.OrderEvaluateComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"orderEvaluatePage"})
public class OrderEvaluatePage extends CustomerPage {

    /* renamed from: a */
    OrderEvaluateComponent f43528a;
    @BindView(18179)
    FrameLayout mEvaluateContainer;

    public OrderEvaluatePage() {
        DiRouter.registerHub(RoutePath.ORDER_EVALUATE, this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
    }

    public ControllerChangeHandler getPushHandler() {
        return new CustomerVerticalChangeHandler(false);
    }

    public ControllerChangeHandler getPopHandler() {
        return new CustomerVerticalChangeHandler();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_order_evaluate, viewGroup, false);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        OrderEvaluateComponent orderEvaluateComponent = new OrderEvaluateComponent(this.mEvaluateContainer);
        this.f43528a = orderEvaluateComponent;
        addComponent(orderEvaluateComponent);
    }

    public boolean onHandleBack() {
        OrderEvaluateComponent orderEvaluateComponent = this.f43528a;
        if (orderEvaluateComponent == null) {
            return super.onHandleBack();
        }
        orderEvaluateComponent.goBack();
        return true;
    }
}
