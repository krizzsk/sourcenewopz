package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzb extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmn;

    zzb(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmn = abstractAdViewAdapter;
    }

    public final void onAdMetadataChanged() {
        if (this.zzmn.zzms != null && this.zzmn.zzmt != null) {
            this.zzmn.zzmt.zzb(this.zzmn.zzms.getAdMetadata());
        }
    }
}
