package com.didi.component.common.loading;

import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.app.LoadingDelegate;

public class LoadingWrapper {
    protected ILoadingable mForwardLoading;
    protected LoadingDelegate mLoadingDelegate;

    public void setLoadingShowOn(ILoadingHolder iLoadingHolder) {
        if (iLoadingHolder != null && iLoadingHolder.getFallbackView() != null && iLoadingHolder.getFallbackView().getContext() != null) {
            this.mLoadingDelegate = new LoadingDelegate(iLoadingHolder.getFallbackView().getContext(), iLoadingHolder);
        }
    }

    public void setLoadingForwardBy(ILoadingable iLoadingable) {
        this.mForwardLoading = iLoadingable;
    }

    public void onCreate() {
        hideLoading();
    }

    public void onDestroy() {
        hideLoading();
    }

    public void showLoading() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setWithMaskLayer(false);
        showLoading(loadingConfig);
    }

    public void showMaskLayerLoading() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setWithMaskLayer(true);
        showLoading(loadingConfig);
    }

    public void showLoading(LoadingConfig loadingConfig) {
        LoadingDelegate loadingDelegate = this.mLoadingDelegate;
        if (loadingDelegate != null) {
            loadingDelegate.showLoading(loadingConfig);
        }
        ILoadingable iLoadingable = this.mForwardLoading;
        if (iLoadingable != null) {
            iLoadingable.showLoading(loadingConfig);
        }
    }

    public void hideLoading() {
        LoadingDelegate loadingDelegate = this.mLoadingDelegate;
        if (loadingDelegate != null) {
            loadingDelegate.hideLoading();
        }
        ILoadingable iLoadingable = this.mForwardLoading;
        if (iLoadingable != null) {
            iLoadingable.hideLoading();
        }
    }

    public boolean isLoading() {
        LoadingDelegate loadingDelegate = this.mLoadingDelegate;
        if (loadingDelegate == null || this.mForwardLoading == null) {
            LoadingDelegate loadingDelegate2 = this.mLoadingDelegate;
            if (loadingDelegate2 != null) {
                return loadingDelegate2.isLoading();
            }
            ILoadingable iLoadingable = this.mForwardLoading;
            if (iLoadingable != null) {
                return iLoadingable.isLoading();
            }
            return false;
        } else if (loadingDelegate.isLoading() || this.mForwardLoading.isLoading()) {
            return true;
        } else {
            return false;
        }
    }
}
