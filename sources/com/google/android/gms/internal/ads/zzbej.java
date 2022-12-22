package com.google.android.gms.internal.ads;

import com.didi.soda.blocks.constant.Const;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbej implements Runnable {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ int zzert;
    private final /* synthetic */ int zzeru;
    private final /* synthetic */ boolean zzerv = false;
    private final /* synthetic */ zzbek zzerw;

    zzbej(zzbek zzbek, String str, String str2, int i, int i2, boolean z) {
        this.zzerw = zzbek;
        this.zzeik = str;
        this.zzers = str2;
        this.zzert = i;
        this.zzeru = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put(Const.BlockParamConst.SRC, this.zzeik);
        hashMap.put("cachedSrc", this.zzers);
        hashMap.put("bytesLoaded", Integer.toString(this.zzert));
        hashMap.put("totalBytes", Integer.toString(this.zzeru));
        hashMap.put("cacheReady", "0");
        this.zzerw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
