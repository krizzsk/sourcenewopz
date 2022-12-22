package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcep implements Runnable {
    private final zzcen zzgih;
    private final ViewGroup zzgin;

    zzcep(zzcen zzcen, ViewGroup viewGroup) {
        this.zzgih = zzcen;
        this.zzgin = viewGroup;
    }

    public final void run() {
        this.zzgih.zzb(this.zzgin);
    }
}
