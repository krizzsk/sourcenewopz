package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcaj extends zzbpc {
    private final Context context;
    private final zzcbr zzfwq;
    private boolean zzfwr = false;
    private final WeakReference<zzbfi> zzgdl;
    private final zzbyz zzgdm;
    private final zzbpz zzgdn;
    private final zzdvj zzgdo;
    private final zzbtb zzgdp;

    zzcaj(zzbpf zzbpf, Context context2, @Nullable zzbfi zzbfi, zzbyz zzbyz, zzcbr zzcbr, zzbpz zzbpz, zzdvj zzdvj, zzbtb zzbtb) {
        super(zzbpf);
        this.context = context2;
        this.zzgdl = new WeakReference<>(zzbfi);
        this.zzgdm = zzbyz;
        this.zzfwq = zzcbr;
        this.zzgdn = zzbpz;
        this.zzgdo = zzdvj;
        this.zzgdp = zzbtb;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(boolean r5, @javax.annotation.Nullable android.app.Activity r6) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcpj
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0049
            com.google.android.gms.ads.internal.zzr.zzkv()
            android.content.Context r0 = r4.context
            boolean r0 = com.google.android.gms.ads.internal.util.zzj.zzat(r0)
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)
            com.google.android.gms.internal.ads.zzbtb r0 = r4.zzgdp
            r0.zzamj()
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcpk
            com.google.android.gms.internal.ads.zzabm r3 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzdvj r0 = r4.zzgdo
            com.google.android.gms.internal.ads.zzdpi r3 = r4.zzftl
            com.google.android.gms.internal.ads.zzdpg r3 = r3.zzhnt
            com.google.android.gms.internal.ads.zzdoy r3 = r3.zzeuy
            java.lang.String r3 = r3.zzbwe
            r0.zzhg(r3)
            goto L_0x004f
        L_0x0049:
            boolean r0 = r4.zzfwr
            if (r0 != 0) goto L_0x004f
            r0 = 1
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 != 0) goto L_0x0053
            return r2
        L_0x0053:
            com.google.android.gms.internal.ads.zzbyz r0 = r4.zzgdm
            r0.zzalz()
            if (r6 != 0) goto L_0x005c
            android.content.Context r6 = r4.context
        L_0x005c:
            com.google.android.gms.internal.ads.zzcbr r0 = r4.zzfwq     // Catch:{ zzcbq -> 0x0069 }
            r0.zza(r5, r6)     // Catch:{ zzcbq -> 0x0069 }
            com.google.android.gms.internal.ads.zzbyz r5 = r4.zzgdm     // Catch:{ zzcbq -> 0x0069 }
            r5.zzalx()     // Catch:{ zzcbq -> 0x0069 }
            r4.zzfwr = r1
            return r1
        L_0x0069:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbtb r6 = r4.zzgdp
            r6.zza(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcaj.zzb(boolean, android.app.Activity):boolean");
    }

    public final boolean isClosed() {
        return this.zzgdn.isClosed();
    }

    public final void finalize() throws Throwable {
        try {
            zzbfi zzbfi = (zzbfi) this.zzgdl.get();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzczr)).booleanValue()) {
                if (!this.zzfwr && zzbfi != null) {
                    zzebs zzebs = zzbat.zzeki;
                    zzbfi.getClass();
                    zzebs.execute(zzcai.zze(zzbfi));
                }
            } else if (zzbfi != null) {
                zzbfi.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
