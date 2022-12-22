package com.didi.hawaii.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

/* renamed from: com.didi.hawaii.utils.IO */
public class C9266IO {

    /* renamed from: a */
    private static final int f24194a = 4096;

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final byte[] toBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        safeClose(byteArrayOutputStream);
                        return byteArray;
                    }
                }
            } catch (IOException unused) {
                safeClose(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                safeClose(byteArrayOutputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            byteArrayOutputStream = null;
            safeClose(byteArrayOutputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            safeClose(byteArrayOutputStream2);
            throw th;
        }
    }

    public static final long pipe(InputStream inputStream, OutputStream outputStream) {
        long j = -1;
        if (inputStream == null || outputStream == null) {
            return -1;
        }
        try {
            byte[] bArr = new byte[4096];
            long j2 = 0;
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        return j2;
                    }
                    outputStream.write(bArr, 0, read);
                    j2 += (long) read;
                } catch (IOException unused) {
                    j = j2;
                    return j;
                }
            }
        } catch (IOException unused2) {
            return j;
        }
    }

    public static int writeToFile(byte[] bArr, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return writeToFile(bArr, new File(str), z);
    }

    public static int writeToFile(byte[] bArr, File file, boolean z) {
        if (!(bArr == null || bArr.length == 0 || file == null || file.isDirectory())) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    int length = bArr.length;
                    safeClose(fileOutputStream2);
                    return length;
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    safeClose(fileOutputStream);
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    safeClose(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                safeClose(fileOutputStream);
                return 0;
            } catch (Throwable th2) {
                th = th2;
                safeClose(fileOutputStream);
                throw th;
            }
        }
        return 0;
    }

    public static boolean ensureDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            return file.mkdirs();
        } catch (Exception unused) {
            return false;
        }
    }

    public static final InputStream getInputStream(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isFile() && file.canRead()) {
                return new FileInputStream(file);
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public static void safeRecycle(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.isRecycled();
        }
    }

    public static boolean rename(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.renameTo(new File(str2));
        }
        return false;
    }

    public static boolean deleteFileOrFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(str);
        while (!stack.isEmpty()) {
            File file = new File((String) stack.peek());
            if (!file.exists()) {
                stack.pop();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    file.delete();
                    stack.pop();
                } else {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            stack.push(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                        }
                    }
                }
            } else {
                file.delete();
                stack.pop();
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[SYNTHETIC, Splitter:B:18:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[SYNTHETIC, Splitter:B:25:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFromFile(java.lang.String r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.Context r2 = com.didi.hawaii.basic.HWContextProvider.getContext()     // Catch:{ IOException -> 0x002e }
            java.io.FileInputStream r4 = r2.openFileInput(r4)     // Catch:{ IOException -> 0x002e }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x002e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x002e }
            r3.<init>(r4)     // Catch:{ IOException -> 0x002e }
            r2.<init>(r3)     // Catch:{ IOException -> 0x002e }
        L_0x0018:
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            if (r4 == 0) goto L_0x0022
            r0.append(r4)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            goto L_0x0018
        L_0x0022:
            r2.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0026:
            r4 = move-exception
            r1 = r2
            goto L_0x0041
        L_0x0029:
            r4 = move-exception
            r1 = r2
            goto L_0x002f
        L_0x002c:
            r4 = move-exception
            goto L_0x0041
        L_0x002e:
            r4 = move-exception
        L_0x002f:
            r4.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003c:
            java.lang.String r4 = r0.toString()
            return r4
        L_0x0041:
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.C9266IO.readFromFile(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029 A[SYNTHETIC, Splitter:B:16:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[SYNTHETIC, Splitter:B:21:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToFile(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.Context r1 = com.didi.hawaii.basic.HWContextProvider.getContext()     // Catch:{ IOException -> 0x0023 }
            r2 = 0
            java.io.FileOutputStream r3 = r1.openFileOutput(r3, r2)     // Catch:{ IOException -> 0x0023 }
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x0023 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0023 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0023 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0023 }
            r1.write(r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
            r1.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x001b:
            r3 = move-exception
            r0 = r1
            goto L_0x0032
        L_0x001e:
            r3 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0021:
            r3 = move-exception
            goto L_0x0032
        L_0x0023:
            r3 = move-exception
        L_0x0024:
            r3.printStackTrace()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0031:
            return
        L_0x0032:
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.C9266IO.writeToFile(java.lang.String, java.lang.String):void");
    }
}
