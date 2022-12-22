package com.didi.onekeyshare.util;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class DownloadImageUtil {

    public interface DownLoadImageCallback {
        void onFail();

        void onSuccess(String str, String str2);
    }

    public static void downloadImage(Context context, final String str, final DownLoadImageCallback downLoadImageCallback) {
        String a = m20898a(str);
        File cacheDir = getCacheDir(context);
        final File file = new File(cacheDir, a + ".jpg");
        if (!file.exists() || downLoadImageCallback == null) {
            new AsyncTask<String, Void, String>() {
                /* access modifiers changed from: protected */
                /* JADX WARNING: Removed duplicated region for block: B:38:0x0069 A[SYNTHETIC, Splitter:B:38:0x0069] */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x0071 A[Catch:{ IOException -> 0x006d }] */
                /* JADX WARNING: Removed duplicated region for block: B:49:0x007e A[SYNTHETIC, Splitter:B:49:0x007e] */
                /* JADX WARNING: Removed duplicated region for block: B:54:0x0086 A[Catch:{ IOException -> 0x0082 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.String doInBackground(java.lang.String... r8) {
                    /*
                        r7 = this;
                        r0 = 0
                        java.io.File r1 = r1     // Catch:{ Exception -> 0x0061, all -> 0x005e }
                        boolean r1 = r1.exists()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
                        if (r1 != 0) goto L_0x000e
                        java.io.File r1 = r1     // Catch:{ Exception -> 0x0061, all -> 0x005e }
                        r1.createNewFile()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
                    L_0x000e:
                        java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0061, all -> 0x005e }
                        r2 = 0
                        r8 = r8[r2]     // Catch:{ Exception -> 0x0061, all -> 0x005e }
                        r1.<init>(r8)     // Catch:{ Exception -> 0x0061, all -> 0x005e }
                        java.io.InputStream r8 = r1.openStream()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
                        java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0058, all -> 0x0052 }
                        java.io.File r3 = r1     // Catch:{ Exception -> 0x0058, all -> 0x0052 }
                        r1.<init>(r3)     // Catch:{ Exception -> 0x0058, all -> 0x0052 }
                        r3 = 204800(0x32000, float:2.86986E-40)
                        byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x004c, all -> 0x0047 }
                    L_0x0026:
                        int r4 = r8.read(r3)     // Catch:{ Exception -> 0x004c, all -> 0x0047 }
                        r5 = -1
                        if (r4 == r5) goto L_0x0031
                        r1.write(r3, r2, r4)     // Catch:{ Exception -> 0x004c, all -> 0x0047 }
                        goto L_0x0026
                    L_0x0031:
                        java.io.File r2 = r1     // Catch:{ Exception -> 0x004c, all -> 0x0047 }
                        java.lang.String r0 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x004c, all -> 0x0047 }
                        if (r8 == 0) goto L_0x003f
                        r8.close()     // Catch:{ IOException -> 0x003d }
                        goto L_0x003f
                    L_0x003d:
                        r8 = move-exception
                        goto L_0x0043
                    L_0x003f:
                        r1.close()     // Catch:{ IOException -> 0x003d }
                        goto L_0x0046
                    L_0x0043:
                        r8.printStackTrace()
                    L_0x0046:
                        return r0
                    L_0x0047:
                        r0 = move-exception
                        r6 = r0
                        r0 = r8
                        r8 = r6
                        goto L_0x007c
                    L_0x004c:
                        r2 = move-exception
                        r6 = r1
                        r1 = r8
                        r8 = r2
                        r2 = r6
                        goto L_0x0064
                    L_0x0052:
                        r1 = move-exception
                        r6 = r0
                        r0 = r8
                        r8 = r1
                        r1 = r6
                        goto L_0x007c
                    L_0x0058:
                        r1 = move-exception
                        r2 = r0
                        r6 = r1
                        r1 = r8
                        r8 = r6
                        goto L_0x0064
                    L_0x005e:
                        r8 = move-exception
                        r1 = r0
                        goto L_0x007c
                    L_0x0061:
                        r8 = move-exception
                        r1 = r0
                        r2 = r1
                    L_0x0064:
                        r8.printStackTrace()     // Catch:{ all -> 0x0079 }
                        if (r1 == 0) goto L_0x006f
                        r1.close()     // Catch:{ IOException -> 0x006d }
                        goto L_0x006f
                    L_0x006d:
                        r8 = move-exception
                        goto L_0x0075
                    L_0x006f:
                        if (r2 == 0) goto L_0x0078
                        r2.close()     // Catch:{ IOException -> 0x006d }
                        goto L_0x0078
                    L_0x0075:
                        r8.printStackTrace()
                    L_0x0078:
                        return r0
                    L_0x0079:
                        r8 = move-exception
                        r0 = r1
                        r1 = r2
                    L_0x007c:
                        if (r0 == 0) goto L_0x0084
                        r0.close()     // Catch:{ IOException -> 0x0082 }
                        goto L_0x0084
                    L_0x0082:
                        r0 = move-exception
                        goto L_0x008a
                    L_0x0084:
                        if (r1 == 0) goto L_0x008d
                        r1.close()     // Catch:{ IOException -> 0x0082 }
                        goto L_0x008d
                    L_0x008a:
                        r0.printStackTrace()
                    L_0x008d:
                        throw r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.onekeyshare.util.DownloadImageUtil.C104281.doInBackground(java.lang.String[]):java.lang.String");
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(String str) {
                    if (downLoadImageCallback == null) {
                        return;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        downLoadImageCallback.onSuccess(str, str);
                    } else {
                        downLoadImageCallback.onFail();
                    }
                }
            }.execute(new String[]{str});
            return;
        }
        downLoadImageCallback.onSuccess(str, file.getAbsolutePath());
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

    /* renamed from: a */
    private static String m20898a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
