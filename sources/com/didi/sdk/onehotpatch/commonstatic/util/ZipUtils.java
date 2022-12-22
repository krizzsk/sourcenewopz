package com.didi.sdk.onehotpatch.commonstatic.util;

import android.content.Context;
import com.didi.dynamic.manager.utils.Log;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipUtils {
    private static final String TAG = "DM.ZipUtils";
    private static byte[] ZIP_HEADER_1 = {80, 75, 3, 4};
    private static byte[] ZIP_HEADER_2 = {80, 75, 5, 6};

    /* JADX WARNING: Removed duplicated region for block: B:29:0x003e A[SYNTHETIC, Splitter:B:29:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0044 A[SYNTHETIC, Splitter:B:34:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isArchiveFile(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4.isFile()
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0038 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0038 }
            r4 = 4
            byte[] r1 = new byte[r4]     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            int r3 = r2.read(r1, r0, r4)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            if (r3 != r4) goto L_0x002c
            byte[] r4 = ZIP_HEADER_1     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            boolean r4 = java.util.Arrays.equals(r4, r1)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            if (r4 != 0) goto L_0x002a
            byte[] r4 = ZIP_HEADER_2     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            boolean r4 = java.util.Arrays.equals(r4, r1)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            if (r4 == 0) goto L_0x002c
        L_0x002a:
            r4 = 1
            r0 = 1
        L_0x002c:
            r2.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0041
        L_0x0030:
            r4 = move-exception
            r1 = r2
            goto L_0x0042
        L_0x0033:
            r4 = move-exception
            r1 = r2
            goto L_0x0039
        L_0x0036:
            r4 = move-exception
            goto L_0x0042
        L_0x0038:
            r4 = move-exception
        L_0x0039:
            r4.printStackTrace()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            return r0
        L_0x0042:
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0047:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.util.ZipUtils.isArchiveFile(java.io.File):boolean");
    }

    public static void unzip(File file, String str) {
        FileOutputStream fileOutputStream;
        try {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.equals("..") && !name.equals(".")) {
                            if (!name.contains("../")) {
                                String str2 = str + "/" + name;
                                if (nextEntry.isDirectory()) {
                                    File file3 = new File(str2);
                                    if (!file3.isDirectory()) {
                                        file3.mkdirs();
                                    }
                                } else {
                                    fileOutputStream = new FileOutputStream(str2, false);
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    zipInputStream.closeEntry();
                                    fileOutputStream.close();
                                }
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                zipInputStream.close();
                throw th;
            }
        } catch (Exception e) {
            Log.m14487e(TAG, "Unzip exception", e);
        }
    }

    public static boolean unJar(File file, File file2, HashMap<String, File> hashMap, FilenameFilter filenameFilter) throws IOException {
        return unJar(file, file2, hashMap, filenameFilter, (byte[]) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unJar(java.io.File r7, java.io.File r8, java.util.HashMap<java.lang.String, java.io.File> r9, java.io.FilenameFilter r10, byte[] r11) throws java.io.IOException {
        /*
            boolean r0 = r7.exists()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r7.isFile()
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x000f:
            r8.mkdirs()
            r0 = 0
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ all -> 0x00a8 }
            r2.<init>(r7)     // Catch:{ all -> 0x00a8 }
            java.util.Enumeration r7 = r2.entries()     // Catch:{ all -> 0x00a5 }
            if (r11 != 0) goto L_0x0022
            r11 = 4096(0x1000, float:5.74E-42)
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x00a5 }
        L_0x0022:
            boolean r3 = r7.hasMoreElements()     // Catch:{ all -> 0x00a5 }
            if (r3 == 0) goto L_0x00a0
            java.lang.Object r3 = r7.nextElement()     // Catch:{ all -> 0x00a5 }
            java.util.jar.JarEntry r3 = (java.util.jar.JarEntry) r3     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = ".."
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00a5 }
            if (r5 != 0) goto L_0x0022
            java.lang.String r5 = "."
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00a5 }
            if (r5 != 0) goto L_0x0022
            java.lang.String r5 = "../"
            boolean r4 = r4.contains(r5)     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x004b
            goto L_0x0022
        L_0x004b:
            boolean r4 = r3.isDirectory()     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x0052
            goto L_0x0022
        L_0x0052:
            if (r10 == 0) goto L_0x005f
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x00a5 }
            boolean r4 = r10.accept(r0, r4)     // Catch:{ all -> 0x00a5 }
            if (r4 != 0) goto L_0x005f
            goto L_0x0022
        L_0x005f:
            java.io.InputStream r4 = r2.getInputStream(r3)     // Catch:{ all -> 0x00a5 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00a5 }
            java.lang.String r6 = r3.getName()     // Catch:{ all -> 0x00a5 }
            r5.<init>(r8, r6)     // Catch:{ all -> 0x00a5 }
            boolean r6 = r5.exists()     // Catch:{ all -> 0x00a5 }
            if (r6 != 0) goto L_0x0079
            java.io.File r6 = r5.getParentFile()     // Catch:{ all -> 0x00a5 }
            r6.mkdirs()     // Catch:{ all -> 0x00a5 }
        L_0x0079:
            if (r9 == 0) goto L_0x0082
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x00a5 }
            r9.put(r3, r5)     // Catch:{ all -> 0x00a5 }
        L_0x0082:
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00a5 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a5 }
            r6.<init>(r5)     // Catch:{ all -> 0x00a5 }
            r3.<init>(r6)     // Catch:{ all -> 0x00a5 }
        L_0x008c:
            int r5 = r4.read(r11)     // Catch:{ all -> 0x00a5 }
            if (r5 <= 0) goto L_0x0096
            r3.write(r11, r1, r5)     // Catch:{ all -> 0x00a5 }
            goto L_0x008c
        L_0x0096:
            r3.flush()     // Catch:{ all -> 0x00a5 }
            r3.close()     // Catch:{ all -> 0x00a5 }
            r4.close()     // Catch:{ all -> 0x00a5 }
            goto L_0x0022
        L_0x00a0:
            r2.close()
            r7 = 1
            return r7
        L_0x00a5:
            r7 = move-exception
            r0 = r2
            goto L_0x00a9
        L_0x00a8:
            r7 = move-exception
        L_0x00a9:
            if (r0 == 0) goto L_0x00ae
            r0.close()
        L_0x00ae:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.util.ZipUtils.unJar(java.io.File, java.io.File, java.util.HashMap, java.io.FilenameFilter, byte[]):boolean");
    }

    public static void jar(File file, File file2) throws IOException {
        jar(file, file2, (byte[]) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void jar(java.io.File r4, java.io.File r5, byte[] r6) throws java.io.IOException {
        /*
            boolean r0 = r4.exists()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x0010
            r5.createNewFile()
        L_0x0010:
            r0 = 0
            if (r6 != 0) goto L_0x0017
            r6 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r6]
        L_0x0017:
            java.util.jar.JarOutputStream r1 = new java.util.jar.JarOutputStream     // Catch:{ all -> 0x0036 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0036 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0036 }
            r3.<init>(r5)     // Catch:{ all -> 0x0036 }
            r2.<init>(r3)     // Catch:{ all -> 0x0036 }
            r1.<init>(r2)     // Catch:{ all -> 0x0036 }
            r5 = 1
            r1.setLevel(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = ""
            jarInner(r1, r4, r5, r6)     // Catch:{ all -> 0x0033 }
            r1.close()
            return
        L_0x0033:
            r4 = move-exception
            r0 = r1
            goto L_0x0037
        L_0x0036:
            r4 = move-exception
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()
        L_0x003c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.util.ZipUtils.jar(java.io.File, java.io.File, byte[]):void");
    }

    private static void jarInner(JarOutputStream jarOutputStream, File file, String str, byte[] bArr) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length == 0) {
                jarOutputStream.putNextEntry(new JarEntry(str + "/"));
            }
            for (int i = 0; i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (str != null && !str.equals("")) {
                    name = str + "/" + listFiles[i].getName();
                }
                jarInner(jarOutputStream, listFiles[i], name, bArr);
            }
            return;
        }
        JarEntry jarEntry = new JarEntry(str);
        jarEntry.setTime(file.lastModified());
        jarOutputStream.putNextEntry(jarEntry);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read > 0) {
                jarOutputStream.write(bArr, 0, read);
            } else {
                jarOutputStream.flush();
                bufferedInputStream.close();
                fileInputStream.close();
                jarOutputStream.closeEntry();
                return;
            }
        }
    }

    public static void copyEntry(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        copyEntry(zipFile, zipEntry, file, (byte[]) null);
    }

    public static void copyEntry(ZipFile zipFile, ZipEntry zipEntry, File file, byte[] bArr) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (bArr != null) {
            IOUtils.copyLarge(inputStream, (OutputStream) fileOutputStream, bArr);
        } else {
            IOUtils.copyLarge(inputStream, (OutputStream) fileOutputStream);
        }
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly((Closeable) fileOutputStream);
    }

    public static String copyAsset(Context context, String str, File file) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            InputStream open = context.getAssets().open(str);
            FileUtils.copyInputStreamToFile(open, file2);
            open.close();
        }
        return file2.getAbsolutePath();
    }
}
