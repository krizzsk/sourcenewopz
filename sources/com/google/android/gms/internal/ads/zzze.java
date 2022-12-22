package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzze extends zzgw implements zzzc {
    zzze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(1, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getResponseId() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List<zzvx> getAdapterResponses() throws RemoteException {
        Parcel zza = zza(3, zzdp());
        ArrayList<zzvx> createTypedArrayList = zza.createTypedArrayList(zzvx.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }
}
