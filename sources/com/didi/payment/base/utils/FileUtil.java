package com.didi.payment.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    /* renamed from: a */
    private static final int f29982a = -1;

    /* renamed from: b */
    private static final int f29983b = 10240;

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0055 A[SYNTHETIC, Splitter:B:37:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005f A[SYNTHETIC, Splitter:B:42:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0067 A[SYNTHETIC, Splitter:B:48:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0071 A[SYNTHETIC, Splitter:B:53:0x0071] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFile(java.io.File r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x007a
            boolean r1 = r5.exists()
            if (r1 == 0) goto L_0x007a
            boolean r1 = r5.canRead()
            if (r1 != 0) goto L_0x0011
            goto L_0x007a
        L_0x0011:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            r1.<init>()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r5 = 10240(0x2800, float:1.4349E-41)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0042 }
        L_0x001f:
            r3 = -1
            int r4 = r2.read(r5)     // Catch:{ Exception -> 0x0042 }
            if (r3 == r4) goto L_0x002b
            r3 = 0
            r1.write(r5, r3, r4)     // Catch:{ Exception -> 0x0042 }
            goto L_0x001f
        L_0x002b:
            java.lang.String r5 = "UTF-8"
            java.lang.String r0 = r1.toString(r5)     // Catch:{ Exception -> 0x0042 }
            r1.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0039:
            r2.close()     // Catch:{ Exception -> 0x003d }
            goto L_0x0062
        L_0x003d:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0062
        L_0x0042:
            r5 = move-exception
            goto L_0x0050
        L_0x0044:
            r5 = move-exception
            r2 = r0
            goto L_0x0064
        L_0x0047:
            r5 = move-exception
            r2 = r0
            goto L_0x0050
        L_0x004a:
            r5 = move-exception
            r2 = r0
            goto L_0x0065
        L_0x004d:
            r5 = move-exception
            r1 = r0
            r2 = r1
        L_0x0050:
            r5.printStackTrace()     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005d:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ Exception -> 0x003d }
        L_0x0062:
            return r0
        L_0x0063:
            r5 = move-exception
        L_0x0064:
            r0 = r1
        L_0x0065:
            if (r0 == 0) goto L_0x006f
            r0.close()     // Catch:{ Exception -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006f:
            if (r2 == 0) goto L_0x0079
            r2.close()     // Catch:{ Exception -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0079:
            throw r5
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.utils.FileUtil.readFile(java.io.File):java.lang.String");
    }

    public static String readLineFile(File file) {
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
            } catch (IOException e) {
                e = e;
                bufferedReader = bufferedReader2;
                try {
                    e.printStackTrace();
                    closeQuietly(bufferedReader);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                closeQuietly(bufferedReader);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
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
            r5 = 10240(0x2800, float:1.4349E-41)
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.utils.FileUtil.readBinaryFile(java.io.File):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[SYNTHETIC, Splitter:B:30:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0057 A[SYNTHETIC, Splitter:B:35:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0063 A[SYNTHETIC, Splitter:B:42:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006d A[SYNTHETIC, Splitter:B:47:0x006d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String byteToFile(byte[] r3, java.lang.String r4, android.content.Context r5) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r5 = getFileDir4GalleryDisplay(r5)
            r0.<init>(r5, r4)
            java.lang.String r4 = r0.getAbsolutePath()
            r5 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            if (r2 != 0) goto L_0x0022
            boolean r2 = r1.isDirectory()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            if (r2 == 0) goto L_0x0022
            r1.mkdirs()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
        L_0x0022:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0041 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0041 }
            r0.write(r3)     // Catch:{ Exception -> 0x003e, all -> 0x003b }
            r0.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0037:
            r1.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x003b:
            r3 = move-exception
            r5 = r0
            goto L_0x0061
        L_0x003e:
            r3 = move-exception
            r5 = r0
            goto L_0x0048
        L_0x0041:
            r3 = move-exception
            goto L_0x0048
        L_0x0043:
            r3 = move-exception
            r1 = r5
            goto L_0x0061
        L_0x0046:
            r3 = move-exception
            r1 = r5
        L_0x0048:
            r3.printStackTrace()     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x0055
            r5.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0055:
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x005f:
            return r4
        L_0x0060:
            r3 = move-exception
        L_0x0061:
            if (r5 == 0) goto L_0x006b
            r5.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006b:
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0075:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.utils.FileUtil.byteToFile(byte[], java.lang.String, android.content.Context):java.lang.String");
    }

    public static String Base64File(File file) {
        byte[] readBinaryFile = readBinaryFile(file);
        if (readBinaryFile == null || readBinaryFile.length <= 0) {
            return null;
        }
        return Base64.encodeToString(readBinaryFile, 8);
    }

    public static String saveFile(Context context, Bitmap bitmap, String str) {
        return saveFile(context, bitmap, str, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A[SYNTHETIC, Splitter:B:24:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0051 A[SYNTHETIC, Splitter:B:31:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String saveFile(android.content.Context r2, android.graphics.Bitmap r3, java.lang.String r4, boolean r5) {
        /*
            java.lang.String r0 = ""
            if (r3 != 0) goto L_0x0005
            return r0
        L_0x0005:
            if (r5 == 0) goto L_0x0011
            java.io.File r5 = new java.io.File
            java.io.File r2 = getFileDir4GalleryDisplay(r2)
            r5.<init>(r2, r4)
            goto L_0x001a
        L_0x0011:
            java.io.File r5 = new java.io.File
            java.io.File r2 = getCacheDir(r2)
            r5.<init>(r2, r4)
        L_0x001a:
            r2 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x003d, all -> 0x0039 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x003d, all -> 0x0039 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0037 }
            r1 = 100
            r3.compress(r2, r1, r4)     // Catch:{ Exception -> 0x0037 }
            r4.flush()     // Catch:{ Exception -> 0x0037 }
            java.lang.String r2 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x0037 }
            r4.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0036:
            return r2
        L_0x0037:
            r2 = move-exception
            goto L_0x0040
        L_0x0039:
            r3 = move-exception
            r4 = r2
            r2 = r3
            goto L_0x004f
        L_0x003d:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L_0x0040:
            r2.printStackTrace()     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x004d
            r4.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r2 = move-exception
            r2.printStackTrace()
        L_0x004d:
            return r0
        L_0x004e:
            r2 = move-exception
        L_0x004f:
            if (r4 == 0) goto L_0x0059
            r4.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0059:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.utils.FileUtil.saveFile(android.content.Context, android.graphics.Bitmap, java.lang.String, boolean):java.lang.String");
    }

    public static void deleteFile(String str) {
        try {
            new File(str).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File getFileDir4GalleryDisplay(Context context) {
        File file;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = context.getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        } else {
            file = null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getCacheDir(Context context) {
        File file;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = context.getApplicationContext().getExternalCacheDir();
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getApplicationContext().getCacheDir();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getDefaultAppDir(Context context) {
        File file;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = context.getApplicationContext().getExternalCacheDir();
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getApplicationContext().getCacheDir();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
