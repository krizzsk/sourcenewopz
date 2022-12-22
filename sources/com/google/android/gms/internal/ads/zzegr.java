package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegr extends zzena<zzegr, zza> implements zzeop {
    private static volatile zzeow<zzegr> zzek;
    /* access modifiers changed from: private */
    public static final zzegr zzihz;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;

    private zzegr() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegr, zza> implements zzeop {
        private zza() {
            super(zzegr.zzihz);
        }

        public final zza zzfi(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegr) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzw(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegr) this.zzits).zzs(zzelq);
            return this;
        }

        /* synthetic */ zza(zzegs zzegs) {
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

    public static zzegr zzk(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegr) zzena.zza(zzihz, zzelq, zzemn);
    }

    public static zza zzbdg() {
        return (zza) zzihz.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegs.zzel[i - 1]) {
            case 1:
                return new zzegr();
            case 2:
                return new zza((zzegs) null);
            case 3:
                return zza((zzeon) zzihz, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzihc", "zzihd"});
            case 4:
                return zzihz;
            case 5:
                zzeow<zzegr> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegr.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihz);
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
        zzegr zzegr = new zzegr();
        zzihz = zzegr;
        zzena.zza(zzegr.class, zzegr);
    }
}
