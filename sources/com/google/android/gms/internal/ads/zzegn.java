package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegn extends zzena<zzegn, zza> implements zzeop {
    private static volatile zzeow<zzegn> zzek;
    /* access modifiers changed from: private */
    public static final zzegn zzihx;
    private int zzihg;
    private zzegq zzihv;

    private zzegn() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegn, zza> implements zzeop {
        private zza() {
            super(zzegn.zzihx);
        }

        /* synthetic */ zza(zzego zzego) {
            this();
        }
    }

    public final zzegq zzbda() {
        zzegq zzegq = this.zzihv;
        return zzegq == null ? zzegq.zzbde() : zzegq;
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzegn zzj(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegn) zzena.zza(zzihx, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzego.zzel[i - 1]) {
            case 1:
                return new zzegn();
            case 2:
                return new zza((zzego) null);
            case 3:
                return zza((zzeon) zzihx, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzihv", "zzihg"});
            case 4:
                return zzihx;
            case 5:
                zzeow<zzegn> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegn.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihx);
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
        zzegn zzegn = new zzegn();
        zzihx = zzegn;
        zzena.zza(zzegn.class, zzegn);
    }
}
