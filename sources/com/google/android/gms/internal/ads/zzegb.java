package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegb extends zzena<zzegb, zza> implements zzeop {
    private static volatile zzeow<zzegb> zzek;
    /* access modifiers changed from: private */
    public static final zzegb zzihm;
    private int zzihc;
    private zzegf zzihk;
    private zzehu zzihl;

    private zzegb() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegb, zza> implements zzeop {
        private zza() {
            super(zzegb.zzihm);
        }

        public final zza zzff(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegb) this.zzits).setVersion(i);
            return this;
        }

        public final zza zzc(zzegf zzegf) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegb) this.zzits).zzb(zzegf);
            return this;
        }

        public final zza zzc(zzehu zzehu) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegb) this.zzits).zzb(zzehu);
            return this;
        }

        /* synthetic */ zza(zzegc zzegc) {
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

    public final zzegf zzbck() {
        zzegf zzegf = this.zzihk;
        return zzegf == null ? zzegf.zzbct() : zzegf;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzegf zzegf) {
        zzegf.getClass();
        this.zzihk = zzegf;
    }

    public final zzehu zzbcl() {
        zzehu zzehu = this.zzihl;
        return zzehu == null ? zzehu.zzbeo() : zzehu;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzehu zzehu) {
        zzehu.getClass();
        this.zzihl = zzehu;
    }

    public static zzegb zze(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegb) zzena.zza(zzihm, zzelq, zzemn);
    }

    public static zza zzbcm() {
        return (zza) zzihm.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegc.zzel[i - 1]) {
            case 1:
                return new zzegb();
            case 2:
                return new zza((zzegc) null);
            case 3:
                return zza((zzeon) zzihm, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzihc", "zzihk", "zzihl"});
            case 4:
                return zzihm;
            case 5:
                zzeow<zzegb> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegb.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihm);
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
        zzegb zzegb = new zzegb();
        zzihm = zzegb;
        zzena.zza(zzegb.class, zzegb);
    }
}
