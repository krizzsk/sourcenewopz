package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegi extends zzena<zzegi, zza> implements zzeop {
    private static volatile zzeow<zzegi> zzek;
    /* access modifiers changed from: private */
    public static final zzegi zzihs;
    private int zzihg;
    private zzegj zzihq;

    private zzegi() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegi, zza> implements zzeop {
        private zza() {
            super(zzegi.zzihs);
        }

        /* synthetic */ zza(zzegh zzegh) {
            this();
        }
    }

    public final zzegj zzbcr() {
        zzegj zzegj = this.zzihq;
        return zzegj == null ? zzegj.zzbcy() : zzegj;
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzegi zzh(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegi) zzena.zza(zzihs, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegh.zzel[i - 1]) {
            case 1:
                return new zzegi();
            case 2:
                return new zza((zzegh) null);
            case 3:
                return zza((zzeon) zzihs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzihq", "zzihg"});
            case 4:
                return zzihs;
            case 5:
                zzeow<zzegi> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegi.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihs);
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

    public static zzegi zzbcv() {
        return zzihs;
    }

    static {
        zzegi zzegi = new zzegi();
        zzihs = zzegi;
        zzena.zza(zzegi.class, zzegi);
    }
}
