package com.didichuxing.omega.sdk.analysis;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
    private static File mInternalCacheFile;

    static File getInternalCacheFile(String str) {
        if (mInternalCacheFile == null) {
            File internalRecordDir = RecordStorage.getInternalRecordDir();
            mInternalCacheFile = new File(internalRecordDir, "e.cache_" + PackageCollector.getVC() + "_" + PackageCollector.getVN() + "_" + OmegaConfig.APP_ISSUE + "_" + str);
        }
        return mInternalCacheFile;
    }

    public static synchronized void push(Event event) {
        synchronized (EventStorage.class) {
            Security.push(event);
        }
    }

    public static synchronized void clean() {
        synchronized (EventStorage.class) {
            File internalCacheFile = getInternalCacheFile(RuntimeCheck.getProcessNameInMD5());
            if (internalCacheFile != null && internalCacheFile.exists() && !internalCacheFile.delete()) {
                internalCacheFile.delete();
            }
        }
    }

    public static synchronized List<Event> pollAll() {
        LinkedList linkedList;
        synchronized (EventStorage.class) {
            linkedList = new LinkedList();
            linkedList.addAll(pollCacheAll(getInternalCacheFile(RuntimeCheck.getProcessNameInMD5())));
        }
        return linkedList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:27|28|29|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:55|(2:57|58)|(2:61|62)|63|64) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006e, code lost:
        if (r7 == null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0082, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0045 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0080 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0069 A[SYNTHETIC, Splitter:B:48:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.List<com.didichuxing.omega.sdk.common.record.Event> pollCacheAll(java.io.File r7) {
        /*
            java.lang.Class<com.didichuxing.omega.sdk.analysis.EventStorage> r0 = com.didichuxing.omega.sdk.analysis.EventStorage.class
            monitor-enter(r0)
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ all -> 0x0083 }
            r1.<init>()     // Catch:{ all -> 0x0083 }
            if (r7 == 0) goto L_0x0081
            boolean r2 = r7.exists()     // Catch:{ all -> 0x0083 }
            if (r2 != 0) goto L_0x0012
            goto L_0x0081
        L_0x0012:
            long r2 = r7.length()     // Catch:{ all -> 0x0083 }
            r4 = 614400(0x96000, double:3.03554E-318)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x001f
            monitor-exit(r0)
            return r1
        L_0x001f:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0083 }
            long r4 = r7.lastModified()     // Catch:{ all -> 0x0083 }
            long r2 = r2 - r4
            r4 = 172800000(0xa4cb800, double:8.53745436E-316)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0031
            monitor-exit(r0)
            return r1
        L_0x0031:
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0061 }
            r3.<init>(r7)     // Catch:{ all -> 0x0061 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x005e }
            r7.<init>(r3)     // Catch:{ all -> 0x005e }
        L_0x003c:
            java.lang.String r2 = r7.readLine()     // Catch:{ all -> 0x005f }
            if (r2 != 0) goto L_0x0049
            r3.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            r7.close()     // Catch:{ Exception -> 0x0071 }
            goto L_0x0071
        L_0x0049:
            java.lang.String r2 = com.didichuxing.omega.sdk.analysis.Security.decrypt(r2)     // Catch:{ all -> 0x005f }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x0054
            goto L_0x003c
        L_0x0054:
            com.didichuxing.omega.sdk.common.record.Event r2 = com.didichuxing.omega.sdk.common.record.Event.fromJson(r2)     // Catch:{ all -> 0x005f }
            if (r2 == 0) goto L_0x003c
            r1.add(r2)     // Catch:{ all -> 0x005f }
            goto L_0x003c
        L_0x005e:
            r7 = r2
        L_0x005f:
            r2 = r3
            goto L_0x0062
        L_0x0061:
            r7 = r2
        L_0x0062:
            java.lang.String r3 = "pollAll fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r3)     // Catch:{ all -> 0x0073 }
            if (r2 == 0) goto L_0x006e
            r2.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x006e
        L_0x006d:
        L_0x006e:
            if (r7 == 0) goto L_0x0071
            goto L_0x0045
        L_0x0071:
            monitor-exit(r0)
            return r1
        L_0x0073:
            r1 = move-exception
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007b
        L_0x007a:
        L_0x007b:
            if (r7 == 0) goto L_0x0080
            r7.close()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            throw r1     // Catch:{ all -> 0x0083 }
        L_0x0081:
            monitor-exit(r0)
            return r1
        L_0x0083:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.analysis.EventStorage.pollCacheAll(java.io.File):java.util.List");
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
