package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xcrash.TombstoneParser;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmk {
    private final zzf zzeci;
    private List<Map<String, String>> zzgor = new ArrayList();
    private boolean zzgos = false;
    private boolean zzgot = false;
    private String zzgou;
    private zzcmg zzgov;

    public zzcmk(String str, zzcmg zzcmg) {
        this.zzgou = str;
        this.zzgov = zzcmg;
        this.zzeci = zzr.zzkz().zzyl();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzgg(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcsg     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x003f }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x003f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzdbl     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x003f }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x003f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0026
            goto L_0x003d
        L_0x0026:
            java.util.Map r0 = r3.zzaru()     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "action"
            java.lang.String r2 = "adapter_init_started"
            r0.put(r1, r2)     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "ancn"
            r0.put(r1, r4)     // Catch:{ all -> 0x003f }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r4 = r3.zzgor     // Catch:{ all -> 0x003f }
            r4.add(r0)     // Catch:{ all -> 0x003f }
            monitor-exit(r3)
            return
        L_0x003d:
            monitor-exit(r3)
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmk.zzgg(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzgh(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcsg     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x003f }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x003f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzdbl     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x003f }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x003f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0026
            goto L_0x003d
        L_0x0026:
            java.util.Map r0 = r3.zzaru()     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "action"
            java.lang.String r2 = "adapter_init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "ancn"
            r0.put(r1, r4)     // Catch:{ all -> 0x003f }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r4 = r3.zzgor     // Catch:{ all -> 0x003f }
            r4.add(r0)     // Catch:{ all -> 0x003f }
            monitor-exit(r3)
            return
        L_0x003d:
            monitor-exit(r3)
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmk.zzgh(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzt(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcsg     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0044 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzdbl     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0044 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0026
            goto L_0x0042
        L_0x0026:
            java.util.Map r0 = r3.zzaru()     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "adapter_init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "ancn"
            r0.put(r1, r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = "rqe"
            r0.put(r4, r5)     // Catch:{ all -> 0x0044 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r4 = r3.zzgor     // Catch:{ all -> 0x0044 }
            r4.add(r0)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            return
        L_0x0042:
            monitor-exit(r3)
            return
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmk.zzt(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzars() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcsg     // Catch:{ all -> 0x0041 }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0041 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0041 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0041 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzdbl     // Catch:{ all -> 0x0041 }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0041 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0041 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0041 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x0026
            goto L_0x003f
        L_0x0026:
            boolean r0 = r3.zzgos     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x003d
            java.util.Map r0 = r3.zzaru()     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_started"
            r0.put(r1, r2)     // Catch:{ all -> 0x0041 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.zzgor     // Catch:{ all -> 0x0041 }
            r1.add(r0)     // Catch:{ all -> 0x0041 }
            r0 = 1
            r3.zzgos = r0     // Catch:{ all -> 0x0041 }
        L_0x003d:
            monitor-exit(r3)
            return
        L_0x003f:
            monitor-exit(r3)
            return
        L_0x0041:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmk.zzars():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzart() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcsg     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0059 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0059 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0059 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0057
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzdbl     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0059 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0059 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0059 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0026
            goto L_0x0057
        L_0x0026:
            boolean r0 = r3.zzgot     // Catch:{ all -> 0x0059 }
            if (r0 != 0) goto L_0x0055
            java.util.Map r0 = r3.zzaru()     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x0059 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.zzgor     // Catch:{ all -> 0x0059 }
            r1.add(r0)     // Catch:{ all -> 0x0059 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r0 = r3.zzgor     // Catch:{ all -> 0x0059 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0059 }
        L_0x0040:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0059 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.ads.zzcmg r2 = r3.zzgov     // Catch:{ all -> 0x0059 }
            r2.zzo(r1)     // Catch:{ all -> 0x0059 }
            goto L_0x0040
        L_0x0052:
            r0 = 1
            r3.zzgot = r0     // Catch:{ all -> 0x0059 }
        L_0x0055:
            monitor-exit(r3)
            return
        L_0x0057:
            monitor-exit(r3)
            return
        L_0x0059:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmk.zzart():void");
    }

    private final Map<String, String> zzaru() {
        Map<String, String> zzarq = this.zzgov.zzarq();
        zzarq.put("tms", Long.toString(zzr.zzlc().elapsedRealtime(), 10));
        zzarq.put(TombstoneParser.keyThreadId, this.zzeci.zzzn() ? "" : this.zzgou);
        return zzarq;
    }
}
