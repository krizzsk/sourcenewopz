package com.didi.zxing.barcodescanner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.didi.dqr.PlanarYUVLuminanceSource;
import java.io.ByteArrayOutputStream;

public class SourceData {

    /* renamed from: a */
    private byte[] f45316a;

    /* renamed from: b */
    private int f45317b;

    /* renamed from: c */
    private int f45318c;

    /* renamed from: d */
    private int f45319d;

    /* renamed from: e */
    private int f45320e;

    /* renamed from: f */
    private Rect f45321f;

    public SourceData(byte[] bArr, int i, int i2, int i3, int i4) {
        this.f45316a = bArr;
        this.f45317b = i;
        this.f45318c = i2;
        this.f45320e = i4;
        this.f45319d = i3;
        if (i * i2 > bArr.length) {
            throw new IllegalArgumentException("Image data does not match the resolution. " + i + "x" + i2 + " > " + bArr.length);
        }
    }

    public Rect getCropRect() {
        return this.f45321f;
    }

    public void setCropRect(Rect rect) {
        this.f45321f = rect;
    }

    public byte[] getData() {
        return this.f45316a;
    }

    public int getDataWidth() {
        return this.f45317b;
    }

    public int getDataHeight() {
        return this.f45318c;
    }

    public boolean isRotated() {
        return this.f45320e % 180 != 0;
    }

    public int getImageFormat() {
        return this.f45319d;
    }

    public PlanarYUVLuminanceSource createSource() {
        int i;
        int i2;
        byte[] rotateCameraPreview = rotateCameraPreview(this.f45320e, this.f45316a, this.f45317b, this.f45318c);
        if (this.f45321f.width() % 2 != 0) {
            Rect rect = this.f45321f;
            rect.right--;
        }
        if (this.f45321f.height() % 2 != 0) {
            Rect rect2 = this.f45321f;
            rect2.bottom--;
        }
        if (isRotated()) {
            if (this.f45321f.left + this.f45321f.width() > this.f45318c || this.f45321f.top + this.f45321f.height() > (i2 = this.f45317b)) {
                return null;
            }
            return new PlanarYUVLuminanceSource(rotateCameraPreview, this.f45318c, i2, this.f45321f.left, this.f45321f.top, this.f45321f.width(), this.f45321f.height(), false);
        } else if (this.f45321f.left + this.f45321f.width() > this.f45317b || this.f45321f.top + this.f45321f.height() > (i = this.f45318c)) {
            return null;
        } else {
            return new PlanarYUVLuminanceSource(rotateCameraPreview, this.f45317b, i, this.f45321f.left, this.f45321f.top, this.f45321f.width(), this.f45321f.height(), false);
        }
    }

    public Bitmap getBitmap() {
        return getBitmap(1);
    }

    public Bitmap getBitmap(int i) {
        return m32535a(this.f45321f, i);
    }

    /* renamed from: a */
    private Bitmap m32535a(Rect rect, int i) {
        if (isRotated()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f45316a, this.f45319d, this.f45317b, this.f45318c, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f45320e == 0) {
            return decodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) this.f45320e);
        return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
    }

    public byte[] getJpeg(int i) {
        if (isRotated()) {
            this.f45321f = new Rect(this.f45321f.top, this.f45321f.left, this.f45321f.bottom, this.f45321f.right);
        }
        YuvImage yuvImage = new YuvImage(this.f45316a, this.f45319d, this.f45317b, this.f45318c, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(this.f45321f, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] rotateCameraPreview(int i, byte[] bArr, int i2, int i3) {
        if (i == 90) {
            return rotateCW(bArr, i2, i3);
        }
        if (i != 180) {
            return i != 270 ? bArr : rotateCCW(bArr, i2, i3);
        }
        return rotate180(bArr, i2, i3);
    }

    public static byte[] rotateCW(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i * i2)];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        return bArr2;
    }

    public static byte[] rotate180(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i4] = bArr[i5];
            i4--;
        }
        return bArr2;
    }

    public static byte[] rotateCCW(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4--;
            }
        }
        return bArr2;
    }

    public int getAverageLum(int i) {
        int i2 = this.f45318c * this.f45317b;
        long j = 0;
        int i3 = 0;
        while (i3 < this.f45317b) {
            int i4 = 0;
            while (i4 < this.f45318c) {
                j += (long) (this.f45316a[(this.f45317b * i4) + i3] & 255);
                i4 += i;
            }
            i3 += i;
        }
        return (int) (j / ((long) ((i2 / i) / i)));
    }
}
