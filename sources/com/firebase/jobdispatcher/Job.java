package com.firebase.jobdispatcher;

import android.os.Bundle;

public final class Job implements JobParameters {

    /* renamed from: a */
    private final String f52114a;

    /* renamed from: b */
    private final String f52115b;

    /* renamed from: c */
    private final JobTrigger f52116c;

    /* renamed from: d */
    private final RetryStrategy f52117d;

    /* renamed from: e */
    private final int f52118e;

    /* renamed from: f */
    private final boolean f52119f;

    /* renamed from: g */
    private final int[] f52120g;

    /* renamed from: h */
    private final boolean f52121h;

    /* renamed from: i */
    private final Bundle f52122i;

    public TriggerReason getTriggerReason() {
        return null;
    }

    private Job(Builder builder) {
        this.f52114a = builder.serviceClassName;
        this.f52122i = builder.extras == null ? null : new Bundle(builder.extras);
        this.f52115b = builder.tag;
        this.f52116c = builder.trigger;
        this.f52117d = builder.retryStrategy;
        this.f52118e = builder.lifetime;
        this.f52119f = builder.recurring;
        this.f52120g = builder.constraints != null ? builder.constraints : new int[0];
        this.f52121h = builder.replaceCurrent;
    }

    public int[] getConstraints() {
        return this.f52120g;
    }

    public Bundle getExtras() {
        return this.f52122i;
    }

    public RetryStrategy getRetryStrategy() {
        return this.f52117d;
    }

    public boolean shouldReplaceCurrent() {
        return this.f52121h;
    }

    public String getTag() {
        return this.f52115b;
    }

    public JobTrigger getTrigger() {
        return this.f52116c;
    }

    public int getLifetime() {
        return this.f52118e;
    }

    public boolean isRecurring() {
        return this.f52119f;
    }

    public String getService() {
        return this.f52114a;
    }

    public static final class Builder implements JobParameters {
        /* access modifiers changed from: private */
        public int[] constraints;
        /* access modifiers changed from: private */
        public Bundle extras;
        /* access modifiers changed from: private */
        public int lifetime = 1;
        /* access modifiers changed from: private */
        public boolean recurring = false;
        /* access modifiers changed from: private */
        public boolean replaceCurrent = false;
        /* access modifiers changed from: private */
        public RetryStrategy retryStrategy = RetryStrategy.DEFAULT_EXPONENTIAL;
        /* access modifiers changed from: private */
        public String serviceClassName;
        /* access modifiers changed from: private */
        public String tag;
        /* access modifiers changed from: private */
        public JobTrigger trigger = Trigger.NOW;
        private final ValidationEnforcer validator;

        public TriggerReason getTriggerReason() {
            return null;
        }

        Builder(ValidationEnforcer validationEnforcer) {
            this.validator = validationEnforcer;
        }

        Builder(ValidationEnforcer validationEnforcer, JobParameters jobParameters) {
            this.validator = validationEnforcer;
            this.tag = jobParameters.getTag();
            this.serviceClassName = jobParameters.getService();
            this.trigger = jobParameters.getTrigger();
            this.recurring = jobParameters.isRecurring();
            this.lifetime = jobParameters.getLifetime();
            this.constraints = jobParameters.getConstraints();
            this.extras = jobParameters.getExtras();
            this.retryStrategy = jobParameters.getRetryStrategy();
        }

        public Builder addConstraint(int i) {
            int[] iArr = this.constraints;
            int length = iArr == null ? 1 : iArr.length + 1;
            int[] iArr2 = new int[length];
            int[] iArr3 = this.constraints;
            if (!(iArr3 == null || iArr3.length == 0)) {
                System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            }
            iArr2[length - 1] = i;
            this.constraints = iArr2;
            return this;
        }

        public Builder setReplaceCurrent(boolean z) {
            this.replaceCurrent = z;
            return this;
        }

        public Job build() {
            this.validator.ensureValid((JobParameters) this);
            return new Job(this);
        }

        public String getService() {
            return this.serviceClassName;
        }

        public Builder setService(Class<? extends JobService> cls) {
            this.serviceClassName = cls == null ? null : cls.getName();
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setServiceName(String str) {
            this.serviceClassName = str;
            return this;
        }

        public String getTag() {
            return this.tag;
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public JobTrigger getTrigger() {
            return this.trigger;
        }

        public Builder setTrigger(JobTrigger jobTrigger) {
            this.trigger = jobTrigger;
            return this;
        }

        public int getLifetime() {
            return this.lifetime;
        }

        public Builder setLifetime(int i) {
            this.lifetime = i;
            return this;
        }

        public boolean isRecurring() {
            return this.recurring;
        }

        public Builder setRecurring(boolean z) {
            this.recurring = z;
            return this;
        }

        public int[] getConstraints() {
            int[] iArr = this.constraints;
            return iArr == null ? new int[0] : iArr;
        }

        public Builder setConstraints(int... iArr) {
            this.constraints = iArr;
            return this;
        }

        public Bundle getExtras() {
            return this.extras;
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public RetryStrategy getRetryStrategy() {
            return this.retryStrategy;
        }

        public Builder setRetryStrategy(RetryStrategy retryStrategy2) {
            this.retryStrategy = retryStrategy2;
            return this;
        }

        public boolean shouldReplaceCurrent() {
            return this.replaceCurrent;
        }
    }
}
