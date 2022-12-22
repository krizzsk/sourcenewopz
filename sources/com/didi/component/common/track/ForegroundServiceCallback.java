package com.didi.component.common.track;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.push.CommonPushManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.service.ForegroundLauncher;
import com.didi.sdk.service.IForegroundServiceCallback;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.session.Session;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.core.listener.DefaultDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.core.order.OrderPollingManager;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.p170v2.poll.ExpressOrderStatusPoll;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider({IForegroundServiceCallback.class})
public class ForegroundServiceCallback implements IForegroundServiceCallback {

    /* renamed from: a */
    private OrderPollingManager f11741a;

    /* renamed from: b */
    private ExpressOrderStatusPoll f11742b;

    /* renamed from: c */
    private Session f11743c;

    /* renamed from: d */
    private String f11744d;

    /* renamed from: e */
    private String f11745e;

    /* renamed from: f */
    private final DefaultDiDiCoreCallback f11746f = new DefaultDiDiCoreCallback() {
        public void onOrderStatusChange(IOrderStatus iOrderStatus) {
            super.onOrderStatusChange(iOrderStatus);
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                DidiTrackingClient instance = DidiTrackingClient.getInstance();
                if (!instance.checkTrackingIsReduced()) {
                    int i = order.orderState == null ? order.status : order.orderState.status;
                    int i2 = order.substatus;
                    SystemUtils.log(6, "onOrderStatusChange", i + "", (Throwable) null, "com.didi.component.common.track.ForegroundServiceCallback$1", 111);
                    if (i != 4 && i != 1) {
                        instance.stopTracking();
                        ForegroundLauncher.stopForeground(DIDIApplication.getAppContext());
                    } else if (i == 4 && i2 == 4006) {
                        instance.startTracking(1, instance.getSendFrequency());
                    }
                }
            }
        }
    };

    public void onServiceStartCommand(int i, Bundle bundle) {
        if (bundle != null) {
            this.f11743c = TravelSDKV2.getSession(bundle.getString(TravelConstant.EXTRA_SESSION_KEY));
            this.f11744d = bundle.getString(TravelConstant.EXTRA_ORDER_ID);
            this.f11745e = bundle.getString(TravelConstant.EXTRA_SOURCE);
        }
        m7950a();
        CommonPushManager.getInstance().registerDidiPushCoreBack(this.f11746f);
        LogUtils.m31493i("ForegroundServiceCallback", "onServiceStartCommand:mSession = " + this.f11743c + ", mOrderId = " + this.f11744d);
    }

    /* renamed from: a */
    private void m7950a() {
        if (!TravelConstant.EXTRA_SOURCE_RIDE_ON_SERVICE_NOTIFICATION.equals(this.f11745e)) {
            HashMap hashMap = new HashMap();
            hashMap.put("source", this.f11745e);
            OmegaSDKAdapter.trackEvent("tech_ride_on_service_order_loop_error_case", (Map<String, Object>) hashMap);
        } else if (this.f11743c == null || TextUtils.isEmpty(this.f11744d)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("source", this.f11745e);
            Session session = this.f11743c;
            hashMap2.put("session_key", session == null ? "" : session.getKey());
            hashMap2.put("order_id", this.f11744d);
            OmegaSDKAdapter.trackEvent("tech_ride_on_service_order_loop_error_case", (Map<String, Object>) hashMap2);
        } else {
            if (this.f11742b == null) {
                this.f11742b = ExpressOrderStatusPoll.getInstance(TravelUtil.getScene(1101), this.f11743c, this.f11744d);
            }
            this.f11742b.setIsNeedAppBackgroundPoll(true);
            this.f11742b.addCoreCallback(this.f11746f);
            this.f11742b.startPoll((Scene) null);
        }
    }

    /* renamed from: b */
    private void m7951b() {
        ExpressOrderStatusPoll expressOrderStatusPoll = this.f11742b;
        if (expressOrderStatusPoll != null) {
            expressOrderStatusPoll.setIsNeedAppBackgroundPoll(false);
            this.f11742b.removeCoreCallback(this.f11746f);
            this.f11742b.stopPoll((Scene) null);
        }
    }

    public void onServiceDestroy(int i) {
        m7951b();
        CommonPushManager.getInstance().unregisterDidiPushCoreBack(this.f11746f);
    }
}
