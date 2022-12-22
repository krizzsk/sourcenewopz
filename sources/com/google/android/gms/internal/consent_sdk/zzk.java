package com.google.android.gms.internal.consent_sdk;

import com.didi.sdk.apm.SystemUtils;
import com.google.android.ump.FormError;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzk extends Exception {
    private final int zza;

    public zzk(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzk(int i, String str, Throwable th) {
        super(str, th);
        this.zza = i;
    }

    public final String getMessage() {
        return super.getMessage();
    }

    public final FormError zza() {
        if (getCause() == null) {
            SystemUtils.log(5, "UserMessagingPlatform", getMessage(), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzk", 12);
        } else {
            SystemUtils.log(5, "UserMessagingPlatform", getMessage(), getCause(), "com.google.android.gms.internal.consent_sdk.zzk", 15);
        }
        return new FormError(this.zza, getMessage());
    }
}
