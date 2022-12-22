package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzder implements zzdhb<Bundle> {
    private final String zzdwm;
    private final boolean zzdwo;

    public zzder(String str, boolean z) {
        this.zzdwm = str;
        this.zzdwo = z;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zzdwm);
        if (this.zzdwo) {
            bundle.putString(Constants.FILE_DART_ERROR_KEY, "1");
        }
    }
}
