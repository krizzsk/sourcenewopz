package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.exifinterface.media.ExifInterface;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdvo implements zzdvr {
    private static final zzcf.zza zzhwh = ((zzcf.zza) ((zzena) zzcf.zza.zzap().zzae(ExifInterface.LONGITUDE_EAST).zzbjv()));

    zzdvo() {
    }

    public final zzcf.zza zzco(Context context) throws PackageManager.NameNotFoundException {
        return zzdvf.zzj(context, context.getPackageName(), Integer.toString(SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode));
    }

    public final zzcf.zza zzayy() {
        return zzhwh;
    }
}
