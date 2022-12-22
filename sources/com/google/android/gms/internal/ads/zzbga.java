package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbga implements zzaig<zzbfi> {
    private final /* synthetic */ zzbfy zzewd;

    zzbga(zzbfy zzbfy) {
        this.zzewd = zzbfy;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzewd) {
                        if (this.zzewd.zzevs != parseInt) {
                            int unused = this.zzewd.zzevs = parseInt;
                            this.zzewd.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzd.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
