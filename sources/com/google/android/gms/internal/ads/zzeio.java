package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeio extends zzena<zzeio, zza> implements zzeop {
    private static volatile zzeow<zzeio> zzek;
    /* access modifiers changed from: private */
    public static final zzeio zzile;
    private int zzihc;
    private zzeir zzild;

    private zzeio() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzeio, zza> implements zzeop {
        private zza() {
            super(zzeio.zzile);
        }

        public final zza zzfx(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeio) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzb(zzeir zzeir) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeio) this.zzits).zza(zzeir);
            return this;
        }

        /* synthetic */ zza(zzeip zzeip) {
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

    public final zzeir zzbfu() {
        zzeir zzeir = this.zzild;
        return zzeir == null ? zzeir.zzbfy() : zzeir;
    }

    /* access modifiers changed from: private */
    public final void zza(zzeir zzeir) {
        zzeir.getClass();
        this.zzild = zzeir;
    }

    public static zzeio zzv(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzeio) zzena.zza(zzile, zzelq, zzemn);
    }

    public static zza zzbfv() {
        return (zza) zzile.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeip.zzel[i - 1]) {
            case 1:
                return new zzeio();
            case 2:
                return new zza((zzeip) null);
            case 3:
                return zza((zzeon) zzile, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzihc", "zzild"});
            case 4:
                return zzile;
            case 5:
                zzeow<zzeio> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzeio.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzile);
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
        zzeio zzeio = new zzeio();
        zzile = zzeio;
        zzena.zza(zzeio.class, zzeio);
    }
}
