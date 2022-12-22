package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.google.android.gms.internal.ads.zzena;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzbw {

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zza extends zzena<zza, zzb> implements zzeop {
        /* access modifiers changed from: private */
        public static final zza zzej;
        private static volatile zzeow<zza> zzek;
        private int zzdv;
        private String zzdw = "";
        private long zzdx;
        private String zzdy = "";
        private String zzdz = "";
        private String zzea = "";
        private long zzeb;
        private long zzec;
        private String zzed = "";
        private long zzee;
        private String zzef = "";
        private String zzeg = "";
        private zzenk<C22007zza> zzeh = zzbjm();
        private int zzei;

        /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class C22007zza extends zzena<C22007zza, C22008zza> implements zzeop {
            private static volatile zzeow<C22007zza> zzek;
            /* access modifiers changed from: private */
            public static final C22007zza zzeo;
            private int zzdv;
            private String zzem = "";
            private String zzen = "";

            private C22007zza() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
            public static final class C22008zza extends zzena.zzb<C22007zza, C22008zza> implements zzeop {
                private C22008zza() {
                    super(C22007zza.zzeo);
                }

                /* synthetic */ C22008zza(zzbx zzbx) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbx.zzel[i - 1]) {
                    case 1:
                        return new C22007zza();
                    case 2:
                        return new C22008zza((zzbx) null);
                    case 3:
                        return zza((zzeon) zzeo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzdv", "zzem", "zzen"});
                    case 4:
                        return zzeo;
                    case 5:
                        zzeow<C22007zza> zzeow = zzek;
                        if (zzeow == null) {
                            synchronized (C22007zza.class) {
                                zzeow = zzek;
                                if (zzeow == null) {
                                    zzeow = new zzena.zza<>(zzeo);
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
                C22007zza zza = new C22007zza();
                zzeo = zza;
                zzena.zza(C22007zza.class, zza);
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public enum zzc implements zzenf {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);
            
            private static final zzene<zzc> zzes = null;
            private final int value;

            public final int zzv() {
                return this.value;
            }

            public static zzc zzh(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return ENABLED;
                }
                if (i != 2) {
                    return null;
                }
                return DISABLED;
            }

            public static zzenh zzw() {
                return zzby.zzeu;
            }

            public final String toString() {
                return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzes = new zzbz();
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        public static final class zzb extends zzena.zzb<zza, zzb> implements zzeop {
            private zzb() {
                super(zza.zzej);
            }

            public final zzb zzo(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzj(str);
                return this;
            }

            public final zzb zzd(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzc(j);
                return this;
            }

            public final zzb zzp(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzk(str);
                return this;
            }

            public final zzb zzq(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzl(str);
                return this;
            }

            public final zzb zzr(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzm(str);
                return this;
            }

            public final zzb zzs(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzn(str);
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

            /* synthetic */ zzb(zzbx zzbx) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzdv |= 1;
            this.zzdw = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzdv |= 2;
            this.zzdx = j;
        }

        /* access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzdv |= 4;
            this.zzdy = str;
        }

        /* access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zzdv |= 8;
            this.zzdz = str;
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zzdv |= 16;
            this.zzea = str;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzdv |= 1024;
            this.zzeg = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            this.zzei = zzc2.zzv();
            this.zzdv |= 2048;
        }

        public static zzb zzs() {
            return (zzb) zzej.zzbjh();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((zzbx) null);
                case 3:
                    return zza((zzeon) zzej, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzdv", "zzdw", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", "zzeg", "zzeh", C22007zza.class, "zzei", zzc.zzw()});
                case 4:
                    return zzej;
                case 5:
                    zzeow<zza> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zza.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzej);
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
            zzej = zza;
            zzena.zza(zza.class, zza);
        }
    }
}
