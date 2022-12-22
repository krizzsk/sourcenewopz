package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public class zzemn {
    private static volatile boolean zziqj = false;
    private static boolean zziqk = true;
    private static volatile zzemn zziql;
    private static volatile zzemn zziqm;
    private static final zzemn zziqn = new zzemn(true);
    private final Map<zza, zzena.zzf<?, ?>> zziqo;

    public static zzemn zzbiv() {
        zzemn zzemn = zziql;
        if (zzemn == null) {
            synchronized (zzemn.class) {
                zzemn = zziql;
                if (zzemn == null) {
                    zzemn = zziqn;
                    zziql = zzemn;
                }
            }
        }
        return zzemn;
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    private static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    public static zzemn zzbiw() {
        Class<zzemn> cls = zzemn.class;
        zzemn zzemn = zziqm;
        if (zzemn != null) {
            return zzemn;
        }
        synchronized (cls) {
            zzemn zzemn2 = zziqm;
            if (zzemn2 != null) {
                return zzemn2;
            }
            zzemn zze = zzemy.zze(cls);
            zziqm = zze;
            return zze;
        }
    }

    public final <ContainingType extends zzeon> zzena.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zziqo.get(new zza(containingtype, i));
    }

    zzemn() {
        this.zziqo = new HashMap();
    }

    private zzemn(boolean z) {
        this.zziqo = Collections.emptyMap();
    }
}
