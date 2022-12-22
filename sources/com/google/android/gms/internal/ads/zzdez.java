package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdez implements zzdhb<Bundle> {
    private final Bundle zzdwl;

    public zzdez(Bundle bundle) {
        this.zzdwl = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdpw.zza(bundle, "device");
        zza.putBundle("android_mem_info", this.zzdwl);
        bundle.putBundle("device", zza);
    }
}
