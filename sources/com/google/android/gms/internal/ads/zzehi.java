package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehi extends zzena<zzehi, zza> implements zzeop {
    private static volatile zzeow<zzehi> zzek;
    /* access modifiers changed from: private */
    public static final zzehi zziio;
    private zzehj zziin;

    private zzehi() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehi, zza> implements zzeop {
        private zza() {
            super(zzehi.zziio);
        }

        /* synthetic */ zza(zzehh zzehh) {
            this();
        }
    }

    public final zzehj zzbds() {
        zzehj zzehj = this.zziin;
        return zzehj == null ? zzehj.zzbdx() : zzehj;
    }

    public static zzehi zzq(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzehi) zzena.zza(zziio, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehh.zzel[i - 1]) {
            case 1:
                return new zzehi();
            case 2:
                return new zza((zzehh) null);
            case 3:
                return zza((zzeon) zziio, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zziin"});
            case 4:
                return zziio;
            case 5:
                zzeow<zzehi> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehi.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziio);
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
        zzehi zzehi = new zzehi();
        zziio = zzehi;
        zzena.zza(zzehi.class, zzehi);
    }
}
