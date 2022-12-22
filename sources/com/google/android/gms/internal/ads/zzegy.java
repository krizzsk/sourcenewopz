package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegy extends zzena<zzegy, zza> implements zzeop {
    private static volatile zzeow<zzegy> zzek;
    /* access modifiers changed from: private */
    public static final zzegy zziic;
    private int zzihc;
    private int zzihg;

    private zzegy() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegy, zza> implements zzeop {
        private zza() {
            super(zzegy.zziic);
        }

        /* synthetic */ zza(zzegx zzegx) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzegy zzn(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegy) zzena.zza(zziic, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegx.zzel[i - 1]) {
            case 1:
                return new zzegy();
            case 2:
                return new zza((zzegx) null);
            case 3:
                return zza((zzeon) zziic, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzihc", "zzihg"});
            case 4:
                return zziic;
            case 5:
                zzeow<zzegy> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegy.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziic);
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
        zzegy zzegy = new zzegy();
        zziic = zzegy;
        zzena.zza(zzegy.class, zzegy);
    }
}
