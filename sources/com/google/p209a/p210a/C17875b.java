package com.google.p209a.p210a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.a.a.b */
/* compiled from: BaseProxy */
public class C17875b implements IInterface {

    /* renamed from: a */
    private final IBinder f52588a;

    /* renamed from: b */
    private final String f52589b;

    protected C17875b(IBinder iBinder, String str) {
        this.f52588a = iBinder;
        this.f52589b = str;
    }

    public IBinder asBinder() {
        return this.f52588a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo132623a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f52589b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo132624a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f52588a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo132626b(int i, Parcel parcel) throws RemoteException {
        try {
            this.f52588a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
