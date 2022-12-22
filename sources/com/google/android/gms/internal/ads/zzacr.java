package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzacr extends zzacp {
    private final OnCustomRenderedAdLoadedListener zzckv;

    public zzacr(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzckv = onCustomRenderedAdLoadedListener;
    }

    public final void zza(zzacl zzacl) {
        this.zzckv.onCustomRenderedAdLoaded(new zzaci(zzacl));
    }
}
