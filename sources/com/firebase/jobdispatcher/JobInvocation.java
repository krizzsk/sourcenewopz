package com.firebase.jobdispatcher;

import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONObject;

final class JobInvocation implements JobParameters {

    /* renamed from: a */
    private final String f52123a;

    /* renamed from: b */
    private final String f52124b;

    /* renamed from: c */
    private final JobTrigger f52125c;

    /* renamed from: d */
    private final boolean f52126d;

    /* renamed from: e */
    private final int f52127e;

    /* renamed from: f */
    private final int[] f52128f;

    /* renamed from: g */
    private final Bundle f52129g;

    /* renamed from: h */
    private final RetryStrategy f52130h;

    /* renamed from: i */
    private final boolean f52131i;

    /* renamed from: j */
    private final TriggerReason f52132j;

    private JobInvocation(Builder builder) {
        this.f52123a = builder.tag;
        this.f52124b = builder.service;
        this.f52125c = builder.trigger;
        this.f52130h = builder.retryStrategy;
        this.f52126d = builder.recurring;
        this.f52127e = builder.lifetime;
        this.f52128f = builder.constraints;
        this.f52129g = builder.extras;
        this.f52131i = builder.replaceCurrent;
        this.f52132j = builder.triggerReason;
    }

    public String getService() {
        return this.f52124b;
    }

    public String getTag() {
        return this.f52123a;
    }

    public JobTrigger getTrigger() {
        return this.f52125c;
    }

    public int getLifetime() {
        return this.f52127e;
    }

    public boolean isRecurring() {
        return this.f52126d;
    }

    public int[] getConstraints() {
        return this.f52128f;
    }

    public Bundle getExtras() {
        return this.f52129g;
    }

    public RetryStrategy getRetryStrategy() {
        return this.f52130h;
    }

    public boolean shouldReplaceCurrent() {
        return this.f52131i;
    }

    public TriggerReason getTriggerReason() {
        return this.f52132j;
    }

    static final class Builder {
        /* access modifiers changed from: private */
        public int[] constraints;
        /* access modifiers changed from: private */
        public final Bundle extras = new Bundle();
        /* access modifiers changed from: private */
        public int lifetime;
        /* access modifiers changed from: private */
        public boolean recurring;
        /* access modifiers changed from: private */
        public boolean replaceCurrent;
        /* access modifiers changed from: private */
        public RetryStrategy retryStrategy;
        /* access modifiers changed from: private */
        public String service;
        /* access modifiers changed from: private */
        public String tag;
        /* access modifiers changed from: private */
        public JobTrigger trigger;
        /* access modifiers changed from: private */
        public TriggerReason triggerReason;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public JobInvocation build() {
            if (this.tag != null && this.service != null && this.trigger != null) {
                return new JobInvocation(this);
            }
            throw new IllegalArgumentException("Required fields were not populated.");
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setService(String str) {
            this.service = str;
            return this;
        }

        public Builder setTrigger(JobTrigger jobTrigger) {
            this.trigger = jobTrigger;
            return this;
        }

        public Builder setRecurring(boolean z) {
            this.recurring = z;
            return this;
        }

        public Builder setLifetime(int i) {
            this.lifetime = i;
            return this;
        }

        public Builder setConstraints(int[] iArr) {
            this.constraints = iArr;
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.extras.putAll(bundle);
            }
            return this;
        }

        public Builder setRetryStrategy(RetryStrategy retryStrategy2) {
            this.retryStrategy = retryStrategy2;
            return this;
        }

        public Builder setReplaceCurrent(boolean z) {
            this.replaceCurrent = z;
            return this;
        }

        public Builder setTriggerReason(TriggerReason triggerReason2) {
            this.triggerReason = triggerReason2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        JobInvocation jobInvocation = (JobInvocation) obj;
        if (!this.f52123a.equals(jobInvocation.f52123a) || !this.f52124b.equals(jobInvocation.f52124b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f52123a.hashCode() * 31) + this.f52124b.hashCode();
    }

    public String toString() {
        return "JobInvocation{tag='" + JSONObject.quote(this.f52123a) + '\'' + ", service='" + this.f52124b + '\'' + ", trigger=" + this.f52125c + ", recurring=" + this.f52126d + ", lifetime=" + this.f52127e + ", constraints=" + Arrays.toString(this.f52128f) + ", extras=" + this.f52129g + ", retryStrategy=" + this.f52130h + ", replaceCurrent=" + this.f52131i + ", triggerReason=" + this.f52132j + '}';
    }
}
