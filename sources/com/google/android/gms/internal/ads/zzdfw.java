package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.didiglobal.ddmirror.monitor.PrismConstants;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfw implements zzdhb<Bundle>, zzdhe<zzdhb<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdvo;

    zzdfw(ApplicationInfo applicationInfo2, PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo2;
        this.zzdvo = packageInfo;
    }

    public final zzebt<zzdhb<Bundle>> zzatu() {
        return zzebh.zzag(this);
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdvo;
        String str2 = null;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle.putString("pn", str);
        if (valueOf != null) {
            bundle.putInt(PrismConstants.Symbol.VIEW_CLASS, valueOf.intValue());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyc)).booleanValue()) {
            PackageInfo packageInfo2 = this.zzdvo;
            if (packageInfo2 != null) {
                str2 = packageInfo2.versionName;
            }
            if (str2 != null) {
                bundle.putString("vnm", str2);
            }
        }
    }
}
