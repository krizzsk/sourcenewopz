package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeiv extends zzena<zzeiv, zza> implements zzeop {
    private static volatile zzeow<zzeiv> zzek;
    /* access modifiers changed from: private */
    public static final zzeiv zzill;
    private String zzilj = "";
    private zzeif zzilk;

    private zzeiv() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzeiv, zza> implements zzeop {
        private zza() {
            super(zzeiv.zzill);
        }

        /* synthetic */ zza(zzeiu zzeiu) {
            this();
        }
    }

    public final String zzbgd() {
        return this.zzilj;
    }

    public final zzeif zzbge() {
        zzeif zzeif = this.zzilk;
        return zzeif == null ? zzeif.zzbfb() : zzeif;
    }

    public static zzeiv zzy(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzeiv) zzena.zza(zzill, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeiu.zzel[i - 1]) {
            case 1:
                return new zzeiv();
            case 2:
                return new zza((zzeiu) null);
            case 3:
                return zza((zzeon) zzill, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzilj", "zzilk"});
            case 4:
                return zzill;
            case 5:
                zzeow<zzeiv> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzeiv.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzill);
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

    public static zzeiv zzbgf() {
        return zzill;
    }

    static {
        zzeiv zzeiv = new zzeiv();
        zzill = zzeiv;
        zzena.zza(zzeiv.class, zzeiv);
    }
}
