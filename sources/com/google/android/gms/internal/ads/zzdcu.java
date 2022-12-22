package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdcu implements zzdhe<zzdhb<Bundle>> {
    private final Set<String> zzhdr;

    zzdcu(Set<String> set) {
        this.zzhdr = set;
    }

    public final zzebt<zzdhb<Bundle>> zzatu() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zzhdr) {
            arrayList.add(add);
        }
        return zzebh.zzag(new zzdct(arrayList));
    }
}
