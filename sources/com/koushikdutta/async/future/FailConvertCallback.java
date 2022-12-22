package com.koushikdutta.async.future;

public interface FailConvertCallback<T> {
    T fail(Exception exc) throws Exception;
}
