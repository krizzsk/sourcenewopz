package com.android.didi.bfflib;

public interface BffCallBack<T> {
    void onFailure(BffExtra bffExtra);

    void onSuccess(T t, BffExtra bffExtra);
}
