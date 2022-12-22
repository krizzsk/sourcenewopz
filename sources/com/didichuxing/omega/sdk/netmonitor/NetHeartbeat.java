package com.didichuxing.omega.sdk.netmonitor;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.ditest.agent.android.SavedState;
import com.didichuxing.omega.sdk.common.collector.CustomCollector;
import com.didichuxing.omega.sdk.common.collector.LocationCollector;
import com.didichuxing.omega.sdk.common.transport.HttpSender;
import com.didichuxing.omega.sdk.common.utils.TraceRouteWithPing;
import com.didichuxing.omega.sdk.netmonitor.HeartbeatInfoCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class NetHeartbeat implements Runnable {
    private static final String TAG = "NetHeartbeat";
    private static List<BizInfo> bizInfos = null;
    private static long cost = 0;
    private static int heartbeatInterval = 180000;
    private static NetHeartbeat instance = null;
    private static boolean isStarted = false;
    private static String reportUrl;
    private static long reqEndTime;
    private static long reqStartTime;
    private String errCountKey = ("netmonitor" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
    private HeartbeatMessage heartbeatMessage;
    private SavedState savedState;

    private NetHeartbeat(Context context) {
        this.savedState = new SavedState(context);
        initBaseInfo();
    }

    public static void initBizConfig(String str) {
        if (bizInfos == null) {
            bizInfos = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(new JSONTokener(str));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    bizInfos.add(new BizInfo(jSONObject.getInt("i"), jSONObject.getString("u")));
                }
            } catch (JSONException e) {
                SystemUtils.log(6, TAG, "config format err:" + e.toString() + "conf:" + str, (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.NetHeartbeat", 65);
            }
        }
    }

    public static void start(Context context) {
        if (!isStarted) {
            isStarted = true;
            HeartbeatInfoCollector.init(context);
            new Thread(getInstance(context), "Omega-HeartBeat").start();
        }
    }

    public static synchronized NetHeartbeat getInstance(Context context) {
        NetHeartbeat netHeartbeat;
        synchronized (NetHeartbeat.class) {
            if (instance == null) {
                instance = new NetHeartbeat(context);
            }
            netHeartbeat = instance;
        }
        return netHeartbeat;
    }

    public static void setHeartBeatInterval(int i) {
        heartbeatInterval = i;
    }

    public static void setReportUrl(String str) {
        reportUrl = str;
    }

    private void initBaseInfo() {
        HeartbeatMessage heartbeatMessage2 = new HeartbeatMessage();
        this.heartbeatMessage = heartbeatMessage2;
        heartbeatMessage2.setCarrier(HeartbeatInfoCollector.getCarrier());
        this.heartbeatMessage.setPackageName(HeartbeatInfoCollector.getPackageName());
    }

    private boolean uploadHeartbeatMsg() {
        int cityId = CustomCollector.getCityId();
        if (cityId <= 0) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SystemUtils.log(5, TAG, "city id:" + cityId, (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.NetHeartbeat", 132);
            return false;
        }
        this.heartbeatMessage.setNetMode(HeartbeatInfoCollector.getNetworkType());
        this.heartbeatMessage.setCityId(cityId);
        this.heartbeatMessage.setUid(CustomCollector.getUid());
        double[] location = LocationCollector.getLocation();
        if (location != null && location.length >= 2) {
            this.heartbeatMessage.setLat(location[0]);
            this.heartbeatMessage.setLng(location[1]);
        }
        HeartbeatInfoCollector.GSMCellLocationInfo gSMCellLocationInfo = HeartbeatInfoCollector.getGSMCellLocationInfo();
        this.heartbeatMessage.setLac(gSMCellLocationInfo.getLac());
        this.heartbeatMessage.setCellId(gSMCellLocationInfo.getCellid());
        this.heartbeatMessage.setDns(TraceRouteWithPing.getDNS());
        for (BizInfo next : bizInfos) {
            this.heartbeatMessage.setReqTime(next.getReqTime());
            this.heartbeatMessage.setBizId(next.getBizId());
            this.heartbeatMessage.setErrCount(getErrCount(next.getBizId()));
            reqStartTime = System.currentTimeMillis();
            String generatorQueryString = this.heartbeatMessage.generatorQueryString();
            SystemUtils.log(3, TAG, "net monitor query:" + generatorQueryString, (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.NetHeartbeat", 162);
            String httpPost = HttpSender.httpPost(next.getUrl(), generatorQueryString);
            SystemUtils.log(3, TAG, "net monitor:" + httpPost, (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.NetHeartbeat", 164);
            reqEndTime = System.currentTimeMillis();
            if (httpPost == null) {
                next.setReqTime(-1);
                addErrCount(next.getBizId());
            } else {
                cleanErrCount(next.getBizId());
                NetHeartbeatResponse netHeartbeatResponse = new NetHeartbeatResponse();
                netHeartbeatResponse.initNetHeartbeatResponse(httpPost);
                if (!netHeartbeatResponse.success || netHeartbeatResponse.getCode() != 0) {
                    SystemUtils.log(3, TAG, "Heartbeat fail:" + netHeartbeatResponse.getMsg(), (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.NetHeartbeat", 181);
                    next.setReqTime(0);
                } else {
                    long cost2 = (long) netHeartbeatResponse.getCost();
                    cost = cost2;
                    next.setReqTime((reqEndTime - reqStartTime) - cost2);
                    if (netHeartbeatResponse.isNeedPing() || netHeartbeatResponse.isNeedTraceRoute()) {
                        new Thread(new TraceThread(netHeartbeatResponse.isNeedPing(), netHeartbeatResponse.isNeedTraceRoute(), next, reportUrl, this.heartbeatMessage), "Omega-heartbeat").start();
                    }
                }
            }
        }
        return true;
    }

    public void run() {
        while (true) {
            if (uploadHeartbeatMsg()) {
                try {
                    Thread.sleep((long) heartbeatInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cleanErrCount(int i) {
        if (this.savedState != null && this.errCountKey != null) {
            String str = this.errCountKey + i;
            this.errCountKey = str;
            this.savedState.save(str, 0);
        }
    }

    public int getErrCount(int i) {
        if (this.savedState == null || this.errCountKey == null) {
            return 0;
        }
        String str = this.errCountKey + i;
        this.errCountKey = str;
        return this.savedState.getInt(str);
    }

    public void addErrCount(int i) {
        if (this.savedState != null && this.errCountKey != null) {
            String str = this.errCountKey + i;
            this.errCountKey = str;
            SavedState savedState2 = this.savedState;
            savedState2.save(str, savedState2.getInt(str) + 1);
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
                SystemUtils.log(6, NetHeartbeat.TAG, "parse response fail:" + e.toString() + "res:" + str, (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.NetHeartbeat$NetHeartbeatResponse", 260);
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
}
