package com.koushikdutta.async.future;

public interface FailRecoverCallback<T> {
    Future<T> fail(Exception exc) throws Exception;
}
