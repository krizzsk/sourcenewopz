package com.didi.travel.psnger.common.net.base;

public abstract class ResponseListener<T> {
    public void onError(T t) {
    }

    public void onFail(T t) {
    }

    public void onFinish(T t) {
    }

    public void onSuccess(T t) {
    }
}
