package com.didi.soda.order.page.debtpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.order.component.debtpay.DebtOrderPayComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"debtOrderPayPage"})
public class DebtOrderPayPage extends CustomerPage {

    /* renamed from: a */
    private DebtOrderPayComponent f43526a;
    @BindView(18185)
    FrameLayout mPayInfoContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public DebtOrderPayPage() {
        DiRouter.registerHub("debtOrderPayPage", this);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_order_pay_info, viewGroup, false);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        DebtOrderPayComponent debtOrderPayComponent = new DebtOrderPayComponent(this.mPayInfoContainer);
        this.f43526a = debtOrderPayComponent;
        addComponent(debtOrderPayComponent);
    }

    public void onPageResult(Bundle bundle) {
        DebtOrderPayComponent debtOrderPayComponent;
        super.onPageResult(bundle);
        if (bundle != null && (debtOrderPayComponent = this.f43526a) != null) {
            debtOrderPayComponent.onPageResult(bundle);
        }
    }

    public boolean onHandleBack() {
        DebtOrderPayComponent debtOrderPayComponent = this.f43526a;
        if (debtOrderPayComponent != null) {
            return debtOrderPayComponent.onHandleBack();
        }
        return super.onHandleBack();
    }

    public ControllerChangeHandler getPushHandler() {
        return new DebtOrderPayChangeHandler(false);
    }

    public ControllerChangeHandler getPopHandler() {
        return new DebtOrderPayChangeHandler(false);
    }
}
