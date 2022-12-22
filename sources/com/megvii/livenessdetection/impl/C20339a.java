package com.megvii.livenessdetection.impl;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.megvii.livenessdetection.DetectionConfig;
import com.megvii.livenessdetection.DetectionFrame;
import com.megvii.livenessdetection.bean.FaceInfo;
import com.megvii.livenessdetection.obf.C20343b;

/* renamed from: com.megvii.livenessdetection.impl.a */
public final class C20339a extends DetectionFrame {

    /* renamed from: a */
    private Bitmap f55787a;

    /* renamed from: b */
    private byte[] f55788b;

    public final byte[] getCroppedFaceImageData(int i) {
        return null;
    }

    public final byte[] getCroppedFaceImageData(int i, Rect rect) {
        return null;
    }

    public final byte[] getCroppedFaceImageData(Rect rect) {
        return null;
    }

    public final byte[] getEncodedFaceImageData(int i, int i2, Rect rect) {
        return null;
    }

    public final byte[] getImageData(Rect rect, boolean z, int i, int i2, boolean z2, boolean z3, int i3) {
        return null;
    }

    public final int getRotation() {
        return 0;
    }

    public C20339a(Bitmap bitmap) {
        this.f55787a = bitmap;
    }

    /* renamed from: b */
    private boolean m40189b() {
        Bitmap bitmap = this.f55787a;
        return bitmap != null && !bitmap.isRecycled() && Bitmap.Config.ARGB_8888.equals(this.f55787a.getConfig());
    }

    public final int getImageWidth() {
        if (m40189b()) {
            return this.f55787a.getWidth();
        }
        return -1;
    }

    public final int getImageHeight() {
        if (m40189b()) {
            return this.f55787a.getHeight();
        }
        return -1;
    }

    public final synchronized byte[] getYUVData() {
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|13|14|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004d */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m40190c() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.megvii.livenessdetection.bean.FaceInfo r0 = r7.mFaceInfo     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            com.megvii.livenessdetection.bean.FaceInfo r0 = r7.mFaceInfo     // Catch:{ all -> 0x0055 }
            android.graphics.RectF r0 = r0.position     // Catch:{ all -> 0x0055 }
            android.graphics.Bitmap r1 = r7.f55787a     // Catch:{ all -> 0x0055 }
            int r1 = r1.getWidth()     // Catch:{ all -> 0x0055 }
            android.graphics.Bitmap r2 = r7.f55787a     // Catch:{ all -> 0x0055 }
            int r2 = r2.getHeight()     // Catch:{ all -> 0x0055 }
            android.graphics.Bitmap r3 = r7.f55787a     // Catch:{ all -> 0x0055 }
            float r4 = r0.left     // Catch:{ all -> 0x0055 }
            float r1 = (float) r1     // Catch:{ all -> 0x0055 }
            float r4 = r4 * r1
            int r4 = (int) r4     // Catch:{ all -> 0x0055 }
            float r5 = r0.top     // Catch:{ all -> 0x0055 }
            float r2 = (float) r2     // Catch:{ all -> 0x0055 }
            float r5 = r5 * r2
            int r5 = (int) r5     // Catch:{ all -> 0x0055 }
            float r6 = r0.width()     // Catch:{ all -> 0x0055 }
            float r6 = r6 * r1
            int r1 = (int) r6     // Catch:{ all -> 0x0055 }
            float r0 = r0.height()     // Catch:{ all -> 0x0055 }
            float r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ all -> 0x0055 }
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r3, r4, r5, r1, r0)     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x003b
            monitor-exit(r7)
            return
        L_0x003b:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0055 }
            r1.<init>()     // Catch:{ all -> 0x0055 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0055 }
            r3 = 80
            r0.compress(r2, r3, r1)     // Catch:{ all -> 0x0055 }
            r0.recycle()     // Catch:{ all -> 0x0055 }
            r1.close()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            byte[] r0 = r1.toByteArray()     // Catch:{ all -> 0x0055 }
            r7.f55788b = r0     // Catch:{ all -> 0x0055 }
            monitor-exit(r7)
            return
        L_0x0055:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.megvii.livenessdetection.impl.C20339a.m40190c():void");
    }

    public final byte[] getCroppedFaceImageData() {
        if (this.f55788b == null && m40189b() && hasFace()) {
            m40190c();
        }
        return this.f55788b;
    }

    /* renamed from: a */
    public final byte[] mo165080a() {
        if (!m40189b()) {
            return null;
        }
        Bitmap bitmap = this.f55787a;
        byte[] bArr = new byte[(bitmap.getWidth() * bitmap.getHeight())];
        for (int i = 0; i < bitmap.getHeight(); i++) {
            for (int i2 = 0; i2 < bitmap.getWidth(); i2++) {
                int pixel = bitmap.getPixel(i2, i);
                bArr[(bitmap.getWidth() * i) + i2] = (byte) ((((((pixel >> 16) & 255) * 299) + (((pixel >> 8) & 255) * 587)) + ((pixel & 255) * 114)) / 1000);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public final void mo165079a(String str, DetectionConfig detectionConfig, C20343b bVar) {
        this.mFaceInfo = FaceInfo.FaceInfoFactory.createFaceInfo(str);
        if (this.mFaceInfo != null) {
            bVar.mo165088a(this.mFaceInfo);
        }
    }
}
