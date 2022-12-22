package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzabs {
    public static boolean zzcp(String str) {
        return zze((String) zzww.zzra().zzd(zzabq.zzcwy), str);
    }

    private static boolean zze(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzr.zzkz().zza(e, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
