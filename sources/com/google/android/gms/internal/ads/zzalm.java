package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzalm implements zzaig<zzamc> {
    private final /* synthetic */ zzei zzdlc;
    private final /* synthetic */ zzakv zzdld;
    private final /* synthetic */ zzbs zzdle;
    private final /* synthetic */ zzale zzdlf;

    zzalm(zzale zzale, zzei zzei, zzakv zzakv, zzbs zzbs) {
        this.zzdlf = zzale;
        this.zzdlc = zzei;
        this.zzdld = zzakv;
        this.zzdle = zzbs;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzamc zzamc = (zzamc) obj;
        synchronized (this.zzdlf.lock) {
            zzd.zzey("JS Engine is requesting an update");
            if (this.zzdlf.status == 0) {
                zzd.zzey("Starting reload.");
                int unused = this.zzdlf.status = 2;
                this.zzdlf.zza(this.zzdlc);
            }
            this.zzdld.zzb("/requestReload", (zzaig) this.zzdle.get());
        }
    }
}
