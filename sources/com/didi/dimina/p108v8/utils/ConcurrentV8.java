package com.didi.dimina.p108v8.utils;

import com.didi.dimina.p108v8.C7781V8;

/* renamed from: com.didi.dimina.v8.utils.ConcurrentV8 */
public final class ConcurrentV8 {

    /* renamed from: v8 */
    private C7781V8 f18204v8 = null;

    public ConcurrentV8() {
        C7781V8 createV8Runtime = C7781V8.createV8Runtime();
        this.f18204v8 = createV8Runtime;
        createV8Runtime.getLocker().release();
    }

    public C7781V8 getV8() {
        return this.f18204v8;
    }

    public synchronized void run(V8Runnable v8Runnable) {
        try {
            this.f18204v8.getLocker().acquire();
            v8Runnable.run(this.f18204v8);
            if (!(this.f18204v8 == null || this.f18204v8.getLocker() == null || !this.f18204v8.getLocker().hasLock())) {
                this.f18204v8.getLocker().release();
            }
        } catch (Throwable th) {
            if (!(this.f18204v8 == null || this.f18204v8.getLocker() == null || !this.f18204v8.getLocker().hasLock())) {
                this.f18204v8.getLocker().release();
            }
            throw th;
        }
    }

    public void release() {
        C7781V8 v8 = this.f18204v8;
        if (v8 != null && !v8.isReleased()) {
            run(new V8Runnable() {
                public void run(C7781V8 v8) {
                    if (v8 != null && !v8.isReleased()) {
                        v8.close();
                    }
                }
            });
        }
    }
}
