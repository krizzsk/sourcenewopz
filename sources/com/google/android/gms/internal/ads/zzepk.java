package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepk {
    private static final Class<?> zzixl = zzbln();
    private static final zzeqa<?, ?> zzixm = zzbz(false);
    private static final zzeqa<?, ?> zzixn = zzbz(true);
    private static final zzeqa<?, ?> zzixo = new zzeqc();

    public static void zzk(Class<?> cls) {
        Class<?> cls2;
        if (!zzena.class.isAssignableFrom(cls) && (cls2 = zzixl) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzeqx zzeqx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzeqx zzeqx) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzelq> list, zzeqx zzeqx) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzeqx zzeqx, zzepi zzepi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zza(i, list, zzepi);
        }
    }

    public static void zzb(int i, List<?> list, zzeqx zzeqx, zzepi zzepi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeqx.zzb(i, list, zzepi);
        }
    }

    static int zzac(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeob) {
            zzeob zzeob = (zzeob) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfl(zzeob.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzemk.zzfl(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzac(list) + (list.size() * zzemk.zzhd(i));
    }

    static int zzad(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeob) {
            zzeob zzeob = (zzeob) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfm(zzeob.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzemk.zzfm(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zzemk.zzhd(i));
    }

    static int zzae(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeob) {
            zzeob zzeob = (zzeob) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfn(zzeob.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzemk.zzfn(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zzemk.zzhd(i));
    }

    static int zzaf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhj(zzend.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzemk.zzhj(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaf(list) + (size * zzemk.zzhd(i));
    }

    static int zzag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhe(zzend.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzemk.zzhe(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzag(list) + (size * zzemk.zzhd(i));
    }

    static int zzah(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhf(zzend.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzemk.zzhf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzah(list) + (size * zzemk.zzhd(i));
    }

    static int zzai(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhg(zzend.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzemk.zzhg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzai(list) + (size * zzemk.zzhd(i));
    }

    static int zzaj(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzemk.zzal(i, 0);
    }

    static int zzak(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzemk.zzo(i, 0);
    }

    static int zzal(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzemk.zzi(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzhd = zzemk.zzhd(i) * size;
        if (list instanceof zzenu) {
            zzenu zzenu = (zzenu) list;
            while (i4 < size) {
                Object zzhr = zzenu.zzhr(i4);
                if (zzhr instanceof zzelq) {
                    i3 = zzemk.zzaj((zzelq) zzhr);
                } else {
                    i3 = zzemk.zzib((String) zzhr);
                }
                zzhd += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzelq) {
                    i2 = zzemk.zzaj((zzelq) obj);
                } else {
                    i2 = zzemk.zzib((String) obj);
                }
                zzhd += i2;
                i4++;
            }
        }
        return zzhd;
    }

    static int zzc(int i, Object obj, zzepi zzepi) {
        if (obj instanceof zzens) {
            return zzemk.zza(i, (zzens) obj);
        }
        return zzemk.zzb(i, (zzeon) obj, zzepi);
    }

    static int zzc(int i, List<?> list, zzepi zzepi) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzhd = zzemk.zzhd(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzens) {
                i2 = zzemk.zza((zzens) obj);
            } else {
                i2 = zzemk.zza((zzeon) obj, zzepi);
            }
            zzhd += i2;
        }
        return zzhd;
    }

    static int zzd(int i, List<zzelq> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzhd = size * zzemk.zzhd(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzhd += zzemk.zzaj(list.get(i2));
        }
        return zzhd;
    }

    static int zzd(int i, List<zzeon> list, zzepi zzepi) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzemk.zzc(i, list.get(i3), zzepi);
        }
        return i2;
    }

    public static zzeqa<?, ?> zzblk() {
        return zzixm;
    }

    public static zzeqa<?, ?> zzbll() {
        return zzixn;
    }

    public static zzeqa<?, ?> zzblm() {
        return zzixo;
    }

    private static zzeqa<?, ?> zzbz(boolean z) {
        try {
            Class<?> zzblo = zzblo();
            if (zzblo == null) {
                return null;
            }
            return (zzeqa) zzblo.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbln() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzblo() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzeog zzeog, T t, T t2, long j) {
        zzeqg.zza((Object) t, j, zzeog.zzf(zzeqg.zzp(t, j), zzeqg.zzp(t2, j)));
    }

    static <T, FT extends zzemv<FT>> void zza(zzemp<FT> zzemp, T t, T t2) {
        zzemt<FT> zzai = zzemp.zzai(t2);
        if (!zzai.zziqs.isEmpty()) {
            zzemp.zzaj(t).zza(zzai);
        }
    }

    static <T, UT, UB> void zza(zzeqa<UT, UB> zzeqa, T t, T t2) {
        zzeqa.zzi(t, zzeqa.zzk(zzeqa.zzay(t), zzeqa.zzay(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzenh zzenh, UB ub, zzeqa<UT, UB> zzeqa) {
        if (zzenh == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzenh.zzi(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzeqa);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzenh.zzi(intValue2)) {
                    ub = zza(i, intValue2, ub, zzeqa);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzeqa<UT, UB> zzeqa) {
        if (ub == null) {
            ub = zzeqa.zzblx();
        }
        zzeqa.zza(ub, i, (long) i2);
        return ub;
    }
}
