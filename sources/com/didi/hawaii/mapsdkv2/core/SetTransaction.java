package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.view.RenderTask;

public final class SetTransaction extends RenderTask {

    /* renamed from: a */
    static final /* synthetic */ boolean f23988a = (!SetTransaction.class.desiredAssertionStatus());

    /* renamed from: b */
    private final GLViewParent f23989b;

    /* renamed from: c */
    private SetTransaction f23990c;

    /* renamed from: d */
    private SetTransaction f23991d;

    /* renamed from: e */
    private SetTransaction f23992e = this;

    /* renamed from: f */
    private Runnable f23993f;

    /* renamed from: g */
    private boolean f23994g = false;

    /* renamed from: h */
    private final Thread f23995h;

    SetTransaction(Runnable runnable, GLViewParent gLViewParent) {
        this.f23993f = runnable;
        this.f23989b = gLViewParent;
        this.f23995h = Thread.currentThread();
    }

    public void chain(Runnable runnable) {
        m17069a();
        if (this.f23993f == null) {
            this.f23993f = runnable;
            return;
        }
        this.f23992e.f23990c = new SetTransaction(runnable, this.f23989b);
        SetTransaction setTransaction = this.f23992e.f23990c;
        setTransaction.f23991d = this;
        this.f23992e = setTransaction;
    }

    public boolean commit() {
        m17069a();
        if (this.f23994g) {
            return false;
        }
        this.f23994g = true;
        return this.f23989b.postToRenderThread((RenderTask) this);
    }

    public void run() {
        Runnable runnable = this.f23993f;
        if (runnable != null) {
            runnable.run();
        }
        SetTransaction setTransaction = this.f23990c;
        if (setTransaction != null) {
            setTransaction.run();
        }
    }

    /* renamed from: a */
    private void m17069a() {
        if (Thread.currentThread() != this.f23995h) {
            throw new IllegalStateException("All setTransaction must be in the same thread");
        }
    }

    public String toString() {
        m17069a();
        SetTransaction setTransaction = this;
        while (true) {
            SetTransaction setTransaction2 = setTransaction.f23991d;
            if (setTransaction2 == null) {
                break;
            }
            setTransaction = setTransaction2;
        }
        StringBuilder sb = new StringBuilder();
        while (setTransaction.f23990c != null) {
            sb.append(setTransaction.m17070b());
            sb.append(" -> ");
            setTransaction = setTransaction.f23990c;
            if (!f23988a && setTransaction == null) {
                throw new AssertionError();
            }
        }
        sb.append(setTransaction.m17070b());
        return sb.toString();
    }

    /* renamed from: b */
    private String m17070b() {
        return super.toString();
    }
}
