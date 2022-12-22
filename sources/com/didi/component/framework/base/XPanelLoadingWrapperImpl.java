package com.didi.component.framework.base;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.loading.XPanelLoadingWrapper;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.loading.LoadingConfig;

public class XPanelLoadingWrapperImpl extends XPanelLoadingWrapper {

    /* renamed from: a */
    private BaseEventPublisher.OnEventListener<LoadingConfig> f13733a = new BaseEventPublisher.OnEventListener<LoadingConfig>() {
        public void onEvent(String str, LoadingConfig loadingConfig) {
            if (BaseEventKeys.XPanel.KEY_XPANEL_LOADING_SHOW.equals(str) && XPanelLoadingWrapperImpl.this.mForwardLoading != null) {
                GLog.m7965d("zl-loading", "KEY_XPANEL_LOADING_SHOW on " + XPanelLoadingWrapperImpl.this.mForwardLoading);
                if (loadingConfig != null) {
                    XPanelLoadingWrapperImpl.this.mForwardLoading.showLoading(loadingConfig);
                } else {
                    XPanelLoadingWrapperImpl.this.mForwardLoading.showLoading();
                }
            }
        }
    };

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13734b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.XPanel.KEY_XPANEL_LOADING_HIDE.equals(str) && XPanelLoadingWrapperImpl.this.mForwardLoading != null) {
                GLog.m7965d("zl-loading", "KEY_XPANEL_LOADING_HIDE on " + XPanelLoadingWrapperImpl.this.mForwardLoading);
                XPanelLoadingWrapperImpl.this.mForwardLoading.hideLoading();
            }
        }
    };

    public void onCreate() {
        super.onCreate();
        if (this.mForwardLoading != null) {
            BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.XPanel.KEY_XPANEL_LOADING_SHOW, this.f13733a);
            BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.XPanel.KEY_XPANEL_LOADING_HIDE, this.f13734b);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mForwardLoading != null) {
            this.mForwardLoading.hideLoading();
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.XPanel.KEY_XPANEL_LOADING_SHOW, this.f13733a);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.XPanel.KEY_XPANEL_LOADING_HIDE, this.f13734b);
        }
    }
}
