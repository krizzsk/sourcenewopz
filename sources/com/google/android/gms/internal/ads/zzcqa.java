package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcqa implements Callable {
    private final zzebt zzgbc;
    private final zzebt zzgkr;

    zzcqa(zzebt zzebt, zzebt zzebt2) {
        this.zzgkr = zzebt;
        this.zzgbc = zzebt2;
    }

    public final Object call() {
        return new zzcqt((JSONObject) this.zzgkr.get(), (zzaup) this.zzgbc.get());
    }
}
