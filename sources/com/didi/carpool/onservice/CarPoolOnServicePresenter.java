package com.didi.carpool.onservice;

import android.os.Bundle;
import android.util.Pair;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.core.ComponentParams;
import com.didi.component.service.OnServicePresenter;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class CarPoolOnServicePresenter extends OnServicePresenter {

    /* renamed from: r */
    private static final String f10677r = "CarPoolOnServicePresenter";

    /* renamed from: s */
    private Pair<Integer, Integer> f10678s = GlobalApolloUtil.getCarPoolOnServiceLoopServiceParams();

    public CarPoolOnServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        onCarPoolInfoChanged();
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        m7295b();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        m7296c();
    }

    /* renamed from: b */
    private void m7295b() {
        Pair<Integer, Integer> pair = this.f10678s;
        if (pair != null) {
            int intValue = ((Integer) pair.first).intValue();
            long intValue2 = (long) (((Integer) this.f10678s.second).intValue() * 1000);
            if (intValue == 1 && intValue2 > 0) {
                this.mOrderStatusPoll.setOuterPollInterval(true, intValue2);
                this.mOrderStatusPoll.setIsNeedAppBackgroundPoll(true);
            }
        }
    }

    /* renamed from: c */
    private void m7296c() {
        this.mOrderStatusPoll.setOuterPollInterval(false, 0);
        this.mOrderStatusPoll.setIsNeedAppBackgroundPoll(false);
    }

    /* access modifiers changed from: protected */
    public void onCarPoolInfoChanged() {
        super.onCarPoolInfoChanged();
        doPublish(BaseEventKeys.CarPool.EVENT_CAR_POOL_PEOPLE_INFOS_CHANGE);
        CarOrder order = CarOrderHelper.getOrder();
        HashMap hashMap = new HashMap();
        if (order != null) {
            hashMap.put("type", 0);
        } else {
            CarOrder carOrder = this.mComponentProxy.getCarOrder();
            if (carOrder != null) {
                hashMap.put("type", 1);
                hashMap.put("orderid", carOrder.oid);
            } else {
                hashMap.put("type", 2);
            }
        }
        OmegaSDKAdapter.trackEvent("tech_capool_onservice_carorder_null", (Map<String, Object>) hashMap);
        XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
    }
}
