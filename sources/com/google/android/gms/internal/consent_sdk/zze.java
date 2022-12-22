package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zze {
    private final Executor zza;

    zze(Executor executor) {
        this.zza = executor;
    }

    public final void zza(String str, String str2, zzi... zziArr) {
        this.zza.execute(new zzg(str, str2, zziArr));
    }

    public final Executor zza() {
        return this.zza;
    }
}
