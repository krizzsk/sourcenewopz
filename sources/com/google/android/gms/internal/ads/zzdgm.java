package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgm implements zzdhb<Bundle> {
    private final String zzecy;
    private final String zzhfv;
    private final String zzhfw;
    private final String zzhfx;
    private final Long zzhfy;

    public zzdgm(String str, String str2, String str3, String str4, Long l) {
        this.zzecy = str;
        this.zzhfv = str2;
        this.zzhfw = str3;
        this.zzhfx = str4;
        this.zzhfy = l;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdpw.zza(bundle, "gmp_app_id", this.zzecy);
        zzdpw.zza(bundle, "fbs_aiid", this.zzhfv);
        zzdpw.zza(bundle, "fbs_aeid", this.zzhfw);
        zzdpw.zza(bundle, "apm_id_origin", this.zzhfx);
        Long l = this.zzhfy;
        if (l != null) {
            bundle.putLong("sai_timeout", l.longValue());
        }
    }
}
