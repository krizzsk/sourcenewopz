package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzbhb extends zzgy implements zzbhc {
    public static zzbhc zzav(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
        if (queryLocalInterface instanceof zzbhc) {
            return (zzbhc) queryLocalInterface;
        }
        return new zzbhd(iBinder);
    }
}
