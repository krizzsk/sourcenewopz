package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcbz implements zzbph<zzbpi> {
    private final zzcdy zzfwx;
    private final Map<String, zzcsz<zzbpi>> zzfyr;
    private final zzesn<zzbph<zzbne>> zzgeb;
    private final Map<String, zzcsz<zzcdf>> zzgec;
    private final Map<String, zzcvm<zzcdf>> zzged;

    zzcbz(Map<String, zzcsz<zzbpi>> map, Map<String, zzcsz<zzcdf>> map2, Map<String, zzcvm<zzcdf>> map3, zzesn<zzbph<zzbne>> zzesn, zzcdy zzcdy) {
        this.zzfyr = map;
        this.zzgec = map2;
        this.zzged = map3;
        this.zzgeb = zzesn;
        this.zzfwx = zzcdy;
    }

    public final zzcsz<zzbpi> zze(int i, String str) {
        zzcsz zze;
        zzcsz<zzbpi> zzcsz = this.zzfyr.get(str);
        if (zzcsz != null) {
            return zzcsz;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzcvm zzcvm = this.zzged.get(str);
            if (zzcvm != null) {
                return zzbpi.zza((zzcvm<? extends zzbpc>) zzcvm);
            }
            zzcsz zzcsz2 = this.zzgec.get(str);
            if (zzcsz2 != null) {
                return zzbpi.zza((zzcsz<? extends zzbpc>) zzcsz2);
            }
            return null;
        } else if (this.zzfwx.zzapg() == null || (zze = this.zzgeb.get().zze(i, str)) == null) {
            return null;
        } else {
            return zzbpi.zza((zzcsz<? extends zzbpc>) zze);
        }
    }
}
