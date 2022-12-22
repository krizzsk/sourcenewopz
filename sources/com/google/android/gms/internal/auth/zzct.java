package com.google.android.gms.internal.auth;

import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzct extends zzcz<Long> {
    zzct(zzcx zzcx, String str, Long l, boolean z) {
        super(zzcx, str, l, true, (zzct) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 25 + str.length());
            sb.append("Invalid long value for ");
            sb.append(zzc);
            sb.append(": ");
            sb.append(str);
            SystemUtils.log(6, "PhenotypeFlag", sb.toString(), (Throwable) null, "com.google.android.gms.internal.auth.zzct", 2);
            return null;
        }
    }
}
