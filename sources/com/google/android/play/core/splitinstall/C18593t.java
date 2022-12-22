package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.listener.C18519b;

/* renamed from: com.google.android.play.core.splitinstall.t */
public final class C18593t extends C18519b<SplitInstallSessionState> {

    /* renamed from: c */
    private static C18593t f53345c;

    /* renamed from: d */
    private final Handler f53346d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final C18577e f53347e;

    public C18593t(Context context, C18577e eVar) {
        super(new C18432ag("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f53347e = eVar;
    }

    /* renamed from: a */
    public static synchronized C18593t m38179a(Context context) {
        C18593t tVar;
        synchronized (C18593t.class) {
            if (f53345c == null) {
                f53345c = new C18593t(context, C18584l.f53328a);
            }
            tVar = f53345c;
        }
        return tVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148800a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState a = SplitInstallSessionState.m38082a(bundleExtra);
            this.f53193a.mo149081a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            C18578f a2 = this.f53347e.mo149295a();
            if (a.status() != 3 || a2 == null) {
                mo149189a(a);
            } else {
                a2.mo149097a(a.mo149266c(), new C18591r(this, a, intent, context));
            }
        }
    }
}
