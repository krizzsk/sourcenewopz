package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdr implements zzdwd {
    private final /* synthetic */ zzduv zzvr;

    zzdr(zzduv zzduv) {
        this.zzvr = zzduv;
    }

    public final void zza(int i, long j) {
        this.zzvr.zzh(i, System.currentTimeMillis() - j);
    }

    public final void zza(int i, long j, String str) {
        this.zzvr.zzb(i, System.currentTimeMillis() - j, str);
    }
}
