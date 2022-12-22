package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegq extends zzena<zzegq, zza> implements zzeop {
    private static volatile zzeow<zzegq> zzek;
    /* access modifiers changed from: private */
    public static final zzegq zzihy;
    private int zziht;

    private zzegq() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegq, zza> implements zzeop {
        private zza() {
            super(zzegq.zzihy);
        }

        /* synthetic */ zza(zzegp zzegp) {
            this();
        }
    }

    public final int zzbcx() {
        return this.zziht;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegp.zzel[i - 1]) {
            case 1:
                return new zzegq();
            case 2:
                return new zza((zzegp) null);
            case 3:
                return zza((zzeon) zzihy, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zziht"});
            case 4:
                return zzihy;
            case 5:
                zzeow<zzegq> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegq.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihy);
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

    public static zzegq zzbde() {
        return zzihy;
    }

    static {
        zzegq zzegq = new zzegq();
        zzihy = zzegq;
        zzena.zza(zzegq.class, zzegq);
    }
}
