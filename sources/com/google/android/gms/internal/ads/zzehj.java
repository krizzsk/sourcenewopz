package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehj extends zzena<zzehj, zza> implements zzeop {
    private static volatile zzeow<zzehj> zzek;
    /* access modifiers changed from: private */
    public static final zzehj zziis;
    private zzehq zziip;
    private zzehe zziiq;
    private int zziir;

    private zzehj() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehj, zza> implements zzeop {
        private zza() {
            super(zzehj.zziis);
        }

        /* synthetic */ zza(zzehk zzehk) {
            this();
        }
    }

    public final zzehq zzbdu() {
        zzehq zzehq = this.zziip;
        return zzehq == null ? zzehq.zzbek() : zzehq;
    }

    public final zzehe zzbdv() {
        zzehe zzehe = this.zziiq;
        return zzehe == null ? zzehe.zzbdq() : zzehe;
    }

    public final zzehd zzbdw() {
        zzehd zzfl = zzehd.zzfl(this.zziir);
        return zzfl == null ? zzehd.UNRECOGNIZED : zzfl;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehk.zzel[i - 1]) {
            case 1:
                return new zzehj();
            case 2:
                return new zza((zzehk) null);
            case 3:
                return zza((zzeon) zziis, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zziip", "zziiq", "zziir"});
            case 4:
                return zziis;
            case 5:
                zzeow<zzehj> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehj.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziis);
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

    public static zzehj zzbdx() {
        return zziis;
    }

    static {
        zzehj zzehj = new zzehj();
        zziis = zzehj;
        zzena.zza(zzehj.class, zzehj);
    }
}
