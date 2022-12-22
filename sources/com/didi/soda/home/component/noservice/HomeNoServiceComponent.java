package com.didi.soda.home.component.noservice;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.widget.tabbar.ITabComponent;
import com.didi.soda.home.component.ICustomerComponent;

public class HomeNoServiceComponent extends MvpComponent<HomeNoServiceView, HomeNoServicePresenter> implements ITabComponent, ICustomerComponent {
    public HomeNoServiceComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        HomeNoServicePresenter homeNoServicePresenter = (HomeNoServicePresenter) getPresenter();
        if (homeNoServicePresenter != null) {
            homeNoServicePresenter.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public HomeNoServiceView onCreateView() {
        return new HomeNoServiceView();
    }

    /* access modifiers changed from: protected */
    public HomeNoServicePresenter onCreatePresenter() {
        return new HomeNoServicePresenter();
    }
}
