package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzabr implements zzady {
    private final /* synthetic */ zzabm zzdbs;

    zzabr(zzabm zzabm) {
        this.zzdbs = zzabm;
    }

    public final Boolean zzf(String str, boolean z) {
        return Boolean.valueOf(this.zzdbs.zzcmn.getBoolean(str, z));
    }

    public final Long getLong(String str, long j) {
        try {
            return Long.valueOf(this.zzdbs.zzcmn.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.zzdbs.zzcmn.getInt(str, (int) j));
        }
    }

    public final Double zza(String str, double d) {
        return Double.valueOf((double) this.zzdbs.zzcmn.getFloat(str, (float) d));
    }

    public final String get(String str, String str2) {
        return this.zzdbs.zzcmn.getString(str, str2);
    }
}
