package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbar;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zze {
    private Context context;
    private long zzbpb = 0;

    public final void zza(Context context2, zzbar zzbar, String str, Runnable runnable) {
        zza(context2, zzbar, true, (zzazt) null, str, (String) null, runnable);
    }

    public final void zza(Context context2, zzbar zzbar, String str, zzazt zzazt) {
        zza(context2, zzbar, false, zzazt, zzazt != null ? zzazt.zzys() : null, str, (Runnable) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r11.zzyq() != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(android.content.Context r8, com.google.android.gms.internal.ads.zzbar r9, boolean r10, com.google.android.gms.internal.ads.zzazt r11, java.lang.String r12, java.lang.String r13, java.lang.Runnable r14) {
        /*
            r7 = this;
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r0 = r0.elapsedRealtime()
            long r2 = r7.zzbpb
            long r0 = r0 - r2
            r2 = 5000(0x1388, double:2.4703E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0017
            java.lang.String r8 = "Not retrying to fetch app settings"
            com.google.android.gms.ads.internal.util.zzd.zzez(r8)
            return
        L_0x0017:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r0 = r0.elapsedRealtime()
            r7.zzbpb = r0
            r0 = 0
            r1 = 1
            if (r11 != 0) goto L_0x0027
        L_0x0025:
            r0 = 1
            goto L_0x0054
        L_0x0027:
            long r2 = r11.zzyp()
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r2 = com.google.android.gms.internal.ads.zzabq.zzcup
            com.google.android.gms.internal.ads.zzabm r3 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            if (r2 != 0) goto L_0x0025
            boolean r11 = r11.zzyq()
            if (r11 != 0) goto L_0x0054
            goto L_0x0025
        L_0x0054:
            if (r0 != 0) goto L_0x0057
            return
        L_0x0057:
            if (r8 != 0) goto L_0x005f
            java.lang.String r8 = "Context not provided to fetch application settings"
            com.google.android.gms.ads.internal.util.zzd.zzez(r8)
            return
        L_0x005f:
            boolean r11 = android.text.TextUtils.isEmpty(r12)
            if (r11 == 0) goto L_0x0071
            boolean r11 = android.text.TextUtils.isEmpty(r13)
            if (r11 == 0) goto L_0x0071
            java.lang.String r8 = "App settings could not be fetched. Required parameters missing"
            com.google.android.gms.ads.internal.util.zzd.zzez(r8)
            return
        L_0x0071:
            android.content.Context r11 = r8.getApplicationContext()
            if (r11 == 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r11 = r8
        L_0x0079:
            r7.context = r11
            com.google.android.gms.internal.ads.zzamj r11 = com.google.android.gms.ads.internal.zzr.zzli()
            android.content.Context r0 = r7.context
            com.google.android.gms.internal.ads.zzamo r9 = r11.zzb(r0, r9)
            com.google.android.gms.internal.ads.zzamk<org.json.JSONObject> r11 = com.google.android.gms.internal.ads.zzamn.zzdma
            com.google.android.gms.internal.ads.zzamk<org.json.JSONObject> r0 = com.google.android.gms.internal.ads.zzamn.zzdma
            java.lang.String r1 = "google.afma.config.fetchAppSettings"
            com.google.android.gms.internal.ads.zzamg r9 = r9.zza(r1, r11, r0)
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d2 }
            r11.<init>()     // Catch:{ Exception -> 0x00d2 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x00d2 }
            if (r0 != 0) goto L_0x00a0
            java.lang.String r13 = "app_id"
            r11.put(r13, r12)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00ab
        L_0x00a0:
            boolean r12 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x00d2 }
            if (r12 != 0) goto L_0x00ab
            java.lang.String r12 = "ad_unit_id"
            r11.put(r12, r13)     // Catch:{ Exception -> 0x00d2 }
        L_0x00ab:
            java.lang.String r12 = "is_init"
            r11.put(r12, r10)     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r10 = "pn"
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x00d2 }
            r11.put(r10, r8)     // Catch:{ Exception -> 0x00d2 }
            com.google.android.gms.internal.ads.zzebt r8 = r9.zzh(r11)     // Catch:{ Exception -> 0x00d2 }
            com.google.android.gms.internal.ads.zzear r9 = com.google.android.gms.ads.internal.zzd.zzbpa     // Catch:{ Exception -> 0x00d2 }
            com.google.android.gms.internal.ads.zzebs r10 = com.google.android.gms.internal.ads.zzbat.zzekj     // Catch:{ Exception -> 0x00d2 }
            com.google.android.gms.internal.ads.zzebt r9 = com.google.android.gms.internal.ads.zzebh.zzb(r8, r9, (java.util.concurrent.Executor) r10)     // Catch:{ Exception -> 0x00d2 }
            if (r14 == 0) goto L_0x00cc
            com.google.android.gms.internal.ads.zzebs r10 = com.google.android.gms.internal.ads.zzbat.zzekj     // Catch:{ Exception -> 0x00d2 }
            r8.addListener(r14, r10)     // Catch:{ Exception -> 0x00d2 }
        L_0x00cc:
            java.lang.String r8 = "ConfigLoader.maybeFetchNewAppSettings"
            com.google.android.gms.internal.ads.zzbba.zza(r9, r8)     // Catch:{ Exception -> 0x00d2 }
            return
        L_0x00d2:
            r8 = move-exception
            java.lang.String r9 = "Error requesting application settings"
            com.google.android.gms.ads.internal.util.zzd.zzc(r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zze.zza(android.content.Context, com.google.android.gms.internal.ads.zzbar, boolean, com.google.android.gms.internal.ads.zzazt, java.lang.String, java.lang.String, java.lang.Runnable):void");
    }
}
