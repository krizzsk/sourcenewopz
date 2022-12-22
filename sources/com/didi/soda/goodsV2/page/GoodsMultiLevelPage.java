package com.didi.soda.goodsV2.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.goodsV2.component.multilevel.GoodsMultiLevelComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"goodsMultiLevelPageV2"})
public class GoodsMultiLevelPage extends FloatingCustomerPage {

    /* renamed from: a */
    View f42527a;

    /* renamed from: b */
    ViewGroup f42528b;

    /* renamed from: c */
    private GoodsMultiLevelComponent f42529c;

    public GoodsMultiLevelPage() {
        DiRouter.registerHub(RoutePath.GOODS_MULTI_LEVEL_V2, this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f42527a);
        setType(2);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        GoodsMultiLevelComponent goodsMultiLevelComponent = new GoodsMultiLevelComponent(this.f42528b);
        this.f42529c = goodsMultiLevelComponent;
        addComponent(goodsMultiLevelComponent);
    }

    public void onPageResult(Bundle bundle) {
        GoodsMultiLevelComponent goodsMultiLevelComponent;
        super.onPageResult(bundle);
        if (bundle != null && (goodsMultiLevelComponent = this.f42529c) != null) {
            goodsMultiLevelComponent.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_goods_multi_level, (ViewGroup) getView(), false);
        this.f42527a = inflate;
        this.f42528b = (ViewGroup) inflate.findViewById(R.id.customer_fl_goods_multi_level_container);
    }

    /* access modifiers changed from: protected */
    public void updateFloatingConfig() {
        super.updateFloatingConfig();
        getNavBar().setVisible(false);
        setShowBackground(false);
    }
}
