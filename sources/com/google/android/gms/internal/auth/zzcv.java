package com.google.android.gms.internal.auth;

import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzcv extends zzcz<Double> {
    zzcv(zzcx zzcx, String str, Double d, boolean z) {
        super(zzcx, str, d, true, (zzct) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 27 + str.length());
            sb.append("Invalid double value for ");
            sb.append(zzc);
            sb.append(": ");
            sb.append(str);
            SystemUtils.log(6, "PhenotypeFlag", sb.toString(), (Throwable) null, "com.google.android.gms.internal.auth.zzcv", 2);
            return null;
        }
    }
}
