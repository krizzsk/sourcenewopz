package com.didi.dimina.container.secondparty.bundle.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PmFileUtil {
    public static final String TAG = "Dimina-PM PmFileUtil";

    public static boolean mkdirs(String... strArr) {
        for (String str : strArr) {
            LogUtil.iRelease(TAG, "创造路径=" + new File(str).mkdirs() + "\t " + str);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String read(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x0081
            boolean r0 = isFileExit(r6)
            java.lang.String r1 = "Dimina-PM PmFileUtil"
            if (r0 != 0) goto L_0x0024
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "读取文件，却不是文件 + "
            r0.append(r2)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.didi.dimina.container.util.LogUtil.eRelease(r1, r6)
            r6 = 0
            return r6
        L_0x0024:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0051 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0051 }
            int r3 = r2.available()     // Catch:{ all -> 0x0045 }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0045 }
            r2.read(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0045 }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0045 }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0045 }
            r0.append(r4)     // Catch:{ all -> 0x0045 }
            r2.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x007c
        L_0x0045:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r4 = move-exception
            r2.close()     // Catch:{ all -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r2 = move-exception
            r3.addSuppressed(r2)     // Catch:{ Exception -> 0x0051 }
        L_0x0050:
            throw r4     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            r2 = move-exception
            r2.printStackTrace()
            r3 = 0
            int r4 = r0.length()
            r0.delete(r3, r4)
            java.lang.String r6 = m12674a(r6)
            r0.append(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r3 = "读取文件发生Exception ="
            r6.append(r3)
            java.lang.String r2 = r2.toString()
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.didi.dimina.container.util.LogUtil.eRelease(r1, r6)
        L_0x007c:
            java.lang.String r6 = r0.toString()
            return r6
        L_0x0081:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.util.PmFileUtil.read(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A[SYNTHETIC, Splitter:B:27:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0060 A[SYNTHETIC, Splitter:B:34:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0067 A[SYNTHETIC, Splitter:B:38:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            r2.<init>(r5)     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            copyFile((java.io.InputStream) r1, (java.io.OutputStream) r2)     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x005c
        L_0x001f:
            r5 = move-exception
            goto L_0x0025
        L_0x0021:
            r6 = move-exception
            goto L_0x0029
        L_0x0023:
            r5 = move-exception
            r2 = r0
        L_0x0025:
            r0 = r1
            goto L_0x005e
        L_0x0027:
            r6 = move-exception
            r2 = r0
        L_0x0029:
            r0 = r1
            goto L_0x0030
        L_0x002b:
            r5 = move-exception
            r2 = r0
            goto L_0x005e
        L_0x002e:
            r6 = move-exception
            r2 = r0
        L_0x0030:
            java.lang.String r1 = "Dimina-PM PmFileUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r3.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "Failed to copy file: "
            r3.append(r4)     // Catch:{ all -> 0x005d }
            r3.append(r5)     // Catch:{ all -> 0x005d }
            java.lang.String r5 = "\n"
            r3.append(r5)     // Catch:{ all -> 0x005d }
            java.lang.String r5 = android.util.Log.getStackTraceString(r6)     // Catch:{ all -> 0x005d }
            r3.append(r5)     // Catch:{ all -> 0x005d }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x005d }
            com.didi.dimina.container.util.LogUtil.eRelease(r1, r5)     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0059
            r0.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x0059
        L_0x0058:
        L_0x0059:
            if (r2 == 0) goto L_0x005c
            goto L_0x001b
        L_0x005c:
            return
        L_0x005d:
            r5 = move-exception
        L_0x005e:
            if (r0 == 0) goto L_0x0065
            r0.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0065
        L_0x0064:
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.close()     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.util.PmFileUtil.copyFile(java.lang.String, java.lang.String):void");
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0059 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090 A[SYNTHETIC, Splitter:B:26:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009c A[SYNTHETIC, Splitter:B:33:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3 A[SYNTHETIC, Splitter:B:37:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.io.File r5, java.io.File r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "copyFile(File src, File dst), src -> "
            r0.append(r1)
            java.lang.String r1 = r5.getAbsolutePath()
            r0.append(r1)
            java.lang.String r1 = " 存在？"
            r0.append(r1)
            boolean r2 = r5.exists()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "Dimina-PM PmFileUtil"
            com.didi.dimina.container.util.LogUtil.iRelease(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "copyFile(File src, File dst),  dst -> "
            r0.append(r3)
            java.lang.String r3 = r6.getAbsolutePath()
            r0.append(r3)
            r0.append(r1)
            boolean r1 = r6.exists()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.didi.dimina.container.util.LogUtil.iRelease(r2, r0)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r1.<init>(r5)     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            copyFile((java.io.InputStream) r1, (java.io.OutputStream) r3)     // Catch:{ IOException -> 0x005f, all -> 0x005d }
            r1.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            r3.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x0098
        L_0x005d:
            r5 = move-exception
            goto L_0x0063
        L_0x005f:
            r6 = move-exception
            goto L_0x0067
        L_0x0061:
            r5 = move-exception
            r3 = r0
        L_0x0063:
            r0 = r1
            goto L_0x009a
        L_0x0065:
            r6 = move-exception
            r3 = r0
        L_0x0067:
            r0 = r1
            goto L_0x006e
        L_0x0069:
            r5 = move-exception
            r3 = r0
            goto L_0x009a
        L_0x006c:
            r6 = move-exception
            r3 = r0
        L_0x006e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r1.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "Failed to copy file: "
            r1.append(r4)     // Catch:{ all -> 0x0099 }
            r1.append(r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r5 = "\n"
            r1.append(r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r5 = android.util.Log.getStackTraceString(r6)     // Catch:{ all -> 0x0099 }
            r1.append(r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0099 }
            com.didi.dimina.container.util.LogUtil.eRelease(r2, r5)     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0095
            r0.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0095
        L_0x0094:
        L_0x0095:
            if (r3 == 0) goto L_0x0098
            goto L_0x0059
        L_0x0098:
            return
        L_0x0099:
            r5 = move-exception
        L_0x009a:
            if (r0 == 0) goto L_0x00a1
            r0.close()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a1
        L_0x00a0:
        L_0x00a1:
            if (r3 == 0) goto L_0x00a6
            r3.close()     // Catch:{ IOException -> 0x00a6 }
        L_0x00a6:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.util.PmFileUtil.copyFile(java.io.File, java.io.File):void");
    }

    public static void deleteFile(String str) {
        deleteFile(str, false);
    }

    public static void deleteFile(String str, boolean z) {
        deleteFile(new File(str), z);
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

    public static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isFileExit(String str) {
        return FileUtil.exists(1, str);
    }

    public static boolean isDirExit(String str) {
        return FileUtil.exists(2, str);
    }

    public static boolean rename(String str, String str2) {
        return FileUtil.rename(str, str2);
    }

    public static File getInternalCacheDirectory(Context context, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            file = context.getCacheDir();
        } else {
            file = new File(context.getCacheDir(), str);
        }
        if (!file.exists() && !file.mkdirs()) {
            LogUtil.eRelease("FileUtils", "getInternalDirectory fail ,the reason is make directory fail !");
        }
        return file;
    }

    public static File getInternalFilesDirectory(Context context, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            file = context.getFilesDir();
        } else {
            file = new File(context.getFilesDir(), str);
        }
        if (!file.exists() && !file.mkdirs()) {
            LogUtil.eRelease(TAG, "getInternalDirectory fail ,the reason is make directory fail !");
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x001f A[SYNTHETIC, Splitter:B:16:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC, Splitter:B:21:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeFile(java.lang.String r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0019 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0019 }
            byte[] r2 = r3.getBytes()     // Catch:{ Exception -> 0x0014, all -> 0x0011 }
            r1.write(r2)     // Catch:{ Exception -> 0x0014, all -> 0x0011 }
            r1.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0011:
            r2 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0014:
            r2 = move-exception
            r0 = r1
            goto L_0x001a
        L_0x0017:
            r2 = move-exception
            goto L_0x0028
        L_0x0019:
            r2 = move-exception
        L_0x001a:
            r2.printStackTrace()     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0027
            r0.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0027:
            return
        L_0x0028:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0032:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.util.PmFileUtil.writeFile(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    private static String m12674a(String str) {
        BufferedReader bufferedReader;
        IOException e;
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append("\n");
                        sb.append(readLine);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            closeStream(bufferedReader);
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            closeStream(bufferedReader);
                            throw th;
                        }
                    }
                }
            } catch (IOException e3) {
                bufferedReader = null;
                e = e3;
                e.printStackTrace();
                closeStream(bufferedReader);
                return sb.toString();
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
                closeStream(bufferedReader);
                throw th;
            }
            closeStream(bufferedReader);
        }
        return sb.toString();
    }

    public static void copyDirectory(String str, String str2) {
        LogUtil.iRelease(TAG, "copyDirectory() - > srcDir = " + str);
        LogUtil.iRelease(TAG, "copyDirectory() - > dstDir = " + str2);
        copyDirectory(new File(str), new File(str2));
    }

    public static void copyDirectory(File file, File file2) {
        if (!file.isDirectory()) {
            File parentFile = file2.getParentFile();
            if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                copyFile(file, file2);
                return;
            }
            LogUtil.eRelease(TAG, "Cannot create dir " + parentFile.getAbsolutePath());
        } else if (file2.exists() || file2.mkdirs()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                copyDirectory(new File(file, list[i]), new File(file2, list[i]));
            }
        } else {
            LogUtil.eRelease(TAG, "Cannot create dir " + file2.getAbsolutePath());
        }
    }

    public static List<String> childFileInDir(String str) {
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (!CollectionsUtil.isEmpty((Object[]) list)) {
                for (String add : list) {
                    arrayList.add(add);
                }
            }
        }
        LogUtil.iRelease(TAG, "childFileInDir()-> dir=" + str + "\t childs=" + arrayList);
        return arrayList;
    }
}
