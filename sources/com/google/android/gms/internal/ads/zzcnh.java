package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnh implements Runnable {
    private final Object zzdms;
    private final String zzgng;
    private final zzcna zzgpl;
    private final zzbbe zzgpo;
    private final long zzgpp;

    zzcnh(zzcna zzcna, Object obj, zzbbe zzbbe, String str, long j) {
        this.zzgpl = zzcna;
        this.zzdms = obj;
        this.zzgpo = zzbbe;
        this.zzgng = str;
        this.zzgpp = j;
    }

    public final void run() {
        this.zzgpl.zza(this.zzdms, this.zzgpo, this.zzgng, this.zzgpp);
    }
}
