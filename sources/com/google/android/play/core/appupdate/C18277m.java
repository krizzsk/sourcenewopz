package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18507p;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.appupdate.m */
class C18277m<T> extends C18507p {

    /* renamed from: a */
    final C18432ag f52639a;

    /* renamed from: b */
    final C18619i<T> f52640b;

    /* renamed from: c */
    final /* synthetic */ C18280p f52641c;

    C18277m(C18280p pVar, C18432ag agVar, C18619i<T> iVar) {
        this.f52641c = pVar;
        this.f52639a = agVar;
        this.f52640b = iVar;
    }

    /* renamed from: a */
    public void mo148808a(Bundle bundle) throws RemoteException {
        this.f52641c.f52646a.mo149092a();
        this.f52639a.mo149084c("onRequestInfo", new Object[0]);
    }

    /* renamed from: b */
    public void mo148809b(Bundle bundle) throws RemoteException {
        this.f52641c.f52646a.mo149092a();
        this.f52639a.mo149084c("onCompleteUpdate", new Object[0]);
    }
}
