package com.didi.entrega.order.debt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.entrega.customer.base.pages.FloatingCustomerPage;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;

@Route({"debtOrderPayPage"})
public class DebtOrderPayPage extends FloatingCustomerPage {

    /* renamed from: a */
    FrameLayout f20875a;

    /* renamed from: b */
    private View f20876b;

    /* renamed from: c */
    private DebtOrderPayComponent f20877c;

    public DebtOrderPayPage() {
        DiRouter.registerHub("debtOrderPayPage", this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f20876b);
        setType(1);
        DebtOrderPayComponent debtOrderPayComponent = new DebtOrderPayComponent(this.f20875a);
        this.f20877c = debtOrderPayComponent;
        addComponent(debtOrderPayComponent);
    }

    public void onPageResult(Bundle bundle) {
        DebtOrderPayComponent debtOrderPayComponent;
        super.onPageResult(bundle);
        if (bundle != null && (debtOrderPayComponent = this.f20877c) != null) {
            debtOrderPayComponent.onPageResult(bundle);
        }
    }

    public boolean onHandleBack() {
        DebtOrderPayComponent debtOrderPayComponent = this.f20877c;
        if (debtOrderPayComponent != null) {
            return debtOrderPayComponent.onHandleBack();
        }
        return super.onHandleBack();
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.entrega_customer_page_order_pay_info, (ViewGroup) getView(), false);
        this.f20876b = inflate;
        this.f20875a = (FrameLayout) inflate.findViewById(R.id.customer_fl_pay_info_container);
    }
}
