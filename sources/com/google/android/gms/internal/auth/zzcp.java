package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzcp {
    static volatile zzde<Boolean> zza = zzde.zzc();
    private static final Object zzb = new Object();

    public static boolean zza(Context context, Uri uri) {
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            SystemUtils.log(6, "PhenotypeClientHelper", sb.toString(), (Throwable) null, "com.google.android.gms.internal.auth.zzcp", 3);
            return false;
        } else if (zza.zzb()) {
            return zza.zza().booleanValue();
        } else {
            synchronized (zzb) {
                if (zza.zzb()) {
                    boolean booleanValue = zza.zza().booleanValue();
                    return booleanValue;
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", Build.VERSION.SDK_INT < 29 ? 0 : 268435456);
                    if (resolveContentProvider != null) {
                        if (!"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        }
                    }
                    zza = zzde.zzd(Boolean.valueOf(z));
                    return zza.zza().booleanValue();
                }
                try {
                    if ((SystemUtils.getApplicationInfo(context.getPackageManager(), "com.google.android.gms", 0).flags & 129) != 0) {
                        z = true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                zza = zzde.zzd(Boolean.valueOf(z));
                return zza.zza().booleanValue();
            }
        }
    }
}
