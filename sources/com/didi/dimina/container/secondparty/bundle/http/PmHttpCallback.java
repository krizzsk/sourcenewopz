package com.didi.dimina.container.secondparty.bundle.http;

public interface PmHttpCallback<T> {
    void onFailed(Exception exc);

    void onSucceed(T t);
}
