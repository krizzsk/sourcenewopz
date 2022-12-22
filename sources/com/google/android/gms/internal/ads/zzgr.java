package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzgr extends zzena<zzgr, zza> implements zzeop {
    /* access modifiers changed from: private */
    public static final zzgr zzach;
    private static volatile zzeow<zzgr> zzek;
    private zzgv zzace;
    private zzelq zzacf = zzelq.zzipc;
    private zzelq zzacg = zzelq.zzipc;
    private int zzdv;

    private zzgr() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zza extends zzena.zzb<zzgr, zza> implements zzeop {
        private zza() {
            super(zzgr.zzach);
        }

        /* synthetic */ zza(zzgt zzgt) {
            this();
        }
    }

    public final zzgv zzdd() {
        zzgv zzgv = this.zzace;
        return zzgv == null ? zzgv.zzdn() : zzgv;
    }

    public final zzelq zzde() {
        return this.zzacf;
    }

    public final zzelq zzdf() {
        return this.zzacg;
    }

    public static zzgr zza(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzgr) zzena.zza(zzach, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgt.zzel[i - 1]) {
            case 1:
                return new zzgr();
            case 2:
                return new zza((zzgt) null);
            case 3:
                return zza((zzeon) zzach, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzace", "zzacf", "zzacg"});
            case 4:
                return zzach;
            case 5:
                zzeow<zzgr> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzgr.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzach);
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
        zzgr zzgr = new zzgr();
        zzach = zzgr;
        zzena.zza(zzgr.class, zzgr);
    }
}
