package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaxt implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zzaai;
    private final zzayd zzbrf;
    private final SharedPreferences zzech;
    private final zzf zzeci;
    private String zzecj = "";

    zzaxt(Context context, zzf zzf, zzayd zzayd) {
        this.zzech = SystemUtils.getDefaultSharedPreferences(context);
        this.zzeci = zzf;
        this.zzaai = context;
        this.zzbrf = zzayd;
    }

    /* access modifiers changed from: package-private */
    public final void zzxn() {
        this.zzech.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzech, "IABTCF_PurposeConsents");
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Context context;
        if ("IABTCF_PurposeConsents".equals(str)) {
            String string = sharedPreferences.getString("IABTCF_PurposeConsents", "");
            if (!string.isEmpty() && !this.zzecj.equals(string)) {
                this.zzecj = string;
                boolean z = false;
                if (string.charAt(0) != '1') {
                    z = true;
                }
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpg)).booleanValue()) {
                    this.zzeci.zzau(z);
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && z && (context = this.zzaai) != null) {
                        context.deleteDatabase("OfflineUpload.db");
                    }
                }
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpc)).booleanValue()) {
                    this.zzbrf.isInitialized();
                }
            }
        }
    }
}
