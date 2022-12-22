package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzf extends zzgw implements zzzd {
    zzzf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final void play() throws RemoteException {
        zzb(1, zzdp());
    }

    public final void pause() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void mute(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(3, zzdp);
    }

    public final boolean isMuted() throws RemoteException {
        Parcel zza = zza(4, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final int getPlaybackState() throws RemoteException {
        Parcel zza = zza(5, zzdp());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final float getDuration() throws RemoteException {
        Parcel zza = zza(6, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getCurrentTime() throws RemoteException {
        Parcel zza = zza(7, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final void zza(zzzi zzzi) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzzi);
        zzb(8, zzdp);
    }

    public final float getAspectRatio() throws RemoteException {
        Parcel zza = zza(9, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final boolean isCustomControlsEnabled() throws RemoteException {
        Parcel zza = zza(10, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzzi zzrm() throws android.os.RemoteException {
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
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzzi
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzzi r1 = (com.google.android.gms.internal.ads.zzzi) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzzk r2 = new com.google.android.gms.internal.ads.zzzk
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzf.zzrm():com.google.android.gms.internal.ads.zzzi");
    }

    public final boolean isClickToExpandEnabled() throws RemoteException {
        Parcel zza = zza(12, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void stop() throws RemoteException {
        zzb(13, zzdp());
    }
}
