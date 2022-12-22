package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcv implements zzdhb<Bundle> {
    private final Bundle zzhds;

    private zzdcv(Bundle bundle) {
        this.zzhds = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.zzhds.isEmpty()) {
            bundle.putBundle("installed_adapter_data", this.zzhds);
        }
    }
}
