package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfp implements zzdhe<zzdfq> {
    private final Context context;
    private final zzebs zzhdd;
    private final Set<String> zzhdr;

    public zzdfp(zzebs zzebs, Context context2, Set<String> set) {
        this.zzhdd = zzebs;
        this.context = context2;
        this.zzhdr = set;
    }

    public final zzebt<zzdfq> zzatu() {
        return this.zzhdd.zze(new zzdfs(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfq zzaui() throws Exception {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() || !zzdfq.zze(this.zzhdr)) {
            return new zzdfq((String) null);
        }
        return new zzdfq(zzr.zzlk().getVersion(this.context));
    }
}
