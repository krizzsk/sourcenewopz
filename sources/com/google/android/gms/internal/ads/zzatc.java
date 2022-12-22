package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzatc extends zzaza {
    private final /* synthetic */ QueryInfoGenerationCallback zzduw;

    zzatc(zzatd zzatd, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zzduw = queryInfoGenerationCallback;
    }

    public final void zzj(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzzy(str, (Bundle) null));
        zzww.zzre().put(queryInfo, str2);
        this.zzduw.onSuccess(queryInfo);
    }

    public final void onError(String str) {
        this.zzduw.onFailure(str);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzzy(str, bundle));
        zzww.zzre().put(queryInfo, str2);
        this.zzduw.onSuccess(queryInfo);
    }
}
