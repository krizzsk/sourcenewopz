package com.didichuxing.mas.sdk.quality.report.backend;

import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.record.EventsRecord;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.transport.FileTooLargeException;
import com.didichuxing.mas.sdk.quality.report.transport.HttpSender;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadStrategy {
    private static String mRealtimeUrl;
    private static String mUploadCDNUrl;
    private static String mUploadSyncUrl;

    public static void upload() {
        String networkStatus = NetworkCollector.getNetworkStatus();
        if (!IStoreCallback.DEFAULT_API_DETAIL_KEY.equals(networkStatus) && !"UNKNOWN".equals(networkStatus)) {
            Map<String, List<File>> allRecordFiles = RecordStorage.getAllRecordFiles();
            String uploadEventsUrl = getUploadEventsUrl();
            String uploadCrashUrl = getUploadCrashUrl();
            doUpload(uploadEventsUrl, allRecordFiles.get("e"));
            doUpload(uploadCrashUrl + "&file_type=1", allRecordFiles.get("c"));
            doUpload(uploadCrashUrl + "&file_type=2", allRecordFiles.get(Constants.FILE_NATIVE_CRASH_KEY));
            doUpload(uploadCrashUrl + "&file_type=3", allRecordFiles.get(Constants.FILE_ANR_KEY));
            doUpload(uploadCrashUrl + "&file_type=4", allRecordFiles.get("l"));
            doUpload(uploadCrashUrl + "&file_type=5", allRecordFiles.get(Constants.FILE_OOM_KEY));
            doUpload(uploadCrashUrl + "&file_type=6", allRecordFiles.get(Constants.FILE_DART_ERROR_KEY));
        }
    }

    private static void doUpload(String str, List<File> list) {
        if (list != null) {
            OLog.m34422v("UploadStrategy.doUpload() begin, files:" + list.size());
            for (File next : list) {
                try {
                    uploadOneFile(str, next);
                } catch (Exception unused) {
                    OLog.m34418e("upload file:" + next.getAbsolutePath() + " fail!");
                }
            }
        }
    }

    private static void uploadOneFile(String str, File file) {
        if (!file.exists()) {
            OLog.m34418e("File:" + file.getAbsolutePath() + " not exist.");
            return;
        }
        String[] split = file.getName().split("_");
        if (split.length != 5) {
            RecordStorage.deleteRecordFile(file, 1, "bad omega file");
        } else if (file.length() < 30) {
            RecordStorage.deleteRecordFile(file, 2, "too small omega file");
        } else {
            String str2 = split[1];
            String str3 = split[3];
            String omegaId = PersistentInfoCollector.getOmegaId();
            String str4 = split[4];
            HashMap hashMap = new HashMap();
            hashMap.put("msgid", str3);
            hashMap.put("oid", omegaId);
            hashMap.put("seq", str4);
            hashMap.put("cts", String.format(InvitationTrackFragment.INVITE_DATE, new Object[]{Long.valueOf(System.currentTimeMillis())}));
            if (System.currentTimeMillis() - Long.valueOf(split[2]).longValue() > MASConfig.RECORD_EXPIRE_MS) {
                RecordStorage.deleteRecordFile(file, 3, "expired omega file");
                return;
            }
            try {
                HttpSender.post(str, file, (Map<String, String>) hashMap);
                RecordStorage.deleteRecordFile(file, 4, "upload success");
            } catch (FileTooLargeException e) {
                OLog.m34419e("type:" + str2 + " oid:" + omegaId + ": upload file too large", e);
                StringBuilder sb = new StringBuilder();
                sb.append("upload file too large e.getMessage: ");
                sb.append(e.getMessage());
                RecordStorage.deleteRecordFile(file, 5, sb.toString());
            } catch (Exception e2) {
                OLog.m34418e(e2.getMessage());
            }
        }
    }

    public static String sendDirectly(EventsRecord eventsRecord, List<Map.Entry<String, byte[]>> list) {
        return sendDirectly(getUploadEventsUrl(), eventsRecord, list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0078 A[SYNTHETIC, Splitter:B:17:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d A[Catch:{ IOException -> 0x0080 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String sendDirectly(java.lang.String r7, com.didichuxing.mas.sdk.quality.report.record.Record r8, java.util.List<java.util.Map.Entry<java.lang.String, byte[]>> r9) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            com.didichuxing.mas.sdk.quality.report.utils.ZipUtil.writeZipOutputStream(r9, r1)     // Catch:{ all -> 0x0072 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0072 }
            byte[] r2 = r1.toByteArray()     // Catch:{ all -> 0x0072 }
            r9.<init>(r2)     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector.getOmegaId()     // Catch:{ all -> 0x0076 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0076 }
            r3.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r4 = "msgid"
            java.lang.String r5 = r8.getRecordId()     // Catch:{ all -> 0x0076 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0076 }
            java.lang.String r4 = "oid"
            r3.put(r4, r2)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "seq"
            java.lang.Long r8 = r8.getSeq()     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0076 }
            r3.put(r2, r8)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = "cts"
            java.lang.String r2 = "%s"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0076 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0076 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0076 }
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x0076 }
            r3.put(r8, r2)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = "no_save"
            java.lang.String r2 = "1"
            r3.put(r8, r2)     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r8.<init>()     // Catch:{ all -> 0x0076 }
            r8.append(r7)     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = "?no_save=1"
            r8.append(r7)     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = com.didichuxing.mas.sdk.quality.report.transport.HttpSender.post((java.lang.String) r7, (java.io.InputStream) r9, (java.util.Map<java.lang.String, java.lang.String>) r3, (boolean) r6)     // Catch:{ all -> 0x0076 }
            r1.close()     // Catch:{ IOException -> 0x0071 }
            r9.close()     // Catch:{ IOException -> 0x0071 }
        L_0x0071:
            return r7
        L_0x0072:
            r9 = r0
            goto L_0x0076
        L_0x0074:
            r9 = r0
            r1 = r9
        L_0x0076:
            if (r1 == 0) goto L_0x007b
            r1.close()     // Catch:{ IOException -> 0x0080 }
        L_0x007b:
            if (r9 == 0) goto L_0x0080
            r9.close()     // Catch:{ IOException -> 0x0080 }
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.backend.UploadStrategy.sendDirectly(java.lang.String, com.didichuxing.mas.sdk.quality.report.record.Record, java.util.List):java.lang.String");
    }

    public static String getUploadEventsUrl() {
        String str = "https://";
        if (MASConfig.DEBUG_MODEL) {
            StringBuilder sb = new StringBuilder();
            if (!MASConfig.SWITCH_USE_HTTPS) {
                str = "http://";
            }
            sb.append(str);
            sb.append(MASConfig.UPLOAD_HOST);
            sb.append(MASConfig.UPLOAD_EVENTS_DEBUG_PATH);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        if (!MASConfig.SWITCH_USE_HTTPS) {
            str = "http://";
        }
        sb2.append(str);
        sb2.append(MASConfig.UPLOAD_HOST);
        sb2.append(MASConfig.UPLOAD_EVENTS_PATH);
        return sb2.toString();
    }

    public static String getUploadCrashUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(MASConfig.SWITCH_USE_HTTPS ? "https://" : "http://");
        sb.append(MASConfig.UPLOAD_HOST);
        sb.append(MASConfig.UPLOAD_CRASH_PATH);
        sb.append("?an=");
        sb.append(MASConfig.CUSTOM_APP_NAME);
        sb.append("&nav=");
        sb.append(MASConfig.APP_ISSUE);
        sb.append("&av=");
        sb.append(PackageCollector.getVN());
        return sb.toString();
    }

    public static String getUploadSyncUrl() {
        if (mUploadSyncUrl == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(MASConfig.SWITCH_USE_HTTPS ? "https://" : "http://");
            sb.append(MASConfig.UPLOAD_HOST);
            sb.append(MASConfig.UPLOAD_SYNC_PATH);
            sb.append("/");
            sb.append(MASConfig.CUSTOM_APP_NAME);
            mUploadSyncUrl = sb.toString();
        }
        return mUploadSyncUrl;
    }

    public static String getUploadCNDUrl() {
        if (mUploadCDNUrl == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(MASConfig.SWITCH_USE_HTTPS ? "https://" : "http://");
            sb.append(MASConfig.UPLOAD_HOST);
            sb.append(MASConfig.UPLOAD_CDN_PATH);
            sb.append("/");
            sb.append(MASConfig.CUSTOM_APP_NAME);
            mUploadCDNUrl = sb.toString();
        }
        return mUploadCDNUrl;
    }

    public static String getRealtimeUrl() {
        if (mRealtimeUrl == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(MASConfig.SWITCH_USE_HTTPS ? "https://" : "http://");
            sb.append(MASConfig.UPLOAD_HOST);
            sb.append(MASConfig.UPLOAD_REALTIME_PATH);
            mRealtimeUrl = sb.toString();
        }
        return mRealtimeUrl;
    }
}
