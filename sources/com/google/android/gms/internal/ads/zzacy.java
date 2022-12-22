package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class zzacy<T> {
    private final String zzcm;
    private final T zzcmg;
    private final int zzddk;

    public static zzacy<Boolean> zzg(String str, boolean z) {
        return new zzacy<>(str, Boolean.valueOf(z), zzada.zzddl);
    }

    public static zzacy<Long> zzb(String str, long j) {
        return new zzacy<>(str, Long.valueOf(j), zzada.zzddm);
    }

    public static zzacy<Double> zzb(String str, double d) {
        return new zzacy<>(str, Double.valueOf(d), zzada.zzddn);
    }

    public static zzacy<String> zzh(String str, String str2) {
        return new zzacy<>(str, str2, zzada.zzddo);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected zzacy(java.lang.String r1, T r2, java.lang.Integer r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzcm = r1
            r0.zzcmg = r2
            r0.zzddk = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacy.<init>(java.lang.String, java.lang.Object, int):void");
    }

    public T get() {
        zzady zzti = zzaeb.zzti();
        if (zzti != null) {
            int i = zzadb.zzddq[this.zzddk - 1];
            if (i == 1) {
                return zzti.zzf(this.zzcm, ((Boolean) this.zzcmg).booleanValue());
            }
            if (i == 2) {
                return zzti.getLong(this.zzcm, ((Long) this.zzcmg).longValue());
            }
            if (i == 3) {
                return zzti.zza(this.zzcm, ((Double) this.zzcmg).doubleValue());
            }
            if (i == 4) {
                return zzti.get(this.zzcm, (String) this.zzcmg);
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException("Flag is not initialized.");
    }
}
