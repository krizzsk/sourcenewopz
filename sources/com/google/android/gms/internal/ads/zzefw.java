package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzefw extends zzena<zzefw, zza> implements zzeop {
    private static volatile zzeow<zzefw> zzek;
    /* access modifiers changed from: private */
    public static final zzefw zzihf;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzega zzihe;

    private zzefw() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzefw, zza> implements zzeop {
        private zza() {
            super(zzefw.zzihf);
        }

        public final zza zzfe(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzefw) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzt(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzefw) this.zzits).zzs(zzelq);
            return this;
        }

        public final zza zzd(zzega zzega) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzefw) this.zzits).zzc(zzega);
            return this;
        }

        /* synthetic */ zza(zzefv zzefv) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzihc;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzihc = 0;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzelq zzelq) {
        zzelq.getClass();
        this.zzihd = zzelq;
    }

    public final zzega zzbcd() {
        zzega zzega = this.zzihe;
        return zzega == null ? zzega.zzbci() : zzega;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzega zzega) {
        zzega.getClass();
        this.zzihe = zzega;
    }

    public static zzefw zzc(zzelq zzelq, zzemn zzemn) throws zzenn {
        return (zzefw) zzena.zza(zzihf, zzelq, zzemn);
    }

    public static zza zzbce() {
        return (zza) zzihf.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefv.zzel[i - 1]) {
            case 1:
                return new zzefw();
            case 2:
                return new zza((zzefv) null);
            case 3:
                return zza((zzeon) zzihf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzihc", "zzihd", "zzihe"});
            case 4:
                return zzihf;
            case 5:
                zzeow<zzefw> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzefw.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzihf);
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
        zzefw zzefw = new zzefw();
        zzihf = zzefw;
        zzena.zza(zzefw.class, zzefw);
    }
}
