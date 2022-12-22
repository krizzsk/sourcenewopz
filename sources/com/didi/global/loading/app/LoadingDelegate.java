package com.didi.global.loading.app;

import android.content.Context;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingConfig;

public class LoadingDelegate implements ILoadingable {

    /* renamed from: a */
    private Context f22653a;

    /* renamed from: b */
    private ILoadingHolder f22654b;

    public LoadingDelegate(Context context, ILoadingHolder iLoadingHolder) {
        this.f22653a = context;
        this.f22654b = iLoadingHolder;
    }

    public void showLoading() {
        showLoading(LoadingConfig.create().build());
    }

    public void showMaskLayerLoading() {
        showLoading(LoadingConfig.create().setWithMaskLayer(true).build());
    }

    public void showLoading(LoadingConfig loadingConfig) {
        ILoadingHolder iLoadingHolder = this.f22654b;
        if (iLoadingHolder != null && iLoadingHolder.getFallbackView() != null) {
            LoadingConfig loadingConfig2 = this.f22654b.getLoadingConfig();
            loadingConfig2.merge(loadingConfig);
            Loading.make(this.f22653a, this.f22654b.getFallbackView(), loadingConfig2).show();
        }
    }

    public void hideLoading() {
        ILoadingHolder iLoadingHolder;
        if (this.f22653a != null && (iLoadingHolder = this.f22654b) != null) {
            Loading.hide(iLoadingHolder.getFallbackView());
        }
    }

    public boolean isLoading() {
        ILoadingHolder iLoadingHolder;
        if (this.f22653a == null || (iLoadingHolder = this.f22654b) == null) {
            return false;
        }
        return Loading.isShowing(iLoadingHolder.getFallbackView());
    }
}
