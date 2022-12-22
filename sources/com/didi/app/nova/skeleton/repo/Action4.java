package com.didi.app.nova.skeleton.repo;

public interface Action4<T> extends Action<T> {
    void call(Event<T> event);
}
