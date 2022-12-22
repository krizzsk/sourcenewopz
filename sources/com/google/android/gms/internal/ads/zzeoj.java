package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeoj implements zzeog {
    zzeoj() {
    }

    public final Map<?, ?> zzan(Object obj) {
        return (zzeoh) obj;
    }

    public final zzeoe<?, ?> zzas(Object obj) {
        zzeof zzeof = (zzeof) obj;
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzao(Object obj) {
        return (zzeoh) obj;
    }

    public final boolean zzap(Object obj) {
        return !((zzeoh) obj).isMutable();
    }

    public final Object zzaq(Object obj) {
        ((zzeoh) obj).zzbhe();
        return obj;
    }

    public final Object zzar(Object obj) {
        return zzeoh.zzbkr().zzbks();
    }

    public final Object zzf(Object obj, Object obj2) {
        zzeoh zzeoh = (zzeoh) obj;
        zzeoh zzeoh2 = (zzeoh) obj2;
        if (!zzeoh2.isEmpty()) {
            if (!zzeoh.isMutable()) {
                zzeoh = zzeoh.zzbks();
            }
            zzeoh.zza(zzeoh2);
        }
        return zzeoh;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzeoh zzeoh = (zzeoh) obj;
        zzeof zzeof = (zzeof) obj2;
        if (zzeoh.isEmpty()) {
            return 0;
        }
        Iterator it = zzeoh.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
