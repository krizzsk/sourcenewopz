package com.google.android.gms.internal.ads;

import android.view.View;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.google.android.gms.internal.ads.zzena;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzcf {

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zza extends zzena<zza, zzb> implements zzeop {
        private static volatile zzeow<zza> zzek;
        /* access modifiers changed from: private */
        public static final zza zzil;
        private int zzdv;
        private String zzef = "";
        private String zzfg = "";
        private String zzfi = "";
        private String zzfj = "D";
        private String zzfk = "D";
        private int zzfn;
        private int zzfo;
        private String zzfp = "";
        private long zzfq;
        private long zzfr;
        private long zzfs;
        private long zzft;
        private long zzfu;
        private long zzfv;
        private long zzfw;
        private long zzfx;
        private long zzfy;
        private long zzfz;
        private String zzga = "";
        private long zzgb;
        private long zzgc;
        private long zzgd;
        private long zzge;
        private long zzgf;
        private long zzgg;
        private long zzgh;
        private long zzgi;
        private long zzgj;
        private String zzgk = "D";
        private String zzgl = "";
        private long zzgm;
        private long zzgn;
        private long zzgo;
        private long zzgp;
        private long zzgq = -1;
        private long zzgr = -1;
        private zzb zzgs;
        private long zzgt = -1;
        private long zzgu = -1;
        private long zzgv = -1;
        private long zzgw = -1;
        private long zzgx = -1;
        private long zzgy = -1;
        private long zzgz = -1;
        private int zzha = 1000;
        private int zzhb = 1000;
        private long zzhc = -1;
        private long zzhd = -1;
        private long zzhe = -1;
        private long zzhf = -1;
        private long zzhg = -1;
        private int zzhh = 1000;
        private zzf zzhi;
        private zzenk<zzf> zzhj = zzbjm();
        private zzg zzhk;
        private long zzhl = -1;
        private long zzhm = -1;
        private long zzhn = -1;
        private long zzho = -1;
        private long zzhp = -1;
        private long zzhq = -1;
        private long zzhr = -1;
        private long zzhs = -1;
        private String zzht = "D";
        private long zzhu = -1;
        private int zzhv;
        private int zzhw;
        private int zzhx;
        private zze zzhy;
        private long zzhz = -1;
        private int zzia = 1000;
        private int zzib = 1000;
        private String zzic = "D";
        private zzenk<zze> zzid = zzbjm();
        private long zzie;
        private String zzif = "";
        private int zzig = 2;
        private boolean zzih;
        private String zzii = "";
        private long zzij;
        private zzd zzik;

        /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public enum C22010zza implements zzenf {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3),
            DEBUGGER_STATE_ENVVAR(4),
            DEBUGGER_STATE_MACHPORT(5),
            DEBUGGER_STATE_ENVVAR_MACHPORT(6);
            
            private static final zzene<C22010zza> zzes = null;
            private final int value;

            public final int zzv() {
                return this.value;
            }

            public static C22010zza zzk(int i) {
                switch (i) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    case 4:
                        return DEBUGGER_STATE_ENVVAR;
                    case 5:
                        return DEBUGGER_STATE_MACHPORT;
                    case 6:
                        return DEBUGGER_STATE_ENVVAR_MACHPORT;
                    default:
                        return null;
                }
            }

            public static zzenh zzw() {
                return zzch.zzeu;
            }

            public final String toString() {
                return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private C22010zza(int i) {
                this.value = i;
            }

            static {
                zzes = new zzci();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public enum zzc implements zzenf {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6),
            DEVICE_IDENTIFIER_PER_APP_ID(7);
            
            private static final zzene<zzc> zzes = null;
            private final int value;

            public final int zzv() {
                return this.value;
            }

            public static zzc zzl(int i) {
                switch (i) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    case 7:
                        return DEVICE_IDENTIFIER_PER_APP_ID;
                    default:
                        return null;
                }
            }

            public static zzenh zzw() {
                return zzck.zzeu;
            }

            public final String toString() {
                return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzes = new zzcj();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public enum zzd implements zzenf {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(512),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(2048),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(32768),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);
            
            private static final zzene<zzd> zzes = null;
            private final int value;

            public final int zzv() {
                return this.value;
            }

            public final String toString() {
                return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzd(int i) {
                this.value = i;
            }

            static {
                zzes = new zzcl();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zze extends zzena<zze, C22011zza> implements zzeop {
            private static volatile zzeow<zze> zzek;
            /* access modifiers changed from: private */
            public static final zze zzkf;
            private int zzdv;
            private int zzkd;
            private long zzke = -1;

            private zze() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zze$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
            public static final class C22011zza extends zzena.zzb<zze, C22011zza> implements zzeop {
                private C22011zza() {
                    super(zze.zzkf);
                }

                /* synthetic */ C22011zza(zzcg zzcg) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzcg.zzel[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C22011zza((zzcg) null);
                    case 3:
                        return zza((zzeon) zzkf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"zzdv", "zzkd", zzc.zzw(), "zzke"});
                    case 4:
                        return zzkf;
                    case 5:
                        zzeow<zze> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zze.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzkf);
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
                zze zze = new zze();
                zzkf = zze;
                zzena.zza(zze.class, zze);
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zzf extends zzena<zzf, C22012zza> implements zzeop {
            private static volatile zzeow<zzf> zzek;
            /* access modifiers changed from: private */
            public static final zzf zzkz;
            private int zzdv;
            private long zzgb = -1;
            private long zzgc = -1;
            private long zzkg = -1;
            private long zzkh = -1;
            private long zzki = -1;
            private long zzkj = -1;
            private int zzkk = 1000;
            private long zzkl = -1;
            private long zzkm = -1;
            private long zzkn = -1;
            private int zzko = 1000;
            private long zzkp = -1;
            private long zzkq = -1;
            private long zzkr = -1;
            private long zzks = -1;
            private long zzkt;
            private long zzku;
            private long zzkv = -1;
            private long zzkw = -1;
            private long zzkx = -1;
            private long zzky = -1;

            private zzf() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zzf$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
            public static final class C22012zza extends zzena.zzb<zzf, C22012zza> implements zzeop {
                private C22012zza() {
                    super(zzf.zzkz);
                }

                public final C22012zza zzcl(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzj(j);
                    return this;
                }

                public final C22012zza zzcm(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzk(j);
                    return this;
                }

                public final C22012zza zzcn(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbs(j);
                    return this;
                }

                public final C22012zza zzco(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbt(j);
                    return this;
                }

                public final C22012zza zzaz() {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzau();
                    return this;
                }

                public final C22012zza zzcp(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbu(j);
                    return this;
                }

                public final C22012zza zzcq(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbv(j);
                    return this;
                }

                public final C22012zza zzm(zzcq zzcq) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzk(zzcq);
                    return this;
                }

                public final C22012zza zzcr(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbw(j);
                    return this;
                }

                public final C22012zza zzcs(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbx(j);
                    return this;
                }

                public final C22012zza zzct(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzby(j);
                    return this;
                }

                public final C22012zza zzn(zzcq zzcq) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzl(zzcq);
                    return this;
                }

                public final C22012zza zzcu(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbz(j);
                    return this;
                }

                public final C22012zza zzcv(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzca(j);
                    return this;
                }

                public final C22012zza zzcw(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcb(j);
                    return this;
                }

                public final C22012zza zzcx(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcc(j);
                    return this;
                }

                public final C22012zza zzcy(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcd(j);
                    return this;
                }

                public final C22012zza zzcz(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzce(j);
                    return this;
                }

                public final C22012zza zzda(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcf(j);
                    return this;
                }

                public final C22012zza zzdb(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcg(j);
                    return this;
                }

                /* synthetic */ C22012zza(zzcg zzcg) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzj(long j) {
                this.zzdv |= 1;
                this.zzgb = j;
            }

            /* access modifiers changed from: private */
            public final void zzk(long j) {
                this.zzdv |= 2;
                this.zzgc = j;
            }

            /* access modifiers changed from: private */
            public final void zzbs(long j) {
                this.zzdv |= 4;
                this.zzkg = j;
            }

            /* access modifiers changed from: private */
            public final void zzbt(long j) {
                this.zzdv |= 8;
                this.zzkh = j;
            }

            /* access modifiers changed from: private */
            public final void zzau() {
                this.zzdv &= -9;
                this.zzkh = -1;
            }

            /* access modifiers changed from: private */
            public final void zzbu(long j) {
                this.zzdv |= 16;
                this.zzki = j;
            }

            /* access modifiers changed from: private */
            public final void zzbv(long j) {
                this.zzdv |= 32;
                this.zzkj = j;
            }

            /* access modifiers changed from: private */
            public final void zzk(zzcq zzcq) {
                this.zzkk = zzcq.zzv();
                this.zzdv |= 64;
            }

            /* access modifiers changed from: private */
            public final void zzbw(long j) {
                this.zzdv |= 128;
                this.zzkl = j;
            }

            /* access modifiers changed from: private */
            public final void zzbx(long j) {
                this.zzdv |= 256;
                this.zzkm = j;
            }

            /* access modifiers changed from: private */
            public final void zzby(long j) {
                this.zzdv |= 512;
                this.zzkn = j;
            }

            /* access modifiers changed from: private */
            public final void zzl(zzcq zzcq) {
                this.zzko = zzcq.zzv();
                this.zzdv |= 1024;
            }

            /* access modifiers changed from: private */
            public final void zzbz(long j) {
                this.zzdv |= 2048;
                this.zzkp = j;
            }

            /* access modifiers changed from: private */
            public final void zzca(long j) {
                this.zzdv |= 4096;
                this.zzkq = j;
            }

            /* access modifiers changed from: private */
            public final void zzcb(long j) {
                this.zzdv |= 8192;
                this.zzkr = j;
            }

            /* access modifiers changed from: private */
            public final void zzcc(long j) {
                this.zzdv |= 16384;
                this.zzks = j;
            }

            /* access modifiers changed from: private */
            public final void zzcd(long j) {
                this.zzdv |= 32768;
                this.zzkt = j;
            }

            /* access modifiers changed from: private */
            public final void zzce(long j) {
                this.zzdv |= 65536;
                this.zzku = j;
            }

            /* access modifiers changed from: private */
            public final void zzcf(long j) {
                this.zzdv |= 131072;
                this.zzkv = j;
            }

            /* access modifiers changed from: private */
            public final void zzcg(long j) {
                this.zzdv |= 262144;
                this.zzkw = j;
            }

            public static C22012zza zzav() {
                return (C22012zza) zzkz.zzbjh();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzcg.zzel[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C22012zza((zzcg) null);
                    case 3:
                        return zza((zzeon) zzkz, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzdv", "zzgb", "zzgc", "zzkg", "zzkh", "zzki", "zzkj", "zzkk", zzcq.zzw(), "zzkl", "zzkm", "zzkn", "zzko", zzcq.zzw(), "zzkp", "zzkq", "zzkr", "zzks", "zzkt", "zzku", "zzkv", "zzkw", "zzkx", "zzky"});
                    case 4:
                        return zzkz;
                    case 5:
                        zzeow<zzf> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zzf.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzkz);
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
                zzkz = zzf;
                zzena.zza(zzf.class, zzf);
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zzg extends zzena<zzg, C22013zza> implements zzeop {
            private static volatile zzeow<zzg> zzek;
            /* access modifiers changed from: private */
            public static final zzg zzle;
            private int zzdv;
            private long zzhf = -1;
            private long zzhg = -1;
            private long zzla = -1;
            private long zzlb = -1;
            private long zzlc = -1;
            private long zzld = -1;

            private zzg() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zzg$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
            public static final class C22013zza extends zzena.zzb<zzg, C22013zza> implements zzeop {
                private C22013zza() {
                    super(zzg.zzle);
                }

                public final C22013zza zzdc(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzg) this.zzits).zzch(j);
                    return this;
                }

                public final C22013zza zzdd(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzg) this.zzits).zzci(j);
                    return this;
                }

                public final C22013zza zzde(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzg) this.zzits).zzcj(j);
                    return this;
                }

                public final C22013zza zzdf(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzg) this.zzits).zzck(j);
                    return this;
                }

                /* synthetic */ C22013zza(zzcg zzcg) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzch(long j) {
                this.zzdv |= 4;
                this.zzla = j;
            }

            /* access modifiers changed from: private */
            public final void zzci(long j) {
                this.zzdv |= 8;
                this.zzlb = j;
            }

            /* access modifiers changed from: private */
            public final void zzcj(long j) {
                this.zzdv |= 16;
                this.zzlc = j;
            }

            /* access modifiers changed from: private */
            public final void zzck(long j) {
                this.zzdv |= 32;
                this.zzld = j;
            }

            public static C22013zza zzax() {
                return (C22013zza) zzle.zzbjh();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzcg.zzel[i - 1]) {
                    case 1:
                        return new zzg();
                    case 2:
                        return new C22013zza((zzcg) null);
                    case 3:
                        return zza((zzeon) zzle, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzdv", "zzhf", "zzhg", "zzla", "zzlb", "zzlc", "zzld"});
                    case 4:
                        return zzle;
                    case 5:
                        zzeow<zzg> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (zzg.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzle);
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
                zzg zzg = new zzg();
                zzle = zzg;
                zzena.zza(zzg.class, zzg);
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zzb extends zzena.zzb<zza, zzb> implements zzeop {
            private zzb() {
                super(zza.zzil);
            }

            public final zzb zzac(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzt(str);
                return this;
            }

            public final zzb zzad(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzu(str);
                return this;
            }

            public final zzb zzal(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zze(j);
                return this;
            }

            public final zzb zzam(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzf(j);
                return this;
            }

            public final zzb zzan(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzg(j);
                return this;
            }

            public final zzb zzao(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzh(j);
                return this;
            }

            public final zzb zzap(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzi(j);
                return this;
            }

            public final zzb zzaq(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzj(j);
                return this;
            }

            public final zzb zzar(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzk(j);
                return this;
            }

            public final zzb zzas(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzl(j);
                return this;
            }

            public final zzb zzat(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzm(j);
                return this;
            }

            public final zzb zzau(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzn(j);
                return this;
            }

            public final zzb zzav(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzo(j);
                return this;
            }

            public final zzb zzaw(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzp(j);
                return this;
            }

            public final zzb zzae(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzv(str);
                return this;
            }

            public final zzb zzaf(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzw(str);
                return this;
            }

            public final zzb zzax(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzq(j);
                return this;
            }

            public final zzb zzay(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzr(j);
                return this;
            }

            public final zzb zzaz(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzs(j);
                return this;
            }

            public final zzb zzag(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzx(str);
                return this;
            }

            public final zzb zzba(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzt(j);
                return this;
            }

            @Deprecated
            public final zzb zzbb(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzu(j);
                return this;
            }

            public final zzb zzbc(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzv(j);
                return this;
            }

            public final zzb zzbd(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzw(j);
                return this;
            }

            public final zzb zzbe(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzx(j);
                return this;
            }

            public final zzb zzbf(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzy(j);
                return this;
            }

            public final zzb zzbg(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzz(j);
                return this;
            }

            public final zzb zzbh(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaa(j);
                return this;
            }

            public final zzb zzbi(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzab(j);
                return this;
            }

            public final zzb zzah(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzy(str);
                return this;
            }

            public final zzb zzai(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzz(str);
                return this;
            }

            public final zzb zzf(zzcq zzcq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzcq);
                return this;
            }

            public final zzb zzg(zzcq zzcq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzb(zzcq);
                return this;
            }

            public final zzb zzbj(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzac(j);
                return this;
            }

            public final zzb zzbk(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzad(j);
                return this;
            }

            public final zzb zzbl(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzae(j);
                return this;
            }

            public final zzb zzh(zzcq zzcq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzc(zzcq);
                return this;
            }

            public final zzb zzc(zzf zzf) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzf);
                return this;
            }

            public final zzb zzd(zzf zzf) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzb(zzf);
                return this;
            }

            public final zzb zzas() {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaj();
                return this;
            }

            public final zzb zzb(zzg zzg) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzg);
                return this;
            }

            public final zzb zzbm(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaf(j);
                return this;
            }

            public final zzb zzbn(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzag(j);
                return this;
            }

            public final zzb zzbo(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzah(j);
                return this;
            }

            public final zzb zzbp(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzai(j);
                return this;
            }

            public final zzb zzbq(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaj(j);
                return this;
            }

            public final zzb zzaj(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaa(str);
                return this;
            }

            public final zzb zzi(zzcq zzcq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzd(zzcq);
                return this;
            }

            public final zzb zzj(zzcq zzcq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zze(zzcq);
                return this;
            }

            public final zzb zzak(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzab(str);
                return this;
            }

            public final zzb zzb(zzc zzc) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzc);
                return this;
            }

            public final zzb zzb(boolean z) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(z);
                return this;
            }

            public final zzb zzbr(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzak(j);
                return this;
            }

            /* synthetic */ zzb(zzcg zzcg) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzt(String str) {
            str.getClass();
            this.zzdv |= 1;
            this.zzfp = str;
        }

        /* access modifiers changed from: private */
        public final void zzu(String str) {
            str.getClass();
            this.zzdv |= 2;
            this.zzef = str;
        }

        /* access modifiers changed from: private */
        public final void zze(long j) {
            this.zzdv |= 4;
            this.zzfq = j;
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzdv |= 16;
            this.zzfs = j;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzdv |= 32;
            this.zzft = j;
        }

        /* access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzdv |= 1024;
            this.zzfy = j;
        }

        /* access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzdv |= 2048;
            this.zzfz = j;
        }

        /* access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzdv |= 8192;
            this.zzgb = j;
        }

        /* access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzdv |= 16384;
            this.zzgc = j;
        }

        /* access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzdv |= 32768;
            this.zzgd = j;
        }

        /* access modifiers changed from: private */
        public final void zzm(long j) {
            this.zzdv |= 65536;
            this.zzge = j;
        }

        /* access modifiers changed from: private */
        public final void zzn(long j) {
            this.zzdv |= 524288;
            this.zzgh = j;
        }

        /* access modifiers changed from: private */
        public final void zzo(long j) {
            this.zzdv |= 1048576;
            this.zzgi = j;
        }

        /* access modifiers changed from: private */
        public final void zzp(long j) {
            this.zzdv |= 2097152;
            this.zzgj = j;
        }

        public final boolean zzai() {
            return (this.zzdv & 4194304) != 0;
        }

        public final String zzaf() {
            return this.zzfg;
        }

        /* access modifiers changed from: private */
        public final void zzv(String str) {
            str.getClass();
            this.zzdv |= 4194304;
            this.zzfg = str;
        }

        /* access modifiers changed from: private */
        public final void zzw(String str) {
            str.getClass();
            this.zzdv |= 16777216;
            this.zzgl = str;
        }

        /* access modifiers changed from: private */
        public final void zzq(long j) {
            this.zzdv |= 33554432;
            this.zzgm = j;
        }

        /* access modifiers changed from: private */
        public final void zzr(long j) {
            this.zzdv |= View.STATUS_BAR_TRANSIENT;
            this.zzgn = j;
        }

        /* access modifiers changed from: private */
        public final void zzs(long j) {
            this.zzdv |= View.NAVIGATION_BAR_TRANSIENT;
            this.zzgo = j;
        }

        /* access modifiers changed from: private */
        public final void zzx(String str) {
            str.getClass();
            this.zzdv |= 268435456;
            this.zzfi = str;
        }

        /* access modifiers changed from: private */
        public final void zzt(long j) {
            this.zzdv |= View.NAVIGATION_BAR_UNHIDE;
            this.zzgp = j;
        }

        /* access modifiers changed from: private */
        public final void zzu(long j) {
            this.zzdv |= 1073741824;
            this.zzgq = j;
        }

        /* access modifiers changed from: private */
        public final void zzv(long j) {
            this.zzdv |= Integer.MIN_VALUE;
            this.zzgr = j;
        }

        /* access modifiers changed from: private */
        public final void zzw(long j) {
            this.zzfn |= 2;
            this.zzgt = j;
        }

        /* access modifiers changed from: private */
        public final void zzx(long j) {
            this.zzfn |= 4;
            this.zzgu = j;
        }

        /* access modifiers changed from: private */
        public final void zzy(long j) {
            this.zzfn |= 8;
            this.zzgv = j;
        }

        /* access modifiers changed from: private */
        public final void zzz(long j) {
            this.zzfn |= 16;
            this.zzgw = j;
        }

        /* access modifiers changed from: private */
        public final void zzaa(long j) {
            this.zzfn |= 32;
            this.zzgx = j;
        }

        /* access modifiers changed from: private */
        public final void zzab(long j) {
            this.zzfn |= 64;
            this.zzgy = j;
        }

        /* access modifiers changed from: private */
        public final void zzy(String str) {
            str.getClass();
            this.zzfn |= 128;
            this.zzfj = str;
        }

        /* access modifiers changed from: private */
        public final void zzz(String str) {
            str.getClass();
            this.zzfn |= 256;
            this.zzfk = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzcq zzcq) {
            this.zzha = zzcq.zzv();
            this.zzfn |= 1024;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzcq zzcq) {
            this.zzhb = zzcq.zzv();
            this.zzfn |= 2048;
        }

        /* access modifiers changed from: private */
        public final void zzac(long j) {
            this.zzfn |= 4096;
            this.zzhc = j;
        }

        /* access modifiers changed from: private */
        public final void zzad(long j) {
            this.zzfn |= 8192;
            this.zzhd = j;
        }

        /* access modifiers changed from: private */
        public final void zzae(long j) {
            this.zzfn |= 16384;
            this.zzhe = j;
        }

        /* access modifiers changed from: private */
        public final void zzc(zzcq zzcq) {
            this.zzhh = zzcq.zzv();
            this.zzfn |= 131072;
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf2) {
            zzf2.getClass();
            this.zzhi = zzf2;
            this.zzfn |= 262144;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzf zzf2) {
            zzf2.getClass();
            zzenk<zzf> zzenk = this.zzhj;
            if (!zzenk.zzbhd()) {
                this.zzhj = zzena.zza(zzenk);
            }
            this.zzhj.add(zzf2);
        }

        /* access modifiers changed from: private */
        public final void zzaj() {
            this.zzhj = zzbjm();
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg2) {
            zzg2.getClass();
            this.zzhk = zzg2;
            this.zzfn |= 524288;
        }

        /* access modifiers changed from: private */
        public final void zzaf(long j) {
            this.zzfn |= 2097152;
            this.zzhm = j;
        }

        /* access modifiers changed from: private */
        public final void zzag(long j) {
            this.zzfn |= 4194304;
            this.zzhn = j;
        }

        /* access modifiers changed from: private */
        public final void zzah(long j) {
            this.zzfn |= 8388608;
            this.zzho = j;
        }

        /* access modifiers changed from: private */
        public final void zzai(long j) {
            this.zzfn |= View.STATUS_BAR_TRANSIENT;
            this.zzhr = j;
        }

        /* access modifiers changed from: private */
        public final void zzaj(long j) {
            this.zzfn |= View.NAVIGATION_BAR_TRANSIENT;
            this.zzhs = j;
        }

        /* access modifiers changed from: private */
        public final void zzaa(String str) {
            str.getClass();
            this.zzfn |= 268435456;
            this.zzht = str;
        }

        /* access modifiers changed from: private */
        public final void zzd(zzcq zzcq) {
            this.zzia = zzcq.zzv();
            this.zzfo |= 8;
        }

        /* access modifiers changed from: private */
        public final void zze(zzcq zzcq) {
            this.zzib = zzcq.zzv();
            this.zzfo |= 16;
        }

        public final String zzak() {
            return this.zzif;
        }

        /* access modifiers changed from: private */
        public final void zzab(String str) {
            str.getClass();
            this.zzfo |= 128;
            this.zzif = str;
        }

        public final zzc zzal() {
            zzc zzl = zzc.zzl(this.zzig);
            return zzl == null ? zzc.DEVICE_IDENTIFIER_GLOBAL_ID : zzl;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            this.zzig = zzc2.zzv();
            this.zzfo |= 256;
        }

        public final boolean zzam() {
            return this.zzih;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzfo |= 512;
            this.zzih = z;
        }

        /* access modifiers changed from: private */
        public final void zzak(long j) {
            this.zzfo |= 2048;
            this.zzij = j;
        }

        public final boolean zzan() {
            return (this.zzfo & 4096) != 0;
        }

        public final zzd zzao() {
            zzd zzd2 = this.zzik;
            return zzd2 == null ? zzd.zzbj() : zzd2;
        }

        public static zza zza(byte[] bArr, zzemn zzemn) throws zzenn {
            return (zza) zzena.zza(zzil, bArr, zzemn);
        }

        public static zzb zzap() {
            return (zzb) zzil.zzbjh();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((zzcg) null);
                case 3:
                    return zza((zzeon) zzil, "\u0001O\u0000\u0003\u0001ÉO\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂF\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈG\u0019ဂK\u001aဌH\u001bဈ\u0016\u001cဇI\u001dဈ\u0018\u001eဈJ\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0ဌ*1ဌ+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08ဌ19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=Aဌ>Bဌ?Cဈ<Dဌ@EဉAFဂBGဂ8Hဂ9IဌCJဂ)Kဈ\u0017LဌDMဈEN\u001bÉဉL", new Object[]{"zzdv", "zzfn", "zzfo", "zzfp", "zzef", "zzfq", "zzfr", "zzfs", "zzft", "zzfu", "zzfv", "zzfw", "zzfx", "zzfy", "zzfz", "zzga", "zzgb", "zzgc", "zzgd", "zzge", "zzgf", "zzgg", "zzgh", "zzie", "zzgi", "zzgj", "zzif", "zzij", "zzig", zzc.zzw(), "zzfg", "zzih", "zzgl", "zzii", "zzgm", "zzgn", "zzgo", "zzfi", "zzgp", "zzgq", "zzgr", "zzgs", "zzgt", "zzgu", "zzgv", "zzgw", "zzhj", zzf.class, "zzgx", "zzgy", "zzfj", "zzfk", "zzha", zzcq.zzw(), "zzhb", zzcq.zzw(), "zzhi", "zzhc", "zzhd", "zzhe", "zzhf", "zzhg", "zzhh", zzcq.zzw(), "zzhk", "zzhl", "zzhm", "zzhn", "zzho", "zzhr", "zzhs", "zzhu", "zzhv", zzcm.zzw(), "zzhw", zzcr.zzw(), "zzht", "zzhx", C22010zza.zzw(), "zzhy", "zzhz", "zzhp", "zzhq", "zzia", zzcq.zzw(), "zzgz", "zzgk", "zzib", zzcq.zzw(), "zzic", "zzid", zze.class, "zzik"});
                case 4:
                    return zzil;
                case 5:
                    zzeow<zza> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zza.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzil);
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

        public static zza zzaq() {
            return zzil;
        }

        static {
            zza zza = new zza();
            zzil = zza;
            zzena.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zzb extends zzena<zzb, zza> implements zzeop {
        private static volatile zzeow<zzb> zzek;
        /* access modifiers changed from: private */
        public static final zzb zzlk;
        private int zzdv;
        private long zzlf;
        private int zzlg;
        private boolean zzlh;
        private zzeng zzli = zzbjk();
        private long zzlj;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zza extends zzena.zzb<zzb, zza> implements zzeop {
            private zza() {
                super(zzb.zzlk);
            }

            /* synthetic */ zza(zzcg zzcg) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzcg) null);
                case 3:
                    return zza((zzeon) zzlk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzdv", "zzlf", "zzlg", "zzlh", "zzli", "zzlj"});
                case 4:
                    return zzlk;
                case 5:
                    zzeow<zzb> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zzb.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzlk);
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
            zzlk = zzb;
            zzena.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zzd extends zzena<zzd, zza> implements zzeop {
        private static volatile zzeow<zzd> zzek;
        /* access modifiers changed from: private */
        public static final zzd zzmj;
        private int zzdv;
        private long zzlf;
        private String zzmh = "";
        private zzelq zzmi = zzelq.zzipc;

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zza extends zzena.zzb<zzd, zza> implements zzeop {
            private zza() {
                super(zzd.zzmj);
            }

            /* synthetic */ zza(zzcg zzcg) {
                this();
            }
        }

        public final boolean zzbh() {
            return (this.zzdv & 1) != 0;
        }

        public final long zzbi() {
            return this.zzlf;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzcg) null);
                case 3:
                    return zza((zzeon) zzmj, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzdv", "zzlf", "zzmh", "zzmi"});
                case 4:
                    return zzmj;
                case 5:
                    zzeow<zzd> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zzd.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzmj);
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

        public static zzd zzbj() {
            return zzmj;
        }

        static {
            zzd zzd = new zzd();
            zzmj = zzd;
            zzena.zza(zzd.class, zzd);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zze extends zzena<zze, zza> implements zzeop {
        private static volatile zzeow<zze> zzek;
        /* access modifiers changed from: private */
        public static final zze zzmk;
        private int zzdv;
        private String zzfl = "";

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zza extends zzena.zzb<zze, zza> implements zzeop {
            private zza() {
                super(zze.zzmk);
            }

            /* synthetic */ zza(zzcg zzcg) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzcg) null);
                case 3:
                    return zza((zzeon) zzmk, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdv", "zzfl"});
                case 4:
                    return zzmk;
                case 5:
                    zzeow<zze> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zze.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzmk);
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
            zze zze = new zze();
            zzmk = zze;
            zzena.zza(zze.class, zze);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zzc extends zzena<zzc, zza> implements zzeop {
        private static volatile zzeow<zzc> zzek;
        /* access modifiers changed from: private */
        public static final zzc zzlp;
        private int zzdv;
        private zzelq zzll = zzelq.zzipc;
        private zzelq zzlm = zzelq.zzipc;
        private zzelq zzln = zzelq.zzipc;
        private zzelq zzlo = zzelq.zzipc;

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zza extends zzena.zzb<zzc, zza> implements zzeop {
            private zza() {
                super(zzc.zzlp);
            }

            public final zza zze(zzelq zzelq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzc) this.zzits).zza(zzelq);
                return this;
            }

            public final zza zzf(zzelq zzelq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzc) this.zzits).zzb(zzelq);
                return this;
            }

            public final zza zzg(zzelq zzelq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzc) this.zzits).zzc(zzelq);
                return this;
            }

            public final zza zzh(zzelq zzelq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzc) this.zzits).zzd(zzelq);
                return this;
            }

            /* synthetic */ zza(zzcg zzcg) {
                this();
            }
        }

        public final zzelq zzbb() {
            return this.zzll;
        }

        /* access modifiers changed from: private */
        public final void zza(zzelq zzelq) {
            zzelq.getClass();
            this.zzdv |= 1;
            this.zzll = zzelq;
        }

        public final zzelq zzbc() {
            return this.zzlm;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzelq zzelq) {
            zzelq.getClass();
            this.zzdv |= 2;
            this.zzlm = zzelq;
        }

        public final zzelq zzbd() {
            return this.zzln;
        }

        /* access modifiers changed from: private */
        public final void zzc(zzelq zzelq) {
            zzelq.getClass();
            this.zzdv |= 4;
            this.zzln = zzelq;
        }

        public final zzelq zzbe() {
            return this.zzlo;
        }

        /* access modifiers changed from: private */
        public final void zzd(zzelq zzelq) {
            zzelq.getClass();
            this.zzdv |= 8;
            this.zzlo = zzelq;
        }

        public static zzc zzb(byte[] bArr, zzemn zzemn) throws zzenn {
            return (zzc) zzena.zza(zzlp, bArr, zzemn);
        }

        public static zza zzbf() {
            return (zza) zzlp.zzbjh();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzcg) null);
                case 3:
                    return zza((zzeon) zzlp, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzdv", "zzll", "zzlm", "zzln", "zzlo"});
                case 4:
                    return zzlp;
                case 5:
                    zzeow<zzc> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zzc.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzlp);
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
            zzc zzc = new zzc();
            zzlp = zzc;
            zzena.zza(zzc.class, zzc);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zzf extends zzena<zzf, zza> implements zzeop {
        private static volatile zzeow<zzf> zzek;
        /* access modifiers changed from: private */
        public static final zzf zzmm;
        private int zzdv;
        private int zzhv = 1;
        private int zzhw = 1;
        private zzelq zzlm = zzelq.zzipc;
        private zzenk<zzelq> zzml = zzbjm();

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zza extends zzena.zzb<zzf, zza> implements zzeop {
            private zza() {
                super(zzf.zzmm);
            }

            public final zza zzi(zzelq zzelq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzf) this.zzits).zzk(zzelq);
                return this;
            }

            public final zza zzj(zzelq zzelq) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzf) this.zzits).zzb(zzelq);
                return this;
            }

            public final zza zza(zzcm zzcm) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzf) this.zzits).zzb(zzcm);
                return this;
            }

            /* synthetic */ zza(zzcg zzcg) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzk(zzelq zzelq) {
            zzelq.getClass();
            zzenk<zzelq> zzenk = this.zzml;
            if (!zzenk.zzbhd()) {
                this.zzml = zzena.zza(zzenk);
            }
            this.zzml.add(zzelq);
        }

        /* access modifiers changed from: private */
        public final void zzb(zzelq zzelq) {
            zzelq.getClass();
            this.zzdv |= 1;
            this.zzlm = zzelq;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzcm zzcm) {
            this.zzhv = zzcm.zzv();
            this.zzdv |= 4;
        }

        public static zza zzbm() {
            return (zza) zzmm.zzbjh();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzcg) null);
                case 3:
                    return zza((zzeon) zzmm, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzdv", "zzml", "zzlm", "zzhw", zzcr.zzw(), "zzhv", zzcm.zzw()});
                case 4:
                    return zzmm;
                case 5:
                    zzeow<zzf> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zzf.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzmm);
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
            zzmm = zzf;
            zzena.zza(zzf.class, zzf);
        }
    }
}
