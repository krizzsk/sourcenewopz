package com.didi.sdk.store;

public interface FetchCallback<T> {
    void onFail(int i);

    void onSuccess(T t);
}
