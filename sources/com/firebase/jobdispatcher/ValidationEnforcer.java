package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

public class ValidationEnforcer implements JobValidator {

    /* renamed from: a */
    private final JobValidator f52145a;

    public ValidationEnforcer(JobValidator jobValidator) {
        this.f52145a = jobValidator;
    }

    public List<String> validate(JobParameters jobParameters) {
        return this.f52145a.validate(jobParameters);
    }

    public List<String> validate(JobTrigger jobTrigger) {
        return this.f52145a.validate(jobTrigger);
    }

    public List<String> validate(RetryStrategy retryStrategy) {
        return this.f52145a.validate(retryStrategy);
    }

    public final boolean isValid(JobParameters jobParameters) {
        return validate(jobParameters) == null;
    }

    public final boolean isValid(JobTrigger jobTrigger) {
        return validate(jobTrigger) == null;
    }

    public final boolean isValid(RetryStrategy retryStrategy) {
        return validate(retryStrategy) == null;
    }

    public final void ensureValid(JobParameters jobParameters) {
        m37213a(validate(jobParameters));
    }

    public final void ensureValid(JobTrigger jobTrigger) {
        m37213a(validate(jobTrigger));
    }

    public final void ensureValid(RetryStrategy retryStrategy) {
        m37213a(validate(retryStrategy));
    }

    /* renamed from: a */
    private static void m37213a(List<String> list) {
        if (list != null) {
            throw new ValidationException("JobParameters is invalid", list);
        }
    }

    public static final class ValidationException extends RuntimeException {
        private final List<String> errors;

        public ValidationException(String str, List<String> list) {
            super(str + ": " + TextUtils.join("\n  - ", list));
            this.errors = list;
        }

        public List<String> getErrors() {
            return this.errors;
        }
    }
}
