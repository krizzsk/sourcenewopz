package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.m */
public final class C18504m extends C18501j implements C18506o {
    C18504m(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    /* renamed from: a */
    public final void mo149171a(String str, Bundle bundle, C18508q qVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) qVar);
        mo149167a(2, a);
    }

    /* renamed from: b */
    public final void mo149172b(String str, Bundle bundle, C18508q qVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) qVar);
        mo149167a(3, a);
    }
}
