package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18475bw;
import com.google.android.play.core.tasks.C18619i;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.au */
class C18569au<T> extends C18475bw {

    /* renamed from: a */
    final C18619i<T> f53299a;

    /* renamed from: b */
    final /* synthetic */ C18570av f53300b;

    C18569au(C18570av avVar, C18619i<T> iVar) {
        this.f53300b = avVar;
        this.f53299a = iVar;
    }

    /* renamed from: a */
    public final void mo149120a() throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onCompleteInstallForAppUpdate", new Object[0]);
    }

    /* renamed from: a */
    public final void mo149121a(int i) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo149122a(int i, Bundle bundle) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onCancelInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo149123a(Bundle bundle) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onDeferredInstall", new Object[0]);
    }

    /* renamed from: a */
    public void mo149124a(List<Bundle> list) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onGetSessionStates", new Object[0]);
    }

    /* renamed from: b */
    public final void mo149125b() throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onGetSplitsForAppUpdate", new Object[0]);
    }

    /* renamed from: b */
    public void mo149126b(int i, Bundle bundle) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: b */
    public void mo149127b(Bundle bundle) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onDeferredLanguageInstall", new Object[0]);
    }

    /* renamed from: c */
    public void mo149128c(int i, Bundle bundle) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onStartInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: c */
    public void mo149129c(Bundle bundle) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onDeferredLanguageUninstall", new Object[0]);
    }

    /* renamed from: d */
    public void mo149130d(Bundle bundle) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        C18570av.f53301b.mo149084c("onDeferredUninstall", new Object[0]);
    }

    /* renamed from: e */
    public final void mo149131e(Bundle bundle) throws RemoteException {
        this.f53300b.f53303a.mo149092a();
        int i = bundle.getInt("error_code");
        C18570av.f53301b.mo149083b("onError(%d)", Integer.valueOf(i));
        this.f53299a.mo149341b((Exception) new SplitInstallException(i));
    }
}
