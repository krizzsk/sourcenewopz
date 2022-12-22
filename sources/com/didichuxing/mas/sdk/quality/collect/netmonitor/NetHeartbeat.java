package com.didichuxing.mas.sdk.quality.collect.netmonitor;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.SavedState;
import com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.transport.HttpSender;
import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class NetHeartbeat implements Runnable {

    /* renamed from: a */
    private static final String f48177a = "NetHeartbeat";

    /* renamed from: b */
    private static int f48178b = 3600000;

    /* renamed from: c */
    private static NetHeartbeat f48179c = null;

    /* renamed from: d */
    private static long f48180d = 0;

    /* renamed from: e */
    private static long f48181e = 0;

    /* renamed from: f */
    private static long f48182f = 0;

    /* renamed from: g */
    private static List<BizInfo> f48183g = null;

    /* renamed from: h */
    private static String f48184h = null;

    /* renamed from: i */
    private static boolean f48185i = false;

    /* renamed from: j */
    private HeartbeatMessage f48186j;

    /* renamed from: k */
    private String f48187k = ("netmonitor" + new SimpleDateFormat("yyyyMMdd").format(new Date()));

    /* renamed from: l */
    private SavedState f48188l;

    private NetHeartbeat(Context context) {
        this.f48188l = new SavedState(context);
        m34338a();
    }

    public static void initBizConfig(String str) {
        if (f48183g == null) {
            f48183g = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(new JSONTokener(str));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    f48183g.add(new BizInfo(jSONObject.getInt("i"), jSONObject.getString("u")));
                }
            } catch (JSONException e) {
                SystemUtils.log(6, f48177a, "config format err:" + e.toString() + "conf:" + str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat", 66);
            }
        }
    }

    public static void start(Context context) {
        if (!f48185i) {
            f48185i = true;
            HeartbeatInfoCollector.init(context);
            new Thread(getInstance(context), "Omega-HeartBeat").start();
        }
    }

    public static synchronized NetHeartbeat getInstance(Context context) {
        NetHeartbeat netHeartbeat;
        synchronized (NetHeartbeat.class) {
            if (f48179c == null) {
                f48179c = new NetHeartbeat(context);
            }
            netHeartbeat = f48179c;
        }
        return netHeartbeat;
    }

    public static void setHeartBeatInterval(int i) {
        f48178b = i;
    }

    public static void setReportUrl(String str) {
        f48184h = str;
    }

    /* renamed from: a */
    private void m34338a() {
        HeartbeatMessage heartbeatMessage = new HeartbeatMessage();
        this.f48186j = heartbeatMessage;
        heartbeatMessage.setCarrier(HeartbeatInfoCollector.getCarrier());
        this.f48186j.setPackageName(HeartbeatInfoCollector.getPackageName());
    }

    /* renamed from: b */
    private boolean m34339b() {
        int cityId = CustomCollector.getCityId();
        this.f48186j.setNetMode(HeartbeatInfoCollector.getNetworkType());
        this.f48186j.setCityId(cityId);
        this.f48186j.setUid(CustomCollector.getUid());
        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation()) {
            double[] location = LocationCollector.getLocation();
            if (location != null && location.length >= 2) {
                this.f48186j.setLat(location[0]);
                this.f48186j.setLng(location[1]);
            }
            HeartbeatInfoCollector.GSMCellLocationInfo gSMCellLocationInfo = HeartbeatInfoCollector.getGSMCellLocationInfo();
            this.f48186j.setLac(gSMCellLocationInfo.getLac());
            this.f48186j.setCellId(gSMCellLocationInfo.getCellid());
        }
        this.f48186j.setDns(TraceRouteWithPing.getDNS());
        for (BizInfo next : f48183g) {
            this.f48186j.setReqTime(next.getReqTime());
            this.f48186j.setBizId(next.getBizId());
            this.f48186j.setErrCount(getErrCount(next.getBizId()));
            f48180d = System.currentTimeMillis();
            String generatorQueryString = this.f48186j.generatorQueryString();
            SystemUtils.log(3, f48177a, "net monitor query:" + generatorQueryString, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat", 166);
            String httpPost = HttpSender.httpPost(next.getUrl(), generatorQueryString);
            SystemUtils.log(3, f48177a, "net monitor:" + httpPost, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat", 168);
            f48181e = System.currentTimeMillis();
            if (httpPost == null) {
                next.setReqTime(-1);
                addErrCount(next.getBizId());
            } else {
                cleanErrCount(next.getBizId());
                NetHeartbeatResponse netHeartbeatResponse = new NetHeartbeatResponse();
                netHeartbeatResponse.initNetHeartbeatResponse(httpPost);
                if (!netHeartbeatResponse.success || netHeartbeatResponse.getCode() != 0) {
                    SystemUtils.log(3, f48177a, "Heartbeat fail:" + netHeartbeatResponse.getMsg(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat", 185);
                    next.setReqTime(0);
                } else {
                    long cost = (long) netHeartbeatResponse.getCost();
                    f48182f = cost;
                    next.setReqTime((f48181e - f48180d) - cost);
                    if (netHeartbeatResponse.isNeedPing() || netHeartbeatResponse.isNeedTraceRoute()) {
                        new Thread(new TraceThread(netHeartbeatResponse.isNeedPing(), netHeartbeatResponse.isNeedTraceRoute(), next, f48184h, this.f48186j), "Omega-heartbeat").start();
                    }
                }
            }
        }
        return true;
    }

    public void run() {
        while (true) {
            if (m34339b()) {
                try {
                    Thread.sleep((long) f48178b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class NetHeartbeatResponse {
        private int code;
        private int cost;
        private String msg;
        private boolean needPing;
        private boolean needTraceRoute;
        /* access modifiers changed from: private */
        public boolean success;

        private NetHeartbeatResponse() {
        }

        public void initNetHeartbeatResponse(String str) {
            this.needPing = false;
            this.needTraceRoute = false;
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.code = jSONObject.getInt("code");
                this.msg = jSONObject.getString("msg");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                this.needPing = jSONObject2.getBoolean("needPing");
                this.needTraceRoute = jSONObject2.getBoolean("needRoute");
                this.cost = jSONObject2.getInt("cost");
                this.success = true;
            } catch (JSONException e) {
                SystemUtils.log(6, NetHeartbeat.f48177a, "parse response fail:" + e.toString() + "res:" + str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat$NetHeartbeatResponse", 243);
                this.success = false;
            }
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        public int getCost() {
            return this.cost;
        }

        public boolean isNeedTraceRoute() {
            return this.needTraceRoute;
        }

        public boolean isNeedPing() {
            return this.needPing;
        }
    }

    public void cleanErrCount(int i) {
        if (this.f48188l != null && this.f48187k != null) {
            String str = this.f48187k + i;
            this.f48187k = str;
            this.f48188l.save(str, 0);
        }
    }

    public int getErrCount(int i) {
        if (this.f48188l == null || this.f48187k == null) {
            return 0;
        }
        String str = this.f48187k + i;
        this.f48187k = str;
        return this.f48188l.getInt(str);
    }

    public void addErrCount(int i) {
        if (this.f48188l != null && this.f48187k != null) {
            String str = this.f48187k + i;
            this.f48187k = str;
            SavedState savedState = this.f48188l;
            savedState.save(str, savedState.getInt(str) + 1);
        }
    }
}
