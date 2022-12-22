package com.firebase.jobdispatcher;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RetryStrategy {
    public static final RetryStrategy DEFAULT_EXPONENTIAL = new RetryStrategy(1, 30, 3600);
    public static final RetryStrategy DEFAULT_LINEAR = new RetryStrategy(2, 30, 3600);
    public static final int RETRY_POLICY_EXPONENTIAL = 1;
    public static final int RETRY_POLICY_LINEAR = 2;

    /* renamed from: a */
    private final int f52140a;

    /* renamed from: b */
    private final int f52141b;

    /* renamed from: c */
    private final int f52142c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RetryPolicy {
    }

    RetryStrategy(int i, int i2, int i3) {
        this.f52140a = i;
        this.f52141b = i2;
        this.f52142c = i3;
    }

    public int getPolicy() {
        return this.f52140a;
    }

    public int getInitialBackoff() {
        return this.f52141b;
    }

    public int getMaximumBackoff() {
        return this.f52142c;
    }

    static final class Builder {
        private final ValidationEnforcer validator;

        Builder(ValidationEnforcer validationEnforcer) {
            this.validator = validationEnforcer;
        }

        public RetryStrategy build(int i, int i2, int i3) {
            RetryStrategy retryStrategy = new RetryStrategy(i, i2, i3);
            this.validator.ensureValid(retryStrategy);
            return retryStrategy;
        }
    }
}
