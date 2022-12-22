package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzayw implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final String filename;
    private final /* synthetic */ zzayu zzedq;

    public zzayw(zzayu zzayu, String str) {
        this.zzedq = zzayu;
        this.filename = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzedq) {
            for (zzayz zza : this.zzedq.zzedo) {
                zza.zza(sharedPreferences, this.filename, str);
            }
        }
    }
}
