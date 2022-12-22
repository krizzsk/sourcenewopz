package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.didi.hawaii.mapsdkv2.core.g */
/* compiled from: Texture */
class C9187g extends Texture {

    /* renamed from: a */
    private String f24042a;

    /* renamed from: b */
    private final int[] f24043b;

    public Bitmap getBitmap() {
        return null;
    }

    C9187g(String str, int i, int i2) {
        int[] iArr = new int[2];
        this.f24043b = iArr;
        this.f24042a = str;
        iArr[0] = i;
        iArr[1] = i2;
    }

    public String getBitmapKey() {
        return this.f24042a;
    }

    public int getRowCount() {
        return this.f24043b[0];
    }

    public int getColumnCount() {
        return this.f24043b[1];
    }

    public String toString() {
        return "[map_pack:" + this.f24042a + Const.jaRight;
    }
}
