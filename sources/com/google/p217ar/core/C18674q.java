package com.google.p217ar.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.ar.core.q */
/* compiled from: InstallServiceImpl */
final class C18674q implements ServiceConnection {

    /* renamed from: a */
    private final /* synthetic */ C18673p f53562a;

    C18674q(C18673p pVar) {
        this.f53562a = pVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f53562a.m38303a(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f53562a.m38314d();
    }
}
