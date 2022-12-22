package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzdyh {
    /* access modifiers changed from: private */
    public final int limit;
    /* access modifiers changed from: private */
    public final zzdxr zzhzb;
    private final boolean zzhzc;
    private final zzdyo zzhzd;

    private zzdyh(zzdyo zzdyo) {
        this(zzdyo, false, zzdxv.zzhyv, Integer.MAX_VALUE);
    }

    private zzdyh(zzdyo zzdyo, boolean z, zzdxr zzdxr, int i) {
        this.zzhzd = zzdyo;
        this.zzhzc = false;
        this.zzhzb = zzdxr;
        this.limit = Integer.MAX_VALUE;
    }

    public static zzdyh zza(zzdxr zzdxr) {
        zzdyi.checkNotNull(zzdxr);
        return new zzdyh(new zzdyk(zzdxr));
    }

    public final Iterable<String> zza(CharSequence charSequence) {
        zzdyi.checkNotNull(charSequence);
        return new zzdym(this, charSequence);
    }

    /* access modifiers changed from: private */
    public final Iterator<String> zzb(CharSequence charSequence) {
        return this.zzhzd.zzb(this, charSequence);
    }

    public final List<String> zzc(CharSequence charSequence) {
        zzdyi.checkNotNull(charSequence);
        Iterator<String> zzb = zzb(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzb.hasNext()) {
            arrayList.add(zzb.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
