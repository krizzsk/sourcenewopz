package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzcb {

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zza extends zzena<zza, C22009zza> implements zzeop {
        private static volatile zzeow<zza> zzek;
        /* access modifiers changed from: private */
        public static final zza zzex;
        private int zzdv;
        private zzb zzev;
        private zzc zzew;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzcb$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class C22009zza extends zzena.zzb<zza, C22009zza> implements zzeop {
            private C22009zza() {
                super(zza.zzex);
            }

            /* synthetic */ C22009zza(zzca zzca) {
                this();
            }
        }

        public final boolean zzx() {
            return (this.zzdv & 1) != 0;
        }

        public final zzb zzy() {
            zzb zzb = this.zzev;
            return zzb == null ? zzb.zzad() : zzb;
        }

        public final boolean zzz() {
            return (this.zzdv & 2) != 0;
        }

        public final zzc zzaa() {
            zzc zzc = this.zzew;
            return zzc == null ? zzc.zzag() : zzc;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzca.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C22009zza((zzca) null);
                case 3:
                    return zza((zzeon) zzex, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzdv", "zzev", "zzew"});
                case 4:
                    return zzex;
                case 5:
                    zzeow<zza> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zza.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzex);
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
            zzex = zza;
            zzena.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zzb extends zzena<zzb, zza> implements zzeop {
        private static volatile zzeow<zzb> zzek;
        /* access modifiers changed from: private */
        public static final zzb zzez;
        private int zzdv;
        private int zzey = 2;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zza extends zzena.zzb<zzb, zza> implements zzeop {
            private zza() {
                super(zzb.zzez);
            }

            /* synthetic */ zza(zzca zzca) {
                this();
            }
        }

        public final zzcd zzac() {
            zzcd zzj = zzcd.zzj(this.zzey);
            return zzj == null ? zzcd.ENUM_SIGNAL_SOURCE_ADSHIELD : zzj;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzca.zzel[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzca) null);
                case 3:
                    return zza((zzeon) zzez, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zzdv", "zzey", zzcd.zzw()});
                case 4:
                    return zzez;
                case 5:
                    zzeow<zzb> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zzb.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzez);
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

        public static zzb zzad() {
            return zzez;
        }

        static {
            zzb zzb = new zzb();
            zzez = zzb;
            zzena.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zzc extends zzena<zzc, zza> implements zzeop {
        private static volatile zzeow<zzc> zzek;
        /* access modifiers changed from: private */
        public static final zzc zzfm;
        private int zzdv;
        private String zzfg = "";
        private String zzfh = "";
        private String zzfi = "";
        private String zzfj = "";
        private String zzfk = "";
        private String zzfl = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zza extends zzena.zzb<zzc, zza> implements zzeop {
            private zza() {
                super(zzc.zzfm);
            }

            /* synthetic */ zza(zzca zzca) {
                this();
            }
        }

        public final String zzaf() {
            return this.zzfg;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzca.zzel[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzca) null);
                case 3:
                    return zza((zzeon) zzfm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzdv", "zzfg", "zzfh", "zzfi", "zzfj", "zzfk", "zzfl"});
                case 4:
                    return zzfm;
                case 5:
                    zzeow<zzc> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zzc.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzfm);
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

        public static zzc zzag() {
            return zzfm;
        }

        static {
            zzc zzc = new zzc();
            zzfm = zzc;
            zzena.zza(zzc.class, zzc);
        }
    }
}
