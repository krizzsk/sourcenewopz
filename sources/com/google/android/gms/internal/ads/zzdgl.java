package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgl implements zzdhe<zzdgm> {
    private final Context context;
    private final zzayd zzbrf;
    private final zzebs zzgka;

    public zzdgl(zzayd zzayd, zzebs zzebs, Context context2) {
        this.zzbrf = zzayd;
        this.zzgka = zzebs;
        this.context = context2;
    }

    public final zzebt<zzdgm> zzatu() {
        return this.zzgka.zze(new zzdgo(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdgm zzaum() throws Exception {
        String str;
        String str2;
        String str3;
        if (!this.zzbrf.zzaa(this.context)) {
            return new zzdgm((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzad = this.zzbrf.zzad(this.context);
        String str4 = zzad == null ? "" : zzad;
        String zzae = this.zzbrf.zzae(this.context);
        if (zzae == null) {
            str = "";
        } else {
            str = zzae;
        }
        String zzaf = this.zzbrf.zzaf(this.context);
        if (zzaf == null) {
            str2 = "";
        } else {
            str2 = zzaf;
        }
        String zzag = this.zzbrf.zzag(this.context);
        if (zzag == null) {
            str3 = "";
        } else {
            str3 = zzag;
        }
        return new zzdgm(str4, str, str2, str3, "TIME_OUT".equals(str) ? (Long) zzww.zzra().zzd(zzabq.zzcot) : null);
    }
}
