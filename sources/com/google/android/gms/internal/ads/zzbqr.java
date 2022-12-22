package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqr implements zzbsy, zzbtq, zzbuj, zzbvm, zzve {
    private final Clock zzbqq;
    private final zzazr zzfzw;

    public zzbqr(Clock clock, zzazr zzazr) {
        this.zzbqq = clock;
        this.zzfzw = zzazr;
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzavd zzavd, String str, String str2) {
    }

    public final void zzd(zzauj zzauj) {
    }

    public final void onAdClicked() {
        this.zzfzw.zzyc();
    }

    public final void onAdLoaded() {
        this.zzfzw.zzar(true);
    }

    public final void onAdImpression() {
        this.zzfzw.zzyb();
    }

    public final void zzf(zzvq zzvq) {
        this.zzfzw.zze(zzvq);
    }

    public final void zzd(zzdpi zzdpi) {
        this.zzfzw.zzey(this.zzbqq.elapsedRealtime());
    }

    public final void onAdClosed() {
        this.zzfzw.zzyd();
    }

    public final String zzye() {
        return this.zzfzw.zzye();
    }
}
