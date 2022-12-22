package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzaa extends zzx {
    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcvx)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvz)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzww.zzqw();
        int zze = zzbae.zze(activity, configuration.screenHeightDp);
        int zze2 = zzbae.zze(activity, configuration.screenWidthDp);
        zzr.zzkv();
        DisplayMetrics zza = zzj.zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) zzww.zzra().zzd(zzabq.zzcvw)).intValue();
        if (!(zze(i, zze + dimensionPixelSize, round) && zze(i2, zze2, round))) {
            return true;
        }
        return false;
    }

    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }
}
