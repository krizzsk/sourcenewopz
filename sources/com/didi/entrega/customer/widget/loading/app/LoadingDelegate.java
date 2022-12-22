package com.didi.entrega.customer.widget.loading.app;

import android.content.Context;
import android.os.Bundle;
import com.didi.entrega.customer.widget.loading.ILoadingHolder;
import com.didi.entrega.customer.widget.loading.ILoadingable;
import com.didi.entrega.customer.widget.loading.Loading;
import com.didi.entrega.customer.widget.loading.LoadingConfig;

public class LoadingDelegate implements ILoadingable {

    /* renamed from: a */
    private Context f20554a;

    /* renamed from: b */
    private ILoadingHolder f20555b;

    public LoadingDelegate(Context context, ILoadingHolder iLoadingHolder) {
        this.f20554a = context;
        this.f20555b = iLoadingHolder;
    }

    public void hideLoading() {
        ILoadingHolder iLoadingHolder;
        if (this.f20554a != null && (iLoadingHolder = this.f20555b) != null) {
            Loading.hide(iLoadingHolder.getFallbackView());
        }
    }

    public boolean isLoading() {
        ILoadingHolder iLoadingHolder;
        if (this.f20554a == null || (iLoadingHolder = this.f20555b) == null) {
            return false;
        }
        return Loading.isShowing(iLoadingHolder.getFallbackView());
    }

    public void showLoading() {
        showLoading((LoadingConfig) null);
    }

    public void showLoading(LoadingConfig loadingConfig) {
        ILoadingHolder iLoadingHolder = this.f20555b;
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
            if (this.f20555b.getFallbackView() != null) {
                Loading.make(this.f20554a, loadingConfig2.getRenderType(), loadingConfig2.getRenderParams(), this.f20555b.getFallbackView(), loadingConfig2.isWithMaskLayer(), loadingConfig2.getLoadingGravity()).show();
            }
        }
    }

    public void showMaskLayerLoading() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setWithMaskLayer(true);
        showLoading(loadingConfig);
    }
}
