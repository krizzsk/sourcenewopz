package com.google.p220vr.dynamite.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p209a.p210a.C17875b;

/* renamed from: com.google.vr.dynamite.client.b */
/* compiled from: INativeLibraryLoader */
public final class C19713b extends C17875b implements INativeLibraryLoader {
    C19713b(IBinder iBinder) {
        super(iBinder, "com.google.vr.dynamite.client.INativeLibraryLoader");
    }

    public final long initializeAndLoadNativeLibrary(String str) throws RemoteException {
        Parcel a = mo132623a();
        a.writeString(str);
        Parcel a2 = mo132624a(1, a);
        long readLong = a2.readLong();
        a2.recycle();
        return readLong;
    }

    public final int checkVersion(String str) throws RemoteException {
        Parcel a = mo132623a();
        a.writeString(str);
        Parcel a2 = mo132624a(2, a);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
