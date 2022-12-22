package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbmz extends zzbpc {
    private final Context context;
    private final zzbfi zzdkm;
    private final int zzfvw;
    private final zzbme zzfwl;
    private final zzcbr zzfwq;
    private boolean zzfwr = false;

    zzbmz(zzbpf zzbpf, Context context2, zzbfi zzbfi, int i, zzbme zzbme, zzcbr zzcbr) {
        super(zzbpf);
        this.zzdkm = zzbfi;
        this.context = context2;
        this.zzfvw = i;
        this.zzfwl = zzbme;
        this.zzfwq = zzcbr;
    }

    public final void zza(zzsi zzsi) {
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi != null) {
            zzbfi.zza(zzsi);
        }
    }

    /* JADX WARNING: type inference failed for: r6v4, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070 A[SYNTHETIC, Splitter:B:17:0x0070] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.app.Activity r6, com.google.android.gms.internal.ads.zzsw r7, boolean r8) throws android.os.RemoteException {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0004
            android.content.Context r6 = r5.context
        L_0x0004:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcpj
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x005f
            com.google.android.gms.ads.internal.zzr.zzkv()
            boolean r0 = com.google.android.gms.ads.internal.util.zzj.zzat(r6)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)
            com.google.android.gms.internal.ads.zzdqj r0 = com.google.android.gms.internal.ads.zzdqj.APP_NOT_FOREGROUND
            r3 = 0
            com.google.android.gms.internal.ads.zzvh r0 = com.google.android.gms.internal.ads.zzdqh.zza(r0, r3, r3)
            r7.zzb(r0)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcpk
            com.google.android.gms.internal.ads.zzabm r3 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzdvj r0 = new com.google.android.gms.internal.ads.zzdvj
            android.content.Context r3 = r6.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbl r4 = com.google.android.gms.ads.internal.zzr.zzlj()
            android.os.Looper r4 = r4.zzaai()
            r0.<init>(r3, r4)
            com.google.android.gms.internal.ads.zzdpi r3 = r5.zzftl
            com.google.android.gms.internal.ads.zzdpg r3 = r3.zzhnt
            com.google.android.gms.internal.ads.zzdoy r3 = r3.zzeuy
            java.lang.String r3 = r3.zzbwe
            r0.zzhg(r3)
            goto L_0x006d
        L_0x005f:
            boolean r0 = r5.zzfwr
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = "App open interstitial ad is already visible."
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)
        L_0x0068:
            boolean r0 = r5.zzfwr
            if (r0 != 0) goto L_0x006d
            r2 = 1
        L_0x006d:
            if (r2 != 0) goto L_0x0070
            return
        L_0x0070:
            com.google.android.gms.internal.ads.zzcbr r0 = r5.zzfwq     // Catch:{ zzcbq -> 0x0078 }
            r0.zza(r8, r6)     // Catch:{ zzcbq -> 0x0078 }
            r5.zzfwr = r1
            return
        L_0x0078:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzvh r6 = com.google.android.gms.internal.ads.zzdqh.zzh(r6)
            r7.zzb(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmz.zza(android.app.Activity, com.google.android.gms.internal.ads.zzsw, boolean):void");
    }

    public final int zzakb() {
        return this.zzfvw;
    }

    public final void zzb(long j, int i) {
        this.zzfwl.zzb(j, i);
    }

    public final void destroy() {
        super.destroy();
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi != null) {
            zzbfi.destroy();
        }
    }
}
