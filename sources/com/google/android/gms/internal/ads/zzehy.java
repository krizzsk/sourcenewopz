package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehy extends zzena<zzehy, zza> implements zzeop {
    private static volatile zzeow<zzehy> zzek;
    /* access modifiers changed from: private */
    public static final zzehy zzijs;
    private int zzihc;
    private int zzihg;
    private zzehz zzijq;

    private zzehy() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehy, zza> implements zzeop {
        private zza() {
            super(zzehy.zzijs);
        }

        /* synthetic */ zza(zzehx zzehx) {
            this();
        }
    }

    public final zzehz zzbem() {
        zzehz zzehz = this.zzijq;
        return zzehz == null ? zzehz.zzbet() : zzehz;
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzehy zzu(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzehy) zzena.zza(zzijs, zzelq, zzemn);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehx.zzel[i - 1]) {
            case 1:
                return new zzehy();
            case 2:
                return new zza((zzehx) null);
            case 3:
                return zza((zzeon) zzijs, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzijq", "zzihg", "zzihc"});
            case 4:
                return zzijs;
            case 5:
                zzeow<zzehy> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehy.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzijs);
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

    public static zzehy zzbeq() {
        return zzijs;
    }

    static {
        zzehy zzehy = new zzehy();
        zzijs = zzehy;
        zzena.zza(zzehy.class, zzehy);
    }
}
