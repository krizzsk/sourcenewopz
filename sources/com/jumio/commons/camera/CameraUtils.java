package com.jumio.commons.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.jumio.commons.log.Log;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.jvision.jvcorejava.swig.Image;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import com.jumio.jvision.jvcorejava.swig.Rect2i;
import com.jumio.jvision.jvcorejava.swig.Size2i;
import java.util.Locale;

public class CameraUtils {
    public static final int FULL_SIZE = -1;
    private static final String TAG = "CameraUtils";

    /* renamed from: com.jumio.commons.camera.CameraUtils$a */
    public enum C19939a {
        Portrait,
        Landscape,
        InvertedPortrait,
        InvertedLandscape,
        Unknown
    }

    private static ImageSource cropRotateScale(ImageSource imageSource, PreviewProperties previewProperties, int i, int i2, int i3, int i4, int i5, int i6) {
        try {
            return ImageSource.CropRotateScale(imageSource, new Rect2i(i3, i4, i, i2), getImageRotation(previewProperties.orientation, previewProperties.frontFacing), new Size2i(i5, i6));
        } catch (Exception e) {
            Log.printStackTrace(e);
            return null;
        }
    }

    public static int getImageRotation(int i, boolean z) {
        int i2 = i / 90;
        if (z) {
            return (i2 == 1 || i2 == 3) ? (i2 + 2) % 4 : i2;
        }
        return i2;
    }

    public static C19939a getOrientationName(PreviewProperties previewProperties) {
        int i = previewProperties.orientation;
        if (i == 270) {
            return C19939a.InvertedPortrait;
        }
        if (i == 90) {
            return C19939a.Portrait;
        }
        if (i == 180) {
            return C19939a.InvertedLandscape;
        }
        if (i == 0) {
            return C19939a.Landscape;
        }
        return C19939a.Unknown;
    }

    public static Size2i getRotatedSize(int i, int i2, PreviewProperties previewProperties) {
        if (previewProperties.isPortrait) {
            return new Size2i(i2, i);
        }
        return new Size2i(i, i2);
    }

    public static RectF previewToSurface(PreviewProperties previewProperties, RectF rectF) {
        Matrix matrix = new Matrix();
        Size size = previewProperties.scaledPreview;
        Size size2 = previewProperties.preview;
        float f = ((float) size.width) / ((float) size2.width);
        float f2 = ((float) size.height) / ((float) size2.height);
        if (previewProperties.frontFacing) {
            matrix.setScale(f * -1.0f, f2);
            matrix.postTranslate((float) previewProperties.scaledPreview.width, 0.0f);
        } else {
            matrix.setScale(f, f2);
        }
        Size size3 = previewProperties.surface;
        int i = size3.width;
        Size size4 = previewProperties.scaledPreview;
        RectF rectF2 = new RectF(rectF);
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        rectF3.offset(((float) (i - size4.width)) / 2.0f, ((float) (size3.height - size4.height)) / 2.0f);
        return rectF3;
    }

    public static Bitmap readBitmap(String str, AuthorizationModel.SessionKey sessionKey) {
        return readBitmap(str, sessionKey, (BitmapFactory.Options) null);
    }

