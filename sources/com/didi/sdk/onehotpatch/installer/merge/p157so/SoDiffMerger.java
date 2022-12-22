package com.didi.sdk.onehotpatch.installer.merge.p157so;

/* renamed from: com.didi.sdk.onehotpatch.installer.merge.so.SoDiffMerger */
public class SoDiffMerger {
    private static final String PATCH_LIB_DIR = "lib";

    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.util.zip.ZipFile] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab A[Catch:{ all -> 0x00a5, all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean merge(android.app.Application r12, com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule r13) throws java.lang.Exception {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = com.didi.sdk.onehotpatch.commonstatic.PatchManager.getPatchDir(r12, r13)
            java.lang.String r2 = "lib"
            r0.<init>(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.didi.sdk.onehotpatch.commonstatic.bean.SoInfo.parseSoInfo(r12, r0, r1)
            boolean r0 = r1.isEmpty()
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0023
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.String r13 = "SoInfo list is empty, ignore so diff."
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r13, r12)
            return r4
        L_0x0023:
            r0 = 0
            android.content.pm.ApplicationInfo r5 = r12.getApplicationInfo()     // Catch:{ all -> 0x00cd }
            java.lang.String r5 = r5.sourceDir     // Catch:{ all -> 0x00cd }
            java.util.zip.ZipFile r6 = new java.util.zip.ZipFile     // Catch:{ all -> 0x00cd }
            r6.<init>(r5)     // Catch:{ all -> 0x00cd }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00ca }
        L_0x0033:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x00ca }
            if (r5 == 0) goto L_0x00c6
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x00ca }
            com.didi.sdk.onehotpatch.commonstatic.bean.SoInfo r5 = (com.didi.sdk.onehotpatch.commonstatic.bean.SoInfo) r5     // Catch:{ all -> 0x00ca }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r7.<init>()     // Catch:{ all -> 0x00ca }
            r7.append(r2)     // Catch:{ all -> 0x00ca }
            java.lang.String r8 = java.io.File.separator     // Catch:{ all -> 0x00ca }
            r7.append(r8)     // Catch:{ all -> 0x00ca }
            java.lang.String r8 = r5.path     // Catch:{ all -> 0x00ca }
            r7.append(r8)     // Catch:{ all -> 0x00ca }
            java.lang.String r8 = java.io.File.separator     // Catch:{ all -> 0x00ca }
            r7.append(r8)     // Catch:{ all -> 0x00ca }
            java.lang.String r8 = r5.name     // Catch:{ all -> 0x00ca }
            r7.append(r8)     // Catch:{ all -> 0x00ca }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00ca }
            java.util.zip.ZipEntry r7 = r6.getEntry(r7)     // Catch:{ all -> 0x00ca }
            java.io.File r8 = com.didi.sdk.onehotpatch.commonstatic.PatchManager.getPatchSoDir(r12, r13)     // Catch:{ all -> 0x00ca }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00ca }
            java.lang.String r10 = r5.path     // Catch:{ all -> 0x00ca }
            r9.<init>(r8, r10)     // Catch:{ all -> 0x00ca }
            boolean r8 = r9.exists()     // Catch:{ all -> 0x00ca }
            if (r8 != 0) goto L_0x0077
            r9.mkdirs()     // Catch:{ all -> 0x00ca }
        L_0x0077:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x00ca }
            java.lang.String r10 = r5.name     // Catch:{ all -> 0x00ca }
            r8.<init>(r9, r10)     // Catch:{ all -> 0x00ca }
            if (r7 == 0) goto L_0x00af
            boolean r9 = com.didi.sdk.onehotpatch.commonstatic.PatchManager.bangProtected(r12)     // Catch:{ all -> 0x00ca }
            if (r9 != 0) goto L_0x00af
            java.io.InputStream r7 = r6.getInputStream(r7)     // Catch:{ all -> 0x00a8 }
            java.lang.String r9 = "BsPatch: %s"
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ all -> 0x00a5 }
            java.lang.String r11 = r5.absolutePath     // Catch:{ all -> 0x00a5 }
            r10[r3] = r11     // Catch:{ all -> 0x00a5 }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r9, r10)     // Catch:{ all -> 0x00a5 }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = r5.absolutePath     // Catch:{ all -> 0x00a5 }
            r9.<init>(r5)     // Catch:{ all -> 0x00a5 }
            com.didi.sdk.onehotpatch.commonstatic.bsdiff.BSPatch.patchFast(r7, r9, r8)     // Catch:{ all -> 0x00a5 }
            if (r7 == 0) goto L_0x0033
            r7.close()     // Catch:{ all -> 0x00ca }
            goto L_0x0033
        L_0x00a5:
            r12 = move-exception
            r0 = r7
            goto L_0x00a9
        L_0x00a8:
            r12 = move-exception
        L_0x00a9:
            if (r0 == 0) goto L_0x00ae
            r0.close()     // Catch:{ all -> 0x00ca }
        L_0x00ae:
            throw r12     // Catch:{ all -> 0x00ca }
        L_0x00af:
            java.lang.String r7 = "Copy: %s"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00ca }
            java.lang.String r10 = r5.absolutePath     // Catch:{ all -> 0x00ca }
            r9[r3] = r10     // Catch:{ all -> 0x00ca }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r7, r9)     // Catch:{ all -> 0x00ca }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x00ca }
            java.lang.String r5 = r5.absolutePath     // Catch:{ all -> 0x00ca }
            r7.<init>(r5)     // Catch:{ all -> 0x00ca }
            com.didi.sdk.onehotpatch.commonstatic.util.FileUtils.copyFile(r7, r8)     // Catch:{ all -> 0x00ca }
            goto L_0x0033
        L_0x00c6:
            r6.close()
            return r4
        L_0x00ca:
            r12 = move-exception
            r0 = r6
            goto L_0x00ce
        L_0x00cd:
            r12 = move-exception
        L_0x00ce:
            if (r0 == 0) goto L_0x00d3
            r0.close()
        L_0x00d3:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.installer.merge.p157so.SoDiffMerger.merge(android.app.Application, com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule):boolean");
    }
}
