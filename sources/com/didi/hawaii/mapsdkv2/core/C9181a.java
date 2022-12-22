package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.didi.hawaii.mapsdkv2.core.a */
/* compiled from: Texture */
class C9181a extends Texture {

    /* renamed from: a */
    private final Bitmap f24006a;

    /* renamed from: b */
    private final String f24007b;

    C9181a(Resources resources, Bitmap bitmap) {
        this.f24006a = bitmap;
        this.f24007b = resources.mo70588a(bitmap);
    }

    public Bitmap getBitmap() {
        return this.f24006a;
    }

    public String getBitmapKey() {
        return this.f24007b;
    }

    public int getRowCount() {
        return this.f24006a.getHeight();
    }

    public int getColumnCount() {
        return this.f24006a.getWidth();
    }

    public String toString() {
        return "[bitmap:" + this.f24006a + Const.jaRight;
    }
}
