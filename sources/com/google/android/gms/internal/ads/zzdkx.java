package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdkx implements zzdav<zzbmz> {
    private final /* synthetic */ zzdkt zzhjf;

    zzdkx(zzdkt zzdkt) {
        this.zzhjf = zzdkt;
    }

    public final void zzatg() {
        synchronized (this.zzhjf) {
            this.zzhjf.zzhjd = null;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbmz zzbmz = (zzbmz) obj;
        synchronized (this.zzhjf) {
            if (this.zzhjf.zzhjd != null) {
                this.zzhjf.zzhjd.destroy();
            }
            this.zzhjf.zzhjd = zzbmz;
            this.zzhjf.zza(zzbmz);
            this.zzhjf.zzhia.zzb((zzsp) new zzbmy(zzbmz, this.zzhjf, this.zzhjf.zzhia));
            zzbmz.zzakv();
        }
    }
}
