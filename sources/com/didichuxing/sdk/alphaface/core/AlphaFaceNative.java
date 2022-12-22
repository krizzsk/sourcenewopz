package com.didichuxing.sdk.alphaface.core;

import android.graphics.Bitmap;
import com.didichuxing.sdk.alphaface.utils.LibraryUtils;

public class AlphaFaceNative {
    public native int addWaterMark(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public native double attackDetect(byte[] bArr, int i, int i2);

    public native int compressBitmap(Bitmap bitmap, int i, byte[] bArr, boolean z);

    public native int compressRGBA(byte[] bArr, int i, int i2, int i3, byte[] bArr2, boolean z);

    public native String getModel();

    public native float[] livenessDetect(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3);

    public native int[] livenessProcess(int i, int i2);

    public native int[] maxFaceDetect(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3);

    public native boolean modelInit(String str);

    public native boolean modelUnInit();

    public native float[] qualityDetect(byte[] bArr, int i, int i2);

    public native boolean setLivenessThres(int i, float f, float f2, float f3, float f4, float f5);

    public native void setModelLayers(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17);

    public native int yuvToRGBA(byte[] bArr, int i, int i2, byte[] bArr2, int i3, boolean z);

    static {
        LibraryUtils.loadLibrary("yuv");
        LibraryUtils.loadLibrary("jpeg-turbo");
        LibraryUtils.loadLibrary("alphaface");
    }
}
