package com.didi.component.confirmbroadingpoint.impl;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.confirmbroadingpoint.AbsConfirmBroadingPointPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class UpdatePickUpBroadingPointPresenter extends AbsConfirmBroadingPointPresenter {

    /* renamed from: n */
    BaseEventPublisher.OnEventListener<Address> f12656n = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, Address address) {
            if (address != null) {
                UpdatePickUpBroadingPointPresenter.super.updateContent(true, address);
            }
        }
    };

    public UpdatePickUpBroadingPointPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void updateContent(boolean z, Address address) {
        if (z) {
            setTitle(ResourcesHelper.getString(this.mContext, R.string.global_confirm_broading_title_in_onservice));
            setTitleFromServer(true, address);
            setConfirmAction(ResourcesHelper.getString(this.mContext, R.string.global_confirm_broading_button_in_onservice));
        }
        super.updateContent(z, address);
    }

    public void onConfirmClicked() {
        super.onConfirmClicked();
        if (this.mDepartureAddress != null) {
            doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_BUTTON_CLICK, this.mDepartureAddress);
        }
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        super.registerListener();
        subscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_PIN_CHANGED_OUT_OF_AREA, this.f12656n);
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        super.unregisterListener();
        unsubscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_PIN_CHANGED_OUT_OF_AREA, this.f12656n);
    }
}
