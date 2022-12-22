package com.didi.global.loading.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.apm.SystemUtils;

public abstract class AbsLoadingAppCompatActivity extends AppCompatActivity implements ILoadingHolder, ILoadingable {
    private LoadingDelegate loadingDelegate;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.loadingDelegate = new LoadingDelegate(this, this);
    }

    /* access modifiers changed from: protected */
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
