package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehz extends zzena<zzehz, zza> implements zzeop {
    private static volatile zzeow<zzehz> zzek;
    /* access modifiers changed from: private */
    public static final zzehz zziju;
    private int zzihi;
    private int zzijt;

    private zzehz() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehz, zza> implements zzeop {
        private zza() {
            super(zzehz.zziju);
        }

        /* synthetic */ zza(zzeia zzeia) {
            this();
        }
    }

    public final zzehs zzbes() {
        zzehs zzfp = zzehs.zzfp(this.zzijt);
        return zzfp == null ? zzehs.UNRECOGNIZED : zzfp;
    }

    public final int zzbch() {
        return this.zzihi;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeia.zzel[i - 1]) {
            case 1:
                return new zzehz();
            case 2:
                return new zza((zzeia) null);
            case 3:
                return zza((zzeon) zziju, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzijt", "zzihi"});
            case 4:
                return zziju;
            case 5:
                zzeow<zzehz> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehz.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziju);
                            zzek = zzeow;
                        }
                    }
                }
                return zzeow;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzehz zzbet() {
        return zziju;
    }

    static {
        zzehz zzehz = new zzehz();
        zziju = zzehz;
        zzena.zza(zzehz.class, zzehz);
    }
}
