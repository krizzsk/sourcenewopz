package com.google.p209a.p211b.p212a.p213a.p214a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p209a.p210a.C17874a;
import com.google.p209a.p210a.C17877d;

/* renamed from: com.google.a.b.a.a.a.e */
/* compiled from: IInstallServiceCallback */
public abstract class C17882e extends C17874a implements C17880c {
    public C17882e() {
        super("com.google.android.play.core.install.protocol.IInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo132620a(int i, Parcel parcel) throws RemoteException {
        if (i == 1) {
            mo132630a((Bundle) C17877d.m37321a(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            mo132631b((Bundle) C17877d.m37321a(parcel, Bundle.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            C17877d.m37321a(parcel, Bundle.CREATOR);
            mo132629a();
        }
        return true;
    }
}
