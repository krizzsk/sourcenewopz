package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18448aw;
import com.google.android.play.core.splitcompat.C18546p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.play.core.listener.b */
public abstract class C18519b<StateT> {

    /* renamed from: a */
    protected final C18432ag f53193a;

    /* renamed from: b */
    protected final Set<StateUpdatedListener<StateT>> f53194b = new HashSet();

    /* renamed from: c */
    private final IntentFilter f53195c;

    /* renamed from: d */
    private final Context f53196d;

    /* renamed from: e */
    private C18518a f53197e = null;

    /* renamed from: f */
    private volatile boolean f53198f = false;

    protected C18519b(C18432ag agVar, IntentFilter intentFilter, Context context) {
        this.f53193a = agVar;
        this.f53195c = intentFilter;
        this.f53196d = C18546p.m38075a(context);
    }

    /* renamed from: c */
    private final void m38000c() {
        C18518a aVar;
        if ((this.f53198f || !this.f53194b.isEmpty()) && this.f53197e == null) {
            C18518a aVar2 = new C18518a(this);
            this.f53197e = aVar2;
            try {
                this.f53196d.registerReceiver(aVar2, this.f53195c);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
        if (!this.f53198f && this.f53194b.isEmpty() && (aVar = this.f53197e) != null) {
            try {
                this.f53196d.unregisterReceiver(aVar);
            } catch (Exception e2) {
                Log.d("Context", "unregisterReceiver", e2);
            }
            this.f53197e = null;
        }
    }

    /* renamed from: a */
    public final synchronized void mo149187a() {
        this.f53193a.mo149084c("clearListeners", new Object[0]);
        this.f53194b.clear();
        m38000c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo148800a(Context context, Intent intent);

    /* renamed from: a */
    public final synchronized void mo149188a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f53193a.mo149084c("registerListener", new Object[0]);
        C18448aw.m37797a(stateUpdatedListener, (Object) "Registered Play Core listener should not be null.");
        this.f53194b.add(stateUpdatedListener);
        m38000c();
    }

    /* renamed from: a */
    public final synchronized void mo149189a(StateT statet) {
        Iterator it = new HashSet(this.f53194b).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    /* renamed from: a */
    public final synchronized void mo149190a(boolean z) {
        this.f53198f = z;
        m38000c();
    }

    /* renamed from: b */
    public final synchronized void mo149191b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f53193a.mo149084c("unregisterListener", new Object[0]);
        C18448aw.m37797a(stateUpdatedListener, (Object) "Unregistered Play Core listener should not be null.");
        this.f53194b.remove(stateUpdatedListener);
        m38000c();
    }

    /* renamed from: b */
    public final synchronized boolean mo149192b() {
        return this.f53197e != null;
    }
}
