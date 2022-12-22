package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzehn extends zzena<zzehn, zza> implements zzeop {
    private static volatile zzeow<zzehn> zzek;
    /* access modifiers changed from: private */
    public static final zzehn zziix;
    private int zzihc;
    private zzehj zziin;
    private zzelq zziiv = zzelq.zzipc;
    private zzelq zziiw = zzelq.zzipc;

    private zzehn() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzehn, zza> implements zzeop {
        private zza() {
            super(zzehn.zziix);
        }

        public final zza zzfn(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehn) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzc(zzehj zzehj) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehn) this.zzits).zzb(zzehj);
            return this;
        }

        public final zza zzac(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehn) this.zzits).zzz(zzelq);
            return this;
        }

        public final zza zzad(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehn) this.zzits).zzaa(zzelq);
            return this;
        }

        /* synthetic */ zza(zzeho zzeho) {
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

    public final zzehj zzbds() {
        zzehj zzehj = this.zziin;
        return zzehj == null ? zzehj.zzbdx() : zzehj;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzehj zzehj) {
        zzehj.getClass();
        this.zziin = zzehj;
    }

    public final zzelq zzbec() {
        return this.zziiv;
    }

    /* access modifiers changed from: private */
    public final void zzz(zzelq zzelq) {
        zzelq.getClass();
        this.zziiv = zzelq;
    }

    public final zzelq zzbed() {
        return this.zziiw;
    }

    /* access modifiers changed from: private */
    public final void zzaa(zzelq zzelq) {
        zzelq.getClass();
        this.zziiw = zzelq;
    }

    public static zzehn zzs(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzehn) zzena.zza(zziix, zzelq, zzemn);
    }

    public static zza zzbee() {
        return (zza) zziix.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeho.zzel[i - 1]) {
            case 1:
                return new zzehn();
            case 2:
                return new zza((zzeho) null);
            case 3:
                return zza((zzeon) zziix, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzihc", "zziin", "zziiv", "zziiw"});
            case 4:
                return zziix;
            case 5:
                zzeow<zzehn> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzehn.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziix);
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

    public static zzehn zzbef() {
        return zziix;
    }

    static {
        zzehn zzehn = new zzehn();
        zziix = zzehn;
        zzena.zza(zzehn.class, zzehn);
    }
}
