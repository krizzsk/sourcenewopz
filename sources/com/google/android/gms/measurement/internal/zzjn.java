package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final /* synthetic */ class zzjn implements Runnable {
    private final zzjq zza;
    private final zzem zzb;
    private final JobParameters zzc;

    zzjn(zzjq zzjq, zzem zzem, JobParameters jobParameters) {
        this.zza = zzjq;
        this.zzb = zzem;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc);
    }
}
