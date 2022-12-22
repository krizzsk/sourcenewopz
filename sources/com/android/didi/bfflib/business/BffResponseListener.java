package com.android.didi.bfflib.business;

public abstract class BffResponseListener<T> {
    public void onError(T t) {
    }

    public void onFail(T t) {
    }

    public void onFinish(T t) {
    }

    public void onSuccess(T t) {
    }
}
