package com.didi.entrega.customer.foundation.util.loadingmanager;

import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.loading.CommonLoadingImpl;

public class LoadingManager {

    /* renamed from: a */
    ICommonLoading f20162a;

    public LoadingManager(ScopeContext scopeContext, View view, View view2) {
        CommonLoadingImpl commonLoadingImpl = new CommonLoadingImpl();
        this.f20162a = commonLoadingImpl;
        commonLoadingImpl.setLoadingView(scopeContext, view, view2);
    }

    public void hideBlockLoading() {
        this.f20162a.hideBlockLoading();
    }

    public void hideLoading() {
        this.f20162a.hideLoading();
    }

    public boolean isLoading() {
        return this.f20162a.isLoading();
    }

    public void setLoadingViewContain(View view) {
        ICommonLoading iCommonLoading = this.f20162a;
        if (iCommonLoading != null) {
            iCommonLoading.setLoadingViewContain(view);
        }
    }

    public void showBlockLoading() {
        this.f20162a.showBlockLoading();
    }

    public void showLoading(boolean z) {
        this.f20162a.showLoading(z);
    }

    public void showLoading() {
        showLoading(false);
    }
}
