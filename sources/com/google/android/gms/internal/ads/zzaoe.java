package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaoe extends zzgw implements zzaoc {
    zzaoe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List getImages() throws RemoteException {
        Parcel zza = zza(3, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    public final String getBody() throws RemoteException {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final zzaes zztw() throws RemoteException {
        Parcel zza = zza(5, zzdp());
        zzaes zzo = zzaev.zzo(zza.readStrongBinder());
        zza.recycle();
        return zzo;
    }

    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(6, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getAdvertiser() throws RemoteException {
        Parcel zza = zza(7, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void recordImpression() throws RemoteException {
        zzb(8, zzdp());
    }

    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(9, zzdp);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(10, zzdp);
    }

    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel zza = zza(11, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel zza = zza(12, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(13, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(14, zzdp);
    }

    public final IObjectWrapper zzvr() throws RemoteException {
        Parcel zza = zza(15, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final zzzd getVideoController() throws RemoteException {
        Parcel zza = zza(16, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final zzaek zztu() throws RemoteException {
        Parcel zza = zza(19, zzdp());
        zzaek zzm = zzaen.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }

    public final IObjectWrapper zzvs() throws RemoteException {
        Parcel zza = zza(20, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zztv() throws RemoteException {
        Parcel zza = zza(21, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper2);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper3);
        zzb(22, zzdp);
    }
}
