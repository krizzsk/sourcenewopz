package com.didi.global.loading.app;

import android.app.Fragment;
import android.os.Bundle;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;

public abstract class AbsLoadingAppFragment extends Fragment implements ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private LoadingDelegate f22651a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22651a = new LoadingDelegate(getActivity(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }

    public void showMaskLayerLoading() {
        this.f22651a.showMaskLayerLoading();
    }

    public void showLoading() {
        this.f22651a.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f22651a.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.f22651a.hideLoading();
    }

    public boolean isLoading() {
        return this.f22651a.isLoading();
    }
}
