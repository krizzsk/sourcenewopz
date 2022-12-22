package com.didi.global.loading.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;

public abstract class AbsLoadingFragment extends Fragment implements ILoadingHolder, ILoadingable {
    private LoadingDelegate loadingDelegate;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.loadingDelegate = new LoadingDelegate(getActivity(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }

    public void showMaskLayerLoading() {
        this.loadingDelegate.showMaskLayerLoading();
    }

    public void showLoading() {
        this.loadingDelegate.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.loadingDelegate.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.loadingDelegate.hideLoading();
    }

    public boolean isLoading() {
        return this.loadingDelegate.isLoading();
    }
}
