package com.didi.one.netdetect.http;

public interface ResponseListener<T> {
    void onFail(Throwable th);

    void onSuccess(T t);
}
