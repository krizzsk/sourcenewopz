package com.didichuxing.dfbasesdk.utils;

public class PictureUtils {
    public static final int PIC_HEIGHT_DEFAULT = 720;
    public static final int PIC_WIDTH_DEFAULT = 1080;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0095 A[SYNTHETIC, Splitter:B:53:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f A[SYNTHETIC, Splitter:B:58:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00bb A[SYNTHETIC, Splitter:B:72:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00c5 A[SYNTHETIC, Splitter:B:77:0x00c5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File savePic(android.content.Context r7, byte[] r8, int r9, java.io.File r10) {
        /*
            r7 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008c, all -> 0x0087 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x008c, all -> 0x0087 }
            int r1 = r8.length     // Catch:{ Exception -> 0x0083, all -> 0x007d }
            r2 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r8, r2, r1)     // Catch:{ Exception -> 0x0083, all -> 0x007d }
            int r1 = r8.getWidth()     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
            int r3 = r8.getHeight()     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
            int r4 = r1 * r3
            r5 = 777600(0xbdd80, float:1.08965E-39)
            if (r4 <= r5) goto L_0x0037
            r4 = 1080(0x438, float:1.513E-42)
            r5 = 720(0x2d0, float:1.009E-42)
            if (r1 < r3) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            r4 = 720(0x2d0, float:1.009E-42)
            r5 = 1080(0x438, float:1.513E-42)
        L_0x0026:
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r8, r4, r5, r2)     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
            java.lang.String r2 = "create scaled bitmap..."
            com.didichuxing.dfbasesdk.utils.LogUtils.m33563d(r2)     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
            if (r1 == 0) goto L_0x0037
            if (r1 == r8) goto L_0x0037
            r8.recycle()     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
            r8 = r1
        L_0x0037:
            android.graphics.Bitmap r8 = com.didichuxing.dfbasesdk.utils.BitmapUtils.rotateBitmap(r8, r9)     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
            r9.<init>()     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r1 = 75
            r8.compress(r7, r1, r9)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            byte[] r7 = r9.toByteArray()     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r0.write(r7)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r0.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0056:
            r9.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005e:
            if (r8 == 0) goto L_0x00b7
            boolean r7 = r8.isRecycled()
            if (r7 != 0) goto L_0x00b7
            r8.recycle()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00b7
        L_0x006b:
            r7 = move-exception
            r10 = r7
            goto L_0x0081
        L_0x006e:
            r7 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L_0x0090
        L_0x0073:
            r9 = move-exception
            r10 = r9
            r9 = r7
            goto L_0x0081
        L_0x0077:
            r9 = move-exception
            r6 = r9
            r9 = r7
            r7 = r0
            r0 = r6
            goto L_0x0090
        L_0x007d:
            r9 = move-exception
            r8 = r7
            r10 = r9
            r9 = r8
        L_0x0081:
            r7 = r0
            goto L_0x00b9
        L_0x0083:
            r9 = move-exception
            r8 = r7
            r7 = r0
            goto L_0x008e
        L_0x0087:
            r9 = move-exception
            r8 = r7
            r10 = r9
            r9 = r8
            goto L_0x00b9
        L_0x008c:
            r9 = move-exception
            r8 = r7
        L_0x008e:
            r0 = r9
            r9 = r8
        L_0x0090:
            r0.printStackTrace()     // Catch:{ all -> 0x00b8 }
            if (r7 == 0) goto L_0x009d
            r7.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r7 = move-exception
            r7.printStackTrace()
        L_0x009d:
            if (r9 == 0) goto L_0x00a7
            r9.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00a7:
            if (r8 == 0) goto L_0x00b7
            boolean r7 = r8.isRecycled()
            if (r7 != 0) goto L_0x00b7
            r8.recycle()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00b7:
            return r10
        L_0x00b8:
            r10 = move-exception
        L_0x00b9:
            if (r7 == 0) goto L_0x00c3
            r7.close()     // Catch:{ IOException -> 0x00bf }
            goto L_0x00c3
        L_0x00bf:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00c3:
            if (r9 == 0) goto L_0x00cd
            r9.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00cd:
            if (r8 == 0) goto L_0x00dd
            boolean r7 = r8.isRecycled()
            if (r7 != 0) goto L_0x00dd
            r8.recycle()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00dd:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.PictureUtils.savePic(android.content.Context, byte[], int, java.io.File):java.io.File");
    }
}
