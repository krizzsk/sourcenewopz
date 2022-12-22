package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzel<T extends zzek<T>> {
    private static final zzel zzb = new zzel(true);
    final zzgl<T, Object> zza = new zzge(16);
    private boolean zzc;
    private boolean zzd;

    private zzel() {
    }

    public static <T extends zzek<T>> zzel<T> zza() {
        throw null;
    }

    private static final void zzd(T t, Object obj) {
        boolean z;
        zzhe zzb2 = t.zzb();
        zzev.zze(obj);
        zzhe zzhe = zzhe.DOUBLE;
        zzhf zzhf = zzhf.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzeb) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzes)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzfq) || (obj instanceof zzex)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t.zza()), t.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzel zzel = new zzel();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry<T, Object> zzg = this.zza.zzg(i);
            zzel.zzc((zzek) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry next : this.zza.zzc()) {
            zzel.zzc((zzek) next.getKey(), next.getValue());
        }
        zzel.zzd = this.zzd;
        return zzel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzel)) {
            return false;
        }
        return this.zza.equals(((zzel) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(T t, Object obj) {
        if (!t.zzc()) {
            zzd(t, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(t, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzex) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    private zzel(boolean z) {
        zzb();
        zzb();
    }
}
