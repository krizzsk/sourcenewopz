package com.didi.dimina.container.secondparty.bundle.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.util.LogUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PmAssetsUtil {
    public static final String TAG = "Dimina-PM PmAssetsUtil";

    public static String toSafeAssetsDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.charAt(0) == '/' ? str.substring(1) : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070 A[SYNTHETIC, Splitter:B:36:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007a A[SYNTHETIC, Splitter:B:41:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0087 A[SYNTHETIC, Splitter:B:49:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0091 A[SYNTHETIC, Splitter:B:54:0x0091] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readAssetsFile(android.content.Context r4, java.lang.String r5) {
        /*
            boolean r0 = isAssetsFilesExist(r4, r5)
            r1 = 0
            if (r0 != 0) goto L_0x001e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "readAssetsFile() 文件不存在 : "
            r4.append(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "Dimina-PM PmAssetsUtil"
            com.didi.dimina.container.util.LogUtil.eRelease(r5, r4)
            return r1
        L_0x001e:
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r5.<init>(r4, r0)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x005d }
            r0.<init>(r5)     // Catch:{ Exception -> 0x005d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d }
            r2.<init>()     // Catch:{ Exception -> 0x005d }
        L_0x0037:
            java.lang.String r3 = r0.readLine()     // Catch:{ Exception -> 0x005d }
            if (r3 == 0) goto L_0x0046
            r2.append(r3)     // Catch:{ Exception -> 0x005d }
            java.lang.String r3 = "\n"
            r2.append(r3)     // Catch:{ Exception -> 0x005d }
            goto L_0x0037
        L_0x0046:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x005d }
            if (r4 == 0) goto L_0x0054
            r4.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0054:
            r5.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005c:
            return r0
        L_0x005d:
            r0 = move-exception
            goto L_0x006b
        L_0x005f:
            r0 = move-exception
            r5 = r1
            goto L_0x0084
        L_0x0062:
            r0 = move-exception
            r5 = r1
            goto L_0x006b
        L_0x0065:
            r0 = move-exception
            r5 = r1
            goto L_0x0085
        L_0x0068:
            r0 = move-exception
            r4 = r1
            r5 = r4
        L_0x006b:
            r0.printStackTrace()     // Catch:{ all -> 0x0083 }
            if (r4 == 0) goto L_0x0078
            r4.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0078:
            if (r5 == 0) goto L_0x0082
            r5.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0082:
            return r1
        L_0x0083:
            r0 = move-exception
        L_0x0084:
            r1 = r4
        L_0x0085:
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x008f:
            if (r5 == 0) goto L_0x0099
            r5.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0099:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.util.PmAssetsUtil.readAssetsFile(android.content.Context, java.lang.String):java.lang.String");
    }

    public static List<File> copyAssetsFiles(Context context, String str, String str2) {
        if (str == null) {
            str = "";
        }
        String[] strArr = null;
        try {
            strArr = context.getAssets().list(str);
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.eRelease(TAG, "Failed to get asset file list.\n" + Log.getStackTraceString(e));
        }
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str3 : strArr) {
                arrayList.add(copyAssetsFile(context, str + "/" + str3, str2));
            }
        }
        return arrayList;
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
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0073, code lost:
        if (r8 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e A[SYNTHETIC, Splitter:B:32:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007b A[SYNTHETIC, Splitter:B:40:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0082 A[SYNTHETIC, Splitter:B:44:0x0082] */
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
            com.didi.dimina.container.secondparty.bundle.util.PmFileUtil.copyFile((java.io.InputStream) r6, (java.io.OutputStream) r8)     // Catch:{ IOException -> 0x002f }
            if (r6 == 0) goto L_0x002b
            r6.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            r8.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x0076
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
            goto L_0x0079
        L_0x003a:
            r8 = move-exception
            r0 = r1
            r1 = r8
            r8 = r0
            goto L_0x0047
        L_0x003f:
            r7 = move-exception
            r8 = r1
            goto L_0x0079
        L_0x0042:
            r6 = move-exception
            r8 = r1
            r0 = r8
            r1 = r6
            r6 = r0
        L_0x0047:
            r1.printStackTrace()     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "FileUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r3.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "Failed to copy asset file: "
            r3.append(r4)     // Catch:{ all -> 0x0077 }
            r3.append(r7)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = "\n"
            r3.append(r7)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = android.util.Log.getStackTraceString(r1)     // Catch:{ all -> 0x0077 }
            r3.append(r7)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0077 }
            com.didi.dimina.container.util.LogUtil.eRelease(r2, r7)     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x0073
            r6.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0073
        L_0x0072:
        L_0x0073:
            if (r8 == 0) goto L_0x0076
            goto L_0x002b
        L_0x0076:
            return r0
        L_0x0077:
            r7 = move-exception
            goto L_0x0038
        L_0x0079:
            if (r1 == 0) goto L_0x0080
            r1.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0080
        L_0x007f:
        L_0x0080:
            if (r8 == 0) goto L_0x0085
            r8.close()     // Catch:{ IOException -> 0x0085 }
        L_0x0085:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.util.PmAssetsUtil.copyAssetsFile(android.content.Context, java.lang.String, java.lang.String):java.io.File");
    }

    public static String[] getAssetsFiles(Context context, String str) {
        try {
            return context.getAssets().list(str);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.eRelease(TAG, "getAssetsFiles, Failed to get asset file list.\n" + Log.getStackTraceString(e));
            return null;
        }
    }

    public static boolean isAssetsFilesExist(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "";
        try {
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf >= 0) {
                str2 = str.substring(0, lastIndexOf);
                str = str.substring(lastIndexOf + 1);
            }
            for (String equals : context.getAssets().list(str2)) {
                if (TextUtils.equals(equals, str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.m13410e(TAG, "childs =  发生了exception " + Log.getStackTraceString(e));
            return true;
        }
    }
}