    public static Bitmap rgb2bitmap(ImageSource imageSource) {
        if (imageSource == null) {
            return null;
        }
        Image rgb = imageSource.getRGB();
        int width = rgb.width();
        int height = rgb.height();
        byte[] bytes = rgb.toBytes();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[width];
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = (i * width * 3) + (i2 * 3);
                iArr[i2] = (((bytes[i3] & 255) << 16) - 16777216) + ((bytes[i3 + 1] & 255) << 8) + (bytes[i3 + 2] & 255);
            }
            createBitmap.setPixels(iArr, 0, width, 0, i, width, 1);
        }
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028 A[SYNTHETIC, Splitter:B:15:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[SYNTHETIC, Splitter:B:21:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveBitmap(android.graphics.Bitmap r4, java.io.File r5, android.graphics.Bitmap.CompressFormat r6, int r7, com.jumio.core.models.AuthorizationModel.SessionKey r8) {
        /*
            java.lang.String r0 = "CameraUtils"
            r1 = 0
            javax.crypto.CipherOutputStream r2 = new javax.crypto.CipherOutputStream     // Catch:{ Exception -> 0x0022 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0022 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0022 }
            javax.crypto.Cipher r5 = r8.getEncryptCipher()     // Catch:{ Exception -> 0x0022 }
            r2.<init>(r3, r5)     // Catch:{ Exception -> 0x0022 }
            r4.compress(r6, r7, r2)     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            r2.flush()     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            r2.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x001b:
            r4 = move-exception
            goto L_0x0032
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r4 = move-exception
            goto L_0x0031
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            com.jumio.commons.log.Log.m39463e((java.lang.String) r0, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r4 = move-exception
            com.jumio.commons.log.Log.m39463e((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x0030:
            return
        L_0x0031:
            r2 = r1
        L_0x0032:
            if (r2 == 0) goto L_0x003c
            r2.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r5 = move-exception
            com.jumio.commons.log.Log.m39463e((java.lang.String) r0, (java.lang.Throwable) r5)
        L_0x003c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.CameraUtils.saveBitmap(android.graphics.Bitmap, java.io.File, android.graphics.Bitmap$CompressFormat, int, com.jumio.core.models.AuthorizationModel$SessionKey):void");
    }

    public static RectF surfaceToPreview(PreviewProperties previewProperties, Rect rect) {
        Matrix matrix = new Matrix();
        Size size = previewProperties.preview;
        Size size2 = previewProperties.scaledPreview;
        matrix.setScale(((float) size.width) / ((float) size2.width), ((float) size.height) / ((float) size2.height));
        Size size3 = previewProperties.scaledPreview;
        int i = size3.width;
        Size size4 = previewProperties.surface;
        RectF rectF = new RectF(rect);
        rectF.offset(((float) (i - size4.width)) / 2.0f, ((float) (size3.height - size4.height)) / 2.0f);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        return rectF2;
    }

    public static Bitmap yuv2bitmap(ImageSource imageSource, boolean z, PreviewProperties previewProperties, Rect rect, int i) {
        ImageSource yuv2rgb = yuv2rgb(imageSource, z, previewProperties, rect, new Size(-1, -1), i);
        if (yuv2rgb != null) {
            return rgb2bitmap(yuv2rgb);
        }
        return null;
    }

    public static ImageSource yuv2rgb(ImageSource imageSource, PreviewProperties previewProperties, Rect rect, float f, Size size) {
        RectF rectF;
        Rect rect2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        PreviewProperties previewProperties2 = previewProperties;
        Size size2 = size;
        if (rect == null) {
            Size size3 = previewProperties2.preview;
            rect2 = new Rect(0, 0, size3.width, size3.height);
            rectF = new RectF(rect2);
        } else {
            rectF = surfaceToPreview(previewProperties, rect);
            rect2 = rect;
        }
        float height = ((float) rect2.height()) / ((float) rect2.width());
        if (previewProperties2.isPortrait) {
            int i7 = (int) rectF.left;
            i = (int) rectF.top;
            int width = (int) rectF.width();
            int height2 = (int) rectF.height();
            if (height >= f) {
                i2 = (int) (((float) width) * f);
                i += (height2 - i2) / 2;
                i3 = i7;
                i4 = width;
            } else {
                int i8 = (int) (((float) height2) / f);
                int i9 = height2;
                i3 = i7 + ((width - i8) / 2);
                i4 = i8;
                i2 = i9;
            }
        } else {
            i = (int) rectF.left;
            int i10 = (int) rectF.top;
            int width2 = (int) rectF.width();
            int height3 = (int) rectF.height();
            if (height <= f) {
                i2 = (int) (((float) height3) / f);
                i += (width2 - i2) / 2;
                int i11 = height3;
                i3 = i10;
                i4 = i11;
            } else {
                int i12 = (int) (((float) width2) * f);
                i3 = i10 + ((height3 - i12) / 2);
                i4 = i12;
                i2 = width2;
            }
        }
        if (size2.width == -1) {
            size2.width = previewProperties2.isPortrait ? i4 : i2;
        }
        if (size2.height == -1) {
            size2.height = previewProperties2.isPortrait ? i2 : i4;
        }
        Size size4 = previewProperties2.camera;
        int i13 = size4.width;
        int i14 = size4.height;
        int i15 = previewProperties2.orientation / 90;
        boolean z = previewProperties2.frontFacing;
        if ((z || !(i15 == 2 || i15 == 4 || i15 == 3)) && (!z || !(i15 == 1 || i15 == 2))) {
            i5 = i3;
            i6 = i;
        } else {
            i5 = (i14 - i4) - i3;
            i6 = (i13 - i2) - i;
        }
        if (i6 < 0 || i5 < 0) {
            Log.m39476w(TAG, String.format(Locale.ENGLISH, "Invalid parameters for cropping: holeLeft: %d ; holeTop: %d ; holeWidth: %d ; holeHeight %d ; previewProperties: %s", new Object[]{Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i4), previewProperties.toString()}));
            return null;
        }
        return cropRotateScale(imageSource, previewProperties, i2, i4, i6, i5, size2.width, size2.height);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: javax.crypto.CipherInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: javax.crypto.CipherInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: javax.crypto.CipherInputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024 A[SYNTHETIC, Splitter:B:15:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[SYNTHETIC, Splitter:B:24:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap readBitmap(java.lang.String r3, com.jumio.core.models.AuthorizationModel.SessionKey r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r0 = 0
            javax.crypto.CipherInputStream r1 = new javax.crypto.CipherInputStream     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            javax.crypto.Cipher r3 = r4.getDecryptCipher()     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1, r0, r5)     // Catch:{ Exception -> 0x0019, all -> 0x0017 }
            r1.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0017:
            r3 = move-exception
            goto L_0x0030
        L_0x0019:
            r3 = move-exception
            goto L_0x001f
        L_0x001b:
            r3 = move-exception
            goto L_0x002f
        L_0x001d:
            r3 = move-exception
            r1 = r0
        L_0x001f:
            com.jumio.commons.log.Log.printStackTrace(r3)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r3 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r3)
        L_0x002c:
            return r0
        L_0x002d:
            r3 = move-exception
            r0 = r1
        L_0x002f:
            r1 = r0
        L_0x0030:
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r4 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r4)
        L_0x003a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.CameraUtils.readBitmap(java.lang.String, com.jumio.core.models.AuthorizationModel$SessionKey, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static int getImageRotation(PreviewProperties previewProperties) {
        return getImageRotation(previewProperties.orientation, previewProperties.frontFacing);
    }

    public static Bitmap rgb2bitmap(ImageSource imageSource, int i, int i2) throws Exception {
        return rgb2bitmap(ImageSource.CropRotateScale(imageSource, new Rect2i(0, 0, imageSource.Width(), imageSource.Height()), 0, new Size2i(i, i2)));
    }

    public static Bitmap rgb2bitmap(ImageSource imageSource, int i) {
        Bitmap rgb2bitmap = rgb2bitmap(imageSource);
        Bitmap createBitmap = Bitmap.createBitmap(rgb2bitmap.getWidth(), rgb2bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, rgb2bitmap.getWidth(), rgb2bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = (float) i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(rgb2bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static ImageSource yuv2rgb(ImageSource imageSource, boolean z, PreviewProperties previewProperties, Rect rect, Size size, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        RectF surfaceToPreview = surfaceToPreview(previewProperties, rect);
        if (z) {
            i2 = (int) surfaceToPreview.width();
            i7 = (int) surfaceToPreview.height();
            i5 = i2;
            i4 = (int) surfaceToPreview.top;
            i6 = i7;
            i3 = (int) surfaceToPreview.left;
        } else {
            int i11 = (int) surfaceToPreview.top;
            i4 = (int) surfaceToPreview.left;
            i5 = (int) surfaceToPreview.height();
            i2 = (int) surfaceToPreview.width();
            i6 = i2;
            i3 = i11;
            i7 = i5;
        }
        if (i == -1 || (i2 <= i && i7 <= i)) {
            i = i2;
            i8 = i7;
        } else if (i2 > i7) {
            i8 = (int) (((float) i) * (((float) i7) / ((float) i2)));
        } else {
            int i12 = i;
            i = (int) (((float) i) * (((float) i2) / ((float) i7)));
            i8 = i12;
        }
        if (size != null) {
            int i13 = size.width;
            if (i13 == -1) {
                size.width = i;
            } else {
                i = i13;
            }
            int i14 = size.height;
            if (i14 == -1) {
                size.height = i8;
            } else {
                i10 = i;
                i9 = i14;
                return cropRotateScale(imageSource, previewProperties, i6, i5, i4, i3, i10, i9);
            }
        }
        i9 = i8;
        i10 = i;
        return cropRotateScale(imageSource, previewProperties, i6, i5, i4, i3, i10, i9);
    }
}
