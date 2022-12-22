package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeir extends zzena<zzeir, zza> implements zzeop {
    private static volatile zzeow<zzeir> zzek;
    /* access modifiers changed from: private */
    public static final zzeir zzilg;
    private String zzilf = "";

    private zzeir() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzeir, zza> implements zzeop {
        private zza() {
            super(zzeir.zzilg);
        }

        /* synthetic */ zza(zzeiq zzeiq) {
            this();
        }
    }

    public final String zzbfx() {
        return this.zzilf;
    }

    public static zzeir zzw(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzeir) zzena.zza(zzilg, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeiq.zzel[i - 1]) {
            case 1:
                return new zzeir();
            case 2:
                return new zza((zzeiq) null);
            case 3:
                return zza((zzeon) zzilg, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzilf"});
            case 4:
                return zzilg;
            case 5:
                zzeow<zzeir> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzeir.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzilg);
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

    public static zzeir zzbfy() {
        return zzilg;
    }

    static {
        zzeir zzeir = new zzeir();
        zzilg = zzeir;
        zzena.zza(zzeir.class, zzeir);
    }
}
