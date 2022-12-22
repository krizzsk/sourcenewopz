package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeix extends zzena<zzeix, zza> implements zzeop {
    private static volatile zzeow<zzeix> zzek;
    /* access modifiers changed from: private */
    public static final zzeix zzilv;
    private String zzilt = "";
    private zzenk<zzeij> zzilu = zzbjm();

    private zzeix() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena.zzb<zzeix, zza> implements zzeop {
        private zza() {
            super(zzeix.zzilv);
        }

        /* synthetic */ zza(zzeiz zzeiz) {
            this();
        }
    }

    public final List<zzeij> zzbgh() {
        return this.zzilu;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeiz.zzel[i - 1]) {
            case 1:
                return new zzeix();
            case 2:
                return new zza((zzeiz) null);
            case 3:
                return zza((zzeon) zzilv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzilt", "zzilu", zzeij.class});
            case 4:
                return zzilv;
            case 5:
                zzeow<zzeix> zzeow = zzek;
                if (zzeow == null) {
                    synchronized (zzeix.class) {
                        zzeow = zzek;
                        if (zzeow == null) {
                            zzeow = new zzena.zza<>(zzilv);
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

    public static zzeix zzbgi() {
        return zzilv;
    }

    static {
        zzeix zzeix = new zzeix();
        zzilv = zzeix;
        zzena.zza(zzeix.class, zzeix);
    }
}
