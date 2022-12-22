package com.didi.unifylogin.base.service;

public interface PassportServiceListener<T> {
    void onFail();

    void onSuccess(T t);
}
