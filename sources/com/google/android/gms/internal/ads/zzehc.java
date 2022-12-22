package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehc extends zzena<zzehc, zza> implements zzeop {
    private static volatile zzeow<zzehc> zzek;
    /* access modifiers changed from: private */
    public static final zzehc zziie;

    private zzehc() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehc, zza> implements zzeop {
        private zza() {
            super(zzehc.zziie);
        }

        /* synthetic */ zza(zzehb zzehb) {
            this();
        }
    }

    public static zzehc zzp(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzehc) zzena.zza(zziie, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehb.zzel[i - 1]) {
            case 1:
                return new zzehc();
            case 2:
                return new zza((zzehb) null);
            case 3:
                return zza((zzeon) zziie, "\u0000\u0000", (Object[]) null);
            case 4:
                return zziie;
            case 5:
                zzeow<zzehc> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehc.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziie);
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

    static {
        zzehc zzehc = new zzehc();
        zziie = zzehc;
        zzena.zza(zzehc.class, zzehc);
    }
}
