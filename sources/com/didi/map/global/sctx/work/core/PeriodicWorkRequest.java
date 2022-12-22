package com.didi.map.global.sctx.work.core;

import com.didi.map.global.sctx.work.core.WorkRequest;
import java.util.concurrent.TimeUnit;

public class PeriodicWorkRequest extends WorkRequest {
    PeriodicWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec);
    }

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* access modifiers changed from: package-private */
        public Builder getThis() {
            return this;
        }

        public Builder(Worker worker, long j, TimeUnit timeUnit) {
            super(worker);
            this.mWorkSpec.setPeriodic(timeUnit.toMillis(j));
        }

        /* access modifiers changed from: package-private */
        public PeriodicWorkRequest buildInternal() {
            return new PeriodicWorkRequest(this);
        }
    }
}
