package com.google.p209a.p211b.p212a.p213a.p214a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.p209a.p210a.C17875b;
import com.google.p209a.p210a.C17877d;
import java.util.List;

/* renamed from: com.google.a.b.a.a.a.d */
/* compiled from: IInstallService */
public final class C17881d extends C17875b implements C17879b {
    C17881d(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.install.protocol.IInstallService");
    }

    /* renamed from: a */
    public final void mo132628a(String str, List<Bundle> list, Bundle bundle, C17880c cVar) throws RemoteException {
        Parcel a = mo132623a();
        a.writeString(str);
        a.writeTypedList(list);
        C17877d.m37323a(a, (Parcelable) bundle);
        C17877d.m37322a(a, (IInterface) cVar);
        mo132626b(1, a);
    }

    /* renamed from: a */
    public final void mo132627a(String str, Bundle bundle, C17880c cVar) throws RemoteException {
        Parcel a = mo132623a();
        a.writeString(str);
        C17877d.m37323a(a, (Parcelable) bundle);
        C17877d.m37322a(a, (IInterface) cVar);
        mo132626b(2, a);
    }
}
