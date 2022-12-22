package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.C1850Util;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public final class WebpDownsampler {
    private static final int DENSITY_PRECISION_MULTIPLIER = 1000000000;
    public static final Option<Boolean> DISABLE_DECODER = Option.memory("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", false);
    private static final Downsampler.DecodeCallbacks EMPTY_CALLBACKS = new Downsampler.DecodeCallbacks() {
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
        }

        public void onObtainBounds() {
        }
    };
    private static final int MARK_POSITION = 10485760;
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = C1850Util.createQueue(0);
    private static final String TAG = "WebpDownsampler";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final List<ImageHeaderParser> parsers;

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    public WebpDownsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    public boolean handles(InputStream inputStream, Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_DECODER)).booleanValue() || WebpHeaderParser.sIsExtendedWebpSupported) {
            return false;
        }
        WebpHeaderParser.WebpImageType type = WebpHeaderParser.getType(inputStream, this.byteArrayPool);
        if (!WebpHeaderParser.isStaticWebpType(type) || type == WebpHeaderParser.WebpImageType.WEBP_SIMPLE) {
            return false;
        }
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer, Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_DECODER)).booleanValue() || WebpHeaderParser.sIsExtendedWebpSupported) {
            return false;
        }
        WebpHeaderParser.WebpImageType type = WebpHeaderParser.getType(byteBuffer);
        if (!WebpHeaderParser.isStaticWebpType(type) || type == WebpHeaderParser.WebpImageType.WEBP_SIMPLE) {
            return false;
        }
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, Downsampler.DecodeCallbacks decodeCallbacks) throws IOException {
        Options options2 = options;
        Class cls = byte[].class;
        Preconditions.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, cls);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.get(Downsampler.DECODE_FORMAT);
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(inputStream, defaultOptions, (DownsampleStrategy) options2.get(Downsampler.DOWNSAMPLE_STRATEGY), decodeFormat, options2.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options2.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue(), i, i2, ((Boolean) options2.get(Downsampler.FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue(), decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr, cls);
        }
    }

    private Bitmap decodeFromWrappedStreams(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, Downsampler.DecodeCallbacks decodeCallbacks) throws IOException {
        WebpDownsampler webpDownsampler;
        int i3;
        int i4;
        int i5;
        InputStream inputStream2 = inputStream;
        BitmapFactory.Options options2 = options;
        Downsampler.DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(inputStream2, options2, decodeCallbacks2, this.bitmapPool);
        boolean z3 = false;
        int i6 = dimensions[0];
        int i7 = dimensions[1];
        String str = options2.outMimeType;
        boolean z4 = (i6 == -1 || i7 == -1) ? false : z;
        int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream2, this.byteArrayPool);
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        int i8 = i;
        int i9 = i2;
        int i10 = i8 == Integer.MIN_VALUE ? i6 : i8;
        int i11 = i9 == Integer.MIN_VALUE ? i7 : i9;
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.parsers, inputStream2, this.byteArrayPool);
        BitmapPool bitmapPool2 = this.bitmapPool;
        ImageHeaderParser.ImageType imageType = type;
        calculateScaling(type, inputStream, decodeCallbacks, bitmapPool2, downsampleStrategy, exifOrientationDegrees, i6, i7, i10, i11, options);
        int i12 = orientation;
        String str2 = str;
        int i13 = i7;
        int i14 = i6;
        Downsampler.DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        BitmapFactory.Options options3 = options2;
        calculateConfig(inputStream, decodeFormat, z4, isExifOrientationRequired, options, i10, i11);
        if (Build.VERSION.SDK_INT >= 19) {
            z3 = true;
        }
        if (options3.inSampleSize == 1 || z3) {
            webpDownsampler = this;
            if (webpDownsampler.shouldUsePool(imageType)) {
                if (!z2 || !z3) {
                    float f = isScaling(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i15 = options3.inSampleSize;
                    float f2 = (float) i15;
                    i5 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f2)))) * f);
                    i4 = Math.round(((float) ((int) Math.ceil((double) (((float) i13) / f2)))) * f);
                    if (Log.isLoggable(TAG, 2)) {
                        SystemUtils.log(2, TAG, "Calculated target [" + i5 + "x" + i4 + "] for source [" + i14 + "x" + i13 + "], sampleSize: " + i15 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f, (Throwable) null, "com.bumptech.glide.integration.webp.decoder.WebpDownsampler", 246);
                    }
                } else {
                    i5 = i10;
                    i4 = i11;
                }
                if (i5 > 0 && i4 > 0) {
                    setInBitmap(options3, webpDownsampler.bitmapPool, i5, i4);
                }
            }
        } else {
            webpDownsampler = this;
        }
        Bitmap decodeStream = decodeStream(inputStream, options3, decodeCallbacks3, webpDownsampler.bitmapPool);
        decodeCallbacks3.onDecodeComplete(webpDownsampler.bitmapPool, decodeStream);
        if (Log.isLoggable(TAG, 2)) {
            i3 = i12;
            logDecode(i14, i13, str2, options, decodeStream, i, i2, logTime);
        } else {
            i3 = i12;
        }
        Bitmap bitmap = null;
        if (decodeStream != null) {
            decodeStream.setDensity(webpDownsampler.displayMetrics.densityDpi);
            bitmap = TransformationUtils.rotateImageExif(webpDownsampler.bitmapPool, decodeStream, i3);
            if (!decodeStream.equals(bitmap)) {
                webpDownsampler.bitmapPool.put(decodeStream);
            }
        }
        return bitmap;
    }

    static void calculateScaling(ImageHeaderParser.ImageType imageType, InputStream inputStream, Downsampler.DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        float f;
        int i6;
        int i7;
        int i8;
        double d;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        BitmapFactory.Options options2 = options;
        if (i10 > 0 && i11 > 0) {
            if (i9 == 90 || i9 == 270) {
                f = downsampleStrategy2.getScaleFactor(i11, i10, i12, i13);
            } else {
                f = downsampleStrategy2.getScaleFactor(i10, i11, i12, i13);
            }
            if (f > 0.0f) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy2.getSampleSizeRounding(i10, i11, i12, i13);
                if (sampleSizeRounding != null) {
                    float f2 = (float) i10;
                    float f3 = (float) i11;
                    int round = i10 / round((double) (f * f2));
                    int round2 = i11 / round((double) (f * f3));
                    if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                        i6 = Math.max(round, round2);
                    } else {
                        i6 = Math.min(round, round2);
                    }
                    int max = Math.max(1, Integer.highestOneBit(i6));
                    if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY && ((float) max) < 1.0f / f) {
                        max <<= 1;
                    }
                    options2.inSampleSize = max;
                    if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                        float min = (float) Math.min(max, 8);
                        i7 = (int) Math.ceil((double) (f2 / min));
                        i8 = (int) Math.ceil((double) (f3 / min));
                        int i14 = max / 8;
                        if (i14 > 0) {
                            i7 /= i14;
                            i8 /= i14;
                        }
                    } else {
                        if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                            float f4 = (float) max;
                            i7 = (int) Math.floor((double) (f2 / f4));
                            d = Math.floor((double) (f3 / f4));
                        } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                float f5 = (float) max;
                                i7 = Math.round(f2 / f5);
                                i8 = Math.round(f3 / f5);
                            } else {
                                float f6 = (float) max;
                                i7 = (int) Math.floor((double) (f2 / f6));
                                d = Math.floor((double) (f3 / f6));
                            }
                        } else if (i10 % max == 0 && i11 % max == 0) {
                            i7 = i10 / max;
                            i8 = i11 / max;
                        } else {
                            int[] dimensions = getDimensions(inputStream, options2, decodeCallbacks, bitmapPool2);
                            i7 = dimensions[0];
                            i8 = dimensions[1];
                        }
                        i8 = (int) d;
                    }
                    double scaleFactor = (double) downsampleStrategy2.getScaleFactor(i7, i8, i12, i13);
                    if (Build.VERSION.SDK_INT >= 19) {
                        options2.inTargetDensity = adjustTargetDensityForError(scaleFactor);
                        options2.inDensity = 1000000000;
                    }
                    if (isScaling(options)) {
                        options2.inScaled = true;
                    } else {
                        options2.inTargetDensity = 0;
                        options2.inDensity = 0;
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        SystemUtils.log(2, TAG, "Calculate scaling, source: [" + i10 + "x" + i11 + "], target: [" + i12 + "x" + i13 + "], power of two scaled: [" + i7 + "x" + i8 + "], exact scale factor: " + f + ", power of 2 sample size: " + max + ", adjusted scale factor: " + scaleFactor + ", target density: " + options2.inTargetDensity + ", density: " + options2.inDensity, (Throwable) null, "com.bumptech.glide.integration.webp.decoder.WebpDownsampler", 412);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + f + " from: " + downsampleStrategy2 + ", source: [" + i10 + "x" + i11 + "], target: [" + i12 + "x" + i13 + Const.jaRight);
        }
    }

    private static int adjustTargetDensityForError(double d) {
        int round = round(1.0E9d * d);
        return round((d / ((double) (((float) round) / 1.0E9f))) * ((double) round));
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) throws IOException {
        return Build.VERSION.SDK_INT >= 19;
    }

    private void calculateConfig(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) throws IOException {
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean z3 = false;
        try {
            z3 = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool).hasAlpha();
        } catch (IOException e) {
            IOException iOException = e;
            if (Log.isLoggable(TAG, 3)) {
                SystemUtils.log(3, TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, iOException, "com.bumptech.glide.integration.webp.decoder.WebpDownsampler", 487);
            }
        }
        options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == Bitmap.Config.RGB_565 || options.inPreferredConfig == Bitmap.Config.ARGB_4444 || options.inPreferredConfig == Bitmap.Config.ALPHA_8) {
            options.inDither = true;
        }
    }

    private static int[] getDimensions(InputStream inputStream, BitmapFactory.Options options, Downsampler.DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(inputStream, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeStream(java.io.InputStream r11, android.graphics.BitmapFactory.Options r12, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r13, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r14) throws java.io.IOException {
        /*
            boolean r0 = r12.inJustDecodeBounds
            if (r0 == 0) goto L_0x000a
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r11.mark(r0)
            goto L_0x000d
        L_0x000a:
            r13.onObtainBounds()
        L_0x000d:
            int r0 = r12.outWidth
            int r1 = r12.outHeight
            java.lang.String r2 = r12.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r3.lock()
            r3 = 0
            android.graphics.Bitmap r13 = com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeStream(r11, r3, r12)     // Catch:{ IllegalArgumentException -> 0x0030 }
            java.util.concurrent.locks.Lock r14 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r14.unlock()
            boolean r12 = r12.inJustDecodeBounds
            if (r12 == 0) goto L_0x002d
            r11.reset()
        L_0x002d:
            return r13
        L_0x002e:
            r11 = move-exception
            goto L_0x0067
        L_0x0030:
            r4 = move-exception
            java.io.IOException r0 = newIoExceptionForInBitmapAssertion(r4, r0, r1, r2, r12)     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "WebpDownsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x004b
            java.lang.String r6 = "WebpDownsampler"
            java.lang.String r7 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            r5 = 3
            java.lang.String r9 = "com.bumptech.glide.integration.webp.decoder.WebpDownsampler"
            r10 = 543(0x21f, float:7.61E-43)
            r8 = r0
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x002e }
        L_0x004b:
            android.graphics.Bitmap r1 = r12.inBitmap     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0066
            r11.reset()     // Catch:{ IOException -> 0x0065 }
            android.graphics.Bitmap r1 = r12.inBitmap     // Catch:{ IOException -> 0x0065 }
            r14.put(r1)     // Catch:{ IOException -> 0x0065 }
            r12.inBitmap = r3     // Catch:{ IOException -> 0x0065 }
            android.graphics.Bitmap r11 = decodeStream(r11, r12, r13, r14)     // Catch:{ IOException -> 0x0065 }
            java.util.concurrent.locks.Lock r12 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r12.unlock()
            return r11
        L_0x0065:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0066:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0067:
            java.util.concurrent.locks.Lock r12 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r12.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.decoder.WebpDownsampler.decodeStream(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        SystemUtils.log(2, TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j), (Throwable) null, "com.bumptech.glide.integration.webp.decoder.WebpDownsampler", 576);
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static String getBitmapString(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return Const.jaLeft + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool2, int i, int i2) {
        if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            options.inBitmap = bitmapPool2.getDirty(i, i2, options.inPreferredConfig);
        }
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (WebpDownsampler.class) {
            synchronized (OPTIONS_QUEUE) {
                poll = OPTIONS_QUEUE.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        synchronized (OPTIONS_QUEUE) {
            OPTIONS_QUEUE.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
