package com.google.android.gms.internal.ads;

import com.didi.soda.blocks.constant.Const;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbel implements Runnable {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ int zzert;
    private final /* synthetic */ int zzeru;
    private final /* synthetic */ boolean zzerv;
    private final /* synthetic */ zzbek zzerw;
    private final /* synthetic */ long zzery;
    private final /* synthetic */ long zzerz;
    private final /* synthetic */ int zzesa;
    private final /* synthetic */ int zzesb;

    zzbel(zzbek zzbek, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.zzerw = zzbek;
        this.zzeik = str;
        this.zzers = str2;
        this.zzert = i;
        this.zzeru = i2;
        this.zzery = j;
        this.zzerz = j2;
        this.zzerv = z;
        this.zzesa = i3;
        this.zzesb = i4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put(Const.BlockParamConst.SRC, this.zzeik);
        hashMap.put("cachedSrc", this.zzers);
        hashMap.put("bytesLoaded", Integer.toString(this.zzert));
        hashMap.put("totalBytes", Integer.toString(this.zzeru));
        hashMap.put("bufferedDuration", Long.toString(this.zzery));
        hashMap.put("totalDuration", Long.toString(this.zzerz));
        hashMap.put("cacheReady", this.zzerv ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzesa));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzesb));
        this.zzerw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
