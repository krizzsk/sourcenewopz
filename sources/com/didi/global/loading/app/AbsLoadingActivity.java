package com.didi.global.loading.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.apm.SystemUtils;

public abstract class AbsLoadingActivity extends FragmentActivity implements ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private LoadingDelegate f22649a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f22649a = new LoadingDelegate(this, this);
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
        this.f22649a.showMaskLayerLoading();
    }

    public void showLoading() {
        this.f22649a.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f22649a.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.f22649a.hideLoading();
    }

    public boolean isLoading() {
        return this.f22649a.isLoading();
    }
}
