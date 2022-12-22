package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzal {
    private final Application zza;
    private final SharedPreferences zzb;
    private final Set<String> zzc = new HashSet(this.zzb.getStringSet("written_values", Collections.emptySet()));

    zzal(Application application) {
        this.zza = application;
        this.zzb = SystemUtils.getSharedPreferences(application, "__GOOGLE_FUNDING_CHOICE_SDK_INTERNAL__", 0);
    }

    public final int zza() {
        return this.zzb.getInt("consent_status", 0);
    }

    public final void zza(int i) {
        this.zzb.edit().putInt("consent_status", i).apply();
    }

    public final int zzb() {
        return this.zzb.getInt("consent_type", 0);
    }

    public final void zzb(int i) {
        this.zzb.edit().putInt("consent_type", i).apply();
    }

    public final Set<String> zzc() {
        return this.zzb.getStringSet("stored_info", Collections.emptySet());
    }

    public final void zza(Set<String> set) {
        this.zzb.edit().putStringSet("stored_info", set).apply();
    }

    public final Set<String> zzd() {
        return this.zzc;
    }

    public final void zze() {
        this.zzb.edit().putStringSet("written_values", this.zzc).apply();
    }

    public final void zzf() {
        zzcc.zza((Context) this.zza, this.zzc);
        this.zzc.clear();
        this.zzb.edit().remove("stored_info").remove("consent_status").remove("consent_type").apply();
    }
}
