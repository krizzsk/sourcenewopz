package com.didi.soda.home.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.changehandler.CustomerVerticalChangeHandler;
import com.didi.soda.home.component.city.HomeCityListComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"citySelectPage"})
public class HomeCityListPage extends CustomerPage {
    public static final String PARAM_ERROR_CODE = "param_error_code";
    public static final String PARAM_TITLE = "param_title";
    @BindView(18156)
    FrameLayout mHomeFeedContainer;

    public HomeCityListPage() {
        DiRouter.registerHub("citySelectPage", this);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_city_list, viewGroup, false);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new HomeCityListComponent(this.mHomeFeedContainer));
    }

    public ControllerChangeHandler getPopHandler() {
        return new CustomerVerticalChangeHandler();
    }

    public ControllerChangeHandler getPushHandler() {
        return new CustomerVerticalChangeHandler();
    }
}
