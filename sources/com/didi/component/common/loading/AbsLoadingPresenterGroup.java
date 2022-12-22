package com.didi.component.common.loading;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.common.util.GoBackRootUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.PresenterGroup;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;

public abstract class AbsLoadingPresenterGroup<V extends IGroupView> extends PresenterGroup<V> implements ILoadingable {

    /* renamed from: a */
    private LoadingWrapper f11643a;
    protected ComponentParams mComponentParams;

    public AbsLoadingPresenterGroup(Context context, Bundle bundle) {
        super(context, bundle);
    }

    public AbsLoadingPresenterGroup(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    public void attachLoadingWrapper(LoadingWrapper loadingWrapper) {
        this.f11643a = loadingWrapper;
    }

    /* access modifiers changed from: protected */
    public LoadingWrapper getLoadingWrapper() {
        if (this.f11643a == null) {
            this.f11643a = new XPanelLoadingWrapper();
        }
        return this.f11643a;
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

    /* access modifiers changed from: protected */
    public void goBackRoot() {
        if (!GoBackRootUtils.hasGobackRideHome(getHost().getFragmentManager(), (Bundle) null)) {
            super.goBackRoot();
        }
    }

    /* access modifiers changed from: protected */
    public void goBackRoot(Bundle bundle) {
        if (!GoBackRootUtils.hasGobackRideHome(getHost().getFragmentManager(), bundle)) {
            super.goBackRoot(bundle);
        }
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
