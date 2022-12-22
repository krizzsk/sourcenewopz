package com.google.p217ar.core;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.p209a.p211b.p212a.p213a.p214a.C17878a;
import com.google.p209a.p211b.p212a.p213a.p214a.C17879b;
import com.google.p217ar.core.ArCoreApk;
import com.google.p217ar.core.exceptions.FatalException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.ar.core.p */
/* compiled from: InstallService */
class C18673p {

    /* renamed from: a */
    private final Queue<Runnable> f53554a;

    /* renamed from: b */
    private Context f53555b;

    /* renamed from: c */
    private volatile int f53556c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C17879b f53557d;

    /* renamed from: e */
    private BroadcastReceiver f53558e;

    /* renamed from: f */
    private Context f53559f;

    /* renamed from: g */
    private final ServiceConnection f53560g;

    /* renamed from: h */
    private final AtomicReference<C18682z> f53561h;

    C18673p() {
    }

    /* renamed from: a */
    public synchronized void mo149642a(Context context) {
        this.f53555b = context;
        if (context.bindService(new Intent("com.google.android.play.core.install.BIND_INSTALL_SERVICE").setPackage("com.android.vending"), this.f53560g, 1)) {
            this.f53556c = C18637aa.f53500b;
            return;
        }
        this.f53556c = C18637aa.f53499a;
        this.f53555b = null;
        SystemUtils.log(5, "ARCore-InstallService", "bindService returned false.", (Throwable) null, "com.google.ar.core.p", 9);
        context.unbindService(this.f53560g);
    }

    /* renamed from: a */
    public synchronized void mo149640a() {
        m38313c();
        int i = this.f53556c - 1;
        if (i == 1 || i == 2) {
            this.f53555b.unbindService(this.f53560g);
            this.f53555b = null;
            this.f53556c = C18637aa.f53499a;
        }
        if (this.f53558e != null) {
            try {
                this.f53559f.unregisterReceiver(this.f53558e);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        }
        return;
    }

    /* renamed from: a */
    public synchronized void mo149643a(Context context, ArCoreApk.C18625a aVar) {
        try {
            m38308a((Runnable) new C18677u(this, context, aVar));
        } catch (C18638ab unused) {
            SystemUtils.log(6, "ARCore-InstallService", "Play Store install service could not be bound.", (Throwable) null, "com.google.ar.core.p", 24);
            aVar.mo149385a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }

    /* renamed from: a */
    public void mo149641a(Activity activity, C18675s sVar) {
        C18682z zVar = new C18682z(activity, sVar);
        C18682z andSet = this.f53561h.getAndSet(zVar);
        if (andSet != null) {
            andSet.mo149652a();
        }
        zVar.start();
        if (this.f53558e == null) {
            C18679w wVar = new C18679w(this, sVar);
            this.f53558e = wVar;
            this.f53559f = activity;
            try {
                activity.registerReceiver(wVar, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
        try {
            m38308a((Runnable) new C18678v(this, activity, sVar));
        } catch (C18638ab unused) {
            SystemUtils.log(5, "ARCore-InstallService", "requestInstall bind failed, launching fullscreen.", (Throwable) null, "com.google.ar.core.p", 39);
            m38311b(activity, sVar);
        }
    }

    C18673p(byte b) {
        this();
        this.f53554a = new ArrayDeque();
        this.f53556c = C18637aa.f53499a;
        this.f53560g = new C18674q(this);
        this.f53561h = new AtomicReference<>();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m38311b(Activity activity, C18675s sVar) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ar.core")));
        } catch (ActivityNotFoundException e) {
            sVar.mo149647a((Exception) new FatalException("Failed to launch installer.", e));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m38302a(Activity activity, Bundle bundle, C18675s sVar) {
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("resolution.intent");
        if (pendingIntent != null) {
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1234, new Intent(activity, activity.getClass()), 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                sVar.mo149647a((Exception) new FatalException("Installation Intent failed", e));
            }
        } else {
            SystemUtils.log(6, "ARCore-InstallService", "Did not get pending intent.", (Throwable) null, "com.google.ar.core.p", 64);
            sVar.mo149647a((Exception) new FatalException("Installation intent failed to unparcel."));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Bundle m38309b() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("package.name", "com.google.ar.core");
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m38313c() {
        C18682z andSet = this.f53561h.getAndSet((Object) null);
        if (andSet != null) {
            andSet.mo149652a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m38303a(IBinder iBinder) {
        C17879b a = C17878a.m37324a(iBinder);
        SystemUtils.log(4, "ARCore-InstallService", "Install service connected", (Throwable) null, "com.google.ar.core.p", 75);
        this.f53557d = a;
        this.f53556c = C18637aa.f53501c;
        for (Runnable run : this.f53554a) {
            run.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m38314d() {
        SystemUtils.log(4, "ARCore-InstallService", "Install service disconnected", (Throwable) null, "com.google.ar.core.p", 82);
        this.f53556c = C18637aa.f53499a;
        this.f53557d = null;
        m38313c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m38308a(java.lang.Runnable r3) throws com.google.p217ar.core.C18638ab {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f53556c     // Catch:{ all -> 0x001f }
            r1 = 1
            int r0 = r0 - r1
            if (r0 == 0) goto L_0x0019
            if (r0 == r1) goto L_0x0012
            r1 = 2
            if (r0 == r1) goto L_0x000d
            goto L_0x0010
        L_0x000d:
            r3.run()     // Catch:{ all -> 0x001f }
        L_0x0010:
            monitor-exit(r2)
            return
        L_0x0012:
            java.util.Queue<java.lang.Runnable> r0 = r2.f53554a     // Catch:{ all -> 0x001f }
            r0.offer(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r2)
            return
        L_0x0019:
            com.google.ar.core.ab r3 = new com.google.ar.core.ab     // Catch:{ all -> 0x001f }
            r3.<init>()     // Catch:{ all -> 0x001f }
            throw r3     // Catch:{ all -> 0x001f }
        L_0x001f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p217ar.core.C18673p.m38308a(java.lang.Runnable):void");
    }
}
