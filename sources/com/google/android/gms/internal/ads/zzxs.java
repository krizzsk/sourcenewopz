package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzxs extends zzgw implements zzxq {
    zzxs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final IObjectWrapper zzki() throws RemoteException {
        Parcel zza = zza(1, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void destroy() throws RemoteException {
        zzb(2, zzdp());
    }

    public final boolean isReady() throws RemoteException {
        Parcel zza = zza(3, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean zza(zzvq zzvq) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvq);
        Parcel zza = zza(4, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void pause() throws RemoteException {
        zzb(5, zzdp());
    }

    public final void resume() throws RemoteException {
        zzb(6, zzdp());
    }

    public final void zza(zzxc zzxc) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzxc);
        zzb(7, zzdp);
    }

    public final void zza(zzxy zzxy) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzxy);
        zzb(8, zzdp);
    }

    public final void showInterstitial() throws RemoteException {
        zzb(9, zzdp());
    }

    public final void stopLoading() throws RemoteException {
        zzb(10, zzdp());
    }

    public final void zzkj() throws RemoteException {
        zzb(11, zzdp());
    }

    public final zzvt zzkk() throws RemoteException {
        Parcel zza = zza(12, zzdp());
        zzvt zzvt = (zzvt) zzgx.zza(zza, zzvt.CREATOR);
        zza.recycle();
        return zzvt;
    }

    public final void zza(zzvt zzvt) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvt);
        zzb(13, zzdp);
    }

    public final void zza(zzasr zzasr) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzasr);
        zzb(14, zzdp);
    }

    public final void zza(zzasx zzasx, String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzasx);
        zzdp.writeString(str);
        zzb(15, zzdp);
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(18, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zza(zzacm zzacm) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzacm);
        zzb(19, zzdp);
    }

    public final void zza(zzwx zzwx) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzwx);
        zzb(20, zzdp);
    }

    public final void zza(zzye zzye) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzye);
        zzb(21, zzdp);
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(22, zzdp);
    }

    public final boolean isLoading() throws RemoteException {
        Parcel zza = zza(23, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(zzavn zzavn) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzavn);
        zzb(24, zzdp);
    }

    public final void setUserId(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(25, zzdp);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzzd getVideoController() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 26
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoController"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzzd
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzzd r1 = (com.google.android.gms.internal.ads.zzzd) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzzf r2 = new com.google.android.gms.internal.ads.zzzf
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxs.getVideoController():com.google.android.gms.internal.ads.zzzd");
    }

    public final void zza(zzaaz zzaaz) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzaaz);
        zzb(29, zzdp);
    }

    public final void zza(zzzj zzzj) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzzj);
        zzb(30, zzdp);
    }

    public final String getAdUnitId() throws RemoteException {
        Parcel zza = zza(31, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxy zzkn() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 32
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzxy
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzxy r1 = (com.google.android.gms.internal.ads.zzxy) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzya r2 = new com.google.android.gms.internal.ads.zzya
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxs.zzkn():com.google.android.gms.internal.ads.zzxy");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxc zzko() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 33
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzxc
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzxc r1 = (com.google.android.gms.internal.ads.zzxc) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzxe r2 = new com.google.android.gms.internal.ads.zzxe
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxs.zzko():com.google.android.gms.internal.ads.zzxc");
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(34, zzdp);
    }

    public final String zzkl() throws RemoteException {
        Parcel zza = zza(35, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zza(zzxt zzxt) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzxt);
        zzb(36, zzdp);
    }

    public final Bundle getAdMetadata() throws RemoteException {
        Parcel zza = zza(37, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final void zzbl(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(38, zzdp);
    }

    public final void zza(zzwc zzwc) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzwc);
        zzb(39, zzdp);
    }

    public final void zza(zzsq zzsq) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzsq);
        zzb(40, zzdp);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzzc zzkm() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 41
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IResponseInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzzc
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzzc r1 = (com.google.android.gms.internal.ads.zzzc) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzze r2 = new com.google.android.gms.internal.ads.zzze
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxs.zzkm():com.google.android.gms.internal.ads.zzzc");
    }

    public final void zza(zzyx zzyx) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzyx);
        zzb(42, zzdp);
    }

    public final void zza(zzvq zzvq, zzxd zzxd) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) zzxd);
        zzb(43, zzdp);
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(44, zzdp);
    }

    public final void zza(zzyg zzyg) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzyg);
        zzb(45, zzdp);
    }
}
