package com.iproov.sdk;

import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.IProovException;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import p068new.C2408case;
import p068new.C2409do;
import p068new.C2410else;
import p068new.C2411for;
import p068new.C2412goto;
import p068new.C2413if;
import p068new.C2414new;
import p068new.C2415try;
import p093switch.C3127throw;

/* renamed from: com.iproov.sdk.a */
/* compiled from: ListenerDelegate */
class C19763a implements IProov.Listener {

    /* renamed from: a */
    private C2408case f53996a;

    /* renamed from: b */
    private Set<IProov.Listener> f53997b = Collections.newSetFromMap(new WeakHashMap());

    C19763a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo161866a(IProov.Listener listener) {
        this.f53997b.remove(listener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo161869a() {
        return !this.f53997b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo161870b() {
        this.f53996a = null;
    }

    public void onCancelled() {
        m38650b((C2408case) new C2409do());
    }

    public void onConnected() {
        m38650b((C2408case) new C2413if());
    }

    public void onConnecting() {
        m38650b((C2408case) new C2411for());
    }

    public void onError(IProovException iProovException) {
        m38650b((C2408case) new C2414new(iProovException));
    }

    public void onFailure(IProov.FailureResult failureResult) {
        m38650b((C2408case) new C2415try(failureResult));
    }

    public void onProcessing(double d, String str) {
        m38650b((C2408case) new C2410else(d, str));
    }

    public void onSuccess(IProov.SuccessResult successResult) {
        m38650b((C2408case) new C2412goto(successResult));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo161867a(IProov.Listener listener, boolean z) {
        this.f53997b.add(listener);
        if (z) {
            mo161871b(listener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo161871b(IProov.Listener listener) {
        if (listener != null) {
            C3127throw.m4052do((Runnable) new Runnable(listener) {
                public final /* synthetic */ IProov.Listener f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19763a.this.m38651c(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo161868a(C2408case caseR) {
        this.f53996a = caseR;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m38651c(IProov.Listener listener) {
        synchronized (this) {
            C2408case caseR = this.f53996a;
            if (caseR != null) {
                caseR.mo24584do(listener);
            }
        }
    }

    /* renamed from: b */
    private void m38650b(C2408case caseR) {
        mo161868a(caseR);
        synchronized (this) {
            for (IProov.Listener r1 : this.f53997b) {
                C3127throw.m4052do((Runnable) new Runnable(r1) {
                    public final /* synthetic */ IProov.Listener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        C2408case.this.mo24584do(this.f$1);
                    }
                });
            }
        }
        if (caseR.mo24585do()) {
            IProov.f53987a.set(false);
            IProov.f53988b = null;
        }
    }
}
