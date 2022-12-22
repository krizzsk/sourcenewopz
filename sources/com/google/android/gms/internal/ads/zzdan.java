package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdan implements zzdav<zzcaj> {
    private final /* synthetic */ zzdak zzhbr;

    zzdan(zzdak zzdak) {
        this.zzhbr = zzdak;
    }

    public final void zzatg() {
        synchronized (this.zzhbr) {
            zzcaj unused = this.zzhbr.zzhbj = null;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcaj zzcaj = (zzcaj) obj;
        synchronized (this.zzhbr) {
            zzcaj unused = this.zzhbr.zzhbj = zzcaj;
            this.zzhbr.zzhbj.zzakv();
        }
    }
}
