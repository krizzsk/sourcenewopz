package com.didichuxing.omega.sdk.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeZipOutputStream(java.util.List<java.util.Map.Entry<java.lang.String, byte[]>> r3, java.io.OutputStream r4) throws java.io.IOException {
        /*
            r0 = 0
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x003d }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x003d }
            r2.<init>(r4)     // Catch:{ all -> 0x003d }
            r1.<init>(r2)     // Catch:{ all -> 0x003d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x003a }
        L_0x000f:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0036
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x003a }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x003a }
            java.lang.Object r0 = r4.getKey()     // Catch:{ all -> 0x003a }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x003a }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x003a }
            byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x003a }
            java.util.zip.ZipEntry r2 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x003a }
            r2.<init>(r0)     // Catch:{ all -> 0x003a }
            r1.putNextEntry(r2)     // Catch:{ all -> 0x003a }
            r1.write(r4)     // Catch:{ all -> 0x003a }
            r1.closeEntry()     // Catch:{ all -> 0x003a }
            goto L_0x000f
        L_0x0036:
            r1.close()
            return
        L_0x003a:
            r3 = move-exception
            r0 = r1
            goto L_0x003e
        L_0x003d:
            r3 = move-exception
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.close()
        L_0x0043:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.utils.ZipUtil.writeZipOutputStream(java.util.List, java.io.OutputStream):void");
    }

    public static void writeZipfile(List<Map.Entry<String, byte[]>> list, File file) throws IOException {
        if (!file.exists()) {
            writeZipOutputStream(list, new FileOutputStream(file));
            return;
        }
        throw new IOException("exist file: " + file.getPath());
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
                bufferedInputStream.close();
            }
            zipOutputStream.close();
        } catch (Throwable th) {
            zipOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static void zip(List<String> list, List<Map.Entry<String, byte[]>> list2, File file) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        if (list != null) {
            try {
                synchronized (list) {
                    byte[] bArr = new byte[8192];
                    for (String next : list) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(next), 8192);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(next.substring(next.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 8192);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            bufferedInputStream.close();
                        } catch (Throwable th) {
                            bufferedInputStream.close();
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                zipOutputStream.close();
                throw th2;
            }
        }
        if (list2 != null) {
            synchronized (list2) {
                for (Map.Entry next2 : list2) {
                    zipOutputStream.putNextEntry(new ZipEntry((String) next2.getKey()));
                    zipOutputStream.write((byte[]) next2.getValue());
                    zipOutputStream.closeEntry();
                }
            }
        }
        zipOutputStream.close();
    }

    /* JADX INFO: finally extract failed */
    public static void zipEventsRecord(List<String> list, List<Map.Entry<String, byte[]>> list2, File file) throws IOException {
        byte[] encrypt;
        byte[] encrypt2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        if (list != null) {
            try {
                synchronized (list) {
                    byte[] bArr = new byte[8192];
                    for (String next : list) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(next), 8192);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(next.substring(next.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 8192);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            bufferedInputStream.close();
                        } catch (Throwable th) {
                            bufferedInputStream.close();
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                zipOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (!(byteArray == null || (encrypt2 = CryptoUtil.encrypt(byteArray)) == null)) {
                    writeFile(encrypt2, file);
                }
                throw th2;
            }
        }
        if (list2 != null) {
            synchronized (list2) {
                for (Map.Entry next2 : list2) {
                    zipOutputStream.putNextEntry(new ZipEntry((String) next2.getKey()));
                    zipOutputStream.write((byte[]) next2.getValue());
                    zipOutputStream.closeEntry();
                }
            }
        }
        zipOutputStream.close();
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (byteArray2 != null && (encrypt = CryptoUtil.encrypt(byteArray2)) != null) {
            writeFile(encrypt, file);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0012 A[Catch:{ IOException -> 0x0015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void writeFile(byte[] r2, java.io.File r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x000f }
            r1.<init>(r3)     // Catch:{ all -> 0x000f }
            r1.write(r2)     // Catch:{ all -> 0x000d }
            r1.close()     // Catch:{ IOException -> 0x0015 }
            goto L_0x0015
        L_0x000d:
            r0 = r1
            goto L_0x0010
        L_0x000f:
        L_0x0010:
            if (r0 == 0) goto L_0x0015
            r0.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.utils.ZipUtil.writeFile(byte[], java.io.File):void");
    }

    public static byte[] getContent(File file) throws IOException {
        byte[] bArr;
        long length = file.length();
        FileInputStream fileInputStream = null;
        if (length > 2147483647L) {
            return null;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            int i = (int) length;
            try {
                bArr = new byte[i];
                int i2 = 0;
                while (i2 < i) {
                    try {
                        int read = fileInputStream2.read(bArr, i2, i - i2);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        fileInputStream.close();
                        return bArr;
                    }
                }
                if (i2 != i) {
                    fileInputStream2.close();
                    return null;
                }
                fileInputStream2.close();
                return bArr;
            } catch (Throwable unused2) {
                bArr = null;
                fileInputStream = fileInputStream2;
                fileInputStream.close();
                return bArr;
            }
        } catch (Throwable unused3) {
            bArr = null;
            fileInputStream.close();
            return bArr;
        }
    }
}
