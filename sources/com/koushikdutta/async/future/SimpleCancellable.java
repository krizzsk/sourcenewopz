package com.koushikdutta.async.future;

public class SimpleCancellable implements DependentCancellable {
    public static final Cancellable CANCELLED = new SimpleCancellable() {
        {
            cancel();
        }
    };
    public static final Cancellable COMPLETED = new SimpleCancellable() {
        {
            setComplete();
        }
    };
    boolean cancelled;
    boolean complete;
    private Cancellable parent;

    /* access modifiers changed from: protected */
    public void cancelCleanup() {
    }

    /* access modifiers changed from: protected */
    public void cleanup() {
    }

    /* access modifiers changed from: protected */
    public void completeCleanup() {
    }

    public boolean isDone() {
        return this.complete;
    }

    public boolean setComplete() {
        synchronized (this) {
            if (this.cancelled) {
                return false;
            }
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.parent = null;
            completeCleanup();
            cleanup();
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        if (r0 == null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
        r0.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        cancelCleanup();
        cleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.complete     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0008
            r0 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            return r0
        L_0x0008:
            boolean r0 = r3.cancelled     // Catch:{ all -> 0x0023 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            return r1
        L_0x000f:
            r3.cancelled = r1     // Catch:{ all -> 0x0023 }
            com.koushikdutta.async.future.Cancellable r0 = r3.parent     // Catch:{ all -> 0x0023 }
            r2 = 0
            r3.parent = r2     // Catch:{ all -> 0x0023 }
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x001c
            r0.cancel()
        L_0x001c:
            r3.cancelCleanup()
            r3.cleanup()
            return r1
        L_0x0023:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.future.SimpleCancellable.cancel():boolean");
    }

    public boolean setParent(Cancellable cancellable) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.parent = cancellable;
            return true;
        }
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this) {
            if (!this.cancelled) {
                if (this.parent == null || !this.parent.isCancelled()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public Cancellable reset() {
        cancel();
        this.complete = false;
        this.cancelled = false;
        return this;
    }
}
