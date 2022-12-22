package com.didi.soda.business.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.business.component.address.BusinessAddressMapComponent;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"businessDetailMapPage"})
public class BusinessAddressPage extends CustomerPage {
    @BindView(18130)
    FrameLayout mBusinessDetailContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public boolean getTouchIntercept() {
        return false;
    }

    public BusinessAddressPage() {
        DiRouter.registerHub(RoutePath.BUSINESS_ADDRESS_MAP, this);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_business_address, viewGroup, false);
    }

    public ControllerChangeHandler getPushHandler() {
        return new BusinessAddressChangeHandler(true);
    }

    public ControllerChangeHandler getPopHandler() {
        return new BusinessAddressChangeHandler(true);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        addComponent(new BusinessAddressMapComponent(this.mBusinessDetailContainer));
    }
}
