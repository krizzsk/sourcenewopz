package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.google.android.gms.internal.ads.zzdvq;
import com.google.android.gms.internal.ads.zzena;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdvx extends zzena<zzdvx, zzb> implements zzeop {
    private static volatile zzeow<zzdvx> zzek;
    /* access modifiers changed from: private */
    public static final zzdvx zzhwu;
    private int zzdv;
    private String zzdw = "";
    private int zzhwr;
    private String zzhws = "";
    private zzdvq zzhwt;

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public enum zza implements zzenf {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        
        private static final zzene<zza> zzes = null;
        private final int value;

        public final int zzv() {
            return this.value;
        }

        public static zza zzeq(int i) {
            if (i == 0) {
                return EVENT_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return BLOCKED_IMPRESSION;
        }

        public static zzenh zzw() {
            return zzdvy.zzeu;
        }

        public final String toString() {
            return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
        }

        private zza(int i) {
            this.value = i;
        }

        static {
            zzes = new zzdvz();
        }
    }

    private zzdvx() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zzb extends zzena.zzb<zzdvx, zzb> implements zzeop {
        private zzb() {
            super(zzdvx.zzhwu);
        }

        public final zzb zzb(zza zza) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvx) this.zzits).zza(zza);
            return this;
        }

        public final zzb zzhj(String str) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvx) this.zzits).zzj(str);
            return this;
        }

        public final zzb zza(zzdvq.zzb zzb) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvx) this.zzits).zza((zzdvq) ((zzena) zzb.zzbjv()));
            return this;
        }

        /* synthetic */ zzb(zzdvw zzdvw) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        this.zzhwr = zza2.zzv();
        this.zzdv |= 1;
    }

    /* access modifiers changed from: private */
    public final void zzj(String str) {
        str.getClass();
        this.zzdv |= 2;
        this.zzdw = str;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdvq zzdvq) {
        zzdvq.getClass();
        this.zzhwt = zzdvq;
        this.zzdv |= 8;
    }

    public static zzb zzazb() {
        return (zzb) zzhwu.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdvw.zzel[i - 1]) {
            case 1:
                return new zzdvx();
            case 2:
                return new zzb((zzdvw) null);
            case 3:
                return zza((zzeon) zzhwu, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzdv", "zzhwr", zza.zzw(), "zzdw", "zzhws", "zzhwt"});
            case 4:
                return zzhwu;
            case 5:
                zzeow<zzdvx> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzdvx.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzhwu);
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
        zzdvx zzdvx = new zzdvx();
        zzhwu = zzdvx;
        zzena.zza(zzdvx.class, zzdvx);
    }
}
