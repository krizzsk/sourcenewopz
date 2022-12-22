package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzacf {
    private final long time;
    private final String zzdch;
    private final zzacf zzdci;

    public zzacf(long j, String str, zzacf zzacf) {
        this.time = j;
        this.zzdch = str;
        this.zzdci = zzacf;
    }

    public final long getTime() {
        return this.time;
    }

    public final String zzss() {
        return this.zzdch;
    }

    public final zzacf zzst() {
        return this.zzdci;
    }
}
