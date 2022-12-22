package com.didi.soda.goodsV2.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.goodsV2.component.purchase.GoodsPurchaseComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route(interceptors = {GoodsPurchasePageInterceptor.class}, value = {"specSelectionPageV2"})
public class GoodsPurchasePage extends FloatingCustomerPage {

    /* renamed from: a */
    private FrameLayout f42530a;

    /* renamed from: b */
    private View f42531b;

    /* renamed from: c */
    private GoodsPurchaseComponent f42532c;

    public GoodsPurchasePage() {
        DiRouter.registerHub(RoutePath.GOODS_PURCHASE_V2, this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f42531b);
        setType(2);
    }

    public boolean onHandleBack() {
        dismiss();
        super.onHandleBack();
        return true;
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        GoodsPurchaseComponent goodsPurchaseComponent = new GoodsPurchaseComponent(this.f42530a);
        this.f42532c = goodsPurchaseComponent;
        addComponent(goodsPurchaseComponent);
    }

    public void onPageResult(Bundle bundle) {
        GoodsPurchaseComponent goodsPurchaseComponent;
        super.onPageResult(bundle);
        if (bundle != null && (goodsPurchaseComponent = this.f42532c) != null) {
            goodsPurchaseComponent.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_goods_purchase, (ViewGroup) getView(), false);
        this.f42531b = inflate;
        this.f42530a = (FrameLayout) inflate.findViewById(R.id.customer_fl_goods_purchase_container);
    }

    /* access modifiers changed from: protected */
    public void updateFloatingConfig() {
        super.updateFloatingConfig();
        getNavBar().setVisible(false);
    }
}
