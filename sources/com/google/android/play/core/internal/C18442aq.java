package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C18619i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.internal.aq */
public final class C18442aq<T extends IInterface> {

    /* renamed from: a */
    private static final Map<String, Handler> f53139a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f53140b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C18432ag f53141c;

    /* renamed from: d */
    private final String f53142d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<C18433ah> f53143e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f53144f;

    /* renamed from: g */
    private final Intent f53145g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C18438am<T> f53146h;

    /* renamed from: i */
    private final WeakReference<C18437al> f53147i;

    /* renamed from: j */
    private final IBinder.DeathRecipient f53148j = new C18434ai(this);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ServiceConnection f53149k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public T f53150l;

    public C18442aq(Context context, C18432ag agVar, String str, Intent intent, C18438am<T> amVar) {
        this.f53140b = context;
        this.f53141c = agVar;
        this.f53142d = str;
        this.f53145g = intent;
        this.f53146h = amVar;
        this.f53147i = new WeakReference<>((Object) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m37769a(C18442aq aqVar, C18433ah ahVar) {
        if (aqVar.f53150l == null && !aqVar.f53144f) {
            aqVar.f53141c.mo149084c("Initiate binding to the service.", new Object[0]);
            aqVar.f53143e.add(ahVar);
            C18441ap apVar = new C18441ap(aqVar);
            aqVar.f53149k = apVar;
            aqVar.f53144f = true;
            if (!aqVar.f53140b.bindService(aqVar.f53145g, apVar, 1)) {
                aqVar.f53141c.mo149084c("Failed to bind to the service.", new Object[0]);
                aqVar.f53144f = false;
                for (C18433ah b : aqVar.f53143e) {
                    C18619i<?> b2 = b.mo149086b();
                    if (b2 != null) {
                        b2.mo149341b((Exception) new C18443ar());
                    }
                }
                aqVar.f53143e.clear();
            }
        } else if (aqVar.f53144f) {
            aqVar.f53141c.mo149084c("Waiting to bind to the service.", new Object[0]);
            aqVar.f53143e.add(ahVar);
        } else {
            ahVar.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m37771b(C18433ah ahVar) {
        Handler handler;
        synchronized (f53139a) {
            if (!f53139a.containsKey(this.f53142d)) {
                HandlerThread handlerThread = new HandlerThread(this.f53142d, 10);
                handlerThread.start();
                f53139a.put(this.f53142d, new Handler(handlerThread.getLooper()));
            }
            handler = f53139a.get(this.f53142d);
        }
        handler.post(ahVar);
    }

    /* renamed from: f */
    static /* synthetic */ void m37776f(C18442aq aqVar) {
        aqVar.f53141c.mo149084c("linkToDeath", new Object[0]);
        try {
            aqVar.f53150l.asBinder().linkToDeath(aqVar.f53148j, 0);
        } catch (RemoteException e) {
            aqVar.f53141c.mo149082a((Throwable) e, "linkToDeath failed", new Object[0]);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m37778h(C18442aq aqVar) {
        aqVar.f53141c.mo149084c("unlinkToDeath", new Object[0]);
        aqVar.f53150l.asBinder().unlinkToDeath(aqVar.f53148j, 0);
    }

    /* renamed from: a */
    public final void mo149092a() {
        m37771b((C18433ah) new C18436ak(this));
    }

    /* renamed from: a */
    public final void mo149093a(C18433ah ahVar) {
        m37771b((C18433ah) new C18435aj(this, ahVar.mo149086b(), ahVar));
    }

    /* renamed from: b */
    public final T mo149094b() {
        return this.f53150l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo149095c() {
        this.f53141c.mo149084c("reportBinderDeath", new Object[0]);
        C18437al alVar = (C18437al) this.f53147i.get();
        if (alVar == null) {
            this.f53141c.mo149084c("%s : Binder has died.", this.f53142d);
            for (C18433ah b : this.f53143e) {
                C18619i<?> b2 = b.mo149086b();
                if (b2 != null) {
                    b2.mo149341b((Exception) Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.f53142d).concat(" : Binder has died.")));
                }
            }
            this.f53143e.clear();
            return;
        }
        this.f53141c.mo149084c("calling onBinderDied", new Object[0]);
        alVar.mo149089a();
    }
}
