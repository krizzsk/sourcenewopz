package com.didi.app.nova.skeleton.repo;

public class Event<T> {
    public T newData;
    public T oldData;
    public Subscription subscription;

    public Event(T t, T t2, Subscription subscription2) {
        this.oldData = t;
        this.newData = t2;
        this.subscription = subscription2;
    }
}
