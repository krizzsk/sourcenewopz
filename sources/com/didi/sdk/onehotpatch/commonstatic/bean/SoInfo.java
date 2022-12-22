package com.didi.sdk.onehotpatch.commonstatic.bean;

import android.content.Context;
import com.didi.dynamic.manager.utils.MD5;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class SoInfo {
    private static String sCurrentAbi;
    public String absolutePath;
    public String md5;
    public String name;
    public String path;

    public static void parseSoInfo(Context context, File file, List<SoInfo> list) {
        if (file != null && file.exists() && file.isDirectory()) {
            sCurrentAbi = getCurrentAbi(context);
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (!file2.isDirectory() || !file2.getName().equalsIgnoreCase(sCurrentAbi)) {
                    i++;
                } else {
                    for (File file3 : file2.listFiles()) {
                        SoInfo soInfo = new SoInfo();
                        soInfo.name = file3.getName();
                        soInfo.path = sCurrentAbi;
                        soInfo.absolutePath = file3.getAbsolutePath();
                        try {
                            soInfo.md5 = MD5.getFileMD5(file3);
                            list.add(soInfo);
                        } catch (FileNotFoundException e) {
                            Logger.warn(e);
                        }
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2 A[SYNTHETIC, Splitter:B:51:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cf A[SYNTHETIC, Splitter:B:58:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCurrentAbi(android.content.Context r9) {
        /*
            java.lang.String r0 = "/"
            java.lang.String r1 = sCurrentAbi
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r2 = 0
            android.content.pm.ApplicationInfo r9 = r9.getApplicationInfo()     // Catch:{ IOException -> 0x00bc }
            java.lang.String r9 = r9.sourceDir     // Catch:{ IOException -> 0x00bc }
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00bc }
            r3.<init>(r9)     // Catch:{ IOException -> 0x00bc }
            java.util.Enumeration r9 = r3.entries()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
        L_0x001c:
            boolean r2 = r9.hasMoreElements()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            r4 = 1
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r9.nextElement()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            if (r2 != 0) goto L_0x002c
            goto L_0x001c
        L_0x002c:
            java.lang.String r2 = r2.getName()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            java.lang.String r5 = "lib/"
            boolean r5 = r2.startsWith(r5)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            if (r5 == 0) goto L_0x001c
            java.lang.String r5 = ".so"
            boolean r5 = r2.endsWith(r5)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            if (r5 == 0) goto L_0x001c
            java.lang.String r5 = "../"
            boolean r5 = r2.contains(r5)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            if (r5 != 0) goto L_0x001c
            int r9 = r2.indexOf(r0)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            int r0 = r2.lastIndexOf(r0)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            int r9 = r9 + r4
            java.lang.String r9 = r2.substring(r9, r0)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            r1.add(r9)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
        L_0x0058:
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            r0 = 21
            r2 = 0
            if (r9 < r0) goto L_0x0062
            java.lang.String[] r9 = android.os.Build.SUPPORTED_ABIS     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            goto L_0x006d
        L_0x0062:
            r9 = 2
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            java.lang.String r0 = android.os.Build.CPU_ABI     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            r9[r2] = r0     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            java.lang.String r0 = android.os.Build.CPU_ABI2     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            r9[r4] = r0     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
        L_0x006d:
            boolean r0 = r1.isEmpty()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            if (r0 == 0) goto L_0x007b
            java.lang.String r0 = "Can't find abis in base.apk!"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r0, r1)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            goto L_0x009d
        L_0x007b:
            int r0 = r9.length     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            r5 = 0
        L_0x007d:
            if (r5 >= r0) goto L_0x009d
            r6 = r9[r5]     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            java.util.Iterator r7 = r1.iterator()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
        L_0x0085:
            boolean r8 = r7.hasNext()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            if (r8 == 0) goto L_0x009a
            java.lang.Object r8 = r7.next()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            if (r8 == 0) goto L_0x0085
            sCurrentAbi = r6     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            goto L_0x009d
        L_0x009a:
            int r5 = r5 + 1
            goto L_0x007d
        L_0x009d:
            java.lang.String r0 = sCurrentAbi     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            if (r0 != 0) goto L_0x00a5
            r9 = r9[r2]     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            sCurrentAbi = r9     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
        L_0x00a5:
            java.lang.String r9 = "CurrentAbi = %s"
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            java.lang.String r1 = sCurrentAbi     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            r0[r2] = r1     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r9, r0)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            r3.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00ca
        L_0x00b4:
            r9 = move-exception
            r2 = r3
            goto L_0x00cd
        L_0x00b7:
            r9 = move-exception
            r2 = r3
            goto L_0x00bd
        L_0x00ba:
            r9 = move-exception
            goto L_0x00cd
        L_0x00bc:
            r9 = move-exception
        L_0x00bd:
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r9)     // Catch:{ all -> 0x00ba }
            if (r2 == 0) goto L_0x00ca
            r2.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r9 = move-exception
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r9)
        L_0x00ca:
            java.lang.String r9 = sCurrentAbi
            return r9
        L_0x00cd:
            if (r2 == 0) goto L_0x00d7
            r2.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00d7
        L_0x00d3:
            r0 = move-exception
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r0)
        L_0x00d7:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.bean.SoInfo.getCurrentAbi(android.content.Context):java.lang.String");
    }
}
