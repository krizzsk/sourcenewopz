package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.UserMessagingPlatform;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzaz {
    private final zzct<zzau> zza;
    private final AtomicReference<zzbb> zzb = new AtomicReference<>();

    zzaz(zzct<zzau> zzct) {
        this.zza = zzct;
    }

    public final void zza(zzbb zzbb) {
        this.zzb.set(zzbb);
    }

    public final void zza(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzcd.zza();
        zzbb zzbb = this.zzb.get();
        if (zzbb == null) {
            onConsentFormLoadFailureListener.onConsentFormLoadFailure(new zzk(3, "No available form can be built.").zza());
        } else {
            this.zza.zza().zza(zzbb).zza().zza().zza(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
        }
    }

    public final boolean zza() {
        return this.zzb.get() != null;
    }
}
