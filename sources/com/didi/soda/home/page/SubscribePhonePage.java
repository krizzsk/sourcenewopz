package com.didi.soda.home.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.base.pages.changehandler.CustomerVerticalChangeHandler;
import com.didi.soda.home.component.phone.HomePhoneComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"subscribePhonePage"})
public class SubscribePhonePage extends CustomerPage {
    public static final String PARAM_CALLING_CODE = "param_calling_code";
    public static final String PARAM_COUNTRY_ID = "param_country_id";
    public static final String PARAM_ERROR_CODE = "param_error_code";

    public SubscribePhonePage() {
        DiRouter.registerHub(RoutePath.HOME_SUBSCRIBE_PHONE_PAGE, this);
    }

    public static void toPhonePage(ScopeContext scopeContext, String str, int i, int i2) {
        if (GlobalContext.isEmbed()) {
            GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
        }
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_CALLING_CODE, str);
        bundle.putInt(PARAM_COUNTRY_ID, i);
        bundle.putInt("param_error_code", i2);
        scopeContext.getNavigator().pushForResult((SubscribePhonePage) PageFactory.newInstance(SubscribePhonePage.class, bundle));
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_topic, viewGroup, false);
    }

    public ControllerChangeHandler getPopHandler() {
        return new CustomerVerticalChangeHandler();
    }

    public ControllerChangeHandler getPushHandler() {
        return new CustomerVerticalChangeHandler();
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new HomePhoneComponent((ViewGroup) getPageView()));
    }
}
