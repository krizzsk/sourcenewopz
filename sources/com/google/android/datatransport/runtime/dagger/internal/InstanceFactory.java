package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

public final class InstanceFactory<T> implements Lazy<T>, Factory<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>((Object) null);
    private final T instance;

    public static <T> Factory<T> create(T t) {
        return new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t) {
        if (t == null) {
            return nullInstanceFactory();
        }
        return new InstanceFactory(t);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return NULL_INSTANCE_FACTORY;
    }

    private InstanceFactory(T t) {
        this.instance = t;
    }

    public T get() {
        return this.instance;
    }
}
