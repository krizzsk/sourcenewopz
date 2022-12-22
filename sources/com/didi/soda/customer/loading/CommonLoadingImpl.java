package com.didi.soda.customer.loading;

import android.view.View;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.loadingmanager.ICommonLoading;
import com.didi.soda.customer.widget.loading.ILoadingHolder;
import com.didi.soda.customer.widget.loading.ILoadingable;
import com.didi.soda.customer.widget.loading.LoadingConfig;
import com.didi.soda.customer.widget.loading.LoadingRenderType;
import com.didi.soda.customer.widget.loading.app.LoadingDelegate;

public class CommonLoadingImpl implements ICommonLoading, ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private View f41356a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LoadingDelegate f41357b;

    public View getFallbackView() {
        return this.f41356a;
    }

    public LoadingConfig getLoadingConfig() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        return loadingConfig;
    }

    public void hideBlockLoading() {
        this.f41357b.hideLoading();
    }

    public void hideLoading() {
        this.f41357b.hideLoading();
    }

    public boolean isLoading() {
        return this.f41357b.isLoading();
    }

    public void setLoadingView(ScopeContext scopeContext, View view, View view2) {
        this.f41357b = new LoadingDelegate(GlobalContext.getContext(), this);
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
                CommonLoadingImpl.this.f41357b.hideLoading();
            }
        });
        this.f41356a = view2;
    }

    public void setLoadingViewContain(View view) {
        if (view != null) {
            this.f41356a = view;
        }
    }

    public void showBlockLoading() {
        this.f41357b.showMaskLayerLoading();
    }

    public void showLoading(boolean z) {
        this.f41357b.showLoading();
    }

    public void showLoading() {
        this.f41357b.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f41357b.showLoading(loadingConfig);
    }
}
