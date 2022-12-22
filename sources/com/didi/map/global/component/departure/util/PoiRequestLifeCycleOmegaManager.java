package com.didi.map.global.component.departure.util;

import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.HashMap;

public class PoiRequestLifeCycleOmegaManager {

    /* renamed from: a */
    private static PoiRequestLifeCycleOmegaManager f25296a;

    /* renamed from: b */
    private long f25297b;

    /* renamed from: c */
    private boolean f25298c;

    /* renamed from: d */
    private long f25299d = 0;

    /* renamed from: e */
    private boolean f25300e;

    /* renamed from: f */
    private boolean f25301f;

    private PoiRequestLifeCycleOmegaManager() {
    }

    public static PoiRequestLifeCycleOmegaManager getInstance() {
        if (f25296a == null) {
            synchronized (PoiRequestLifeCycleOmegaManager.class) {
                if (f25296a == null) {
                    PoiRequestLifeCycleOmegaManager poiRequestLifeCycleOmegaManager = new PoiRequestLifeCycleOmegaManager();
                    f25296a = poiRequestLifeCycleOmegaManager;
                    poiRequestLifeCycleOmegaManager.m18109a();
                }
            }
        }
        return f25296a;
    }

    public void onDestroy() {
        if (f25296a != null) {
            this.f25297b = 0;
            this.f25299d = 0;
            this.f25298c = true;
            this.f25300e = false;
            this.f25301f = false;
            f25296a = null;
        }
    }

    public void setBuryPoint(boolean z) {
        this.f25300e = z;
    }

    /* renamed from: a */
    private void m18109a() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f25299d = currentTimeMillis;
        this.f25297b = currentTimeMillis;
        this.f25298c = true;
        this.f25301f = false;
    }

    public void timeStampOnStartRequest() {
        if (this.f25300e && !this.f25301f && this.f25298c) {
            this.f25301f = true;
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            this.f25297b = currentTimeMillis;
            hashMap.put("time", Long.valueOf(currentTimeMillis - this.f25297b));
            GlobalOmegaTracker.trackEvent("tech_global_piconf_init_to_req_time", hashMap);
        }
    }

    public void timeStampOnGetResponse() {
        if (this.f25300e && this.f25298c) {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            this.f25297b = currentTimeMillis;
            hashMap.put("time", Long.valueOf(currentTimeMillis - this.f25297b));
            GlobalOmegaTracker.trackEvent("tech_global_piconf_poiinfo_time", hashMap);
        }
    }

    public void timeStampOnResponseResolveDone() {
        if (this.f25300e && this.f25298c) {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            this.f25297b = currentTimeMillis;
            hashMap.put("time", Long.valueOf(currentTimeMillis - this.f25297b));
            GlobalOmegaTracker.trackEvent("tech_global_piconf_show_card_time", hashMap);
        }
    }

    public void timeStampPoiRequestAllLife() {
        if (this.f25300e && this.f25298c) {
            this.f25298c = false;
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f25299d));
            GlobalOmegaTracker.trackEvent("tech_global_piconf_first_result_time", hashMap);
        }
    }

    public void onPoiRequestError() {
        this.f25298c = false;
        this.f25301f = false;
    }
}
