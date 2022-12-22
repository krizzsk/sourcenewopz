package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.internal.zzr;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcov {
    private final Context context;
    private final Executor executor;
    private final zzdpm zzfzg;
    private final zzbar zzgra;

    public zzcov(Context context2, zzbar zzbar, zzdpm zzdpm, Executor executor2) {
        this.context = context2;
        this.zzgra = zzbar;
        this.zzfzg = zzdpm;
        this.executor = executor2;
    }

    public final zzebt<zzdpi> zzasl() {
        zzamg<I, O> zza = zzr.zzli().zzb(this.context, this.zzgra).zza("google.afma.response.normalize", zzamn.zzdma, zzamn.zzdma);
        zzvf zzvf = this.zzfzg.zzhnx.zzcip;
        if (!zza(zzvf)) {
            return zzebh.immediateFailedFuture(new zzcwo(zzdqj.REQUEST_ID_MISMATCH, "Mismatch request IDs."));
        }
        return zzebh.zzb(zzebh.zzb(zzebh.zzb(zzebh.zzag(""), new zzcou(this, zzvf), this.executor), new zzcox(zza), this.executor), new zzcow(this), this.executor);
    }

    private static boolean zza(zzvf zzvf) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzczy)).booleanValue()) {
            return true;
        }
        if (zzvf == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzvf.zzchp);
            JSONObject jSONObject2 = new JSONObject(zzvf.zzchq);
            String optString = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
            String optString2 = jSONObject2.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
            return !TextUtils.isEmpty(optString2) && optString.equals(optString2);
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzp(JSONObject jSONObject) throws Exception {
        return zzebh.zzag(new zzdpi(new zzdpd(this.zzfzg), zzdpg.zza(new StringReader(jSONObject.toString()))));
    }
}
