package com.didichuxing.omega.sdk.trafficstat.datareader;

import android.os.Process;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;
import com.didichuxing.omega.sdk.trafficstat.cache.TrafficCache;
import com.didichuxing.omega.sdk.trafficstat.config.TagConfig;
import com.didichuxing.omega.sdk.trafficstat.config.TrafficConfig;
import com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats;
import com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStatsFactory;
import com.didichuxing.omega.sdk.trafficstat.model.TrafficData;
import com.didichuxing.omega.sdk.trafficstat.utils.TrafficUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficDataReader {
    /* access modifiers changed from: private */
    public static NetworkStats curSnapshot;
    private static TrafficDataReader instance;
    /* access modifiers changed from: private */
    public static NetworkStats lastSnapshot;
    private static NetworkStatsFactory networkStatsFactory;
    /* access modifiers changed from: private */
    public final Lock lock = new ReentrantLock();

    private TrafficDataReader() {
        networkStatsFactory = new NetworkStatsFactory();
    }

    public static synchronized TrafficDataReader getInstance() {
        TrafficDataReader trafficDataReader;
        synchronized (TrafficDataReader.class) {
            if (instance == null) {
                instance = new TrafficDataReader();
            }
            trafficDataReader = instance;
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
                        TrafficDataReader.this.lock.lock();
                        NetworkStats unused = TrafficDataReader.curSnapshot = TrafficDataReader.this.getAppNetworkStats();
                        if (!(TrafficDataReader.curSnapshot == null || TrafficDataReader.lastSnapshot == null)) {
                            NetworkStats subtract = TrafficDataReader.curSnapshot.subtract(TrafficDataReader.lastSnapshot);
                            if (!subtract.isEmpty()) {
                                TrafficCache.getTrafficCacheInstance().writeCacheFileAsync(TrafficDataReader.this.getCurrentTrafficInc(subtract));
                            }
                        }
                        NetworkStats unused2 = TrafficDataReader.lastSnapshot = TrafficDataReader.curSnapshot;
                    } catch (Exception e) {
                        Tracker.trackGood("omega_generic_traffic_stat:get Traffic Snapshot fail", e);
                        e.printStackTrace();
                    } catch (Throwable th) {
                        TrafficDataReader.this.lock.unlock();
                        throw th;
                    }
                    TrafficDataReader.this.lock.unlock();
                }
            }.start();
        }
    }

    private NetworkStats getDeviceNetworkStats() {
        return networkStatsFactory.readNetworkStatsSummaryXt();
    }

    /* access modifiers changed from: private */
    public NetworkStats getAppNetworkStats() {
        return networkStatsFactory.readNetworkStatsDetail(Process.myUid());
    }

    /* access modifiers changed from: private */
    public Map<String, Object> getCurrentTrafficInc(NetworkStats networkStats) {
        HashMap hashMap = new HashMap();
        int[] uniqueTags = networkStats.getUniqueTags();
        for (int i = 0; i < uniqueTags.length; i++) {
            Map<String, Object> currentTrafficInc = getCurrentTrafficInc(networkStats, uniqueTags[i]);
            if (TrafficData.isNotEmpty(currentTrafficInc)) {
                String str = TagConfig.mapTable.get(new Integer(uniqueTags[i]));
                if (str == null || str.length() == 0) {
                    str = "unknow";
                }
                hashMap.put(str, currentTrafficInc);
            }
        }
        return hashMap;
    }

    private Map<String, Object> getCurrentTrafficInc(NetworkStats networkStats, int i) {
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
