package com.didi.soda.customer.base.pages;

import android.view.View;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.mvp.MvpPage;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.listener.PageClickableListener;
import com.didi.soda.router.HubTable;
import com.didi.soda.router.IHubHandler;
import com.didi.soda.router.Request;
import com.didi.soda.router.Response;

public class CustomerMvpPage<V extends ICustomerView, P extends ICustomerPresenter> extends MvpPage<V, P> implements PageClickableListener, IHubHandler {

    /* renamed from: c */
    private static final int f40356c = 0;

    /* renamed from: d */
    private CustomerPageDelegate f40357d = new CustomerPageDelegate(this, false);

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
        return this.f40357d.mo101871b();
    }

    public ControllerChangeHandler getPushHandler() {
        return this.f40357d.mo101869a();
    }

    public void onCreate(View view) {
        ButterKnife.bind((Object) this, view);
        this.f40357d.onCreate();
        super.onCreate(view);
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        return super.onHandleBack();
    }

    public void onResume() {
        super.onResume();
        this.f40357d.onResume();
    }

    public void onStart() {
        super.onStart();
        this.f40357d.onStart(getView(), getStatusBarHeight());
    }

    public void onStop() {
        super.onStop();
        this.f40357d.onStop();
    }

    public void openRoute(Request request, Response response) {
        this.f40357d.mo101870a(request);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return CustomerSystemUtil.getImmersiveStatusBarHeight(getBaseContext());
    }
}
