package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcew implements zzaig {
    private final zzcev zzgiw;

    zzcew(zzcev zzcev) {
        this.zzgiw = zzcev;
    }

    public final void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        zzbfi.zzaef().zza((zzbgt) new zzcfb(this.zzgiw, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbfi.loadData(str, "text/html", "UTF-8");
        } else {
            zzbfi.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
