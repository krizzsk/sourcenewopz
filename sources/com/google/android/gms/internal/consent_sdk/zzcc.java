package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzcc {
    public static zzcb zza(Context context, String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("/", -1);
        if (split.length == 1) {
            str3 = String.valueOf(context.getPackageName()).concat("_preferences");
            str2 = split[0];
        } else {
            if (split.length == 2) {
                str3 = split[0];
                str2 = split[1];
            }
            return null;
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            return new zzcb(str3, str2);
        }
        return null;
    }

    public static void zza(Context context, Set<String> set) {
        zzce zzce = new zzce(context);
        for (String next : set) {
            zzcb zza = zza(context, next);
            if (zza == null) {
                String valueOf = String.valueOf(next);
                SystemUtils.log(3, "UserMessagingPlatform", valueOf.length() != 0 ? "clearKeys: unable to process key: ".concat(valueOf) : new String("clearKeys: unable to process key: "), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzcc", 21);
            } else {
                zzce.zza(zza.zza).remove(zza.zzb);
            }
        }
        zzce.zza();
    }
}
