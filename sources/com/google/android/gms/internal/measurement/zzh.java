package com.google.android.gms.internal.measurement;

import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzh {
    public static void zza(String str, int i, List<zzap> list) {
        if (list.size() != i) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(list.size())}));
        }
    }

    public static void zzb(String str, int i, List<zzap> list) {
        if (list.size() < i) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(list.size())}));
        }
    }

    public static void zzc(String str, int i, List<zzap> list) {
        if (list.size() > i) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(list.size())}));
        }
    }

    public static boolean zzd(zzap zzap) {
        if (zzap == null) {
            return false;
        }
        Double zzd = zzap.zzd();
        if (zzd.isNaN() || zzd.doubleValue() < 0.0d || !zzd.equals(Double.valueOf(Math.floor(zzd.doubleValue())))) {
            return false;
        }
        return true;
    }

    public static zzbl zze(String str) {
        zzbl zzbl = null;
        if (str != null && !str.isEmpty()) {
            zzbl = zzbl.zza(Integer.parseInt(str));
        }
        if (zzbl != null) {
            return zzbl;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", new Object[]{str}));
    }

    public static boolean zzf(zzap zzap, zzap zzap2) {
        if (!zzap.getClass().equals(zzap2.getClass())) {
            return false;
        }
        if ((zzap instanceof zzau) || (zzap instanceof zzan)) {
            return true;
        }
        if (zzap instanceof zzah) {
            if (Double.isNaN(zzap.zzd().doubleValue()) || Double.isNaN(zzap2.zzd().doubleValue())) {
                return false;
            }
            return zzap.zzd().equals(zzap2.zzd());
        } else if (zzap instanceof zzat) {
            return zzap.zzc().equals(zzap2.zzc());
        } else {
            if (zzap instanceof zzaf) {
                return zzap.zze().equals(zzap2.zze());
            }
            if (zzap == zzap2) {
                return true;
            }
            return false;
        }
    }

    public static int zzg(double d) {
        int i;
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return 0;
        }
        return (int) ((long) ((((double) (i > 0 ? 1 : -1)) * Math.floor(Math.abs(d))) % 4.294967296E9d));
    }

    public static long zzh(double d) {
        return ((long) zzg(d)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    public static double zzi(double d) {
        int i;
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (Double.isInfinite(d) || d == 0.0d || i == 0) {
            return d;
        }
        return ((double) (i > 0 ? 1 : -1)) * Math.floor(Math.abs(d));
    }

    public static Object zzj(zzap zzap) {
        if (zzap.zzg.equals(zzap)) {
            return null;
        }
        if (zzap.zzf.equals(zzap)) {
            return "";
        }
        if (!zzap.zzd().isNaN()) {
            return zzap.zzd();
        }
        return zzap.zzc();
    }

    public static int zzk(zzg zzg) {
        int zzg2 = zzg(zzg.zzh("runtime.counter").zzd().doubleValue() + 1.0d);
        if (zzg2 <= 1000000) {
            zzg.zze("runtime.counter", new zzah(Double.valueOf((double) zzg2)));
            return zzg2;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }
}
