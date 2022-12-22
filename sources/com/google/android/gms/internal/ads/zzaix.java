package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaix implements zzaig<Object> {
    private final zzaiw zzdjt;

    public static void zza(zzbfi zzbfi, zzaiw zzaiw) {
        zzbfi.zza("/reward", (zzaig<? super zzbfi>) new zzaix(zzaiw));
    }

    private zzaix(zzaiw zzaiw) {
        this.zzdjt = zzaiw;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzavy zzavy = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzavy = new zzavy(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzd.zzd("Unable to parse reward amount.", e);
            }
            this.zzdjt.zza(zzavy);
        } else if ("video_start".equals(str)) {
            this.zzdjt.zzul();
        } else if ("video_complete".equals(str)) {
            this.zzdjt.zzum();
        }
    }
}
