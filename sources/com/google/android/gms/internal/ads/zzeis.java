package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeis extends zzena<zzeis, zza> implements zzeop {
    private static volatile zzeow<zzeis> zzek;
    /* access modifiers changed from: private */
    public static final zzeis zzili;
    private int zzihc;
    private zzeiv zzilh;

    private zzeis() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzeis, zza> implements zzeop {
        private zza() {
            super(zzeis.zzili);
        }

        public final zza zzfy(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeis) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzb(zzeiv zzeiv) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeis) this.zzits).zza(zzeiv);
            return this;
        }

        /* synthetic */ zza(zzeit zzeit) {
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

    public final zzeiv zzbga() {
        zzeiv zzeiv = this.zzilh;
        return zzeiv == null ? zzeiv.zzbgf() : zzeiv;
    }

    /* access modifiers changed from: private */
    public final void zza(zzeiv zzeiv) {
        zzeiv.getClass();
        this.zzilh = zzeiv;
    }

    public static zzeis zzx(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzeis) zzena.zza(zzili, zzelq, zzemn);
    }

    public static zza zzbgb() {
        return (zza) zzili.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeit.zzel[i - 1]) {
            case 1:
                return new zzeis();
            case 2:
                return new zza((zzeit) null);
            case 3:
                return zza((zzeon) zzili, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzihc", "zzilh"});
            case 4:
                return zzili;
            case 5:
                zzeow<zzeis> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzeis.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzili);
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
        zzeis zzeis = new zzeis();
        zzili = zzeis;
        zzena.zza(zzeis.class, zzeis);
    }
}
