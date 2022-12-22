package com.didi.beatles.p099im.utils.imageloader;

/* renamed from: com.didi.beatles.im.utils.imageloader.IMImageRequestOptions */
public class IMImageRequestOptions {

    /* renamed from: a */
    private static final int f9833a = -1;

    /* renamed from: b */
    private static final int f9834b = 1;

    /* renamed from: c */
    private float f9835c = -1.0f;

    /* renamed from: d */
    private int f9836d = -1;

    /* renamed from: e */
    private int f9837e = -1;

    /* renamed from: f */
    private int f9838f;

    /* renamed from: g */
    private DiskCacheStrategy f9839g = DiskCacheStrategy.AUTOMATIC;

    /* renamed from: h */
    private int f9840h = -1;

    /* renamed from: com.didi.beatles.im.utils.imageloader.IMImageRequestOptions$DiskCacheStrategy */
    public enum DiskCacheStrategy {
        ALL,
        NONE,
        DATA,
        RESOURCE,
        AUTOMATIC
    }

    public IMImageRequestOptions sizeMultiplier(float f) {
        this.f9835c = f;
        return this;
    }

    public float getSizeMultiplier() {
        return this.f9835c;
    }

    public boolean isValidSizeMultiplier() {
        return this.f9835c != -1.0f;
    }

    public IMImageRequestOptions override(int i) {
        this.f9837e = i;
        this.f9836d = i;
        return this;
    }

    public IMImageRequestOptions override(int i, int i2) {
        this.f9837e = i;
        this.f9836d = i2;
        return this;
    }

    public boolean isValidOverrideSize() {
        return (this.f9837e == -1 || this.f9836d == -1) ? false : true;
    }

    public int getOverrideWidth() {
        return this.f9837e;
    }

    public int getOverrideHeight() {
        return this.f9836d;
    }

    public IMImageRequestOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        this.f9839g = diskCacheStrategy;
        return this;
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.f9839g;
    }

    public IMImageRequestOptions placeholder(int i) {
        this.f9838f = i;
        return this;
    }

    public boolean isValidPlaceholderId() {
        return this.f9838f > 0;
    }

    public int getPlaceholderId() {
        return this.f9838f;
    }

    public IMImageRequestOptions centerCrop() {
        this.f9840h = 1;
        return this;
    }

    public boolean isValidCenterCrop() {
        return this.f9840h == 1;
    }
}
