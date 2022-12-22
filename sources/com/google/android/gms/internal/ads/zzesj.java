package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzesj<T> implements zzesa<Set<T>> {
    private static final zzesa<Set<Object>> zzjff = zzesd.zzbb(Collections.emptySet());
    private final List<zzesn<T>> zzjfg;
    private final List<zzesn<Collection<T>>> zzjfh;

    public static <T> zzesl<T> zzau(int i, int i2) {
        return new zzesl<>(i, i2);
    }

    private zzesj(List<zzesn<T>> list, List<zzesn<Collection<T>>> list2) {
        this.zzjfg = list;
        this.zzjfh = list2;
    }

    public final /* synthetic */ Object get() {
        int size = this.zzjfg.size();
        ArrayList arrayList = new ArrayList(this.zzjfh.size());
        int size2 = this.zzjfh.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) this.zzjfh.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zzim = zzerz.zzim(size);
        int size3 = this.zzjfg.size();
        for (int i2 = 0; i2 < size3; i2++) {
            zzim.add(zzesg.checkNotNull(this.zzjfg.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object checkNotNull : (Collection) arrayList.get(i3)) {
                zzim.add(zzesg.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(zzim);
    }
}
