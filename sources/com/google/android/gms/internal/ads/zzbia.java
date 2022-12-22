package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbia implements zzesa<zzaux> {
    private final zzesn<Context> zzeyq;

    public zzbia(zzesn<Context> zzesn) {
        this.zzeyq = zzesn;
    }

    public final /* synthetic */ Object get() {
        Context context = this.zzeyq.get();
        return (zzaux) zzesg.zzbd(new zzauv(context, new zzauy(context).zzwv()));
    }
}
