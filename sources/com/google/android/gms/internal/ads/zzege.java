package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzege extends zzena<zzege, zza> implements zzeop {
    private static volatile zzeow<zzege> zzek;
    /* access modifiers changed from: private */
    public static final zzege zzihp;
    private zzegi zzihn;
    private zzehy zziho;

    private zzege() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzege, zza> implements zzeop {
        private zza() {
            super(zzege.zzihp);
        }

        /* synthetic */ zza(zzegd zzegd) {
            this();
        }
    }

    public final zzegi zzbco() {
        zzegi zzegi = this.zzihn;
        return zzegi == null ? zzegi.zzbcv() : zzegi;
    }

    public final zzehy zzbcp() {
        zzehy zzehy = this.zziho;
        return zzehy == null ? zzehy.zzbeq() : zzehy;
    }

    public static zzege zzf(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzege) zzena.zza(zzihp, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegd.zzel[i - 1]) {
            case 1:
                return new zzege();
            case 2:
                return new zza((zzegd) null);
            case 3:
                return zza((zzeon) zzihp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzihn", "zziho"});
            case 4:
                return zzihp;
            case 5:
                zzeow<zzege> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzege.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihp);
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
        zzege zzege = new zzege();
        zzihp = zzege;
        zzena.zza(zzege.class, zzege);
    }
}
