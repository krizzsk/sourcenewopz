package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcw implements zzesa<zzdcu> {
    private final zzesn<Set<String>> zzhdt;

    private zzdcw(zzesn<Set<String>> zzesn) {
        this.zzhdt = zzesn;
    }

    public static zzdcw zzal(zzesn<Set<String>> zzesn) {
        return new zzdcw(zzesn);
    }

    public static zzdcu zzd(Set<String> set) {
        return new zzdcu(set);
    }

    public final /* synthetic */ Object get() {
        return zzd(this.zzhdt.get());
    }
}
