package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.splitinstall.ar */
final class C18566ar extends C18569au<SplitInstallSessionState> {
    C18566ar(C18570av avVar, C18619i<SplitInstallSessionState> iVar) {
        super(avVar, iVar);
    }

    /* renamed from: b */
    public final void mo149126b(int i, Bundle bundle) throws RemoteException {
        super.mo149126b(i, bundle);
        this.f53299a.mo149342b(SplitInstallSessionState.m38082a(bundle));
    }
}
