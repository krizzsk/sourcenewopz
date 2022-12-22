package com.google.android.gms.internal.p215authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzz */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
final class zzz extends zzi {
    final /* synthetic */ TaskCompletionSource zza;

    zzz(zzab zzab, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }
}
