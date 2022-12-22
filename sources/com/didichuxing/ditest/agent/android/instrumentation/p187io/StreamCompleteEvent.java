package com.didichuxing.ditest.agent.android.instrumentation.p187io;

import java.util.EventObject;

/* renamed from: com.didichuxing.ditest.agent.android.instrumentation.io.StreamCompleteEvent */
public final class StreamCompleteEvent extends EventObject {
    private static final long serialVersionUID = 1;
    private final long bytes;
    private final Exception exception;

    public StreamCompleteEvent(Object obj, long j, Exception exc) {
        super(obj);
        this.bytes = j;
        this.exception = exc;
    }

    public StreamCompleteEvent(Object obj, long j) {
        this(obj, j, (Exception) null);
    }

    public long getBytes() {
        return this.bytes;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean isError() {
        return this.exception != null;
    }
}
