package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcea {
    zzafx zzghj;
    zzafs zzghk;
    zzagl zzghl;
    zzagg zzghm;
    zzakg zzghn;
    final SimpleArrayMap<String, zzagd> zzgho = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzafy> zzghp = new SimpleArrayMap<>();

    public final zzcea zzb(zzafx zzafx) {
        this.zzghj = zzafx;
        return this;
    }

    public final zzcea zzb(zzafs zzafs) {
        this.zzghk = zzafs;
        return this;
    }

    public final zzcea zzb(zzagl zzagl) {
        this.zzghl = zzagl;
        return this;
    }

    public final zzcea zza(zzagg zzagg) {
        this.zzghm = zzagg;
        return this;
    }

    public final zzcea zzb(zzakg zzakg) {
        this.zzghn = zzakg;
        return this;
    }

    public final zzcea zzb(String str, zzagd zzagd, zzafy zzafy) {
        this.zzgho.put(str, zzagd);
        this.zzghp.put(str, zzafy);
        return this;
    }

    public final zzcdy zzapk() {
        return new zzcdy(this);
    }
}
