package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ap */
final class C18441ap implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C18442aq f53138a;

    /* synthetic */ C18441ap(C18442aq aqVar) {
        this.f53138a = aqVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f53138a.f53141c.mo149084c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f53138a.m37771b((C18433ah) new C18439an(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f53138a.f53141c.mo149084c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f53138a.m37771b((C18433ah) new C18440ao(this));
    }
}
