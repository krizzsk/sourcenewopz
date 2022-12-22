package com.google.android.datatransport.runtime.backends;

public abstract class BackendResponse {

    public enum Status {
        f52592OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public abstract long getNextRequestWaitMillis();

    public abstract Status getStatus();

    public static BackendResponse transientError() {
        return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1);
    }

    public static BackendResponse fatalError() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1);
    }

    /* renamed from: ok */
    public static BackendResponse m37335ok(long j) {
        return new AutoValue_BackendResponse(Status.f52592OK, j);
    }
}
