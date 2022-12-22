package com.didi.entrega.customer.base.pages;

import android.view.View;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.mvp.MvpPage;
import com.didi.entrega.customer.base.ICustomerPresenter;
import com.didi.entrega.customer.base.ICustomerView;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.listener.PageClickableListener;
import com.didi.entrega.router.HubTable;
import com.didi.entrega.router.IHubHandler;
import com.didi.entrega.router.Request;
import com.didi.entrega.router.Response;

public class CustomerMvpPage<V extends ICustomerView, P extends ICustomerPresenter> extends MvpPage<V, P> implements PageClickableListener, IHubHandler {

    /* renamed from: c */
    private static final int f19807c = 0;

    /* renamed from: d */
    private CustomerPageDelegate f19808d = new CustomerPageDelegate(this, false);

    public boolean getTouchIntercept() {
        return true;
    }

    public String alias() {
        return HubTable.getPageId(getClass());
    }

    public View getPageView() {
        return getView();
    }

    public ControllerChangeHandler getPopHandler() {
        return this.f19808d.mo59675b();
    }

    public ControllerChangeHandler getPushHandler() {
        return this.f19808d.mo59673a();
    }

    public void onCreate(View view) {
        ButterKnife.bind((Object) this, view);
        this.f19808d.onCreate();
        super.onCreate(view);
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        return super.onHandleBack();
    }

    public void onResume() {
        super.onResume();
        this.f19808d.onResume();
    }

    public void onStart() {
        super.onStart();
        this.f19808d.onStart(getView(), getStatusBarHeight());
    }

    public void onStop() {
        super.onStop();
        this.f19808d.onStop();
    }

    public void openRoute(Request request, Response response) {
        this.f19808d.openRoute(request);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return CustomerSystemUtil.getImmersiveStatusBarHeight(getBaseContext());
    }
}
