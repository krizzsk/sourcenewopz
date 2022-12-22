package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgu implements zzdhe<zzdhb<Bundle>> {
    private final boolean zzhgf;

    zzdgu(zzdmp zzdmp) {
        if (zzdmp != null) {
            this.zzhgf = true;
        } else {
            this.zzhgf = false;
        }
    }

    public final zzebt<zzdhb<Bundle>> zzatu() {
        return zzebh.zzag(this.zzhgf ? zzdgt.zzhge : null);
    }
}
