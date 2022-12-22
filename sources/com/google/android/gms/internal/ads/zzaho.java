package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaho implements zzaig<zzbfi> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzd.zzez("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzd.zzez("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzr.zzlc().elapsedRealtime() + (Long.parseLong(str4) - zzr.zzlc().currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbfi.zzacb().zzb(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzd.zzd("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzd.zzez("No value given for CSI experiment.");
                return;
            }
            zzach zzsr = zzbfi.zzacb().zzsr();
            if (zzsr == null) {
                zzd.zzez("No ticker for WebView, dropping experiment ID.");
            } else {
                zzsr.zzg("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzd.zzez("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzd.zzez("No name given for CSI extra.");
            } else {
                zzach zzsr2 = zzbfi.zzacb().zzsr();
                if (zzsr2 == null) {
                    zzd.zzez("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzsr2.zzg(str6, str7);
                }
            }
        }
    }
}
