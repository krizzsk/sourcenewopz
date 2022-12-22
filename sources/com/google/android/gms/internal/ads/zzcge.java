package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcge implements zzdxw {
    static final zzdxw zzebv = new zzcge();

    private zzcge() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzaee zzaee : (List) obj) {
            if (zzaee != null) {
                arrayList.add(zzaee);
            }
        }
        return arrayList;
    }
}
