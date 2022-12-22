package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzn {
    /* access modifiers changed from: private */
    public final Application zza;
    /* access modifiers changed from: private */
    public final zzb zzb;
    /* access modifiers changed from: private */
    public final zzal zzc;

    zzn(Application application, zzb zzb2, zzal zzal) {
        this.zza = application;
        this.zzb = zzb2;
        this.zzc = zzal;
    }

    /* access modifiers changed from: package-private */
    public final zzbn zza(Activity activity, ConsentRequestParameters consentRequestParameters) throws zzk {
        ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
        if (consentDebugSettings == null) {
            consentDebugSettings = new ConsentDebugSettings.Builder(this.zza).build();
        }
        return new zzl(this, activity, consentDebugSettings, consentRequestParameters).zza();
    }
}
