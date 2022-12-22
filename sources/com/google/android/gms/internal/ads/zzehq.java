package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehq extends zzena<zzehq, zza> implements zzeop {
    private static volatile zzeow<zzehq> zzek;
    /* access modifiers changed from: private */
    public static final zzehq zzijb;
    private int zziiy;
    private int zziiz;
    private zzelq zzija = zzelq.zzipc;

    private zzehq() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehq, zza> implements zzeop {
        private zza() {
            super(zzehq.zzijb);
        }

        /* synthetic */ zza(zzehp zzehp) {
            this();
        }
    }

    public final zzehr zzbeh() {
        zzehr zzfo = zzehr.zzfo(this.zziiy);
        return zzfo == null ? zzehr.UNRECOGNIZED : zzfo;
    }

    public final zzehs zzbei() {
        zzehs zzfp = zzehs.zzfp(this.zziiz);
        return zzfp == null ? zzehs.UNRECOGNIZED : zzfp;
    }

    public final zzelq zzbej() {
        return this.zzija;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehp.zzel[i - 1]) {
            case 1:
                return new zzehq();
            case 2:
                return new zza((zzehp) null);
            case 3:
                return zza((zzeon) zzijb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zziiy", "zziiz", "zzija"});
            case 4:
                return zzijb;
            case 5:
                zzeow<zzehq> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehq.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzijb);
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

    public static zzehq zzbek() {
        return zzijb;
    }

    static {
        zzehq zzehq = new zzehq();
        zzijb = zzehq;
        zzena.zza(zzehq.class, zzehq);
    }
}
