package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddy implements zzdhe<zzdhb<Bundle>> {
    private final zzdlr zzhej;

    zzddy(zzdlr zzdlr) {
        this.zzhej = zzdlr;
    }

    public final zzebt<zzdhb<Bundle>> zzatu() {
        zzdlr zzdlr = this.zzhej;
        return zzebh.zzag((zzdlr == null || zzdlr.zzavo() == null || this.zzhej.zzavo().isEmpty()) ? null : new zzddx(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Bundle bundle) {
        bundle.putString("key_schema", this.zzhej.zzavo());
    }
}
