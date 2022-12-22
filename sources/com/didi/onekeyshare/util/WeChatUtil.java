package com.didi.onekeyshare.util;

import android.graphics.Bitmap;
import com.didi.sdk.apm.SystemUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeChatUtil {

    /* renamed from: a */
    private static final String f29778a = "SDK_Sample.Util";

    /* renamed from: b */
    private static final int f29779b = 2764800;

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    public static byte[] getHtmlByteArray(String str) {
        InputStream inputStream = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return inputStreamToByte(inputStream);
    }

    public static byte[] inputStreamToByte(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] readFromFile(String str, int i, int i2) {
        byte[] bArr = null;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            SystemUtils.log(4, f29778a, "readFromFile: file not found", (Throwable) null, "com.didi.onekeyshare.util.WeChatUtil", 87);
            return null;
        }
        if (i2 == -1) {
            i2 = (int) file.length();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("readFromFile : offset = ");
        sb.append(i);
        sb.append(" len = ");
        sb.append(i2);
        sb.append(" offset + len = ");
        int i3 = i + i2;
        sb.append(i3);
        SystemUtils.log(3, f29778a, sb.toString(), (Throwable) null, "com.didi.onekeyshare.util.WeChatUtil", 95);
        if (i < 0) {
            SystemUtils.log(6, f29778a, "readFromFile invalid offset:" + i, (Throwable) null, "com.didi.onekeyshare.util.WeChatUtil", 98);
            return null;
        } else if (i2 <= 0) {
            SystemUtils.log(6, f29778a, "readFromFile invalid len:" + i2, (Throwable) null, "com.didi.onekeyshare.util.WeChatUtil", 102);
            return null;
        } else if (i3 > ((int) file.length())) {
            SystemUtils.log(6, f29778a, "readFromFile invalid file len:" + file.length(), (Throwable) null, "com.didi.onekeyshare.util.WeChatUtil", 106);
            return null;
        } else {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                bArr = new byte[i2];
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                return bArr;
            } catch (Exception e) {
                SystemUtils.log(6, f29778a, "readFromFile : errMsg = " + e.getMessage(), (Throwable) null, "com.didi.onekeyshare.util.WeChatUtil", 119);
                e.printStackTrace();
                return bArr;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0084, code lost:
        if (r8 < r14) goto L_0x0086;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0091 A[Catch:{ OutOfMemoryError -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a1 A[Catch:{ OutOfMemoryError -> 0x01bc }, LOOP:0: B:17:0x0093->B:19:0x00a1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00aa A[Catch:{ OutOfMemoryError -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c9 A[Catch:{ OutOfMemoryError -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0132 A[Catch:{ OutOfMemoryError -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0141 A[Catch:{ OutOfMemoryError -> 0x01bc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap extractThumbNail(java.lang.String r22, int r23, int r24, boolean r25) {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "x"
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options
            r5.<init>()
            r7 = 1
            r5.inJustDecodeBounds = r7     // Catch:{ OutOfMemoryError -> 0x01bc }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeFile(r0, r5)     // Catch:{ OutOfMemoryError -> 0x01bc }
            if (r8 == 0) goto L_0x001b
            r8.recycle()     // Catch:{ OutOfMemoryError -> 0x01bc }
        L_0x001b:
            java.lang.String r10 = "SDK_Sample.Util"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.<init>()     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r9 = "extractThumbNail: round="
            r8.append(r9)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r2)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r4)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r1)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r9 = ", crop="
            r8.append(r9)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r3)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r11 = r8.toString()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r9 = 3
            r12 = 0
            java.lang.String r13 = "com.didi.onekeyshare.util.WeChatUtil"
            r14 = 140(0x8c, float:1.96E-43)
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r8 = r5.outHeight     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r8 = (double) r8     // Catch:{ OutOfMemoryError -> 0x01bc }
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r8 = r8 * r10
            double r12 = (double) r1     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r8 = r8 / r12
            int r14 = r5.outWidth     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r14 = (double) r14     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r14 = r14 * r10
            double r10 = (double) r2     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r14 = r14 / r10
            java.lang.String r17 = "SDK_Sample.Util"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x01bc }
            r6.<init>()     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r7 = "extractThumbNail: extract beX = "
            r6.append(r7)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r6.append(r14)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r7 = ", beY = "
            r6.append(r7)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r6.append(r8)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r18 = r6.toString()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r16 = 3
            r19 = 0
            java.lang.String r20 = "com.didi.onekeyshare.util.WeChatUtil"
            r21 = 143(0x8f, float:2.0E-43)
            com.didi.sdk.apm.SystemUtils.log(r16, r17, r18, r19, r20, r21)     // Catch:{ OutOfMemoryError -> 0x01bc }
            if (r3 == 0) goto L_0x0082
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x0088
            goto L_0x0086
        L_0x0082:
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x0088
        L_0x0086:
            r6 = r14
            goto L_0x0089
        L_0x0088:
            r6 = r8
        L_0x0089:
            int r6 = (int) r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            r5.inSampleSize = r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r6 = r5.inSampleSize     // Catch:{ OutOfMemoryError -> 0x01bc }
            r7 = 1
            if (r6 > r7) goto L_0x0093
            r5.inSampleSize = r7     // Catch:{ OutOfMemoryError -> 0x01bc }
        L_0x0093:
            int r6 = r5.outHeight     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r7 = r5.outWidth     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r6 = r6 * r7
            int r7 = r5.inSampleSize     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r6 = r6 / r7
            r7 = 2764800(0x2a3000, float:3.87431E-39)
            if (r6 <= r7) goto L_0x00a8
            int r6 = r5.inSampleSize     // Catch:{ OutOfMemoryError -> 0x01bc }
            r7 = 1
            int r6 = r6 + r7
            r5.inSampleSize = r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            goto L_0x0093
        L_0x00a8:
            if (r3 == 0) goto L_0x00c9
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ba
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r10 = r10 * r6
            int r6 = r5.outHeight     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r6 = (double) r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r10 = r10 * r6
            int r6 = r5.outWidth     // Catch:{ OutOfMemoryError -> 0x01bc }
            goto L_0x00d8
        L_0x00ba:
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = r12 * r6
            int r6 = r5.outWidth     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r6 = (double) r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r12 = r12 * r6
            int r6 = r5.outHeight     // Catch:{ OutOfMemoryError -> 0x01bc }
        L_0x00c5:
            double r6 = (double) r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r12 = r12 / r6
            int r6 = (int) r12     // Catch:{ OutOfMemoryError -> 0x01bc }
            goto L_0x00ea
        L_0x00c9:
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x00de
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r10 = r10 * r6
            int r6 = r5.outHeight     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r6 = (double) r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r10 = r10 * r6
            int r6 = r5.outWidth     // Catch:{ OutOfMemoryError -> 0x01bc }
        L_0x00d8:
            double r6 = (double) r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r10 = r10 / r6
            int r6 = (int) r10     // Catch:{ OutOfMemoryError -> 0x01bc }
            r7 = r6
            r6 = r2
            goto L_0x00eb
        L_0x00de:
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = r12 * r6
            int r6 = r5.outWidth     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r6 = (double) r6     // Catch:{ OutOfMemoryError -> 0x01bc }
            double r12 = r12 * r6
            int r6 = r5.outHeight     // Catch:{ OutOfMemoryError -> 0x01bc }
            goto L_0x00c5
        L_0x00ea:
            r7 = r1
        L_0x00eb:
            r8 = 0
            r5.inJustDecodeBounds = r8     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r10 = "SDK_Sample.Util"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.<init>()     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r9 = "bitmap required size="
            r8.append(r9)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r6)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r4)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r7)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r9 = ", orig="
            r8.append(r9)     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r9 = r5.outWidth     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r9)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r4)     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r9 = r5.outHeight     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r9)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r9 = ", sample="
            r8.append(r9)     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r9 = r5.inSampleSize     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8.append(r9)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r11 = r8.toString()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r9 = 4
            r12 = 0
            java.lang.String r13 = "com.didi.onekeyshare.util.WeChatUtil"
            r14 = 172(0xac, float:2.41E-43)
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ OutOfMemoryError -> 0x01bc }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r5)     // Catch:{ OutOfMemoryError -> 0x01bc }
            if (r0 != 0) goto L_0x0141
            java.lang.String r9 = "SDK_Sample.Util"
            java.lang.String r10 = "bitmap decode failed"
            r8 = 6
            r11 = 0
            java.lang.String r12 = "com.didi.onekeyshare.util.WeChatUtil"
            r13 = 175(0xaf, float:2.45E-43)
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r1 = 0
            return r1
        L_0x0141:
            java.lang.String r9 = "SDK_Sample.Util"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x01bc }
            r5.<init>()     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r8 = "bitmap decoded size="
            r5.append(r8)     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r8 = r0.getWidth()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r5.append(r8)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r5.append(r4)     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r8 = r0.getHeight()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r5.append(r8)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r10 = r5.toString()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r8 = 4
            r11 = 0
            java.lang.String r12 = "com.didi.onekeyshare.util.WeChatUtil"
            r13 = 179(0xb3, float:2.51E-43)
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r5 = 1
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r0, r6, r7, r5)     // Catch:{ OutOfMemoryError -> 0x01bc }
            if (r6 == 0) goto L_0x0176
            r0.recycle()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r0 = r6
        L_0x0176:
            if (r3 == 0) goto L_0x01bb
            int r3 = r0.getWidth()     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r3 = r3 - r2
            r5 = 1
            int r3 = r3 >> r5
            int r6 = r0.getHeight()     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r6 = r6 - r1
            int r5 = r6 >> 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r0, r3, r5, r2, r1)     // Catch:{ OutOfMemoryError -> 0x01bc }
            if (r1 != 0) goto L_0x018d
            return r0
        L_0x018d:
            r0.recycle()     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r6 = "SDK_Sample.Util"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x01bc }
            r0.<init>()     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r2 = "bitmap croped size="
            r0.append(r2)     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r2 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r0.append(r2)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r0.append(r4)     // Catch:{ OutOfMemoryError -> 0x01bc }
            int r2 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r0.append(r2)     // Catch:{ OutOfMemoryError -> 0x01bc }
            java.lang.String r7 = r0.toString()     // Catch:{ OutOfMemoryError -> 0x01bc }
            r5 = 4
            r8 = 0
            java.lang.String r9 = "com.didi.onekeyshare.util.WeChatUtil"
            r10 = 194(0xc2, float:2.72E-43)
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ OutOfMemoryError -> 0x01bc }
            r0 = r1
        L_0x01bb:
            return r0
        L_0x01bc:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "decode bitmap failed: "
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r4 = r1.toString()
            r2 = 6
            r5 = 0
            r7 = 199(0xc7, float:2.79E-43)
            java.lang.String r3 = "SDK_Sample.Util"
            java.lang.String r6 = "com.didi.onekeyshare.util.WeChatUtil"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.onekeyshare.util.WeChatUtil.extractThumbNail(java.lang.String, int, int, boolean):android.graphics.Bitmap");
    }
}
