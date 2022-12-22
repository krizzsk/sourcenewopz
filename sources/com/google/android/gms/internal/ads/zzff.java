package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzff {
    static zzecq zzzu;

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean zzb(com.google.android.gms.internal.ads.zzfc r8) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            com.google.android.gms.internal.ads.zzecq r0 = zzzu
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            com.google.android.gms.internal.ads.zzabf<java.lang.String> r0 = com.google.android.gms.internal.ads.zzabq.zzcsz
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.String r0 = (java.lang.String) r0
            r2 = 0
            if (r0 == 0) goto L_0x001b
            int r3 = r0.length()
            if (r3 != 0) goto L_0x0036
        L_0x001b:
            r0 = 0
            if (r8 != 0) goto L_0x001f
            goto L_0x0033
        L_0x001f:
            java.lang.String r3 = "4ioREl2wGHUH3L1Ffod4L799Wcu9qX0THPnnrMniz0uOTIixizwJO+JKyjfP+vUT"
            java.lang.String r4 = "/fmVllZVlSra7BEtwv3jJDV2EycO3hpoom0fb/ewpTo="
            java.lang.reflect.Method r8 = r8.zza((java.lang.String) r3, (java.lang.String) r4)
            if (r8 != 0) goto L_0x002a
            goto L_0x0033
        L_0x002a:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Object r8 = r8.invoke(r0, r3)
            java.lang.String r8 = (java.lang.String) r8
            r0 = r8
        L_0x0033:
            if (r0 != 0) goto L_0x0036
            return r2
        L_0x0036:
            byte[] r8 = com.google.android.gms.internal.ads.zzcy.zzb(r0, r1)     // Catch:{ IllegalArgumentException -> 0x011d }
            com.google.android.gms.internal.ads.zzecz r8 = com.google.android.gms.internal.ads.zzedd.zzl(r8)     // Catch:{  }
            com.google.android.gms.internal.ads.zzeix r0 = com.google.android.gms.internal.ads.zzefb.zzifu     // Catch:{  }
            java.util.List r0 = r0.zzbgh()     // Catch:{  }
            java.util.Iterator r0 = r0.iterator()     // Catch:{  }
        L_0x0048:
            boolean r3 = r0.hasNext()     // Catch:{  }
            if (r3 == 0) goto L_0x0114
            java.lang.Object r3 = r0.next()     // Catch:{  }
            com.google.android.gms.internal.ads.zzeij r3 = (com.google.android.gms.internal.ads.zzeij) r3     // Catch:{  }
            java.lang.String r4 = r3.zzbev()     // Catch:{  }
            boolean r4 = r4.isEmpty()     // Catch:{  }
            if (r4 != 0) goto L_0x010c
            java.lang.String r4 = r3.zzbfd()     // Catch:{  }
            boolean r4 = r4.isEmpty()     // Catch:{  }
            if (r4 != 0) goto L_0x0104
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            boolean r4 = r4.isEmpty()     // Catch:{  }
            if (r4 != 0) goto L_0x00fc
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            java.lang.String r5 = "TinkAead"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            java.lang.String r5 = "TinkMac"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            java.lang.String r5 = "TinkHybridDecrypt"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            java.lang.String r5 = "TinkHybridEncrypt"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            java.lang.String r5 = "TinkPublicKeySign"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            java.lang.String r5 = "TinkPublicKeyVerify"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            java.lang.String r5 = "TinkStreamingAead"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            java.lang.String r5 = "TinkDeterministicAead"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 == 0) goto L_0x00d4
            goto L_0x0048
        L_0x00d4:
            java.lang.String r4 = r3.zzbfg()     // Catch:{  }
            com.google.android.gms.internal.ads.zzecm r4 = com.google.android.gms.internal.ads.zzedl.zzhs(r4)     // Catch:{  }
            com.google.android.gms.internal.ads.zzedg r5 = r4.zzbbg()     // Catch:{  }
            com.google.android.gms.internal.ads.zzedl.zza(r5)     // Catch:{  }
            java.lang.String r5 = r3.zzbev()     // Catch:{  }
            java.lang.String r6 = r3.zzbfd()     // Catch:{  }
            int r7 = r3.zzbfe()     // Catch:{  }
            com.google.android.gms.internal.ads.zzect r4 = r4.zzb(r5, r6, r7)     // Catch:{  }
            boolean r3 = r3.zzbff()     // Catch:{  }
            com.google.android.gms.internal.ads.zzedl.zza(r4, (boolean) r3)     // Catch:{  }
            goto L_0x0048
        L_0x00fc:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing catalogue_name."
            r8.<init>(r0)     // Catch:{  }
            throw r8     // Catch:{  }
        L_0x0104:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing primitive_name."
            r8.<init>(r0)     // Catch:{  }
            throw r8     // Catch:{  }
        L_0x010c:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing type_url."
            r8.<init>(r0)     // Catch:{  }
            throw r8     // Catch:{  }
        L_0x0114:
            com.google.android.gms.internal.ads.zzecq r8 = com.google.android.gms.internal.ads.zzeff.zza(r8)     // Catch:{  }
            zzzu = r8     // Catch:{  }
            if (r8 == 0) goto L_0x011d
            return r1
        L_0x011d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzff.zzb(com.google.android.gms.internal.ads.zzfc):boolean");
    }
}
