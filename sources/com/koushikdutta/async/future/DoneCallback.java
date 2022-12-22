package com.koushikdutta.async.future;

public interface DoneCallback<T> {
    void done(Exception exc, T t) throws Exception;
}
