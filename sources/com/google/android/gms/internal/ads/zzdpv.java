package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdpv implements zzaig {
    private final zzdup zzhol;
    private final zzcsh zzhom;

    zzdpv(zzdup zzdup, zzcsh zzcsh) {
        this.zzhol = zzdup;
        this.zzhom = zzcsh;
    }

    public final void zza(Object obj, Map map) {
        zzdup zzdup = this.zzhol;
        zzcsh zzcsh = this.zzhom;
        zzbex zzbex = (zzbex) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzd.zzez("URL missing from httpTrack GMSG.");
        } else if (!zzbex.zzadk().zzhmz) {
            zzdup.zzen(str);
        } else {
            zzcsh.zza(new zzcso(zzr.zzlc().currentTimeMillis(), ((zzbgd) zzbex).zzaev().zzbwe, str, zzcse.zzgui));
        }
    }
}
