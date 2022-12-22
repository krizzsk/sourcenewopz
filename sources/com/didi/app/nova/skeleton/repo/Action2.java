package com.didi.app.nova.skeleton.repo;

public interface Action2<T> extends Action<T> {
    void call(T t, Subscription subscription);
}
