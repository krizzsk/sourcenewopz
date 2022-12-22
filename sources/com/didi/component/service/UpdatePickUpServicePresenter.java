package com.didi.component.service;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;

public class UpdatePickUpServicePresenter extends AbsOnServicePresenter {

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<Boolean> f15628r = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            UpdatePickUpServicePresenter.this.goBack();
        }
    };

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void tryForwardEndService() {
    }

    public UpdatePickUpServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        registerListener();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unregisterListener();
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, this.f15628r);
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, this.f15628r);
    }
}
