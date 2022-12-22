package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdmd implements zzdxw<zzcpo, zzdmf> {
    private final /* synthetic */ zzdmb zzhks;

    zzdmd(zzdmb zzdmb) {
        this.zzhks = zzdmb;
    }

    @NullableDecl
    public final /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbao.zzc("", (zzcpo) obj);
        zzd.zzed("Failed to get a cache key, reverting to legacy flow.");
        zzdmb zzdmb = this.zzhks;
        zzdmf unused = zzdmb.zzhkq = new zzdmf((zzauj) null, zzdmb.zzavs(), (zzdmd) null);
        return this.zzhks.zzhkq;
    }
}
