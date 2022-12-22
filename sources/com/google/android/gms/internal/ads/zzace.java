package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzace {
    private final Map<String, zzacf> zzdcf = new HashMap();
    private final zzach zzdcg;

    public zzace(zzach zzach) {
        this.zzdcg = zzach;
    }

    public final void zza(String str, zzacf zzacf) {
        this.zzdcf.put(str, zzacf);
    }

    public final void zzb(String str, String str2, long j) {
        zzacf zzacf;
        zzach zzach = this.zzdcg;
        zzacf zzacf2 = this.zzdcf.get(str2);
        String[] strArr = {str};
        if (!(zzach == null || zzacf2 == null)) {
            zzach.zza(zzacf2, j, strArr);
        }
        Map<String, zzacf> map = this.zzdcf;
        zzach zzach2 = this.zzdcg;
        if (zzach2 == null) {
            zzacf = null;
        } else {
            zzacf = zzach2.zzex(j);
        }
        map.put(str, zzacf);
    }

    public final zzach zzsr() {
        return this.zzdcg;
    }
}
