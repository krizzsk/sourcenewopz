package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdqh {
    public static zzvh zza(zzdqj zzdqj, zzvh zzvh) {
        if (zzdqj.equals(zzdqj.MEDIATION_SHOW_ERROR)) {
            if (((Integer) zzww.zzra().zzd(zzabq.zzday)).intValue() > 0) {
                return zzvh;
            }
        }
        return zza(zzdqj, (String) null, zzvh);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzvh zza(com.google.android.gms.internal.ads.zzdqj r6, java.lang.String r7, com.google.android.gms.internal.ads.zzvh r8) {
        /*
            if (r7 != 0) goto L_0x0046
            int[] r7 = com.google.android.gms.internal.ads.zzdqg.zzhou
            int r0 = r6.ordinal()
            r7 = r7[r0]
            java.lang.String r0 = "No fill."
            switch(r7) {
                case 1: goto L_0x0044;
                case 2: goto L_0x0041;
                case 3: goto L_0x003e;
                case 4: goto L_0x003b;
                case 5: goto L_0x0039;
                case 6: goto L_0x0036;
                case 7: goto L_0x0033;
                case 8: goto L_0x0030;
                case 9: goto L_0x002d;
                case 10: goto L_0x002a;
                case 11: goto L_0x000f;
                case 12: goto L_0x0015;
                case 13: goto L_0x000f;
                case 14: goto L_0x0012;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.String r7 = "Internal error."
            goto L_0x0046
        L_0x0012:
            java.lang.String r7 = "Mismatch request IDs."
            goto L_0x0046
        L_0x0015:
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r7 = com.google.android.gms.internal.ads.zzabq.zzdbc
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r7 = r1.zzd(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r7 > 0) goto L_0x0039
            java.lang.String r7 = "The mediation adapter did not return an ad."
            goto L_0x0046
        L_0x002a:
            java.lang.String r7 = "The ad can not be shown when app is not in foreground."
            goto L_0x0046
        L_0x002d:
            java.lang.String r7 = "The ad has already been shown."
            goto L_0x0046
        L_0x0030:
            java.lang.String r7 = "The ad is not ready."
            goto L_0x0046
        L_0x0033:
            java.lang.String r7 = "A mediation adapter failed to show the ad."
            goto L_0x0046
        L_0x0036:
            java.lang.String r7 = "App ID missing."
            goto L_0x0046
        L_0x0039:
            r7 = r0
            goto L_0x0046
        L_0x003b:
            java.lang.String r7 = "Network error."
            goto L_0x0046
        L_0x003e:
            java.lang.String r7 = "Invalid request: Invalid ad size."
            goto L_0x0046
        L_0x0041:
            java.lang.String r7 = "Invalid request: Invalid ad unit ID."
            goto L_0x0046
        L_0x0044:
            java.lang.String r7 = "Invalid request."
        L_0x0046:
            r2 = r7
            com.google.android.gms.internal.ads.zzvh r7 = new com.google.android.gms.internal.ads.zzvh
            int[] r0 = com.google.android.gms.internal.ads.zzdqg.zzhou
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 0
            r3 = 2
            r4 = 1
            r5 = 3
            switch(r0) {
                case 1: goto L_0x00a5;
                case 2: goto L_0x00a5;
                case 3: goto L_0x00a5;
                case 4: goto L_0x00a3;
                case 5: goto L_0x00a1;
                case 6: goto L_0x009c;
                case 7: goto L_0x0099;
                case 8: goto L_0x00a3;
                case 9: goto L_0x00a5;
                case 10: goto L_0x00a1;
                case 11: goto L_0x00a6;
                case 12: goto L_0x0082;
                case 13: goto L_0x00a6;
                case 14: goto L_0x007d;
                default: goto L_0x0058;
            }
        L_0x0058:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r8 = java.lang.String.valueOf(r6)
            int r8 = r8.length()
            int r8 = r8 + 18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            java.lang.String r8 = "Unknown SdkError: "
            r0.append(r8)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L_0x007d:
            r6 = 10
            r1 = 10
            goto L_0x00a6
        L_0x0082:
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r6 = com.google.android.gms.internal.ads.zzabq.zzdbc
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r6 = r0.zzd(r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r6 > 0) goto L_0x00a1
            r6 = 9
            r1 = 9
            goto L_0x00a6
        L_0x0099:
            r6 = 4
            r1 = 4
            goto L_0x00a6
        L_0x009c:
            r6 = 8
            r1 = 8
            goto L_0x00a6
        L_0x00a1:
            r1 = 3
            goto L_0x00a6
        L_0x00a3:
            r1 = 2
            goto L_0x00a6
        L_0x00a5:
            r1 = 1
        L_0x00a6:
            r5 = 0
            java.lang.String r3 = "com.google.android.gms.ads"
            r0 = r7
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqh.zza(com.google.android.gms.internal.ads.zzdqj, java.lang.String, com.google.android.gms.internal.ads.zzvh):com.google.android.gms.internal.ads.zzvh");
    }

    public static zzvh zzh(Throwable th) {
        if (th instanceof zzctd) {
            zzctd zzctd = (zzctd) th;
            return zza(zzctd.zzasc(), zzctd.zzasv());
        } else if (th instanceof zzcnp) {
            if (th.getMessage() == null) {
                return zza(((zzcnp) th).zzasc(), (String) null, (zzvh) null);
            }
            return zza(((zzcnp) th).zzasc(), th.getMessage(), (zzvh) null);
        } else if (!(th instanceof zzap)) {
            return zza(zzdqj.INTERNAL_ERROR, (String) null, (zzvh) null);
        } else {
            zzap zzap = (zzap) th;
            return new zzvh(zzap.getErrorCode(), zzdyq.zzhn(zzap.getMessage()), MobileAds.ERROR_DOMAIN, (zzvh) null, (IBinder) null);
        }
    }

    public static zzvh zza(Throwable th, zzctc zzctc) {
        zzvh zzh = zzh(th);
        if ((zzh.errorCode == 3 || zzh.errorCode == 0) && zzh.zzchu != null && !zzh.zzchu.zzcht.equals(MobileAds.ERROR_DOMAIN)) {
            zzh.zzchu = null;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue() && zzctc != null) {
            zzh.zzchv = zzctc.zzasu();
        }
        return zzh;
    }
}
