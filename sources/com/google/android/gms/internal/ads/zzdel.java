package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdel implements zzdhb<Bundle> {
    private final String zzdxc;
    private final String zzhev;
    private final Bundle zzhew;

    private zzdel(String str, String str2, Bundle bundle) {
        this.zzdxc = str;
        this.zzhev = str2;
        this.zzhew = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.zzdxc);
        bundle.putString("fc_consent", this.zzhev);
        bundle.putBundle("iab_consent_info", this.zzhew);
    }
}
