package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzau {
    private final String[] zzeht;
    private final double[] zzehu;
    private final double[] zzehv;
    private final int[] zzehw;
    private int zzehx;

    private zzau(zzav zzav) {
        int size = zzav.zzehz.size();
        this.zzeht = (String[]) zzav.zzehy.toArray(new String[size]);
        this.zzehu = zzg(zzav.zzehz);
        this.zzehv = zzg(zzav.zzeia);
        this.zzehw = new int[size];
        this.zzehx = 0;
    }

    private static double[] zzg(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zzehx++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzehv;
            if (i < dArr.length) {
                if (dArr[i] <= d && d < this.zzehu[i]) {
                    int[] iArr = this.zzehw;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= this.zzehv[i]) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final List<zzaw> zzaag() {
        ArrayList arrayList = new ArrayList(this.zzeht.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzeht;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzehv[i];
            double d2 = this.zzehu[i];
            int[] iArr = this.zzehw;
            arrayList.add(new zzaw(str, d, d2, ((double) iArr[i]) / ((double) this.zzehx), iArr[i]));
            i++;
        }
    }
}
