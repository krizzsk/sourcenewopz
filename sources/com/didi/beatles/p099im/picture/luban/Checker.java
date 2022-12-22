package com.didi.beatles.p099im.picture.luban;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.didi.beatles.im.picture.luban.Checker */
enum Checker {
    SINGLE;
    
    private static final String JPG = ".jpg";
    private static final String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE;

    /* access modifiers changed from: package-private */
    public boolean isJPG(InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    /* access modifiers changed from: package-private */
    public int getOrientation(InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0070, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0071, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0072, code lost:
        if (r5 <= 8) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0074, code lost:
        r4 = pack(r1, r3, 4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007b, code lost:
        if (r4 == 1229531648) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0080, code lost:
        if (r4 == 1296891946) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0082, code lost:
        com.didi.sdk.apm.SystemUtils.log(6, TAG, "Invalid byte order", (java.lang.Throwable) null, "com.didi.beatles.im.picture.luban.Checker", 103);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008f, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0090, code lost:
        if (r4 != 1229531648) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0092, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0094, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0095, code lost:
        r6 = pack(r1, r3 + 4, 4, r4) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009e, code lost:
        if (r6 < 10) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a0, code lost:
        if (r6 <= r5) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a3, code lost:
        r3 = r3 + r6;
        r5 = r5 - r6;
        r6 = pack(r1, r3 - 2, 2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ab, code lost:
        r10 = r6 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ad, code lost:
        if (r6 <= 0) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b1, code lost:
        if (r5 < 12) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b9, code lost:
        if (pack(r1, r3, 2, r4) != 274) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bb, code lost:
        r1 = pack(r1, r3 + 8, 2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c0, code lost:
        if (r1 == 1) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c3, code lost:
        if (r1 == 3) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c6, code lost:
        if (r1 == 6) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c8, code lost:
        if (r1 == 8) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ca, code lost:
        com.didi.sdk.apm.SystemUtils.log(6, TAG, "Unsupported orientation", (java.lang.Throwable) null, "com.didi.beatles.im.picture.luban.Checker", 134);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d7, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d8, code lost:
        return 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00db, code lost:
        return 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00de, code lost:
        return 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e1, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e2, code lost:
        r3 = r3 + 12;
        r5 = r5 - 12;
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e8, code lost:
        com.didi.sdk.apm.SystemUtils.log(6, TAG, "Invalid offset", (java.lang.Throwable) null, "com.didi.beatles.im.picture.luban.Checker", 111);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f5, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f6, code lost:
        com.didi.sdk.apm.SystemUtils.log(6, TAG, "Orientation not found", (java.lang.Throwable) null, "com.didi.beatles.im.picture.luban.Checker", 142);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0103, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getOrientation(byte[] r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            r3 = 0
        L_0x0009:
            int r4 = r3 + 3
            int r5 = r1.length
            r6 = 4
            r7 = 1
            r8 = 8
            r9 = 2
            if (r4 >= r5) goto L_0x0071
            int r4 = r3 + 1
            byte r3 = r1[r3]
            r5 = 255(0xff, float:3.57E-43)
            r3 = r3 & r5
            if (r3 != r5) goto L_0x0070
            byte r3 = r1[r4]
            r3 = r3 & r5
            if (r3 != r5) goto L_0x0022
            goto L_0x006e
        L_0x0022:
            int r4 = r4 + 1
            r5 = 216(0xd8, float:3.03E-43)
            if (r3 == r5) goto L_0x006e
            if (r3 != r7) goto L_0x002b
            goto L_0x006e
        L_0x002b:
            r5 = 217(0xd9, float:3.04E-43)
            if (r3 == r5) goto L_0x0070
            r5 = 218(0xda, float:3.05E-43)
            if (r3 != r5) goto L_0x0034
            goto L_0x0070
        L_0x0034:
            int r5 = r0.pack(r1, r4, r9, r2)
            if (r5 < r9) goto L_0x0060
            int r10 = r4 + r5
            int r11 = r1.length
            if (r10 <= r11) goto L_0x0040
            goto L_0x0060
        L_0x0040:
            r11 = 225(0xe1, float:3.15E-43)
            if (r3 != r11) goto L_0x005e
            if (r5 < r8) goto L_0x005e
            int r3 = r4 + 2
            int r3 = r0.pack(r1, r3, r6, r2)
            r11 = 1165519206(0x45786966, float:3974.5874)
            if (r3 != r11) goto L_0x005e
            int r3 = r4 + 6
            int r3 = r0.pack(r1, r3, r9, r2)
            if (r3 != 0) goto L_0x005e
            int r3 = r4 + 8
            int r5 = r5 + -8
            goto L_0x0072
        L_0x005e:
            r3 = r10
            goto L_0x0009
        L_0x0060:
            r10 = 6
            r13 = 0
            r15 = 80
            java.lang.String r11 = "Luban"
            java.lang.String r12 = "Invalid length"
            java.lang.String r14 = "com.didi.beatles.im.picture.luban.Checker"
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)
            return r2
        L_0x006e:
            r3 = r4
            goto L_0x0009
        L_0x0070:
            r3 = r4
        L_0x0071:
            r5 = 0
        L_0x0072:
            if (r5 <= r8) goto L_0x00f6
            int r4 = r0.pack(r1, r3, r6, r2)
            r10 = 1229531648(0x49492a00, float:823968.0)
            if (r4 == r10) goto L_0x0090
            r11 = 1296891946(0x4d4d002a, float:2.14958752E8)
            if (r4 == r11) goto L_0x0090
            r12 = 6
            r15 = 0
            r17 = 103(0x67, float:1.44E-43)
            java.lang.String r13 = "Luban"
            java.lang.String r14 = "Invalid byte order"
            java.lang.String r16 = "com.didi.beatles.im.picture.luban.Checker"
            com.didi.sdk.apm.SystemUtils.log(r12, r13, r14, r15, r16, r17)
            return r2
        L_0x0090:
            if (r4 != r10) goto L_0x0094
            r4 = 1
            goto L_0x0095
        L_0x0094:
            r4 = 0
        L_0x0095:
            int r10 = r3 + 4
            int r6 = r0.pack(r1, r10, r6, r4)
            int r6 = r6 + r9
            r10 = 10
            if (r6 < r10) goto L_0x00e8
            if (r6 <= r5) goto L_0x00a3
            goto L_0x00e8
        L_0x00a3:
            int r3 = r3 + r6
            int r5 = r5 - r6
            int r6 = r3 + -2
            int r6 = r0.pack(r1, r6, r9, r4)
        L_0x00ab:
            int r10 = r6 + -1
            if (r6 <= 0) goto L_0x00f6
            r6 = 12
            if (r5 < r6) goto L_0x00f6
            int r6 = r0.pack(r1, r3, r9, r4)
            r11 = 274(0x112, float:3.84E-43)
            if (r6 != r11) goto L_0x00e2
            int r3 = r3 + r8
            int r1 = r0.pack(r1, r3, r9, r4)
            if (r1 == r7) goto L_0x00e1
            r3 = 3
            if (r1 == r3) goto L_0x00de
            r3 = 6
            if (r1 == r3) goto L_0x00db
            if (r1 == r8) goto L_0x00d8
            r9 = 6
            r12 = 0
            r14 = 134(0x86, float:1.88E-43)
            java.lang.String r10 = "Luban"
            java.lang.String r11 = "Unsupported orientation"
            java.lang.String r13 = "com.didi.beatles.im.picture.luban.Checker"
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)
            return r2
        L_0x00d8:
            r1 = 270(0x10e, float:3.78E-43)
            return r1
        L_0x00db:
            r1 = 90
            return r1
        L_0x00de:
            r1 = 180(0xb4, float:2.52E-43)
            return r1
        L_0x00e1:
            return r2
        L_0x00e2:
            int r3 = r3 + 12
            int r5 = r5 + -12
            r6 = r10
            goto L_0x00ab
        L_0x00e8:
            r11 = 6
            r14 = 0
            r16 = 111(0x6f, float:1.56E-43)
            java.lang.String r12 = "Luban"
            java.lang.String r13 = "Invalid offset"
            java.lang.String r15 = "com.didi.beatles.im.picture.luban.Checker"
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)
            return r2
        L_0x00f6:
            r3 = 6
            r6 = 0
            r8 = 142(0x8e, float:1.99E-43)
            java.lang.String r4 = "Luban"
            java.lang.String r5 = "Orientation not found"
            java.lang.String r7 = "com.didi.beatles.im.picture.luban.Checker"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.picture.luban.Checker.getOrientation(byte[]):int");
    }

    /* access modifiers changed from: package-private */
    public String extSuffix(InputStreamProvider inputStreamProvider) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamProvider.open(), (Rect) null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return JPG;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean needCompress(Context context, int i, String str) {
        if (i <= 0) {
            return true;
        }
        if (IMPictureFileUtils.isFileExists(context, str)) {
            if (Build.VERSION.SDK_INT > 28 && IMPictureFileUtils.isImageUriFormat(str)) {
                try {
                    InputStream openInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
                    if (openInputStream == null || openInputStream.available() <= (i << 10)) {
                        return false;
                    }
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            } else if (new File(str).length() > ((long) (i << 10))) {
                return true;
            } else {
                return false;
            }
        } else if (new File(str).length() > ((long) (i << 10))) {
            return true;
        } else {
            return false;
        }
    }

    private int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        byte b = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return b;
            }
            b = (bArr[i] & 255) | (b << 8);
            i += i3;
            i2 = i4;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        return new byte[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] toByteArray(java.io.InputStream r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0006
            byte[] r7 = new byte[r0]
            return r7
        L_0x0006:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r2]
        L_0x000f:
            int r4 = r7.read(r3, r0, r2)     // Catch:{ Exception -> 0x0024 }
            r5 = -1
            if (r4 == r5) goto L_0x001a
            r1.write(r3, r0, r4)     // Catch:{ Exception -> 0x0024 }
            goto L_0x000f
        L_0x001a:
            r1.close()     // Catch:{ IOException -> 0x001d }
        L_0x001d:
            byte[] r7 = r1.toByteArray()
            return r7
        L_0x0022:
            r7 = move-exception
            goto L_0x002a
        L_0x0024:
            byte[] r7 = new byte[r0]     // Catch:{ all -> 0x0022 }
            r1.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            return r7
        L_0x002a:
            r1.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.picture.luban.Checker.toByteArray(java.io.InputStream):byte[]");
    }
}
