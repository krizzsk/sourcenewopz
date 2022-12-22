package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzalr implements zzbbi<zzakv> {
    private final /* synthetic */ zzale zzdlf;
    private final /* synthetic */ zzalz zzdlh;

    zzalr(zzale zzale, zzalz zzalz) {
        this.zzdlf = zzale;
        this.zzdlh = zzalz;
    }

    public final /* synthetic */ void zzg(Object obj) {
        zzakv zzakv = (zzakv) obj;
        synchronized (this.zzdlf.lock) {
            int unused = this.zzdlf.status = 0;
            if (!(this.zzdlf.zzdku == null || this.zzdlh == this.zzdlf.zzdku)) {
                zzd.zzed("New JS engine is loaded, marking previous one as destroyable.");
                this.zzdlf.zzdku.zzuy();
            }
            zzalz unused2 = this.zzdlf.zzdku = this.zzdlh;
        }
    }
}
