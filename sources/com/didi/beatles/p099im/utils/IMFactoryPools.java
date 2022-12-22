package com.didi.beatles.p099im.utils;

import androidx.core.util.Pools;

/* renamed from: com.didi.beatles.im.utils.IMFactoryPools */
public final class IMFactoryPools {

    /* renamed from: a */
    private static final String f9766a = IMFactoryPools.class.getSimpleName();

    /* renamed from: b */
    private static final Resetter<Object> f9767b = new Resetter<Object>() {
        public void reset(Object obj) {
        }
    };

    /* renamed from: com.didi.beatles.im.utils.IMFactoryPools$Factory */
    public interface Factory<T> {
        T create();
    }

    /* renamed from: com.didi.beatles.im.utils.IMFactoryPools$Resetter */
    public interface Resetter<T> {
        void reset(T t);
    }

    private IMFactoryPools() {
    }

    public static <T> Pools.Pool<T> simple(int i, Factory<T> factory) {
        return m6618a(new Pools.SimplePool(i), factory);
    }

    public static <T> Pools.Pool<T> simple(int i, Factory<T> factory, Resetter<T> resetter) {
        return m6619a(new Pools.SimplePool(i), factory, resetter);
    }

    public static <T> Pools.Pool<T> threadSafe(int i, Factory<T> factory) {
        return m6618a(new Pools.SynchronizedPool(i), factory);
    }

    public static <T> Pools.Pool<T> threadSafe(int i, Factory<T> factory, Resetter<T> resetter) {
        return m6619a(new Pools.SynchronizedPool(i), factory, resetter);
    }

    /* renamed from: a */
    private static <T> Pools.Pool<T> m6618a(Pools.Pool<T> pool, Factory<T> factory) {
        return m6619a(pool, factory, m6620a());
    }

    /* renamed from: a */
    private static <T> Pools.Pool<T> m6619a(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    /* renamed from: a */
    private static <T> Resetter<T> m6620a() {
        return f9767b;
    }

    /* renamed from: com.didi.beatles.im.utils.IMFactoryPools$FactoryPool */
    private static final class FactoryPool<T> implements Pools.Pool<T> {
        private final Factory<T> factory;
        private final Pools.Pool<T> pool;
        private final Resetter<T> resetter;

        public FactoryPool(Pools.Pool<T> pool2, Factory<T> factory2, Resetter<T> resetter2) {
            this.factory = factory2;
            this.resetter = resetter2;
            this.pool = pool2;
        }

        public T acquire() {
            T acquire = this.pool.acquire();
            return acquire == null ? this.factory.create() : acquire;
        }

        public boolean release(T t) {
            this.resetter.reset(t);
            return this.pool.release(t);
        }
    }
}
