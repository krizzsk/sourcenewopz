package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;

    public BitmapEncoder(ArrayPool arrayPool2) {
        this.arrayPool = arrayPool2;
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:20|(0)|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
        if (r9 == null) goto L_0x0079;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00d7 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4 A[SYNTHETIC, Splitter:B:38:0x00d4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r17, java.io.File r18, com.bumptech.glide.load.Options r19) {
        /*
            r16 = this;
            r1 = r16
            r2 = r19
            java.lang.String r3 = "BitmapEncoder"
            java.lang.Object r0 = r17.get()
            r4 = r0
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            android.graphics.Bitmap$CompressFormat r5 = r1.getFormat(r4, r2)
            int r0 = r4.getWidth()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r6 = r4.getHeight()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat(r7, r0, r6, r5)
            long r6 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00d8 }
            com.bumptech.glide.load.Option<java.lang.Integer> r0 = COMPRESSION_QUALITY     // Catch:{ all -> 0x00d8 }
            java.lang.Object r0 = r2.get(r0)     // Catch:{ all -> 0x00d8 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00d8 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00d8 }
            r8 = 0
            r9 = 0
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0061 }
            r11 = r18
            r10.<init>(r11)     // Catch:{ IOException -> 0x0061 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r9 = r1.arrayPool     // Catch:{ IOException -> 0x005b, all -> 0x0057 }
            if (r9 == 0) goto L_0x004b
            com.bumptech.glide.load.data.BufferedOutputStream r9 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch:{ IOException -> 0x005b, all -> 0x0057 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r11 = r1.arrayPool     // Catch:{ IOException -> 0x005b, all -> 0x0057 }
            r9.<init>(r10, r11)     // Catch:{ IOException -> 0x005b, all -> 0x0057 }
            goto L_0x004c
        L_0x004b:
            r9 = r10
        L_0x004c:
            r4.compress(r5, r0, r9)     // Catch:{ IOException -> 0x0061 }
            r9.close()     // Catch:{ IOException -> 0x0061 }
            r8 = 1
        L_0x0053:
            r9.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x0079
        L_0x0057:
            r0 = move-exception
            r9 = r10
            goto L_0x00d2
        L_0x005b:
            r0 = move-exception
            r13 = r0
            r9 = r10
            goto L_0x0063
        L_0x005f:
            r0 = move-exception
            goto L_0x00d2
        L_0x0061:
            r0 = move-exception
            r13 = r0
        L_0x0063:
            r0 = 3
            boolean r0 = android.util.Log.isLoggable(r3, r0)     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0076
            java.lang.String r11 = "BitmapEncoder"
            java.lang.String r12 = "Failed to encode Bitmap"
            r10 = 3
            java.lang.String r14 = "com.bumptech.glide.load.resource.bitmap.BitmapEncoder"
            r15 = 88
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x005f }
        L_0x0076:
            if (r9 == 0) goto L_0x0079
            goto L_0x0053
        L_0x0079:
            r0 = 2
            boolean r0 = android.util.Log.isLoggable(r3, r0)     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x00ce
            java.lang.String r10 = "BitmapEncoder"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r0.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = "Compressed with type: "
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            r0.append(r5)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = " of size "
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            int r3 = com.bumptech.glide.util.C1850Util.getBitmapByteSize(r4)     // Catch:{ all -> 0x00d8 }
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = " in "
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            double r5 = com.bumptech.glide.util.LogTime.getElapsedMillis(r6)     // Catch:{ all -> 0x00d8 }
            r0.append(r5)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = ", options format: "
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r3 = COMPRESSION_FORMAT     // Catch:{ all -> 0x00d8 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x00d8 }
            r0.append(r2)     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = ", hasAlpha: "
            r0.append(r2)     // Catch:{ all -> 0x00d8 }
            boolean r2 = r4.hasAlpha()     // Catch:{ all -> 0x00d8 }
            r0.append(r2)     // Catch:{ all -> 0x00d8 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x00d8 }
            r9 = 2
            r12 = 0
            java.lang.String r13 = "com.bumptech.glide.load.resource.bitmap.BitmapEncoder"
            r14 = 101(0x65, float:1.42E-43)
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x00d8 }
        L_0x00ce:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r8
        L_0x00d2:
            if (r9 == 0) goto L_0x00d7
            r9.close()     // Catch:{ IOException -> 0x00d7 }
        L_0x00d7:
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r0 = move-exception
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
