package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzchy implements zzebi<zzbfi> {
    private final /* synthetic */ String zzetu;
    private final /* synthetic */ zzaig zzglm;

    zzchy(zzchu zzchu, String str, zzaig zzaig) {
        this.zzetu = str;
        this.zzglm = zzaig;
    }

    public final void zzb(Throwable th) {
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbfi) obj).zza(this.zzetu, (zzaig<? super zzbfi>) this.zzglm);
    }
}
