package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbjl {
    private zza zzfsn;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static abstract class zza {
        public abstract zzbes zzags();

        public abstract zzbcc zzagt();

        public abstract zzue zzagu();

        public abstract zzaxq zzagv();

        public abstract zzaso zzagw();

        public abstract zzacw zzagx();
    }

    public zzbjl(zza zza2) {
        this.zzfsn = zza2;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzaxl, com.google.android.gms.internal.ads.zzaxr] */
    public final zzb zzajh() {
        zza zza2 = this.zzfsn;
        return new zzb(zza2.zzags(), zza2.zzagt(), new zzaxl(zza2.zzagv()), zza2.zzagu(), zza2.zzagw(), zza2.zzagx());
    }

    public final zzaxq zzagv() {
        return this.zzfsn.zzagv();
    }

    public final zzaso zzagw() {
        return this.zzfsn.zzagw();
    }

    public final zzacw zzagx() {
        return this.zzfsn.zzagx();
    }
}
