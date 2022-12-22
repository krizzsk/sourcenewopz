package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.appupdate.o */
final class C18279o extends C18277m<AppUpdateInfo> {

    /* renamed from: d */
    final /* synthetic */ C18280p f52642d;

    /* renamed from: e */
    private final String f52643e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18279o(C18280p pVar, C18619i<AppUpdateInfo> iVar, String str) {
        super(pVar, new C18432ag("OnRequestInstallCallback"), iVar);
        this.f52642d = pVar;
        this.f52643e = str;
    }

    /* renamed from: a */
    public final void mo148808a(Bundle bundle) throws RemoteException {
        super.mo148808a(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f52640b.mo149341b((Exception) new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f52640b.mo149342b(C18280p.m37395a(this.f52642d, bundle, this.f52643e));
        }
    }
}
