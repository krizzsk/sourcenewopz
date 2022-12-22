package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeoc implements zzeok {
    private zzeok[] zzivm;

    zzeoc(zzeok... zzeokArr) {
        this.zzivm = zzeokArr;
    }

    public final boolean zzg(Class<?> cls) {
        for (zzeok zzg : this.zzivm) {
            if (zzg.zzg(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzeol zzh(Class<?> cls) {
        for (zzeok zzeok : this.zzivm) {
            if (zzeok.zzg(cls)) {
                return zzeok.zzh(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
