package com.didi.soda.order.page.receipt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.base.pages.changehandler.CustomerVerticalChangeHandler;
import com.didi.soda.order.component.receipt.OrderReceiptComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route(interceptors = {OrderReceiptPageIntercepter.class}, value = {"sendReceiptPage"})
public class SendReceiptPage extends CustomerPage {

    /* renamed from: a */
    FrameLayout f43535a;

    public SendReceiptPage() {
        DiRouter.registerHub(RoutePath.SEND_RECEIPT, this);
    }

    public ControllerChangeHandler getPushHandler() {
        return new CustomerVerticalChangeHandler(false);
    }

    public ControllerChangeHandler getPopHandler() {
        return new CustomerVerticalChangeHandler();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.customer_page_order_receipt, viewGroup, false);
        this.f43535a = frameLayout;
        return frameLayout;
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new OrderReceiptComponent(this.f43535a));
    }
}
