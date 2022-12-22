package com.google.android.ump;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public class ConsentRequestParameters {
    private final boolean zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final ConsentDebugSettings zzf;

    private ConsentRequestParameters(Builder builder) {
        this.zza = builder.zza;
        this.zzc = null;
        this.zzb = 0;
        this.zzd = null;
        this.zze = builder.zzc;
        this.zzf = builder.zzd;
    }

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza;
        private int zzb = 0;
        /* access modifiers changed from: private */
        public String zzc;
        /* access modifiers changed from: private */
        public ConsentDebugSettings zzd;

        public final Builder setTagForUnderAgeOfConsent(boolean z) {
            this.zza = z;
            return this;
        }

        public final Builder setConsentDebugSettings(ConsentDebugSettings consentDebugSettings) {
            this.zzd = consentDebugSettings;
            return this;
        }

        public final Builder setAdMobAppId(String str) {
            this.zzc = str;
            return this;
        }

        public final ConsentRequestParameters build() {
            return new ConsentRequestParameters(this);
        }
    }

    public boolean isTagForUnderAgeOfConsent() {
        return this.zza;
    }

    public ConsentDebugSettings getConsentDebugSettings() {
        return this.zzf;
    }

    public final String zza() {
        return this.zze;
    }
}
