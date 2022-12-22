package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.didi.soda.customer.app.constant.Const;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfq implements zzdhb<Bundle> {
    private final String zzhfi;

    /* access modifiers changed from: private */
    public static boolean zze(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains(Const.ComponentType.BANNER);
    }

    public zzdfq(String str) {
        this.zzhfi = str;
    }

    public final /* synthetic */ void zzr(Object obj) {
        zzdpw.zza((Bundle) obj, "omid_v", this.zzhfi);
    }
}
