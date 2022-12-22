package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bt */
public final class C18472bt extends C18501j implements C18474bv {
    C18472bt(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    /* renamed from: a */
    public final void mo149112a(String str, int i, Bundle bundle, C18476bx bxVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeInt(i);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) bxVar);
        mo149167a(4, a);
    }

    /* renamed from: a */
    public final void mo149113a(String str, int i, C18476bx bxVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeInt(i);
        C18503l.m37946a(a, (IInterface) bxVar);
        mo149167a(5, a);
    }

    /* renamed from: a */
    public final void mo149114a(String str, C18476bx bxVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37946a(a, (IInterface) bxVar);
        mo149167a(6, a);
    }

    /* renamed from: a */
    public final void mo149115a(String str, List<Bundle> list, Bundle bundle, C18476bx bxVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeTypedList(list);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) bxVar);
        mo149167a(2, a);
    }

    /* renamed from: b */
    public final void mo149116b(String str, List<Bundle> list, Bundle bundle, C18476bx bxVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeTypedList(list);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) bxVar);
        mo149167a(7, a);
    }

    /* renamed from: c */
    public final void mo149117c(String str, List<Bundle> list, Bundle bundle, C18476bx bxVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeTypedList(list);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) bxVar);
        mo149167a(8, a);
    }

    /* renamed from: d */
    public final void mo149118d(String str, List<Bundle> list, Bundle bundle, C18476bx bxVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeTypedList(list);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) bxVar);
        mo149167a(13, a);
    }

    /* renamed from: e */
    public final void mo149119e(String str, List<Bundle> list, Bundle bundle, C18476bx bxVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeTypedList(list);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) bxVar);
        mo149167a(14, a);
    }
}
