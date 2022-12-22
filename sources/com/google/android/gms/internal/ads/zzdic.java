package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdic implements zzdhe<zzdhz> {
    private final Context context;
    private final String packageName;
    private final zzebs zzgka;
    private final zzaum zzhhg;

    public zzdic(zzaum zzaum, Context context2, String str, zzebs zzebs) {
        this.zzhhg = zzaum;
        this.context = context2;
        this.packageName = str;
        this.zzgka = zzebs;
    }

    public final zzebt<zzdhz> zzatu() {
        return this.zzgka.zze(new zzdib(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdhz zzaus() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzaum zzaum = this.zzhhg;
        if (zzaum != null) {
            zzaum.zza(this.context, this.packageName, jSONObject);
        }
        return new zzdhz(jSONObject);
    }
}
