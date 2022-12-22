package com.didi.sdk.resource.warehouse.image.strategy;

import com.didi.sdk.resource.warehouse.image.IRetryStrategy;

public class FixedIntervalRetryStrategy implements IRetryStrategy {

    /* renamed from: a */
    private final int f37118a;

    /* renamed from: b */
    private final int f37119b;

    public FixedIntervalRetryStrategy(int i, int i2) {
        this.f37118a = i;
        this.f37119b = i2;
    }

    public int interval(String str, int i, Throwable th) {
        return this.f37118a;
    }

    public boolean isContinue(String str, int i, Throwable th) {
        return this.f37119b >= i;
    }
}
