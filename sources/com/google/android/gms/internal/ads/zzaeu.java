package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaeu extends zzgw implements zzaes {
    zzaeu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final IObjectWrapper zztn() throws RemoteException {
        Parcel zza = zza(1, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final Uri getUri() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        Uri uri = (Uri) zzgx.zza(zza, Uri.CREATOR);
        zza.recycle();
        return uri;
    }

    public final double getScale() throws RemoteException {
        Parcel zza = zza(3, zzdp());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    public final int getWidth() throws RemoteException {
        Parcel zza = zza(4, zzdp());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final int getHeight() throws RemoteException {
        Parcel zza = zza(5, zzdp());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
