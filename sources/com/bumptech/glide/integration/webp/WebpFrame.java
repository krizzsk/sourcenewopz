package com.bumptech.glide.integration.webp;

import android.graphics.Bitmap;

public class WebpFrame {
    static final int FRAME_DURATION_MS_FOR_MIN = 100;
    static final int MIN_FRAME_DURATION_MS = 11;
    boolean blendPreviousFrame;
    int delay;
    boolean disposeBackgroundColor;

    /* renamed from: ih */
    int f2152ih;

    /* renamed from: iw */
    int f2153iw;

    /* renamed from: ix */
    int f2154ix;

    /* renamed from: iy */
    int f2155iy;
    private long mNativePtr;

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    WebpFrame(long j, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        this.mNativePtr = j;
        this.f2154ix = i;
        this.f2155iy = i2;
        this.f2153iw = i3;
        this.f2152ih = i4;
        this.delay = i5;
        this.blendPreviousFrame = z;
        this.disposeBackgroundColor = z2;
        fixFrameDuration();
    }

    private void fixFrameDuration() {
        if (this.delay < 11) {
            this.delay = 100;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        nativeFinalize();
    }

    public void dispose() {
        nativeDispose();
    }

    public void renderFrame(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    public int getWidth() {
        return this.f2153iw;
    }

    public int getHeight() {
        return this.f2152ih;
    }

    public int getDurationMs() {
        return this.delay;
    }

    public int getXOffest() {
        return this.f2154ix;
    }

    public int getYOffest() {
        return this.f2155iy;
    }

    public boolean shouldDisposeToBackgroundColor() {
        return this.disposeBackgroundColor;
    }

    public boolean isBlendWithPreviousFrame() {
        return this.blendPreviousFrame;
    }
}
