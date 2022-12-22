package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.raven.config.RavenKey;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdue {
    private final Context context;
    private final String packageName;
    private final String zzbrz;

    public zzdue(Context context2, zzbar zzbar) {
        this.context = context2;
        this.packageName = context2.getPackageName();
        this.zzbrz = zzbar.zzbrz;
    }

    public final void zzq(Map<String, String> map) {
        map.put(RavenKey.STACK, "gmob_sdk");
        map.put(RavenKey.VERSION, "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzr.zzkv();
        map.put("device", zzj.zzzs());
        map.put("app", this.packageName);
        zzr.zzkv();
        map.put("is_lite_sdk", zzj.zzax(this.context) ? "1" : "0");
        List<String> zzsj = zzabq.zzsj();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczx)).booleanValue()) {
            zzsj.addAll(zzr.zzkz().zzyl().zzzg().zznm());
        }
        map.put("e", TextUtils.join(",", zzsj));
        map.put("sdkVersion", this.zzbrz);
    }
}
