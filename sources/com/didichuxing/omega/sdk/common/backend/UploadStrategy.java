package com.didichuxing.omega.sdk.common.backend;

import android.content.Context;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.OmegaSetting;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.record.EventsRecord;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.transport.FileTooLargeException;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadStrategy {
    public static void upload(Context context) {
        doUpload(getUploadEventsUrl(), RecordStorage.getAllRecordFiles(), true);
    }

    private static void doUpload(String str, List<File> list, boolean z) {
        try {
            for (File uploadOneFile : list) {
                uploadOneFile(str, uploadOneFile, z);
            }
        } catch (Throwable unused) {
            OLog.m34769w("doUpload fail!");
        }
    }

    private static void uploadOneFile(String str, File file, boolean z) throws IOException {
        if (!file.exists()) {
            OLog.m34763e("File:" + file.getAbsolutePath() + " NOT exist.");
            return;
        }
        String[] split = file.getName().split("_");
        if (split.length != 6) {
            RecordStorage.deleteRecordFile(file);
        } else if (file.length() < 30) {
            RecordStorage.deleteRecordFile(file);
        } else {
            String str2 = split[1];
            String str3 = split[4];
            String omegaId = PersistentInfoCollector.getOmegaId();
            String str4 = split[5];
            HashMap hashMap = new HashMap();
            hashMap.put("msgid", str3);
            hashMap.put("oid", omegaId);
            hashMap.put("seq", str4);
            hashMap.put("cts", String.format(InvitationTrackFragment.INVITE_DATE, new Object[]{Long.valueOf(System.currentTimeMillis())}));
            Security.setHeaderCityIdEncrypt(hashMap, omegaId);
            if (System.currentTimeMillis() - Long.valueOf(split[3]).longValue() > OmegaConfig.RECORD_EXPIRE_MS) {
                RecordStorage.deleteRecordFile(file);
                return;
            }
            try {
                Security.post(str, file, hashMap, z);
            } catch (FileTooLargeException e) {
                Tracker.trackGood("type:" + str2 + " oid:" + omegaId + ": upload file too large", e);
            } catch (Exception e2) {
                OLog.m34763e(e2.getMessage());
                return;
            }
            try {
                RecordStorage.deleteRecordFile(file);
            } catch (Exception e3) {
                OLog.m34763e(e3.getMessage());
            }
        }
    }

    public static String sendDirectly(EventsRecord eventsRecord, List<Map.Entry<String, byte[]>> list) {
        return sendDirectly(getUploadEventsUrl(), eventsRecord, list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b A[SYNTHETIC, Splitter:B:21:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093 A[Catch:{ IOException -> 0x008f }, DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String sendDirectly(java.lang.String r9, com.didichuxing.omega.sdk.common.record.Record r10, java.util.List<java.util.Map.Entry<java.lang.String, byte[]>> r11) {
        /*
            java.lang.String r0 = "sendDirectly close io fail"
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0081 }
            r2.<init>()     // Catch:{ all -> 0x0081 }
            com.didichuxing.omega.sdk.common.utils.ZipUtil.writeZipOutputStream(r11, r2)     // Catch:{ all -> 0x007e }
            java.io.ByteArrayInputStream r11 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x007e }
            byte[] r3 = r2.toByteArray()     // Catch:{ all -> 0x007e }
            r11.<init>(r3)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector.getOmegaId()     // Catch:{ all -> 0x007c }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x007c }
            r4.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "msgid"
            java.lang.String r6 = r10.getRecordId()     // Catch:{ all -> 0x007c }
            r4.put(r5, r6)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "oid"
            r4.put(r5, r3)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "seq"
            java.lang.Long r10 = r10.getSeq()     // Catch:{ all -> 0x007c }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x007c }
            r4.put(r5, r10)     // Catch:{ all -> 0x007c }
            java.lang.String r10 = "cts"
            java.lang.String r5 = "%s"
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x007c }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007c }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x007c }
            r8 = 0
            r6[r8] = r7     // Catch:{ all -> 0x007c }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ all -> 0x007c }
            r4.put(r10, r5)     // Catch:{ all -> 0x007c }
            java.lang.String r10 = "no_save"
            java.lang.String r5 = "1"
            r4.put(r10, r5)     // Catch:{ all -> 0x007c }
            com.didichuxing.omega.sdk.analysis.Security.setHeaderCityIdEncrypt(r4, r3)     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r10.<init>()     // Catch:{ all -> 0x007c }
            r10.append(r9)     // Catch:{ all -> 0x007c }
            java.lang.String r9 = "?no_save=1"
            r10.append(r9)     // Catch:{ all -> 0x007c }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x007c }
            java.lang.String r9 = com.didichuxing.omega.sdk.common.transport.HttpSender.post((java.lang.String) r9, (java.io.InputStream) r11, (java.util.Map<java.lang.String, java.lang.String>) r4, (boolean) r8)     // Catch:{ all -> 0x007c }
            r2.close()     // Catch:{ IOException -> 0x0077 }
            r11.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r10 = move-exception
            com.didichuxing.omega.sdk.common.utils.OLog.m34764e(r0, r10)
        L_0x007b:
            return r9
        L_0x007c:
            r9 = move-exception
            goto L_0x0084
        L_0x007e:
            r9 = move-exception
            r11 = r1
            goto L_0x0084
        L_0x0081:
            r9 = move-exception
            r11 = r1
            r2 = r11
        L_0x0084:
            java.lang.String r10 = "sendDirectly fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m34764e(r10, r9)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x0091
            r2.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0091
        L_0x008f:
            r9 = move-exception
            goto L_0x0097
        L_0x0091:
            if (r11 == 0) goto L_0x009a
            r11.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x009a
        L_0x0097:
            com.didichuxing.omega.sdk.common.utils.OLog.m34764e(r0, r9)
        L_0x009a:
            return r1
        L_0x009b:
            r9 = move-exception
            if (r2 == 0) goto L_0x00a4
            r2.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00a4
        L_0x00a2:
            r10 = move-exception
            goto L_0x00aa
        L_0x00a4:
            if (r11 == 0) goto L_0x00ad
            r11.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00ad
        L_0x00aa:
            com.didichuxing.omega.sdk.common.utils.OLog.m34764e(r0, r10)
        L_0x00ad:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.backend.UploadStrategy.sendDirectly(java.lang.String, com.didichuxing.omega.sdk.common.record.Record, java.util.List):java.lang.String");
    }

    public static String getUploadEventsUrl() {
        return OmegaSetting.getUploadEventsUrl();
    }

    public static String getUploadCrashUrl() {
        return OmegaSetting.getUploadCrashUrl();
    }

    public static String getUploadSyncUrl() {
        return OmegaSetting.getUploadSyncUrl();
    }

    public static String getUploadCNDUrl() {
        return OmegaSetting.getUploadCNDUrl();
    }

    public static String getRealtimeUrl() {
        return OmegaSetting.getRealtimeUrl();
    }
}
