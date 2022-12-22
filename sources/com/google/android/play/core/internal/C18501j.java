package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.j */
public class C18501j implements IInterface {

    /* renamed from: a */
    private final IBinder f53190a;

    /* renamed from: b */
    private final String f53191b;

    protected C18501j(IBinder iBinder, String str) {
        this.f53190a = iBinder;
        this.f53191b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo149166a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f53191b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo149167a(int i, Parcel parcel) throws RemoteException {
        try {
            this.f53190a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f53190a;
    }
}
