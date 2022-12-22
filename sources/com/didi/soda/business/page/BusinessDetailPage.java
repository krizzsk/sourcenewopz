package com.didi.soda.business.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.business.component.detail.BusinessDetailComponent;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"businessDetailPage"})
public class BusinessDetailPage extends FloatingCustomerPage {

    /* renamed from: a */
    View f39722a;

    /* renamed from: b */
    FrameLayout f39723b;

    /* renamed from: c */
    private BusinessDetailComponent f39724c;

    public BusinessDetailPage() {
        DiRouter.registerHub(RoutePath.BUSINESS_DETAIL, this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f39722a);
        setType(2);
        BusinessDetailComponent businessDetailComponent = new BusinessDetailComponent(this.f39723b);
        this.f39724c = businessDetailComponent;
        addComponent(businessDetailComponent);
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_business_detail, (ViewGroup) getView(), false);
        this.f39722a = inflate;
        this.f39723b = (FrameLayout) inflate.findViewById(R.id.customer_fl_business_detail_container);
    }
}
