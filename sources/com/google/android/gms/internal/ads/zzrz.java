package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzrz {
    private final int zzbuo;
    private final int zzbup;
    private final int zzbuq;
    private final zzrw zzbur = new zzsd();

    public zzrz(int i) {
        this.zzbup = i;
        this.zzbuo = 6;
        this.zzbuq = 0;
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            sb.append(((String) obj).toLowerCase(Locale.US));
            sb.append(10);
        }
        return zzbq(sb.toString());
    }

    private final String zzbq(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzsb zzsb = new zzsb();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbup, new zzry(this));
        for (String zze : split) {
            String[] zze2 = zzsa.zze(zze, false);
            if (zze2.length != 0) {
                zzsf.zza(zze2, this.zzbup, this.zzbuo, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzsb.write(this.zzbur.zzbp(((zzse) it.next()).zzbuv));
            } catch (IOException e) {
                zzd.zzc("Error while writing hash to byteStream", e);
            }
        }
        return zzsb.toString();
    }
}
