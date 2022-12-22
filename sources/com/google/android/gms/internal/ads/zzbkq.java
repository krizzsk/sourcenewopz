package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbkq implements zzbkn {
    private final Context context;
    private final zzf zzeci = zzr.zzkz().zzyl();

    public zzbkq(Context context2) {
        this.context = context2;
    }

    public final void zzm(Map<String, String> map) {
        Context context2;
        if (!map.isEmpty()) {
            String str = map.get("gad_idless");
            if (str != null) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                map.remove("gad_idless");
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpg)).booleanValue()) {
                    this.zzeci.zzau(parseBoolean);
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && parseBoolean && (context2 = this.context) != null) {
                        context2.deleteDatabase("OfflineUpload.db");
                    }
                }
            }
            Bundle bundle = new Bundle();
            for (Map.Entry next : map.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcpc)).booleanValue()) {
                zzr.zzlt().setConsent(bundle);
            }
        }
    }
}
