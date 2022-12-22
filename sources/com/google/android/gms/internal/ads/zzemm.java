package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzemm implements zzeqx {
    private final zzemk zziph;

    public static zzemm zza(zzemk zzemk) {
        if (zzemk.zziqg != null) {
            return zzemk.zziqg;
        }
        return new zzemm(zzemk);
    }

    private zzemm(zzemk zzemk) {
        zzemk zzemk2 = (zzemk) zzenc.zza(zzemk, "output");
        this.zziph = zzemk2;
        zzemk2.zziqg = this;
    }

    public final int zzbiu() {
        return zzeqw.zzjak;
    }

    public final void zzao(int i, int i2) throws IOException {
        this.zziph.zzah(i, i2);
    }

    public final void zzq(int i, long j) throws IOException {
        this.zziph.zzi(i, j);
    }

    public final void zzr(int i, long j) throws IOException {
        this.zziph.zzk(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zziph.zza(i, f);
    }

    public final void zzb(int i, double d) throws IOException {
        this.zziph.zzb(i, d);
    }

    public final void zzap(int i, int i2) throws IOException {
        this.zziph.zzae(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zziph.zzi(i, j);
    }

    public final void zzae(int i, int i2) throws IOException {
        this.zziph.zzae(i, i2);
    }

    public final void zzk(int i, long j) throws IOException {
        this.zziph.zzk(i, j);
    }

    public final void zzah(int i, int i2) throws IOException {
        this.zziph.zzah(i, i2);
    }

    public final void zzh(int i, boolean z) throws IOException {
        this.zziph.zzh(i, z);
    }

    public final void zzi(int i, String str) throws IOException {
        this.zziph.zzi(i, str);
    }

    public final void zza(int i, zzelq zzelq) throws IOException {
        this.zziph.zza(i, zzelq);
    }

    public final void zzaf(int i, int i2) throws IOException {
        this.zziph.zzaf(i, i2);
    }

    public final void zzag(int i, int i2) throws IOException {
        this.zziph.zzag(i, i2);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zziph.zzj(i, j);
    }

    public final void zza(int i, Object obj, zzepi zzepi) throws IOException {
        this.zziph.zza(i, (zzeon) obj, zzepi);
    }

    public final void zzb(int i, Object obj, zzepi zzepi) throws IOException {
        zzemk zzemk = this.zziph;
        zzemk.writeTag(i, 3);
        zzepi.zza((zzeon) obj, zzemk.zziqg);
        zzemk.writeTag(i, 4);
    }

    public final void zzhm(int i) throws IOException {
        this.zziph.writeTag(i, 3);
    }

    public final void zzhn(int i) throws IOException {
        this.zziph.writeTag(i, 4);
    }

    public final void zzc(int i, Object obj) throws IOException {
        if (obj instanceof zzelq) {
            this.zziph.zzb(i, (zzelq) obj);
        } else {
            this.zziph.zza(i, (zzeon) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhe(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzgz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhh(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzhc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzah(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfl(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfm(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfo(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzg(list.get(i4).floatValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzf(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzd(list.get(i4).doubleValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzc(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhj(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzgz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzbx(list.get(i4).booleanValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzbw(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzh(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzenu) {
            zzenu zzenu = (zzenu) list;
            while (i2 < list.size()) {
                Object zzhr = zzenu.zzhr(i2);
                if (zzhr instanceof String) {
                    this.zziph.zzi(i, (String) zzhr);
                } else {
                    this.zziph.zza(i, (zzelq) zzhr);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzi(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzelq> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zziph.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhf(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzha(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzaf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhi(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzhc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzah(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfp(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhg(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzhb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzag(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfn(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzepi zzepi) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzepi);
        }
    }

    public final void zzb(int i, List<?> list, zzepi zzepi) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzepi);
        }
    }

    public final <K, V> void zza(int i, zzeoe<K, V> zzeoe, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zziph.writeTag(i, 2);
            this.zziph.zzha(zzeof.zza(zzeoe, next.getKey(), next.getValue()));
            zzeof.zza(this.zziph, zzeoe, next.getKey(), next.getValue());
        }
    }
}
