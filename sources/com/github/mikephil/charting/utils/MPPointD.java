package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

public class MPPointD extends ObjectPool.Poolable {

    /* renamed from: a */
    private static ObjectPool<MPPointD> f52494a;

    /* renamed from: x */
    public double f52495x;

    /* renamed from: y */
    public double f52496y;

    static {
        ObjectPool<MPPointD> create = ObjectPool.create(64, new MPPointD(0.0d, 0.0d));
        f52494a = create;
        create.setReplenishPercentage(0.5f);
    }

    public static MPPointD getInstance(double d, double d2) {
        MPPointD mPPointD = f52494a.get();
        mPPointD.f52495x = d;
        mPPointD.f52496y = d2;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        f52494a.recycle(mPPointD);
    }

    public static void recycleInstances(List<MPPointD> list) {
        f52494a.recycle(list);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable instantiate() {
        return new MPPointD(0.0d, 0.0d);
    }

    private MPPointD(double d, double d2) {
        this.f52495x = d;
        this.f52496y = d2;
    }

    public String toString() {
        return "MPPointD, x: " + this.f52495x + ", y: " + this.f52496y;
    }
}
