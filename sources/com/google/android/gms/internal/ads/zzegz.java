package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzegz extends zzena<zzegz, zza> implements zzeop {
    private static volatile zzeow<zzegz> zzek;
    /* access modifiers changed from: private */
    public static final zzegz zziid;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;

    private zzegz() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzegz, zza> implements zzeop {
        private zza() {
            super(zzegz.zziid);
        }

        public final zza zzfk(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegz) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzy(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegz) this.zzits).zzs(zzelq);
            return this;
        }

        /* synthetic */ zza(zzeha zzeha) {
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

    public static zzegz zzo(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzegz) zzena.zza(zziid, zzelq, zzemn);
    }

    public static zza zzbdm() {
        return (zza) zziid.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeha.zzel[i - 1]) {
            case 1:
                return new zzegz();
            case 2:
                return new zza((zzeha) null);
            case 3:
                return zza((zzeon) zziid, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzihc", "zzihd"});
            case 4:
                return zziid;
            case 5:
                zzeow<zzegz> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzegz.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zziid);
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
        zzegz zzegz = new zzegz();
        zziid = zzegz;
        zzena.zza(zzegz.class, zzegz);
    }
}
