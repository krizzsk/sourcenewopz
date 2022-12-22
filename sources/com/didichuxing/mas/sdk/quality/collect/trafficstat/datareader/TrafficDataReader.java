package com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader;

import android.os.Process;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.cache.TrafficCache;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TagConfig;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TrafficConfig;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot.NetworkStats;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot.NetworkStatsFactory;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.model.TrafficData;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.utils.TrafficUtils;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadTaskObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficDataReader {

    /* renamed from: a */
    private static NetworkStatsFactory f48216a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static NetworkStats f48217b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static NetworkStats f48218c;

    /* renamed from: d */
    private static TrafficDataReader f48219d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Lock f48220e = new ReentrantLock();

    private TrafficDataReader() {
        f48216a = new NetworkStatsFactory();
    }

    public static synchronized TrafficDataReader getInstance() {
        TrafficDataReader trafficDataReader;
        synchronized (TrafficDataReader.class) {
            if (f48219d == null) {
                f48219d = new TrafficDataReader();
            }
            trafficDataReader = f48219d;
        }
        return trafficDataReader;
    }

    public void getTrafficSnapshot() {
        if (TrafficConfig.SWITCH_TRAFFIC_GENERAL_STAT && !TrafficUtils.isUpperLimitByDay()) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    Thread.currentThread().setPriority(1);
                    try {
                        TrafficDataReader.this.f48220e.lock();
                        NetworkStats unused = TrafficDataReader.f48218c = TrafficDataReader.this.m34372d();
                        if (!(TrafficDataReader.f48218c == null || TrafficDataReader.f48217b == null)) {
                            NetworkStats subtract = TrafficDataReader.f48218c.subtract(TrafficDataReader.f48217b);
                            if (!subtract.isEmpty()) {
                                TrafficCache.getTrafficCacheInstance().writeCacheFileAsync(TrafficDataReader.this.m34371c(subtract));
                            }
                        }
                        NetworkStats unused2 = TrafficDataReader.f48217b = TrafficDataReader.f48218c;
                    } catch (Exception e) {
                        Tracker.trackGood("omega_generic_traffic_stat:get Traffic Snapshot fail", e);
                        e.printStackTrace();
                    } catch (Throwable th) {
                        TrafficDataReader.this.f48220e.unlock();
                        throw th;
                    }
                    TrafficDataReader.this.f48220e.unlock();
                }
            }.start();
        }
    }

    /* renamed from: c */
    private NetworkStats m34370c() {
        return f48216a.readNetworkStatsSummaryXt();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public NetworkStats m34372d() {
        return f48216a.readNetworkStatsDetail(Process.myUid());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Map<String, Object> m34371c(NetworkStats networkStats) {
        HashMap hashMap = new HashMap();
        int[] uniqueTags = networkStats.getUniqueTags();
        for (int i = 0; i < uniqueTags.length; i++) {
            Map<String, Object> a = m34365a(networkStats, uniqueTags[i]);
            if (TrafficData.isNotEmpty(a)) {
                String str = TagConfig.mapTable.get(new Integer(uniqueTags[i]));
                if (str == null || str.length() == 0) {
                    str = "unknow";
                }
                hashMap.put(str, a);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private Map<String, Object> m34365a(NetworkStats networkStats, int i) {
        Map<String, Object> emptyDataMap = TrafficData.getEmptyDataMap();
        for (int i2 = 0; i2 < networkStats.size(); i2++) {
            NetworkStats.Entry entry = new NetworkStats.Entry();
            networkStats.getValues(i2, entry);
            if (i == entry.tag) {
                if (entry.iface.indexOf("wlan") >= 0) {
                    if (entry.set == 0) {
                        emptyDataMap.put("bg_wifi_tx", Long.valueOf(entry.txBytes));
                        emptyDataMap.put("bg_wifi_rx", Long.valueOf(entry.rxBytes));
                    } else {
                        emptyDataMap.put("fg_wifi_tx", Long.valueOf(entry.txBytes));
                        emptyDataMap.put("fg_wifi_rx", Long.valueOf(entry.rxBytes));
                    }
                } else if (entry.iface.indexOf("rmnet") >= 0) {
                    if (entry.set == 0) {
                        emptyDataMap.put("bg_mobile_tx", Long.valueOf(entry.txBytes));
                        emptyDataMap.put("bg_mobile_rx", Long.valueOf(entry.rxBytes));
                    } else {
                        emptyDataMap.put("fg_mobile_tx", Long.valueOf(entry.txBytes));
                        emptyDataMap.put("fg_mobile_rx", Long.valueOf(entry.rxBytes));
                    }
                } else if (entry.set == 0) {
                    emptyDataMap.put("bg_other_tx", Long.valueOf(entry.txBytes));
                    emptyDataMap.put("bg_other_rx", Long.valueOf(entry.rxBytes));
                } else {
                    emptyDataMap.put("fg_other_tx", Long.valueOf(entry.txBytes));
                    emptyDataMap.put("fg_other_rx", Long.valueOf(entry.rxBytes));
                }
            }
        }
        return emptyDataMap;
    }
}
