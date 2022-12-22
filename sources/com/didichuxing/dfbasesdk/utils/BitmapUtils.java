package com.didichuxing.dfbasesdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.ByteBuffer;

public class BitmapUtils {

    /* renamed from: a */
    private static final int f46693a = 1024;

    public static byte[] compressJpgData(byte[] bArr) {
        return compressJpgData(bArr, 100);
    }

    public static byte[] compressJpgData(byte[] bArr, int i) {
        LogUtils.m33563d("before compress raw jpg size is: " + (bArr.length / 1024) + "KB");
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
            LogUtils.m33563d("compressed size ===" + length + "KB, quality=" + i2);
            if (length <= i) {
                break;
            }
        }
        LogUtils.m33563d("after compress pic size is: " + (bArr2.length / 1024) + "KB, quality=" + i2);
        decodeByteArray.recycle();
        return bArr2;
    }

    public static byte[] compressJpgData(File file, int i) {
        LogUtils.m33563d("before compress raw jpg size is: " + (file.length() / 1024) + "KB");
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        int i2 = 105;
        while (i2 > 40) {
            i2 -= 5;
            byteArrayOutputStream.reset();
            decodeFile.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            int length = bArr.length / 1024;
            LogUtils.m33563d("compressed size ===" + length + "KB, quality=" + i2);
            if (length <= i) {
                break;
            }
        }
        LogUtils.m33563d("after compress pic size is: " + (bArr.length / 1024) + "KB, quality=" + i2);
        decodeFile.recycle();
        return bArr;
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
            com.didichuxing.dfbasesdk.utils.LogUtils.m33563d(r3)     // Catch:{ Exception -> 0x003b }
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
            com.didichuxing.dfbasesdk.utils.LogUtils.logStackTrace(r3)     // Catch:{ all -> 0x004f }
        L_0x0046:
            com.didichuxing.dfbasesdk.utils.IOUtils.closeQuietly(r4)
            long r3 = (long) r12
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0004
        L_0x004e:
            return
        L_0x004f:
            r10 = move-exception
            r3 = r4
        L_0x0051:
            com.didichuxing.dfbasesdk.utils.IOUtils.closeQuietly(r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.BitmapUtils.compressSaveBitmap(android.graphics.Bitmap, java.io.File, int):void");
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

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r5 != null) goto L_0x0031;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0074 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083 A[SYNTHETIC, Splitter:B:46:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008a A[SYNTHETIC, Splitter:B:50:0x008a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] setJpgUserComment(android.content.Context r5, byte[] r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0093
            int r1 = r6.length
            if (r1 > 0) goto L_0x0008
            goto L_0x0093
        L_0x0008:
            java.io.File r1 = new java.io.File
            java.io.File r5 = r5.getCacheDir()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "as_"
            r2.append(r3)
            long r3 = java.lang.System.currentTimeMillis()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r5, r2)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0039 }
            r5.<init>(r1)     // Catch:{ all -> 0x0039 }
            r5.write(r6)     // Catch:{ all -> 0x0037 }
            r5.flush()     // Catch:{ all -> 0x0037 }
        L_0x0031:
            r5.close()     // Catch:{ all -> 0x0035 }
            goto L_0x003d
        L_0x0035:
            goto L_0x003d
        L_0x0037:
            goto L_0x003a
        L_0x0039:
            r5 = r0
        L_0x003a:
            if (r5 == 0) goto L_0x003d
            goto L_0x0031
        L_0x003d:
            boolean r5 = r1.isFile()
            if (r5 == 0) goto L_0x0093
            long r5 = r1.length()
            r2 = 0
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x004e
            goto L_0x0093
        L_0x004e:
            boolean r5 = setJpgUserComment((java.io.File) r1, (java.lang.String) r7)
            if (r5 == 0) goto L_0x0090
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x007f }
            r5.<init>()     // Catch:{ all -> 0x007f }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x007d }
            r6.<init>(r1)     // Catch:{ all -> 0x007d }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x007b }
        L_0x0062:
            int r2 = r6.read(r7)     // Catch:{ all -> 0x007b }
            if (r2 <= 0) goto L_0x006d
            r3 = 0
            r5.write(r7, r3, r2)     // Catch:{ all -> 0x007b }
            goto L_0x0062
        L_0x006d:
            byte[] r7 = r5.toByteArray()     // Catch:{ all -> 0x007b }
            r5.close()     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r6.close()     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r1.delete()
            return r7
        L_0x007b:
            goto L_0x0081
        L_0x007d:
            r6 = r0
            goto L_0x0081
        L_0x007f:
            r5 = r0
            r6 = r5
        L_0x0081:
            if (r5 == 0) goto L_0x0088
            r5.close()     // Catch:{ all -> 0x0087 }
            goto L_0x0088
        L_0x0087:
        L_0x0088:
            if (r6 == 0) goto L_0x008d
            r6.close()     // Catch:{ all -> 0x008d }
        L_0x008d:
            r1.delete()
        L_0x0090:
            r1.delete()
        L_0x0093:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.BitmapUtils.setJpgUserComment(android.content.Context, byte[], java.lang.String):byte[]");
    }

    public static boolean setJpgUserComment(File file, String str) {
        try {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            exifInterface.setAttribute(ExifInterface.TAG_USER_COMMENT, str);
            exifInterface.saveAttributes();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean setJpgUserComment(String str, String str2) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            exifInterface.setAttribute(ExifInterface.TAG_USER_COMMENT, str2);
            exifInterface.saveAttributes();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getJpgUserComment(String str) {
        try {
            return new ExifInterface(str).getAttribute(ExifInterface.TAG_USER_COMMENT);
        } catch (Exception unused) {
            return null;
        }
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
        LogUtils.m33563d("inSampleSize===" + i5);
        return i5;
    }

    public static int calculateInSampleSize2(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        LogUtils.m33563d("raw img w===" + i4 + ", h=" + i5);
        if (i5 > i2 || i4 > i) {
            i3 = Math.round(((float) i5) / ((float) i2));
            int round = Math.round(((float) i4) / ((float) i));
            if (i3 >= round) {
                i3 = round;
            }
        } else {
            i3 = 1;
        }
        LogUtils.m33563d("inSampleSize2===" + i3);
        return i3;
    }
}
