package com.didi.safety.god.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class BitmapUtils {

    /* renamed from: a */
    private static final int f34807a = 1024;

    public static byte[] compressJpgData(byte[] bArr) {
        return compressJpgData(bArr, 100);
    }

    public static byte[] compressJpgData(byte[] bArr, int i) {
        LogUtils.m24578d("before compress raw jpg size is: " + (bArr.length / 1024) + "KB");
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[0];
        int i2 = 105;
        while (i2 > 40) {
            i2 -= 5;
            byteArrayOutputStream.reset();
            decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            bArr2 = byteArrayOutputStream.toByteArray();
            int length = bArr2.length / 1024;
            LogUtils.m24578d("compressed size ===" + length + "KB, quality=" + i2);
            if (length <= i) {
                break;
            }
        }
        LogUtils.m24578d("after compress pic size is: " + (bArr2.length / 1024) + "KB, quality=" + i2);
        decodeByteArray.recycle();
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void compressSaveBitmap(android.graphics.Bitmap r10, java.io.File r11, int r12) {
        /*
            r0 = 100
            r1 = 0
        L_0x0004:
            r3 = 40
            if (r0 > r3) goto L_0x0009
            goto L_0x004e
        L_0x0009:
            int r0 = r0 + -5
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r4.<init>(r11)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x003b }
            r10.compress(r3, r0, r4)     // Catch:{ Exception -> 0x003b }
            long r5 = r11.length()     // Catch:{ Exception -> 0x003b }
            r7 = 1024(0x400, double:5.06E-321)
            long r1 = r5 / r7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003b }
            r3.<init>()     // Catch:{ Exception -> 0x003b }
            java.lang.String r5 = "compressed size===="
            r3.append(r5)     // Catch:{ Exception -> 0x003b }
            r3.append(r1)     // Catch:{ Exception -> 0x003b }
            java.lang.String r5 = "KB, quality="
            r3.append(r5)     // Catch:{ Exception -> 0x003b }
            r3.append(r0)     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x003b }
            com.didi.safety.god.util.LogUtils.m24578d(r3)     // Catch:{ Exception -> 0x003b }
            goto L_0x0046
        L_0x003b:
            r3 = move-exception
            goto L_0x0043
        L_0x003d:
            r10 = move-exception
            goto L_0x0051
        L_0x003f:
            r4 = move-exception
            r9 = r4
            r4 = r3
            r3 = r9
        L_0x0043:
            com.didi.safety.god.util.LogUtils.logStackTrace(r3)     // Catch:{ all -> 0x004f }
        L_0x0046:
            com.didi.safety.god.util.FileUtils.closeQuietly(r4)
            long r3 = (long) r12
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0004
        L_0x004e:
            return
        L_0x004f:
            r10 = move-exception
            r3 = r4
        L_0x0051:
            com.didi.safety.god.util.FileUtils.closeQuietly(r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.util.BitmapUtils.compressSaveBitmap(android.graphics.Bitmap, java.io.File, int):void");
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        return rotateBitmap(bitmap, true, i);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, boolean z, int i) {
        CheckUtils.checkAssert(!bitmap.isRecycled(), "source bitmap has recycled!!!");
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static byte[] toBytes(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        LogUtils.m24578d("inSampleSize===" + i5);
        return i5;
    }

    public static int calculateInSampleSize2(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        LogUtils.m24578d("raw img w===" + i4 + ", h=" + i5);
        if (i5 > i2 || i4 > i) {
            i3 = Math.round(((float) i5) / ((float) i2));
            int round = Math.round(((float) i4) / ((float) i));
            if (i3 >= round) {
                i3 = round;
            }
        } else {
            i3 = 1;
        }
        LogUtils.m24578d("inSampleSize2===" + i3);
        return i3;
    }
}
