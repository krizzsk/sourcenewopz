package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzebt;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzb {
    public static void zzam(Context context) {
        if (zzbai.zzbv(context) && !zzbai.zzaat()) {
            zzebt<?> zzyx = new zze(context).zzyx();
            zzd.zzey("Updating ad debug logging enablement.");
            zzbba.zza(zzyx, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
