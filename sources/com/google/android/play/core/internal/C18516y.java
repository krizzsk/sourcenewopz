package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.y */
public final class C18516y extends C18501j implements C18517z {
    C18516y(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    /* renamed from: a */
    public final void mo149183a(Bundle bundle) throws RemoteException {
        Parcel a = mo149166a();
        C18503l.m37947a(a, (Parcelable) bundle);
        mo149167a(3, a);
    }

    /* renamed from: a */
    public final void mo149184a(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a = mo149166a();
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37947a(a, (Parcelable) bundle2);
        mo149167a(2, a);
    }

    /* renamed from: b */
    public final void mo149185b(Bundle bundle) throws RemoteException {
        Parcel a = mo149166a();
        C18503l.m37947a(a, (Parcelable) bundle);
        mo149167a(4, a);
    }
}
