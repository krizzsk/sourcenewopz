package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzatd;
import com.google.android.gms.internal.ads.zzzl;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class QueryInfo {
    private final zzzy zzhva;

    public QueryInfo(zzzy zzzy) {
        this.zzhva = zzzy;
    }

    public String getQuery() {
        return this.zzhva.getQuery();
    }

    public Bundle getQueryBundle() {
        return this.zzhva.getQueryBundle();
    }

    public String getRequestId() {
        return zzzy.zza(this);
    }

    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzzl zzzl;
        if (adRequest == null) {
            zzzl = null;
        } else {
            zzzl = adRequest.zzdt();
        }
        new zzatd(context, adFormat, zzzl).zza(queryInfoGenerationCallback);
    }
}
