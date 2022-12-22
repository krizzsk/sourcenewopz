package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzxl extends zzgw implements zzxj {
    zzxl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxi zzrf() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 1
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzxi
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzxi r1 = (com.google.android.gms.internal.ads.zzxi) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzxk r2 = new com.google.android.gms.internal.ads.zzxk
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxl.zzrf():com.google.android.gms.internal.ads.zzxi");
    }

    public final void zzb(zzxc zzxc) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzxc);
        zzb(2, zzdp);
    }

    public final void zza(zzafs zzafs) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzafs);
        zzb(3, zzdp);
    }

    public final void zza(zzafx zzafx) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzafx);
        zzb(4, zzdp);
    }

    public final void zza(String str, zzagd zzagd, zzafy zzafy) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) zzagd);
        zzgx.zza(zzdp, (IInterface) zzafy);
        zzb(5, zzdp);
    }

    public final void zza(zzaei zzaei) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzaei);
        zzb(6, zzdp);
    }

    public final void zzb(zzye zzye) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzye);
        zzb(7, zzdp);
    }

    public final void zza(zzagg zzagg, zzvt zzvt) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzagg);
        zzgx.zza(zzdp, (Parcelable) zzvt);
        zzb(8, zzdp);
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) publisherAdViewOptions);
        zzb(9, zzdp);
    }

    public final void zza(zzagl zzagl) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzagl);
        zzb(10, zzdp);
    }

    public final void zza(zzajy zzajy) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzajy);
        zzb(13, zzdp);
    }

    public final void zza(zzakg zzakg) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzakg);
        zzb(14, zzdp);
    }

    public final void zza(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) adManagerAdViewOptions);
        zzb(15, zzdp);
    }
}
