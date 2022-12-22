package com.koushikdutta.async.future;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import java.util.LinkedList;

public class Continuation extends SimpleCancellable implements ContinuationCallback, Cancellable, Runnable {

    /* renamed from: a */
    CompletedCallback f55249a;

    /* renamed from: b */
    Runnable f55250b;

    /* renamed from: c */
    LinkedList<ContinuationCallback> f55251c;

    /* renamed from: d */
    boolean f55252d;

    /* renamed from: e */
    private boolean f55253e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f55254f;

    public CompletedCallback getCallback() {
        return this.f55249a;
    }

    public void setCallback(CompletedCallback completedCallback) {
        this.f55249a = completedCallback;
    }

    public Runnable getCancelCallback() {
        return this.f55250b;
    }

    public void setCancelCallback(Runnable runnable) {
        this.f55250b = runnable;
    }

    public void setCancelCallback(final Cancellable cancellable) {
        if (cancellable == null) {
            this.f55250b = null;
        } else {
            this.f55250b = new Runnable() {
                public void run() {
                    cancellable.cancel();
                }
            };
        }
    }

    public Continuation() {
        this((CompletedCallback) null);
    }

    public Continuation(CompletedCallback completedCallback) {
        this(completedCallback, (Runnable) null);
    }

    public Continuation(CompletedCallback completedCallback, Runnable runnable) {
        this.f55251c = new LinkedList<>();
        this.f55250b = runnable;
        this.f55249a = completedCallback;
    }

    /* renamed from: a */
    private CompletedCallback m39793a() {
        return new CompletedCallback() {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            boolean mThisCompleted;

            static {
                Class<Continuation> cls = Continuation.class;
            }

            public void onCompleted(Exception exc) {
                if (!this.mThisCompleted) {
                    this.mThisCompleted = true;
                    boolean unused = Continuation.this.f55254f = false;
                    if (exc == null) {
                        Continuation.this.m39797b();
                    } else {
                        Continuation.this.mo163938a(exc);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo163938a(Exception exc) {
        CompletedCallback completedCallback;
        if (setComplete() && (completedCallback = this.f55249a) != null) {
            completedCallback.onCompleted(exc);
        }
    }

    /* renamed from: a */
    private ContinuationCallback m39794a(ContinuationCallback continuationCallback) {
        if (continuationCallback instanceof DependentCancellable) {
            ((DependentCancellable) continuationCallback).setParent(this);
        }
        return continuationCallback;
    }

    public Continuation add(ContinuationCallback continuationCallback) {
        this.f55251c.add(m39794a(continuationCallback));
        return this;
    }

    public Continuation insert(ContinuationCallback continuationCallback) {
        this.f55251c.add(0, m39794a(continuationCallback));
        return this;
    }

    public Continuation add(final DependentFuture dependentFuture) {
        dependentFuture.setParent(this);
        add((ContinuationCallback) new ContinuationCallback() {
            public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
                dependentFuture.get();
                completedCallback.onCompleted((Exception) null);
            }
        });
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m39797b() {
        if (!this.f55253e) {
            while (this.f55251c.size() > 0 && !this.f55254f && !isDone() && !isCancelled()) {
                ContinuationCallback remove = this.f55251c.remove();
                try {
                    this.f55253e = true;
                    this.f55254f = true;
                    remove.onContinue(this, m39793a());
                } catch (Exception e) {
                    mo163938a(e);
                } catch (Throwable th) {
                    this.f55253e = false;
                    throw th;
                }
                this.f55253e = false;
            }
            if (!this.f55254f && !isDone() && !isCancelled()) {
                mo163938a((Exception) null);
            }
        }
    }

    public boolean cancel() {
        if (!super.cancel()) {
            return false;
        }
        Runnable runnable = this.f55250b;
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    public Continuation start() {
        if (!this.f55252d) {
            this.f55252d = true;
            m39797b();
            return this;
        }
        throw new IllegalStateException("already started");
    }

    public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
        setCallback(completedCallback);
        start();
    }

    public void run() {
        start();
    }
}
