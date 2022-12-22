package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcur implements Callable {
    private final zzdot zzfxi;
    private final zzdpi zzgjy;
    private final zzcuo zzgwx;

    zzcur(zzcuo zzcuo, zzdpi zzdpi, zzdot zzdot) {
        this.zzgwx = zzcuo;
        this.zzgjy = zzdpi;
        this.zzfxi = zzdot;
    }

    public final Object call() {
        return this.zzgwx.zzc(this.zzgjy, this.zzfxi);
    }
}
