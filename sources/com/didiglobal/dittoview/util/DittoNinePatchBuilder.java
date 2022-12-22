package com.didiglobal.dittoview.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import com.didi.sdk.apm.SystemUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class DittoNinePatchBuilder {

    /* renamed from: a */
    private int f49896a;

    /* renamed from: b */
    private int f49897b;

    /* renamed from: c */
    private Bitmap f49898c;

    /* renamed from: d */
    private Resources f49899d;

    /* renamed from: e */
    private ArrayList<Integer> f49900e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<Integer> f49901f = new ArrayList<>();

    public DittoNinePatchBuilder(Resources resources, Bitmap bitmap) {
        this.f49896a = bitmap.getWidth();
        this.f49897b = bitmap.getHeight();
        SystemUtils.log(6, "9patch", "width = " + this.f49896a + ", height = " + this.f49897b, (Throwable) null, "com.didiglobal.dittoview.util.DittoNinePatchBuilder", 27);
        this.f49898c = bitmap;
        this.f49899d = resources;
    }

    public DittoNinePatchBuilder(int i, int i2) {
        this.f49896a = i;
        this.f49897b = i2;
    }

    public DittoNinePatchBuilder addXRegion(int i, int i2) {
        this.f49900e.add(Integer.valueOf(i));
        this.f49900e.add(Integer.valueOf(i + i2));
        return this;
    }

    public DittoNinePatchBuilder addXRegionPoints(int i, int i2) {
        this.f49900e.add(Integer.valueOf(i));
        this.f49900e.add(Integer.valueOf(i2));
        return this;
    }

    public DittoNinePatchBuilder addXRegion(float f, float f2) {
        int i = (int) (f * ((float) this.f49896a));
        this.f49900e.add(Integer.valueOf(i));
        this.f49900e.add(Integer.valueOf(i + ((int) (f2 * ((float) this.f49896a)))));
        return this;
    }

    public DittoNinePatchBuilder addXRegionPoints(float f, float f2) {
        this.f49900e.add(Integer.valueOf((int) (f * ((float) this.f49896a))));
        this.f49900e.add(Integer.valueOf((int) (f2 * ((float) this.f49896a))));
        return this;
    }

    public DittoNinePatchBuilder addXCenteredRegion(int i) {
        int i2 = (this.f49896a - i) / 2;
        this.f49900e.add(Integer.valueOf(i2));
        this.f49900e.add(Integer.valueOf(i2 + i));
        return this;
    }

    public DittoNinePatchBuilder addXCenteredRegion(float f) {
        int i = this.f49896a;
        int i2 = (int) (f * ((float) i));
        int i3 = (i - i2) / 2;
        this.f49900e.add(Integer.valueOf(i3));
        this.f49900e.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public DittoNinePatchBuilder addYRegion(int i, int i2) {
        this.f49901f.add(Integer.valueOf(i));
        this.f49901f.add(Integer.valueOf(i + i2));
        return this;
    }

    public DittoNinePatchBuilder addYRegionPoints(int i, int i2) {
        this.f49901f.add(Integer.valueOf(i));
        this.f49901f.add(Integer.valueOf(i2));
        return this;
    }

    public DittoNinePatchBuilder addYRegion(float f, float f2) {
        int i = (int) (f * ((float) this.f49897b));
        this.f49901f.add(Integer.valueOf(i));
        this.f49901f.add(Integer.valueOf(i + ((int) (f2 * ((float) this.f49897b)))));
        return this;
    }

    public DittoNinePatchBuilder addYRegionPoints(float f, float f2) {
        this.f49901f.add(Integer.valueOf((int) (f * ((float) this.f49897b))));
        this.f49901f.add(Integer.valueOf((int) (f2 * ((float) this.f49897b))));
        return this;
    }

    public DittoNinePatchBuilder addYCenteredRegion(int i) {
        int i2 = (this.f49897b - i) / 2;
        this.f49901f.add(Integer.valueOf(i2));
        this.f49901f.add(Integer.valueOf(i2 + i));
        return this;
    }

    public DittoNinePatchBuilder addYCenteredRegion(float f) {
        int i = this.f49897b;
        int i2 = (int) (f * ((float) i));
        int i3 = (i - i2) / 2;
        this.f49901f.add(Integer.valueOf(i3));
        this.f49901f.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public byte[] buildChunk() {
        if (this.f49900e.size() == 0) {
            this.f49900e.add(0);
            this.f49900e.add(Integer.valueOf(this.f49896a));
        }
        if (this.f49901f.size() == 0) {
            this.f49901f.add(0);
            this.f49901f.add(Integer.valueOf(this.f49897b));
        }
        ByteBuffer order = ByteBuffer.allocate((this.f49900e.size() + 8 + this.f49901f.size() + 9) * 4).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) this.f49900e.size());
        order.put((byte) this.f49901f.size());
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        Iterator<Integer> it = this.f49900e.iterator();
        while (it.hasNext()) {
            order.putInt(it.next().intValue());
        }
        Iterator<Integer> it2 = this.f49901f.iterator();
        while (it2.hasNext()) {
            order.putInt(it2.next().intValue());
        }
        for (int i = 0; i < 9; i++) {
            order.putInt(1);
        }
        return order.array();
    }

    public NinePatch buildNinePatch() {
        byte[] buildChunk = buildChunk();
        if (this.f49898c != null) {
            return new NinePatch(this.f49898c, buildChunk, (String) null);
        }
        return null;
    }

    public NinePatchDrawable build() {
        NinePatch buildNinePatch = buildNinePatch();
        if (buildNinePatch != null) {
            return new NinePatchDrawable(this.f49899d, buildNinePatch);
        }
        return null;
    }
}
