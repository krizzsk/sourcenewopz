package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.views.IJarvisView;
import com.didi.sdk.util.UiThreadHandler;

public class HomeJarvisPresenter extends AbsJarvisPresenter {

    /* renamed from: a */
    private int f15402a = -1;

    /* access modifiers changed from: protected */
    public String getPage() {
        return "home";
    }

    public HomeJarvisPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                HomeJarvisPresenter.this.requestJarvisStatus();
            }
        }, 1000);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        ((IJarvisView) this.mView).onLeaveHome();
        unRegister();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        ((IJarvisView) this.mView).onBackHome();
        register();
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                HomeJarvisPresenter.this.requestJarvisStatus();
            }
        }, 1000);
    }

    /* renamed from: b */
    private void m11096b() {
        if (this.mView != null) {
            ((IJarvisView) this.mView).setJarvisVisible(8);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, 0);
        }
    }

    /* renamed from: c */
    private void m11097c() {
        if (this.mView != null) {
            ((IJarvisView) this.mView).setJarvisVisible(0);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, Integer.valueOf(((IJarvisView) this.mView).getView().getMeasuredHeight()));
        }
    }

    /* access modifiers changed from: protected */
    public void register() {
        super.register();
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        super.unRegister();
    }
}
