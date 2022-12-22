package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.p */
public abstract class C18507p extends C18502k implements C18508q {
    public C18507p() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo149076a(int i, Parcel parcel) throws RemoteException {
        if (i == 2) {
            mo148808a((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
            return true;
        } else if (i != 3) {
            return false;
        } else {
            mo148809b((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
