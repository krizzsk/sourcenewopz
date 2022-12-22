package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.koushikdutta.async.http.AsyncHttpHead;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzauv extends zzaux {
    private final Object lock = new Object();
    private final Context zzaai;
    private SharedPreferences zzeak;
    private final zzamg<JSONObject, JSONObject> zzeal;

    public zzauv(Context context, zzamg<JSONObject, JSONObject> zzamg) {
        this.zzaai = context.getApplicationContext();
        this.zzeal = zzamg;
    }

    public final zzebt<Void> zzxe() {
        synchronized (this.lock) {
            if (this.zzeak == null) {
                this.zzeak = SystemUtils.getSharedPreferences(this.zzaai, "google_ads_flags_meta", 0);
            }
        }
        if (zzr.zzlc().currentTimeMillis() - this.zzeak.getLong("js_last_update", 0) < zzadn.zzdfg.get().longValue()) {
            return zzebh.zzag(null);
        }
        return zzebh.zzb(this.zzeal.zzh(zzw(this.zzaai)), new zzauu(this), (Executor) zzbat.zzekj);
    }

    public static JSONObject zzw(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbar.zzaau().zzbrz);
            jSONObject.put("mf", zzadn.zzdff.get());
            jSONObject.put("cl", "360757573");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", AsyncHttpHead.METHOD);
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzf(JSONObject jSONObject) {
        zzabq.zza(this.zzaai, 1, jSONObject);
        this.zzeak.edit().putLong("js_last_update", zzr.zzlc().currentTimeMillis()).apply();
        return null;
    }
}
