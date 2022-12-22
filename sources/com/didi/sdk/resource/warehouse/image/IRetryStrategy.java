package com.didi.sdk.resource.warehouse.image;

public interface IRetryStrategy {
    int interval(String str, int i, Throwable th);

    boolean isContinue(String str, int i, Throwable th);
}
