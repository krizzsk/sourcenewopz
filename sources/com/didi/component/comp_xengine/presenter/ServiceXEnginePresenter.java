package com.didi.component.comp_xengine.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xengine.lifecycle.XEngineLifeCycle;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.EventKeys;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class ServiceXEnginePresenter extends AbsGlobalXEnginePresenter {

    /* renamed from: a */
    private String f12515a;

    /* renamed from: b */
    private int f12516b;

    /* renamed from: c */
    private int f12517c;

    /* renamed from: d */
    private String f12518d;

    /* renamed from: e */
    private int f12519e;

    /* renamed from: f */
    private int f12520f;

    /* renamed from: g */
    private long f12521g;
    protected BaseEventPublisher.OnEventListener<String> mOrderStatusChangeListener = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            String a = ServiceXEnginePresenter.this.TAG;
            LogUtils.m31493i(a, "onEvent:event = " + str + ", orderId = " + TravelUtil.getRichOid(str2));
            if (EventKeys.XEngine.EVENT_X_ENGINE_ORDER_STATUS_CHANGE.equals(str)) {
                ServiceXEnginePresenter.this.onStatusChange(str2);
                return;
            }
            String b = ServiceXEnginePresenter.this.TAG;
            LogUtils.m31492e(b, "invalid event, event = " + str + ", orderId = " + TravelUtil.getRichOid(str2));
        }
    };

    /* access modifiers changed from: protected */
    public String getScene() {
        return XERequestKey.SCENE_TRIP;
    }

    public void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
    }

    public ServiceXEnginePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        BaseEventPublisher.getPublisher().subscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_STATUS_CHANGE, this.mOrderStatusChangeListener);
        XEngineLifeCycle.getInstance().setServiceEngineActive(true);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_STATUS_CHANGE, this.mOrderStatusChangeListener);
        XEngineLifeCycle.getInstance().setServiceEngineActive(false);
    }

    /* access modifiers changed from: protected */
    public void onStatusChange(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtils.m31492e(this.TAG, "onStatusChange:orderId is empty");
        } else if (!str.equals(this.mComponentProxy.getOrderId())) {
            String str2 = this.TAG;
            LogUtils.m31492e(str2, "onStatusChange:orderId not match, current orderId = " + this.mComponentProxy.getOrderId() + ", event orderId = " + str);
        } else {
            CarOrder order = CarOrderHelper.getOrder();
            if (order == null) {
                XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
                return;
            }
            DTSDKOrderStatus dTSDKOrderStatus = order.orderState;
            int status = dTSDKOrderStatus.status();
            int subStatus = dTSDKOrderStatus.subStatus();
            String str3 = dTSDKOrderStatus.md5;
            if (TextUtils.isEmpty(this.f12515a) || !this.f12515a.equals(order.oid) || this.f12516b != status || this.f12517c != subStatus || (!TextUtils.isEmpty(str3) && !str3.equals(this.f12518d))) {
                XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
                m8502b();
                this.f12515a = order.oid;
                this.f12516b = order.status;
                this.f12517c = order.substatus;
                this.f12518d = str3;
            }
            if (!(status == 7 || (this.f12519e == 7 && status == 4 && subStatus == 4001))) {
                if (this.f12519e == 4 && this.f12520f == 4001 && status == 4 && subStatus == 4003) {
                    this.f12521g = System.currentTimeMillis() - this.f12521g;
                    HashMap hashMap = new HashMap();
                    hashMap.put("time", Long.valueOf(this.f12521g));
                    OmegaSDKAdapter.trackEvent("ibt_gp_orderstatus_time_sw", (Map<String, Object>) hashMap);
                } else if (this.f12519e == 4 && this.f12520f == 4003 && status == 4 && subStatus == 4006) {
                    this.f12521g = System.currentTimeMillis() - this.f12521g;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("time", Long.valueOf(this.f12521g));
                    OmegaSDKAdapter.trackEvent("ibt_gp_orderstatus_time_sw", (Map<String, Object>) hashMap2);
                } else if (this.f12519e == 4 && this.f12520f == 4006 && (status == 2 || status == 6 || status == 5 || status == 3)) {
                    this.f12521g = System.currentTimeMillis() - this.f12521g;
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("time", Long.valueOf(this.f12521g));
                    OmegaSDKAdapter.trackEvent("ibt_gp_orderstatus_time_sw", (Map<String, Object>) hashMap3);
                }
            }
            this.f12521g = System.currentTimeMillis();
            this.f12519e = status;
            this.f12520f = subStatus;
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        this.f12521g = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        if (this.f12519e == 4) {
            this.f12521g = System.currentTimeMillis() - this.f12521g;
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(this.f12521g));
            OmegaSDKAdapter.trackEvent("ibt_gp_orderstatus_time_sw", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: b */
    private void m8502b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (this.f12516b != order.status || this.f12516b != order.substatus) {
                HashMap hashMap = new HashMap();
                hashMap.put("status", Integer.valueOf(order.status));
                hashMap.put("substatus", Integer.valueOf(order.substatus));
                GLog.m7966d("ibt_gp_orderstatus_sw", "status:" + order.status + "....substatus:" + order.substatus, new Exception());
                OmegaSDKAdapter.trackEvent("ibt_gp_orderstatus_sw", (Map<String, Object>) hashMap);
            }
        }
    }
}
