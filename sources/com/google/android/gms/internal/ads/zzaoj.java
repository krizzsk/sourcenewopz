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
public final class zzaoj extends zzgw implements zzaoh {
    zzaoj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
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

    public final zzaes zztt() throws RemoteException {
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

    public final double getStarRating() throws RemoteException {
        Parcel zza = zza(8, zzdp());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    public final String getStore() throws RemoteException {
        Parcel zza = zza(9, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getPrice() throws RemoteException {
        Parcel zza = zza(10, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final zzzd getVideoController() throws RemoteException {
        Parcel zza = zza(11, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final zzaek zztu() throws RemoteException {
        Parcel zza = zza(12, zzdp());
        zzaek zzm = zzaen.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }

    public final IObjectWrapper zzvr() throws RemoteException {
        Parcel zza = zza(13, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzvs() throws RemoteException {
        Parcel zza = zza(14, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zztv() throws RemoteException {
        Parcel zza = zza(15, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(16, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel zza = zza(17, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel zza = zza(18, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void recordImpression() throws RemoteException {
        zzb(19, zzdp());
    }

    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(20, zzdp);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper2);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper3);
        zzb(21, zzdp);
    }

    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(22, zzdp);
    }

    public final float getMediaContentAspectRatio() throws RemoteException {
        Parcel zza = zza(23, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getVideoDuration() throws RemoteException {
        Parcel zza = zza(24, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getVideoCurrentTime() throws RemoteException {
        Parcel zza = zza(25, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }
}
