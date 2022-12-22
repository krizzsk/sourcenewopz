package com.didichuxing.mas.sdk.quality.collect.trafficstat;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.cache.TrafficCache;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TrafficConfig;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.TrafficDataReader;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.utils.TrafficUtils;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TrafficStatAnalysis {

    /* renamed from: a */
    private static TrafficStatAnalysis f48211a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static int f48212b;

    /* renamed from: b */
    static /* synthetic */ int m34357b() {
        int i = f48212b;
        f48212b = i + 1;
        return i;
    }

    private TrafficStatAnalysis() {
    }

    public static synchronized TrafficStatAnalysis getInstance() {
        TrafficStatAnalysis trafficStatAnalysis;
        synchronized (TrafficStatAnalysis.class) {
            if (f48211a == null) {
                f48211a = new TrafficStatAnalysis();
            }
            trafficStatAnalysis = f48211a;
        }
        return trafficStatAnalysis;
    }

    public void start(Context context) {
        TrafficUtils.init(context);
        m34358c();
        ThreadPoolHelp.Builder.schedule(1).scheduleBuilder().scheduleAtFixedRate(new Runnable() {
            public void run() {
                Thread.currentThread().setName("OmegaSDK.TrafficCache");
                Thread.currentThread().setPriority(1);
                TrafficDataReader.getInstance().getTrafficSnapshot();
                if (((long) TrafficStatAnalysis.f48212b) >= TrafficConfig.TRAFFIC_UOLOAD_INTERVAL) {
                    int unused = TrafficStatAnalysis.f48212b = 0;
                    TrafficStatAnalysis.this.m34359d();
                }
                TrafficStatAnalysis.m34357b();
            }
        }, 0, TrafficConfig.TRAFFIC_STAT_INTERVAL, TimeUnit.MILLISECONDS);
    }

    /* renamed from: c */
    private void m34358c() {
        AppStateMonitor.getInstance().registerAppStateListener(new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
            }

            public void onInBackground() {
                TrafficDataReader.getInstance().getTrafficSnapshot();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34359d() {
        Map<String, Object> readMapDataFromFile;
        if (TrafficConfig.SWITCH_TRAFFIC_GENERAL_STAT && !TrafficUtils.isUpperLimitByDay() && (readMapDataFromFile = TrafficCache.getTrafficCacheInstance().readMapDataFromFile()) != null && !readMapDataFromFile.isEmpty() && TrafficUtils.containsAllKey(readMapDataFromFile)) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : readMapDataFromFile.entrySet()) {
                hashMap.put((String) next.getKey(), JsonUtil.map2Json((Map) next.getValue()));
            }
            OmegaSDKAdapter.trackMasEvent("omega_generic_traffic_stat", (String) null, hashMap);
            TrafficUtils.addNetEventNum();
        }
    }
}
