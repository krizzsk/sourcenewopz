package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfp extends zzgn {
    private static final zzgq<zzcx> zzaaz = new zzgq<>();
    private final Context zzaba;
    private zzcb.zza zzabb = null;

    public zzfp(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2, Context context, zzcb.zza zza) {
        super(zzfc, str, str2, zzb, i, 27);
        this.zzaba = context;
        this.zzabb = zza;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcx() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzgq<com.google.android.gms.internal.ads.zzcx> r0 = zzaaz
            android.content.Context r1 = r10.zzaba
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.zzas(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcx r1 = (com.google.android.gms.internal.ads.zzcx) r1     // Catch:{ all -> 0x0113 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r1.zzns     // Catch:{ all -> 0x0113 }
            boolean r4 = com.google.android.gms.internal.ads.zzfh.zzar(r4)     // Catch:{ all -> 0x0113 }
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = r1.zzns     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = "E"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0113 }
            if (r4 != 0) goto L_0x0036
            java.lang.String r1 = r1.zzns     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0113 }
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == 0) goto L_0x00df
            com.google.android.gms.internal.ads.zzcb$zza r1 = r10.zzabb     // Catch:{ all -> 0x0113 }
            java.lang.String r1 = zza(r1)     // Catch:{ all -> 0x0113 }
            boolean r1 = com.google.android.gms.internal.ads.zzfh.zzar(r1)     // Catch:{ all -> 0x0113 }
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x0113 }
            goto L_0x0082
        L_0x0048:
            com.google.android.gms.internal.ads.zzcb$zza r1 = r10.zzabb     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = zza(r1)     // Catch:{ all -> 0x0113 }
            boolean r4 = com.google.android.gms.internal.ads.zzfh.zzar(r4)     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x006a
            if (r1 == 0) goto L_0x006a
            boolean r4 = r1.zzx()     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzcb$zzb r1 = r1.zzy()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcd r1 = r1.zzac()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcd r4 = com.google.android.gms.internal.ads.zzcd.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x0113 }
            if (r1 != r4) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0113 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0113 }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzfc r1 = r10.zzwh     // Catch:{ all -> 0x0113 }
            boolean r1 = r1.zzcn()     // Catch:{ all -> 0x0113 }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x0113 }
            goto L_0x0082
        L_0x0080:
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x0113 }
        L_0x0082:
            com.google.android.gms.internal.ads.zzcd r4 = com.google.android.gms.internal.ads.zzcd.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x0113 }
            if (r1 != r4) goto L_0x0088
            r4 = 1
            goto L_0x0089
        L_0x0088:
            r4 = 0
        L_0x0089:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0113 }
            java.lang.reflect.Method r5 = r10.zzabq     // Catch:{ all -> 0x0113 }
            r6 = 0
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x0113 }
            android.content.Context r9 = r10.zzaba     // Catch:{ all -> 0x0113 }
            r8[r2] = r9     // Catch:{ all -> 0x0113 }
            r8[r3] = r4     // Catch:{ all -> 0x0113 }
            java.lang.Object r2 = r5.invoke(r6, r8)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcx r4 = new com.google.android.gms.internal.ads.zzcx     // Catch:{ all -> 0x0113 }
            r4.<init>(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = r4.zzns     // Catch:{ all -> 0x0113 }
            boolean r2 = com.google.android.gms.internal.ads.zzfh.zzar(r2)     // Catch:{ all -> 0x0113 }
            if (r2 != 0) goto L_0x00b6
            java.lang.String r2 = r4.zzns     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = "E"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x00dc
        L_0x00b6:
            int[] r2 = com.google.android.gms.internal.ads.zzfs.zzabd     // Catch:{ all -> 0x0113 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0113 }
            r1 = r2[r1]     // Catch:{ all -> 0x0113 }
            if (r1 == r3) goto L_0x00d0
            if (r1 == r7) goto L_0x00c3
            goto L_0x00dc
        L_0x00c3:
            java.lang.String r1 = r10.zzcy()     // Catch:{ all -> 0x0113 }
            boolean r2 = com.google.android.gms.internal.ads.zzfh.zzar(r1)     // Catch:{ all -> 0x0113 }
            if (r2 != 0) goto L_0x00dc
            r4.zzns = r1     // Catch:{ all -> 0x0113 }
            goto L_0x00dc
        L_0x00d0:
            com.google.android.gms.internal.ads.zzcb$zza r1 = r10.zzabb     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcb$zzc r1 = r1.zzaa()     // Catch:{ all -> 0x0113 }
            java.lang.String r1 = r1.zzaf()     // Catch:{ all -> 0x0113 }
            r4.zzns = r1     // Catch:{ all -> 0x0113 }
        L_0x00dc:
            r0.set(r4)     // Catch:{ all -> 0x0113 }
        L_0x00df:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcx r1 = (com.google.android.gms.internal.ads.zzcx) r1     // Catch:{ all -> 0x0113 }
            monitor-exit(r0)     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcf$zza$zzb r2 = r10.zzabg
            monitor-enter(r2)
            if (r1 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzcf$zza$zzb r0 = r10.zzabg     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r1.zzns     // Catch:{ all -> 0x0110 }
            r0.zzae(r3)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.ads.zzcf$zza$zzb r0 = r10.zzabg     // Catch:{ all -> 0x0110 }
            long r3 = r1.zznt     // Catch:{ all -> 0x0110 }
            r0.zzba(r3)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.ads.zzcf$zza$zzb r0 = r10.zzabg     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r1.zznu     // Catch:{ all -> 0x0110 }
            r0.zzag(r3)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.ads.zzcf$zza$zzb r0 = r10.zzabg     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r1.zznv     // Catch:{ all -> 0x0110 }
            r0.zzah(r3)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.ads.zzcf$zza$zzb r0 = r10.zzabg     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = r1.zznw     // Catch:{ all -> 0x0110 }
            r0.zzai(r1)     // Catch:{ all -> 0x0110 }
        L_0x010e:
            monitor-exit(r2)     // Catch:{ all -> 0x0110 }
            return
        L_0x0110:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0110 }
            throw r0
        L_0x0113:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0113 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfp.zzcx():void");
    }

    private static String zza(zzcb.zza zza) {
        if (zza == null || !zza.zzz() || zzfh.zzar(zza.zzaa().zzaf())) {
            return null;
        }
        return zza.zzaa().zzaf();
    }

    private final String zzcy() {
        try {
            if (this.zzwh.zzcq() != null) {
                this.zzwh.zzcq().get();
            }
            zzcf.zza zzcp = this.zzwh.zzcp();
            if (zzcp == null || !zzcp.zzai()) {
                return null;
            }
            return zzcp.zzaf();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
