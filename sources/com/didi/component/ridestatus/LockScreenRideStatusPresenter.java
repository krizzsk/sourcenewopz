package com.didi.component.ridestatus;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.ridestatus.view.OptimizeRideStatusView;
import com.didi.travel.psnger.model.response.CarOrder;

public class LockScreenRideStatusPresenter extends OnServiceRideStatusPresenter {
    public LockScreenRideStatusPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void waitDriver() {
        super.waitDriver();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.LockScreen.EVENT_LOCK_SCREEN_RIDE_STATUS_SHOW, 0);
    }

    /* access modifiers changed from: protected */
    public void driverArrived() {
        super.driverArrived();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.LockScreen.EVENT_LOCK_SCREEN_RIDE_STATUS_SHOW, 1);
    }

    /* access modifiers changed from: protected */
    public void passengerLate() {
        super.passengerLate();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.LockScreen.EVENT_LOCK_SCREEN_RIDE_STATUS_SHOW, 4);
    }

    /* access modifiers changed from: protected */
    public void driverLate() {
        super.driverLate();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.LockScreen.EVENT_LOCK_SCREEN_RIDE_STATUS_SHOW, 2);
    }

    /* access modifiers changed from: protected */
    public void makeAddCardModel(CarOrder carOrder, String str, String str2) {
        if (this.mView != null) {
            ((OptimizeRideStatusView) this.mView).setTitleText(str);
        }
    }

    /* access modifiers changed from: protected */
    public void makeAddCardModel(String str, String str2) {
        if (this.mView != null) {
            ((OptimizeRideStatusView) this.mView).setTitleText(str);
        }
    }
}
