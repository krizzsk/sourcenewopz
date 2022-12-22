package com.jumio.core.model;

public interface Subscriber<Result> {
    void onError(Throwable th);

    void onResult(Result result);
}
