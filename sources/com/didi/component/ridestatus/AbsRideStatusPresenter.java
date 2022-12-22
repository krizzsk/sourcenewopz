package com.didi.component.ridestatus;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.model.RideStatusData;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.ridestatus.IRideStatusView;
import com.didi.travel.psnger.model.response.CarOrder;

public abstract class AbsRideStatusPresenter<V extends IRideStatusView> extends BaseExpressPresenter<V> {

    /* renamed from: a */
    private BaseEventPublisher.OnEventListener f15327a = new BaseEventPublisher.OnEventListener<RideStatusData>() {
        public void onEvent(String str, RideStatusData rideStatusData) {
            if (rideStatusData != null && TextUtils.equals(BaseEventKeys.Service.EVENT_CHANGE_RIDE_STATUS, str)) {
                AbsRideStatusPresenter.this.onUpdateRideStatusByEvent(rideStatusData);
            }
        }
    };
    protected String mPreContentText = null;
    protected String mPreTitleText = null;

    /* access modifiers changed from: protected */
    public void makeAddCardModel(CarOrder carOrder, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void makeAddCardModel(String str, String str2) {
    }

    public void onWhyWaitClicked(View view) {
    }

    /* access modifiers changed from: protected */
    public void onUpdateRideStatusByEvent(RideStatusData rideStatusData) {
        if (this.mView != null) {
            ((IRideStatusView) this.mView).setTitleText(rideStatusData.title);
            ((IRideStatusView) this.mView).setTitleWarning(rideStatusData.titleWarning);
            if (TextUtils.isEmpty(rideStatusData.content)) {
                ((IRideStatusView) this.mView).setContentVisible(false);
                return;
            }
            ((IRideStatusView) this.mView).setContentText(rideStatusData.content);
            ((IRideStatusView) this.mView).setContentWarning(rideStatusData.contentWarning);
            ((IRideStatusView) this.mView).setContentVisible(true);
        }
    }

    public AbsRideStatusPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.EVENT_CHANGE_RIDE_STATUS, this.f15327a);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.EVENT_CHANGE_RIDE_STATUS, this.f15327a);
    }
}
