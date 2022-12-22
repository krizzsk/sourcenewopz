package com.didichuxing.mas.sdk.quality.collect.netmonitor;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.transport.HttpSender;
import com.didichuxing.mas.sdk.quality.report.utils.ApiSigner;
import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceThread implements Runnable {

    /* renamed from: a */
    private static final String f48189a = "TraceThread";

    /* renamed from: b */
    private boolean f48190b;

    /* renamed from: c */
    private boolean f48191c;

    /* renamed from: d */
    private BizInfo f48192d;

    /* renamed from: e */
    private String f48193e = "";

    /* renamed from: f */
    private String f48194f = "";

    /* renamed from: g */
    private String f48195g = "";

    /* renamed from: h */
    private String f48196h = "";

    /* renamed from: i */
    private String f48197i = "";

    /* renamed from: j */
    private HeartbeatMessage f48198j;

    public TraceThread(boolean z, boolean z2, BizInfo bizInfo, String str, HeartbeatMessage heartbeatMessage) {
        this.f48190b = z;
        this.f48191c = z2;
        this.f48192d = bizInfo;
        this.f48197i = str;
        this.f48198j = heartbeatMessage;
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

    public void run() {
        Thread.currentThread().setName(getClass().getName());
        BizInfo bizInfo = this.f48192d;
        if (bizInfo != null && this.f48197i != null) {
            String host = getHost(bizInfo.getUrl());
            if (host != null) {
                if (this.f48190b) {
                    this.f48195g = TraceRouteWithPing.ping(5, 10, host);
                    this.f48193e = host;
                }
                if (this.f48191c) {
                    this.f48196h = TraceRouteWithPing.executeTraceroute(host, 30);
                    this.f48194f = host;
                }
                if (this.f48195g != null || this.f48196h != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("pingAddress", this.f48193e);
                    hashMap.put("pingInfo", this.f48195g);
                    hashMap.put("routeAddress", this.f48194f);
                    hashMap.put("routeInfo", this.f48196h);
                    hashMap.put("bizId", Integer.valueOf(this.f48192d.getBizId()));
                    HeartbeatMessage heartbeatMessage = this.f48198j;
                    if (heartbeatMessage != null) {
                        hashMap.put("uid", heartbeatMessage.getUid());
                        hashMap.put("carrier", Integer.valueOf(this.f48198j.getCarrier()));
                        hashMap.put("cityId", Integer.valueOf(this.f48198j.getCityId()));
                        hashMap.put("netMode", Integer.valueOf(this.f48198j.getNetMode()));
                        hashMap.put("os", 1);
                        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation()) {
                            hashMap.put("lat", Double.valueOf(this.f48198j.getLat()));
                            hashMap.put("lng", Double.valueOf(this.f48198j.getLng()));
                        }
                    }
                    HttpSender.httpPost(this.f48197i, ApiSigner.sign(hashMap));
                    return;
                }
                return;
            }
            SystemUtils.log(6, f48189a, "domain url is null, bizId:" + this.f48192d.getBizId(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.TraceThread", 110);
        }
    }
}
