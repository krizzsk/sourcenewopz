package com.megvii.livenessdetection.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import com.megvii.livenessdetection.DetectionConfig;
import com.megvii.livenessdetection.DetectionFrame;
import com.megvii.livenessdetection.Detector;
import com.megvii.livenessdetection.bean.FaceInfo;
import com.megvii.livenessdetection.obf.C20343b;
import com.megvii.livenessdetection.obf.C20346d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.megvii.livenessdetection.impl.b */
public final class C20340b extends DetectionFrame {

    /* renamed from: a */
    private int f55789a;

    /* renamed from: b */
    private int f55790b;

    /* renamed from: c */
    private Detector.DetectionType f55791c;

    /* renamed from: d */
    private byte[] f55792d;

    /* renamed from: e */
    private int f55793e;

    public C20340b(byte[] bArr, int i, int i2, int i3, Detector.DetectionType detectionType) {
        this.f55789a = i;
        this.f55790b = i2;
        this.f55793e = i3;
        System.currentTimeMillis();
        this.f55791c = detectionType;
        this.f55792d = bArr;
    }

    public final int getRotation() {
        return this.f55793e;
    }

    /* renamed from: a */
    public final Detector.DetectionType mo165081a() {
        return this.f55791c;
    }

    public final int getImageWidth() {
        return this.f55789a;
    }

    public final int getImageHeight() {
        return this.f55790b;
    }

    public final byte[] getYUVData() {
        return this.f55792d;
    }

    /* renamed from: a */
    private synchronized byte[] m40193a(int i, Rect rect) {
        return m40194a(i, rect, 80);
    }

