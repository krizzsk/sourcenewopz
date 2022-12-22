package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehe extends zzena<zzehe, zza> implements zzeop {
    private static volatile zzeow<zzehe> zzek;
    /* access modifiers changed from: private */
    public static final zzehe zziim;
    private zzeif zziil;

    private zzehe() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehe, zza> implements zzeop {
        private zza() {
            super(zzehe.zziim);
        }

        /* synthetic */ zza(zzehg zzehg) {
            this();
        }
    }

    public final zzeif zzbdp() {
        zzeif zzeif = this.zziil;
        return zzeif == null ? zzeif.zzbfb() : zzeif;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehg.zzel[i - 1]) {
            case 1:
                return new zzehe();
            case 2:
                return new zza((zzehg) null);
            case 3:
                return zza((zzeon) zziim, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zziil"});
            case 4:
                return zziim;
            case 5:
                zzeow<zzehe> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehe.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziim);
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

    public static zzehe zzbdq() {
        return zziim;
    }

    static {
        zzehe zzehe = new zzehe();
        zziim = zzehe;
        zzena.zza(zzehe.class, zzehe);
    }
}
