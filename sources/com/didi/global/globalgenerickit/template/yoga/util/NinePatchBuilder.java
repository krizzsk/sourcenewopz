package com.didi.global.globalgenerickit.template.yoga.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import com.didi.sdk.apm.SystemUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class NinePatchBuilder {

    /* renamed from: a */
    private int f22237a;

    /* renamed from: b */
    private int f22238b;

    /* renamed from: c */
    private Bitmap f22239c;

    /* renamed from: d */
    private Resources f22240d;

    /* renamed from: e */
    private ArrayList<Integer> f22241e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<Integer> f22242f = new ArrayList<>();

    public NinePatchBuilder(Resources resources, Bitmap bitmap) {
        this.f22237a = bitmap.getWidth();
        this.f22238b = bitmap.getHeight();
        SystemUtils.log(6, "9patch", "width = " + this.f22237a + ", height = " + this.f22238b, (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.util.NinePatchBuilder", 27);
        this.f22239c = bitmap;
        this.f22240d = resources;
    }

    public NinePatchBuilder(int i, int i2) {
        this.f22237a = i;
        this.f22238b = i2;
    }

    public NinePatchBuilder addXRegion(int i, int i2) {
        this.f22241e.add(Integer.valueOf(i));
        this.f22241e.add(Integer.valueOf(i + i2));
        return this;
    }

    public NinePatchBuilder addXRegionPoints(int i, int i2) {
        this.f22241e.add(Integer.valueOf(i));
        this.f22241e.add(Integer.valueOf(i2));
        return this;
    }

    public NinePatchBuilder addXRegion(float f, float f2) {
        int i = (int) (f * ((float) this.f22237a));
        this.f22241e.add(Integer.valueOf(i));
        this.f22241e.add(Integer.valueOf(i + ((int) (f2 * ((float) this.f22237a)))));
        return this;
    }

    public NinePatchBuilder addXRegionPoints(float f, float f2) {
        this.f22241e.add(Integer.valueOf((int) (f * ((float) this.f22237a))));
        this.f22241e.add(Integer.valueOf((int) (f2 * ((float) this.f22237a))));
        return this;
    }

    public NinePatchBuilder addXCenteredRegion(int i) {
        int i2 = (this.f22237a - i) / 2;
        this.f22241e.add(Integer.valueOf(i2));
        this.f22241e.add(Integer.valueOf(i2 + i));
        return this;
    }

    public NinePatchBuilder addXCenteredRegion(float f) {
        int i = this.f22237a;
        int i2 = (int) (f * ((float) i));
        int i3 = (i - i2) / 2;
        this.f22241e.add(Integer.valueOf(i3));
        this.f22241e.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public NinePatchBuilder addYRegion(int i, int i2) {
        this.f22242f.add(Integer.valueOf(i));
        this.f22242f.add(Integer.valueOf(i + i2));
        return this;
    }

    public NinePatchBuilder addYRegionPoints(int i, int i2) {
        this.f22242f.add(Integer.valueOf(i));
        this.f22242f.add(Integer.valueOf(i2));
        return this;
    }

    public NinePatchBuilder addYRegion(float f, float f2) {
        int i = (int) (f * ((float) this.f22238b));
        this.f22242f.add(Integer.valueOf(i));
        this.f22242f.add(Integer.valueOf(i + ((int) (f2 * ((float) this.f22238b)))));
        return this;
    }

    public NinePatchBuilder addYRegionPoints(float f, float f2) {
        this.f22242f.add(Integer.valueOf((int) (f * ((float) this.f22238b))));
        this.f22242f.add(Integer.valueOf((int) (f2 * ((float) this.f22238b))));
        return this;
    }

    public NinePatchBuilder addYCenteredRegion(int i) {
        int i2 = (this.f22238b - i) / 2;
        this.f22242f.add(Integer.valueOf(i2));
        this.f22242f.add(Integer.valueOf(i2 + i));
        return this;
    }

    public NinePatchBuilder addYCenteredRegion(float f) {
        int i = this.f22238b;
        int i2 = (int) (f * ((float) i));
        int i3 = (i - i2) / 2;
        this.f22242f.add(Integer.valueOf(i3));
        this.f22242f.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public byte[] buildChunk() {
        if (this.f22241e.size() == 0) {
            this.f22241e.add(0);
            this.f22241e.add(Integer.valueOf(this.f22237a));
        }
        if (this.f22242f.size() == 0) {
            this.f22242f.add(0);
            this.f22242f.add(Integer.valueOf(this.f22238b));
        }
        ByteBuffer order = ByteBuffer.allocate((this.f22241e.size() + 8 + this.f22242f.size() + 9) * 4).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) this.f22241e.size());
        order.put((byte) this.f22242f.size());
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        Iterator<Integer> it = this.f22241e.iterator();
        while (it.hasNext()) {
            order.putInt(it.next().intValue());
        }
        Iterator<Integer> it2 = this.f22242f.iterator();
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
        if (this.f22239c != null) {
            return new NinePatch(this.f22239c, buildChunk, (String) null);
        }
        return null;
    }

    public NinePatchDrawable build() {
        NinePatch buildNinePatch = buildNinePatch();
        if (buildNinePatch != null) {
            return new NinePatchDrawable(this.f22240d, buildNinePatch);
        }
        return null;
    }
}
