package com.didi.dimina.container.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class LocalDevUtil {
    public static List<File> unzipFile(File file, File file2) throws IOException {
        return unzipFileByKeyword(file, file2, (String) null);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0062=Splitter:B:19:0x0062, B:7:0x0024=Splitter:B:7:0x0024} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.io.File> unzipFileByKeyword(java.io.File r11, java.io.File r12, java.lang.String r13) throws java.io.IOException {
        /*
            if (r11 == 0) goto L_0x00ab
            if (r12 == 0) goto L_0x00ab
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile
            r1.<init>(r11)
            java.util.Enumeration r11 = r1.entries()
            boolean r2 = m13403a((java.lang.String) r13)     // Catch:{ all -> 0x00a6 }
            java.lang.String r3 = " is dangerous!"
            java.lang.String r4 = "entryName: "
            java.lang.String r5 = "ZipUtils"
            java.lang.String r6 = "../"
            java.lang.String r7 = "/"
            java.lang.String r8 = "\\"
            if (r2 == 0) goto L_0x0062
        L_0x0024:
            boolean r13 = r11.hasMoreElements()     // Catch:{ all -> 0x00a6 }
            if (r13 == 0) goto L_0x005e
            java.lang.Object r13 = r11.nextElement()     // Catch:{ all -> 0x00a6 }
            java.util.zip.ZipEntry r13 = (java.util.zip.ZipEntry) r13     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = r13.getName()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = r2.replace(r8, r7)     // Catch:{ all -> 0x00a6 }
            boolean r9 = r2.contains(r6)     // Catch:{ all -> 0x00a6 }
            if (r9 == 0) goto L_0x0054
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r13.<init>()     // Catch:{ all -> 0x00a6 }
            r13.append(r4)     // Catch:{ all -> 0x00a6 }
            r13.append(r2)     // Catch:{ all -> 0x00a6 }
            r13.append(r3)     // Catch:{ all -> 0x00a6 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00a6 }
            com.didi.dimina.container.util.LogUtil.m13410e(r5, r13)     // Catch:{ all -> 0x00a6 }
            goto L_0x0024
        L_0x0054:
            boolean r13 = m13402a(r12, r0, r1, r13, r2)     // Catch:{ all -> 0x00a6 }
            if (r13 != 0) goto L_0x0024
            r1.close()
            return r0
        L_0x005e:
            r1.close()
            return r0
        L_0x0062:
            boolean r2 = r11.hasMoreElements()     // Catch:{ all -> 0x00a6 }
            if (r2 == 0) goto L_0x00a2
            java.lang.Object r2 = r11.nextElement()     // Catch:{ all -> 0x00a6 }
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch:{ all -> 0x00a6 }
            java.lang.String r9 = r2.getName()     // Catch:{ all -> 0x00a6 }
            java.lang.String r9 = r9.replace(r8, r7)     // Catch:{ all -> 0x00a6 }
            boolean r10 = r9.contains(r6)     // Catch:{ all -> 0x00a6 }
            if (r10 == 0) goto L_0x0092
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r2.<init>()     // Catch:{ all -> 0x00a6 }
            r2.append(r4)     // Catch:{ all -> 0x00a6 }
            r2.append(r9)     // Catch:{ all -> 0x00a6 }
            r2.append(r3)     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00a6 }
            com.didi.dimina.container.util.LogUtil.m13410e(r5, r2)     // Catch:{ all -> 0x00a6 }
            goto L_0x0062
        L_0x0092:
            boolean r10 = r9.contains(r13)     // Catch:{ all -> 0x00a6 }
            if (r10 == 0) goto L_0x0062
            boolean r2 = m13402a(r12, r0, r1, r2, r9)     // Catch:{ all -> 0x00a6 }
            if (r2 != 0) goto L_0x0062
            r1.close()
            return r0
        L_0x00a2:
            r1.close()
            return r0
        L_0x00a6:
            r11 = move-exception
            r1.close()
            throw r11
        L_0x00ab:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.LocalDevUtil.unzipFileByKeyword(java.io.File, java.io.File, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    private static boolean m13401a(File file) {
        if (file != null) {
            return file.exists() ? file.isDirectory() : file.mkdirs();
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m13404b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!m13401a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m13402a(java.io.File r1, java.util.List<java.io.File> r2, java.util.zip.ZipFile r3, java.util.zip.ZipEntry r4, java.lang.String r5) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r1, r5)
            r2.add(r0)
            boolean r1 = r4.isDirectory()
            if (r1 == 0) goto L_0x0013
            boolean r1 = m13401a((java.io.File) r0)
            return r1
        L_0x0013:
            boolean r1 = m13404b(r0)
            r2 = 0
            if (r1 != 0) goto L_0x001b
            return r2
        L_0x001b:
            r1 = 0
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ all -> 0x004b }
            java.io.InputStream r3 = r3.getInputStream(r4)     // Catch:{ all -> 0x004b }
            r5.<init>(r3)     // Catch:{ all -> 0x004b }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0048 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0048 }
            r4.<init>(r0)     // Catch:{ all -> 0x0048 }
            r3.<init>(r4)     // Catch:{ all -> 0x0048 }
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0046 }
        L_0x0033:
            int r4 = r5.read(r1)     // Catch:{ all -> 0x0046 }
            r0 = -1
            if (r4 == r0) goto L_0x003e
            r3.write(r1, r2, r4)     // Catch:{ all -> 0x0046 }
            goto L_0x0033
        L_0x003e:
            r5.close()
            r3.close()
            r1 = 1
            return r1
        L_0x0046:
            r1 = move-exception
            goto L_0x004f
        L_0x0048:
            r2 = move-exception
            r3 = r1
            goto L_0x004e
        L_0x004b:
            r2 = move-exception
            r3 = r1
            r5 = r3
        L_0x004e:
            r1 = r2
        L_0x004f:
            if (r5 == 0) goto L_0x0054
            r5.close()
        L_0x0054:
            if (r3 == 0) goto L_0x0059
            r3.close()
        L_0x0059:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.LocalDevUtil.m13402a(java.io.File, java.util.List, java.util.zip.ZipFile, java.util.zip.ZipEntry, java.lang.String):boolean");
    }

    /* renamed from: a */
    private static boolean m13403a(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void deleteFile(File file) {
        deleteFile(file, false);
    }

    public static void deleteFile(File file, boolean z) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteFile : listFiles) {
                    deleteFile(deleteFile, false);
                }
                if (!z) {
                    file.delete();
                }
            }
        } else if (file.exists()) {
            file.delete();
        }
    }

    public static File getInternalFilesDirectory(Context context, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            file = context.getFilesDir();
        } else {
            file = new File(context.getFilesDir(), str);
        }
        if (!file.exists() && !file.mkdirs()) {
            LogUtil.m13410e("FileUtils", "getInternalDirectory fail ,the reason is make directory fail !");
        }
        return file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        r1 = r8;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
        if (r8 != null) goto L_0x002b;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006b A[SYNTHETIC, Splitter:B:33:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0078 A[SYNTHETIC, Splitter:B:41:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f A[SYNTHETIC, Splitter:B:45:0x007f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File copyAssetsFile(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.content.res.AssetManager r6 = r6.getAssets()
            java.io.InputStream r6 = r6.open(r7)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x003a, all -> 0x0036 }
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x003a, all -> 0x0036 }
            r2.<init>(r7)     // Catch:{ IOException -> 0x003a, all -> 0x0036 }
            java.lang.String r2 = r2.getName()     // Catch:{ IOException -> 0x003a, all -> 0x0036 }
            r0.<init>(r8, r2)     // Catch:{ IOException -> 0x003a, all -> 0x0036 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0031, all -> 0x0036 }
            r8.<init>(r0)     // Catch:{ IOException -> 0x0031, all -> 0x0036 }
            m13400a(r6, r8)     // Catch:{ IOException -> 0x002f }
            if (r6 == 0) goto L_0x002b
            r6.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            r8.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0073
        L_0x002f:
            r1 = move-exception
            goto L_0x0047
        L_0x0031:
            r8 = move-exception
            r5 = r1
            r1 = r8
            r8 = r5
            goto L_0x0047
        L_0x0036:
            r7 = move-exception
            r8 = r1
        L_0x0038:
            r1 = r6
            goto L_0x0076
        L_0x003a:
            r8 = move-exception
            r0 = r1
            r1 = r8
            r8 = r0
            goto L_0x0047
        L_0x003f:
            r7 = move-exception
            r8 = r1
            goto L_0x0076
        L_0x0042:
            r6 = move-exception
            r8 = r1
            r0 = r8
            r1 = r6
            r6 = r0
        L_0x0047:
            java.lang.String r2 = "FileUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r3.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = "Failed to copy asset file: "
            r3.append(r4)     // Catch:{ all -> 0x0074 }
            r3.append(r7)     // Catch:{ all -> 0x0074 }
            java.lang.String r7 = "\t"
            r3.append(r7)     // Catch:{ all -> 0x0074 }
            java.lang.String r7 = android.util.Log.getStackTraceString(r1)     // Catch:{ all -> 0x0074 }
            r3.append(r7)     // Catch:{ all -> 0x0074 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0074 }
            com.didi.dimina.container.util.LogUtil.m13410e(r2, r7)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0070
            r6.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0070
        L_0x006f:
        L_0x0070:
            if (r8 == 0) goto L_0x0073
            goto L_0x002b
        L_0x0073:
            return r0
        L_0x0074:
            r7 = move-exception
            goto L_0x0038
        L_0x0076:
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x007d
        L_0x007c:
        L_0x007d:
            if (r8 == 0) goto L_0x0082
            r8.close()     // Catch:{ IOException -> 0x0082 }
        L_0x0082:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.LocalDevUtil.copyAssetsFile(android.content.Context, java.lang.String, java.lang.String):java.io.File");
    }

    /* renamed from: a */
    private static void m13400a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
