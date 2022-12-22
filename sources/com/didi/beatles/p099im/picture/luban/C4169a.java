package com.didi.beatles.p099im.picture.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMApolloConfigUtil;
import com.didi.beatles.p099im.utils.IMLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.didi.beatles.im.picture.luban.a */
/* compiled from: Engine */
class C4169a {

    /* renamed from: a */
    private static final int f9438a = 10;

    /* renamed from: b */
    private static final int f9439b = 10;

    /* renamed from: c */
    private InputStreamProvider f9440c;

    /* renamed from: d */
    private File f9441d;

    /* renamed from: e */
    private int f9442e;

    /* renamed from: f */
    private int f9443f;

    /* renamed from: g */
    private boolean f9444g;

    C4169a(InputStreamProvider inputStreamProvider, File file, boolean z) throws IOException {
        this.f9441d = file;
        this.f9440c = inputStreamProvider;
        this.f9444g = z;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(inputStreamProvider.open(), (Rect) null, options);
        this.f9442e = options.outWidth;
        this.f9443f = options.outHeight;
    }

    /* renamed from: a */
    private int m6416a() {
        int i = this.f9442e;
        if (i % 2 == 1) {
            i++;
        }
        this.f9442e = i;
        int i2 = this.f9443f;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.f9443f = i2;
        int max = Math.max(this.f9442e, i2);
        float min = ((float) Math.min(this.f9442e, this.f9443f)) / ((float) max);
        if (min > 1.0f || ((double) min) <= 0.5625d) {
            double d = (double) min;
            if (d > 0.5625d || d <= 0.5d) {
                return (int) Math.ceil(((double) max) / (1280.0d / d));
            }
            int i3 = max / 1280;
            if (i3 == 0) {
                return 1;
            }
            return i3;
        } else if (max < 1664) {
            return 1;
        } else {
            if (max < 4990) {
                return 2;
            }
            if (max > 4990 && max < 10240) {
                return 4;
            }
            int i4 = max / 1280;
            if (i4 == 0) {
                return 1;
            }
            return i4;
        }
    }

    /* renamed from: a */
    private Bitmap m6417a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public LubanOutput mo43146a(int i) throws IOException {
        int i2 = i;
        if (i2 == 0) {
            throw new IllegalArgumentException("MaxImageSize must be greater than 0.");
        } else if (this.f9441d == null) {
            IMLog.m6632e(Luban.TAG_LUBAN, "[compress] #ERROR# with NULL file");
            return null;
        } else {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = m6416a();
                Bitmap decodeStream = BitmapFactory.decodeStream(this.f9440c.open(), (Rect) null, options);
                if (decodeStream == null) {
                    IMLog.m6632e(Luban.TAG_LUBAN, "[compress] #ERROR# with NULL bitmap by decodeStream");
                    return null;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (Checker.SINGLE.isJPG(this.f9440c.open())) {
                    decodeStream = m6417a(decodeStream, Checker.SINGLE.getOrientation(this.f9440c.open()));
                }
                if (decodeStream == null) {
                    IMLog.m6632e(Luban.TAG_LUBAN, "[compress] #ERROR# with NULL bitmap by rotatingImage");
                    return null;
                }
                int imageBaseCompressQuality = IMApolloConfigUtil.getImageBaseCompressQuality();
                decodeStream.compress(this.f9444g ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, imageBaseCompressQuality, byteArrayOutputStream);
                IMLog.m6631d(Luban.TAG_LUBAN, C4234I.m6591t("[compress] maxImageSize=", Integer.valueOf(i), " #step1# compressQuality=", Integer.valueOf(imageBaseCompressQuality)));
                int i3 = 1;
                while (true) {
                    int length = byteArrayOutputStream.toByteArray().length / 1024;
                    if (length <= i2) {
                        break;
                    }
                    byteArrayOutputStream.reset();
                    i3++;
                    imageBaseCompressQuality = Math.max(imageBaseCompressQuality - 10, 10);
                    IMLog.m6631d(Luban.TAG_LUBAN, C4234I.m6591t("[compress] #Loop# compressQuality=", Integer.valueOf(imageBaseCompressQuality), " |imageSize(kb)=", Integer.valueOf(length)));
                    decodeStream.compress(this.f9444g ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, imageBaseCompressQuality, byteArrayOutputStream);
                    if (imageBaseCompressQuality == 10) {
                        IMLog.m6631d(Luban.TAG_LUBAN, C4234I.m6591t("[compress] #BreakLoop# LOW COMPRESS QUALITY. imageSize(kb)=", Integer.valueOf(length)));
                        break;
                    }
                }
                int i4 = i3;
                int i5 = options.outWidth;
                int i6 = options.outHeight;
                decodeStream.recycle();
                FileOutputStream fileOutputStream = new FileOutputStream(this.f9441d);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                byteArrayOutputStream.close();
                return new LubanOutput(this.f9441d, i5, i6, this.f9441d.length(), i4, imageBaseCompressQuality);
            } catch (OutOfMemoryError e) {
                IMTraceError.trackError("[Luban]#compress#", e);
                return null;
            }
        }
    }
}
