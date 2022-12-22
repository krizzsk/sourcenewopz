package com.didichuxing.omega.sdk.common.record;

import android.content.Context;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.backend.UploadStrategy;
import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.Constants;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecordStorage {
    private static Context mContext;
    private static File mInternalRecordDir;
    private static String mNativeCrashDirecotry;
    private static File mNativeCrashDmpCacheDir;
    private static File mRecordCacheDir;
    private static File mRecordDir;

    public static void init(Context context) {
        mContext = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0179, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void save(com.didichuxing.omega.sdk.common.record.Record r8) {
        /*
            java.lang.Class<com.didichuxing.omega.sdk.common.record.RecordStorage> r0 = com.didichuxing.omega.sdk.common.record.RecordStorage.class
            monitor-enter(r0)
            r1 = 0
            boolean r2 = r8 instanceof com.didichuxing.omega.sdk.common.record.EventsRecord     // Catch:{ all -> 0x019d }
            r3 = 1
            if (r2 == 0) goto L_0x0044
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
            r2.<init>()     // Catch:{ all -> 0x019d }
            java.lang.String r3 = "omega_e_"
            r2.append(r3)     // Catch:{ all -> 0x019d }
            java.lang.String r3 = com.didichuxing.omega.sdk.common.perforence.RuntimeCheck.getProcessNameInMD5()     // Catch:{ all -> 0x019d }
            r2.append(r3)     // Catch:{ all -> 0x019d }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x019d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019d }
            r2.append(r3)     // Catch:{ all -> 0x019d }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x019d }
            java.lang.String r3 = r8.getRecordId()     // Catch:{ all -> 0x019d }
            r2.append(r3)     // Catch:{ all -> 0x019d }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x019d }
            java.lang.Long r3 = r8.getSeq()     // Catch:{ all -> 0x019d }
            r2.append(r3)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x019d }
            goto L_0x0111
        L_0x0044:
            boolean r1 = r8 instanceof com.didichuxing.omega.sdk.common.record.CrashRecord     // Catch:{ all -> 0x019d }
            if (r1 == 0) goto L_0x007a
            boolean r1 = r8 instanceof com.didichuxing.omega.sdk.common.record.NativeCrashRecord     // Catch:{ all -> 0x019d }
            if (r1 != 0) goto L_0x007a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
            r1.<init>()     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "omega_c_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019d }
            r1.append(r4)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x019d }
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x019d }
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x019d }
            goto L_0x00ab
        L_0x007a:
            boolean r1 = r8 instanceof com.didichuxing.omega.sdk.common.record.LagRecord     // Catch:{ all -> 0x019d }
            if (r1 == 0) goto L_0x00ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
            r1.<init>()     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "omega_l_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019d }
            r1.append(r4)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x019d }
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x019d }
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x019d }
        L_0x00ab:
            r1 = 1
            goto L_0x0111
        L_0x00ad:
            boolean r1 = r8 instanceof com.didichuxing.omega.sdk.common.record.ANRRecord     // Catch:{ all -> 0x019d }
            if (r1 == 0) goto L_0x00df
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
            r1.<init>()     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "omega_a_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019d }
            r1.append(r4)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x019d }
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x019d }
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x019d }
            goto L_0x00ab
        L_0x00df:
            boolean r1 = r8 instanceof com.didichuxing.omega.sdk.common.record.NativeCrashRecord     // Catch:{ all -> 0x019d }
            if (r1 == 0) goto L_0x017a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
            r1.<init>()     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "omega_nc_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019d }
            r1.append(r4)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x019d }
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x019d }
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x019d }
            goto L_0x00ab
        L_0x0111:
            java.util.List r3 = packRecord(r8)     // Catch:{ all -> 0x019d }
            boolean r4 = r8 instanceof com.didichuxing.omega.sdk.common.record.EventsRecord     // Catch:{ all -> 0x016a }
            if (r4 == 0) goto L_0x0123
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x016a }
            java.io.File r5 = getInternalRecordDir()     // Catch:{ all -> 0x016a }
            r4.<init>(r5, r2)     // Catch:{ all -> 0x016a }
            goto L_0x012c
        L_0x0123:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x016a }
            java.io.File r5 = getRecordDir()     // Catch:{ all -> 0x016a }
            r4.<init>(r5, r2)     // Catch:{ all -> 0x016a }
        L_0x012c:
            com.didichuxing.omega.sdk.analysis.Security.zip(r8, r3, r4)     // Catch:{ all -> 0x016a }
            long r4 = r4.length()     // Catch:{ all -> 0x016a }
            if (r1 == 0) goto L_0x0160
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x016a }
            r6.<init>()     // Catch:{ all -> 0x016a }
            java.lang.String r7 = "size"
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x016a }
            r6.put(r7, r4)     // Catch:{ all -> 0x016a }
            java.lang.String r4 = "fileName"
            r6.put(r4, r2)     // Catch:{ all -> 0x016a }
            java.lang.String r2 = "oid"
            java.lang.String r4 = com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector.getOmegaId()     // Catch:{ all -> 0x016a }
            r6.put(r2, r4)     // Catch:{ all -> 0x016a }
            java.lang.String r2 = "rid"
            java.lang.String r4 = r8.getRecordId()     // Catch:{ all -> 0x016a }
            r6.put(r2, r4)     // Catch:{ all -> 0x016a }
            java.lang.String r2 = "omega_big_pack"
            r4 = 0
            com.didichuxing.omega.sdk.analysis.Tracker.trackEvent(r2, r4, r6)     // Catch:{ all -> 0x016a }
        L_0x0160:
            if (r1 == 0) goto L_0x0178
            com.didichuxing.omega.sdk.common.backend.BackendThread r1 = com.didichuxing.omega.sdk.common.backend.BackendThread.getInstance()     // Catch:{ all -> 0x016a }
            r1.wakeup()     // Catch:{ all -> 0x016a }
            goto L_0x0178
        L_0x016a:
            java.lang.String r1 = "RecordStorage.save() fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r1)     // Catch:{ all -> 0x019d }
            boolean r1 = r8 instanceof com.didichuxing.omega.sdk.common.record.EventsRecord     // Catch:{ all -> 0x019d }
            if (r1 == 0) goto L_0x0178
            com.didichuxing.omega.sdk.common.record.EventsRecord r8 = (com.didichuxing.omega.sdk.common.record.EventsRecord) r8     // Catch:{ all -> 0x019d }
            com.didichuxing.omega.sdk.common.backend.UploadStrategy.sendDirectly(r8, r3)     // Catch:{ all -> 0x019d }
        L_0x0178:
            monitor-exit(r0)
            return
        L_0x017a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
            r1.<init>()     // Catch:{ all -> 0x019d }
            java.lang.String r2 = "RecordStorage.save(): Unexpected record type:"
            r1.append(r2)     // Catch:{ all -> 0x019d }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x019d }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x019d }
            r1.append(r8)     // Catch:{ all -> 0x019d }
            java.lang.String r8 = "."
            r1.append(r8)     // Catch:{ all -> 0x019d }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x019d }
            com.didichuxing.omega.sdk.common.utils.OLog.m34763e(r8)     // Catch:{ all -> 0x019d }
            monitor-exit(r0)
            return
        L_0x019d:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.record.RecordStorage.save(com.didichuxing.omega.sdk.common.record.Record):void");
    }

    public static String sendWithoutSave(String str, Record record) {
        return UploadStrategy.sendDirectly(str, record, packRecord(record));
    }

    public static synchronized List<File> getAllRecordFiles() {
        LinkedList linkedList;
        synchronized (RecordStorage.class) {
            linkedList = new LinkedList();
            File internalRecordDir = getInternalRecordDir();
            if (internalRecordDir != null) {
                File[] listFiles = internalRecordDir.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.getName().startsWith("omega_e_" + RuntimeCheck.getProcessNameInMD5())) {
                            linkedList.add(file);
                        }
                    }
                }
            } else {
                Tracker.trackGood("event internalrecordDir is null", (Throwable) null);
            }
        }
        return linkedList;
    }

    public static void deleteRecordFile(File file) {
        doubleDelete(file);
    }

    private static void doubleDelete(File file) {
        if (file != null && file.exists() && file.isFile() && !file.delete() && !file.delete()) {
            Tracker.trackError("delete_record_file_failed", "DeleteRecordFileFailed", "", "", (Map<String, Object>) null);
        }
    }

    public static void deleteRecordFile(String str) {
        deleteRecordFile(new File(getRecordDir(), str));
    }

    public static List<Map.Entry<String, byte[]>> packRecord(Record record) {
        LinkedList linkedList = new LinkedList();
        String json = record.toJson();
        linkedList.add(new AbstractMap.SimpleEntry(0 + ".json", json.getBytes()));
        return linkedList;
    }

    public static File getInternalRecordDir() {
        if (mInternalRecordDir == null) {
            mInternalRecordDir = new File(mContext.getFilesDir(), Constants.DIR_STORAGE_CACHE_ROOT);
        }
        try {
            if (!mInternalRecordDir.exists()) {
                mInternalRecordDir.mkdir();
            }
        } catch (Throwable unused) {
        }
        return mInternalRecordDir;
    }

    public static File getRecordDir() {
        if (mRecordDir == null) {
            File file = null;
            try {
                file = mContext.getExternalFilesDir("omega");
            } catch (Throwable th) {
                Tracker.trackGood("getExternalFilesDir fail", th);
            }
            if (file == null) {
                mRecordDir = mContext.getFilesDir();
            } else if (CommonUtil.getAPILevel() >= 19) {
                mRecordDir = file;
            } else {
                try {
                    int checkCallingOrSelfPermission = mContext.checkCallingOrSelfPermission(Permission.READ_EXTERNAL_STORAGE);
                    int checkCallingOrSelfPermission2 = mContext.checkCallingOrSelfPermission(Permission.WRITE_EXTERNAL_STORAGE);
                    if (checkCallingOrSelfPermission == 0 && checkCallingOrSelfPermission2 == 0) {
                        mRecordDir = file;
                    } else {
                        mRecordDir = mContext.getFilesDir();
                    }
                } catch (Throwable unused) {
                    mRecordDir = mContext.getFilesDir();
                }
            }
        }
        return mRecordDir;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File getRecordCacheDir() {
        /*
            java.io.File r0 = mRecordCacheDir
            if (r0 != 0) goto L_0x0034
            r0 = 0
            android.content.Context r1 = mContext     // Catch:{ all -> 0x001e }
            java.io.File r0 = r1.getExternalCacheDir()     // Catch:{ all -> 0x001e }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "omega"
            r1.<init>(r0, r2)     // Catch:{ all -> 0x001e }
            boolean r0 = r1.exists()     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x0027
            r1.mkdir()     // Catch:{ all -> 0x001c }
            goto L_0x0027
        L_0x001c:
            r0 = move-exception
            goto L_0x0022
        L_0x001e:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0022:
            java.lang.String r2 = "getExternalCacheDir fail"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r2, r0)
        L_0x0027:
            if (r1 != 0) goto L_0x0032
            android.content.Context r0 = mContext
            java.io.File r0 = r0.getCacheDir()
            mRecordCacheDir = r0
            goto L_0x0034
        L_0x0032:
            mRecordCacheDir = r1
        L_0x0034:
            java.io.File r0 = mRecordCacheDir
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.record.RecordStorage.getRecordCacheDir():java.io.File");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File getNativeCrashDmpCacheDir() {
        /*
            java.io.File r0 = mNativeCrashDmpCacheDir
            if (r0 != 0) goto L_0x002b
            r0 = 0
            android.content.Context r1 = mContext     // Catch:{ all -> 0x001d }
            java.io.File r0 = r1.getExternalCacheDir()     // Catch:{ all -> 0x001d }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x001d }
            java.lang.String r2 = "alpha_nc"
            r1.<init>(r0, r2)     // Catch:{ all -> 0x001d }
            boolean r0 = r1.exists()     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x001e
            r1.mkdir()     // Catch:{ all -> 0x001c }
            goto L_0x001e
        L_0x001c:
            r0 = r1
        L_0x001d:
            r1 = r0
        L_0x001e:
            if (r1 != 0) goto L_0x0029
            android.content.Context r0 = mContext
            java.io.File r0 = r0.getCacheDir()
            mNativeCrashDmpCacheDir = r0
            goto L_0x002b
        L_0x0029:
            mNativeCrashDmpCacheDir = r1
        L_0x002b:
            java.io.File r0 = mNativeCrashDmpCacheDir
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.record.RecordStorage.getNativeCrashDmpCacheDir():java.io.File");
    }

    public static File getLogFile(File[] fileArr) {
        for (File file : fileArr) {
            if (file.getName().equals("1.log")) {
                return file;
            }
        }
        return null;
    }

    public static File[] getNativeCrashFiles() {
        if (getNativeCrashPath() == null) {
            return null;
        }
        File file = new File(getNativeCrashPath());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return file.listFiles();
    }

    public static String getNativeCrashPath() {
        String str = mNativeCrashDirecotry;
        if (str != null) {
            return str;
        }
        String absolutePath = getNativeCrashDmpCacheDir().getAbsolutePath();
        mNativeCrashDirecotry = absolutePath;
        return absolutePath;
    }

    public static void setNativeCrashDirecotry(String str) {
        mNativeCrashDirecotry = str;
    }

    public static boolean doubleDeleteFile(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        boolean delete = file.delete();
        return !delete ? file.delete() : delete;
    }
}
