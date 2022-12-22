package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgc implements zzdhb<Bundle> {
    private String zzdvx;
    private final String zzhfn;

    public zzdgc(String str, String str2) {
        this.zzdvx = str;
        this.zzhfn = str2;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczz)).booleanValue()) {
            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.zzhfn);
        } else {
            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.zzdvx);
        }
    }
}
