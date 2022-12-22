package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.didi.soda.blocks.constant.Const;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbeq implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ zzbek zzerw;
    private final /* synthetic */ String zzesf;

    zzbeq(zzbek zzbek, String str, String str2, String str3, String str4) {
        this.zzerw = zzbek;
        this.zzeik = str;
        this.zzers = str2;
        this.zzesf = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put(Const.BlockParamConst.SRC, this.zzeik);
        if (!TextUtils.isEmpty(this.zzers)) {
            hashMap.put("cachedSrc", this.zzers);
        }
        hashMap.put("type", zzbek.zzfj(this.zzesf));
        hashMap.put("reason", this.zzesf);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzerw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
