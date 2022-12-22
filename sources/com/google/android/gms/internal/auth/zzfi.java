package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzfi implements zzgc {
    private static final zzfo zza = new zzfg();
    private final zzfo zzb;

    public zzfi() {
        zzfo zzfo;
        zzfo[] zzfoArr = new zzfo[2];
        zzfoArr[0] = zzen.zza();
        try {
            zzfo = (zzfo) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzfo = zza;
        }
        zzfoArr[1] = zzfo;
        zzfh zzfh = new zzfh(zzfoArr);
        zzev.zzf(zzfh, "messageInfoFactory");
        this.zzb = zzfh;
    }

    private static boolean zzb(zzfn zzfn) {
        return zzfn.zzc() == 1;
    }

    public final <T> zzgb<T> zza(Class<T> cls) {
        zzgd.zzg(cls);
        zzfn zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzeq.class.isAssignableFrom(cls)) {
                return zzfu.zzb(zzgd.zzc(), zzej.zzb(), zzb2.zza());
            }
            return zzfu.zzb(zzgd.zza(), zzej.zza(), zzb2.zza());
        } else if (zzeq.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzft.zzj(cls, zzb2, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), zzej.zzb(), zzfm.zzb());
            }
            return zzft.zzj(cls, zzb2, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), (zzeh<?>) null, zzfm.zzb());
        } else if (zzb(zzb2)) {
            return zzft.zzj(cls, zzb2, zzfw.zza(), zzfe.zzc(), zzgd.zza(), zzej.zza(), zzfm.zza());
        } else {
            return zzft.zzj(cls, zzb2, zzfw.zza(), zzfe.zzc(), zzgd.zzb(), (zzeh<?>) null, zzfm.zza());
        }
    }
}
