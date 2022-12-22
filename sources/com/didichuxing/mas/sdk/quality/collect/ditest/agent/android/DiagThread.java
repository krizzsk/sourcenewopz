package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;
import java.util.HashMap;
import java.util.Map;

public class DiagThread implements Runnable {

    /* renamed from: a */
    private String f47831a;

    /* renamed from: b */
    private Map<String, Object> f47832b;

    public DiagThread(String str, Map<String, Object> map) {
        this.f47831a = str;
        if (map != null) {
            this.f47832b = map;
        } else {
            this.f47832b = new HashMap();
        }
    }

    public void run() {
        String str;
        String str2;
        try {
            if (this.f47831a == null || "".equals(this.f47831a)) {
                str2 = null;
                str = null;
            } else {
                str2 = TraceRouteWithPing.executeTraceroute(this.f47831a, 30);
                str = TraceRouteWithPing.ping(3, 3, this.f47831a);
            }
            if (str2 != null) {
                this.f47832b.put("routeInfo", str2);
                this.f47832b.put("traceHost", this.f47831a);
            }
            if (str != null) {
                this.f47832b.put("pingInfo", str);
            }
            Measurements.trackNetEvent("http_api_err_diag", (String) null, this.f47832b);
        } catch (Throwable th) {
            Measurements.FLAG_SYNCING = false;
            throw th;
        }
        Measurements.FLAG_SYNCING = false;
    }
}
