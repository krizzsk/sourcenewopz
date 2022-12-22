package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzahz implements zzaig<zzbfi> {
    zzahz() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zztq;
        zzbfi zzbfi = (zzbfi) obj;
        zzaeg zzaeq = zzbfi.zzaeq();
        if (zzaeq == null || (zztq = zzaeq.zztq()) == null) {
            zzbfi.zza("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzbfi.zza("nativeAdViewSignalsReady", zztq);
        }
    }
}
