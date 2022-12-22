package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.aa */
public final class C18426aa extends C18501j implements C18428ac {
    C18426aa(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* renamed from: a */
    public final void mo149075a(String str, Bundle bundle, C18430ae aeVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) aeVar);
        mo149167a(2, a);
    }
}
