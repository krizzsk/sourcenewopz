package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegf extends zzena<zzegf, zza> implements zzeop {
    private static volatile zzeow<zzegf> zzek;
    /* access modifiers changed from: private */
    public static final zzegf zzihr;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzegj zzihq;

    private zzegf() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegf, zza> implements zzeop {
        private zza() {
            super(zzegf.zzihr);
        }

        public final zza zzfg(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegf) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzc(zzegj zzegj) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegf) this.zzits).zzb(zzegj);
            return this;
        }

        public final zza zzu(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegf) this.zzits).zzs(zzelq);
            return this;
        }

        /* synthetic */ zza(zzegg zzegg) {
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

    public final zzegj zzbcr() {
        zzegj zzegj = this.zzihq;
        return zzegj == null ? zzegj.zzbcy() : zzegj;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzegj zzegj) {
        zzegj.getClass();
        this.zzihq = zzegj;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzelq zzelq) {
        zzelq.getClass();
        this.zzihd = zzelq;
    }

    public static zzegf zzg(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegf) zzena.zza(zzihr, zzelq, zzemn);
    }

    public static zza zzbcs() {
        return (zza) zzihr.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegg.zzel[i - 1]) {
            case 1:
                return new zzegf();
            case 2:
                return new zza((zzegg) null);
            case 3:
                return zza((zzeon) zzihr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzihc", "zzihq", "zzihd"});
            case 4:
                return zzihr;
            case 5:
                zzeow<zzegf> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegf.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihr);
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

    public static zzegf zzbct() {
        return zzihr;
    }

    static {
        zzegf zzegf = new zzegf();
        zzihr = zzegf;
        zzena.zza(zzegf.class, zzegf);
    }
}
