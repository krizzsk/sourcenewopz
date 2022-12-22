package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbvl extends AdMetadataListener implements AppEventListener, zzp, zzbsy, zzbtm, zzbtq, zzbus, zzbvb, zzve {
    private final zzbwp zzgcb = new zzbwp(this);
    /* access modifiers changed from: private */
    @Nullable
    public zzczm zzgcc;
    /* access modifiers changed from: private */
    @Nullable
    public zzdaj zzgcd;
    /* access modifiers changed from: private */
    @Nullable
    public zzdkd zzgce;
    /* access modifiers changed from: private */
    @Nullable
    public zzdnb zzgcf;

    public final zzbwp zzaln() {
        return this.zzgcb;
    }

    public final void onAdOpened() {
        zza(this.zzgcc, zzbvo.zzgcg);
        zza(this.zzgcf, zzbvn.zzgcg);
    }

    public final void onAdClosed() {
        zza(this.zzgcc, zzbwa.zzgcg);
        zza(this.zzgcf, zzbwh.zzgcg);
    }

    public final void onAdLeftApplication() {
        zza(this.zzgcc, zzbwk.zzgcg);
        zza(this.zzgcf, zzbwj.zzgcg);
    }

    public final void onRewardedVideoStarted() {
        zza(this.zzgcc, zzbwm.zzgcg);
        zza(this.zzgcf, zzbwl.zzgcg);
    }

    public final void zzb(zzavd zzavd, String str, String str2) {
        zza(this.zzgcc, new zzbwo(zzavd, str, str2));
        zza(this.zzgcf, new zzbwn(zzavd, str, str2));
    }

    public final void onRewardedVideoCompleted() {
        zza(this.zzgcc, zzbvq.zzgcg);
        zza(this.zzgcf, zzbvp.zzgcg);
    }

    public final void onAdClicked() {
        zza(this.zzgcc, zzbvs.zzgcg);
        zza(this.zzgcd, zzbvr.zzgcg);
    }

    public final void onAppEvent(String str, String str2) {
        zza(this.zzgcc, new zzbvu(str, str2));
    }

    public final void zzb(zzvv zzvv) {
        zza(this.zzgcc, new zzbvt(zzvv));
        zza(this.zzgcf, new zzbvw(zzvv));
        zza(this.zzgce, new zzbvv(zzvv));
    }

    public final void onAdImpression() {
        zza(this.zzgcc, zzbvy.zzgcg);
    }

    public final void zzamk() {
        zza(this.zzgce, zzbvx.zzgcg);
    }

    public final void onAdMetadataChanged() {
        zza(this.zzgcf, zzbvz.zzgcg);
    }

    public final void zzk(zzvh zzvh) {
        zza(this.zzgcf, new zzbwc(zzvh));
        zza(this.zzgcc, new zzbwb(zzvh));
    }

    public final void zzvz() {
        zza(this.zzgce, zzbwe.zzgcg);
    }

    public final void zza(zzl zzl) {
        zza(this.zzgce, new zzbwd(zzl));
    }

    public final void onUserLeaveHint() {
        zza(this.zzgce, zzbwg.zzgcg);
    }

    public final void onPause() {
        zza(this.zzgce, zzbwf.zzgcg);
    }

    public final void onResume() {
        zza(this.zzgce, zzbwi.zzgcg);
    }

    private static <T> void zza(T t, zzbws<T> zzbws) {
        if (t != null) {
            zzbws.zzp(t);
        }
    }
}
