package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzasj extends zzgw implements zzash {
    zzasj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) bundle);
        zzb(1, zzdp);
    }

    public final void onRestart() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void onStart() throws RemoteException {
        zzb(3, zzdp());
    }

    public final void onResume() throws RemoteException {
        zzb(4, zzdp());
    }

    public final void onPause() throws RemoteException {
        zzb(5, zzdp());
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) bundle);
        Parcel zza = zza(6, zzdp);
        if (zza.readInt() != 0) {
            bundle.readFromParcel(zza);
        }
        zza.recycle();
    }

    public final void onStop() throws RemoteException {
        zzb(7, zzdp());
    }

    public final void onDestroy() throws RemoteException {
        zzb(8, zzdp());
    }

    public final void zzdq() throws RemoteException {
        zzb(9, zzdp());
    }

    public final void onBackPressed() throws RemoteException {
        zzb(10, zzdp());
    }

    public final boolean zzwh() throws RemoteException {
        Parcel zza = zza(11, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzdp.writeInt(i2);
        zzgx.zza(zzdp, (Parcelable) intent);
        zzb(12, zzdp);
    }

    public final void zzae(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(13, zzdp);
    }

    public final void onUserLeaveHint() throws RemoteException {
        zzb(14, zzdp());
    }
}
