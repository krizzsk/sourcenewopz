package com.didichuxing.omega.sdk.netmonitor;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.common.transport.HttpSender;
import com.didichuxing.omega.sdk.common.utils.ApiSigner;
import com.didichuxing.omega.sdk.common.utils.TraceRouteWithPing;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceThread implements Runnable {
    private static final String TAG = "TraceThread";
    private BizInfo bizInfo;
    private HeartbeatMessage heartbeatMessage;
    private boolean needPing;
    private boolean needTraceRoute;
    private String pingAddress = "";
    private String pingInfo = "";
    private String reportUrl = "";
    private String routeAddress = "";
    private String routeInfo = "";

    public TraceThread(boolean z, boolean z2, BizInfo bizInfo2, String str, HeartbeatMessage heartbeatMessage2) {
        this.needPing = z;
        this.needTraceRoute = z2;
        this.bizInfo = bizInfo2;
        this.reportUrl = str;
        this.heartbeatMessage = heartbeatMessage2;
    }

    public void run() {
        Thread.currentThread().setName(getClass().getName());
        BizInfo bizInfo2 = this.bizInfo;
        if (bizInfo2 != null && this.reportUrl != null) {
            String host = getHost(bizInfo2.getUrl());
            if (host != null) {
                if (this.needPing) {
                    this.pingInfo = TraceRouteWithPing.ping(5, 10, host);
                    this.pingAddress = host;
                }
                if (this.needTraceRoute) {
                    this.routeInfo = TraceRouteWithPing.executeTraceroute(host, 30);
                    this.routeAddress = host;
                }
                if (this.pingInfo != null || this.routeInfo != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("pingAddress", this.pingAddress);
                    hashMap.put("pingInfo", this.pingInfo);
                    hashMap.put("routeAddress", this.routeAddress);
                    hashMap.put("routeInfo", this.routeInfo);
                    hashMap.put("bizId", Integer.valueOf(this.bizInfo.getBizId()));
                    HeartbeatMessage heartbeatMessage2 = this.heartbeatMessage;
                    if (heartbeatMessage2 != null) {
                        hashMap.put("uid", heartbeatMessage2.getUid());
                        hashMap.put("carrier", Integer.valueOf(this.heartbeatMessage.getCarrier()));
                        hashMap.put("cityId", Integer.valueOf(this.heartbeatMessage.getCityId()));
                        hashMap.put("netMode", Integer.valueOf(this.heartbeatMessage.getNetMode()));
                        hashMap.put("os", 1);
                        hashMap.put("lat", Double.valueOf(this.heartbeatMessage.getLat()));
                        hashMap.put("lng", Double.valueOf(this.heartbeatMessage.getLng()));
                    }
                    HttpSender.httpPost(this.reportUrl, ApiSigner.sign(hashMap));
                    return;
                }
                return;
            }
            SystemUtils.log(6, TAG, "domain url is null, bizId:" + this.bizInfo.getBizId(), (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.TraceThread", 86);
        }
    }

    public static String getHost(String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        Matcher matcher = Pattern.compile("(?<=//|)((\\w|-)+\\.)+\\w+").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}
