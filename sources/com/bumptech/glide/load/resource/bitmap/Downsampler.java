package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.C1850Util;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    private static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() {
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void onObtainBounds() {
        }
    };
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = C1850Util.createQueue(0);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    private static boolean isRotationRequired(int i) {
        return i == 90 || i == 270;
    }

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ByteBufferReader(byteBuffer, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return decode((ImageReader) new ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i, i2, options, decodeCallbacks);
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i, int i2, Options options) throws IOException {
        decode((ImageReader) new ImageReader.ByteArrayReader(bArr, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    /* access modifiers changed from: package-private */
    public void decode(File file, int i, int i2, Options options) throws IOException {
        decode((ImageReader) new ImageReader.FileReader(file, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader imageReader, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Options options2 = options;
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.get(PREFERRED_COLOR_SPACE);
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, (DownsampleStrategy) options2.get(DownsampleStrategy.OPTION), decodeFormat, preferredColorSpace, options2.get(ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options2.get(ALLOW_HARDWARE_CONFIG)).booleanValue(), i, i2, ((Boolean) options2.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue(), decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        int i3;
        int i4;
        Downsampler downsampler;
        int i5;
        int i6;
        BitmapFactory.Options options2 = options;
        PreferredColorSpace preferredColorSpace2 = preferredColorSpace;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader, options2, decodeCallbacks2, this.bitmapPool);
        boolean z3 = false;
        int i7 = dimensions[0];
        int i8 = dimensions[1];
        String str = options2.outMimeType;
        boolean z4 = (i7 == -1 || i8 == -1) ? false : z;
        int imageOrientation = imageReader.getImageOrientation();
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(imageOrientation);
        int i9 = i;
        if (i9 == Integer.MIN_VALUE) {
            i4 = i2;
            i3 = isRotationRequired(exifOrientationDegrees) ? i8 : i7;
        } else {
            i4 = i2;
            i3 = i9;
        }
        int i10 = i4 == Integer.MIN_VALUE ? isRotationRequired(exifOrientationDegrees) ? i7 : i8 : i4;
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        BitmapPool bitmapPool2 = this.bitmapPool;
        ImageHeaderParser.ImageType imageType2 = imageType;
        int i11 = imageOrientation;
        calculateScaling(imageType, imageReader, decodeCallbacks, bitmapPool2, downsampleStrategy, exifOrientationDegrees, i7, i8, i3, i10, options);
        String str2 = str;
        int i12 = i8;
        int i13 = i7;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        PreferredColorSpace preferredColorSpace3 = preferredColorSpace2;
        BitmapFactory.Options options3 = options2;
        calculateConfig(imageReader, decodeFormat, z4, isExifOrientationRequired, options, i3, i10);
        boolean z5 = Build.VERSION.SDK_INT >= 19;
        if (options3.inSampleSize == 1 || z5) {
            downsampler = this;
            if (downsampler.shouldUsePool(imageType2)) {
                if (i13 < 0 || i12 < 0 || !z2 || !z5) {
                    float f = isScaling(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i14 = options3.inSampleSize;
                    float f2 = (float) i14;
                    float f3 = f;
                    i6 = Math.round(((float) ((int) Math.ceil((double) (((float) i13) / f2)))) * f3);
                    i5 = Math.round(((float) ((int) Math.ceil((double) (((float) i12) / f2)))) * f3);
                    if (Log.isLoggable(TAG, 2)) {
                        SystemUtils.log(2, TAG, "Calculated target [" + i6 + "x" + i5 + "] for source [" + i13 + "x" + i12 + "], sampleSize: " + i14 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f3, (Throwable) null, "com.bumptech.glide.load.resource.bitmap.Downsampler", 387);
                    }
                } else {
                    i6 = i3;
                    i5 = i10;
                }
                if (i6 > 0 && i5 > 0) {
                    setInBitmap(options3, downsampler.bitmapPool, i6, i5);
                }
            }
        } else {
            downsampler = this;
        }
        if (preferredColorSpace3 != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (preferredColorSpace3 == PreferredColorSpace.DISPLAY_P3 && options3.outColorSpace != null && options3.outColorSpace.isWideGamut()) {
                    z3 = true;
                }
                options3.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else if (Build.VERSION.SDK_INT >= 26) {
                options3.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap decodeStream = decodeStream(imageReader, options3, decodeCallbacks3, downsampler.bitmapPool);
        decodeCallbacks3.onDecodeComplete(downsampler.bitmapPool, decodeStream);
        if (Log.isLoggable(TAG, 2)) {
            logDecode(i13, i12, str2, options, decodeStream, i, i2, logTime);
        }
        Bitmap bitmap = null;
        if (decodeStream != null) {
            decodeStream.setDensity(downsampler.displayMetrics.densityDpi);
            bitmap = TransformationUtils.rotateImageExif(downsampler.bitmapPool, decodeStream, i11);
            if (!decodeStream.equals(bitmap)) {
                downsampler.bitmapPool.put(decodeStream);
            }
        }
        return bitmap;
    }

    private static void calculateScaling(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        double d;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        BitmapFactory.Options options2 = options;
        if (i12 > 0 && i13 > 0) {
            if (isRotationRequired(i)) {
                i6 = i12;
                i7 = i13;
            } else {
                i7 = i12;
                i6 = i13;
            }
            float scaleFactor = downsampleStrategy2.getScaleFactor(i7, i6, i14, i15);
            if (scaleFactor > 0.0f) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy2.getSampleSizeRounding(i7, i6, i14, i15);
                if (sampleSizeRounding != null) {
                    float f = (float) i7;
                    float f2 = (float) i6;
                    int round = i7 / round((double) (scaleFactor * f));
                    int round2 = i6 / round((double) (scaleFactor * f2));
                    if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                        i8 = Math.max(round, round2);
                    } else {
                        i8 = Math.min(round, round2);
                    }
                    String str = "x";
                    if (Build.VERSION.SDK_INT > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options2.outMimeType)) {
                        i9 = Math.max(1, Integer.highestOneBit(i8));
                        if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY && ((float) i9) < 1.0f / scaleFactor) {
                            i9 <<= 1;
                        }
                    } else {
                        i9 = 1;
                    }
                    options2.inSampleSize = i9;
                    if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                        float min = (float) Math.min(i9, 8);
                        i10 = (int) Math.ceil((double) (f / min));
                        i11 = (int) Math.ceil((double) (f2 / min));
                        int i16 = i9 / 8;
                        if (i16 > 0) {
                            i10 /= i16;
                            i11 /= i16;
                        }
                    } else {
                        if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                            float f3 = (float) i9;
                            i10 = (int) Math.floor((double) (f / f3));
                            d = Math.floor((double) (f2 / f3));
                        } else if (imageType.isWebp()) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                float f4 = (float) i9;
                                i10 = Math.round(f / f4);
                                i11 = Math.round(f2 / f4);
                            } else {
                                float f5 = (float) i9;
                                i10 = (int) Math.floor((double) (f / f5));
                                d = Math.floor((double) (f2 / f5));
                            }
                        } else if (i7 % i9 == 0 && i6 % i9 == 0) {
                            i10 = i7 / i9;
                            i11 = i6 / i9;
                        } else {
                            int[] dimensions = getDimensions(imageReader, options2, decodeCallbacks, bitmapPool2);
                            i10 = dimensions[0];
                            i11 = dimensions[1];
                        }
                        i11 = (int) d;
                    }
                    double scaleFactor2 = (double) downsampleStrategy2.getScaleFactor(i10, i11, i14, i15);
                    if (Build.VERSION.SDK_INT >= 19) {
                        options2.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
                        options2.inDensity = getDensityMultiplier(scaleFactor2);
                    }
                    if (isScaling(options)) {
                        options2.inScaled = true;
                    } else {
                        options2.inTargetDensity = 0;
                        options2.inDensity = 0;
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Calculate scaling, source: [");
                        sb.append(i2);
                        String str2 = str;
                        sb.append(str2);
                        sb.append(i3);
                        sb.append("], degreesToRotate: ");
                        sb.append(i);
                        sb.append(", target: [");
                        sb.append(i14);
                        sb.append(str2);
                        sb.append(i15);
                        sb.append("], power of two scaled: [");
                        sb.append(i10);
                        sb.append(str2);
                        sb.append(i11);
                        sb.append("], exact scale factor: ");
                        sb.append(scaleFactor);
                        sb.append(", power of 2 sample size: ");
                        sb.append(i9);
                        sb.append(", adjusted scale factor: ");
                        sb.append(scaleFactor2);
                        sb.append(", target density: ");
                        sb.append(options2.inTargetDensity);
                        sb.append(", density: ");
                        sb.append(options2.inDensity);
                        SystemUtils.log(2, TAG, sb.toString(), (Throwable) null, "com.bumptech.glide.load.resource.bitmap.Downsampler", 619);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            int i17 = i12;
            throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy2 + ", source: [" + i17 + "x" + i13 + "], target: [" + i14 + "x" + i15 + Const.jaRight);
        } else if (Log.isLoggable(TAG, 3)) {
            SystemUtils.log(3, TAG, "Unable to determine dimensions for: " + imageType2 + " with target [" + i14 + "x" + i15 + Const.jaRight, (Throwable) null, "com.bumptech.glide.load.resource.bitmap.Downsampler", 475);
        }
    }

    private static int adjustTargetDensityForError(double d) {
        int densityMultiplier = getDensityMultiplier(d);
        int round = round(((double) densityMultiplier) * d);
        return round((d / ((double) (((float) round) / ((float) densityMultiplier)))) * ((double) round));
    }

    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return TYPES_THAT_USE_POOL_PRE_KITKAT.contains(imageType);
    }

    private void calculateConfig(ImageReader imageReader, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (!this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, z, z2)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = imageReader.getImageType().hasAlpha();
            } catch (IOException e) {
                IOException iOException = e;
                if (Log.isLoggable(TAG, 3)) {
                    SystemUtils.log(3, TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, iOException, "com.bumptech.glide.load.resource.bitmap.Downsampler", 721);
                }
            }
            options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    private static int[] getDimensions(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader r10, android.graphics.BitmapFactory.Options r11, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r12, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r13) throws java.io.IOException {
        /*
            boolean r0 = r11.inJustDecodeBounds
            if (r0 != 0) goto L_0x000a
            r12.onObtainBounds()
            r10.stopGrowingBuffers()
        L_0x000a:
            int r0 = r11.outWidth
            int r1 = r11.outHeight
            java.lang.String r2 = r11.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r3.lock()
            android.graphics.Bitmap r10 = r10.decodeBitmap(r11)     // Catch:{ IllegalArgumentException -> 0x0025 }
            java.util.concurrent.locks.Lock r11 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r11.unlock()
            return r10
        L_0x0023:
            r10 = move-exception
            goto L_0x005a
        L_0x0025:
            r3 = move-exception
            java.io.IOException r0 = newIoExceptionForInBitmapAssertion(r3, r0, r1, r2, r11)     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0040
            java.lang.String r5 = "Downsampler"
            java.lang.String r6 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            r4 = 3
            java.lang.String r8 = "com.bumptech.glide.load.resource.bitmap.Downsampler"
            r9 = 786(0x312, float:1.101E-42)
            r7 = r0
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0023 }
        L_0x0040:
            android.graphics.Bitmap r1 = r11.inBitmap     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0059
            android.graphics.Bitmap r1 = r11.inBitmap     // Catch:{ IOException -> 0x0058 }
            r13.put(r1)     // Catch:{ IOException -> 0x0058 }
            r1 = 0
            r11.inBitmap = r1     // Catch:{ IOException -> 0x0058 }
            android.graphics.Bitmap r10 = decodeStream(r10, r11, r12, r13)     // Catch:{ IOException -> 0x0058 }
            java.util.concurrent.locks.Lock r11 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r11.unlock()
            return r10
        L_0x0058:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0059:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x005a:
            java.util.concurrent.locks.Lock r11 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r11.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        SystemUtils.log(2, TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j), (Throwable) null, "com.bumptech.glide.load.resource.bitmap.Downsampler", 823);
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
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool2.getDirty(i, i2, config);
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
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
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
