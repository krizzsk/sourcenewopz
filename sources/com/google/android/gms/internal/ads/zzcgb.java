package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcgb {
    private final zzebs zzgka;
    private final zzcgf zzgkb;
    private final zzcgp zzgkc;

    public zzcgb(zzebs zzebs, zzcgf zzcgf, zzcgp zzcgp) {
        this.zzgka = zzebs;
        this.zzgkb = zzcgf;
        this.zzgkc = zzcgp;
    }

    public final zzebt<zzcdr> zza(zzdpi zzdpi, zzdot zzdot, JSONObject jSONObject) {
        zzebt zzb;
        JSONObject jSONObject2 = jSONObject;
        zzdpi zzdpi2 = zzdpi;
        zzebt zze = this.zzgka.zze(new zzcga(this, zzdpi, zzdot, jSONObject2));
        zzebt<List<zzaee>> zzd = this.zzgkb.zzd(jSONObject2, "images");
        zzebt<zzaee> zzc = this.zzgkb.zzc(jSONObject2, "secondary_image");
        zzebt<zzaee> zzc2 = this.zzgkb.zzc(jSONObject2, "app_icon");
        zzebt<zzaed> zze2 = this.zzgkb.zze(jSONObject2, "attribution");
        zzebt<zzbfi> zzn = this.zzgkb.zzn(jSONObject2);
        zzcgf zzcgf = this.zzgkb;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzb = zzebh.zzag(null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzb = zzebh.zzag(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzb = zzebh.zzag(null);
                } else {
                    zzb = zzebh.zzb(zzebh.zzag(null), new zzcgj(zzcgf, optString), (Executor) zzbat.zzeki);
                }
            }
        }
        zzebt zzebt = zzb;
        zzebt<List<zzcgq>> zzg = this.zzgkc.zzg(jSONObject2, "custom_assets");
        return zzebh.zza((zzebt<? extends V>[]) new zzebt[]{zze, zzd, zzc, zzc2, zze2, zzn, zzebt, zzg}).zzb(new zzcgd(this, zze, zzd, zzc2, zzc, zze2, jSONObject, zzn, zzebt, zzg), this.zzgka);
    }
}
