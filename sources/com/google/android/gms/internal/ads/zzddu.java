package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddu implements zzdhb<Bundle> {
    private final double zzdzq;
    private final boolean zzdzr;

    public zzddu(double d, boolean z) {
        this.zzdzq = d;
        this.zzdzr = z;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdpw.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzdpw.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdzr);
        zza2.putDouble("battery_level", this.zzdzq);
    }
}
