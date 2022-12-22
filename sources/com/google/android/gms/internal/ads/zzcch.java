package com.google.android.gms.internal.ads;

import com.didi.soda.customer.app.constant.Const;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcch implements zzesa<Set<String>> {
    private final zzesn<zzcdy> zzfxe;

    public zzcch(zzesn<zzcdy> zzesn) {
        this.zzfxe = zzesn;
    }

    public static Set<String> zza(zzcdy zzcdy) {
        Set set;
        if (zzcdy.zzapg() != null) {
            set = Collections.singleton(Const.ComponentType.BANNER);
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzesg.zzbd(set);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfxe.get());
    }
}
