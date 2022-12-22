package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzejc extends zzena<zzejc, zza> implements zzeop {
    private static volatile zzeow<zzejc> zzek;
    /* access modifiers changed from: private */
    public static final zzejc zzilx;

    private zzejc() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzejc, zza> implements zzeop {
        private zza() {
            super(zzejc.zzilx);
        }

        /* synthetic */ zza(zzejd zzejd) {
            this();
        }
    }

    public static zzejc zzaa(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzejc) zzena.zza(zzilx, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzejd.zzel[i - 1]) {
            case 1:
                return new zzejc();
            case 2:
                return new zza((zzejd) null);
            case 3:
                return zza((zzeon) zzilx, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzilx;
            case 5:
                zzeow<zzejc> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzejc.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzilx);
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
        zzejc zzejc = new zzejc();
        zzilx = zzejc;
        zzena.zza(zzejc.class, zzejc);
    }
}
