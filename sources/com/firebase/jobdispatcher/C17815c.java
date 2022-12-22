package com.firebase.jobdispatcher;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.firebase.jobdispatcher.c */
/* compiled from: GooglePlayJobCallback */
final class C17815c implements JobCallback {

    /* renamed from: a */
    private static final String f52175a = "com.google.android.gms.gcm.INetworkTaskCallback";

    /* renamed from: b */
    private static final int f52176b = 2;

    /* renamed from: c */
    private final IBinder f52177c;

    public C17815c(IBinder iBinder) {
        this.f52177c = iBinder;
    }

    public void jobFinished(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f52175a);
            obtain.writeInt(i);
            this.f52177c.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            obtain.recycle();
            obtain2.recycle();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
    }
}
