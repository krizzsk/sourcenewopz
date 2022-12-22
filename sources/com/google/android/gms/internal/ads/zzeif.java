package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeif extends zzena<zzeif, zza> implements zzeop {
    private static volatile zzeow<zzeif> zzek;
    /* access modifiers changed from: private */
    public static final zzeif zzikn;
    private String zzijv = "";
    private zzelq zzijw = zzelq.zzipc;
    private int zzikm;

    private zzeif() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzeif, zza> implements zzeop {
        private zza() {
            super(zzeif.zzikn);
        }

        /* synthetic */ zza(zzeih zzeih) {
            this();
        }
    }

    public final String zzbev() {
        return this.zzijv;
    }

    public final zzelq zzbew() {
        return this.zzijw;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeih.zzel[i - 1]) {
            case 1:
                return new zzeif();
            case 2:
                return new zza((zzeih) null);
            case 3:
                return zza((zzeon) zzikn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzijv", "zzijw", "zzikm"});
            case 4:
                return zzikn;
            case 5:
                zzeow<zzeif> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzeif.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzikn);
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

    public static zzeif zzbfb() {
        return zzikn;
    }

    static {
        zzeif zzeif = new zzeif();
        zzikn = zzeif;
        zzena.zza(zzeif.class, zzeif);
    }
}
