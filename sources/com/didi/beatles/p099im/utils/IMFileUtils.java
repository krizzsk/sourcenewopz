package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p099im.IMContextInfoHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.didi.beatles.im.utils.IMFileUtils */
public class IMFileUtils {
    public static String getAppPath() {
        if (IMContextInfoHelper.getContext() == null) {
            return "";
        }
        return IMContextInfoHelper.getContext().getFilesDir().getAbsolutePath() + File.separator;
    }

    public static boolean createFileDir(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0052 A[SYNTHETIC, Splitter:B:34:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005c A[SYNTHETIC, Splitter:B:39:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0068 A[SYNTHETIC, Splitter:B:45:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0072 A[SYNTHETIC, Splitter:B:50:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToFile(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            if (r3 == 0) goto L_0x007b
            if (r4 == 0) goto L_0x007b
            if (r5 != 0) goto L_0x0008
            goto L_0x007b
        L_0x0008:
            boolean r0 = createFileDir(r3)
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            r2.<init>()     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            r2.append(r3)     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            r2.append(r4)     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            java.lang.String r3 = r2.toString()     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            r4 = 1
            r1.<init>(r3, r4)     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r3.write(r5)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r3.flush()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0038:
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x003c:
            r4 = move-exception
            goto L_0x0042
        L_0x003e:
            r4 = move-exception
            goto L_0x0046
        L_0x0040:
            r4 = move-exception
            r3 = r0
        L_0x0042:
            r0 = r1
            goto L_0x0066
        L_0x0044:
            r4 = move-exception
            r3 = r0
        L_0x0046:
            r0 = r1
            goto L_0x004d
        L_0x0048:
            r4 = move-exception
            r3 = r0
            goto L_0x0066
        L_0x004b:
            r4 = move-exception
            r3 = r0
        L_0x004d:
            r4.printStackTrace()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x005a
            r0.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005a:
            if (r3 == 0) goto L_0x0064
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0064:
            return
        L_0x0065:
            r4 = move-exception
        L_0x0066:
            if (r0 == 0) goto L_0x0070
            r0.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0070:
            if (r3 == 0) goto L_0x007a
            r3.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r3 = move-exception
            r3.printStackTrace()
        L_0x007a:
            throw r4
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.utils.IMFileUtils.writeToFile(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static boolean fileIsExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (new File(str).exists()) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static String getInstallId(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("imInstall");
            byte[] bArr = new byte[openFileInput.available()];
            openFileInput.read(bArr);
            openFileInput.close();
            return new String(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                FileOutputStream openFileOutput = context.openFileOutput("imInstall", 0);
                openFileOutput.write(UUID.randomUUID().toString().getBytes());
                openFileOutput.flush();
                openFileOutput.close();
                return getInstallId(context);
            } catch (IOException e2) {
                e2.printStackTrace();
                return IMEncryptionUtil.encrypt("im");
            }
        }
    }
}
