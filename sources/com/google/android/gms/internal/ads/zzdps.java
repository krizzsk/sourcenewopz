package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdps implements zzaig {
    private final zzdup zzhol;
    private final zzcsh zzhom;

    zzdps(zzdup zzdup, zzcsh zzcsh) {
        this.zzhol = zzdup;
        this.zzhom = zzcsh;
    }

    /* JADX WARNING: type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbgk, com.google.android.gms.internal.ads.zzbex] */
    public final void zza(Object obj, Map map) {
        int i;
        zzdup zzdup = this.zzhol;
        zzcsh zzcsh = this.zzhom;
        ? r9 = (zzbex) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzd.zzez("URL missing from click GMSG.");
            return;
        }
        String zza = zzahr.zza(r9, str);
        if (!r9.zzadk().zzhmz) {
            zzdup.zzen(zza);
            return;
        }
        long currentTimeMillis = zzr.zzlc().currentTimeMillis();
        String str2 = r9.zzaev().zzbwe;
        zzr.zzkv();
        if (zzj.zzbd(((zzbgk) r9).getContext())) {
            i = zzcse.zzgui;
        } else {
            i = zzcse.zzguh;
        }
        zzcsh.zza(new zzcso(currentTimeMillis, str2, zza, i));
    }
}
