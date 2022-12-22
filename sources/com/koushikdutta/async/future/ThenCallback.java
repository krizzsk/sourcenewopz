package com.koushikdutta.async.future;

public interface ThenCallback<T, F> {
    T then(F f) throws Exception;
}
