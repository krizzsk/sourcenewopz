package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzels implements Comparator<zzelq> {
    zzels() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzelq zzelq = (zzelq) obj;
        zzelq zzelq2 = (zzelq) obj2;
        zzelv zzelv = (zzelv) zzelq.iterator();
        zzelv zzelv2 = (zzelv) zzelq2.iterator();
        while (zzelv.hasNext() && zzelv2.hasNext()) {
            int compare = Integer.compare(zzelq.zzb(zzelv.nextByte()), zzelq.zzb(zzelv2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzelq.size(), zzelq2.size());
    }
}
