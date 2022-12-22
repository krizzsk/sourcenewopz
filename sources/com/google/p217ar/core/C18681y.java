package com.google.p217ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.p209a.p211b.p212a.p213a.p214a.C17882e;
import com.google.p217ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.ar.core.y */
/* compiled from: InstallServiceImpl */
final class C18681y extends C17882e {

    /* renamed from: a */
    private final /* synthetic */ AtomicBoolean f53576a;

    /* renamed from: b */
    private final /* synthetic */ C18678v f53577b;

    C18681y(C18678v vVar, AtomicBoolean atomicBoolean) {
        this.f53577b = vVar;
        this.f53576a = atomicBoolean;
    }

    /* renamed from: a */
    public final void mo132629a() throws RemoteException {
    }

    /* renamed from: b */
    public final void mo132631b(Bundle bundle) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo132630a(Bundle bundle) throws RemoteException {
        if (!this.f53576a.getAndSet(true)) {
            int i = bundle.getInt("error.code", -100);
            int i2 = bundle.getInt("install.status", 0);
            if (i2 == 4) {
                this.f53577b.f53570b.mo149646a(C18672o.COMPLETED);
            } else if (i != 0) {
                StringBuilder sb = new StringBuilder(51);
                sb.append("requestInstall = ");
                sb.append(i);
                sb.append(", launching fullscreen.");
                SystemUtils.log(5, "ARCore-InstallService", sb.toString(), (Throwable) null, "com.google.ar.core.y", 12);
                C18673p.m38311b(this.f53577b.f53569a, this.f53577b.f53570b);
            } else if (bundle.containsKey("resolution.intent")) {
                C18673p.m38302a(this.f53577b.f53569a, bundle, this.f53577b.f53570b);
            } else if (i2 != 10) {
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                        this.f53577b.f53570b.mo149646a(C18672o.ACCEPTED);
                        return;
                    case 4:
                        this.f53577b.f53570b.mo149646a(C18672o.COMPLETED);
                        return;
                    case 5:
                        this.f53577b.f53570b.mo149647a((Exception) new FatalException("Unexpected FAILED install status without error."));
                        return;
                    case 6:
                        this.f53577b.f53570b.mo149646a(C18672o.CANCELLED);
                        return;
                    default:
                        C18675s sVar = this.f53577b.f53570b;
                        StringBuilder sb2 = new StringBuilder(38);
                        sb2.append("Unexpected install status: ");
                        sb2.append(i2);
                        sVar.mo149647a((Exception) new FatalException(sb2.toString()));
                        return;
                }
            } else {
                this.f53577b.f53570b.mo149647a((Exception) new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
            }
        }
    }
}
