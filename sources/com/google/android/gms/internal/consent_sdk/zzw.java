package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final /* synthetic */ class zzw implements Runnable {
    private final ConsentInformation.OnConsentInfoUpdateFailureListener zza;
    private final zzk zzb;

    zzw(ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener, zzk zzk) {
        this.zza = onConsentInfoUpdateFailureListener;
        this.zzb = zzk;
    }

    public final void run() {
        this.zza.onConsentInfoUpdateFailure(this.zzb.zza());
    }
}
