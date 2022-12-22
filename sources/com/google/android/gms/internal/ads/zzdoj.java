package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdoj implements zzdav<zzcip> {
    private final /* synthetic */ zzdoh zzhlt;

    zzdoj(zzdoh zzdoh) {
        this.zzhlt = zzdoh;
    }

    public final void zzatg() {
        synchronized (this.zzhlt) {
            zzcip unused = this.zzhlt.zzhls = null;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcip zzcip = (zzcip) obj;
        synchronized (this.zzhlt) {
            zzcip unused = this.zzhlt.zzhls = zzcip;
            this.zzhlt.zzhls.zzakv();
        }
    }
}
