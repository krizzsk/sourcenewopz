package com.didi.payment.base.lifecycle;

public interface ILifecycle {
    void didAppear();

    void didComplete();

    void didCreated();

    void didDisappear();

    void willAppear();

    void willDisappear();
}
