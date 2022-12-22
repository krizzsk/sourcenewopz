package com.didi.one.netdetect.util;

import com.google.common.base.Ascii;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class IOUtil {
    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(java.io.InputStream r3, java.io.OutputStream r4) throws java.io.IOException {
        /*
            r0 = 512(0x200, float:7.175E-43)
            byte[] r0 = new byte[r0]
        L_0x0004:
            int r1 = r3.read(r0)     // Catch:{ all -> 0x0017 }
            r2 = -1
            if (r1 == r2) goto L_0x0010
            r2 = 0
            r4.write(r0, r2, r1)     // Catch:{ all -> 0x0017 }
            goto L_0x0004
        L_0x0010:
            r3.close()     // Catch:{ IOException -> 0x0013 }
        L_0x0013:
            r4.close()     // Catch:{ IOException -> 0x0016 }
        L_0x0016:
            return
        L_0x0017:
            r0 = move-exception
            r3.close()     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            r4.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.one.netdetect.util.IOUtil.copy(java.io.InputStream, java.io.OutputStream):void");
    }

    public static String md5Encode(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                stringBuffer.append(Character.forDigit(digest[i] & Ascii.f53593SI, 16));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static File createPath(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void save(java.io.File r3, java.lang.String r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0020 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0020 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0020 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0020 }
            java.lang.String r3 = "UTF-8"
            byte[] r3 = r4.getBytes(r3)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r1.write(r3)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r1.close()
            goto L_0x0029
        L_0x0018:
            r3 = move-exception
            r0 = r1
            goto L_0x002a
        L_0x001b:
            r3 = move-exception
            r0 = r1
            goto L_0x0021
        L_0x001e:
            r3 = move-exception
            goto L_0x002a
        L_0x0020:
            r3 = move-exception
        L_0x0021:
            r3.printStackTrace()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0029
            r0.close()
        L_0x0029:
            return
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()
        L_0x002f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.one.netdetect.util.IOUtil.save(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String read(java.io.File r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            r1.<init>(r4)     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            int r4 = r1.available()     // Catch:{ IOException -> 0x001b }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x001b }
            r1.read(r4)     // Catch:{ IOException -> 0x001b }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x001b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r4, r3)     // Catch:{ IOException -> 0x001b }
            r1.close()
            r0 = r2
            goto L_0x0029
        L_0x001b:
            r4 = move-exception
            goto L_0x0021
        L_0x001d:
            r4 = move-exception
            goto L_0x002c
        L_0x001f:
            r4 = move-exception
            r1 = r0
        L_0x0021:
            r4.printStackTrace()     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0029
            r1.close()
        L_0x0029:
            return r0
        L_0x002a:
            r4 = move-exception
            r0 = r1
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()
        L_0x0031:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.one.netdetect.util.IOUtil.read(java.io.File):java.lang.String");
    }
}
