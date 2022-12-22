package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdao implements zzdav<zzbpc> {
    private final /* synthetic */ zzdap zzhbs;

    zzdao(zzdap zzdap) {
        this.zzhbs = zzdap;
    }

    public final void zzatg() {
        synchronized (this.zzhbs) {
            boolean unused = this.zzhbs.zzafk = false;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbpc zzbpc = (zzbpc) obj;
        synchronized (this.zzhbs) {
            boolean unused = this.zzhbs.zzafk = false;
            zzzc unused2 = this.zzhbs.zzaec = zzbpc.zzall();
            zzbpc.zzakv();
        }
    }
}
