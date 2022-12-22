package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

public class MPPointF extends ObjectPool.Poolable {
    public static final Parcelable.Creator<MPPointF> CREATOR = new Parcelable.Creator<MPPointF>() {
        public MPPointF createFromParcel(Parcel parcel) {
            MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
            mPPointF.my_readFromParcel(parcel);
            return mPPointF;
        }

        public MPPointF[] newArray(int i) {
            return new MPPointF[i];
        }
    };

    /* renamed from: a */
    private static ObjectPool<MPPointF> f52497a;

    /* renamed from: x */
    public float f52498x;

    /* renamed from: y */
    public float f52499y;

    static {
        ObjectPool<MPPointF> create = ObjectPool.create(32, new MPPointF(0.0f, 0.0f));
        f52497a = create;
        create.setReplenishPercentage(0.5f);
    }

    public MPPointF() {
    }

    public MPPointF(float f, float f2) {
        this.f52498x = f;
        this.f52499y = f2;
    }

    public static MPPointF getInstance(float f, float f2) {
        MPPointF mPPointF = f52497a.get();
        mPPointF.f52498x = f;
        mPPointF.f52499y = f2;
        return mPPointF;
    }

    public static MPPointF getInstance() {
        return f52497a.get();
    }

    public static MPPointF getInstance(MPPointF mPPointF) {
        MPPointF mPPointF2 = f52497a.get();
        mPPointF2.f52498x = mPPointF.f52498x;
        mPPointF2.f52499y = mPPointF.f52499y;
        return mPPointF2;
    }

    public static void recycleInstance(MPPointF mPPointF) {
        f52497a.recycle(mPPointF);
    }

    public static void recycleInstances(List<MPPointF> list) {
        f52497a.recycle(list);
    }

    public void my_readFromParcel(Parcel parcel) {
        this.f52498x = parcel.readFloat();
        this.f52499y = parcel.readFloat();
    }

    public float getX() {
        return this.f52498x;
    }

    public float getY() {
        return this.f52499y;
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable instantiate() {
        return new MPPointF(0.0f, 0.0f);
    }
}
