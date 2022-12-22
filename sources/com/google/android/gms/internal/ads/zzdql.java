package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdql implements zzesa<Clock> {
    private final zzdqi zzhpk;

    public zzdql(zzdqi zzdqi) {
        this.zzhpk = zzdqi;
    }

    public final /* synthetic */ Object get() {
        return (Clock) zzesg.zzbd(DefaultClock.getInstance());
    }
}
