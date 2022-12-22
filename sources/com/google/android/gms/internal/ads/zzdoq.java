package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdoq implements zzdav<zzcip> {
    private final /* synthetic */ zzdon zzhlw;

    zzdoq(zzdon zzdon) {
        this.zzhlw = zzdon;
    }

    public final void zzatg() {
        synchronized (this.zzhlw) {
            zzcip unused = this.zzhlw.zzhls = null;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcip zzcip = (zzcip) obj;
        synchronized (this.zzhlw) {
            zzcip unused = this.zzhlw.zzhls = zzcip;
            this.zzhlw.zzhls.zzakv();
        }
    }
}
