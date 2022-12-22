package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhl implements zzdhb<Bundle> {
    private final String zzdza;
    private final int zzdzl;
    private final int zzdzm;
    private final int zzdzn;
    private final boolean zzdzs;
    private final int zzdzt;

    public zzdhl(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdza = str;
        this.zzdzl = i;
        this.zzdzm = i2;
        this.zzdzn = i3;
        this.zzdzs = z;
        this.zzdzt = i4;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zzdza;
        boolean z = true;
        zzdpw.zza(bundle, "carrier", str, !TextUtils.isEmpty(str));
        Integer valueOf = Integer.valueOf(this.zzdzl);
        if (this.zzdzl == -2) {
            z = false;
        }
        zzdpw.zza(bundle, "cnt", valueOf, z);
        bundle.putInt("gnt", this.zzdzm);
        bundle.putInt("pt", this.zzdzn);
        Bundle zza = zzdpw.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzdpw.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzdzt);
        zza2.putBoolean("active_network_metered", this.zzdzs);
    }
}
