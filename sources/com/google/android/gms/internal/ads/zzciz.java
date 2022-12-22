package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzciz implements zzesa<zzuh.zza.C22026zza> {
    private final zzesn<zzdpm> zzfxn;

    public zzciz(zzesn<zzdpm> zzesn) {
        this.zzfxn = zzesn;
    }

    public final /* synthetic */ Object get() {
        zzuh.zza.C22026zza zza;
        if (this.zzfxn.get().zzhof.zzhnj == zzdpe.zzhnn) {
            zza = zzuh.zza.C22026zza.REWARDED_INTERSTITIAL;
        } else {
            zza = zzuh.zza.C22026zza.REWARD_BASED_VIDEO_AD;
        }
        return (zzuh.zza.C22026zza) zzesg.zzbd(zza);
    }
}
