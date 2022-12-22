package com.didichuxing.omega.sdk.cdnmonitor.detector;

import com.didi.sdk.push.ServerParam;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.omega.sdk.cdnmonitor.detector.cname.CNameUtils;
import com.didichuxing.omega.sdk.cdnmonitor.ping.PingResult;
import com.didichuxing.omega.sdk.common.collector.CustomCollector;
import com.didichuxing.omega.sdk.common.collector.LocationCollector;
import com.didichuxing.omega.sdk.common.collector.NetworkCollector;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.common.utils.TraceRouteWithPing;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CdnDetectionResult {
    private int appId = 1;
    private String carrier;
    private int cellId;
    private String cname;
    private int contentLength = 0;
    private int detectErrCode = 1000;
    private String detectIp = "";
    private String detectUrl;
    private String downFileMd5;
    private int httpDuration;
    private int lac;
    private double lat;
    private double lng;
    private String localDns;
    private String networkType;
    private String osType = "android";
    private float pingErrorRatio;
    private String pingResponse;
    private float pingTime;
    private String resHeaders;
    private long timeStamp;
    private String uid;

    public CdnDetectionResult(String str) {
        this.detectUrl = str;
    }

    public int getDetectErrCode() {
        return this.detectErrCode;
    }

    public void setDetectErrCode(int i) {
        this.detectErrCode = i;
    }

    public void fetchEnvironmentParameters() {
        this.carrier = NetworkCollector.getNetworkOperatorName();
        this.networkType = NetworkCollector.getNetworkType();
        this.uid = CustomCollector.getUid();
        this.lac = NetworkCollector.getLac();
        this.cellId = NetworkCollector.getCellid();
        double[] location = LocationCollector.getLocation();
        if (location != null && location.length >= 2) {
            this.lng = location[0];
            this.lat = location[1];
        }
        this.timeStamp = System.currentTimeMillis();
        String dns = TraceRouteWithPing.getDNS();
        this.localDns = dns;
        this.cname = CNameUtils.getNetCName(this.detectUrl, dns);
    }

    public void setPingInfo(PingResult pingResult) {
        this.detectIp = pingResult.getDetectIp();
        this.pingTime = pingResult.getPingTime();
        this.pingErrorRatio = pingResult.getPingErrorRadio();
        this.pingResponse = pingResult.getPingResponse();
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("carrier", this.carrier);
        hashMap.put("networkType", this.networkType);
        hashMap.put(ServerParam.PARAM_DDRIVER_OSTYPE, this.osType);
        hashMap.put("appId", Integer.valueOf(this.appId));
        hashMap.put("uid", this.uid);
        hashMap.put("lac", Integer.valueOf(this.lac));
        hashMap.put("cellId", Integer.valueOf(this.cellId));
        hashMap.put("lng", Double.valueOf(this.lng));
        hashMap.put("lat", Double.valueOf(this.lat));
        hashMap.put("timeStamp", Long.valueOf(this.timeStamp));
        hashMap.put("localDns", this.localDns);
        hashMap.put("detectUrl", this.detectUrl);
        hashMap.put("detectErrCode", Integer.valueOf(this.detectErrCode));
        hashMap.put("downFileMd5", this.downFileMd5);
        hashMap.put("resHeaders", this.resHeaders);
        hashMap.put("httpDuration", Integer.valueOf(this.httpDuration));
        hashMap.put("contentLength", Integer.valueOf(this.contentLength));
        hashMap.put("detectIp", this.detectIp);
        hashMap.put("pingTime", Float.valueOf(this.pingTime));
        hashMap.put("pingErrorRatio", Float.valueOf(this.pingErrorRatio));
        hashMap.put("pingResponse", this.pingResponse);
        hashMap.put("cname", this.cname);
        return hashMap;
    }

    public void addDetectionResult(int i, int i2, Map<String, List<String>> map, int i3) {
        this.detectErrCode = i;
        this.httpDuration = i2;
        this.resHeaders = toJson(map);
        this.contentLength = i3;
    }

    private String toJson(Map<String, List<String>> map) {
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
            OLog.m34769w("headerFields toJson error");
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean hasError() {
        return getDetectErrCode() != 2200;
    }

    public void setDownFileMd5(String str) {
        this.downFileMd5 = str;
    }
}
