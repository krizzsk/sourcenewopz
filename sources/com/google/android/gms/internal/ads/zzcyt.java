package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyt implements zzg {
    private zzg zzhaa;

    public final synchronized void zza(zzg zzg) {
        this.zzhaa = zzg;
    }

    public final synchronized void zzh(View view) {
        if (this.zzhaa != null) {
            this.zzhaa.zzh(view);
        }
    }

    public final synchronized void zzkg() {
        if (this.zzhaa != null) {
            this.zzhaa.zzkg();
        }
    }

    public final synchronized void zzkh() {
        if (this.zzhaa != null) {
            this.zzhaa.zzkh();
        }
    }
}
