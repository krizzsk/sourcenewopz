package com.didichuxing.omega.sdk.cdnmonitor.ping;

import com.didichuxing.omega.sdk.common.utils.TraceRouteWithPing;

public class PingExecutor {
    private String host;

    public PingExecutor(String str) {
        this.host = str;
    }

    public PingResult execute() {
        String ping = TraceRouteWithPing.ping(5, 10, this.host);
        String parseIpFromPing = TraceRouteWithPing.parseIpFromPing(ping);
        float parseAvgTimeFromPing = TraceRouteWithPing.parseAvgTimeFromPing(ping);
        float parseErrorRatio = TraceRouteWithPing.parseErrorRatio(ping);
        if (parseIpFromPing != null && parseIpFromPing.length() > 2 && Character.isDigit(parseIpFromPing.charAt(0))) {
            ping = "";
        }
        return new PingResult(parseIpFromPing, parseAvgTimeFromPing, parseErrorRatio, ping);
    }
}
