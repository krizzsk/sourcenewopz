package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbum extends zzbxq<AdMetadataListener> implements zzahn {
    private Bundle zzgbt = new Bundle();

    public zzbum(Set<zzbzl<AdMetadataListener>> set) {
        super(set);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzgbt.putAll(bundle);
        zza(zzbul.zzgbn);
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzgbt);
    }
}
