package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdev implements zzdhb<Bundle> {
    private final Boolean zzhfa;

    public zzdev(Boolean bool) {
        this.zzhfa = bool;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        Boolean bool = this.zzhfa;
        if (bool != null) {
            bundle.putBoolean("hw_accel", bool.booleanValue());
        }
    }
}
