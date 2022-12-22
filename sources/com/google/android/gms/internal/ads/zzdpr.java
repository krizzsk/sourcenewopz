package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdpr {
    public static zzdow zza(List<zzdow> list, zzdow zzdow) {
        return list.get(0);
    }

    public static zzvt zzb(Context context, List<zzdow> list) {
        ArrayList arrayList = new ArrayList();
        for (zzdow next : list) {
            if (next.zzhng) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(next.width, next.height));
            }
        }
        return new zzvt(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzdow zzh(zzvt zzvt) {
        if (zzvt.zzcit) {
            return new zzdow(-3, 0, true);
        }
        return new zzdow(zzvt.width, zzvt.height, false);
    }
}
