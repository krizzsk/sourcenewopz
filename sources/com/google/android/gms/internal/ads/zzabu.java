package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.didi.raven.config.RavenKey;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzabu {
    private Context context = null;
    private String zzbrz = null;
    private String zzdbu;
    private Map<String, String> zzdbv;

    public zzabu(Context context2, String str) {
        String str2;
        this.context = context2;
        this.zzbrz = str;
        this.zzdbu = zzadg.zzdec.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzdbv = linkedHashMap;
        linkedHashMap.put(RavenKey.STACK, "gmob_sdk");
        this.zzdbv.put(RavenKey.VERSION, "3");
        this.zzdbv.put("os", Build.VERSION.RELEASE);
        this.zzdbv.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzdbv;
        zzr.zzkv();
        map.put("device", zzj.zzzs());
        Map<String, String> map2 = this.zzdbv;
        if (context2.getApplicationContext() != null) {
            str2 = context2.getApplicationContext().getPackageName();
        } else {
            str2 = context2.getPackageName();
        }
        map2.put("app", str2);
        Map<String, String> map3 = this.zzdbv;
        zzr.zzkv();
        map3.put("is_lite_sdk", zzj.zzax(context2) ? "1" : "0");
        Future<zzauo> zzr = zzr.zzlg().zzr(this.context);
        try {
            this.zzdbv.put("network_coarse", Integer.toString(zzr.get().zzdzl));
            this.zzdbv.put("network_fine", Integer.toString(zzr.get().zzdzm));
        } catch (Exception e) {
            zzr.zzkz().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzsm() {
        return this.zzdbu;
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: package-private */
    public final String zzma() {
        return this.zzbrz;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzsn() {
        return this.zzdbv;
    }
}
