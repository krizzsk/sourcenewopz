package com.didi.global.loading.app;

import android.content.Context;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;

public abstract class AbsLoadingView implements ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private LoadingDelegate f22652a;

    public AbsLoadingView(Context context) {
        this.f22652a = new LoadingDelegate(context, this);
    }

    public void showMaskLayerLoading() {
        this.f22652a.showMaskLayerLoading();
    }

    public void showLoading() {
        this.f22652a.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f22652a.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.f22652a.hideLoading();
    }

    public boolean isLoading() {
        return this.f22652a.isLoading();
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().build();
    }
}
