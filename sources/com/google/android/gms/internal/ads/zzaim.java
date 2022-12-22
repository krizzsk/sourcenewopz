package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaim implements zzaig<Object> {
    private final Context context;

    public zzaim(Context context2) {
        this.context = context2;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzr.zzlt().zzaa(this.context)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            if (c == 0) {
                zzr.zzlt().zzg(this.context, str2);
            } else if (c == 1) {
                zzr.zzlt().zzh(this.context, str2);
            } else if (c != 2) {
                zzd.zzex("logScionEvent gmsg contained unsupported eventName");
            } else {
                zzr.zzlt().zzj(this.context, str2);
            }
        }
    }
}
