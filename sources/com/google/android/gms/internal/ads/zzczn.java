package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzczn implements zzdav<zzbne> {
    private final /* synthetic */ zzczk zzhbc;

    zzczn(zzczk zzczk) {
        this.zzhbc = zzczk;
    }

    public final void zzatg() {
        synchronized (this.zzhbc) {
            zzbne unused = this.zzhbc.zzhah = null;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbne zzbne = (zzbne) obj;
        synchronized (this.zzhbc) {
            if (this.zzhbc.zzhah != null) {
                this.zzhbc.zzhah.destroy();
            }
            zzbne unused = this.zzhbc.zzhah = zzbne;
            this.zzhbc.zzhah.zzakv();
        }
    }
}
