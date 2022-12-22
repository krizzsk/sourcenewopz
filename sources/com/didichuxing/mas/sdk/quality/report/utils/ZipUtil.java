package com.didichuxing.mas.sdk.quality.report.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeZipOutputStream(java.util.List<java.util.Map.Entry<java.lang.String, byte[]>> r3, java.io.OutputStream r4) throws java.io.IOException {
        /*
            r0 = 0
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x0043 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0043 }
            r2.<init>(r4)     // Catch:{ all -> 0x0043 }
            r1.<init>(r2)     // Catch:{ all -> 0x0043 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0040 }
        L_0x000f:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0040 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0040 }
            java.lang.Object r0 = r4.getKey()     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0040 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0040 }
            byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x0040 }
            java.util.zip.ZipEntry r2 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0040 }
            r2.<init>(r0)     // Catch:{ all -> 0x0040 }
            r1.putNextEntry(r2)     // Catch:{ all -> 0x0040 }
            r1.write(r4)     // Catch:{ all -> 0x0040 }
            r1.flush()     // Catch:{ all -> 0x0040 }
            r1.closeEntry()     // Catch:{ all -> 0x0040 }
            goto L_0x000f
        L_0x0039:
            r1.flush()
            r1.close()
            return
        L_0x0040:
            r3 = move-exception
            r0 = r1
            goto L_0x0044
        L_0x0043:
            r3 = move-exception
        L_0x0044:
            if (r0 == 0) goto L_0x004c
            r0.flush()
            r0.close()
        L_0x004c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.utils.ZipUtil.writeZipOutputStream(java.util.List, java.io.OutputStream):void");
    }

    public static void zip(String[] strArr, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
        try {
            byte[] bArr = new byte[8192];
            for (int i = 0; i < strArr.length; i++) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(strArr[i]), 8192);
                zipOutputStream.putNextEntry(new ZipEntry(strArr[i].substring(strArr[i].lastIndexOf("/") + 1)));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                closeBufferInputStream(bufferedInputStream);
            }
            zipOutputStream.flush();
            zipOutputStream.close();
        } catch (Throwable th) {
            zipOutputStream.flush();
            zipOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static void zip(List<String> list, List<Map.Entry<String, byte[]>> list2, File file) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        if (list != null) {
            try {
                if (list.size() > 0) {
                    synchronized (list) {
                        byte[] bArr = new byte[8192];
                        for (String next : list) {
                            File file2 = new File(next);
                            if (file2.exists()) {
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2), 8192);
                                try {
                                    zipOutputStream.putNextEntry(new ZipEntry(next.substring(next.lastIndexOf("/") + 1)));
                                    while (true) {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream.write(bArr, 0, read);
                                    }
                                    closeBufferInputStream(bufferedInputStream);
                                } catch (Throwable th) {
                                    closeBufferInputStream(bufferedInputStream);
                                    throw th;
                                }
                            }
                        }
                        zipOutputStream.flush();
                    }
                }
            } catch (Throwable th2) {
                zipOutputStream.close();
                throw th2;
            }
        }
        if (list2 != null && list2.size() > 0) {
            synchronized (list2) {
                for (Map.Entry next2 : list2) {
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry((String) next2.getKey()));
                        zipOutputStream.write((byte[]) next2.getValue());
                        zipOutputStream.flush();
                        zipOutputStream.closeEntry();
                    } catch (Throwable th3) {
                        zipOutputStream.flush();
                        zipOutputStream.closeEntry();
                        throw th3;
                    }
                }
            }
        }
        zipOutputStream.close();
    }

    private static void closeBufferInputStream(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
