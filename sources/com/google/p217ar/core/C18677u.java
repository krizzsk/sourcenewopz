package com.google.p217ar.core;

import android.content.Context;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.p217ar.core.ArCoreApk;

/* renamed from: com.google.ar.core.u */
/* compiled from: InstallServiceImpl */
final class C18677u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArCoreApk.C18625a f53566a;

    /* renamed from: b */
    private final /* synthetic */ Context f53567b;

    /* renamed from: c */
    private final /* synthetic */ C18673p f53568c;

    C18677u(C18673p pVar, Context context, ArCoreApk.C18625a aVar) {
        this.f53568c = pVar;
        this.f53567b = context;
        this.f53566a = aVar;
    }

    public final void run() {
        try {
            this.f53568c.f53557d.mo132627a(this.f53567b.getApplicationInfo().packageName, C18673p.m38309b(), new C18676t(this));
        } catch (RemoteException e) {
            SystemUtils.log(6, "ARCore-InstallService", "requestInfo threw", e, "com.google.ar.core.u", 8);
            this.f53566a.mo149385a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
