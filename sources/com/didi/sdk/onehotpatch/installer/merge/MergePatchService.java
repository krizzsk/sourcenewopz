package com.didi.sdk.onehotpatch.installer.merge;

import android.app.IntentService;

public class MergePatchService extends IntentService {
    public static final String ACTION_MERGE_HOTPATCH = "merge_patch";
    public static final String KEY_MODULE = "key_module";

    public MergePatchService() {
        super("MergePatchService");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0148 A[SYNTHETIC, Splitter:B:56:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r10) {
        /*
            r9 = this;
            java.lang.String r0 = "key_module"
            java.lang.String r1 = "install"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "MergePatchService: start"
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.info(r4, r3)
            if (r10 != 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r3 = r10.getAction()
            java.lang.String r4 = "merge_patch"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x001c
            return
        L_0x001c:
            r3 = 0
            java.io.Serializable r10 = r10.getSerializableExtra(r0)     // Catch:{ all -> 0x0116 }
            boolean r4 = r10 instanceof com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule     // Catch:{ all -> 0x0116 }
            if (r4 == 0) goto L_0x010e
            com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule r10 = (com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule) r10     // Catch:{ all -> 0x0116 }
            r4 = 1
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.trackMerge(r9, r10, r4, r3)     // Catch:{ all -> 0x010b }
            java.lang.String r5 = r10.ext     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.openapi.HotpatchStateBroadcast.sendPatchDownloadState(r9, r1, r4, r5)     // Catch:{ all -> 0x010b }
            java.io.File r5 = com.didi.sdk.onehotpatch.commonstatic.PatchManager.getPatchDir(r9, r10)     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.commonstatic.util.FileUtils.deleteDirectory(r5)     // Catch:{ all -> 0x010b }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x010b }
            java.lang.String r7 = r10.modulePath     // Catch:{ all -> 0x010b }
            r6.<init>(r7)     // Catch:{ all -> 0x010b }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.commonstatic.util.ZipUtils.unzip(r6, r5)     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.commonstatic.bean.MetaBean r5 = com.didi.sdk.onehotpatch.commonstatic.PatchManager.getPatchMeta(r9, r10)     // Catch:{ all -> 0x010b }
            java.lang.String r6 = r10.ext     // Catch:{ all -> 0x010b }
            if (r6 == 0) goto L_0x0057
            java.lang.String r6 = ""
            java.lang.String r7 = r10.ext     // Catch:{ all -> 0x010b }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x010b }
            if (r6 == 0) goto L_0x005b
        L_0x0057:
            java.lang.String r6 = r5.ext     // Catch:{ all -> 0x010b }
            r10.ext = r6     // Catch:{ all -> 0x010b }
        L_0x005b:
            java.lang.String r6 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.getVersionNameAndCode(r9)     // Catch:{ all -> 0x010b }
            java.lang.String r7 = r5.target_version     // Catch:{ all -> 0x010b }
            boolean r7 = r7.equals(r6)     // Catch:{ all -> 0x010b }
            r8 = 2
            if (r7 == 0) goto L_0x00f7
            java.lang.String r6 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.getAppRandom(r9)     // Catch:{ all -> 0x010b }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x010b }
            if (r7 != 0) goto L_0x0097
            java.lang.String r7 = r5.random     // Catch:{ all -> 0x010b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x010b }
            if (r7 != 0) goto L_0x0097
            java.lang.String r7 = r5.random     // Catch:{ all -> 0x010b }
            boolean r7 = android.text.TextUtils.equals(r7, r6)     // Catch:{ all -> 0x010b }
            if (r7 == 0) goto L_0x0083
            goto L_0x0097
        L_0x0083:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x010b }
            java.lang.String r3 = "app random_matching(%s) can not match patch random_matching(%s)"
            java.lang.Object[] r7 = new java.lang.Object[r8]     // Catch:{ all -> 0x010b }
            r7[r2] = r6     // Catch:{ all -> 0x010b }
            java.lang.String r5 = r5.random     // Catch:{ all -> 0x010b }
            r7[r4] = r5     // Catch:{ all -> 0x010b }
            java.lang.String r3 = java.lang.String.format(r3, r7)     // Catch:{ all -> 0x010b }
            r0.<init>(r3)     // Catch:{ all -> 0x010b }
            throw r0     // Catch:{ all -> 0x010b }
        L_0x0097:
            android.app.Application r4 = r9.getApplication()     // Catch:{ all -> 0x010b }
            boolean r4 = com.didi.sdk.onehotpatch.installer.merge.dex.DexDiffMerger.merge(r4, r10)     // Catch:{ all -> 0x010b }
            if (r4 == 0) goto L_0x00ef
            android.app.Application r4 = r9.getApplication()     // Catch:{ all -> 0x010b }
            boolean r4 = com.didi.sdk.onehotpatch.installer.merge.p157so.SoDiffMerger.merge(r4, r10)     // Catch:{ all -> 0x010b }
            if (r4 == 0) goto L_0x00e7
            java.lang.String r4 = "MergePatchService: merge patch success"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.info(r4, r5)     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.trackMerge(r9, r10, r2, r3)     // Catch:{ all -> 0x010b }
            boolean r4 = com.didi.sdk.onehotpatch.commonstatic.PatchManager.bangProtected(r9)     // Catch:{ all -> 0x010b }
            if (r4 == 0) goto L_0x00d3
            com.didi.sdk.onehotpatch.commonstatic.PatchManager.setInstalledPatch(r9, r10)     // Catch:{ all -> 0x010b }
            java.lang.String r0 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.commonstatic.PatchManager.setFingerPrint(r9, r0)     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.trackDexopt(r9, r10, r2, r3)     // Catch:{ all -> 0x010b }
            java.lang.String r0 = "DexOptService: patch success, restart will effect!"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.info(r0, r3)     // Catch:{ all -> 0x010b }
            java.lang.String r0 = r10.ext     // Catch:{ all -> 0x010b }
            com.didi.sdk.onehotpatch.openapi.HotpatchStateBroadcast.sendPatchDownloadState(r9, r1, r2, r0)     // Catch:{ all -> 0x010b }
            return
        L_0x00d3:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x010b }
            java.lang.Class<com.didi.sdk.onehotpatch.installer.dexopt.DexOptService> r4 = com.didi.sdk.onehotpatch.installer.dexopt.DexOptService.class
            r3.<init>(r9, r4)     // Catch:{ all -> 0x010b }
            java.lang.String r4 = "action_dexopt"
            r3.setAction(r4)     // Catch:{ all -> 0x010b }
            r3.putExtra(r0, r10)     // Catch:{ all -> 0x010b }
            r9.startService(r3)     // Catch:{ all -> 0x010b }
            goto L_0x0174
        L_0x00e7:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x010b }
            java.lang.String r3 = "MergePatchService merge patch so failed"
            r0.<init>(r3)     // Catch:{ all -> 0x010b }
            throw r0     // Catch:{ all -> 0x010b }
        L_0x00ef:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x010b }
            java.lang.String r3 = "MergePatchService merge patch dex failed"
            r0.<init>(r3)     // Catch:{ all -> 0x010b }
            throw r0     // Catch:{ all -> 0x010b }
        L_0x00f7:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x010b }
            java.lang.String r3 = "app version(%s) can not match patch version(%s)"
            java.lang.Object[] r7 = new java.lang.Object[r8]     // Catch:{ all -> 0x010b }
            r7[r2] = r6     // Catch:{ all -> 0x010b }
            java.lang.String r5 = r5.target_version     // Catch:{ all -> 0x010b }
            r7[r4] = r5     // Catch:{ all -> 0x010b }
            java.lang.String r3 = java.lang.String.format(r3, r7)     // Catch:{ all -> 0x010b }
            r0.<init>(r3)     // Catch:{ all -> 0x010b }
            throw r0     // Catch:{ all -> 0x010b }
        L_0x010b:
            r0 = move-exception
            r3 = r10
            goto L_0x0117
        L_0x010e:
            java.lang.Exception r10 = new java.lang.Exception     // Catch:{ all -> 0x0116 }
            java.lang.String r0 = "MergePatchService: patchModule is null"
            r10.<init>(r0)     // Catch:{ all -> 0x0116 }
            throw r10     // Catch:{ all -> 0x0116 }
        L_0x0116:
            r0 = move-exception
        L_0x0117:
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.String r4 = "MergePatchService fail!!"
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.info(r4, r10)
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r0)
            java.lang.String r10 = r3.ext
            r4 = -1
            com.didi.sdk.onehotpatch.openapi.HotpatchStateBroadcast.sendPatchDownloadState(r9, r1, r4, r10)
            android.content.Intent r10 = new android.content.Intent     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = "local_test"
            r10.<init>(r1)     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = r9.getPackageName()     // Catch:{ all -> 0x0142 }
            r10.setPackage(r1)     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = "key_msg"
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0142 }
            r10.putExtra(r1, r5)     // Catch:{ all -> 0x0142 }
            r9.sendBroadcast(r10)     // Catch:{ all -> 0x0142 }
            goto L_0x0146
        L_0x0142:
            r10 = move-exception
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r10)
        L_0x0146:
            if (r3 == 0) goto L_0x0174
            java.lang.String r10 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.dumpException(r0)     // Catch:{ all -> 0x0170 }
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.trackMerge(r9, r3, r4, r0)     // Catch:{ all -> 0x0170 }
            com.didi.sdk.onehotpatch.commonstatic.PatchManager.deleteInstallingPatchAndDatabase(r9, r3)     // Catch:{ all -> 0x0170 }
            com.didi.sdk.onehotpatch.commonstatic.report.Report$ReportModule r0 = new com.didi.sdk.onehotpatch.commonstatic.report.Report$ReportModule     // Catch:{ all -> 0x0170 }
            r0.<init>()     // Catch:{ all -> 0x0170 }
            r0.isLoadSuccess = r2     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r1.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = "MergePatchService:"
            r1.append(r2)     // Catch:{ all -> 0x0170 }
            r1.append(r10)     // Catch:{ all -> 0x0170 }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x0170 }
            r0.errorMsg = r10     // Catch:{ all -> 0x0170 }
            com.didi.sdk.onehotpatch.commonstatic.report.Report.report(r9, r3, r0)     // Catch:{ all -> 0x0170 }
            goto L_0x0174
        L_0x0170:
            r10 = move-exception
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r10)
        L_0x0174:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.installer.merge.MergePatchService.onHandleIntent(android.content.Intent):void");
    }
}
