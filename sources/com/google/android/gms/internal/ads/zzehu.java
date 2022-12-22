package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehu extends zzena<zzehu, zza> implements zzeop {
    private static volatile zzeow<zzehu> zzek;
    /* access modifiers changed from: private */
    public static final zzehu zzijr;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzehz zzijq;

    private zzehu() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehu, zza> implements zzeop {
        private zza() {
            super(zzehu.zzijr);
        }

        public final zza zzfq(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehu) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzd(zzehz zzehz) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehu) this.zzits).zzc(zzehz);
            return this;
        }

        public final zza zzae(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehu) this.zzits).zzs(zzelq);
            return this;
        }

        /* synthetic */ zza(zzehw zzehw) {
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

    public final zzehz zzbem() {
        zzehz zzehz = this.zzijq;
        return zzehz == null ? zzehz.zzbet() : zzehz;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzehz zzehz) {
        zzehz.getClass();
        this.zzijq = zzehz;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzelq zzelq) {
        zzelq.getClass();
        this.zzihd = zzelq;
    }

    public static zzehu zzt(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzehu) zzena.zza(zzijr, zzelq, zzemn);
    }

    public static zza zzben() {
        return (zza) zzijr.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehw.zzel[i - 1]) {
            case 1:
                return new zzehu();
            case 2:
                return new zza((zzehw) null);
            case 3:
                return zza((zzeon) zzijr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzihc", "zzijq", "zzihd"});
            case 4:
                return zzijr;
            case 5:
                zzeow<zzehu> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehu.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzijr);
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

    public static zzehu zzbeo() {
        return zzijr;
    }

    static {
        zzehu zzehu = new zzehu();
        zzijr = zzehu;
        zzena.zza(zzehu.class, zzehu);
    }
}
