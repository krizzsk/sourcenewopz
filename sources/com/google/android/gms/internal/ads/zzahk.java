package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzahk implements zzaig<Object> {
    private final zzahn zzdic;

    public zzahk(zzahn zzahn) {
        this.zzdic = zzahn;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzdic != null) {
            String str = map.get("name");
            if (str == null) {
                zzd.zzey("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzbh.zzh(new JSONObject(map.get("info")));
                } catch (JSONException e) {
                    zzd.zzc("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzd.zzex("Failed to convert ad metadata to Bundle.");
            } else {
                this.zzdic.zza(str, bundle);
            }
        }
    }
}
