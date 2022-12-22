package com.didi.component.common.loading;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.loading.LoadingConfig;

public class XPanelLoadingWrapper extends LoadingWrapper {
    public void showLoading(LoadingConfig loadingConfig) {
        super.showLoading(loadingConfig);
        if (loadingConfig == null) {
            loadingConfig = new LoadingConfig();
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.KEY_XPANEL_LOADING_SHOW, loadingConfig);
    }

    public void hideLoading() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.KEY_XPANEL_LOADING_HIDE);
    }
}
