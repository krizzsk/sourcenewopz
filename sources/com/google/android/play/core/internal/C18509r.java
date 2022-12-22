package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.r */
public final class C18509r extends C18501j implements C18511t {
    C18509r(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    /* renamed from: a */
    public final void mo149173a(String str, Bundle bundle, Bundle bundle2, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37947a(a, (Parcelable) bundle2);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(6, a);
    }

    /* renamed from: a */
    public final void mo149174a(String str, Bundle bundle, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(5, a);
    }

    /* renamed from: a */
    public final void mo149175a(String str, List<Bundle> list, Bundle bundle, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeTypedList(list);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(2, a);
    }

    /* renamed from: b */
    public final void mo149176b(String str, Bundle bundle, Bundle bundle2, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37947a(a, (Parcelable) bundle2);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(7, a);
    }

    /* renamed from: b */
    public final void mo149177b(String str, Bundle bundle, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(10, a);
    }

    /* renamed from: b */
    public final void mo149178b(String str, List<Bundle> list, Bundle bundle, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeTypedList(list);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(14, a);
    }

    /* renamed from: c */
    public final void mo149179c(String str, Bundle bundle, Bundle bundle2, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37947a(a, (Parcelable) bundle2);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(9, a);
    }

    /* renamed from: c */
    public final void mo149180c(String str, List<Bundle> list, Bundle bundle, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        a.writeTypedList(list);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(12, a);
    }

    /* renamed from: d */
    public final void mo149181d(String str, Bundle bundle, Bundle bundle2, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37947a(a, (Parcelable) bundle2);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(11, a);
    }

    /* renamed from: e */
    public final void mo149182e(String str, Bundle bundle, Bundle bundle2, C18513v vVar) throws RemoteException {
        Parcel a = mo149166a();
        a.writeString(str);
        C18503l.m37947a(a, (Parcelable) bundle);
        C18503l.m37947a(a, (Parcelable) bundle2);
        C18503l.m37946a(a, (IInterface) vVar);
        mo149167a(13, a);
    }
}
