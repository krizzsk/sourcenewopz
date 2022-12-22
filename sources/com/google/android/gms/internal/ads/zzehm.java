package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehm extends zzena<zzehm, zza> implements zzeop {
    private static volatile zzeow<zzehm> zzek;
    /* access modifiers changed from: private */
    public static final zzehm zziiu;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzehn zziit;

    private zzehm() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehm, zza> implements zzeop {
        private zza() {
            super(zzehm.zziiu);
        }

        public final zza zzfm(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehm) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzb(zzehn zzehn) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehm) this.zzits).zza(zzehn);
            return this;
        }

        public final zza zzab(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehm) this.zzits).zzs(zzelq);
            return this;
        }

        /* synthetic */ zza(zzehl zzehl) {
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

    public final zzehn zzbdz() {
        zzehn zzehn = this.zziit;
        return zzehn == null ? zzehn.zzbef() : zzehn;
    }

    /* access modifiers changed from: private */
    public final void zza(zzehn zzehn) {
        zzehn.getClass();
        this.zziit = zzehn;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzelq zzelq) {
        zzelq.getClass();
        this.zzihd = zzelq;
    }

    public static zzehm zzr(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzehm) zzena.zza(zziiu, zzelq, zzemn);
    }

    public static zza zzbea() {
        return (zza) zziiu.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehl.zzel[i - 1]) {
            case 1:
                return new zzehm();
            case 2:
                return new zza((zzehl) null);
            case 3:
                return zza((zzeon) zziiu, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzihc", "zziit", "zzihd"});
            case 4:
                return zziiu;
            case 5:
                zzeow<zzehm> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehm.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziiu);
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
        zzehm zzehm = new zzehm();
        zziiu = zzehm;
        zzena.zza(zzehm.class, zzehm);
    }
}
