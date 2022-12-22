package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzl extends zzan {
    final /* synthetic */ zzm zza;

    zzl(zzm zzm) {
        this.zza = zzm;
    }

    public final void zzd(Status status) {
        this.zza.zzb.setException(new AccountTransferException(status));
    }

    public final void zze() {
        this.zza.zzb.setResult(null);
    }
}
