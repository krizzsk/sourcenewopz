package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.google.android.gms.internal.ads.zzena;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeic extends zzena<zzeic, zzb> implements zzeop {
    private static volatile zzeow<zzeic> zzek;
    /* access modifiers changed from: private */
    public static final zzeic zzijy;
    private String zzijv = "";
    private zzelq zzijw = zzelq.zzipc;
    private int zzijx;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public enum zza implements zzenf {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzene<zza> zzes = null;
        private final int value;

        public final int zzv() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zza zzfr(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(IMTextUtils.STREET_IMAGE_TAG_START);
            sb.append(getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzv());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append(Typography.greater);
            return sb.toString();
        }

        private zza(int i) {
            this.value = i;
        }

        static {
            zzes = new zzeie();
        }
    }

    private zzeic() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zzb extends zzena.zzb<zzeic, zzb> implements zzeop {
        private zzb() {
            super(zzeic.zzijy);
        }

        public final zzb zzhv(String str) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeic) this.zzits).zzhu(str);
            return this;
        }

        public final zzb zzag(zzelq zzelq) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeic) this.zzits).zzaf(zzelq);
            return this;
        }

        public final zzb zzb(zza zza) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeic) this.zzits).zza(zza);
            return this;
        }

        /* synthetic */ zzb(zzeib zzeib) {
            this();
        }
    }

    public final String zzbev() {
        return this.zzijv;
    }

    /* access modifiers changed from: private */
    public final void zzhu(String str) {
        str.getClass();
        this.zzijv = str;
    }

    public final zzelq zzbew() {
        return this.zzijw;
    }

    /* access modifiers changed from: private */
    public final void zzaf(zzelq zzelq) {
        zzelq.getClass();
        this.zzijw = zzelq;
    }

    public final zza zzbex() {
        zza zzfr = zza.zzfr(this.zzijx);
        return zzfr == null ? zza.UNRECOGNIZED : zzfr;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        this.zzijx = zza2.zzv();
    }

    public static zzb zzbey() {
        return (zzb) zzijy.zzbjh();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeib.zzel[i - 1]) {
            case 1:
                return new zzeic();
            case 2:
                return new zzb((zzeib) null);
            case 3:
                return zza((zzeon) zzijy, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzijv", "zzijw", "zzijx"});
            case 4:
                return zzijy;
            case 5:
                zzeow<zzeic> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzeic.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzijy);
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

    public static zzeic zzbez() {
        return zzijy;
    }

    static {
        zzeic zzeic = new zzeic();
        zzijy = zzeic;
        zzena.zza(zzeic.class, zzeic);
    }
}
