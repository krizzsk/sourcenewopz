package com.didi.soda.customer.foundation.util.loadingmanager;

import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.loading.CommonLoadingImpl;

public class LoadingManager {

    /* renamed from: a */
    ICommonLoading f41264a;

    public LoadingManager(ScopeContext scopeContext, View view, View view2) {
        CommonLoadingImpl commonLoadingImpl = new CommonLoadingImpl();
        this.f41264a = commonLoadingImpl;
        commonLoadingImpl.setLoadingView(scopeContext, view, view2);
    }

    public void hideBlockLoading() {
        this.f41264a.hideBlockLoading();
    }

    public void hideLoading() {
        this.f41264a.hideLoading();
    }

    public boolean isLoading() {
        return this.f41264a.isLoading();
    }

    public void setLoadingViewContain(View view) {
        ICommonLoading iCommonLoading = this.f41264a;
        if (iCommonLoading != null) {
            iCommonLoading.setLoadingViewContain(view);
        }
    }

    public void showBlockLoading() {
        this.f41264a.showBlockLoading();
    }

    public void showLoading(boolean z) {
        this.f41264a.showLoading(z);
    }

    public void showLoading() {
        showLoading(false);
    }
}
