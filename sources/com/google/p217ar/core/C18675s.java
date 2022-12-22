package com.google.p217ar.core;

import com.google.p217ar.core.exceptions.UnavailableException;
import com.google.p217ar.core.exceptions.UnavailableUserDeclinedInstallationException;

/* renamed from: com.google.ar.core.s */
/* compiled from: InstallService */
class C18675s {

    /* renamed from: a */
    boolean f53563a = false;

    /* renamed from: b */
    final /* synthetic */ InstallActivity f53564b;

    /* renamed from: a */
    public void mo149646a(C18672o oVar) {
        synchronized (this.f53564b) {
            if (!this.f53563a) {
                C18672o unused = this.f53564b.lastEvent = oVar;
                int ordinal = oVar.ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        this.f53564b.finishWithFailure(new UnavailableUserDeclinedInstallationException());
                    } else if (ordinal == 2) {
                        if (!this.f53564b.waitingForCompletion) {
                            this.f53564b.closeInstaller();
                        }
                        this.f53564b.finishWithFailure((Exception) null);
                    }
                    this.f53563a = true;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo149647a(Exception exc) {
        synchronized (this.f53564b) {
            if (!this.f53563a) {
                this.f53563a = true;
                C18672o unused = this.f53564b.lastEvent = C18672o.CANCELLED;
                boolean z = exc instanceof UnavailableException;
                this.f53564b.finishWithFailure(exc);
            }
        }
    }

    C18675s(InstallActivity installActivity) {
        this.f53564b = installActivity;
    }
}
