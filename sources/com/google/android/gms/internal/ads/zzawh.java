package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzawh extends zzgw implements zzawf {
    zzawh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final void zza(zzvq zzvq, zzawn zzawn) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) zzawn);
        zzb(1, zzdp);
    }

    public final void zza(zzawg zzawg) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzawg);
        zzb(2, zzdp);
    }

    public final boolean isLoaded() throws RemoteException {
        Parcel zza = zza(3, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(5, zzdp);
    }

    public final void zza(zzawo zzawo) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzawo);
        zzb(6, zzdp);
    }

    public final void zza(zzaww zzaww) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzaww);
        zzb(7, zzdp);
    }

    public final void zza(zzyw zzyw) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzyw);
        zzb(8, zzdp);
    }

    public final Bundle getAdMetadata() throws RemoteException {
        Parcel zza = zza(9, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.writeBoolean(zzdp, z);
        zzb(10, zzdp);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzawa zzsb() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 11
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzawa
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzawa r1 = (com.google.android.gms.internal.ads.zzawa) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzawc r2 = new com.google.android.gms.internal.ads.zzawc
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawh.zzsb():com.google.android.gms.internal.ads.zzawa");
    }

    public final zzzc zzkm() throws RemoteException {
        Parcel zza = zza(12, zzdp());
        zzzc zzj = zzzb.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    public final void zza(zzyx zzyx) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzyx);
        zzb(13, zzdp);
    }

    public final void zzb(zzvq zzvq, zzawn zzawn) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) zzawn);
        zzb(14, zzdp);
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(15, zzdp);
    }
}
