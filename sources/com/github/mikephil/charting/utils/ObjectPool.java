package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

public class ObjectPool<T extends Poolable> {

    /* renamed from: a */
    private static int f52500a;

    /* renamed from: b */
    private int f52501b;

    /* renamed from: c */
    private int f52502c;

    /* renamed from: d */
    private Object[] f52503d;

    /* renamed from: e */
    private int f52504e;

    /* renamed from: f */
    private T f52505f;

    /* renamed from: g */
    private float f52506g;

    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        int currentOwnerId = NO_OWNER;

        /* access modifiers changed from: protected */
        public abstract Poolable instantiate();
    }

    public int getPoolId() {
        return this.f52501b;
    }

    public static synchronized ObjectPool create(int i, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i, poolable);
            objectPool.f52501b = f52500a;
            f52500a++;
        }
        return objectPool;
    }

    private ObjectPool(int i, T t) {
        if (i > 0) {
            this.f52502c = i;
            this.f52503d = new Object[i];
            this.f52504e = 0;
            this.f52505f = t;
            this.f52506g = 1.0f;
            m37285a();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public void setReplenishPercentage(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f52506g = f;
    }

    public float getReplenishPercentage() {
        return this.f52506g;
    }

    /* renamed from: a */
    private void m37285a() {
        m37286a(this.f52506g);
    }

    /* renamed from: a */
    private void m37286a(float f) {
        int i = this.f52502c;
        int i2 = (int) (((float) i) * f);
        if (i2 < 1) {
            i = 1;
        } else if (i2 <= i) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f52503d[i3] = this.f52505f.instantiate();
        }
        this.f52504e = i - 1;
    }

    public synchronized T get() {
        T t;
        if (this.f52504e == -1 && this.f52506g > 0.0f) {
            m37285a();
        }
        t = (Poolable) this.f52503d[this.f52504e];
        t.currentOwnerId = Poolable.NO_OWNER;
        this.f52504e--;
        return t;
    }

    public synchronized void recycle(T t) {
        if (t.currentOwnerId == Poolable.NO_OWNER) {
            int i = this.f52504e + 1;
            this.f52504e = i;
            if (i >= this.f52503d.length) {
                m37287b();
            }
            t.currentOwnerId = this.f52501b;
            this.f52503d[this.f52504e] = t;
        } else if (t.currentOwnerId == this.f52501b) {
            throw new IllegalArgumentException("The object passed is already stored in this pool!");
        } else {
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
        }
    }

    public synchronized void recycle(List<T> list) {
        while (list.size() + this.f52504e + 1 > this.f52502c) {
            m37287b();
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            Poolable poolable = (Poolable) list.get(i);
            if (poolable.currentOwnerId == Poolable.NO_OWNER) {
                poolable.currentOwnerId = this.f52501b;
                this.f52503d[this.f52504e + 1 + i] = poolable;
                i++;
            } else if (poolable.currentOwnerId == this.f52501b) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            } else {
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + poolable.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
        }
        this.f52504e += size;
    }

    /* renamed from: b */
    private void m37287b() {
        int i = this.f52502c;
        int i2 = i * 2;
        this.f52502c = i2;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = this.f52503d[i3];
        }
        this.f52503d = objArr;
    }

    public int getPoolCapacity() {
        return this.f52503d.length;
    }

    public int getPoolCount() {
        return this.f52504e + 1;
    }
}