    /* renamed from: a */
    private synchronized byte[] m40194a(int i, Rect rect, int i2) {
        int i3 = i;
        int i4 = i2;
        synchronized (this) {
            if (!hasFace()) {
                return null;
            }
            YuvImage yuvImage = new YuvImage(this.f55792d, 17, this.f55789a, this.f55790b, (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Matrix matrix = new Matrix();
            matrix.postRotate((float) (360 - this.f55793e), 0.5f, 0.5f);
            RectF rectF = new RectF();
            matrix.mapRect(rectF, this.mFaceInfo.position);
            Rect rect2 = new Rect();
            rect2.left = (int) (rectF.left * ((float) this.f55789a));
            rect2.right = (int) (rectF.right * ((float) this.f55789a));
            rect2.top = (int) (rectF.top * ((float) this.f55790b));
            rect2.bottom = (int) (rectF.bottom * ((float) this.f55790b));
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f, (float) rect2.centerX(), (float) rect2.centerY());
            RectF rectF2 = new RectF();
            matrix2.mapRect(rectF2, new RectF(rect2));
            rectF2.left = Math.max(0.0f, rectF2.left);
            rectF2.top = Math.max(0.0f, rectF2.top);
            rectF2.right = Math.min(rectF2.right, (float) this.f55789a);
            rectF2.bottom = Math.min(rectF2.bottom, (float) this.f55790b);
            yuvImage.compressToJpeg(new Rect((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom), i4, byteArrayOutputStream);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                C20346d.m40219a(e.toString());
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            Matrix matrix3 = new Matrix();
            matrix3.postRotate((float) this.f55793e);
            if (i3 != -1) {
                float max = ((float) Math.max(decodeByteArray.getWidth(), decodeByteArray.getHeight())) / ((float) i3);
                if (max > 1.0f) {
                    float f = 1.0f / max;
                    matrix3.postScale(f, f);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix3, true);
            float centerX = ((float) rect2.centerX()) - rectF2.left;
            float centerY = ((float) rect2.centerY()) - rectF2.top;
            Matrix matrix4 = new Matrix();
            matrix4.setRotate((float) this.f55793e, 0.5f, 0.5f);
            float[] fArr = new float[2];
            matrix4.mapPoints(fArr, new float[]{centerX / rectF2.width(), centerY / rectF2.height()});
            float width = fArr[0] * ((float) createBitmap.getWidth());
            float height = fArr[1] * ((float) createBitmap.getHeight());
            float max2 = ((float) Math.max(createBitmap.getWidth(), createBitmap.getHeight())) / 1.5f;
            Rect rect3 = rect == null ? new Rect() : rect;
            float f2 = max2 / 2.0f;
            rect3.left = (int) (width - f2);
            rect3.top = (int) (height - f2);
            rect3.right = (int) (width + f2);
            rect3.bottom = (int) (height + f2);
            String a = C20343b.m40203a(rect3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream2);
            try {
                byteArrayOutputStream2.close();
                byte[] a2 = EncodeImpl.m40188a(byteArrayOutputStream2.toByteArray(), false, false, 1824058797, a);
                return a2;
            } catch (IOException unused) {
                return null;
            }
        }
    }

    /* renamed from: b */
    private synchronized byte[] m40195b(int i, Rect rect, int i2) {
        byte[] byteArray;
        YuvImage yuvImage = new YuvImage(this.f55792d, 17, this.f55789a, this.f55790b, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, this.f55789a, this.f55790b), i2, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            C20346d.m40219a(e.toString());
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length);
        Matrix matrix = new Matrix();
        matrix.postRotate((float) this.f55793e);
        if (i != -1) {
            float max = ((float) Math.max(decodeByteArray.getWidth(), decodeByteArray.getHeight())) / ((float) i);
            if (max > 1.0f) {
                float f = 1.0f / max;
                matrix.postScale(f, f);
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
        if (rect == null) {
            rect = new Rect();
        }
        if (hasFace()) {
            rect.left = (int) (this.mFaceInfo.position.left * ((float) createBitmap.getWidth()));
            rect.top = (int) (this.mFaceInfo.position.top * ((float) createBitmap.getHeight()));
            rect.right = (int) (this.mFaceInfo.position.right * ((float) createBitmap.getWidth()));
            rect.bottom = (int) (this.mFaceInfo.position.bottom * ((float) createBitmap.getHeight()));
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream2);
        try {
            byteArrayOutputStream2.close();
            byteArray = byteArrayOutputStream2.toByteArray();
            if (hasFace()) {
                byteArray = EncodeImpl.m40188a(byteArray, false, false, 1824058797, C20343b.m40203a(rect));
            }
        } catch (IOException unused) {
            return null;
        }
        return byteArray;
    }

    public final synchronized byte[] getCroppedFaceImageData() {
        return m40193a(-1, (Rect) null);
    }

    public final synchronized byte[] getCroppedFaceImageData(int i) {
        return m40193a(i, (Rect) null);
    }

    public final byte[] getCroppedFaceImageData(Rect rect) {
        return m40193a(-1, rect);
    }

    public final byte[] getCroppedFaceImageData(int i, Rect rect) {
        return m40193a(i, rect);
    }

    public final byte[] getEncodedFaceImageData(int i, int i2, Rect rect) {
        return EncodeImpl.m40187a(getCroppedFaceImageData(i2, rect), true, true, i);
    }

    public final byte[] getImageData(Rect rect, boolean z, int i, int i2, boolean z2, boolean z3, int i3) {
        if (((z2 || z3) && i3 < 0) || i < 0 || i > 100) {
            return null;
        }
        if (z) {
            if (i2 <= 0) {
                i2 = -1;
            }
            return EncodeImpl.m40187a(m40194a(i2, rect, i), z2, z3, i3);
        }
        if (i2 <= 0) {
            i2 = -1;
        }
        return EncodeImpl.m40187a(m40195b(i2, rect, i), z2, z3, i3);
    }

    /* renamed from: a */
    public final boolean mo165083a(DetectionFrame detectionFrame) {
        return detectionFrame == null || !detectionFrame.hasFace() || (this.mFaceInfo == null ? 0.0f : this.mFaceInfo.smoothQuality) > detectionFrame.getFaceInfo().smoothQuality;
    }

    /* renamed from: a */
    public final void mo165082a(String str, DetectionConfig detectionConfig, C20343b bVar) {
        this.mFaceInfo = FaceInfo.FaceInfoFactory.createFaceInfo(str);
        bVar.mo165088a(this.mFaceInfo);
    }
}
