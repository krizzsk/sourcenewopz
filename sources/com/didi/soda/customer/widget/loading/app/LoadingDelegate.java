package com.didi.soda.customer.widget.loading.app;

import android.content.Context;
import android.os.Bundle;
import com.didi.soda.customer.widget.loading.ILoadingHolder;
import com.didi.soda.customer.widget.loading.ILoadingable;
import com.didi.soda.customer.widget.loading.Loading;
import com.didi.soda.customer.widget.loading.LoadingConfig;

public class LoadingDelegate implements ILoadingable {

    /* renamed from: a */
    private Context f42090a;

    /* renamed from: b */
    private ILoadingHolder f42091b;

    public LoadingDelegate(Context context, ILoadingHolder iLoadingHolder) {
        this.f42090a = context;
        this.f42091b = iLoadingHolder;
    }

    public void hideLoading() {
        ILoadingHolder iLoadingHolder;
        if (this.f42090a != null && (iLoadingHolder = this.f42091b) != null) {
            Loading.hide(iLoadingHolder.getFallbackView());
        }
    }

    public boolean isLoading() {
        ILoadingHolder iLoadingHolder;
        if (this.f42090a == null || (iLoadingHolder = this.f42091b) == null) {
            return false;
        }
        return Loading.isShowing(iLoadingHolder.getFallbackView());
    }

    public void showLoading() {
        showLoading((LoadingConfig) null);
    }

    public void showLoading(LoadingConfig loadingConfig) {
        ILoadingHolder iLoadingHolder = this.f42091b;
        if (iLoadingHolder != null) {
            LoadingConfig loadingConfig2 = iLoadingHolder.getLoadingConfig();
            if (loadingConfig != null) {
                loadingConfig2.setWithMaskLayer(loadingConfig.isWithMaskLayer());
                if (loadingConfig.getRenderType() != null) {
                    loadingConfig2.setRenderType(loadingConfig.getRenderType());
                }
                if (loadingConfig.getRenderParams() != null) {
                    Bundle renderParams = loadingConfig2.getRenderParams();
                    if (renderParams != null) {
                        renderParams.putAll(loadingConfig.getRenderParams());
                    } else {
                        loadingConfig2.setRenderParams(loadingConfig.getRenderParams());
                    }
                }
            }
            if (this.f42091b.getFallbackView() != null) {
                Loading.make(this.f42090a, loadingConfig2.getRenderType(), loadingConfig2.getRenderParams(), this.f42091b.getFallbackView(), loadingConfig2.isWithMaskLayer(), loadingConfig2.getLoadingGravity()).show();
            }
        }
    }

    public void showMaskLayerLoading() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setWithMaskLayer(true);
        showLoading(loadingConfig);
    }
}
