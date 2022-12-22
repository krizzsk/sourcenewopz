package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzein extends zzena<zzein, zzb> implements zzeop {
    private static volatile zzeow<zzein> zzek;
    /* access modifiers changed from: private */
    public static final zzein zzilb;
    private int zzikt;
    private zzenk<zza> zzila = zzbjm();

    private zzein() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena<zza, C22014zza> implements zzeop {
        private static volatile zzeow<zza> zzek;
        /* access modifiers changed from: private */
        public static final zza zzilc;
        private String zzijv = "";
        private int zzikm;
        private int zzikx;
        private int zziky;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzein$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class C22014zza extends zzena.zzb<zza, C22014zza> implements zzeop {
            private C22014zza() {
                super(zza.zzilc);
            }

            public final C22014zza zzhw(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzhu(str);
                return this;
            }

            public final C22014zza zzb(zzeid zzeid) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzeid);
                return this;
            }

            public final C22014zza zzfw(int i) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzfu(i);
                return this;
            }

            public final C22014zza zzb(zzeiw zzeiw) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzeiw);
                return this;
            }

            /* synthetic */ C22014zza(zzeim zzeim) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzhu(String str) {
            str.getClass();
            this.zzijv = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzeid zzeid) {
            this.zzikx = zzeid.zzv();
        }

        /* access modifiers changed from: private */
        public final void zzfu(int i) {
            this.zziky = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzeiw zzeiw) {
            this.zzikm = zzeiw.zzv();
        }

        public static C22014zza zzbfs() {
            return (C22014zza) zzilc.zzbjh();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzeim.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C22014zza((zzeim) null);
                case 3:
                    return zza((zzeon) zzilc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzijv", "zzikx", "zziky", "zzikm"});
                case 4:
                    return zzilc;
                case 5:
                    zzeow<zza> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zza.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzilc);
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
            zza zza = new zza();
            zzilc = zza;
            zzena.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zzb extends zzena.zzb<zzein, zzb> implements zzeop {
        private zzb() {
            super(zzein.zzilb);
        }

        public final zzb zzfv(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzein) this.zzits).zzft(i);
            return this;
        }

        public final zzb zzb(zza zza) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzein) this.zzits).zza(zza);
            return this;
        }

        /* synthetic */ zzb(zzeim zzeim) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzft(int i) {
        this.zzikt = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        zza2.getClass();
        zzenk<zza> zzenk = this.zzila;
        if (!zzenk.zzbhd()) {
            this.zzila = zzena.zza(zzenk);
        }
        this.zzila.add(zza2);
    }

    public static zzb zzbfq() {
        return (zzb) zzilb.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeim.zzel[i - 1]) {
            case 1:
                return new zzein();
            case 2:
                return new zzb((zzeim) null);
            case 3:
                return zza((zzeon) zzilb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzikt", "zzila", zza.class});
            case 4:
                return zzilb;
            case 5:
                zzeow<zzein> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzein.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzilb);
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
        zzein zzein = new zzein();
        zzilb = zzein;
        zzena.zza(zzein.class, zzein);
    }
}
