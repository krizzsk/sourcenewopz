package com.didichuxing.apollo.sdk.dataprovider;

import android.content.Context;
import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.apollo.sdk.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.SoftReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DCache {

    /* renamed from: a */
    private static DCacheImpl f45602a;

    public static void init(Context context) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "dcache init start");
        f45602a = new DCacheImpl(context);
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "dcache init end");
    }

    public static <T> T getObject(String str, Class<T> cls) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache#getObject: " + str);
        DCacheImpl dCacheImpl = f45602a;
        if (dCacheImpl == null) {
            return null;
        }
        T object = dCacheImpl.getObject(str, cls);
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache#getObject done");
        return object;
    }

    public static <T> void putObject(String str, T t) {
        LogUtils.m32690d("DCache#putObject: " + str);
        DCacheImpl dCacheImpl = f45602a;
        if (dCacheImpl != null) {
            dCacheImpl.putObject(str, t);
        }
    }

    public static void clearCache(String str) {
        LogUtils.m32690d("DCache#clearCache: " + str);
        DCacheImpl dCacheImpl = f45602a;
        if (dCacheImpl != null) {
            dCacheImpl.clearCache(str);
        }
    }

    static class DCacheImpl {
        private Context context;
        private Map<String, SoftReference<ReentrantReadWriteLock>> lockMap;

        private DCacheImpl(Context context2) {
            this.lockMap = new HashMap();
            this.context = context2;
        }

        /* JADX INFO: finally extract failed */
        public <T> T getObject(String str, Class<T> cls) {
            LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache try load cache file");
            if (TextUtils.isEmpty(str) || this.context == null) {
                return null;
            }
            ReentrantReadWriteLock lock = getLock(str);
            Boolean.valueOf(false);
            lock.readLock().lock();
            try {
                File file = getFile(str, false);
                if (file == null || !file.exists()) {
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache file null returned");
                    lock.readLock().unlock();
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache file loaded");
                    return null;
                }
                T readObjectByGson = readObjectByGson(cls, file);
                lock.readLock().unlock();
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache file loaded");
                return readObjectByGson;
            } catch (Throwable th) {
                lock.readLock().unlock();
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache file loaded");
                throw th;
            }
        }

        private <T> T readObjectByGson(Class<T> cls, File file) throws FileNotFoundException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 1024);
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(bufferedReader);
            jsonReader.setLenient(true);
            long currentTimeMillis = System.currentTimeMillis();
            T fromJson = gson.fromJson(jsonReader, (Type) cls);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "Gson read >>> " + (currentTimeMillis2 - currentTimeMillis) + " ms");
            return fromJson;
        }

        public <T> void putObject(String str, T t) {
            LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache putObject start");
            if (TextUtils.isEmpty(str) || t == null) {
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "isEmpty(cacheKey) || value == nul");
                return;
            }
            ReentrantReadWriteLock lock = getLock(str);
            lock.writeLock().lock();
            try {
                File file = getFile(str, true);
                if (file == null || !file.exists()) {
                    lock.writeLock().unlock();
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache putObject end");
                    return;
                }
                saveObjectByGson(t, file);
                lock.writeLock().unlock();
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache putObject end");
            } catch (Throwable th) {
                lock.writeLock().unlock();
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache putObject end");
                throw th;
            }
        }

        private <T> void saveObjectByGson(T t, File file) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            Gson gson = new Gson();
            long currentTimeMillis = System.currentTimeMillis();
            gson.toJson((Object) t, (Appendable) bufferedWriter);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "gson save >>> " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            bufferedWriter.flush();
            bufferedWriter.close();
        }

        public void clearCache(String str) {
            LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache clear cache start");
            if (TextUtils.isEmpty(str)) {
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache isEmpty(cacheKet");
                return;
            }
            ReentrantReadWriteLock lock = getLock(str);
            lock.writeLock().lock();
            try {
                File file = getFile(str, false);
                if (file != null && file.exists()) {
                    file.delete();
                }
            } finally {
                lock.writeLock().unlock();
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "DCache clearCache end");
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.util.concurrent.locks.ReentrantReadWriteLock} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.util.concurrent.locks.ReentrantReadWriteLock getLock(java.lang.String r5) {
            /*
                r4 = this;
                java.util.Map<java.lang.String, java.lang.ref.SoftReference<java.util.concurrent.locks.ReentrantReadWriteLock>> r0 = r4.lockMap
                monitor-enter(r0)
                java.util.Map<java.lang.String, java.lang.ref.SoftReference<java.util.concurrent.locks.ReentrantReadWriteLock>> r1 = r4.lockMap     // Catch:{ all -> 0x0028 }
                java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0028 }
                java.lang.ref.SoftReference r1 = (java.lang.ref.SoftReference) r1     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 == 0) goto L_0x0015
                java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0028 }
                r2 = r1
                java.util.concurrent.locks.ReentrantReadWriteLock r2 = (java.util.concurrent.locks.ReentrantReadWriteLock) r2     // Catch:{ all -> 0x0028 }
            L_0x0015:
                if (r2 != 0) goto L_0x0026
                java.util.concurrent.locks.ReentrantReadWriteLock r2 = new java.util.concurrent.locks.ReentrantReadWriteLock     // Catch:{ all -> 0x0028 }
                r2.<init>()     // Catch:{ all -> 0x0028 }
                java.lang.ref.SoftReference r1 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x0028 }
                r1.<init>(r2)     // Catch:{ all -> 0x0028 }
                java.util.Map<java.lang.String, java.lang.ref.SoftReference<java.util.concurrent.locks.ReentrantReadWriteLock>> r3 = r4.lockMap     // Catch:{ all -> 0x0028 }
                r3.put(r5, r1)     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.apollo.sdk.dataprovider.DCache.DCacheImpl.getLock(java.lang.String):java.util.concurrent.locks.ReentrantReadWriteLock");
        }

        private File getFile(String str, boolean z) {
            Context context2;
            if (TextUtils.isEmpty(str) || (context2 = this.context) == null) {
                return null;
            }
            File dir = context2.getDir(GlobalCashierCoreModule.APOLLO, 0);
            File file = new File(dir.getPath() + File.separator + "cache");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, Utils.md5(str));
            if (!file2.exists()) {
                if (z) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        LogUtils.m32692e("IOException while DCache#getFile createNewFile: " + e.getMessage());
                    }
                }
                return null;
            }
            return file2;
        }
    }
}
