package com.airbnb.lottie;

import android.graphics.Bitmap;

public class LottieImageAsset {

    /* renamed from: a */
    private final int f1161a;

    /* renamed from: b */
    private final int f1162b;

    /* renamed from: c */
    private final String f1163c;

    /* renamed from: d */
    private final String f1164d;

    /* renamed from: e */
    private final String f1165e;

    /* renamed from: f */
    private Bitmap f1166f;

    public LottieImageAsset(int i, int i2, String str, String str2, String str3) {
        this.f1161a = i;
        this.f1162b = i2;
        this.f1163c = str;
        this.f1164d = str2;
        this.f1165e = str3;
    }

    public int getWidth() {
        return this.f1161a;
    }

    public int getHeight() {
        return this.f1162b;
    }

    public String getId() {
        return this.f1163c;
    }

    public String getFileName() {
        return this.f1164d;
    }

    public String getDirName() {
        return this.f1165e;
    }

    public Bitmap getBitmap() {
        return this.f1166f;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f1166f = bitmap;
    }
}
