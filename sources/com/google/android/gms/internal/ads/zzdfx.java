package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfx implements zzdhe<zzdfy> {
    private final Bundle zzgbd;
    private final zzebs zzgka;

    public zzdfx(zzebs zzebs, Bundle bundle) {
        this.zzgka = zzebs;
        this.zzgbd = bundle;
    }

    public final zzebt<zzdfy> zzatu() {
        return this.zzgka.zze(new zzdga(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfy zzauj() throws Exception {
        return new zzdfy(this.zzgbd);
    }
}
