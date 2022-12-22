package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector;

import com.didi.sdk.push.ServerParam;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname.CNameUtils;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.ping.PingResult;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CdnDetectionResult {

    /* renamed from: a */
    private String f47742a;

    /* renamed from: b */
    private String f47743b;

    /* renamed from: c */
    private String f47744c = "android";

    /* renamed from: d */
    private int f47745d = 1;

    /* renamed from: e */
    private String f47746e;

    /* renamed from: f */
    private int f47747f;

    /* renamed from: g */
    private int f47748g;

    /* renamed from: h */
    private double f47749h;

    /* renamed from: i */
    private double f47750i;

    /* renamed from: j */
    private long f47751j;

    /* renamed from: k */
    private String f47752k;

    /* renamed from: l */
    private String f47753l;

    /* renamed from: m */
    private int f47754m = 1000;

    /* renamed from: n */
    private String f47755n;

    /* renamed from: o */
    private String f47756o;

    /* renamed from: p */
    private int f47757p = 0;

    /* renamed from: q */
    private int f47758q;

    /* renamed from: r */
    private String f47759r = "";

    /* renamed from: s */
    private float f47760s;

    /* renamed from: t */
    private float f47761t;

    /* renamed from: u */
    private String f47762u;

    /* renamed from: v */
    private String f47763v;

    public CdnDetectionResult(String str) {
        this.f47753l = str;
    }

    public int getDetectErrCode() {
        return this.f47754m;
    }

    public void setDetectErrCode(int i) {
        this.f47754m = i;
    }

    public void fetchEnvironmentParameters() {
        this.f47742a = NetworkCollector.getNetworkOperatorType();
        this.f47743b = NetworkCollector.getNetworkType();
        this.f47746e = CustomCollector.getUid();
        this.f47747f = NetworkCollector.getLac();
        this.f47748g = NetworkCollector.getCellid();
        double[] location = LocationCollector.getLocation();
        if (location != null && location.length >= 2) {
            this.f47750i = location[0];
            this.f47749h = location[1];
        }
        this.f47751j = System.currentTimeMillis();
        String dns = TraceRouteWithPing.getDNS();
        this.f47752k = dns;
        this.f47763v = CNameUtils.getNetCName(this.f47753l, dns);
    }

    public void setPingInfo(PingResult pingResult) {
        this.f47759r = pingResult.getDetectIp();
        this.f47760s = pingResult.getPingTime();
        this.f47761t = pingResult.getPingErrorRadio();
        this.f47762u = pingResult.getPingResponse();
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("carrier", this.f47742a);
        hashMap.put("networkType", this.f47743b);
        hashMap.put(ServerParam.PARAM_DDRIVER_OSTYPE, this.f47744c);
        hashMap.put("appId", Integer.valueOf(this.f47745d));
        hashMap.put("uid", this.f47746e);
        hashMap.put("lac", Integer.valueOf(this.f47747f));
        hashMap.put("cellId", Integer.valueOf(this.f47748g));
        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation()) {
            hashMap.put("lng", Double.valueOf(this.f47750i));
            hashMap.put("lat", Double.valueOf(this.f47749h));
        }
        hashMap.put("timeStamp", Long.valueOf(this.f47751j));
        hashMap.put("localDns", this.f47752k);
        hashMap.put("detectUrl", this.f47753l);
        hashMap.put("detectErrCode", Integer.valueOf(this.f47754m));
        hashMap.put("downFileMd5", this.f47755n);
        hashMap.put("resHeaders", this.f47756o);
        hashMap.put("httpDuration", Integer.valueOf(this.f47758q));
        hashMap.put("contentLength", Integer.valueOf(this.f47757p));
        hashMap.put("detectIp", this.f47759r);
        hashMap.put("pingTime", Float.valueOf(this.f47760s));
        hashMap.put("pingErrorRatio", Float.valueOf(this.f47761t));
        hashMap.put("pingResponse", this.f47762u);
        hashMap.put("cname", this.f47763v);
        return hashMap;
    }

    public void addDetectionResult(int i, int i2, Map<String, List<String>> map, int i3) {
        this.f47754m = i;
        this.f47758q = i2;
        this.f47756o = m34192a(map);
        this.f47757p = i3;
    }

    /* renamed from: a */
    private String m34192a(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.joLeft);
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(Const.jsQuote);
                sb.append((String) next.getKey());
                sb.append("\":\"");
                sb.append(JsonUtil.list2Json((List) next.getValue()));
                sb.append(Const.jsQuote);
                sb.append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        } catch (Exception unused) {
            OLog.m34424w("headerFields toJson error");
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean hasError() {
        return getDetectErrCode() != 2200;
    }

    public void setDownFileMd5(String str) {
        this.f47755n = str;
    }
}
