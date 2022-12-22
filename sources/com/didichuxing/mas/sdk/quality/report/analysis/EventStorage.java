package com.didichuxing.mas.sdk.quality.report.analysis;

import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.perforence.RuntimeCheck;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import java.io.File;
import java.util.List;

public class EventStorage {
    private static File mCacheFile;

    private static File getCacheFile(String str) {
        if (mCacheFile == null) {
            File recordDir = RecordStorage.getRecordDir();
            mCacheFile = new File(recordDir, "e.cache_" + PackageCollector.getVC() + "_" + PackageCollector.getVN() + "_" + MASConfig.APP_ISSUE + "_" + str);
        }
        return mCacheFile;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[SYNTHETIC, Splitter:B:16:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void push(com.didichuxing.mas.sdk.quality.report.record.Event r5) {
        /*
            java.lang.Class<com.didichuxing.mas.sdk.quality.report.analysis.EventStorage> r0 = com.didichuxing.mas.sdk.quality.report.analysis.EventStorage.class
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = com.didichuxing.mas.sdk.quality.report.perforence.RuntimeCheck.getProcessNameInMD5()     // Catch:{ all -> 0x002e }
            java.io.File r2 = getCacheFile(r2)     // Catch:{ all -> 0x002e }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x002e }
            r4 = 1
            r3.<init>(r2, r4)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = r5.toJson()     // Catch:{ all -> 0x002d }
            java.lang.String r1 = "UTF-8"
            byte[] r5 = r5.getBytes(r1)     // Catch:{ all -> 0x002d }
            r3.write(r5)     // Catch:{ all -> 0x002d }
            byte[] r5 = new byte[r4]     // Catch:{ all -> 0x002d }
            r1 = 0
            r2 = 10
            r5[r1] = r2     // Catch:{ all -> 0x002d }
            r3.write(r5)     // Catch:{ all -> 0x002d }
            r3.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0038
        L_0x002d:
            r1 = r3
        L_0x002e:
            java.lang.String r5 = "EventStorage.push fail"
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34424w(r5)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0038
            r1.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            monitor-exit(r0)
            return
        L_0x003a:
            r5 = move-exception
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            throw r5     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.analysis.EventStorage.push(com.didichuxing.mas.sdk.quality.report.record.Event):void");
    }

    public static synchronized void clean() {
        synchronized (EventStorage.class) {
            File cacheFile = getCacheFile(RuntimeCheck.getProcessNameInMD5());
            if (cacheFile.exists() && !cacheFile.delete()) {
                cacheFile.delete();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:47|(2:49|50)|(2:53|54)|55|56) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0061, code lost:
        if (r2 == null) goto L_0x0064;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0043 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0073 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x005c A[SYNTHETIC, Splitter:B:40:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.List<com.didichuxing.mas.sdk.quality.report.record.Event> pollAll() {
        /*
            java.lang.Class<com.didichuxing.mas.sdk.quality.report.analysis.EventStorage> r0 = com.didichuxing.mas.sdk.quality.report.analysis.EventStorage.class
            monitor-enter(r0)
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = com.didichuxing.mas.sdk.quality.report.perforence.RuntimeCheck.getProcessNameInMD5()     // Catch:{ all -> 0x0074 }
            java.io.File r2 = getCacheFile(r2)     // Catch:{ all -> 0x0074 }
            long r3 = r2.length()     // Catch:{ all -> 0x0074 }
            r5 = 614400(0x96000, double:3.03554E-318)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x001d
            monitor-exit(r0)
            return r1
        L_0x001d:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0074 }
            long r5 = r2.lastModified()     // Catch:{ all -> 0x0074 }
            long r3 = r3 - r5
            r5 = 172800000(0xa4cb800, double:8.53745436E-316)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x002f
            monitor-exit(r0)
            return r1
        L_0x002f:
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x0054 }
            r4.<init>(r2)     // Catch:{ all -> 0x0054 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0051 }
            r2.<init>(r4)     // Catch:{ all -> 0x0051 }
        L_0x003a:
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0052 }
            if (r3 != 0) goto L_0x0047
            r4.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            r2.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0064
        L_0x0047:
            com.didichuxing.mas.sdk.quality.report.record.Event r3 = com.didichuxing.mas.sdk.quality.report.record.Event.fromJson(r3)     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x003a
            r1.add(r3)     // Catch:{ all -> 0x0052 }
            goto L_0x003a
        L_0x0051:
            r2 = r3
        L_0x0052:
            r3 = r4
            goto L_0x0055
        L_0x0054:
            r2 = r3
        L_0x0055:
            java.lang.String r4 = "pollAll fail"
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34424w(r4)     // Catch:{ all -> 0x0066 }
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0061
        L_0x0060:
        L_0x0061:
            if (r2 == 0) goto L_0x0064
            goto L_0x0043
        L_0x0064:
            monitor-exit(r0)
            return r1
        L_0x0066:
            r1 = move-exception
            if (r3 == 0) goto L_0x006e
            r3.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x006e
        L_0x006d:
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.analysis.EventStorage.pollAll():java.util.List");
    }

    public static synchronized List<Event> pollAllAndClean() {
        List<Event> pollAll;
        synchronized (EventStorage.class) {
            pollAll = pollAll();
            clean();
        }
        return pollAll;
    }
}
