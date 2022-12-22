package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcsy<DelegateT, AdapterT> implements zzcsz<AdapterT> {
    private final zzcsz<DelegateT> zzgvi;
    private final zzdxw<DelegateT, AdapterT> zzgvj;

    public zzcsy(zzcsz<DelegateT> zzcsz, zzdxw<DelegateT, AdapterT> zzdxw) {
        this.zzgvi = zzcsz;
        this.zzgvj = zzdxw;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return this.zzgvi.zza(zzdpi, zzdot);
    }

    public final zzebt<AdapterT> zzb(zzdpi zzdpi, zzdot zzdot) {
        return zzebh.zzb(this.zzgvi.zzb(zzdpi, zzdot), this.zzgvj, (Executor) zzbat.zzeke);
    }
}
