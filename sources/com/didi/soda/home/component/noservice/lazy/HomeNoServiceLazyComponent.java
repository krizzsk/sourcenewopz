package com.didi.soda.home.component.noservice.lazy;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.soda.customer.base.lazycomponent.LazyComponent;
import com.didi.soda.customer.widget.tabbar.ITabComponent;
import com.didi.soda.home.component.ICustomerComponent;

public class HomeNoServiceLazyComponent extends LazyComponent<HomeNoServiceLazyView, HomeNoServiceLazyPresenter> implements ITabComponent, ICustomerComponent {
    public HomeNoServiceLazyComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        HomeNoServiceLazyPresenter homeNoServiceLazyPresenter = (HomeNoServiceLazyPresenter) getPresenter();
        if (homeNoServiceLazyPresenter != null) {
            homeNoServiceLazyPresenter.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public HomeNoServiceLazyView onCreateView() {
        return new HomeNoServiceLazyView();
    }

    /* access modifiers changed from: protected */
    public HomeNoServiceLazyPresenter onCreatePresenter() {
        return new HomeNoServiceLazyPresenter();
    }
}
