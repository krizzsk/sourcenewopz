package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public abstract class DefaultDecoder implements PlatformDecoder {
    private static final int DECODE_BUFFER_SIZE = 16384;
    private static final byte[] EOI_TAIL = {-1, -39};
    private static final Class<?> TAG = DefaultDecoder.class;
    private final BitmapPool mBitmapPool;
    final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, false);
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, false);
    }

    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, boolean z) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        boolean z2 = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, z);
        } catch (RuntimeException e) {
            if (z2) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, z);
            }
            throw e;
        }
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, boolean z) {
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        TailAppendingInputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        if (!isCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        boolean z2 = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(inputStream, decodeOptionsForStream, rect, z);
        } catch (RuntimeException e) {
            if (z2) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, z);
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return decodeFromStream(inputStream, options, rect, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        com.facebook.common.logging.FLog.m37096e(TAG, "Could not decode region %s, decoding full bitmap instead.", r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0073, code lost:
        if (r0 != null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0079, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007a, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00cb */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6, all -> 0x00a4, IOException -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084 A[Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6, all -> 0x00a4, IOException -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromStream(java.io.InputStream r8, android.graphics.BitmapFactory.Options r9, @javax.annotation.Nullable android.graphics.Rect r10, boolean r11) {
        /*
            r7 = this;
            com.facebook.common.internal.Preconditions.checkNotNull(r8)
            int r0 = r9.outWidth
            int r1 = r9.outHeight
            if (r10 == 0) goto L_0x0017
            int r0 = r10.width()
            int r1 = r9.inSampleSize
            int r0 = r0 / r1
            int r1 = r10.height()
            int r2 = r9.inSampleSize
            int r1 = r1 / r2
        L_0x0017:
            int r2 = r7.getBitmapSize(r0, r1, r9)
            com.facebook.imagepipeline.memory.BitmapPool r3 = r7.mBitmapPool
            java.lang.Object r2 = r3.get(r2)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            if (r2 == 0) goto L_0x00d2
            r9.inBitmap = r2
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            if (r3 < r4) goto L_0x0037
            if (r11 == 0) goto L_0x0037
            android.graphics.ColorSpace$Named r11 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r11 = android.graphics.ColorSpace.get(r11)
            r9.inPreferredColorSpace = r11
        L_0x0037:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r11 = r7.mDecodeBuffers
            java.lang.Object r11 = r11.acquire()
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            if (r11 != 0) goto L_0x0047
            r11 = 16384(0x4000, float:2.2959E-41)
            java.nio.ByteBuffer r11 = java.nio.ByteBuffer.allocate(r11)
        L_0x0047:
            byte[] r3 = r11.array()     // Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6 }
            r9.inTempStorage = r3     // Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6 }
            r3 = 0
            if (r10 == 0) goto L_0x0081
            r4 = 1
            android.graphics.Bitmap$Config r5 = r9.inPreferredConfig     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            r2.reconfigure(r0, r1, r5)     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            android.graphics.BitmapRegionDecoder r0 = android.graphics.BitmapRegionDecoder.newInstance(r8, r4)     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            android.graphics.Bitmap r10 = r0.decodeRegion(r10, r9)     // Catch:{ IOException -> 0x0067 }
            if (r0 == 0) goto L_0x0082
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6 }
            goto L_0x0082
        L_0x0064:
            r9 = move-exception
            goto L_0x007b
        L_0x0066:
            r0 = r3
        L_0x0067:
            java.lang.Class<?> r1 = TAG     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = "Could not decode region %s, decoding full bitmap instead."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0079 }
            r6 = 0
            r4[r6] = r10     // Catch:{ all -> 0x0079 }
            com.facebook.common.logging.FLog.m37096e((java.lang.Class<?>) r1, (java.lang.String) r5, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0081
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6 }
            goto L_0x0081
        L_0x0079:
            r9 = move-exception
            r3 = r0
        L_0x007b:
            if (r3 == 0) goto L_0x0080
            r3.recycle()     // Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6 }
        L_0x0080:
            throw r9     // Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6 }
        L_0x0081:
            r10 = r3
        L_0x0082:
            if (r10 != 0) goto L_0x0088
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r8, r3, r9)     // Catch:{ IllegalArgumentException -> 0x00ad, RuntimeException -> 0x00a6 }
        L_0x0088:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r8 = r7.mDecodeBuffers
            r8.release(r11)
            if (r2 != r10) goto L_0x0096
            com.facebook.imagepipeline.memory.BitmapPool r8 = r7.mBitmapPool
            com.facebook.common.references.CloseableReference r8 = com.facebook.common.references.CloseableReference.m37163of(r10, r8)
            return r8
        L_0x0096:
            com.facebook.imagepipeline.memory.BitmapPool r8 = r7.mBitmapPool
            r8.release(r2)
            r10.recycle()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x00a4:
            r8 = move-exception
            goto L_0x00cc
        L_0x00a6:
            r8 = move-exception
            com.facebook.imagepipeline.memory.BitmapPool r9 = r7.mBitmapPool     // Catch:{ all -> 0x00a4 }
            r9.release(r2)     // Catch:{ all -> 0x00a4 }
            throw r8     // Catch:{ all -> 0x00a4 }
        L_0x00ad:
            r9 = move-exception
            com.facebook.imagepipeline.memory.BitmapPool r10 = r7.mBitmapPool     // Catch:{ all -> 0x00a4 }
            r10.release(r2)     // Catch:{ all -> 0x00a4 }
            r8.reset()     // Catch:{ IOException -> 0x00cb }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r8)     // Catch:{ IOException -> 0x00cb }
            if (r8 == 0) goto L_0x00ca
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r10 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance()     // Catch:{ IOException -> 0x00cb }
            com.facebook.common.references.CloseableReference r8 = com.facebook.common.references.CloseableReference.m37163of(r8, r10)     // Catch:{ IOException -> 0x00cb }
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r9 = r7.mDecodeBuffers
            r9.release(r11)
            return r8
        L_0x00ca:
            throw r9     // Catch:{ IOException -> 0x00cb }
        L_0x00cb:
            throw r9     // Catch:{ all -> 0x00a4 }
        L_0x00cc:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r9 = r7.mDecodeBuffers
            r9.release(r11)
            throw r8
        L_0x00d2:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "BitmapPool.get returned null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.DefaultDecoder.decodeFromStream(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, boolean):com.facebook.common.references.CloseableReference");
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), (Rect) null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }
}
