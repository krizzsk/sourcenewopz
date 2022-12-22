package com.google.android.gms.internal.ads;

import com.didi.soda.blocks.constant.Const;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzben implements Runnable {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ zzbek zzerw;
    private final /* synthetic */ long zzerz;

    zzben(zzbek zzbek, String str, String str2, long j) {
        this.zzerw = zzbek;
        this.zzeik = str;
        this.zzers = str2;
        this.zzerz = j;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put(Const.BlockParamConst.SRC, this.zzeik);
        hashMap.put("cachedSrc", this.zzers);
        hashMap.put("totalDuration", Long.toString(this.zzerz));
        this.zzerw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
