package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddp implements zzdhe<zzddq> {
    private final Context context;
    private final zzebs zzgka;

    public zzddp(zzebs zzebs, Context context2) {
        this.zzgka = zzebs;
        this.context = context2;
    }

    public final zzebt<zzddq> zzatu() {
        return this.zzgka.zze(new zzdds(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzddq zzaub() throws Exception {
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        return new zzddq(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzr.zzla().zzrg(), zzr.zzla().zzrh());
    }
}
