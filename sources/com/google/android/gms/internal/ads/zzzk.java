package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzk extends zzgw implements zzzi {
    zzzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void onVideoStart() throws RemoteException {
        zzb(1, zzdp());
    }

    public final void onVideoPlay() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void onVideoPause() throws RemoteException {
        zzb(3, zzdp());
    }

    public final void onVideoEnd() throws RemoteException {
        zzb(4, zzdp());
    }

    public final void onVideoMute(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(5, zzdp);
    }
}
