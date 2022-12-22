package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeoa implements zzepl {
    private static final zzeok zzivj = new zzeod();
    private final zzeok zzivi;

    public zzeoa() {
        this(new zzeoc(zzenb.zzbjq(), zzbkp()));
    }

    private zzeoa(zzeok zzeok) {
        this.zzivi = (zzeok) zzenc.zza(zzeok, "messageInfoFactory");
    }

    public final <T> zzepi<T> zzi(Class<T> cls) {
        zzepk.zzk(cls);
        zzeol zzh = this.zzivi.zzh(cls);
        if (zzh.zzbky()) {
            if (zzena.class.isAssignableFrom(cls)) {
                return zzeot.zza(zzepk.zzblm(), zzemq.zzbiy(), zzh.zzbkz());
            }
            return zzeot.zza(zzepk.zzblk(), zzemq.zzbiz(), zzh.zzbkz());
        } else if (zzena.class.isAssignableFrom(cls)) {
            if (zza(zzh)) {
                return zzeor.zza(cls, zzh, zzeox.zzblb(), zzenx.zzbko(), zzepk.zzblm(), zzemq.zzbiy(), zzeoi.zzbkv());
            }
            return zzeor.zza(cls, zzh, zzeox.zzblb(), zzenx.zzbko(), zzepk.zzblm(), (zzemp<?>) null, zzeoi.zzbkv());
        } else if (zza(zzh)) {
            return zzeor.zza(cls, zzh, zzeox.zzbla(), zzenx.zzbkn(), zzepk.zzblk(), zzemq.zzbiz(), zzeoi.zzbku());
        } else {
            return zzeor.zza(cls, zzh, zzeox.zzbla(), zzenx.zzbkn(), zzepk.zzbll(), (zzemp<?>) null, zzeoi.zzbku());
        }
    }

    private static boolean zza(zzeol zzeol) {
        return zzeol.zzbkx() == zzeoy.zziwn;
    }

    private static zzeok zzbkp() {
        try {
            return (zzeok) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzivj;
        }
    }
}
