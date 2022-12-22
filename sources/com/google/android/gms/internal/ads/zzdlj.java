package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdlj implements zzear {
    private final zzdlk zzhjr;
    private final zzdrj zzhjs;
    private final zzbqd zzhjt;

    zzdlj(zzdlk zzdlk, zzdrj zzdrj, zzbqd zzbqd) {
        this.zzhjr = zzdlk;
        this.zzhjs = zzdrj;
        this.zzhjt = zzbqd;
    }

    public final zzebt zzf(Object obj) {
        zzdrj zzdrj = this.zzhjs;
        zzbqd zzbqd = this.zzhjt;
        zzdpi zzdpi = (zzdpi) obj;
        zzdrj.zzfbh = zzdpi;
        Iterator<zzdot> it = zzdpi.zzhnt.zzhnq.iterator();
        boolean z = false;
        boolean z2 = false;
        loop0:
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            Iterator<String> it2 = it.next().zzhly.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!it2.next().contains("FirstPartyRenderer")) {
                        break loop0;
                    }
                    z2 = true;
                }
            }
        }
        if (!z) {
            return zzebh.zzag(null);
        }
        return zzbqd.zzb((zzebt<zzdpi>) zzebh.zzag(zzdpi));
    }
}
