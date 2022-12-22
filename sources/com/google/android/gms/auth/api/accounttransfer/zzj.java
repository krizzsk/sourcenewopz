package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
class zzj<T> extends zzan {
    final zzk<T> zzb;

    public zzj(zzk<T> zzk) {
        this.zzb = zzk;
    }

    public final void zzd(Status status) {
        TaskCompletionSource<T> taskCompletionSource = this.zzb.zzb;
        int i = AccountTransferClient.zza;
        taskCompletionSource.setException(new AccountTransferException(status));
    }
}
