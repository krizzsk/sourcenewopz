package com.didi.app.nova.skeleton.repo;

public abstract class Action3<T, R> implements Action<T> {
    /* access modifiers changed from: protected */
    public abstract R before(T t);

    /* access modifiers changed from: protected */
    public abstract void call(R r, Subscription subscription);

    /* access modifiers changed from: protected */
    public abstract boolean filter(T t);

    public void invoke(T t, Subscription subscription) {
        if (filter(t)) {
            call(before(t), subscription);
        }
    }
}
