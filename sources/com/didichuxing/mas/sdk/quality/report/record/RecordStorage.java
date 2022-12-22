package com.didichuxing.mas.sdk.quality.report.record;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.backend.UploadStrategy;
import com.didichuxing.mas.sdk.quality.report.collector.ThreadCollector;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.mas.sdk.quality.report.utils.DataTrackUtil;
import com.didichuxing.mas.sdk.quality.report.utils.FileType;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecordStorage {
    private static Context mContext;
    private static String mNativeCrashDirecotry;
    private static File mNativeCrashDmpCacheDir;
    private static File mRecordCacheDir;
    private static File mRecordDir;

    public static void init(Context context) {
        mContext = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01f6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void save(com.didichuxing.mas.sdk.quality.report.record.Record r8) {
        /*
            java.lang.Class<com.didichuxing.mas.sdk.quality.report.record.RecordStorage> r0 = com.didichuxing.mas.sdk.quality.report.record.RecordStorage.class
            monitor-enter(r0)
            r1 = 0
            boolean r2 = r8 instanceof com.didichuxing.mas.sdk.quality.report.record.EventsRecord     // Catch:{ all -> 0x021a }
            r3 = 1
            if (r2 == 0) goto L_0x0038
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
            r2.<init>()     // Catch:{ all -> 0x021a }
            java.lang.String r3 = "omega_e_"
            r2.append(r3)     // Catch:{ all -> 0x021a }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x021a }
            r2.append(r3)     // Catch:{ all -> 0x021a }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x021a }
            java.lang.String r3 = r8.getRecordId()     // Catch:{ all -> 0x021a }
            r2.append(r3)     // Catch:{ all -> 0x021a }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x021a }
            java.lang.Long r3 = r8.getSeq()     // Catch:{ all -> 0x021a }
            r2.append(r3)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x021a }
            goto L_0x0171
        L_0x0038:
            boolean r1 = r8 instanceof com.didichuxing.mas.sdk.quality.report.record.CrashRecord     // Catch:{ all -> 0x021a }
            if (r1 == 0) goto L_0x00a6
            boolean r1 = r8 instanceof com.didichuxing.mas.sdk.quality.report.record.NativeCrashRecord     // Catch:{ all -> 0x021a }
            if (r1 != 0) goto L_0x00a6
            r1 = r8
            com.didichuxing.mas.sdk.quality.report.record.CrashRecord r1 = (com.didichuxing.mas.sdk.quality.report.record.CrashRecord) r1     // Catch:{ all -> 0x021a }
            boolean r1 = r1.isOOM()     // Catch:{ all -> 0x021a }
            if (r1 == 0) goto L_0x0077
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
            r1.<init>()     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "mas_oom_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x021a }
            r1.append(r4)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x021a }
            goto L_0x00a4
        L_0x0077:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
            r1.<init>()     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "mas_c_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x021a }
            r1.append(r4)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x021a }
        L_0x00a4:
            r2 = r1
            goto L_0x00d7
        L_0x00a6:
            boolean r1 = r8 instanceof com.didichuxing.mas.sdk.quality.report.record.LagRecord     // Catch:{ all -> 0x021a }
            if (r1 == 0) goto L_0x00da
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
            r1.<init>()     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "mas_l_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x021a }
            r1.append(r4)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x021a }
        L_0x00d7:
            r1 = 1
            goto L_0x0171
        L_0x00da:
            boolean r1 = r8 instanceof com.didichuxing.mas.sdk.quality.report.record.ANRRecord     // Catch:{ all -> 0x021a }
            if (r1 == 0) goto L_0x010c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
            r1.<init>()     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "mas_a_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x021a }
            r1.append(r4)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x021a }
            goto L_0x00d7
        L_0x010c:
            boolean r1 = r8 instanceof com.didichuxing.mas.sdk.quality.report.record.NativeCrashRecord     // Catch:{ all -> 0x021a }
            if (r1 == 0) goto L_0x013e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
            r1.<init>()     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "mas_nc_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x021a }
            r1.append(r4)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x021a }
            goto L_0x00d7
        L_0x013e:
            boolean r1 = r8 instanceof com.didichuxing.mas.sdk.quality.report.record.DartErrorRecord     // Catch:{ all -> 0x021a }
            if (r1 == 0) goto L_0x01f7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
            r1.<init>()     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "mas_de_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x021a }
            r1.append(r4)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r8.getRecordId()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.Long r2 = r8.getSeq()     // Catch:{ all -> 0x021a }
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x021a }
            goto L_0x00d7
        L_0x0171:
            java.util.List r3 = packRecord(r8)     // Catch:{ all -> 0x021a }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x01e7 }
            java.io.File r5 = getRecordDir()     // Catch:{ all -> 0x01e7 }
            r4.<init>(r5, r2)     // Catch:{ all -> 0x01e7 }
            java.util.List r5 = r8.getExtraFiles()     // Catch:{ all -> 0x01e7 }
            com.didichuxing.mas.sdk.quality.report.utils.ZipUtil.zip(r5, r3, r4)     // Catch:{ all -> 0x01e7 }
            java.util.List r5 = r8.getExtraFiles()     // Catch:{ all -> 0x01e7 }
            if (r5 == 0) goto L_0x01ae
            int r5 = r5.size()     // Catch:{ all -> 0x01e7 }
            if (r5 <= 0) goto L_0x01ae
            java.util.List r5 = r8.getExtraFiles()     // Catch:{ all -> 0x01e7 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x01e7 }
        L_0x0199:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x01e7 }
            if (r6 == 0) goto L_0x01ae
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x01e7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x01e7 }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x01e7 }
            r7.<init>(r6)     // Catch:{ all -> 0x01e7 }
            com.didichuxing.mas.sdk.quality.report.utils.FileUtil.delFileOnExist(r7)     // Catch:{ all -> 0x01e7 }
            goto L_0x0199
        L_0x01ae:
            long r4 = r4.length()     // Catch:{ all -> 0x01e7 }
            if (r1 == 0) goto L_0x01f5
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x01e7 }
            r1.<init>()     // Catch:{ all -> 0x01e7 }
            java.lang.String r6 = "size"
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01e7 }
            r1.put(r6, r4)     // Catch:{ all -> 0x01e7 }
            java.lang.String r4 = "fileName"
            r1.put(r4, r2)     // Catch:{ all -> 0x01e7 }
            java.lang.String r2 = "oid"
            java.lang.String r4 = com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector.getOmegaId()     // Catch:{ all -> 0x01e7 }
            r1.put(r2, r4)     // Catch:{ all -> 0x01e7 }
            java.lang.String r2 = "rid"
            java.lang.String r4 = r8.getRecordId()     // Catch:{ all -> 0x01e7 }
            r1.put(r2, r4)     // Catch:{ all -> 0x01e7 }
            java.lang.String r2 = "omega_big_pack"
            r4 = 0
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackMasEvent(r2, r4, r1)     // Catch:{ all -> 0x01e7 }
            com.didichuxing.mas.sdk.quality.report.backend.BackendThread r1 = com.didichuxing.mas.sdk.quality.report.backend.BackendThread.getInstance()     // Catch:{ all -> 0x01e7 }
            r1.wakeup()     // Catch:{ all -> 0x01e7 }
            goto L_0x01f5
        L_0x01e7:
            java.lang.String r1 = "RecordStorage.save() fail"
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34424w(r1)     // Catch:{ all -> 0x021a }
            boolean r1 = r8 instanceof com.didichuxing.mas.sdk.quality.report.record.EventsRecord     // Catch:{ all -> 0x021a }
            if (r1 == 0) goto L_0x01f5
            com.didichuxing.mas.sdk.quality.report.record.EventsRecord r8 = (com.didichuxing.mas.sdk.quality.report.record.EventsRecord) r8     // Catch:{ all -> 0x021a }
            com.didichuxing.mas.sdk.quality.report.backend.UploadStrategy.sendDirectly(r8, r3)     // Catch:{ all -> 0x021a }
        L_0x01f5:
            monitor-exit(r0)
            return
        L_0x01f7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
            r1.<init>()     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "RecordStorage.save(): Unexpected record type:"
            r1.append(r2)     // Catch:{ all -> 0x021a }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x021a }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x021a }
            r1.append(r8)     // Catch:{ all -> 0x021a }
            java.lang.String r8 = "."
            r1.append(r8)     // Catch:{ all -> 0x021a }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x021a }
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34418e(r8)     // Catch:{ all -> 0x021a }
            monitor-exit(r0)
            return
        L_0x021a:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.record.RecordStorage.save(com.didichuxing.mas.sdk.quality.report.record.Record):void");
    }

    public static String sendWithoutSave(String str, Record record) {
        return UploadStrategy.sendDirectly(str, record, packRecord(record));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cb, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.Map<java.lang.String, java.util.List<java.io.File>> getAllRecordFiles() {
        /*
            java.lang.Class<com.didichuxing.mas.sdk.quality.report.record.RecordStorage> r0 = com.didichuxing.mas.sdk.quality.report.record.RecordStorage.class
            monitor-enter(r0)
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x00cc }
            r1.<init>()     // Catch:{ all -> 0x00cc }
            java.util.LinkedList r2 = new java.util.LinkedList     // Catch:{ all -> 0x00cc }
            r2.<init>()     // Catch:{ all -> 0x00cc }
            java.util.LinkedList r3 = new java.util.LinkedList     // Catch:{ all -> 0x00cc }
            r3.<init>()     // Catch:{ all -> 0x00cc }
            java.util.LinkedList r4 = new java.util.LinkedList     // Catch:{ all -> 0x00cc }
            r4.<init>()     // Catch:{ all -> 0x00cc }
            java.util.LinkedList r5 = new java.util.LinkedList     // Catch:{ all -> 0x00cc }
            r5.<init>()     // Catch:{ all -> 0x00cc }
            java.util.LinkedList r6 = new java.util.LinkedList     // Catch:{ all -> 0x00cc }
            r6.<init>()     // Catch:{ all -> 0x00cc }
            java.util.LinkedList r7 = new java.util.LinkedList     // Catch:{ all -> 0x00cc }
            r7.<init>()     // Catch:{ all -> 0x00cc }
            java.util.LinkedList r8 = new java.util.LinkedList     // Catch:{ all -> 0x00cc }
            r8.<init>()     // Catch:{ all -> 0x00cc }
            java.io.File r9 = getRecordDir()     // Catch:{ all -> 0x00cc }
            if (r9 != 0) goto L_0x0039
            java.lang.String r2 = "recordDir is null"
            r3 = 0
            com.didichuxing.mas.sdk.quality.report.analysis.Tracker.trackGood(r2, r3)     // Catch:{ all -> 0x00cc }
            monitor-exit(r0)
            return r1
        L_0x0039:
            java.io.File[] r9 = r9.listFiles()     // Catch:{ all -> 0x00cc }
            if (r9 == 0) goto L_0x00ca
            int r10 = r9.length     // Catch:{ all -> 0x00cc }
            r11 = 1
            if (r10 >= r11) goto L_0x0045
            goto L_0x00ca
        L_0x0045:
            int r10 = r9.length     // Catch:{ all -> 0x00cc }
            r11 = 0
        L_0x0047:
            if (r11 >= r10) goto L_0x00a5
            r12 = r9[r11]     // Catch:{ all -> 0x00cc }
            java.lang.String r13 = r12.getName()     // Catch:{ all -> 0x00cc }
            java.lang.String r14 = "omega_e_"
            boolean r14 = r13.startsWith(r14)     // Catch:{ all -> 0x00cc }
            if (r14 == 0) goto L_0x005b
            r2.add(r12)     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x005b:
            java.lang.String r14 = "mas_c_"
            boolean r14 = r13.startsWith(r14)     // Catch:{ all -> 0x00cc }
            if (r14 == 0) goto L_0x0067
            r3.add(r12)     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x0067:
            java.lang.String r14 = "mas_a_"
            boolean r14 = r13.startsWith(r14)     // Catch:{ all -> 0x00cc }
            if (r14 == 0) goto L_0x0073
            r4.add(r12)     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x0073:
            java.lang.String r14 = "mas_nc_"
            boolean r14 = r13.startsWith(r14)     // Catch:{ all -> 0x00cc }
            if (r14 == 0) goto L_0x007f
            r5.add(r12)     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x007f:
            java.lang.String r14 = "mas_l_"
            boolean r14 = r13.startsWith(r14)     // Catch:{ all -> 0x00cc }
            if (r14 == 0) goto L_0x008b
            r6.add(r12)     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x008b:
            java.lang.String r14 = "mas_oom_"
            boolean r14 = r13.startsWith(r14)     // Catch:{ all -> 0x00cc }
            if (r14 == 0) goto L_0x0097
            r7.add(r12)     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x0097:
            java.lang.String r14 = "mas_de_"
            boolean r13 = r13.startsWith(r14)     // Catch:{ all -> 0x00cc }
            if (r13 == 0) goto L_0x00a2
            r8.add(r12)     // Catch:{ all -> 0x00cc }
        L_0x00a2:
            int r11 = r11 + 1
            goto L_0x0047
        L_0x00a5:
            java.lang.String r9 = "e"
            r1.put(r9, r2)     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "c"
            r1.put(r2, r3)     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "a"
            r1.put(r2, r4)     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "nc"
            r1.put(r2, r5)     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "l"
            r1.put(r2, r6)     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "oc"
            r1.put(r2, r7)     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "de"
            r1.put(r2, r8)     // Catch:{ all -> 0x00cc }
            monitor-exit(r0)
            return r1
        L_0x00ca:
            monitor-exit(r0)
            return r1
        L_0x00cc:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.record.RecordStorage.getAllRecordFiles():java.util.Map");
    }

    public static void deleteRecordFile(File file, int i, String str) {
        doubleDelete(file, i, str);
    }

    private static void doubleDelete(File file, int i, String str) {
        if (file != null && file.exists() && file.isFile() && !file.delete() && !file.delete() && !CommonUtil.isUpperLimitByDay(Constants.UPPER_LIMIT_FILE_DELETE_FAIL_KEY, 10)) {
            Tracker.trackError("delete_record_file_failed", "DeleteRecordFileFailed", i + "", str + "", (Map<String, Object>) null);
            CommonUtil.addUpperLimitByDay(Constants.UPPER_LIMIT_FILE_DELETE_FAIL_KEY);
        }
    }

    public static void deleteRecordFile(String str) {
        deleteRecordFile(new File(getRecordDir(), str), 6, "deleteRecordFile");
    }

    private static List<Map.Entry<String, byte[]>> packRecord(Record record) {
        byte[] logcat;
        LinkedList linkedList = new LinkedList();
        String json = record.toJson();
        linkedList.add(new AbstractMap.SimpleEntry(0 + ".json", json.getBytes()));
        if (record instanceof ChanceRecord) {
            ChanceRecord chanceRecord = (ChanceRecord) record;
            int i = 1;
            if (!MASConfig.BAN_LOGCAT_UPLOAD && (logcat = chanceRecord.getLogcat()) != null) {
                linkedList.add(new AbstractMap.SimpleEntry(1 + ".log", logcat));
                i = 2;
            }
            for (byte[] simpleEntry : chanceRecord.getScreenshots()) {
                StringBuilder sb = new StringBuilder();
                int i2 = i + 1;
                sb.append(i);
                sb.append(".jpg");
                linkedList.add(new AbstractMap.SimpleEntry(sb.toString(), simpleEntry));
                i = i2;
            }
        }
        return linkedList;
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
            com.didichuxing.mas.sdk.quality.report.analysis.Tracker.trackGood(r2, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.record.RecordStorage.getRecordCacheDir():java.io.File");
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
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.record.RecordStorage.getNativeCrashDmpCacheDir():java.io.File");
    }

    public static void saveNativeCrash(boolean z) {
        try {
            File[] nativeCrashFiles = getNativeCrashFiles();
            if (nativeCrashFiles != null) {
                long currentTimeMillis = System.currentTimeMillis();
                for (int i = 0; i < nativeCrashFiles.length; i++) {
                    File file = null;
                    if (currentTimeMillis - nativeCrashFiles[i].lastModified() < MASConfig.NATIVE_CRASH_EXPIRE_MS && nativeCrashFiles[i].getName().endsWith("dmp")) {
                        file = getLogFile(nativeCrashFiles);
                        NativeCrashRecord createNativeCrashRecord = RecordFactory.createNativeCrashRecord(z, nativeCrashFiles[i], file);
                        boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_native_crash", MASConfig.UPPER_LIMIT_NATIVE_CRASH_EVENT_PER_DAY);
                        DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.NATIVE_CRASH, createNativeCrashRecord.getRecordId(), isUpperLimitByDay);
                        OLog.m34418e("create native record. " + isUpperLimitByDay);
                        if (!isUpperLimitByDay) {
                            save(createNativeCrashRecord);
                            CommonUtil.addUpperLimitByDay("upper_limit_native_crash");
                        } else {
                            return;
                        }
                    }
                    if (!doubleDeleteFile(nativeCrashFiles[i])) {
                        OLog.m34418e("remove native crash dump file fail!");
                    }
                    if (file != null) {
                        file.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            OLog.m34418e("saveNativeCrash failed. " + e.getMessage());
        }
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

    private static boolean doubleDeleteFile(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        boolean delete = file.delete();
        return !delete ? file.delete() : delete;
    }

    public static void saveDartException(Map<String, Object> map) {
        CrashRecord createCrashRecord = RecordFactory.createCrashRecord();
        createCrashRecord.setErrorTrace((String) map.get("errorStackTrace"));
        String str = (String) map.get("errorName");
        createCrashRecord.setErrorMsg(str);
        createCrashRecord.put("pt", Long.valueOf(((Long) map.get("errorTime")).longValue()));
        createCrashRecord.put("ast", map.get("appStartTime"));
        createCrashRecord.put("ph", map.get("pageAccessHistory"));
        createCrashRecord.put("cp", map.get("curPage"));
        String str2 = (String) map.get(Constants.JSON_KEY_FLUTTER_SDK_VERSION);
        createCrashRecord.put(Constants.JSON_KEY_FLUTTER_SDK_VERSION, str2);
        String str3 = (String) map.get("platformVersion");
        createCrashRecord.put("platformVersion", str3);
        int intValue = ((Integer) map.get("isEmbed")).intValue();
        createCrashRecord.put("isEmbed", Integer.valueOf(intValue));
        boolean booleanValue = ((Boolean) map.get(Constants.JSON_KEY_IS_RELEASE)).booleanValue();
        createCrashRecord.put(Constants.JSON_KEY_IS_RELEASE, Boolean.valueOf(booleanValue));
        createCrashRecord.put(Constants.JSON_KEY_MAS_SDK_VERSION, "nv=" + MASConfig.MAS_SDK_VERSION + ", fv=" + str2 + ", dv=" + str3 + ", isEmbed=" + intValue + ", isRelease=" + booleanValue);
        createCrashRecord.setCurrentThreadCount(ThreadCollector.getCurrentThreadCount());
        createCrashRecord.setSysThreadCount(ThreadCollector.getSysThreadCountLimit());
        createCrashRecord.setAllThreadStack(ThreadCollector.getAllThreadStacks());
        createCrashRecord.setFileType(FileType.DART_EXCEPTION);
        Map<String, Object> currentFDList = ThreadCollector.getCurrentFDList();
        createCrashRecord.setCurrentFdCount(currentFDList.size());
        createCrashRecord.setSysFdCount(ThreadCollector.getSysFdCountLimit());
        createCrashRecord.setFdList(currentFDList);
        createCrashRecord.put("type", (String) map.get("type"));
        DartErrorRecord dartErrorRecord = new DartErrorRecord();
        dartErrorRecord.fromRecord(createCrashRecord);
        dartErrorRecord.takeLogcatWithErrorCheck(str);
        save(dartErrorRecord);
    }
}
