package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzds implements zzdy {
    private static zzds zzvs;
    private final Context context;
    private final zzdwp zzvt;
    private final zzdwu zzvu;
    private final zzdwz zzvv;
    private final zzex zzvw;
    /* access modifiers changed from: private */
    public final zzduv zzvx;
    private final Executor zzvy;
    private final zzgp zzvz;
    private final zzdwv zzwa;
    private volatile long zzwb = 0;
    /* access modifiers changed from: private */
    public final Object zzwc = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzwd;

    public static synchronized zzds zza(String str, Context context2, boolean z) {
        zzds zzds;
        synchronized (zzds.class) {
            if (zzvs == null) {
                zzduz zzayn = zzduz.zzayq().zzhf(str).zzbt(z).zzayn();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzds zza = zza(context2, zzduv.zza(context2, newCachedThreadPool), zzayn, (Executor) newCachedThreadPool);
                zzvs = zza;
                zza.zzbr();
                zzvs.zzbu();
            }
            zzds = zzvs;
        }
        return zzds;
    }

    public final void zza(int i, int i2, int i3) {
    }

    static zzds zza(Context context2, zzduv zzduv, zzduz zzduz) {
        return zza(context2, zzduv, zzduz, (Executor) Executors.newCachedThreadPool());
    }

    private static zzds zza(Context context2, zzduv zzduv, zzduz zzduz, Executor executor) {
        zzdvl zza = zzdvl.zza(context2, executor, zzduv, zzduz);
        zzfa zzfa = new zzfa(context2);
        zzex zzex = new zzex(zzduz, zza, new zzfj(context2, zzfa), zzfa);
        zzgp zzazf = new zzdwb(context2, zzduv).zzazf();
        zzduu zzduu = new zzduu();
        return new zzds(context2, zzduv, new zzdwp(context2, zzazf), new zzdwu(context2, zzazf, new zzdr(zzduv), ((Boolean) zzww.zzra().zzd(zzabq.zzcsl)).booleanValue()), new zzdwz(context2, zzex, zzduv, zzduu), zzex, executor, zzduu, zzazf);
    }

    private zzds(Context context2, zzduv zzduv, zzdwp zzdwp, zzdwu zzdwu, zzdwz zzdwz, zzex zzex, Executor executor, zzduu zzduu, zzgp zzgp) {
        this.context = context2;
        this.zzvx = zzduv;
        this.zzvt = zzdwp;
        this.zzvu = zzdwu;
        this.zzvv = zzdwz;
        this.zzvw = zzex;
        this.zzvy = executor;
        this.zzvz = zzgp;
        this.zzwa = new zzdu(this, zzduu);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzbr() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdwm zzp = zzp(zzdwx.zzhxv);
        if (zzp != null) {
            this.zzvv.zzb(zzp);
        } else {
            this.zzvx.zzh(4013, System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public final void zzbs() {
        if (zzdwb.zza(this.zzvz)) {
            this.zzvy.execute(new zzdt(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa A[Catch:{ zzenn -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b7 A[Catch:{ zzenn -> 0x0127 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzbt() {
        /*
            r11 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = com.google.android.gms.internal.ads.zzdwx.zzhxv
            com.google.android.gms.internal.ads.zzdwm r2 = r11.zzp(r2)
            r3 = 0
            if (r2 == 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzgv r3 = r2.zzazj()
            java.lang.String r3 = r3.zzdh()
            com.google.android.gms.internal.ads.zzgv r2 = r2.zzazj()
            java.lang.String r2 = r2.zzdi()
            r8 = r2
            r7 = r3
            goto L_0x0022
        L_0x0020:
            r7 = r3
            r8 = r7
        L_0x0022:
            android.content.Context r4 = r11.context     // Catch:{ zzenn -> 0x0127 }
            r5 = 1
            com.google.android.gms.internal.ads.zzgp r6 = r11.zzvz     // Catch:{ zzenn -> 0x0127 }
            java.lang.String r9 = "1"
            com.google.android.gms.internal.ads.zzduv r10 = r11.zzvx     // Catch:{ zzenn -> 0x0127 }
            com.google.android.gms.internal.ads.zzdwt r2 = com.google.android.gms.internal.ads.zzdvh.zza(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ zzenn -> 0x0127 }
            byte[] r3 = r2.zzhxp     // Catch:{ zzenn -> 0x0127 }
            if (r3 == 0) goto L_0x011a
            byte[] r3 = r2.zzhxp     // Catch:{ zzenn -> 0x0127 }
            int r3 = r3.length     // Catch:{ zzenn -> 0x0127 }
            if (r3 != 0) goto L_0x003a
            goto L_0x011a
        L_0x003a:
            byte[] r3 = r2.zzhxp     // Catch:{ NullPointerException -> 0x010d }
            com.google.android.gms.internal.ads.zzelq r3 = com.google.android.gms.internal.ads.zzelq.zzt(r3)     // Catch:{ NullPointerException -> 0x010d }
            com.google.android.gms.internal.ads.zzemn r4 = com.google.android.gms.internal.ads.zzemn.zzbiv()     // Catch:{ NullPointerException -> 0x010d }
            com.google.android.gms.internal.ads.zzgr r3 = com.google.android.gms.internal.ads.zzgr.zza(r3, r4)     // Catch:{ NullPointerException -> 0x010d }
            com.google.android.gms.internal.ads.zzgv r4 = r3.zzdd()     // Catch:{ zzenn -> 0x0127 }
            java.lang.String r4 = r4.zzdh()     // Catch:{ zzenn -> 0x0127 }
            boolean r4 = r4.isEmpty()     // Catch:{ zzenn -> 0x0127 }
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzgv r4 = r3.zzdd()     // Catch:{ zzenn -> 0x0127 }
            java.lang.String r4 = r4.zzdi()     // Catch:{ zzenn -> 0x0127 }
            boolean r4 = r4.isEmpty()     // Catch:{ zzenn -> 0x0127 }
            if (r4 != 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzelq r4 = r3.zzdf()     // Catch:{ zzenn -> 0x0127 }
            byte[] r4 = r4.toByteArray()     // Catch:{ zzenn -> 0x0127 }
            int r4 = r4.length     // Catch:{ zzenn -> 0x0127 }
            if (r4 != 0) goto L_0x0072
            goto L_0x00a7
        L_0x0072:
            int r4 = com.google.android.gms.internal.ads.zzdwx.zzhxv     // Catch:{ zzenn -> 0x0127 }
            com.google.android.gms.internal.ads.zzdwm r4 = r11.zzp(r4)     // Catch:{ zzenn -> 0x0127 }
            if (r4 != 0) goto L_0x007b
            goto L_0x00a8
        L_0x007b:
            com.google.android.gms.internal.ads.zzgv r4 = r4.zzazj()     // Catch:{ zzenn -> 0x0127 }
            if (r4 != 0) goto L_0x0082
            goto L_0x00a8
        L_0x0082:
            com.google.android.gms.internal.ads.zzgv r7 = r3.zzdd()     // Catch:{ zzenn -> 0x0127 }
            java.lang.String r7 = r7.zzdh()     // Catch:{ zzenn -> 0x0127 }
            java.lang.String r8 = r4.zzdh()     // Catch:{ zzenn -> 0x0127 }
            boolean r7 = r7.equals(r8)     // Catch:{ zzenn -> 0x0127 }
            if (r7 == 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzgv r7 = r3.zzdd()     // Catch:{ zzenn -> 0x0127 }
            java.lang.String r7 = r7.zzdi()     // Catch:{ zzenn -> 0x0127 }
            java.lang.String r4 = r4.zzdi()     // Catch:{ zzenn -> 0x0127 }
            boolean r4 = r7.equals(r4)     // Catch:{ zzenn -> 0x0127 }
            if (r4 != 0) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r5 = 0
        L_0x00a8:
            if (r5 != 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzduv r2 = r11.zzvx     // Catch:{ zzenn -> 0x0127 }
            r3 = 5010(0x1392, float:7.02E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzenn -> 0x0127 }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzenn -> 0x0127 }
            return
        L_0x00b7:
            com.google.android.gms.internal.ads.zzdwv r4 = r11.zzwa     // Catch:{ zzenn -> 0x0127 }
            int r2 = r2.status     // Catch:{ zzenn -> 0x0127 }
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzabq.zzcsj     // Catch:{ zzenn -> 0x0127 }
            com.google.android.gms.internal.ads.zzabm r7 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ zzenn -> 0x0127 }
            java.lang.Object r5 = r7.zzd(r5)     // Catch:{ zzenn -> 0x0127 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ zzenn -> 0x0127 }
            boolean r5 = r5.booleanValue()     // Catch:{ zzenn -> 0x0127 }
            if (r5 == 0) goto L_0x00e1
            r5 = 3
            if (r2 != r5) goto L_0x00d7
            com.google.android.gms.internal.ads.zzdwu r2 = r11.zzvu     // Catch:{ zzenn -> 0x0127 }
            boolean r6 = r2.zza(r3)     // Catch:{ zzenn -> 0x0127 }
            goto L_0x00e7
        L_0x00d7:
            r5 = 4
            if (r2 != r5) goto L_0x00e7
            com.google.android.gms.internal.ads.zzdwu r2 = r11.zzvu     // Catch:{ zzenn -> 0x0127 }
            boolean r6 = r2.zza((com.google.android.gms.internal.ads.zzgr) r3, (com.google.android.gms.internal.ads.zzdwv) r4)     // Catch:{ zzenn -> 0x0127 }
            goto L_0x00e7
        L_0x00e1:
            com.google.android.gms.internal.ads.zzdwp r2 = r11.zzvt     // Catch:{ zzenn -> 0x0127 }
            boolean r6 = r2.zza(r3, r4)     // Catch:{ zzenn -> 0x0127 }
        L_0x00e7:
            if (r6 != 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzduv r2 = r11.zzvx     // Catch:{ zzenn -> 0x0127 }
            r3 = 4009(0xfa9, float:5.618E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzenn -> 0x0127 }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzenn -> 0x0127 }
            return
        L_0x00f6:
            int r2 = com.google.android.gms.internal.ads.zzdwx.zzhxv     // Catch:{ zzenn -> 0x0127 }
            com.google.android.gms.internal.ads.zzdwm r2 = r11.zzp(r2)     // Catch:{ zzenn -> 0x0127 }
            if (r2 == 0) goto L_0x010c
            com.google.android.gms.internal.ads.zzdwz r3 = r11.zzvv     // Catch:{ zzenn -> 0x0127 }
            r3.zzb(r2)     // Catch:{ zzenn -> 0x0127 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzenn -> 0x0127 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r11.zzwb = r2     // Catch:{ zzenn -> 0x0127 }
        L_0x010c:
            return
        L_0x010d:
            com.google.android.gms.internal.ads.zzduv r2 = r11.zzvx     // Catch:{ zzenn -> 0x0127 }
            r3 = 2030(0x7ee, float:2.845E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzenn -> 0x0127 }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzenn -> 0x0127 }
            return
        L_0x011a:
            com.google.android.gms.internal.ads.zzduv r2 = r11.zzvx     // Catch:{ zzenn -> 0x0127 }
            r3 = 5009(0x1391, float:7.019E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzenn -> 0x0127 }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzenn -> 0x0127 }
            return
        L_0x0127:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzduv r3 = r11.zzvx
            r4 = 4002(0xfa2, float:5.608E-42)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r3.zza((int) r4, (long) r5, (java.lang.Exception) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzds.zzbt():void");
    }

    public final void zza(MotionEvent motionEvent) {
        zzdvb zzazu = this.zzvv.zzazu();
        if (zzazu != null) {
            try {
                zzazu.zza((String) null, motionEvent);
            } catch (zzdww e) {
                this.zzvx.zza(e.zzazt(), -1, (Exception) e);
            }
        }
    }

    public final String zza(Context context2, String str, View view, Activity activity) {
        zzbu();
        zzdvb zzazu = this.zzvv.zzazu();
        if (zzazu == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza = zzazu.zza(context2, (String) null, str, view, activity);
        this.zzvx.zza(5000, System.currentTimeMillis() - currentTimeMillis, zza, (Map<String, String>) null);
        return zza;
    }

    public final String zza(Context context2, String str, View view) {
        return zza(context2, str, view, (Activity) null);
    }

    public final void zzb(View view) {
        this.zzvw.zzc(view);
    }

    public final String zza(Context context2, View view, Activity activity) {
        zzbu();
        zzdvb zzazu = this.zzvv.zzazu();
        if (zzazu == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb = zzazu.zzb(context2, (String) null, view, activity);
        this.zzvx.zza(5002, System.currentTimeMillis() - currentTimeMillis, zzb, (Map<String, String>) null);
        return zzb;
    }

    public final String zzb(Context context2) {
        zzbu();
        zzdvb zzazu = this.zzvv.zzazu();
        if (zzazu == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzs = zzazu.zzs(context2, (String) null);
        this.zzvx.zza(5001, System.currentTimeMillis() - currentTimeMillis, zzs, (Map<String, String>) null);
        return zzs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzbu() {
        /*
            r6 = this;
            boolean r0 = r6.zzwd
            if (r0 != 0) goto L_0x0033
            java.lang.Object r0 = r6.zzwc
            monitor-enter(r0)
            boolean r1 = r6.zzwd     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0030 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r6.zzwb     // Catch:{ all -> 0x0030 }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzdwz r1 = r6.zzvv     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzdwm r1 = r1.zzazv()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzfg(r3)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
        L_0x002b:
            r6.zzbs()     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzds.zzbu():void");
    }

    private final zzdwm zzp(int i) {
        if (!zzdwb.zza(this.zzvz)) {
            return null;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsj)).booleanValue()) {
            return this.zzvu.zzp(i);
        }
        return this.zzvt.zzp(i);
    }
}
