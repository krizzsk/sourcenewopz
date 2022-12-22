package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdgx implements zzdhb {
    private final Bundle zzecv;

    zzdgx(Bundle bundle) {
        this.zzecv = bundle;
    }

    public final void zzr(Object obj) {
        ((Bundle) obj).putBundle("shared_pref", this.zzecv);
    }
}
