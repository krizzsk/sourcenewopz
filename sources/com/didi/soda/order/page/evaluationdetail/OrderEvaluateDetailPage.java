package com.didi.soda.order.page.evaluationdetail;

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
import com.didi.soda.order.component.evaluatedetail.OrderEvaluateDetailComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"orderEvaluateDetailPage"})
public class OrderEvaluateDetailPage extends CustomerPage {
    @BindView(18180)
    FrameLayout mEvaluateDetailContainer;

    public OrderEvaluateDetailPage() {
        DiRouter.registerHub(RoutePath.ORDER_EVALUATE_DETAIL, this);
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
        return layoutInflater.inflate(R.layout.customer_page_order_evaluate_detail, viewGroup, false);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new OrderEvaluateDetailComponent(this.mEvaluateDetailContainer));
    }
}
