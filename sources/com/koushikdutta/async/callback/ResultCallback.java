package com.koushikdutta.async.callback;

public interface ResultCallback<S, T> {
    void onCompleted(Exception exc, S s, T t);
}
