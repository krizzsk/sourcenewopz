package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzega extends zzena<zzega, zza> implements zzeop {
    private static volatile zzeow<zzega> zzek;
    /* access modifiers changed from: private */
    public static final zzega zzihj;
    private int zzihi;

    private zzega() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzega, zza> implements zzeop {
        private zza() {
            super(zzega.zzihj);
        }

        /* synthetic */ zza(zzefz zzefz) {
            this();
        }
    }

    public final int zzbch() {
        return this.zzihi;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefz.zzel[i - 1]) {
            case 1:
                return new zzega();
            case 2:
                return new zza((zzefz) null);
            case 3:
                return zza((zzeon) zzihj, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzihi"});
            case 4:
                return zzihj;
            case 5:
                zzeow<zzega> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzega.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihj);
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

    public static zzega zzbci() {
        return zzihj;
    }

    static {
        zzega zzega = new zzega();
        zzihj = zzega;
        zzena.zza(zzega.class, zzega);
    }
}
