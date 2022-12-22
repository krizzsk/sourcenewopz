package com.didi.entrega.home.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.entrega.customer.base.pages.CustomerPage;
import com.didi.entrega.customer.base.pages.changehandler.CustomerVerticalChangeHandler;
import com.didi.entrega.home.component.city.HomeCityListComponent;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;

@Route({"citySelectPage"})
public class HomeCityListPage extends CustomerPage {
    public static final String PARAM_ERROR_CODE = "param_error_code";
    public static final String PARAM_TITLE = "param_title";
    @BindView(16318)
    FrameLayout mHomeFeedContainer;

    public HomeCityListPage() {
        DiRouter.registerHub("citySelectPage", this);
    }

    public static void showPage() {
        DiRouter.request().path("citySelectPage").open();
        HomeOtherOmegaHelper.trackExceptionCK(3);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.entrega_page_city_list, viewGroup, false);
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
