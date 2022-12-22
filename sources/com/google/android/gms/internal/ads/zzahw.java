package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzahw implements zzaig<zzbfi> {
    zzahw() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        if (zzbfi.zzaet() != null) {
            zzbfi.zzaet().zzmz();
        }
        zze zzaeb = zzbfi.zzaeb();
        if (zzaeb != null) {
            zzaeb.close();
            return;
        }
        zze zzaec = zzbfi.zzaec();
        if (zzaec != null) {
            zzaec.close();
        } else {
            zzd.zzez("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
