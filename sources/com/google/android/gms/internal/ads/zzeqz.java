package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.google.android.gms.internal.ads.zzena;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeqz {

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena<zza, C22015zza> implements zzeop {
        private static volatile zzeow<zza> zzek;
        /* access modifiers changed from: private */
        public static final zza zzjau;
        private int zzdv;
        private int zzjan;
        private zzb zzjao;
        private zzelq zzjap = zzelq.zzipc;
        private zzelq zzjaq = zzelq.zzipc;
        private boolean zzjar;
        private boolean zzjas;
        private byte zzjat = 2;

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class zzb extends zzena<zzb, C22016zza> implements zzeop {
            private static volatile zzeow<zzb> zzek;
            /* access modifiers changed from: private */
            public static final zzb zzjaz;
            private int zzdv;
            private String zzjav = "";
            private String zzjaw = "";
            private String zzjax = "";
            private int zzjay;

            private zzb() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zza$zzb$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class C22016zza extends zzena.zzb<zzb, C22016zza> implements zzeop {
                private C22016zza() {
                    super(zzb.zzjaz);
                }

                /* synthetic */ C22016zza(zzeqy zzeqy) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C22016zza((zzeqy) null);
                    case 3:
                        return zza((zzeon) zzjaz, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdv", "zzjav", "zzjaw", "zzjax", "zzjay"});
                    case 4:
                        return zzjaz;
                    case 5:
                        zzeow<zzb> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zzb.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzjaz);
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
                zzb zzb = new zzb();
                zzjaz = zzb;
                zzena.zza(zzb.class, zzb);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public enum zzc implements zzenf {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzene<zzc> zzes = null;
            private final int value;

            public final int zzv() {
                return this.value;
            }

            public static zzc zzig(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            public static zzenh zzw() {
                return zzerb.zzeu;
            }

            public final String toString() {
                return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzes = new zzera();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzeqz$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class C22015zza extends zzena.zzb<zza, C22015zza> implements zzeop {
            private C22015zza() {
                super(zza.zzjau);
            }

            /* synthetic */ C22015zza(zzeqy zzeqy) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzeqy.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C22015zza((zzeqy) null);
                case 3:
                    return zza((zzeon) zzjau, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdv", "zzjan", zzc.zzw(), "zzjao", "zzjap", "zzjaq", "zzjar", "zzjas"});
                case 4:
                    return zzjau;
                case 5:
                    zzeow<zza> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zza.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzjau);
                                zzek = zzeow;
                            }
                        }
                    }
                    return zzeow;
                case 6:
                    return Byte.valueOf(this.zzjat);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzjat = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzjau = zza;
            zzena.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zzb extends zzena<zzb, C22018zzb> implements zzeop {
        private static volatile zzeow<zzb> zzek;
        /* access modifiers changed from: private */
        public static final zzb zzjbv;
        private int zzcan;
        private int zzdv;
        private zzelq zzjap = zzelq.zzipc;
        private byte zzjat = 2;
        private String zzjaw = "";
        private int zzjbg;
        private String zzjbh = "";
        private String zzjbi = "";
        private zza zzjbj;
        private zzenk<zzh> zzjbk = zzbjm();
        private String zzjbl = "";
        private zzf zzjbm;
        private boolean zzjbn;
        private zzenk<String> zzjbo = zzena.zzbjm();
        private String zzjbp = "";
        private boolean zzjbq;
        private boolean zzjbr;
        private zzi zzjbs;
        private zzenk<String> zzjbt = zzena.zzbjm();
        private zzenk<String> zzjbu = zzena.zzbjm();

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class zze extends zzena<zze, C22022zzb> implements zzeop {
            private static volatile zzeow<zze> zzek;
            /* access modifiers changed from: private */
            public static final zze zzjcm;
            private int zzdv;
            private byte zzjat = 2;
            private zzenk<zzc> zzjcb = zzbjm();
            private zzelq zzjcc = zzelq.zzipc;
            private zzelq zzjcd = zzelq.zzipc;
            private int zzjce;
            private zza zzjck;
            private zzelq zzjcl = zzelq.zzipc;

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class zza extends zzena<zza, C22021zza> implements zzeop {
                private static volatile zzeow<zza> zzek;
                /* access modifiers changed from: private */
                public static final zza zzjcp;
                private int zzdv;
                private zzelq zzjci = zzelq.zzipc;
                private int zzjcn;
                private zzelq zzjco = zzelq.zzipc;

                private zza() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zze$zza$zza  reason: collision with other inner class name */
                /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
                public static final class C22021zza extends zzena.zzb<zza, C22021zza> implements zzeop {
                    private C22021zza() {
                        super(zza.zzjcp);
                    }

                    /* synthetic */ C22021zza(zzeqy zzeqy) {
                        this();
                    }
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzeqy.zzel[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C22021zza((zzeqy) null);
                        case 3:
                            return zza((zzeon) zzjcp, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzjcn", "zzjco", "zzjci"});
                        case 4:
                            return zzjcp;
                        case 5:
                            zzeow<zza> zzeow = zzek;
                            if (zzeow == null) {
                                synchronized (zza.class) {
                                    zzeow = zzek;
                                    if (zzeow == null) {
                                        zzeow = new zzena.zza<>(zzjcp);
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
                    zzjcp = zza;
                    zzena.zza(zza.class, zza);
                }
            }

            private zze() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zze$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class C22022zzb extends zzena.zzb<zze, C22022zzb> implements zzeop {
                private C22022zzb() {
                    super(zze.zzjcm);
                }

                /* synthetic */ C22022zzb(zzeqy zzeqy) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C22022zzb((zzeqy) null);
                    case 3:
                        return zza((zzeon) zzjcm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdv", "zzjck", "zzjcb", zzc.class, "zzjcc", "zzjcd", "zzjce", "zzjcl"});
                    case 4:
                        return zzjcm;
                    case 5:
                        zzeow<zze> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zze.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzjcm);
                                    zzek = zzeow;
                                }
                            }
                        }
                        return zzeow;
                    case 6:
                        return Byte.valueOf(this.zzjat);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzjat = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zze zze = new zze();
                zzjcm = zze;
                zzena.zza(zze.class, zze);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public enum zzg implements zzenf {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzene<zzg> zzes = null;
            private final int value;

            public final int zzv() {
                return this.value;
            }

            public static zzg zzii(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzenh zzw() {
                return zzerf.zzeu;
            }

            public final String toString() {
                return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzg(int i) {
                this.value = i;
            }

            static {
                zzes = new zzere();
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class zza extends zzena<zza, C22017zza> implements zzeop {
            private static volatile zzeow<zza> zzek;
            /* access modifiers changed from: private */
            public static final zza zzjbx;
            private int zzdv;
            private String zzjbw = "";

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class C22017zza extends zzena.zzb<zza, C22017zza> implements zzeop {
                private C22017zza() {
                    super(zza.zzjbx);
                }

                public final C22017zza zzii(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zza) this.zzits).zzie(str);
                    return this;
                }

                /* synthetic */ C22017zza(zzeqy zzeqy) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzie(String str) {
                str.getClass();
                this.zzdv |= 1;
                this.zzjbw = str;
            }

            public static C22017zza zzbmq() {
                return (C22017zza) zzjbx.zzbjh();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C22017zza((zzeqy) null);
                    case 3:
                        return zza((zzeon) zzjbx, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdv", "zzjbw"});
                    case 4:
                        return zzjbx;
                    case 5:
                        zzeow<zza> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zza.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzjbx);
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
                zzjbx = zza;
                zzena.zza(zza.class, zza);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class zzc extends zzena<zzc, zza> implements zzeop {
            private static volatile zzeow<zzc> zzek;
            /* access modifiers changed from: private */
            public static final zzc zzjbz;
            private int zzdv;
            private zzelq zzijw = zzelq.zzipc;
            private byte zzjat = 2;
            private zzelq zzjby = zzelq.zzipc;

            private zzc() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class zza extends zzena.zzb<zzc, zza> implements zzeop {
                private zza() {
                    super(zzc.zzjbz);
                }

                public final zza zzap(zzelq zzelq) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzc) this.zzits).zzao(zzelq);
                    return this;
                }

                public final zza zzaq(zzelq zzelq) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzc) this.zzits).zzaf(zzelq);
                    return this;
                }

                /* synthetic */ zza(zzeqy zzeqy) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzao(zzelq zzelq) {
                zzelq.getClass();
                this.zzdv |= 1;
                this.zzjby = zzelq;
            }

            /* access modifiers changed from: private */
            public final void zzaf(zzelq zzelq) {
                zzelq.getClass();
                this.zzdv |= 2;
                this.zzijw = zzelq;
            }

            public static zza zzbmt() {
                return (zza) zzjbz.zzbjh();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza((zzeqy) null);
                    case 3:
                        return zza((zzeon) zzjbz, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdv", "zzjby", "zzijw"});
                    case 4:
                        return zzjbz;
                    case 5:
                        zzeow<zzc> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zzc.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzjbz);
                                    zzek = zzeow;
                                }
                            }
                        }
                        return zzeow;
                    case 6:
                        return Byte.valueOf(this.zzjat);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzjat = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzc zzc = new zzc();
                zzjbz = zzc;
                zzena.zza(zzc.class, zzc);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class zzd extends zzena<zzd, C22020zzb> implements zzeop {
            private static volatile zzeow<zzd> zzek;
            /* access modifiers changed from: private */
            public static final zzd zzjcf;
            private int zzdv;
            private byte zzjat = 2;
            private zza zzjca;
            private zzenk<zzc> zzjcb = zzbjm();
            private zzelq zzjcc = zzelq.zzipc;
            private zzelq zzjcd = zzelq.zzipc;
            private int zzjce;

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class zza extends zzena<zza, C22019zza> implements zzeop {
                private static volatile zzeow<zza> zzek;
                /* access modifiers changed from: private */
                public static final zza zzjcj;
                private int zzdv;
                private zzelq zzjcg = zzelq.zzipc;
                private zzelq zzjch = zzelq.zzipc;
                private zzelq zzjci = zzelq.zzipc;

                private zza() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzd$zza$zza  reason: collision with other inner class name */
                /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
                public static final class C22019zza extends zzena.zzb<zza, C22019zza> implements zzeop {
                    private C22019zza() {
                        super(zza.zzjcj);
                    }

                    /* synthetic */ C22019zza(zzeqy zzeqy) {
                        this();
                    }
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzeqy.zzel[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C22019zza((zzeqy) null);
                        case 3:
                            return zza((zzeon) zzjcj, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzjcg", "zzjch", "zzjci"});
                        case 4:
                            return zzjcj;
                        case 5:
                            zzeow<zza> zzeow = zzek;
                            if (zzeow == null) {
                                synchronized (zza.class) {
                                    zzeow = zzek;
                                    if (zzeow == null) {
                                        zzeow = new zzena.zza<>(zzjcj);
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
                    zzjcj = zza;
                    zzena.zza(zza.class, zza);
                }
            }

            private zzd() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzd$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class C22020zzb extends zzena.zzb<zzd, C22020zzb> implements zzeop {
                private C22020zzb() {
                    super(zzd.zzjcf);
                }

                public final C22020zzb zzb(zzc zzc) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzd) this.zzits).zza(zzc);
                    return this;
                }

                /* synthetic */ C22020zzb(zzeqy zzeqy) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zzc zzc) {
                zzc.getClass();
                zzenk<zzc> zzenk = this.zzjcb;
                if (!zzenk.zzbhd()) {
                    this.zzjcb = zzena.zza(zzenk);
                }
                this.zzjcb.add(zzc);
            }

            public static C22020zzb zzbmv() {
                return (C22020zzb) zzjcf.zzbjh();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C22020zzb((zzeqy) null);
                    case 3:
                        return zza((zzeon) zzjcf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdv", "zzjca", "zzjcb", zzc.class, "zzjcc", "zzjcd", "zzjce"});
                    case 4:
                        return zzjcf;
                    case 5:
                        zzeow<zzd> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zzd.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzjcf);
                                    zzek = zzeow;
                                }
                            }
                        }
                        return zzeow;
                    case 6:
                        return Byte.valueOf(this.zzjat);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzjat = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzd zzd = new zzd();
                zzjcf = zzd;
                zzena.zza(zzd.class, zzd);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class zzf extends zzena<zzf, C22023zzb> implements zzeop {
            private static volatile zzeow<zzf> zzek;
            /* access modifiers changed from: private */
            public static final zzf zzjcs;
            private int zzcan;
            private int zzdv;
            private String zzjcq = "";
            private zzelq zzjcr = zzelq.zzipc;

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public enum zza implements zzenf {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzene<zza> zzes = null;
                private final int value;

                public final int zzv() {
                    return this.value;
                }

                public static zza zzih(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                public static zzenh zzw() {
                    return zzerc.zzeu;
                }

                public final String toString() {
                    return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
                }

                private zza(int i) {
                    this.value = i;
                }

                static {
                    zzes = new zzerd();
                }
            }

            private zzf() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzf$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class C22023zzb extends zzena.zzb<zzf, C22023zzb> implements zzeop {
                private C22023zzb() {
                    super(zzf.zzjcs);
                }

                public final C22023zzb zzb(zza zza) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zza(zza);
                    return this;
                }

                public final C22023zzb zzij(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).setMimeType(str);
                    return this;
                }

                public final C22023zzb zzas(zzelq zzelq) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzar(zzelq);
                    return this;
                }

                /* synthetic */ C22023zzb(zzeqy zzeqy) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zza zza2) {
                this.zzcan = zza2.zzv();
                this.zzdv |= 1;
            }

            /* access modifiers changed from: private */
            public final void setMimeType(String str) {
                str.getClass();
                this.zzdv |= 2;
                this.zzjcq = str;
            }

            /* access modifiers changed from: private */
            public final void zzar(zzelq zzelq) {
                zzelq.getClass();
                this.zzdv |= 4;
                this.zzjcr = zzelq;
            }

            public static C22023zzb zzbna() {
                return (C22023zzb) zzjcs.zzbjh();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C22023zzb((zzeqy) null);
                    case 3:
                        return zza((zzeon) zzjcs, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzcan", zza.zzw(), "zzjcq", "zzjcr"});
                    case 4:
                        return zzjcs;
                    case 5:
                        zzeow<zzf> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zzf.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzjcs);
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
                zzf zzf = new zzf();
                zzjcs = zzf;
                zzena.zza(zzf.class, zzf);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class zzh extends zzena<zzh, C22024zzb> implements zzeop {
            private static volatile zzeow<zzh> zzek;
            /* access modifiers changed from: private */
            public static final zzh zzjdp;
            private int zzdv;
            private byte zzjat = 2;
            private String zzjaw = "";
            private int zzjdh;
            private zzd zzjdi;
            private zze zzjdj;
            private int zzjdk;
            private zzeng zzjdl = zzbjk();
            private String zzjdm = "";
            private int zzjdn;
            private zzenk<String> zzjdo = zzena.zzbjm();

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public enum zza implements zzenf {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzene<zza> zzes = null;
                private final int value;

                public final int zzv() {
                    return this.value;
                }

                public static zza zzij(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                public static zzenh zzw() {
                    return zzerh.zzeu;
                }

                public final String toString() {
                    return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
                }

                private zza(int i) {
                    this.value = i;
                }

                static {
                    zzes = new zzerg();
                }
            }

            private zzh() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class C22024zzb extends zzena.zzb<zzh, C22024zzb> implements zzeop {
                private C22024zzb() {
                    super(zzh.zzjdp);
                }

                public final C22024zzb zzik(int i) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).setId(i);
                    return this;
                }

                public final C22024zzb zzil(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).setUrl(str);
                    return this;
                }

                public final C22024zzb zzb(zzd zzd) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).zza(zzd);
                    return this;
                }

                public final C22024zzb zzb(zza zza) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).zza(zza);
                    return this;
                }

                public final C22024zzb zzim(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).zzik(str);
                    return this;
                }

                /* synthetic */ C22024zzb(zzeqy zzeqy) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void setId(int i) {
                this.zzdv |= 1;
                this.zzjdh = i;
            }

            public final String getUrl() {
                return this.zzjaw;
            }

            /* access modifiers changed from: private */
            public final void setUrl(String str) {
                str.getClass();
                this.zzdv |= 2;
                this.zzjaw = str;
            }

            /* access modifiers changed from: private */
            public final void zza(zzd zzd) {
                zzd.getClass();
                this.zzjdi = zzd;
                this.zzdv |= 4;
            }

            /* access modifiers changed from: private */
            public final void zza(zza zza2) {
                this.zzjdn = zza2.zzv();
                this.zzdv |= 64;
            }

            public final int zzbnc() {
                return this.zzjdo.size();
            }

            /* access modifiers changed from: private */
            public final void zzik(String str) {
                str.getClass();
                zzenk<String> zzenk = this.zzjdo;
                if (!zzenk.zzbhd()) {
                    this.zzjdo = zzena.zza(zzenk);
                }
                this.zzjdo.add(str);
            }

            public static C22024zzb zzbnd() {
                return (C22024zzb) zzjdp.zzbjh();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C22024zzb((zzeqy) null);
                    case 3:
                        return zza((zzeon) zzjdp, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdv", "zzjdh", "zzjaw", "zzjdi", "zzjdj", "zzjdk", "zzjdl", "zzjdm", "zzjdn", zza.zzw(), "zzjdo"});
                    case 4:
                        return zzjdp;
                    case 5:
                        zzeow<zzh> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zzh.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzjdp);
                                    zzek = zzeow;
                                }
                            }
                        }
                        return zzeow;
                    case 6:
                        return Byte.valueOf(this.zzjat);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzjat = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzh zzh = new zzh();
                zzjdp = zzh;
                zzena.zza(zzh.class, zzh);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class zzi extends zzena<zzi, zza> implements zzeop {
            private static volatile zzeow<zzi> zzek;
            /* access modifiers changed from: private */
            public static final zzi zzjdy;
            private int zzdv;
            private String zzjdv = "";
            private long zzjdw;
            private boolean zzjdx;

            private zzi() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            public static final class zza extends zzena.zzb<zzi, zza> implements zzeop {
                private zza() {
                    super(zzi.zzjdy);
                }

                public final zza zzin(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzi) this.zzits).zzio(str);
                    return this;
                }

                public final zza zzft(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzi) this.zzits).zzfu(j);
                    return this;
                }

                public final zza zzca(boolean z) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzi) this.zzits).zzcb(z);
                    return this;
                }

                /* synthetic */ zza(zzeqy zzeqy) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzio(String str) {
                str.getClass();
                this.zzdv |= 1;
                this.zzjdv = str;
            }

            /* access modifiers changed from: private */
            public final void zzfu(long j) {
                this.zzdv |= 2;
                this.zzjdw = j;
            }

            /* access modifiers changed from: private */
            public final void zzcb(boolean z) {
                this.zzdv |= 4;
                this.zzjdx = z;
            }

            public static zza zzbnf() {
                return (zza) zzjdy.zzbjh();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza((zzeqy) null);
                    case 3:
                        return zza((zzeon) zzjdy, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdv", "zzjdv", "zzjdw", "zzjdx"});
                    case 4:
                        return zzjdy;
                    case 5:
                        zzeow<zzi> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zzi.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzjdy);
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
                zzi zzi = new zzi();
                zzjdy = zzi;
                zzena.zza(zzi.class, zzi);
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class C22018zzb extends zzena.zzb<zzb, C22018zzb> implements zzeop {
            private C22018zzb() {
                super(zzb.zzjbv);
            }

            public final C22018zzb zzb(zzg zzg) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zzg);
                return this;
            }

            public final String getUrl() {
                return ((zzb) this.zzits).getUrl();
            }

            public final C22018zzb zzif(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).setUrl(str);
                return this;
            }

            public final C22018zzb zzig(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzid(str);
                return this;
            }

            public final C22018zzb zzb(zza zza) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zza);
                return this;
            }

            public final List<zzh> zzbml() {
                return Collections.unmodifiableList(((zzb) this.zzits).zzbml());
            }

            public final C22018zzb zzb(zzh zzh) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zzh);
                return this;
            }

            public final String zzbmm() {
                return ((zzb) this.zzits).zzbmm();
            }

            public final C22018zzb zzih(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzdw(str);
                return this;
            }

            public final C22018zzb zzbms() {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzbmn();
                return this;
            }

            public final C22018zzb zzb(zzf zzf) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zzf);
                return this;
            }

            public final C22018zzb zzb(zzi zzi) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zzi);
                return this;
            }

            public final C22018zzb zzo(Iterable<String> iterable) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzm(iterable);
                return this;
            }

            public final C22018zzb zzp(Iterable<String> iterable) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzn(iterable);
                return this;
            }

            /* synthetic */ C22018zzb(zzeqy zzeqy) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg2) {
            this.zzcan = zzg2.zzv();
            this.zzdv |= 1;
        }

        public final String getUrl() {
            return this.zzjaw;
        }

        /* access modifiers changed from: private */
        public final void setUrl(String str) {
            str.getClass();
            this.zzdv |= 4;
            this.zzjaw = str;
        }

        /* access modifiers changed from: private */
        public final void zzid(String str) {
            str.getClass();
            this.zzdv |= 8;
            this.zzjbh = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            zza2.getClass();
            this.zzjbj = zza2;
            this.zzdv |= 32;
        }

        public final List<zzh> zzbml() {
            return this.zzjbk;
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh2) {
            zzh2.getClass();
            zzenk<zzh> zzenk = this.zzjbk;
            if (!zzenk.zzbhd()) {
                this.zzjbk = zzena.zza(zzenk);
            }
            this.zzjbk.add(zzh2);
        }

        public final String zzbmm() {
            return this.zzjbl;
        }

        /* access modifiers changed from: private */
        public final void zzdw(String str) {
            str.getClass();
            this.zzdv |= 64;
            this.zzjbl = str;
        }

        /* access modifiers changed from: private */
        public final void zzbmn() {
            this.zzdv &= -65;
            this.zzjbl = zzjbv.zzjbl;
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf2) {
            zzf2.getClass();
            this.zzjbm = zzf2;
            this.zzdv |= 128;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zzjbs = zzi2;
            this.zzdv |= 8192;
        }

        /* access modifiers changed from: private */
        public final void zzm(Iterable<String> iterable) {
            zzenk<String> zzenk = this.zzjbt;
            if (!zzenk.zzbhd()) {
                this.zzjbt = zzena.zza(zzenk);
            }
            zzelg.zza(iterable, this.zzjbt);
        }

        /* access modifiers changed from: private */
        public final void zzn(Iterable<String> iterable) {
            zzenk<String> zzenk = this.zzjbu;
            if (!zzenk.zzbhd()) {
                this.zzjbu = zzena.zza(zzenk);
            }
            zzelg.zza(iterable, this.zzjbu);
        }

        public static C22018zzb zzbmo() {
            return (C22018zzb) zzjbv.zzbjh();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzeqy.zzel[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C22018zzb((zzeqy) null);
                case 3:
                    return zza((zzeon) zzjbv, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdv", "zzjaw", "zzjbh", "zzjbi", "zzjbk", zzh.class, "zzjbn", "zzjbo", "zzjbp", "zzjbq", "zzjbr", "zzcan", zzg.zzw(), "zzjbg", zza.zzc.zzw(), "zzjbj", "zzjbl", "zzjbm", "zzjap", "zzjbs", "zzjbt", "zzjbu"});
                case 4:
                    return zzjbv;
                case 5:
                    zzeow<zzb> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zzb.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzjbv);
                                zzek = zzeow;
                            }
                        }
                    }
                    return zzeow;
                case 6:
                    return Byte.valueOf(this.zzjat);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzjat = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzjbv = zzb;
            zzena.zza(zzb.class, zzb);
        }
    }
}
