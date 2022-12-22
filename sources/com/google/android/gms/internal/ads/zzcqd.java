package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcqd implements Callable {
    private final zzebt zzfyy;
    private final zzebt zzgbc;
    private final zzebt zzgkr;

    zzcqd(zzebt zzebt, zzebt zzebt2, zzebt zzebt3) {
        this.zzgkr = zzebt;
        this.zzgbc = zzebt2;
        this.zzfyy = zzebt3;
    }

    public final Object call() {
        return new zzcqp((zzcqs) this.zzgkr.get(), (JSONObject) this.zzgbc.get(), (zzaup) this.zzfyy.get());
    }
}
