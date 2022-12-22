package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class MediationConfiguration {
    private final Bundle zzewv;
    private final AdFormat zzewz;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.zzewz = adFormat;
        this.zzewv = bundle;
    }

    public AdFormat getFormat() {
        return this.zzewz;
    }

    public Bundle getServerParameters() {
        return this.zzewv;
    }
}
