package com.didi.dimina.webview.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtil {
    public static final int EOF = -1;

    /* renamed from: a */
    private static final int f18398a = 4096;

    public static String readTextFile(File file) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    sb.append(readLine);
                    sb.append("\n");
                }
                String sb2 = sb.toString();
                closeQuietly(bufferedReader2);
                return sb2;
            } catch (IOException unused) {
                bufferedReader = bufferedReader2;
                closeQuietly(bufferedReader);
                return "";
            } catch (Throwable th) {
                closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            closeQuietly(bufferedReader);
            return "";
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readBinaryFile(java.io.File r5) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002a }
            r3.<init>(r5)     // Catch:{ IOException -> 0x002a }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0026, all -> 0x0023 }
        L_0x0010:
            r2 = -1
            int r4 = r3.read(r5)     // Catch:{ IOException -> 0x0026, all -> 0x0023 }
            if (r2 == r4) goto L_0x001b
            r0.write(r5, r1, r4)     // Catch:{ IOException -> 0x0026, all -> 0x0023 }
            goto L_0x0010
        L_0x001b:
            byte[] r5 = r0.toByteArray()     // Catch:{ IOException -> 0x0026, all -> 0x0023 }
            closeQuietly(r3)
            goto L_0x002f
        L_0x0023:
            r5 = move-exception
            r2 = r3
            goto L_0x0033
        L_0x0026:
            r2 = r3
            goto L_0x002a
        L_0x0028:
            r5 = move-exception
            goto L_0x0033
        L_0x002a:
            byte[] r5 = new byte[r1]     // Catch:{ all -> 0x0028 }
            closeQuietly(r2)
        L_0x002f:
            closeQuietly(r0)
            return r5
        L_0x0033:
            closeQuietly(r2)
            closeQuietly(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.util.FileUtil.readBinaryFile(java.io.File):byte[]");
    }

    public static String Base64File(File file) {
        byte[] readBinaryFile = readBinaryFile(file);
        return (readBinaryFile == null || readBinaryFile.length <= 0) ? "" : Base64.encodeToString(readBinaryFile, 8);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean writeInputStreamToOutputStream(BufferedInputStream bufferedInputStream, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read != -1) {
                        bufferedOutputStream2.write(read);
                    } else {
                        closeQuietly(bufferedInputStream);
                        closeQuietly(bufferedOutputStream2);
                        return true;
                    }
                } catch (IOException unused) {
                    bufferedOutputStream = bufferedOutputStream2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(bufferedOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(bufferedOutputStream);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            closeQuietly(bufferedInputStream);
            closeQuietly(bufferedOutputStream);
            return false;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(bufferedInputStream);
            closeQuietly(bufferedOutputStream);
            throw th;
        }
    }

    public static boolean isBinaryFile(String str) {
        String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
        if (lowerCase.equals("png") || lowerCase.equals(com.didi.dimina.starbox.util.FileUtil.JPG) || lowerCase.equals("jpeg") || lowerCase.equals("gif")) {
            return true;
        }
        return false;
    }

    public static boolean isBinaryFile(File file) {
        return isBinaryFile(file.getName());
    }

    public static boolean isBinaryFile(Uri uri) {
        return isBinaryFile(uri.getLastPathSegment());
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static void deleteContents(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    public static boolean hasContents(File file) {
        if (file == null || !file.exists() || !file.isDirectory() || file.listFiles().length <= 0) {
            return false;
        }
        return true;
    }

    public static boolean verifyData(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str2.equals(C7819Util.getSHA1(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005a A[SYNTHETIC, Splitter:B:37:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0064 A[SYNTHETIC, Splitter:B:42:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006c A[SYNTHETIC, Splitter:B:48:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0076 A[SYNTHETIC, Splitter:B:53:0x0076] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFile(java.io.File r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x007f
            boolean r1 = r6.exists()
            if (r1 == 0) goto L_0x007f
            boolean r1 = r6.canRead()
            if (r1 != 0) goto L_0x0011
            goto L_0x007f
        L_0x0011:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            r1.<init>()     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r6 = 8000(0x1f40, float:1.121E-41)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0047 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0047 }
            r3.<init>()     // Catch:{ Exception -> 0x0047 }
        L_0x0024:
            int r4 = r2.read(r6)     // Catch:{ Exception -> 0x0047 }
            r5 = -1
            if (r4 == r5) goto L_0x0030
            r5 = 0
            r3.write(r6, r5, r4)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0024
        L_0x0030:
            java.lang.String r6 = "UTF-8"
            java.lang.String r0 = r3.toString(r6)     // Catch:{ Exception -> 0x0047 }
            r1.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x003e:
            r2.close()     // Catch:{ Exception -> 0x0042 }
            goto L_0x0067
        L_0x0042:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0067
        L_0x0047:
            r6 = move-exception
            goto L_0x0055
        L_0x0049:
            r6 = move-exception
            r2 = r0
            goto L_0x0069
        L_0x004c:
            r6 = move-exception
            r2 = r0
            goto L_0x0055
        L_0x004f:
            r6 = move-exception
            r2 = r0
            goto L_0x006a
        L_0x0052:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L_0x0055:
            r6.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0062:
            if (r2 == 0) goto L_0x0067
            r2.close()     // Catch:{ Exception -> 0x0042 }
        L_0x0067:
            return r0
        L_0x0068:
            r6 = move-exception
        L_0x0069:
            r0 = r1
        L_0x006a:
            if (r0 == 0) goto L_0x0074
            r0.close()     // Catch:{ Exception -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0074:
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ Exception -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007e:
            throw r6
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.util.FileUtil.readFile(java.io.File):java.lang.String");
    }
}
