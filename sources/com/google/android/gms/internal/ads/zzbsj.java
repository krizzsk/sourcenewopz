package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbsj {
    private final Context context;
    private final zzdpm zzfzg;
    private Bundle zzgbd;
    private final String zzgbe;
    private final zzdph zzgbf;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public zzdpm zzfzg;
        /* access modifiers changed from: private */
        public Bundle zzgbd;
        /* access modifiers changed from: private */
        public String zzgbe;
        /* access modifiers changed from: private */
        public zzdph zzgbf;

        public final zza zzci(Context context2) {
            this.context = context2;
            return this;
        }

        public final zza zza(zzdpm zzdpm) {
            this.zzfzg = zzdpm;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.zzgbd = bundle;
            return this;
        }

        public final zza zzft(String str) {
            this.zzgbe = str;
            return this;
        }

        public final zzbsj zzami() {
            return new zzbsj(this);
        }

        public final zza zza(zzdph zzdph) {
            this.zzgbf = zzdph;
            return this;
        }
    }

    private zzbsj(zza zza2) {
        this.context = zza2.context;
        this.zzfzg = zza2.zzfzg;
        this.zzgbd = zza2.zzgbd;
        this.zzgbe = zza2.zzgbe;
        this.zzgbf = zza2.zzgbf;
    }

    /* access modifiers changed from: package-private */
    public final zza zzame() {
        return new zza().zzci(this.context).zza(this.zzfzg).zzft(this.zzgbe).zze(this.zzgbd);
    }

    /* access modifiers changed from: package-private */
    public final zzdpm zzamf() {
        return this.zzfzg;
    }

    /* access modifiers changed from: package-private */
    public final zzdph zzamg() {
        return this.zzgbf;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzamh() {
        return this.zzgbd;
    }

    /* access modifiers changed from: package-private */
    public final Context zzch(Context context2) {
        if (this.zzgbe != null) {
            return context2;
        }
        return this.context;
    }
}
