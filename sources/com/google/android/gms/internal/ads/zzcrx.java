package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzuh;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcrx implements zzebi<Bundle> {
    private final /* synthetic */ boolean zzgtz;
    final /* synthetic */ zzcru zzgua;

    zzcrx(zzcru zzcru, boolean z) {
        this.zzgua = zzcru;
        this.zzgtz = z;
    }

    public final void zzb(Throwable th) {
        zzd.zzex("Failed to get signals bundle");
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.zzgua.zzeci.zzzn()) {
            ArrayList zza = zzcru.zzl(bundle);
            zzuh.zzo.zzb zzb = zzcru.zzk(bundle);
            this.zzgua.zzgtr.zza(new zzcrw(this, this.zzgtz, zza, this.zzgua.zzj(bundle), zzb));
        }
    }
}
