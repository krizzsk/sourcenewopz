package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.appupdate.n */
final class C18278n extends C18277m<Void> {
    C18278n(C18280p pVar, C18619i<Void> iVar) {
        super(pVar, new C18432ag("OnCompleteUpdateCallback"), iVar);
    }

    /* renamed from: b */
    public final void mo148809b(Bundle bundle) throws RemoteException {
        super.mo148809b(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f52640b.mo149341b((Exception) new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f52640b.mo149342b(null);
        }
    }
}
