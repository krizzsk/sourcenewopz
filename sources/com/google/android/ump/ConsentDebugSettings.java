package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzbz;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public class ConsentDebugSettings {
    private final boolean zza;
    private final int zzb;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    public @interface DebugGeography {
        public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
        public static final int DEBUG_GEOGRAPHY_EEA = 1;
        public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
    }

    private ConsentDebugSettings(boolean z, Builder builder) {
        this.zza = z;
        this.zzb = builder.zzc;
    }

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    public static class Builder {
        private final List<String> zza = new ArrayList();
        private final Context zzb;
        /* access modifiers changed from: private */
        public int zzc = 0;
        private boolean zzd;

        public Builder(Context context) {
            this.zzb = context.getApplicationContext();
        }

        public Builder setDebugGeography(int i) {
            this.zzc = i;
            return this;
        }

        public Builder addTestDeviceHashedId(String str) {
            this.zza.add(str);
            return this;
        }

        public Builder setForceTesting(boolean z) {
            this.zzd = z;
            return this;
        }

        public ConsentDebugSettings build() {
            boolean z = false;
            if ((zzbz.zza() || this.zza.contains(zzbz.zza(this.zzb))) || this.zzd) {
                z = true;
            }
            return new ConsentDebugSettings(z, this);
        }
    }

    public boolean isTestDevice() {
        return this.zza;
    }

    public int getDebugGeography() {
        return this.zzb;
    }
}
