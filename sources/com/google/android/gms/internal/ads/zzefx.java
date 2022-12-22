package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzefx extends zzena<zzefx, zza> implements zzeop {
    private static volatile zzeow<zzefx> zzek;
    /* access modifiers changed from: private */
    public static final zzefx zzihh;
    private zzega zzihe;
    private int zzihg;

    private zzefx() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzefx, zza> implements zzeop {
        private zza() {
            super(zzefx.zzihh);
        }

        /* synthetic */ zza(zzefy zzefy) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public final zzega zzbcd() {
        zzega zzega = this.zzihe;
        return zzega == null ? zzega.zzbci() : zzega;
    }

    public static zzefx zzd(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzefx) zzena.zza(zzihh, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefy.zzel[i - 1]) {
            case 1:
                return new zzefx();
            case 2:
                return new zza((zzefy) null);
            case 3:
                return zza((zzeon) zzihh, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzihg", "zzihe"});
            case 4:
                return zzihh;
            case 5:
                zzeow<zzefx> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzefx.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihh);
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
        zzefx zzefx = new zzefx();
        zzihh = zzefx;
        zzena.zza(zzefx.class, zzefx);
    }
}
