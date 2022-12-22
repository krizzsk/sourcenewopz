package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzur;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzz extends zzaa {
    public final zzur zza(Context context, TelephonyManager telephonyManager) {
        zzr.zzkv();
        if (zzj.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzur.ENUM_TRUE : zzur.ENUM_FALSE;
        }
        return zzur.ENUM_FALSE;
    }
}
