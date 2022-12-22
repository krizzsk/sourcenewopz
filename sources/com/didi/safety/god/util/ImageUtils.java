package com.didi.safety.god.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Environment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.FileUtil;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ImageUtils {
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    /* renamed from: a */
    static int m24574a(byte b) {
        return (((b >> 4) & 15) * 16) + (b & Ascii.f53593SI);
    }

    public static void saveData(byte[] bArr) {
    }

    public static void saveImageData(byte[] bArr, int i, int i2, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 80, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(byteArray);
                FileUtil.closeSilently(fileOutputStream2);
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    FileUtil.closeSilently(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    FileUtil.closeSilently(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                FileUtil.closeSilently(fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            FileUtil.closeSilently(fileOutputStream);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveScreenShotData(byte[] r14, int r15, int r16, float r17, java.io.File r18) {
        /*
            r1 = 0
            android.graphics.YuvImage r0 = new android.graphics.YuvImage     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            r4 = 17
            r7 = 0
            r2 = r0
            r3 = r14
            r5 = r15
            r6 = r16
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            r2.<init>()     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            int r4 = r0.getWidth()     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            int r5 = r0.getHeight()     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            r6 = 0
            r3.<init>(r6, r6, r4, r5)     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            r4 = 100
            r0.compressToJpeg(r3, r4, r2)     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            byte[] r0 = r2.toByteArray()     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            int r2 = r0.length     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeByteArray(r0, r6, r2)     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            android.graphics.Matrix r12 = new android.graphics.Matrix     // Catch:{ Exception -> 0x00ce, all -> 0x00cb }
            r12.<init>()     // Catch:{ Exception -> 0x00ce, all -> 0x00cb }
            r0 = r17
            r12.postScale(r0, r0)     // Catch:{ Exception -> 0x00ce, all -> 0x00cb }
            r8 = 0
            r9 = 0
            r13 = 1
            r7 = r2
            r10 = r15
            r11 = r16
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x00ce, all -> 0x00cb }
            if (r2 == 0) goto L_0x00b6
            if (r3 != 0) goto L_0x004a
            goto L_0x00b6
        L_0x004a:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00c9 }
            r0.<init>()     // Catch:{ Exception -> 0x00c9 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00c9 }
            r5 = 80
            r3.compress(r4, r5, r0)     // Catch:{ Exception -> 0x00c9 }
            byte[] r0 = r0.toByteArray()     // Catch:{ Exception -> 0x00c9 }
            java.io.File r4 = r18.getParentFile()     // Catch:{ Exception -> 0x00c9 }
            if (r4 == 0) goto L_0x0069
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x00c9 }
            if (r5 != 0) goto L_0x0069
            r4.mkdirs()     // Catch:{ Exception -> 0x00c9 }
        L_0x0069:
            boolean r4 = r18.exists()     // Catch:{ Exception -> 0x00c9 }
            if (r4 == 0) goto L_0x0074
            boolean r4 = r18.delete()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            boolean r5 = r18.exists()     // Catch:{ Exception -> 0x00c9 }
            if (r5 != 0) goto L_0x007f
            boolean r6 = r18.createNewFile()     // Catch:{ Exception -> 0x00c9 }
        L_0x007f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c9 }
            r5.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r7 = "ImageUtils deleteFile status"
            r5.append(r7)     // Catch:{ Exception -> 0x00c9 }
            r5.append(r4)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r4 = " create new file status "
            r5.append(r4)     // Catch:{ Exception -> 0x00c9 }
            r5.append(r6)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00c9 }
            com.didi.safety.god.util.LogUtils.m24584i(r4)     // Catch:{ Exception -> 0x00c9 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c9 }
            r5 = r18
            r4.<init>(r5)     // Catch:{ Exception -> 0x00c9 }
            r4.write(r0)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            com.didi.sdk.util.FileUtil.closeSilently(r4)
            if (r3 == 0) goto L_0x00ad
            r3.recycle()
        L_0x00ad:
            if (r2 == 0) goto L_0x0103
            goto L_0x0100
        L_0x00b0:
            r0 = move-exception
            r1 = r4
            goto L_0x0105
        L_0x00b3:
            r0 = move-exception
            r1 = r4
            goto L_0x00d8
        L_0x00b6:
            java.lang.String r0 = "scaleBitmap is NULL !!!!!!!!"
            com.didi.safety.god.util.LogUtils.m24580e(r0)     // Catch:{ Exception -> 0x00c9 }
            com.didi.sdk.util.FileUtil.closeSilently(r1)
            if (r3 == 0) goto L_0x00c3
            r3.recycle()
        L_0x00c3:
            if (r2 == 0) goto L_0x00c8
            r2.recycle()
        L_0x00c8:
            return
        L_0x00c9:
            r0 = move-exception
            goto L_0x00d8
        L_0x00cb:
            r0 = move-exception
            r3 = r1
            goto L_0x0105
        L_0x00ce:
            r0 = move-exception
            r3 = r1
            goto L_0x00d8
        L_0x00d1:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x0105
        L_0x00d5:
            r0 = move-exception
            r2 = r1
            r3 = r2
        L_0x00d8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r4.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = "ImageUtils saveScreenPic failed exception is"
            r4.append(r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = r0.getMessage()     // Catch:{ all -> 0x0104 }
            r4.append(r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0104 }
            com.didi.safety.god.util.LogUtils.m24580e(r4)     // Catch:{ all -> 0x0104 }
            r0.printStackTrace()     // Catch:{ all -> 0x0104 }
            com.didi.safety.god.util.LogUtils.logStackTrace(r0)     // Catch:{ all -> 0x0104 }
            com.didi.sdk.util.FileUtil.closeSilently(r1)
            if (r3 == 0) goto L_0x00fe
            r3.recycle()
        L_0x00fe:
            if (r2 == 0) goto L_0x0103
        L_0x0100:
            r2.recycle()
        L_0x0103:
            return
        L_0x0104:
            r0 = move-exception
        L_0x0105:
            com.didi.sdk.util.FileUtil.closeSilently(r1)
            if (r3 == 0) goto L_0x010d
            r3.recycle()
        L_0x010d:
            if (r2 == 0) goto L_0x0112
            r2.recycle()
        L_0x0112:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.util.ImageUtils.saveScreenShotData(byte[], int, int, float, java.io.File):void");
    }

    public static byte[] rotateYUV420Degree90(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            for (int i7 = i2 - 1; i7 >= 0; i7--) {
                bArr2[i5] = bArr[(i7 * i) + i6];
                i5++;
            }
        }
        int i8 = i4 - 1;
        for (int i9 = i - 1; i9 > 0; i9 -= 2) {
            for (int i10 = 0; i10 < i2 / 2; i10++) {
                int i11 = (i10 * i) + i3;
                bArr2[i8] = bArr[i11 + i9];
                int i12 = i8 - 1;
                bArr2[i12] = bArr[i11 + (i9 - 1)];
                i8 = i12 - 1;
            }
        }
        return bArr2;
    }

    /* renamed from: b */
    private static byte[] m24577b(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            bArr2[i5] = bArr[i6];
            i5++;
        }
        for (int i7 = i4 - 1; i7 >= i3; i7 -= 2) {
            int i8 = i5 + 1;
            bArr2[i5] = bArr[i7 - 1];
            i5 = i8 + 1;
            bArr2[i8] = bArr[i7];
        }
        return bArr2;
    }

    /* renamed from: a */
    static Bitmap m24575a(byte[] bArr, int i, int i2) {
        int[] a = m24576a(bArr);
        if (a == null) {
            return null;
        }
        return Bitmap.createBitmap(a, 0, i, i, i2, Bitmap.Config.ARGB_8888);
    }

    /* renamed from: a */
    static int[] m24576a(byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = length % 4 != 0 ? 1 : 0;
        SystemUtils.log(4, "data.length", String.valueOf(length), (Throwable) null, "com.didi.safety.god.util.ImageUtils", 173);
        SystemUtils.log(4, "arg:", String.valueOf(i3), (Throwable) null, "com.didi.safety.god.util.ImageUtils", 174);
        int i4 = (length / 4) + i3;
        int[] iArr = new int[i4];
        SystemUtils.log(4, "colorLen", String.valueOf(i4), (Throwable) null, "com.didi.safety.god.util.ImageUtils", 180);
        if (i3 == 0) {
            boolean z = true;
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 4;
                int a = m24574a(bArr2[i6 + 3]);
                int a2 = m24574a(bArr2[i6 + 2]);
                int a3 = m24574a(bArr2[i6 + 1]);
                if (a == 0 && a2 == 0 && a3 == 0 && z) {
                    SystemUtils.log(4, "color = 0", String.valueOf(i5), (Throwable) null, "com.didi.safety.god.util.ImageUtils", 188);
                    z = false;
                }
                iArr[i5] = a3 | (a << 16) | (a2 << 8) | -16777216;
            }
        } else {
            while (true) {
                i = i4 - 1;
                if (i2 >= i) {
                    break;
                }
                int i7 = i2 * 3;
                iArr[i2] = m24574a(bArr2[i7 + 2]) | (m24574a(bArr2[i7]) << 16) | (m24574a(bArr2[i7 + 1]) << 8) | -16777216;
                i2++;
            }
            iArr[i] = -16777216;
        }
        return iArr;
    }

    public static File getCacheDir(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return context.getExternalFilesDir("");
        }
        return context.getCacheDir();
    }

    public static File getVideoCacheDir(Context context) {
        return context.getCacheDir();
    }
}
