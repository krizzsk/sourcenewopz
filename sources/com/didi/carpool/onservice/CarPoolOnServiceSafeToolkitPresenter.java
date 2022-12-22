package com.didi.carpool.onservice;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.ISafeToolkitView;
import com.didi.component.safetoolkit.presenter.OnServiceSafeToolkitPresenter;

public class CarPoolOnServiceSafeToolkitPresenter extends OnServiceSafeToolkitPresenter {
    public CarPoolOnServiceSafeToolkitPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public boolean refreshVisibility() {
        ((ISafeToolkitView) this.mView).setVisibility(true);
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY);
        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY, new Boolean(false));
        return true;
    }
}
