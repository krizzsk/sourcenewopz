package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzkv extends zzkw {
    public final long zzate;
    public final List<zzky> zzatf = new ArrayList();
    public final List<zzkv> zzatg = new ArrayList();

    public zzkv(int i, long j) {
        super(i);
        this.zzate = j;
    }

    public final void zza(zzky zzky) {
        this.zzatf.add(zzky);
    }

    public final void zza(zzkv zzkv) {
        this.zzatg.add(zzkv);
    }

    public final zzky zzas(int i) {
        int size = this.zzatf.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzky zzky = this.zzatf.get(i2);
            if (zzky.type == i) {
                return zzky;
            }
        }
        return null;
    }

    public final zzkv zzat(int i) {
        int size = this.zzatg.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkv zzkv = this.zzatg.get(i2);
            if (zzkv.type == i) {
                return zzkv;
            }
        }
        return null;
    }

    public final String toString() {
        String zzaw = zzaw(this.type);
        String arrays = Arrays.toString(this.zzatf.toArray());
        String arrays2 = Arrays.toString(this.zzatg.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzaw).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzaw);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
