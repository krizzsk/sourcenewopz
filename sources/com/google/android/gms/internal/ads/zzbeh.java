package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbeh implements Iterable<zzbef> {
    private final List<zzbef> zzerq = new ArrayList();

    public static boolean zzc(zzbcs zzbcs) {
        zzbef zzd = zzd(zzbcs);
        if (zzd == null) {
            return false;
        }
        zzd.zzerp.abort();
        return true;
    }

    static zzbef zzd(zzbcs zzbcs) {
        Iterator<zzbef> it = zzr.zzlr().iterator();
        while (it.hasNext()) {
            zzbef next = it.next();
            if (next.zzekz == zzbcs) {
                return next;
            }
        }
        return null;
    }

    public final void zza(zzbef zzbef) {
        this.zzerq.add(zzbef);
    }

    public final void zzb(zzbef zzbef) {
        this.zzerq.remove(zzbef);
    }

    public final Iterator<zzbef> iterator() {
        return this.zzerq.iterator();
    }
}
