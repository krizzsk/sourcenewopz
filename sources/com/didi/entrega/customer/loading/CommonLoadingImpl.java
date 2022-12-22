package com.didi.entrega.customer.loading;

import android.view.View;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.loadingmanager.ICommonLoading;
import com.didi.entrega.customer.widget.loading.ILoadingHolder;
import com.didi.entrega.customer.widget.loading.ILoadingable;
import com.didi.entrega.customer.widget.loading.LoadingConfig;
import com.didi.entrega.customer.widget.loading.LoadingRenderType;
import com.didi.entrega.customer.widget.loading.app.LoadingDelegate;

public class CommonLoadingImpl implements ICommonLoading, ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private View f20180a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LoadingDelegate f20181b;

    public View getFallbackView() {
        return this.f20180a;
    }

    public LoadingConfig getLoadingConfig() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        return loadingConfig;
    }

    public void hideBlockLoading() {
        this.f20181b.hideLoading();
    }

    public void hideLoading() {
        this.f20181b.hideLoading();
    }

    public boolean isLoading() {
        return this.f20181b.isLoading();
    }

    public void setLoadingView(ScopeContext scopeContext, View view, View view2) {
        this.f20181b = new LoadingDelegate(GlobalContext.getContext(), this);
        scopeContext.addObserver(new IScopeLifecycle() {
            public void onCreate(ILive iLive) {
            }

            public void onDestroy(ILive iLive) {
            }

            public void onPause(ILive iLive) {
            }

            public void onResume(ILive iLive) {
            }

            public void onStart(ILive iLive) {
            }

            public void onStop(ILive iLive) {
                CommonLoadingImpl.this.f20181b.hideLoading();
            }
        });
        this.f20180a = view2;
    }

    public void setLoadingViewContain(View view) {
        if (view != null) {
            this.f20180a = view;
        }
    }

    public void showBlockLoading() {
        this.f20181b.showMaskLayerLoading();
    }

    public void showLoading(boolean z) {
        this.f20181b.showLoading();
    }

    public void showLoading() {
        this.f20181b.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f20181b.showLoading(loadingConfig);
    }
}
