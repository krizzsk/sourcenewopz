package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzaa {
    private final zzz zza;
    private final zzby zzb;
    private int zzc = 0;
    private int zzd = 0;

    zzaa(zzz zzz, zzby zzby) {
        this.zza = zzz;
        this.zzb = zzby;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.consent_sdk.zzy zza() throws com.google.android.gms.internal.consent_sdk.zzk {
        /*
            r12 = this;
            int[] r0 = com.google.android.gms.internal.consent_sdk.zzx.zza
            com.google.android.gms.internal.consent_sdk.zzby r1 = r12.zzb
            int r1 = r1.zza
            r2 = 1
            int r1 = r1 - r2
            r0 = r0[r1]
            r1 = 2
            r3 = 0
            r4 = 3
            switch(r0) {
                case 1: goto L_0x006e;
                case 2: goto L_0x0069;
                case 3: goto L_0x0064;
                case 4: goto L_0x005f;
                case 5: goto L_0x005a;
                case 6: goto L_0x0039;
                case 7: goto L_0x0018;
                default: goto L_0x0010;
            }
        L_0x0010:
            com.google.android.gms.internal.consent_sdk.zzk r0 = new com.google.android.gms.internal.consent_sdk.zzk
            java.lang.String r1 = "Invalid response from server."
            r0.<init>(r2, r1)
            throw r0
        L_0x0018:
            com.google.android.gms.internal.consent_sdk.zzk r0 = new com.google.android.gms.internal.consent_sdk.zzk
            java.lang.String r1 = "Publisher misconfiguration: "
            com.google.android.gms.internal.consent_sdk.zzby r2 = r12.zzb
            java.lang.String r2 = r2.zzd
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x002f
            java.lang.String r1 = r1.concat(r2)
            goto L_0x0035
        L_0x002f:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x0035:
            r0.<init>(r4, r1)
            throw r0
        L_0x0039:
            com.google.android.gms.internal.consent_sdk.zzk r0 = new com.google.android.gms.internal.consent_sdk.zzk
            java.lang.String r1 = "Invalid response from server: "
            com.google.android.gms.internal.consent_sdk.zzby r3 = r12.zzb
            java.lang.String r3 = r3.zzd
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x0050
            java.lang.String r1 = r1.concat(r3)
            goto L_0x0056
        L_0x0050:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r1)
            r1 = r3
        L_0x0056:
            r0.<init>(r2, r1)
            throw r0
        L_0x005a:
            r12.zzc = r4
            r12.zzd = r3
            goto L_0x0072
        L_0x005f:
            r12.zzc = r4
            r12.zzd = r2
            goto L_0x0072
        L_0x0064:
            r12.zzc = r4
            r12.zzd = r1
            goto L_0x0072
        L_0x0069:
            r12.zzc = r1
            r12.zzd = r3
            goto L_0x0072
        L_0x006e:
            r12.zzc = r2
            r12.zzd = r3
        L_0x0072:
            com.google.android.gms.internal.consent_sdk.zzby r0 = r12.zzb
            java.lang.String r0 = r0.zzb
            r5 = 0
            if (r0 != 0) goto L_0x007b
            r6 = r5
            goto L_0x0084
        L_0x007b:
            com.google.android.gms.internal.consent_sdk.zzbb r6 = new com.google.android.gms.internal.consent_sdk.zzbb
            com.google.android.gms.internal.consent_sdk.zzby r7 = r12.zzb
            java.lang.String r7 = r7.zzc
            r6.<init>(r7, r0)
        L_0x0084:
            com.google.android.gms.internal.consent_sdk.zzz r0 = r12.zza
            com.google.android.gms.internal.consent_sdk.zzal r0 = r0.zzc
            java.util.HashSet r7 = new java.util.HashSet
            com.google.android.gms.internal.consent_sdk.zzby r8 = r12.zzb
            java.util.List<java.lang.String> r8 = r8.zze
            r7.<init>(r8)
            r0.zza((java.util.Set<java.lang.String>) r7)
            com.google.android.gms.internal.consent_sdk.zzby r0 = r12.zzb
            java.util.List<com.google.android.gms.internal.consent_sdk.zzbx> r0 = r0.zzf
            java.util.Iterator r0 = r0.iterator()
        L_0x009e:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x00d7
            java.lang.Object r7 = r0.next()
            com.google.android.gms.internal.consent_sdk.zzbx r7 = (com.google.android.gms.internal.consent_sdk.zzbx) r7
            int[] r8 = com.google.android.gms.internal.consent_sdk.zzx.zzb
            int r9 = r7.zza
            int r9 = r9 - r2
            r8 = r8[r9]
            if (r8 == r2) goto L_0x00be
            if (r8 == r1) goto L_0x00bb
            if (r8 == r4) goto L_0x00b8
            goto L_0x00be
        L_0x00b8:
            java.lang.String r8 = "clear"
            goto L_0x00bf
        L_0x00bb:
            java.lang.String r8 = "write"
            goto L_0x00bf
        L_0x00be:
            r8 = r5
        L_0x00bf:
            if (r8 == 0) goto L_0x009e
            com.google.android.gms.internal.consent_sdk.zzz r9 = r12.zza
            com.google.android.gms.internal.consent_sdk.zze r9 = r9.zza
            java.lang.String r7 = r7.zzb
            com.google.android.gms.internal.consent_sdk.zzi[] r10 = new com.google.android.gms.internal.consent_sdk.zzi[r2]
            com.google.android.gms.internal.consent_sdk.zzz r11 = r12.zza
            com.google.android.gms.internal.consent_sdk.zzaj r11 = r11.zzb
            r10[r3] = r11
            r9.zza(r8, r7, r10)
            goto L_0x009e
        L_0x00d7:
            com.google.android.gms.internal.consent_sdk.zzy r0 = new com.google.android.gms.internal.consent_sdk.zzy
            int r1 = r12.zzc
            int r2 = r12.zzd
            r0.<init>(r1, r2, r6, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzaa.zza():com.google.android.gms.internal.consent_sdk.zzy");
    }
}
