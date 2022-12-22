package com.didichuxing.sdk.alphaface.core;

import android.graphics.Bitmap;
import com.didichuxing.sdk.alphaface.AlphaFace;

public class AlphaFaceNativeProxy {

    /* renamed from: a */
    private final AlphaFaceNative f48613a = new AlphaFaceNative();

    public boolean modelInit(String str) {
        try {
            return this.f48613a.modelInit(str);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return false;
        }
    }

    public void setModelLayers(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        try {
            this.f48613a.setModelLayers(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
        }
    }

    public int[] maxFaceDetect(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3) {
        try {
            return this.f48613a.maxFaceDetect(bArr, i, i2, i3, f, f2, f3);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return null;
        }
    }

    public double attackDetect(byte[] bArr, int i, int i2) {
        try {
            return this.f48613a.attackDetect(bArr, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return 0.0d;
        }
    }

    public boolean modelUnInit() {
        try {
            return this.f48613a.modelUnInit();
        } catch (Throwable th) {
            AlphaFace.throwable(th);
            return false;
        }
    }

    public float[] qualityDetect(byte[] bArr, int i, int i2) {
        try {
            return this.f48613a.qualityDetect(bArr, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return null;
        }
    }

    public float[] livenessDetect(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3) {
        try {
            return this.f48613a.livenessDetect(bArr, i, i2, i3, f, f2, f3);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return new float[3];
        }
    }

    public int[] livenessProcess(int i, int i2) {
        try {
            return this.f48613a.livenessProcess(i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return new int[7];
        }
    }

    public int compressBitmap(Bitmap bitmap, int i, byte[] bArr, boolean z) {
        try {
            return this.f48613a.compressBitmap(bitmap, i, bArr, z);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return 0;
        }
    }

    public int compressRGBA(byte[] bArr, int i, int i2, int i3, byte[] bArr2, boolean z) {
        try {
            return this.f48613a.compressRGBA(bArr, i, i2, i3, bArr2, z);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return 0;
        }
    }

    public int yuvToRGBA(byte[] bArr, int i, int i2, byte[] bArr2, int i3, boolean z) {
        try {
            return this.f48613a.yuvToRGBA(bArr, i, i2, bArr2, i3, z);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return 0;
        }
    }

    public boolean setLivenessThres(int i, float f, float f2, float f3, float f4, float f5) {
        try {
            return this.f48613a.setLivenessThres(i, f, f2, f3, f4, f5);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return false;
        }
    }

    public int addWaterMark(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            return this.f48613a.addWaterMark(bArr, i, i2, bArr2, i3);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return 0;
        }
    }

    public String getModel() {
        try {
            return this.f48613a.getModel();
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
            return "";
        }
    }
}
