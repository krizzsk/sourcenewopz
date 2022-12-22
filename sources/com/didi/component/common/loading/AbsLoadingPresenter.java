package com.didi.component.common.loading;

import android.os.Bundle;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;

public abstract class AbsLoadingPresenter<V extends IView> extends BaseExpressPresenter<V> implements ILoadingable {

    /* renamed from: a */
    private LoadingWrapper f11642a;

    public AbsLoadingPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void attachLoadingWrapper(LoadingWrapper loadingWrapper) {
        this.f11642a = loadingWrapper;
    }

    /* access modifiers changed from: protected */
    public LoadingWrapper getLoadingWrapper() {
        if (this.f11642a == null) {
            this.f11642a = new XPanelLoadingWrapper();
        }
        return this.f11642a;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        getLoadingWrapper().onCreate();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        getLoadingWrapper().onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        getLoadingWrapper().onCreate();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        getLoadingWrapper().onDestroy();
    }

    public void showLoading() {
        getLoadingWrapper().showLoading();
    }

    public void showMaskLayerLoading() {
        getLoadingWrapper().showMaskLayerLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        getLoadingWrapper().showLoading(loadingConfig);
    }

    public void hideLoading() {
        getLoadingWrapper().hideLoading();
    }

    public boolean isLoading() {
        return getLoadingWrapper().isLoading();
    }
}
