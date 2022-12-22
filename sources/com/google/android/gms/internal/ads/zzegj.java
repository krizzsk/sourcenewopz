package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegj extends zzena<zzegj, zza> implements zzeop {
    private static volatile zzeow<zzegj> zzek;
    /* access modifiers changed from: private */
    public static final zzegj zzihu;
    private int zziht;

    private zzegj() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegj, zza> implements zzeop {
        private zza() {
            super(zzegj.zzihu);
        }

        /* synthetic */ zza(zzegk zzegk) {
            this();
        }
    }

    public final int zzbcx() {
        return this.zziht;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegk.zzel[i - 1]) {
            case 1:
                return new zzegj();
            case 2:
                return new zza((zzegk) null);
            case 3:
                return zza((zzeon) zzihu, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zziht"});
            case 4:
                return zzihu;
            case 5:
                zzeow<zzegj> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegj.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihu);
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

    public static zzegj zzbcy() {
        return zzihu;
    }

    static {
        zzegj zzegj = new zzegj();
        zzihu = zzegj;
        zzena.zza(zzegj.class, zzegj);
    }
}
