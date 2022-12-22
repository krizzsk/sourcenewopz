package com.didichuxing.ditest.agent.android.socketanalysis.cache;

import android.content.Context;
import com.didichuxing.ditest.agent.android.socketanalysis.config.SocketConfig;
import com.didichuxing.ditest.agent.android.socketanalysis.config.StatusConfig;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.io.File;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class SocketDiskCache {
    private static SocketDiskCache fileCacheInstance;
    public static Context mContext;
    private File mSocketDiskCacheFile = null;
    private String socketFileName = "socket.log";

    private SocketDiskCache() {
    }

    public static synchronized SocketDiskCache getSocketDiskCacheInstance() {
        SocketDiskCache socketDiskCache;
        synchronized (SocketDiskCache.class) {
            if (fileCacheInstance == null) {
                fileCacheInstance = new SocketDiskCache();
            }
            socketDiskCache = fileCacheInstance;
        }
        return socketDiskCache;
    }

    public void start(Context context) {
        if (SocketConfig.SWITCH_SOCKET_TRANSACTION_STAT && SocketConfig.SOCKET_DISK_CACHE) {
            mContext = context;
            this.mSocketDiskCacheFile = new File(getSocketCacheDir(mContext), this.socketFileName);
            uploadDiskCacheIfExist();
            new Timer(true).schedule(new TimerTask() {
                public void run() {
                    SocketDiskCache.this.writeCacheFileAsync(SocketMemCache.mSocketMemoryCache);
                }
            }, SocketConfig.WRITE_DISK_INTERVAL, SocketConfig.WRITE_DISK_INTERVAL);
        }
    }

    private void uploadDiskCacheIfExist() {
        new ThreadTaskObject() {
            public void run() {
                ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                SocketDiskCache.this.uploadEventImmediatelyByDiskCache();
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void uploadEventImmediatelyByDiskCache() {
        File file = this.mSocketDiskCacheFile;
        if (file == null || !file.exists() || StatusConfig.hasFileExpiration()) {
            newFile();
            return;
        }
        Map<String, Object> readMapDataFromFile = readMapDataFromFile();
        if (readMapDataFromFile != null && !readMapDataFromFile.isEmpty()) {
            Tracker.trackEvent("omg_socket_traffic_stat", (String) null, readMapDataFromFile);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059 A[SYNTHETIC, Splitter:B:36:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0066 A[SYNTHETIC, Splitter:B:43:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.Object> readMapDataFromFile() {
        /*
            r6 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.File r1 = r6.mSocketDiskCacheFile
            monitor-enter(r1)
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0052 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0052 }
            java.io.File r5 = r6.mSocketDiskCacheFile     // Catch:{ Exception -> 0x0052 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0052 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r4.<init>()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
        L_0x001a:
            java.lang.String r5 = r3.readLine()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            if (r5 == 0) goto L_0x0024
            r4.append(r5)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            goto L_0x001a
        L_0x0024:
            int r5 = r4.length()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            if (r5 != 0) goto L_0x0037
            r3.close()     // Catch:{ IOException -> 0x0031 }
            r6.newFile()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0072 }
        L_0x0035:
            monitor-exit(r1)     // Catch:{ all -> 0x0072 }
            return r2
        L_0x0037:
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.util.Map r0 = com.didichuxing.omega.sdk.common.utils.JsonUtil.json2Map(r2)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r3.close()     // Catch:{ IOException -> 0x0046 }
            r6.newFile()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0062
        L_0x0046:
            r2 = move-exception
        L_0x0047:
            r2.printStackTrace()     // Catch:{ all -> 0x0072 }
            goto L_0x0062
        L_0x004b:
            r0 = move-exception
            r2 = r3
            goto L_0x0064
        L_0x004e:
            r2 = r3
            goto L_0x0052
        L_0x0050:
            r0 = move-exception
            goto L_0x0064
        L_0x0052:
            java.lang.String r3 = "readMapDataFromFile fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r3)     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x0060 }
            r6.newFile()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0062
        L_0x0060:
            r2 = move-exception
            goto L_0x0047
        L_0x0062:
            monitor-exit(r1)     // Catch:{ all -> 0x0072 }
            return r0
        L_0x0064:
            if (r2 == 0) goto L_0x0071
            r2.close()     // Catch:{ IOException -> 0x006d }
            r6.newFile()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0072 }
        L_0x0071:
            throw r0     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0072 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.ditest.agent.android.socketanalysis.cache.SocketDiskCache.readMapDataFromFile():java.util.Map");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        r0 = "writeCacheFileAsync2 fail";
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba A[SYNTHETIC, Splitter:B:57:0x00ba] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeCacheFileAsync(com.didichuxing.ditest.agent.android.socketanalysis.model.TransactionInfo r7) {
        /*
            r6 = this;
            boolean r0 = com.didichuxing.ditest.agent.android.socketanalysis.config.SocketConfig.SWITCH_SOCKET_TRANSACTION_STAT
            if (r0 == 0) goto L_0x00c7
            boolean r0 = com.didichuxing.ditest.agent.android.socketanalysis.config.SocketConfig.SOCKET_DISK_CACHE
            if (r0 != 0) goto L_0x000a
            goto L_0x00c7
        L_0x000a:
            if (r7 == 0) goto L_0x00c7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r0 = r7.data
            if (r0 == 0) goto L_0x00c7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r0 = r7.data
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001a
            goto L_0x00c7
        L_0x001a:
            monitor-enter(r7)
            r0 = 0
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x00a8 }
            r1.<init>()     // Catch:{ Exception -> 0x00a8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r2 = r7.data     // Catch:{ Exception -> 0x00a8 }
            r1.putAll(r2)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = "seqid"
            java.util.List<java.lang.String> r3 = r7.seqIdList     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r3 = com.didichuxing.omega.sdk.common.utils.JsonUtil.list2Json(r3)     // Catch:{ Exception -> 0x00a8 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = "ver"
            java.util.Set<java.lang.String> r3 = r7.verList     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r3 = com.didichuxing.omega.sdk.common.utils.JsonUtil.set2Json(r3)     // Catch:{ Exception -> 0x00a8 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = "tls"
            java.util.Set<java.lang.String> r3 = r7.tlsList     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r3 = com.didichuxing.omega.sdk.common.utils.JsonUtil.set2Json(r3)     // Catch:{ Exception -> 0x00a8 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = "nt"
            java.lang.String r3 = com.didichuxing.omega.sdk.common.collector.NetworkCollector.getNetworkType()     // Catch:{ Exception -> 0x00a8 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = "car"
            java.lang.String r3 = com.didichuxing.omega.sdk.common.collector.NetworkCollector.getNetworkOperatorName()     // Catch:{ Exception -> 0x00a8 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = "for"
            com.didichuxing.omega.sdk.common.backend.AppStateMonitor r3 = com.didichuxing.omega.sdk.common.backend.AppStateMonitor.getInstance()     // Catch:{ Exception -> 0x00a8 }
            boolean r3 = r3.isInForeground()     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x0067
            r3 = 1
            goto L_0x0068
        L_0x0067:
            r3 = 0
        L_0x0068:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00a8 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00a8 }
            java.io.File r2 = r6.mSocketDiskCacheFile     // Catch:{ Exception -> 0x00a8 }
            if (r2 != 0) goto L_0x0076
            r6.newFile()     // Catch:{ Exception -> 0x00a8 }
        L_0x0076:
            java.io.File r2 = r6.mSocketDiskCacheFile     // Catch:{ Exception -> 0x00a8 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x00a8 }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ all -> 0x009a }
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ all -> 0x009a }
            java.io.File r5 = r6.mSocketDiskCacheFile     // Catch:{ all -> 0x009a }
            r4.<init>(r5)     // Catch:{ all -> 0x009a }
            r3.<init>(r4)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = com.didichuxing.omega.sdk.common.utils.JsonUtil.map2Json(r1)     // Catch:{ all -> 0x00a4 }
            r3.write(r0)     // Catch:{ all -> 0x00a4 }
            r3.flush()     // Catch:{ all -> 0x00a4 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a4 }
            r3.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x00b6
        L_0x0094:
            java.lang.String r0 = "writeCacheFileAsync2 fail"
        L_0x0096:
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r0)     // Catch:{ all -> 0x00c4 }
            goto L_0x00b6
        L_0x009a:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L_0x009d:
            monitor-exit(r2)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ Exception -> 0x00a2, all -> 0x009f }
        L_0x009f:
            r1 = move-exception
            r0 = r3
            goto L_0x00b8
        L_0x00a2:
            r0 = r3
            goto L_0x00a8
        L_0x00a4:
            r0 = move-exception
            goto L_0x009d
        L_0x00a6:
            r1 = move-exception
            goto L_0x00b8
        L_0x00a8:
            java.lang.String r1 = "writeCacheFileAsync1 fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r1)     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x00b6
            r0.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00b6
        L_0x00b3:
            java.lang.String r0 = "writeCacheFileAsync2 fail"
            goto L_0x0096
        L_0x00b6:
            monitor-exit(r7)     // Catch:{ all -> 0x00c4 }
            return
        L_0x00b8:
            if (r0 == 0) goto L_0x00c3
            r0.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c3
        L_0x00be:
            java.lang.String r0 = "writeCacheFileAsync2 fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r0)     // Catch:{ all -> 0x00c4 }
        L_0x00c3:
            throw r1     // Catch:{ all -> 0x00c4 }
        L_0x00c4:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00c4 }
            throw r0
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.ditest.agent.android.socketanalysis.cache.SocketDiskCache.writeCacheFileAsync(com.didichuxing.ditest.agent.android.socketanalysis.model.TransactionInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[SYNTHETIC, Splitter:B:22:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052 A[SYNTHETIC, Splitter:B:30:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005d A[SYNTHETIC, Splitter:B:38:0x005d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x004d=Splitter:B:27:0x004d, B:19:0x003e=Splitter:B:19:0x003e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void newFile() {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = mContext
            java.io.File r1 = r6.getSocketCacheDir(r1)
            java.lang.String r2 = r6.socketFileName
            r0.<init>(r1, r2)
            r6.mSocketDiskCacheFile = r0
            monitor-enter(r0)
            r1 = 0
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x003a, all -> 0x0035 }
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x003a, all -> 0x0035 }
            java.io.File r4 = r6.mSocketDiskCacheFile     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x003a, all -> 0x0035 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x003a, all -> 0x0035 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x003a, all -> 0x0035 }
            java.lang.String r1 = ""
            r2.write(r1)     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0031 }
            r2.flush()     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0031 }
            com.didichuxing.ditest.agent.android.socketanalysis.config.StatusConfig.savefileCreatedTime()     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0031 }
            r2.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0058
        L_0x002c:
            r1 = move-exception
        L_0x002d:
            r1.printStackTrace()     // Catch:{ all -> 0x0066 }
            goto L_0x0058
        L_0x0031:
            r1 = move-exception
            goto L_0x003e
        L_0x0033:
            r1 = move-exception
            goto L_0x004d
        L_0x0035:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x005b
        L_0x003a:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x003e:
            r1.printStackTrace()     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0058
            r2.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x0058
        L_0x0047:
            r1 = move-exception
            goto L_0x002d
        L_0x0049:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x004d:
            r1.printStackTrace()     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0058
            r2.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0058
        L_0x0056:
            r1 = move-exception
            goto L_0x002d
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            return
        L_0x005a:
            r1 = move-exception
        L_0x005b:
            if (r2 == 0) goto L_0x0065
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0066 }
        L_0x0065:
            throw r1     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.ditest.agent.android.socketanalysis.cache.SocketDiskCache.newFile():void");
    }

    public void deleteFile() {
        newFile();
    }

    private File getSocketCacheDir(Context context) {
        File file;
        try {
            file = context.getCacheDir();
            try {
                File file2 = new File(file, "alpha_net_cache");
                try {
                    if (file2.exists()) {
                        return file2;
                    }
                    file2.mkdir();
                    return file2;
                } catch (Throwable unused) {
                    file = file2;
                    OLog.m34761d("mkdir fail in getSocketCache");
                    return file;
                }
            } catch (Throwable unused2) {
                OLog.m34761d("mkdir fail in getSocketCache");
                return file;
            }
        } catch (Throwable unused3) {
            file = null;
            OLog.m34761d("mkdir fail in getSocketCache");
            return file;
        }
    }
}
