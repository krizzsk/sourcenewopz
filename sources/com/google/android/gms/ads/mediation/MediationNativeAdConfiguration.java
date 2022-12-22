package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.internal.ads.zzaei;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class MediationNativeAdConfiguration extends MediationAdConfiguration {
    private final zzaei zzdpr;

    public MediationNativeAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2, String str3, zzaei zzaei) {
        super(context, str, bundle, bundle2, z, location, i, i2, str2, str3);
        this.zzdpr = zzaei;
    }

    public NativeAdOptions getNativeAdOptions() {
        return zzaei.zzb(this.zzdpr);
    }
}
