package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfy implements zzdhb<Bundle> {
    private final Bundle zzgbd;

    public zzdfy(Bundle bundle) {
        this.zzgbd = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundle2 = this.zzgbd;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }
}
