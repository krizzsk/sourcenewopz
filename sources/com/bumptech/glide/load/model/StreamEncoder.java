package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a A[Catch:{ all -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048 A[SYNTHETIC, Splitter:B:24:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0053 A[SYNTHETIC, Splitter:B:30:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(java.io.InputStream r9, java.io.File r10, com.bumptech.glide.load.Options r11) {
        /*
            r8 = this;
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r11 = r8.byteArrayPool
            java.lang.Class<byte[]> r0 = byte[].class
            r1 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r11 = r11.get(r1, r0)
            byte[] r11 = (byte[]) r11
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002f }
            r2.<init>(r10)     // Catch:{ IOException -> 0x002f }
        L_0x0013:
            int r10 = r9.read(r11)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            r1 = -1
            if (r10 == r1) goto L_0x001e
            r2.write(r11, r0, r10)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            goto L_0x0013
        L_0x001e:
            r2.close()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            r0 = 1
            r2.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004b
        L_0x0026:
            r9 = move-exception
            r1 = r2
            goto L_0x0051
        L_0x0029:
            r9 = move-exception
            r5 = r9
            r1 = r2
            goto L_0x0031
        L_0x002d:
            r9 = move-exception
            goto L_0x0051
        L_0x002f:
            r9 = move-exception
            r5 = r9
        L_0x0031:
            java.lang.String r9 = "StreamEncoder"
            r10 = 3
            boolean r9 = android.util.Log.isLoggable(r9, r10)     // Catch:{ all -> 0x002d }
            if (r9 == 0) goto L_0x0046
            java.lang.String r3 = "StreamEncoder"
            java.lang.String r4 = "Failed to encode data onto the OutputStream"
            r2 = 3
            java.lang.String r6 = "com.bumptech.glide.load.model.StreamEncoder"
            r7 = 40
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002d }
        L_0x0046:
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r9 = r8.byteArrayPool
            r9.put(r11)
            return r0
        L_0x0051:
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r10 = r8.byteArrayPool
            r10.put(r11)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.StreamEncoder.encode(java.io.InputStream, java.io.File, com.bumptech.glide.load.Options):boolean");
    }
}
