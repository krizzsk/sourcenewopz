package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegv extends zzena<zzegv, zza> implements zzeop {
    private static volatile zzeow<zzegv> zzek;
    /* access modifiers changed from: private */
    public static final zzegv zziib;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;

    private zzegv() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegv, zza> implements zzeop {
        private zza() {
            super(zzegv.zziib);
        }

        public final zza zzfj(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegv) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzx(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegv) this.zzits).zzs(zzelq);
            return this;
        }

        /* synthetic */ zza(zzegw zzegw) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzihc;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzihc = i;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzelq zzelq) {
        zzelq.getClass();
        this.zzihd = zzelq;
    }

    public static zzegv zzm(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegv) zzena.zza(zziib, zzelq, zzemn);
    }

    public static zza zzbdj() {
        return (zza) zziib.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegw.zzel[i - 1]) {
            case 1:
                return new zzegv();
            case 2:
                return new zza((zzegw) null);
            case 3:
                return zza((zzeon) zziib, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzihc", "zzihd"});
            case 4:
                return zziib;
            case 5:
                zzeow<zzegv> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegv.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziib);
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
        zzegv zzegv = new zzegv();
        zziib = zzegv;
        zzena.zza(zzegv.class, zzegv);
    }
}
