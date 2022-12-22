package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzas implements zzad {
    private final zzaf zzau = null;
    private final zzm zzbn;
    private final Map<String, List<zzab<?>>> zzbx = new HashMap();
    private final zzal zzby;
    private final BlockingQueue<zzab<?>> zzm;

    zzas(zzm zzm2, BlockingQueue<zzab<?>> blockingQueue, zzal zzal) {
        this.zzby = zzal;
        this.zzbn = zzm2;
        this.zzm = blockingQueue;
    }

    public final void zzb(zzab<?> zzab, zzag<?> zzag) {
        List<zzab> remove;
        if (zzag.zzbq == null || zzag.zzbq.zza()) {
            zzc(zzab);
            return;
        }
        String zze = zzab.zze();
        synchronized (this) {
            remove = this.zzbx.remove(zze);
        }
        if (remove != null) {
            if (zzao.DEBUG) {
                zzao.m37367v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zze);
            }
            for (zzab zza : remove) {
                this.zzby.zza((zzab<?>) zza, zzag);
            }
        }
    }

    public final synchronized void zzc(zzab<?> zzab) {
        String zze = zzab.zze();
        List remove = this.zzbx.remove(zze);
        if (remove != null && !remove.isEmpty()) {
            if (zzao.DEBUG) {
                zzao.m37367v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zze);
            }
            zzab zzab2 = (zzab) remove.remove(0);
            this.zzbx.put(zze, remove);
            zzab2.zza((zzad) this);
            if (!(this.zzbn == null || this.zzm == null)) {
                try {
                    this.zzm.put(zzab2);
                } catch (InterruptedException e) {
                    zzao.m37366e("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.zzbn.quit();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzg(com.google.android.gms.internal.ads.zzab<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = r6.zze()     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzab<?>>> r1 = r5.zzbx     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003a
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzab<?>>> r1 = r5.zzbx     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.zzc(r4)     // Catch:{ all -> 0x0052 }
            r1.add(r6)     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzab<?>>> r6 = r5.zzbx     // Catch:{ all -> 0x0052 }
            r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzao.DEBUG     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038
            java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzao.m37365d(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzab<?>>> r1 = r5.zzbx     // Catch:{ all -> 0x0052 }
            r4 = 0
            r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
            r6.zza((com.google.android.gms.internal.ads.zzad) r5)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzao.DEBUG     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "new request, sending to network %s"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzao.m37365d(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return r3
        L_0x0052:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzas.zzg(com.google.android.gms.internal.ads.zzab):boolean");
    }
}
