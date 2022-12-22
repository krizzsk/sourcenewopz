package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeij extends zzena<zzeij, zza> implements zzeop {
    private static volatile zzeow<zzeij> zzek;
    /* access modifiers changed from: private */
    public static final zzeij zziks;
    private String zzijv = "";
    private String zziko = "";
    private int zzikp;
    private boolean zzikq;
    private String zzikr = "";

    private zzeij() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzeij, zza> implements zzeop {
        private zza() {
            super(zzeij.zziks);
        }

        /* synthetic */ zza(zzeii zzeii) {
            this();
        }
    }

    public final String zzbfd() {
        return this.zziko;
    }

    public final String zzbev() {
        return this.zzijv;
    }

    public final int zzbfe() {
        return this.zzikp;
    }

    public final boolean zzbff() {
        return this.zzikq;
    }

    public final String zzbfg() {
        return this.zzikr;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeii.zzel[i - 1]) {
            case 1:
                return new zzeij();
            case 2:
                return new zza((zzeii) null);
            case 3:
                return zza((zzeon) zziks, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zziko", "zzijv", "zzikp", "zzikq", "zzikr"});
            case 4:
                return zziks;
            case 5:
                zzeow<zzeij> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzeij.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziks);
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
        zzeij zzeij = new zzeij();
        zziks = zzeij;
        zzena.zza(zzeij.class, zzeij);
    }
}
