package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegu extends zzena<zzegu, zza> implements zzeop {
    private static volatile zzeow<zzegu> zzek;
    /* access modifiers changed from: private */
    public static final zzegu zziia;
    private int zzihc;
    private int zzihg;

    private zzegu() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegu, zza> implements zzeop {
        private zza() {
            super(zzegu.zziia);
        }

        /* synthetic */ zza(zzegt zzegt) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzegu zzl(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegu) zzena.zza(zziia, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegt.zzel[i - 1]) {
            case 1:
                return new zzegu();
            case 2:
                return new zza((zzegt) null);
            case 3:
                return zza((zzeon) zziia, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzihg", "zzihc"});
            case 4:
                return zziia;
            case 5:
                zzeow<zzegu> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegu.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziia);
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
        zzegu zzegu = new zzegu();
        zziia = zzegu;
        zzena.zza(zzegu.class, zzegu);
    }
}
