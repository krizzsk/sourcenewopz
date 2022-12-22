package com.google.android.gms.internal.ads;

import com.didi.soda.blocks.constant.Const;
import com.google.android.gms.ads.internal.zzr;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbem implements Runnable {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ boolean zzerv;
    private final /* synthetic */ zzbek zzerw;
    private final /* synthetic */ long zzery;
    private final /* synthetic */ long zzerz;
    private final /* synthetic */ int zzesa;
    private final /* synthetic */ int zzesb;
    private final /* synthetic */ long zzesc;
    private final /* synthetic */ long zzesd;
    private final /* synthetic */ long zzese;

    zzbem(zzbek zzbek, String str, String str2, long j, long j2, long j3, long j4, long j5, boolean z, int i, int i2) {
        this.zzerw = zzbek;
        this.zzeik = str;
        this.zzers = str2;
        this.zzery = j;
        this.zzerz = j2;
        this.zzesc = j3;
        this.zzesd = j4;
        this.zzese = j5;
        this.zzerv = z;
        this.zzesa = i;
        this.zzesb = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put(Const.BlockParamConst.SRC, this.zzeik);
        hashMap.put("cachedSrc", this.zzers);
        hashMap.put("bufferedDuration", Long.toString(this.zzery));
        hashMap.put("totalDuration", Long.toString(this.zzerz));
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue()) {
            hashMap.put("qoeLoadedBytes", Long.toString(this.zzesc));
            hashMap.put("qoeCachedBytes", Long.toString(this.zzesd));
            hashMap.put("totalBytes", Long.toString(this.zzese));
            hashMap.put("reportTime", Long.toString(zzr.zzlc().currentTimeMillis()));
        }
        hashMap.put("cacheReady", this.zzerv ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzesa));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzesb));
        this.zzerw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
