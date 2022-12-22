package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbsp extends zzzb {
    private final List<zzvx> zzaed;
    private final String zzgbh;
    private final String zzgbi;

    public zzbsp(zzdot zzdot, String str, zzctc zzctc) {
        String str2;
        String str3 = null;
        if (zzdot == null) {
            str2 = null;
        } else {
            str2 = zzdot.zzgbi;
        }
        this.zzgbi = str2;
        str3 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzb(zzdot) : str3;
        this.zzgbh = str3 != null ? str3 : str;
        this.zzaed = zzctc.getAdapterResponses();
    }

    public final String getMediationAdapterClassName() {
        return this.zzgbh;
    }

    public final String getResponseId() {
        return this.zzgbi;
    }

    private static String zzb(zzdot zzdot) {
        try {
            return zzdot.zzhmk.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    public final List<zzvx> getAdapterResponses() {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
            return null;
        }
        return this.zzaed;
    }
}
