package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgv;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@19.0.0 */
final class zzdv extends zzch {
    private final zzgv zza;

    zzdv(zzgv zzgv) {
        this.zza = zzgv;
    }

    public final void zzd(String str, String str2, Bundle bundle, long j) {
        this.zza.onEvent(str, str2, bundle, j);
    }

    public final int zze() {
        return System.identityHashCode(this.zza);
    }
}
