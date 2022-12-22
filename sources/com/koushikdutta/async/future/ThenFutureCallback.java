package com.koushikdutta.async.future;

public interface ThenFutureCallback<T, F> {
    Future<T> then(F f) throws Exception;
}
