package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbov implements zzbtq, zzbuj {
    private final Context context;
    private final zzbar zzbpx;
    private final zzbfi zzdkm;
    private final zzdot zzeux;
    private IObjectWrapper zzfya;
    private boolean zzfyb;

    public zzbov(Context context2, zzbfi zzbfi, zzdot zzdot, zzbar zzbar) {
        this.context = context2;
        this.zzdkm = zzbfi;
        this.zzeux = zzdot;
        this.zzbpx = zzbar;
    }

    public final synchronized void onAdLoaded() {
        if (!this.zzfyb) {
            zzalh();
        }
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfyb) {
            zzalh();
        }
        if (!(!this.zzeux.zzdyg || this.zzfya == null || this.zzdkm == null)) {
            this.zzdkm.zza("onSdkImpression", (Map<String, ?>) new ArrayMap());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ea, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzalh() {
        /*
            r13 = this;
            monitor-enter(r13)
            com.google.android.gms.internal.ads.zzdot r0 = r13.zzeux     // Catch:{ all -> 0x00eb }
            boolean r0 = r0.zzdyg     // Catch:{ all -> 0x00eb }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r13)
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbfi r0 = r13.zzdkm     // Catch:{ all -> 0x00eb }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r13)
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzasb r0 = com.google.android.gms.ads.internal.zzr.zzlk()     // Catch:{ all -> 0x00eb }
            android.content.Context r1 = r13.context     // Catch:{ all -> 0x00eb }
            boolean r0 = r0.zzm(r1)     // Catch:{ all -> 0x00eb }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r13)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzbar r0 = r13.zzbpx     // Catch:{ all -> 0x00eb }
            int r0 = r0.zzeka     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzbar r1 = r13.zzbpx     // Catch:{ all -> 0x00eb }
            int r1 = r1.zzekb     // Catch:{ all -> 0x00eb }
            r2 = 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
            r3.<init>(r2)     // Catch:{ all -> 0x00eb }
            r3.append(r0)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = "."
            r3.append(r0)     // Catch:{ all -> 0x00eb }
            r3.append(r1)     // Catch:{ all -> 0x00eb }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzdot r0 = r13.zzeux     // Catch:{ all -> 0x00eb }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings r0 = r0.zzhms     // Catch:{ all -> 0x00eb }
            java.lang.String r9 = r0.getVideoEventsOwner()     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcwk     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x00eb }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00eb }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00eb }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00eb }
            r1 = 1
            if (r0 == 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzdot r0 = r13.zzeux     // Catch:{ all -> 0x00eb }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings r0 = r0.zzhms     // Catch:{ all -> 0x00eb }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType r0 = r0.getMediaType()     // Catch:{ all -> 0x00eb }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType r2 = com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType.VIDEO     // Catch:{ all -> 0x00eb }
            if (r0 != r2) goto L_0x0069
            com.google.android.gms.internal.ads.zzasc r0 = com.google.android.gms.internal.ads.zzasc.zzdsm     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzase r2 = com.google.android.gms.internal.ads.zzase.DEFINED_BY_JAVASCRIPT     // Catch:{ all -> 0x00eb }
        L_0x0066:
            r11 = r0
            r10 = r2
            goto L_0x0077
        L_0x0069:
            com.google.android.gms.internal.ads.zzasc r0 = com.google.android.gms.internal.ads.zzasc.HTML_DISPLAY     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzdot r2 = r13.zzeux     // Catch:{ all -> 0x00eb }
            int r2 = r2.zzhma     // Catch:{ all -> 0x00eb }
            if (r2 != r1) goto L_0x0074
            com.google.android.gms.internal.ads.zzase r2 = com.google.android.gms.internal.ads.zzase.ONE_PIXEL     // Catch:{ all -> 0x00eb }
            goto L_0x0066
        L_0x0074:
            com.google.android.gms.internal.ads.zzase r2 = com.google.android.gms.internal.ads.zzase.BEGIN_TO_RENDER     // Catch:{ all -> 0x00eb }
            goto L_0x0066
        L_0x0077:
            com.google.android.gms.internal.ads.zzasb r4 = com.google.android.gms.ads.internal.zzr.zzlk()     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzbfi r0 = r13.zzdkm     // Catch:{ all -> 0x00eb }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x00eb }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.internal.ads.zzdot r0 = r13.zzeux     // Catch:{ all -> 0x00eb }
            java.lang.String r12 = r0.zzcig     // Catch:{ all -> 0x00eb }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00eb }
            r13.zzfya = r0     // Catch:{ all -> 0x00eb }
            goto L_0x00a4
        L_0x0090:
            com.google.android.gms.internal.ads.zzasb r4 = com.google.android.gms.ads.internal.zzr.zzlk()     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzbfi r0 = r13.zzdkm     // Catch:{ all -> 0x00eb }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x00eb }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00eb }
            r13.zzfya = r0     // Catch:{ all -> 0x00eb }
        L_0x00a4:
            com.google.android.gms.internal.ads.zzbfi r0 = r13.zzdkm     // Catch:{ all -> 0x00eb }
            android.view.View r0 = r0.getView()     // Catch:{ all -> 0x00eb }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.zzfya     // Catch:{ all -> 0x00eb }
            if (r2 == 0) goto L_0x00e9
            if (r0 == 0) goto L_0x00e9
            com.google.android.gms.internal.ads.zzasb r2 = com.google.android.gms.ads.internal.zzr.zzlk()     // Catch:{ all -> 0x00eb }
            com.google.android.gms.dynamic.IObjectWrapper r3 = r13.zzfya     // Catch:{ all -> 0x00eb }
            r2.zza(r3, r0)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzbfi r0 = r13.zzdkm     // Catch:{ all -> 0x00eb }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.zzfya     // Catch:{ all -> 0x00eb }
            r0.zzar(r2)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzasb r0 = com.google.android.gms.ads.internal.zzr.zzlk()     // Catch:{ all -> 0x00eb }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.zzfya     // Catch:{ all -> 0x00eb }
            r0.zzac(r2)     // Catch:{ all -> 0x00eb }
            r13.zzfyb = r1     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcwn     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x00eb }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00eb }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00eb }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00eb }
            if (r0 == 0) goto L_0x00e9
            com.google.android.gms.internal.ads.zzbfi r0 = r13.zzdkm     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = "onSdkLoaded"
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00eb }
            r2.<init>()     // Catch:{ all -> 0x00eb }
            r0.zza((java.lang.String) r1, (java.util.Map<java.lang.String, ?>) r2)     // Catch:{ all -> 0x00eb }
        L_0x00e9:
            monitor-exit(r13)
            return
        L_0x00eb:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbov.zzalh():void");
    }
}
