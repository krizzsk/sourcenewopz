package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzae {
    private float zzdwd = 1.0f;
    private boolean zzdwi = false;

    public final synchronized void setAppVolume(float f) {
        this.zzdwd = f;
    }

    public final synchronized float zzrg() {
        if (!zzaad()) {
            return 1.0f;
        }
        return this.zzdwd;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzdwi = z;
    }

    public final synchronized boolean zzrh() {
        return this.zzdwi;
    }

    private final synchronized boolean zzaad() {
        return this.zzdwd >= 0.0f;
    }

    public static float zzbj(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return ((float) streamVolume) / ((float) streamMaxVolume);
    }
}
