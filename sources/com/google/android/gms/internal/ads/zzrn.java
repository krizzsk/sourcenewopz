package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzrn {
    private final Object lock = new Object();
    private int zzbtj;
    private List<zzrk> zzbtk = new LinkedList();

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrk zzp(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.lock
            monitor-enter(r0)
            java.util.List<com.google.android.gms.internal.ads.zzrk> r1 = r7.zzbtk     // Catch:{ all -> 0x005a }
            int r1 = r1.size()     // Catch:{ all -> 0x005a }
            r2 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r8 = "Queue empty"
            com.google.android.gms.ads.internal.util.zzd.zzdz(r8)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r2
        L_0x0013:
            java.util.List<com.google.android.gms.internal.ads.zzrk> r1 = r7.zzbtk     // Catch:{ all -> 0x005a }
            int r1 = r1.size()     // Catch:{ all -> 0x005a }
            r3 = 2
            r4 = 0
            if (r1 < r3) goto L_0x0045
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            java.util.List<com.google.android.gms.internal.ads.zzrk> r1 = r7.zzbtk     // Catch:{ all -> 0x005a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x005a }
            r3 = 0
        L_0x0026:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x003e
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzrk r5 = (com.google.android.gms.internal.ads.zzrk) r5     // Catch:{ all -> 0x005a }
            int r6 = r5.getScore()     // Catch:{ all -> 0x005a }
            if (r6 <= r8) goto L_0x003b
            r4 = r3
            r2 = r5
            r8 = r6
        L_0x003b:
            int r3 = r3 + 1
            goto L_0x0026
        L_0x003e:
            java.util.List<com.google.android.gms.internal.ads.zzrk> r8 = r7.zzbtk     // Catch:{ all -> 0x005a }
            r8.remove(r4)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r2
        L_0x0045:
            java.util.List<com.google.android.gms.internal.ads.zzrk> r1 = r7.zzbtk     // Catch:{ all -> 0x005a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzrk r1 = (com.google.android.gms.internal.ads.zzrk) r1     // Catch:{ all -> 0x005a }
            if (r8 == 0) goto L_0x0055
            java.util.List<com.google.android.gms.internal.ads.zzrk> r8 = r7.zzbtk     // Catch:{ all -> 0x005a }
            r8.remove(r4)     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x0055:
            r1.zzmi()     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r1
        L_0x005a:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrn.zzp(boolean):com.google.android.gms.internal.ads.zzrk");
    }

    public final boolean zza(zzrk zzrk) {
        synchronized (this.lock) {
            if (this.zzbtk.contains(zzrk)) {
                return true;
            }
            return false;
        }
    }

    public final boolean zzb(zzrk zzrk) {
        synchronized (this.lock) {
            Iterator<zzrk> it = this.zzbtk.iterator();
            while (it.hasNext()) {
                zzrk next = it.next();
                if (!zzr.zzkz().zzyl().zzzb()) {
                    if (zzrk != next && next.zzmf().equals(zzrk.zzmf())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzr.zzkz().zzyl().zzzd() && zzrk != next && next.zzmh().equals(zzrk.zzmh())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzrk zzrk) {
        synchronized (this.lock) {
            if (this.zzbtk.size() >= 10) {
                int size = this.zzbtk.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzd.zzdz(sb.toString());
                this.zzbtk.remove(0);
            }
            int i = this.zzbtj;
            this.zzbtj = i + 1;
            zzrk.zzbw(i);
            zzrk.zzml();
            this.zzbtk.add(zzrk);
        }
    }
}
