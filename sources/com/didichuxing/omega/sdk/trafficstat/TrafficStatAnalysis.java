package com.didichuxing.omega.sdk.trafficstat;

import android.content.Context;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.trafficstat.cache.TrafficCache;
import com.didichuxing.omega.sdk.trafficstat.config.TrafficConfig;
import com.didichuxing.omega.sdk.trafficstat.datareader.TrafficDataReader;
import com.didichuxing.omega.sdk.trafficstat.utils.TrafficUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TrafficStatAnalysis {
    /* access modifiers changed from: private */
    public static int count;
    private static TrafficStatAnalysis instance;

    static /* synthetic */ int access$008() {
        int i = count;
        count = i + 1;
        return i;
    }

    private TrafficStatAnalysis() {
    }

    public static synchronized TrafficStatAnalysis getInstance() {
        TrafficStatAnalysis trafficStatAnalysis;
        synchronized (TrafficStatAnalysis.class) {
            if (instance == null) {
                instance = new TrafficStatAnalysis();
            }
            trafficStatAnalysis = instance;
        }
        return trafficStatAnalysis;
    }

    public void start(Context context) {
        TrafficUtils.init(context);
        registerAppStateCallback();
        ThreadPoolHelp.Builder.schedule(1).scheduleBuilder().scheduleAtFixedRate(new Runnable() {
            public void run() {
                Thread.currentThread().setName("OmegaSDK.TrafficCache");
                Thread.currentThread().setPriority(1);
                TrafficDataReader.getInstance().getTrafficSnapshot();
                if (((long) TrafficStatAnalysis.count) >= TrafficConfig.TRAFFIC_UOLOAD_INTERVAL) {
                    int unused = TrafficStatAnalysis.count = 0;
                    TrafficStatAnalysis.this.uploadTrafficStatImmediately();
                }
                TrafficStatAnalysis.access$008();
            }
        }, 0, TrafficConfig.TRAFFIC_STAT_INTERVAL, TimeUnit.MILLISECONDS);
    }

    private void registerAppStateCallback() {
        AppStateMonitor.getInstance().registerAppStateListener(new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
            }

            public void onInBackground() {
                TrafficDataReader.getInstance().getTrafficSnapshot();
            }
        });
    }

    /* access modifiers changed from: private */
    public void uploadTrafficStatImmediately() {
        Map<String, Object> readMapDataFromFile;
        if (TrafficConfig.SWITCH_TRAFFIC_GENERAL_STAT && !TrafficUtils.isUpperLimitByDay() && (readMapDataFromFile = TrafficCache.getTrafficCacheInstance().readMapDataFromFile()) != null && !readMapDataFromFile.isEmpty() && TrafficUtils.containsAllKey(readMapDataFromFile)) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : readMapDataFromFile.entrySet()) {
                hashMap.put((String) next.getKey(), JsonUtil.map2Json((Map) next.getValue()));
            }
            Tracker.trackEvent("omega_generic_traffic_stat", (String) null, hashMap);
            TrafficUtils.addNetEventNum();
        }
    }
}
