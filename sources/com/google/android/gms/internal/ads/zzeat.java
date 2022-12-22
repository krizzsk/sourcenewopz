package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeat<V> extends zzeau<V, List<V>> {
    zzeat(zzdyv<? extends zzebt<? extends V>> zzdyv, boolean z) {
        super(zzdyv, true);
        zzbav();
    }

    public final /* synthetic */ Object zzl(List list) {
        ArrayList zzfb = zzdzi.zzfb(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzeaw zzeaw = (zzeaw) it.next();
            zzfb.add(zzeaw != null ? zzeaw.value : null);
        }
        return Collections.unmodifiableList(zzfb);
    }
}
