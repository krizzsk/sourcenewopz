package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzaj implements zzi {
    private final Application zza;
    private final zzal zzb;
    private final Executor zzc;

    public zzaj(Application application, zzal zzal, Executor executor) {
        this.zza = application;
        this.zzb = zzal;
        this.zzc = executor;
    }

    public final Executor zza() {
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r14, org.json.JSONObject r15) {
        /*
            r13 = this;
            int r0 = r14.hashCode()
            r1 = 94746189(0x5a5b64d, float:1.5583492E-35)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 113399775(0x6c257df, float:7.3103804E-35)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "write"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0025
            r14 = 0
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "clear"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0025
            r14 = 1
            goto L_0x0026
        L_0x0025:
            r14 = -1
        L_0x0026:
            if (r14 == 0) goto L_0x00a2
            if (r14 == r3) goto L_0x002b
            return r2
        L_0x002b:
            java.lang.String r14 = "keys"
            org.json.JSONArray r14 = r15.optJSONArray(r14)
            if (r14 == 0) goto L_0x007a
            int r0 = r14.length()
            if (r0 != 0) goto L_0x003a
            goto L_0x007a
        L_0x003a:
            java.util.HashSet r15 = new java.util.HashSet
            r15.<init>()
            int r0 = r14.length()
        L_0x0043:
            if (r2 >= r0) goto L_0x0074
            java.lang.String r1 = r14.optString(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x006e
            r1 = 46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = "Action[clear]: empty key at index: "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r7 = r4.toString()
            r5 = 3
            r8 = 0
            r10 = 37
            java.lang.String r6 = "UserMessagingPlatform"
            java.lang.String r9 = "com.google.android.gms.internal.consent_sdk.zzaj"
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
            goto L_0x0071
        L_0x006e:
            r15.add(r1)
        L_0x0071:
            int r2 = r2 + 1
            goto L_0x0043
        L_0x0074:
            android.app.Application r14 = r13.zza
            com.google.android.gms.internal.consent_sdk.zzcc.zza((android.content.Context) r14, (java.util.Set<java.lang.String>) r15)
            goto L_0x00a1
        L_0x007a:
            java.lang.String r14 = "Action[clear]: wrong args."
            java.lang.String r15 = r15.toString()
            java.lang.String r15 = java.lang.String.valueOf(r15)
            int r0 = r15.length()
            if (r0 == 0) goto L_0x0090
            java.lang.String r14 = r14.concat(r15)
            r6 = r14
            goto L_0x0096
        L_0x0090:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r14)
            r6 = r15
        L_0x0096:
            r4 = 3
            r7 = 0
            r9 = 29
            java.lang.String r5 = "UserMessagingPlatform"
            java.lang.String r8 = "com.google.android.gms.internal.consent_sdk.zzaj"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x00a1:
            return r3
        L_0x00a2:
            com.google.android.gms.internal.consent_sdk.zzce r14 = new com.google.android.gms.internal.consent_sdk.zzce
            android.app.Application r0 = r13.zza
            r14.<init>(r0)
            java.util.Iterator r0 = r15.keys()
        L_0x00ad:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x012b
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r15.opt(r1)
            java.lang.String r4 = java.lang.String.valueOf(r2)
            java.lang.String r5 = java.lang.String.valueOf(r1)
            int r5 = r5.length()
            int r5 = r5 + 23
            java.lang.String r6 = java.lang.String.valueOf(r4)
            int r6 = r6.length()
            int r5 = r5 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Writing to storage: ["
            r6.append(r5)
            r6.append(r1)
            java.lang.String r5 = "] "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r9 = r6.toString()
            r7 = 3
            r10 = 0
            r12 = 15
            java.lang.String r8 = "UserMessagingPlatform"
            java.lang.String r11 = "com.google.android.gms.internal.consent_sdk.zzaj"
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
            boolean r2 = r14.zza((java.lang.String) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0108
            com.google.android.gms.internal.consent_sdk.zzal r2 = r13.zzb
            java.util.Set r2 = r2.zzd()
            r2.add(r1)
            goto L_0x00ad
        L_0x0108:
            java.lang.String r2 = "Failed writing key: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L_0x0119
            java.lang.String r1 = r2.concat(r1)
            goto L_0x011e
        L_0x0119:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x011e:
            r6 = r1
            r4 = 3
            r7 = 0
            r9 = 20
            java.lang.String r5 = "UserMessagingPlatform"
            java.lang.String r8 = "com.google.android.gms.internal.consent_sdk.zzaj"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            goto L_0x00ad
        L_0x012b:
            com.google.android.gms.internal.consent_sdk.zzal r15 = r13.zzb
            r15.zze()
            r14.zza()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzaj.zza(java.lang.String, org.json.JSONObject):boolean");
    }
}
