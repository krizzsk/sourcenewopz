package com.didi.sdk.monitor;

import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.monitor.TrackerConstants;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class GlobalPaxTechTracker {

    /* renamed from: a */
    private long f36843a;

    private GlobalPaxTechTracker() {
        this.f36843a = 0;
    }

    private static final class Singleton {
        /* access modifiers changed from: private */
        public static final GlobalPaxTechTracker sInstance = new GlobalPaxTechTracker();

        private Singleton() {
        }
    }

    public static GlobalPaxTechTracker getInstance() {
        return Singleton.sInstance;
    }

    /* renamed from: a */
    private Map<String, Object> m26093a() {
        HashMap hashMap = new HashMap();
        hashMap.put("ab1", 1);
        hashMap.put("ab2", 1);
        hashMap.put("ab3", 1);
        return hashMap;
    }

    public void trackUnableCity(boolean z) {
        LocationPerformer.getInstance().getLastLocation();
        Map<String, Object> a = m26093a();
        a.put("show_status", Integer.valueOf(z ? 1 : 0));
        if (z) {
            this.f36843a = System.currentTimeMillis();
        }
        a.put("tag", Long.valueOf(this.f36843a));
        a.put("is_login", Integer.valueOf(OneLoginFacade.getStore().isLoginNow() ? 1 : 0));
        m26094a(TrackerConstants.Event.KEY_UNABLE_CITY, a);
    }

    public void trackSideBar(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("err_type", Integer.valueOf(i));
        hashMap.put("err_msg", str);
        m26094a(TrackerConstants.Event.KEY_SIDE_BAR_LOAD, hashMap);
    }

    public void trackEstimateError(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("err_type", Integer.valueOf(i));
        hashMap.put(ParamConst.TRACE_ID, str);
        m26094a(TrackerConstants.Event.KEY_ESTIMATE_ERROR, hashMap);
    }

    public void trackPIN(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("product_id", Integer.valueOf(i));
        hashMap.put("oid", str);
        m26094a(TrackerConstants.Event.KEY_PIN_SHOW, hashMap);
    }

    public void trackNewOrderError(int i, int i2, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("err_type", Integer.valueOf(i));
        hashMap.put("err_no", Integer.valueOf(i2));
        hashMap.put("err_msg", str);
        hashMap.put(ParamConst.TRACE_ID, str2);
        m26094a(TrackerConstants.Event.KEY_NEW_ORDER_ERROR, hashMap);
    }

    /* renamed from: a */
    private void m26094a(String str, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(TrackerConstants.OMEGA_TECH_EVENT_PEFIX + str, map);
    }
}
