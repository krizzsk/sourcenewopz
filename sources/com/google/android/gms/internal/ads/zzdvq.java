package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.google.android.gms.internal.ads.zzena;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdvq extends zzena<zzdvq, zzb> implements zzeop {
    private static volatile zzeow<zzdvq> zzek;
    private static final zzeni<Integer, zza> zzhwj = new zzdvt();
    /* access modifiers changed from: private */
    public static final zzdvq zzhwn;
    private int zzdv;
    private zzeng zzhwi = zzbjk();
    private String zzhwk = "";
    private String zzhwl = "";
    private String zzhwm = "";

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public enum zza implements zzenf {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzene<zza> zzes = null;
        private final int value;

        public final int zzv() {
            return this.value;
        }

        public static zza zzep(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        public static zzenh zzw() {
            return zzdvv.zzeu;
        }

        public final String toString() {
            return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
        }

        private zza(int i) {
            this.value = i;
        }

        static {
            zzes = new zzdvu();
        }
    }

    private zzdvq() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zzb extends zzena.zzb<zzdvq, zzb> implements zzeop {
        private zzb() {
            super(zzdvq.zzhwn);
        }

        public final zzb zzb(zza zza) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvq) this.zzits).zza(zza);
            return this;
        }

        public final zzb zzhi(String str) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvq) this.zzits).zzhh(str);
            return this;
        }

        /* synthetic */ zzb(zzdvt zzdvt) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        zza2.getClass();
        zzeng zzeng = this.zzhwi;
        if (!zzeng.zzbhd()) {
            this.zzhwi = zzena.zza(zzeng);
        }
        this.zzhwi.zzhp(zza2.zzv());
    }

    /* access modifiers changed from: private */
    public final void zzhh(String str) {
        str.getClass();
        this.zzdv |= 1;
        this.zzhwk = str;
    }

    public static zzb zzayz() {
        return (zzb) zzhwn.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdvs.zzel[i - 1]) {
            case 1:
                return new zzdvq();
            case 2:
                return new zzb((zzdvt) null);
            case 3:
                return zza((zzeon) zzhwn, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdv", "zzhwi", zza.zzw(), "zzhwk", "zzhwl", "zzhwm"});
            case 4:
                return zzhwn;
            case 5:
                zzeow<zzdvq> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzdvq.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzhwn);
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
        zzdvq zzdvq = new zzdvq();
        zzhwn = zzdvq;
        zzena.zza(zzdvq.class, zzdvq);
    }
}
