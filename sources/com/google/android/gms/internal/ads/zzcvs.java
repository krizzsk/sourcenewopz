package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcvs implements Callable {
    private final zzebt zzfyy;
    private final zzebt zzgbc;
    private final zzcvp zzgxj;
    private final zzdpi zzgxo;
    private final zzdot zzgxp;
    private final JSONObject zzgxq;

    zzcvs(zzcvp zzcvp, zzebt zzebt, zzebt zzebt2, zzdpi zzdpi, zzdot zzdot, JSONObject jSONObject) {
        this.zzgxj = zzcvp;
        this.zzgbc = zzebt;
        this.zzfyy = zzebt2;
        this.zzgxo = zzdpi;
        this.zzgxp = zzdot;
        this.zzgxq = jSONObject;
    }

    public final Object call() {
        return this.zzgxj.zza(this.zzgbc, this.zzfyy, this.zzgxo, this.zzgxp, this.zzgxq);
    }
}
