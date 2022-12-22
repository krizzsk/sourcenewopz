package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzanq extends zzgw implements zzano {
    zzanq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvt);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(1, zzdp);
    }

    public final IObjectWrapper zzve() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(3, zzdp);
    }

    public final void showInterstitial() throws RemoteException {
        zzb(4, zzdp());
    }

    public final void destroy() throws RemoteException {
        zzb(5, zzdp());
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvt);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(6, zzdp);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(7, zzdp);
    }

    public final void pause() throws RemoteException {
        zzb(8, zzdp());
    }

    public final void resume() throws RemoteException {
        zzb(9, zzdp());
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzavu zzavu, String str2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) zzavu);
        zzdp.writeString(str2);
        zzb(10, zzdp);
    }

    public final void zza(zzvq zzvq, String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzb(11, zzdp);
    }

    public final void showVideo() throws RemoteException {
        zzb(12, zzdp());
    }

    public final boolean isInitialized() throws RemoteException {
        Parcel zza = zza(13, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, String str2, zzant zzant, zzaei zzaei, List<String> list) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzgx.zza(zzdp, (Parcelable) zzaei);
        zzdp.writeStringList(list);
        zzb(14, zzdp);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaob zzvf() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 15
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaob
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaob r1 = (com.google.android.gms.internal.ads.zzaob) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaod r2 = new com.google.android.gms.internal.ads.zzaod
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanq.zzvf():com.google.android.gms.internal.ads.zzaob");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaoc zzvg() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 16
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaoc
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaoc r1 = (com.google.android.gms.internal.ads.zzaoc) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaoe r2 = new com.google.android.gms.internal.ads.zzaoe
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanq.zzvg():com.google.android.gms.internal.ads.zzaoc");
    }

    public final Bundle zzvh() throws RemoteException {
        Parcel zza = zza(17, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final Bundle getInterstitialAdapterInfo() throws RemoteException {
        Parcel zza = zza(18, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final Bundle zzvi() throws RemoteException {
        Parcel zza = zza(19, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final void zza(zzvq zzvq, String str, String str2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(20, zzdp);
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(21, zzdp);
    }

    public final boolean zzvj() throws RemoteException {
        Parcel zza = zza(22, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzavu zzavu, List<String> list) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzavu);
        zzdp.writeStringList(list);
        zzb(23, zzdp);
    }

    public final zzafo zzvk() throws RemoteException {
        Parcel zza = zza(24, zzdp());
        zzafo zzr = zzafr.zzr(zza.readStrongBinder());
        zza.recycle();
        return zzr;
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(25, zzdp);
    }

    public final zzzd getVideoController() throws RemoteException {
        Parcel zza = zza(26, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaoh zzvl() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 27
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaoh
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaoh r1 = (com.google.android.gms.internal.ads.zzaoh) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaoj r2 = new com.google.android.gms.internal.ads.zzaoj
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanq.zzvl():com.google.android.gms.internal.ads.zzaoh");
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(28, zzdp);
    }

    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(30, zzdp);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajo, List<zzajw> list) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzajo);
        zzdp.writeTypedList(list);
        zzb(31, zzdp);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(32, zzdp);
    }

    public final zzaqr zzvm() throws RemoteException {
        Parcel zza = zza(33, zzdp());
        zzaqr zzaqr = (zzaqr) zzgx.zza(zza, zzaqr.CREATOR);
        zza.recycle();
        return zzaqr;
    }

    public final zzaqr zzvn() throws RemoteException {
        Parcel zza = zza(34, zzdp());
        zzaqr zzaqr = (zzaqr) zzgx.zza(zza, zzaqr.CREATOR);
        zza.recycle();
        return zzaqr;
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzvt);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(35, zzdp);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzanu zzvo() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdp()
            r1 = 36
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzanu
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzanu r1 = (com.google.android.gms.internal.ads.zzanu) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzanw r2 = new com.google.android.gms.internal.ads.zzanw
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanq.zzvo():com.google.android.gms.internal.ads.zzanu");
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(37, zzdp);
    }
}
