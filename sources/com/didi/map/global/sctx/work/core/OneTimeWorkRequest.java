package com.didi.map.global.sctx.work.core;

import com.didi.map.global.sctx.work.core.WorkRequest;
import java.util.concurrent.TimeUnit;

public class OneTimeWorkRequest extends WorkRequest {
    protected OneTimeWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec);
    }

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        /* access modifiers changed from: package-private */
        public Builder getThis() {
            return this;
        }

        public Builder(Worker worker, long j, TimeUnit timeUnit) {
            super(worker);
            this.mWorkSpec.setInitialDelay(timeUnit.toMillis(j));
        }

        /* access modifiers changed from: package-private */
        public OneTimeWorkRequest buildInternal() {
            return new OneTimeWorkRequest(this);
        }
    }
}
