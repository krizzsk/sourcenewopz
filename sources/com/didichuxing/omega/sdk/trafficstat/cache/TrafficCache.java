package com.didichuxing.omega.sdk.trafficstat.cache;

import com.didichuxing.omega.sdk.trafficstat.utils.TrafficUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TrafficCache {
    private static TrafficCache trafficCacheInstance;
    private File mTrafficDiskCacheFile;
    private String trafficFileName;

    private TrafficCache() {
        this.mTrafficDiskCacheFile = null;
        this.trafficFileName = "new_traffic.log";
        this.mTrafficDiskCacheFile = new File(TrafficUtils.getTrafficCacheDir(), this.trafficFileName);
    }

    public static synchronized TrafficCache getTrafficCacheInstance() {
        TrafficCache trafficCache;
        synchronized (TrafficCache.class) {
            if (trafficCacheInstance == null) {
                trafficCacheInstance = new TrafficCache();
            }
            trafficCache = trafficCacheInstance;
        }
        return trafficCache;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r3.close();
        newFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b8, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b9, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bf A[SYNTHETIC, Splitter:B:58:0x00bf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> readMapDataFromFile() {
        /*
            r8 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.File r1 = r8.mTrafficDiskCacheFile
            r2 = 0
            if (r1 == 0) goto L_0x00cb
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x00cb
            boolean r1 = com.didichuxing.omega.sdk.trafficstat.utils.TrafficUtils.hasFileExpiration()
            if (r1 == 0) goto L_0x0018
            goto L_0x00cb
        L_0x0018:
            java.io.File r1 = r8.mTrafficDiskCacheFile     // Catch:{ Exception -> 0x00a6 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x00a6 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0096 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x0096 }
            java.io.File r5 = r8.mTrafficDiskCacheFile     // Catch:{ all -> 0x0096 }
            r4.<init>(r5)     // Catch:{ all -> 0x0096 }
            r3.<init>(r4)     // Catch:{ all -> 0x0096 }
        L_0x0027:
            java.lang.String r2 = r3.readLine()     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x008e
            java.util.Map r2 = com.didichuxing.omega.sdk.common.utils.JsonUtil.json2Map(r2)     // Catch:{ Exception -> 0x0074 }
            if (r2 == 0) goto L_0x0027
            boolean r4 = r2.isEmpty()     // Catch:{ all -> 0x00a2 }
            if (r4 != 0) goto L_0x0027
            boolean r4 = com.didichuxing.omega.sdk.trafficstat.utils.TrafficUtils.containsAllKey(r2)     // Catch:{ all -> 0x00a2 }
            if (r4 != 0) goto L_0x0040
            goto L_0x0027
        L_0x0040:
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x00a2 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00a2 }
        L_0x0048:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00a2 }
            if (r4 == 0) goto L_0x0027
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00a2 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x00a2 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00a2 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x00a2 }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x00a2 }
            boolean r6 = r0.containsKey(r5)     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x0070
            java.lang.Object r6 = r0.get(r5)     // Catch:{ all -> 0x00a2 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x00a2 }
            java.util.Map r4 = r8.add(r4, r6)     // Catch:{ all -> 0x00a2 }
        L_0x0070:
            r0.put(r5, r4)     // Catch:{ all -> 0x00a2 }
            goto L_0x0048
        L_0x0074:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r4.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = "readMapDataFromFile prase json data err: "
            r4.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.Throwable r2 = r2.getCause()     // Catch:{ all -> 0x00a2 }
            r4.append(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00a2 }
            com.didichuxing.omega.sdk.common.utils.OLog.m34763e(r2)     // Catch:{ all -> 0x00a2 }
            goto L_0x0027
        L_0x008e:
            monitor-exit(r1)     // Catch:{ all -> 0x00a2 }
            r3.close()     // Catch:{ IOException -> 0x00b8 }
            r8.newFile()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00bc
        L_0x0096:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
        L_0x009a:
            monitor-exit(r1)     // Catch:{ all -> 0x00a2 }
            throw r2     // Catch:{ Exception -> 0x009f, all -> 0x009c }
        L_0x009c:
            r0 = move-exception
            r2 = r3
            goto L_0x00bd
        L_0x009f:
            r1 = move-exception
            r2 = r3
            goto L_0x00a7
        L_0x00a2:
            r2 = move-exception
            goto L_0x009a
        L_0x00a4:
            r0 = move-exception
            goto L_0x00bd
        L_0x00a6:
            r1 = move-exception
        L_0x00a7:
            java.lang.String r3 = "omega_generic_traffic_stat:read traffic data from file fail"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r3, r1)     // Catch:{ all -> 0x00a4 }
            r1.printStackTrace()     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x00bc
            r2.close()     // Catch:{ IOException -> 0x00b8 }
            r8.newFile()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00bc
        L_0x00b8:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00bc:
            return r0
        L_0x00bd:
            if (r2 == 0) goto L_0x00ca
            r2.close()     // Catch:{ IOException -> 0x00c6 }
            r8.newFile()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00ca:
            throw r0
        L_0x00cb:
            r8.newFile()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.trafficstat.cache.TrafficCache.readMapDataFromFile():java.util.Map");
    }

    private Map<String, Object> add(Map<String, Object> map, Map<String, Object> map2) {
        HashMap hashMap = new HashMap();
        hashMap.put("bg_mobile_rx", Long.valueOf(Long.parseLong(map.get("bg_mobile_rx").toString()) + Long.parseLong(map2.get("bg_mobile_rx").toString())));
        hashMap.put("bg_mobile_tx", Long.valueOf(Long.parseLong(map.get("bg_mobile_tx").toString()) + Long.parseLong(map2.get("bg_mobile_tx").toString())));
        hashMap.put("bg_wifi_rx", Long.valueOf(Long.parseLong(map.get("bg_wifi_rx").toString()) + Long.parseLong(map2.get("bg_wifi_rx").toString())));
        hashMap.put("bg_wifi_tx", Long.valueOf(Long.parseLong(map.get("bg_wifi_tx").toString()) + Long.parseLong(map2.get("bg_wifi_tx").toString())));
        hashMap.put("bg_other_rx", Long.valueOf(Long.parseLong(map.get("bg_other_rx").toString()) + Long.parseLong(map2.get("bg_other_rx").toString())));
        hashMap.put("bg_other_tx", Long.valueOf(Long.parseLong(map.get("bg_other_tx").toString()) + Long.parseLong(map2.get("bg_other_tx").toString())));
        hashMap.put("fg_mobile_rx", Long.valueOf(Long.parseLong(map.get("fg_mobile_rx").toString()) + Long.parseLong(map2.get("fg_mobile_rx").toString())));
        hashMap.put("fg_mobile_tx", Long.valueOf(Long.parseLong(map.get("fg_mobile_tx").toString()) + Long.parseLong(map2.get("fg_mobile_tx").toString())));
        hashMap.put("fg_wifi_rx", Long.valueOf(Long.parseLong(map.get("fg_wifi_rx").toString()) + Long.parseLong(map2.get("fg_wifi_rx").toString())));
        hashMap.put("fg_wifi_tx", Long.valueOf(Long.parseLong(map.get("fg_wifi_tx").toString()) + Long.parseLong(map2.get("fg_wifi_tx").toString())));
        hashMap.put("fg_other_rx", Long.valueOf(Long.parseLong(map.get("fg_other_rx").toString()) + Long.parseLong(map2.get("fg_other_rx").toString())));
        hashMap.put("fg_other_tx", Long.valueOf(Long.parseLong(map.get("fg_other_tx").toString()) + Long.parseLong(map2.get("fg_other_tx").toString())));
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0063 A[SYNTHETIC, Splitter:B:33:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006e A[SYNTHETIC, Splitter:B:41:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeCacheFileAsync(java.util.Map<java.lang.String, java.lang.Object> r7) {
        /*
            r6 = this;
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.io.File r0 = r6.mTrafficDiskCacheFile
            if (r0 == 0) goto L_0x0017
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0017
            boolean r0 = com.didichuxing.omega.sdk.trafficstat.utils.TrafficUtils.hasFileExpiration()
            if (r0 == 0) goto L_0x001a
        L_0x0017:
            r6.newFile()
        L_0x001a:
            java.io.File r0 = r6.mTrafficDiskCacheFile
            monitor-enter(r0)
            r1 = 0
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0058 }
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ Exception -> 0x0058 }
            java.io.File r4 = r6.mTrafficDiskCacheFile     // Catch:{ Exception -> 0x0058 }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0058 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0058 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r1.<init>()     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.lang.String r7 = com.didichuxing.omega.sdk.common.utils.JsonUtil.map2Json(r7)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r1.append(r7)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.lang.String r7 = "\n"
            r1.append(r7)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.lang.String r7 = r1.toString()     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r2.write(r7)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r2.flush()     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r2.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x006a
        L_0x004a:
            java.lang.String r7 = "write traffic cache file async2 fail"
        L_0x004c:
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r7)     // Catch:{ all -> 0x0078 }
            goto L_0x006a
        L_0x0050:
            r7 = move-exception
            r1 = r2
            goto L_0x006c
        L_0x0053:
            r7 = move-exception
            r1 = r2
            goto L_0x0059
        L_0x0056:
            r7 = move-exception
            goto L_0x006c
        L_0x0058:
            r7 = move-exception
        L_0x0059:
            java.lang.String r2 = "omega_generic_traffic_stat:write traffic data to file fail"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r2, r7)     // Catch:{ all -> 0x0056 }
            r7.printStackTrace()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x006a
            r1.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006a
        L_0x0067:
            java.lang.String r7 = "write traffic cache file async2 fail"
            goto L_0x004c
        L_0x006a:
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            return
        L_0x006c:
            if (r1 == 0) goto L_0x0077
            r1.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0077
        L_0x0072:
            java.lang.String r1 = "write traffic cache file async2 fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r1)     // Catch:{ all -> 0x0078 }
        L_0x0077:
            throw r7     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.trafficstat.cache.TrafficCache.writeCacheFileAsync(java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041 A[SYNTHETIC, Splitter:B:22:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[SYNTHETIC, Splitter:B:30:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005b A[SYNTHETIC, Splitter:B:38:0x005b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x004b=Splitter:B:27:0x004b, B:19:0x003c=Splitter:B:19:0x003c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void newFile() {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            java.io.File r1 = com.didichuxing.omega.sdk.trafficstat.utils.TrafficUtils.getTrafficCacheDir()
            java.lang.String r2 = r6.trafficFileName
            r0.<init>(r1, r2)
            r6.mTrafficDiskCacheFile = r0
            monitor-enter(r0)
            r1 = 0
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0038, all -> 0x0033 }
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0038, all -> 0x0033 }
            java.io.File r4 = r6.mTrafficDiskCacheFile     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0038, all -> 0x0033 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0038, all -> 0x0033 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0038, all -> 0x0033 }
            java.lang.String r1 = ""
            r2.write(r1)     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x002f }
            r2.flush()     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x002f }
            com.didichuxing.omega.sdk.trafficstat.utils.TrafficUtils.savefileCreatedTime()     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x002f }
            r2.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x0056
        L_0x002a:
            r1 = move-exception
        L_0x002b:
            r1.printStackTrace()     // Catch:{ all -> 0x0064 }
            goto L_0x0056
        L_0x002f:
            r1 = move-exception
            goto L_0x003c
        L_0x0031:
            r1 = move-exception
            goto L_0x004b
        L_0x0033:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x0059
        L_0x0038:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x003c:
            r1.printStackTrace()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0056
        L_0x0045:
            r1 = move-exception
            goto L_0x002b
        L_0x0047:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x004b:
            r1.printStackTrace()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0056
        L_0x0054:
            r1 = move-exception
            goto L_0x002b
        L_0x0056:
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            return
        L_0x0058:
            r1 = move-exception
        L_0x0059:
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0064 }
        L_0x0063:
            throw r1     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.trafficstat.cache.TrafficCache.newFile():void");
    }
}
