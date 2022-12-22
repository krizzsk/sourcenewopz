package com.didiglobal.passenger.mex.component.newui;

import android.content.Intent;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.event.TripSwitchSceneEvent;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.operationpanel.impl.newui.presenter.GlobalOnTripOperationPanelPresenterV2;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.taxis99.R;

public class MexOnTripOperationPanelPresenterV2 extends GlobalOnTripOperationPanelPresenterV2 {
    public MexOnTripOperationPanelPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!isDoingService()) {
            return;
        }
        if (i != 101 || i2 != -1 || intent == null || !intent.getBooleanExtra("isCancelTrip", false)) {
            super.onActivityResult(i, i2, intent);
        } else {
            m36235b();
        }
    }

    /* renamed from: b */
    private void m36235b() {
        CarOrder order = CarOrderHelper.getOrder();
        TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), order.oid, new ITravelOrderListener() {
            public void onSuccess(ICarOrder iCarOrder) {
                MexOnTripOperationPanelPresenterV2.this.dismissDialog(11);
                NotificationUtils.getInstance(MexOnTripOperationPanelPresenterV2.this.mContext).hideNotification();
                MexOnTripOperationPanelPresenterV2.this.m36239c();
            }

            public void onTimeout(String str) {
                MexOnTripOperationPanelPresenterV2.this.dismissDialog(11);
                ToastHelper.showLongCompleted(MexOnTripOperationPanelPresenterV2.this.mContext, str);
            }

            public void onError(int i, String str) {
                MexOnTripOperationPanelPresenterV2.this.dismissDialog(11);
                ToastHelper.showShortInfo(MexOnTripOperationPanelPresenterV2.this.mContext, (int) R.string.car_get_order_detail_fail);
            }

            public void onFail(int i, String str) {
                MexOnTripOperationPanelPresenterV2.this.dismissDialog(11);
                ToastHelper.showShortInfo(MexOnTripOperationPanelPresenterV2.this.mContext, (int) R.string.car_get_order_detail_fail);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36239c() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
        doPublish(BaseEventKeys.Service.Trip.EVENT_TRIP_SCENE_SWITCH, new TripSwitchSceneEvent(10403, bundle));
    }
}
