package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcvp implements zzcvm<zzcdf> {
    private final zzebs zzgka;
    private final zzccf zzgxk;
    private final zzcgb zzgxl;
    private final zzdqc<zzchu> zzgxm;

    public zzcvp(zzccf zzccf, zzebs zzebs, zzcgb zzcgb, zzdqc<zzchu> zzdqc) {
        this.zzgxk = zzccf;
        this.zzgka = zzebs;
        this.zzgxl = zzcgb;
        this.zzgxm = zzdqc;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (zzdot.zzhmh == null || zzdot.zzhmh.zzgem == null) ? false : true;
    }

    public final zzebt<List<zzebt<zzcdf>>> zzb(zzdpi zzdpi, zzdot zzdot) {
        return zzebh.zzb(zzebh.zzb(this.zzgxm.zzawl(), new zzcvo(this, zzdot), (Executor) this.zzgka), new zzcvr(this, zzdpi, zzdot), (Executor) this.zzgka);
    }

    private final zzebt<zzcdf> zzb(zzdpi zzdpi, zzdot zzdot, JSONObject jSONObject) {
        zzebt<zzchu> zzawl = this.zzgxm.zzawl();
        zzebt<zzcdr> zza = this.zzgxl.zza(zzdpi, zzdot, jSONObject);
        return zzebh.zzb((zzebt<? extends V>[]) new zzebt[]{zzawl, zza}).zzb(new zzcvs(this, zza, zzawl, zzdpi, zzdot, jSONObject), this.zzgka);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcdf zza(zzebt zzebt, zzebt zzebt2, zzdpi zzdpi, zzdot zzdot, JSONObject jSONObject) throws Exception {
        zzcdr zzcdr = (zzcdr) zzebt.get();
        zzchu zzchu = (zzchu) zzebt2.get();
        zzcdt zza = this.zzgxk.zza(new zzbps(zzdpi, zzdot, (String) null), new zzced(zzcdr), new zzcct(jSONObject, zzchu));
        zza.zzahp().zzaqi();
        zza.zzahq().zzb(zzchu);
        zza.zzahr().zzi(zzcdr.zzaot());
        return zza.zzaho();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzchu zzchu, JSONObject jSONObject) throws Exception {
        this.zzgxm.zzd(zzebh.zzag(zzchu));
        if (jSONObject.optBoolean("success")) {
            return zzebh.zzag(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzamh("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdpi zzdpi, zzdot zzdot, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzebh.immediateFailedFuture(new zzcnp(zzdqj.NO_FILL));
        }
        if (zzdpi.zzhns.zzfzg.zzhby <= 1) {
            return zzebh.zzb(zzb(zzdpi, zzdot, jSONArray.getJSONObject(0)), zzcvt.zzebv, (Executor) this.zzgka);
        }
        int length = jSONArray.length();
        this.zzgxm.ensureSize(Math.min(length, zzdpi.zzhns.zzfzg.zzhby));
        ArrayList arrayList = new ArrayList(zzdpi.zzhns.zzfzg.zzhby);
        for (int i = 0; i < zzdpi.zzhns.zzfzg.zzhby; i++) {
            if (i < length) {
                arrayList.add(zzb(zzdpi, zzdot, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzebh.immediateFailedFuture(new zzcnp(zzdqj.NO_FILL)));
            }
        }
        return zzebh.zzag(arrayList);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdot zzdot, zzchu zzchu) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbi)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzdot.zzhmh.zzgem);
        jSONObject2.put("sdk_params", jSONObject);
        return zzebh.zzb(zzchu.zzc("google.afma.nativeAds.preProcessJson", jSONObject2), new zzcvq(this, zzchu), (Executor) this.zzgka);
    }
}
