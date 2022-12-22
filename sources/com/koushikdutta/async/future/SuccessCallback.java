package com.koushikdutta.async.future;

public interface SuccessCallback<T> {
    void success(T t) throws Exception;
}
