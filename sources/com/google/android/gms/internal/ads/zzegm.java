package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegm extends zzena<zzegm, zza> implements zzeop {
    private static volatile zzeow<zzegm> zzek;
    /* access modifiers changed from: private */
    public static final zzegm zzihw;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzegq zzihv;

    private zzegm() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegm, zza> implements zzeop {
        private zza() {
            super(zzegm.zzihw);
        }

        public final zza zzfh(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegm) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzb(zzegq zzegq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegm) this.zzits).zza(zzegq);
            return this;
        }

        public final zza zzv(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegm) this.zzits).zzs(zzelq);
            return this;
        }

        /* synthetic */ zza(zzegl zzegl) {
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

    public final zzegq zzbda() {
        zzegq zzegq = this.zzihv;
        return zzegq == null ? zzegq.zzbde() : zzegq;
    }

    /* access modifiers changed from: private */
    public final void zza(zzegq zzegq) {
        zzegq.getClass();
        this.zzihv = zzegq;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzelq zzelq) {
        zzelq.getClass();
        this.zzihd = zzelq;
    }

    public static zzegm zzi(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegm) zzena.zza(zzihw, zzelq, zzemn);
    }

    public static zza zzbdb() {
        return (zza) zzihw.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegl.zzel[i - 1]) {
            case 1:
                return new zzegm();
            case 2:
                return new zza((zzegl) null);
            case 3:
                return zza((zzeon) zzihw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzihc", "zzihv", "zzihd"});
            case 4:
                return zzihw;
            case 5:
                zzeow<zzegm> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegm.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihw);
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
        zzegm zzegm = new zzegm();
        zzihw = zzegm;
        zzena.zza(zzegm.class, zzegm);
    }
}
