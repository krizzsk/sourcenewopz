package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.ping;

import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;

public class PingExecutor {

    /* renamed from: a */
    private String f47781a;

    public PingExecutor(String str) {
        this.f47781a = str;
    }

    public PingResult execute() {
        String ping = TraceRouteWithPing.ping(5, 10, this.f47781a);
        String parseIpFromPing = TraceRouteWithPing.parseIpFromPing(ping);
        float parseAvgTimeFromPing = TraceRouteWithPing.parseAvgTimeFromPing(ping);
        float parseErrorRatio = TraceRouteWithPing.parseErrorRatio(ping);
        if (parseIpFromPing != null && parseIpFromPing.length() > 2 && Character.isDigit(parseIpFromPing.charAt(0))) {
            ping = "";
        }
        return new PingResult(parseIpFromPing, parseAvgTimeFromPing, parseErrorRatio, ping);
    }
}
