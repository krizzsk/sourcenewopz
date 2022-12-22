package com.didi.soda.pay.pospay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.pay.model.PayMethodInfoModel;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"payPosListPage"})
public class PosListPage extends CustomerPage {
    public static final String PAGE_PARAM = "pos_page_param";

    public PosListPage() {
        DiRouter.registerHub("payPosListPage", this);
    }

    public static void toPosListPage(ScopeContext scopeContext, PayMethodInfoModel payMethodInfoModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pos_page_param", payMethodInfoModel);
        scopeContext.getNavigator().pushForResult((PosListPage) PageFactory.newInstance(PosListPage.class, bundle));
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_pos_list_container, viewGroup, false);
    }

    public void onCreate(View view) {
        super.onCreate(view);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new PosListComponent((ViewGroup) getView()));
    }
}
