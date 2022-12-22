package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdrs implements zzebi<zzdrj<AdT>> {
    private final /* synthetic */ zzdrr zzhrz;

    zzdrs(zzdrr zzdrr) {
        this.zzhrz = zzdrr;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzhrz) {
            this.zzhrz.zzhrw.zzb(th);
            this.zzhrz.zzhrt.setException(th);
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdrj zzdrj = (zzdrj) obj;
        synchronized (this.zzhrz) {
            this.zzhrz.zzhrw.zza(zzdrj);
            if (this.zzhrz.zzhrv != zzdrw.zzhsc) {
                this.zzhrz.zzhkm.zza(this.zzhrz.zzhrs.zzavp(), zzdrj);
            }
            if (this.zzhrz.zzhrv == zzdrw.zzhsb) {
                this.zzhrz.zzd(this.zzhrz.zzhrs);
            }
            int unused = this.zzhrz.zzhrv = zzdrw.zzhsb;
            this.zzhrz.zzhrt.set(zzdrj);
        }
    }
}
