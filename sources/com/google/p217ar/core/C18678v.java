package com.google.p217ar.core;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.ar.core.v */
/* compiled from: InstallServiceImpl */
final class C18678v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f53569a;

    /* renamed from: b */
    final /* synthetic */ C18675s f53570b;

    /* renamed from: c */
    final /* synthetic */ C18673p f53571c;

    C18678v(C18673p pVar, Activity activity, C18675s sVar) {
        this.f53571c = pVar;
        this.f53569a = activity;
        this.f53570b = sVar;
    }

    public final void run() {
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.f53571c.f53557d.mo132628a(this.f53569a.getApplicationInfo().packageName, Collections.singletonList(C18673p.m38309b()), new Bundle(), new C18681y(this, atomicBoolean));
            new Handler().postDelayed(new C18680x(this, atomicBoolean), 3000);
        } catch (RemoteException e) {
            SystemUtils.log(5, "ARCore-InstallService", "requestInstall threw, launching fullscreen.", e, "com.google.ar.core.v", 11);
            C18673p.m38311b(this.f53569a, this.f53570b);
        }
    }
}
