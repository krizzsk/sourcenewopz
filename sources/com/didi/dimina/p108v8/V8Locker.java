package com.didi.dimina.p108v8;

/* renamed from: com.didi.dimina.v8.V8Locker */
public class V8Locker {
    private boolean released = false;
    private C7781V8 runtime;
    private Thread thread = null;

    V8Locker(C7781V8 v8) {
        this.runtime = v8;
        acquire();
    }

    public Thread getThread() {
        return this.thread;
    }

    public synchronized void acquire() {
        if (this.thread != null) {
            if (this.thread != Thread.currentThread()) {
                throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
            }
        }
        if (this.thread != Thread.currentThread()) {
            this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
            this.thread = Thread.currentThread();
            this.released = false;
        }
    }

    public synchronized boolean tryAcquire() {
        if (this.thread != null && this.thread != Thread.currentThread()) {
            return false;
        }
        if (this.thread == Thread.currentThread()) {
            return true;
        }
        this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
        this.thread = Thread.currentThread();
        this.released = false;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void release() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.released     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0009
            java.lang.Thread r0 = r3.thread     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0011
        L_0x0009:
            com.didi.dimina.v8.V8 r0 = r3.runtime     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isReleased()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0013
        L_0x0011:
            monitor-exit(r3)
            return
        L_0x0013:
            r3.checkThread()     // Catch:{ all -> 0x0029 }
            com.didi.dimina.v8.V8 r0 = r3.runtime     // Catch:{ all -> 0x0029 }
            com.didi.dimina.v8.V8 r1 = r3.runtime     // Catch:{ all -> 0x0029 }
            long r1 = r1.getV8RuntimePtr()     // Catch:{ all -> 0x0029 }
            r0.releaseLock(r1)     // Catch:{ all -> 0x0029 }
            r0 = 0
            r3.thread = r0     // Catch:{ all -> 0x0029 }
            r0 = 1
            r3.released = r0     // Catch:{ all -> 0x0029 }
            monitor-exit(r3)
            return
        L_0x0029:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.p108v8.V8Locker.release():void");
    }

    public void checkThread() {
        if (this.released && this.thread == null) {
            throw new Error("Invalid V8 thread access: the locker has been released!");
        } else if (this.thread != Thread.currentThread()) {
            throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
        }
    }

    public boolean hasLock() {
        return this.thread == Thread.currentThread();
    }
}
