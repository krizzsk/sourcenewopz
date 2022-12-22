package com.didi.onehybrid.resource;

import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FusionZipTaskRecorder {

    /* renamed from: a */
    private static boolean f29707a = false;

    /* renamed from: b */
    private HashSet<String> f29708b = new HashSet<>();

    static {
        IToggle toggle = Apollo.getToggle("global_driver_opt_crash_types");
        if (toggle.allow()) {
            boolean z = false;
            if (1 == ((Integer) toggle.getExperiment().getParam("hybrid", 0)).intValue()) {
                z = true;
            }
            f29707a = z;
        }
    }

    /* renamed from: a */
    private static void m20855a() {
        HashMap hashMap = new HashMap();
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP, XENetConstant.DataHandlerAction.ACTION_INTERCEPT);
        OmegaSDKAdapter.trackEvent("tech_gd_hybrid_offline_task", (Map<String, Object>) hashMap);
    }

    public boolean recordTask(String str) {
        if (!f29707a) {
            return true;
        }
        synchronized (this) {
            if (this.f29708b.contains(str)) {
                m20855a();
                return false;
            }
            this.f29708b.add(str);
            return true;
        }
    }

    public boolean finishTask(String str) {
        if (!f29707a) {
            return true;
        }
        synchronized (this) {
            if (!this.f29708b.contains(str)) {
                return false;
            }
            this.f29708b.remove(str);
            return true;
        }
    }

    public synchronized int getCount() {
        return this.f29708b.size();
    }
}
