package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzry implements Comparator<zzse> {
    zzry(zzrz zzrz) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzse zzse = (zzse) obj;
        zzse zzse2 = (zzse) obj2;
        int i = zzse.zzbuo - zzse2.zzbuo;
        if (i != 0) {
            return i;
        }
        return (int) (zzse.value - zzse2.value);
    }
}
