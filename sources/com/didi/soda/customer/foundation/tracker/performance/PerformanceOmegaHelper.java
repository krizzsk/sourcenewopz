package com.didi.soda.customer.foundation.tracker.performance;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import java.util.HashSet;
import java.util.Set;

public final class PerformanceOmegaHelper {

    /* renamed from: a */
    private long f41126a = -1;

    /* renamed from: b */
    private boolean f41127b;

    /* renamed from: c */
    private Set f41128c = new HashSet();

    private PerformanceOmegaHelper() {
    }

    public static PerformanceOmegaHelper getInstance() {
        return (PerformanceOmegaHelper) SingletonFactory.get(PerformanceOmegaHelper.class);
    }

    public void initStartTime() {
        this.f41127b = true;
        this.f41126a = System.currentTimeMillis();
    }

    public void reset() {
        this.f41127b = false;
        this.f41128c.clear();
    }

    public void trackAppRunDuration(String str) {
        if (!this.f41127b || this.f41128c.contains(str)) {
            return;
        }
        if (!EventConst.Performance.REQUESTFEEDDATACALLBACK.equals(str) || this.f41128c.contains(EventConst.Performance.LOCATIONMANAGER)) {
            OmegaTracker.Builder.create(EventConst.Performance.SODA_S_APP_RUN_DURATION).addEventParam("key", str).addEventParam("start_time", Long.valueOf(this.f41126a)).addEventParam("time", Long.valueOf(System.currentTimeMillis() - this.f41126a)).addEventParam(ParamConst.PARAM_PERFORMANCE_APM_ENABLED, Boolean.valueOf(FallbackController.getFallbackInfo().isOpen)).build().track();
            this.f41128c.add(str);
            if (EventConst.Performance.REQUESTFEEDDATACALLBACK.equals(str)) {
                getInstance().reset();
                return;
            }
            return;
        }
        getInstance().reset();
    }

    public void appsflyerTracker(String str, String str2) {
        if (this.f41126a <= 0) {
            this.f41126a = System.currentTimeMillis();
        }
        OmegaTracker.Builder.create(EventConst.Performance.SODA_S_APP_RUN_DURATION).addEventParam("key", str).addEventParam(ParamConst.PARAM_PROMOCODE_VALUE, str2).addEventParam("start_time", Long.valueOf(this.f41126a)).addEventParam("time", Long.valueOf(System.currentTimeMillis() - this.f41126a)).build().track();
    }

    public void popDialogTracker(String str) {
        if (this.f41126a <= 0) {
            this.f41126a = System.currentTimeMillis();
        }
        OmegaTracker.Builder.create(EventConst.Performance.SODA_S_APP_RUN_DURATION).addEventParam("key", str).addEventParam("start_time", Long.valueOf(this.f41126a)).addEventParam("time", Long.valueOf(System.currentTimeMillis() - this.f41126a)).build().track();
    }

    public void trackImagePerformance(String str, long j, int i) {
        OmegaTracker.Builder.create(EventConst.Performance.SODA_S_IMG_AVG_LDT).addEventParam("time", Long.valueOf(j)).addEventParam("url", str).addEventParam(ParamConst.PARAM_PERFORMANCE_TOTAL_IMG_CACHE_TIME, Integer.valueOf(i)).build().track();
    }

    public void trackWebViewPerformance(String str, long j) {
        OmegaTracker.Builder.create(EventConst.Performance.TONE_P_X_FUSION_RENDER_FROM_NATIVE).addEventParam(ParamConst.PARAM_PERFORMANCE_TOTAL_TIME, Long.valueOf(j)).addEventParam("url", str).build().track();
    }
}
