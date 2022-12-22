package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzejb extends zzena<zzejb, zza> implements zzeop {
    private static volatile zzeow<zzejb> zzek;
    /* access modifiers changed from: private */
    public static final zzejb zzilw;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;

    private zzejb() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzejb, zza> implements zzeop {
        private zza() {
            super(zzejb.zzilw);
        }

        public final zza zzga(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzejb) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzah(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzejb) this.zzits).zzs(zzelq);
            return this;
        }

        /* synthetic */ zza(zzeja zzeja) {
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

    public static zzejb zzz(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzejb) zzena.zza(zzilw, zzelq, zzemn);
    }

    public static zza zzbgk() {
        return (zza) zzilw.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeja.zzel[i - 1]) {
            case 1:
                return new zzejb();
            case 2:
                return new zza((zzeja) null);
            case 3:
                return zza((zzeon) zzilw, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzihc", "zzihd"});
            case 4:
                return zzilw;
            case 5:
                zzeow<zzejb> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzejb.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzilw);
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
        zzejb zzejb = new zzejb();
        zzilw = zzejb;
        zzena.zza(zzejb.class, zzejb);
    }
}
