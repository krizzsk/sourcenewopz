package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzc;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class UserMessagingPlatform {

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    public interface OnConsentFormLoadFailureListener {
        void onConsentFormLoadFailure(FormError formError);
    }

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    public interface OnConsentFormLoadSuccessListener {
        void onConsentFormLoadSuccess(ConsentForm consentForm);
    }

    public static ConsentInformation getConsentInformation(Context context) {
        return zzc.zza(context).zza();
    }

    public static void loadConsentForm(Context context, OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzc.zza(context).zzb().zza(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
    }

    private UserMessagingPlatform() {
    }
}
