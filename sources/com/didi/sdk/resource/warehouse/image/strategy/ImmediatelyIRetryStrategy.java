package com.didi.sdk.resource.warehouse.image.strategy;

import com.didi.sdk.resource.warehouse.image.IRetryStrategy;

public class ImmediatelyIRetryStrategy implements IRetryStrategy {

    /* renamed from: a */
    private final int f37120a;

    public int interval(String str, int i, Throwable th) {
        return 0;
    }

    public ImmediatelyIRetryStrategy(int i) {
        this.f37120a = i;
    }

    public boolean isContinue(String str, int i, Throwable th) {
        return this.f37120a >= i;
    }
}
