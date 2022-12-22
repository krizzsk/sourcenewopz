package com.didichuxing.ditest.agent.android;

import com.didichuxing.omega.sdk.common.utils.TraceRouteWithPing;
import java.util.HashMap;
import java.util.Map;

public class DiagThread implements Runnable {
    private Map<String, Object> attrs;
    private String host;

    public DiagThread(String str, Map<String, Object> map) {
        this.host = str;
        if (map != null) {
            this.attrs = map;
        } else {
            this.attrs = new HashMap();
        }
    }

    public void run() {
        String str;
        String str2;
        try {
            if (this.host == null || "".equals(this.host)) {
                str2 = null;
                str = null;
            } else {
                str2 = TraceRouteWithPing.executeTraceroute(this.host, 30);
                str = TraceRouteWithPing.ping(3, 3, this.host);
            }
            if (str2 != null) {
                this.attrs.put("routeInfo", str2);
                this.attrs.put("traceHost", this.host);
            }
            if (str != null) {
                this.attrs.put("pingInfo", str);
            }
            Measurements.trackNetEvent("http_api_err_diag", (String) null, this.attrs);
        } catch (Throwable th) {
            Measurements.FLAG_SYNCING = false;
            throw th;
        }
        Measurements.FLAG_SYNCING = false;
    }
}
