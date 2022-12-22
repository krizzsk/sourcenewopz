package com.google.android.gms.internal.ads;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdek implements zzdhe<zzdel> {
    private final Context zzaai;
    private final zzebs zzgka;

    zzdek(Context context, zzebs zzebs) {
        this.zzaai = context;
        this.zzgka = zzebs;
    }

    public final zzebt<zzdel> zzatu() {
        return this.zzgka.zze(new zzdej(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdel zzaue() throws Exception {
        zzr.zzkv();
        String zzay = zzj.zzay(this.zzaai);
        String str = "";
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyo)).booleanValue()) {
            str = SystemUtils.getSharedPreferences(this.zzaai, "mobileads_consent", 0).getString("fc_consent", str);
        }
        zzr.zzkv();
        return new zzdel(zzay, str, zzj.zzaz(this.zzaai));
    }
}
