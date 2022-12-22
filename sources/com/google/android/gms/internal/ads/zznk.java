package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zznk {
    private int length;
    private int[] zzape = new int[1000];
    private long[] zzapf = new long[1000];
    private long[] zzaph = new long[1000];
    private int[] zzayv = new int[1000];
    private int zzbfy = 1000;
    private int[] zzbfz = new int[1000];
    private zzkk[] zzbga = new zzkk[1000];
    private zzht[] zzbgb = new zzht[1000];
    private int zzbgc;
    private int zzbgd;
    private int zzbge;
    private long zzbgf = Long.MIN_VALUE;
    private long zzbgg = Long.MIN_VALUE;
    private boolean zzbgh = true;
    private boolean zzbgi = true;
    private zzht zzbgj;

    public final void zzif() {
        this.zzbgc = 0;
        this.zzbgd = 0;
        this.zzbge = 0;
        this.length = 0;
        this.zzbgh = true;
    }

    public final void zzig() {
        this.zzbgf = Long.MIN_VALUE;
        this.zzbgg = Long.MIN_VALUE;
    }

    public final int zzih() {
        return this.zzbgc + this.length;
    }

    public final synchronized boolean zzii() {
        return this.length != 0;
    }

    public final synchronized zzht zzij() {
        if (this.zzbgi) {
            return null;
        }
        return this.zzbgj;
    }

    public final synchronized long zzhz() {
        return Math.max(this.zzbgf, this.zzbgg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zza(com.google.android.gms.internal.ads.zzhv r5, com.google.android.gms.internal.ads.zzjp r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzht r9, com.google.android.gms.internal.ads.zznj r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzii()     // Catch:{ all -> 0x00a4 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0024
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzht r6 = r4.zzbgj     // Catch:{ all -> 0x00a4 }
            if (r6 == 0) goto L_0x0022
            if (r7 != 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzht r6 = r4.zzbgj     // Catch:{ all -> 0x00a4 }
            if (r6 == r9) goto L_0x0022
        L_0x001c:
            com.google.android.gms.internal.ads.zzht r6 = r4.zzbgj     // Catch:{ all -> 0x00a4 }
            r5.zzaij = r6     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r1
        L_0x0022:
            monitor-exit(r4)
            return r2
        L_0x0024:
            if (r7 != 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzht[] r7 = r4.zzbgb     // Catch:{ all -> 0x00a4 }
            int r8 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            r7 = r7[r8]     // Catch:{ all -> 0x00a4 }
            if (r7 == r9) goto L_0x002f
            goto L_0x009a
        L_0x002f:
            java.nio.ByteBuffer r5 = r6.zzdr     // Catch:{ all -> 0x00a4 }
            r7 = 0
            r8 = 1
            if (r5 != 0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            monitor-exit(r4)
            return r2
        L_0x003c:
            long[] r5 = r4.zzaph     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r6.zzaov = r0     // Catch:{ all -> 0x00a4 }
            int[] r5 = r4.zzayv     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r6.setFlags(r5)     // Catch:{ all -> 0x00a4 }
            int[] r5 = r4.zzape     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r10.size = r5     // Catch:{ all -> 0x00a4 }
            long[] r5 = r4.zzapf     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r10.zzaxf = r0     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzkk[] r5 = r4.zzbga     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r10.zzarz = r5     // Catch:{ all -> 0x00a4 }
            long r0 = r4.zzbgf     // Catch:{ all -> 0x00a4 }
            long r5 = r6.zzaov     // Catch:{ all -> 0x00a4 }
            long r5 = java.lang.Math.max(r0, r5)     // Catch:{ all -> 0x00a4 }
            r4.zzbgf = r5     // Catch:{ all -> 0x00a4 }
            int r5 = r4.length     // Catch:{ all -> 0x00a4 }
            int r5 = r5 - r8
            r4.length = r5     // Catch:{ all -> 0x00a4 }
            int r5 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            int r5 = r5 + r8
            r4.zzbgd = r5     // Catch:{ all -> 0x00a4 }
            int r6 = r4.zzbgc     // Catch:{ all -> 0x00a4 }
            int r6 = r6 + r8
            r4.zzbgc = r6     // Catch:{ all -> 0x00a4 }
            int r6 = r4.zzbfy     // Catch:{ all -> 0x00a4 }
            if (r5 != r6) goto L_0x0084
            r4.zzbgd = r7     // Catch:{ all -> 0x00a4 }
        L_0x0084:
            int r5 = r4.length     // Catch:{ all -> 0x00a4 }
            if (r5 <= 0) goto L_0x008f
            long[] r5 = r4.zzapf     // Catch:{ all -> 0x00a4 }
            int r6 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            r6 = r5[r6]     // Catch:{ all -> 0x00a4 }
            goto L_0x0096
        L_0x008f:
            long r5 = r10.zzaxf     // Catch:{ all -> 0x00a4 }
            int r7 = r10.size     // Catch:{ all -> 0x00a4 }
            long r7 = (long) r7     // Catch:{ all -> 0x00a4 }
            long r6 = r5 + r7
        L_0x0096:
            r10.zzbfx = r6     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r3
        L_0x009a:
            com.google.android.gms.internal.ads.zzht[] r6 = r4.zzbgb     // Catch:{ all -> 0x00a4 }
            int r7 = r4.zzbgd     // Catch:{ all -> 0x00a4 }
            r6 = r6[r7]     // Catch:{ all -> 0x00a4 }
            r5.zzaij = r6     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r1
        L_0x00a4:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznk.zza(com.google.android.gms.internal.ads.zzhv, com.google.android.gms.internal.ads.zzjp, boolean, boolean, com.google.android.gms.internal.ads.zzht, com.google.android.gms.internal.ads.zznj):int");
    }

    public final synchronized long zzik() {
        if (!zzii()) {
            return -1;
        }
        int i = ((this.zzbgd + this.length) - 1) % this.zzbfy;
        this.zzbgd = (this.zzbgd + this.length) % this.zzbfy;
        this.zzbgc += this.length;
        this.length = 0;
        return this.zzapf[i] + ((long) this.zzape[i]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzd(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzii()     // Catch:{ all -> 0x005e }
            r1 = -1
            if (r0 == 0) goto L_0x005c
            long[] r0 = r8.zzaph     // Catch:{ all -> 0x005e }
            int r3 = r8.zzbgd     // Catch:{ all -> 0x005e }
            r3 = r0[r3]     // Catch:{ all -> 0x005e }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005c
        L_0x0014:
            long r3 = r8.zzbgg     // Catch:{ all -> 0x005e }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            if (r11 != 0) goto L_0x001e
            monitor-exit(r8)
            return r1
        L_0x001e:
            r11 = 0
            int r0 = r8.zzbgd     // Catch:{ all -> 0x005e }
            r3 = -1
            r4 = -1
        L_0x0023:
            int r5 = r8.zzbge     // Catch:{ all -> 0x005e }
            if (r0 == r5) goto L_0x0040
            long[] r5 = r8.zzaph     // Catch:{ all -> 0x005e }
            r6 = r5[r0]     // Catch:{ all -> 0x005e }
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0040
            int[] r5 = r8.zzayv     // Catch:{ all -> 0x005e }
            r5 = r5[r0]     // Catch:{ all -> 0x005e }
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0038
            r4 = r11
        L_0x0038:
            int r0 = r0 + 1
            int r5 = r8.zzbfy     // Catch:{ all -> 0x005e }
            int r0 = r0 % r5
            int r11 = r11 + 1
            goto L_0x0023
        L_0x0040:
            if (r4 != r3) goto L_0x0044
            monitor-exit(r8)
            return r1
        L_0x0044:
            int r9 = r8.zzbgd     // Catch:{ all -> 0x005e }
            int r9 = r9 + r4
            int r10 = r8.zzbfy     // Catch:{ all -> 0x005e }
            int r9 = r9 % r10
            r8.zzbgd = r9     // Catch:{ all -> 0x005e }
            int r10 = r8.zzbgc     // Catch:{ all -> 0x005e }
            int r10 = r10 + r4
            r8.zzbgc = r10     // Catch:{ all -> 0x005e }
            int r10 = r8.length     // Catch:{ all -> 0x005e }
            int r10 = r10 - r4
            r8.length = r10     // Catch:{ all -> 0x005e }
            long[] r10 = r8.zzapf     // Catch:{ all -> 0x005e }
            r9 = r10[r9]     // Catch:{ all -> 0x005e }
            monitor-exit(r8)
            return r9
        L_0x005c:
            monitor-exit(r8)
            return r1
        L_0x005e:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznk.zzd(long, boolean):long");
    }

    public final synchronized boolean zzg(zzht zzht) {
        if (zzht == null) {
            this.zzbgi = true;
            return false;
        }
        this.zzbgi = false;
        if (zzpt.zza(zzht, this.zzbgj)) {
            return false;
        }
        this.zzbgj = zzht;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(long r6, int r8, long r9, int r11, com.google.android.gms.internal.ads.zzkk r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzbgh     // Catch:{ all -> 0x00e7 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.zzbgh = r1     // Catch:{ all -> 0x00e7 }
        L_0x000e:
            boolean r0 = r5.zzbgi     // Catch:{ all -> 0x00e7 }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.internal.ads.zzpg.checkState(r0)     // Catch:{ all -> 0x00e7 }
            r5.zzei(r6)     // Catch:{ all -> 0x00e7 }
            long[] r0 = r5.zzaph     // Catch:{ all -> 0x00e7 }
            int r3 = r5.zzbge     // Catch:{ all -> 0x00e7 }
            r0[r3] = r6     // Catch:{ all -> 0x00e7 }
            long[] r6 = r5.zzapf     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbge     // Catch:{ all -> 0x00e7 }
            r6[r7] = r9     // Catch:{ all -> 0x00e7 }
            int[] r6 = r5.zzape     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbge     // Catch:{ all -> 0x00e7 }
            r6[r7] = r11     // Catch:{ all -> 0x00e7 }
            int[] r6 = r5.zzayv     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbge     // Catch:{ all -> 0x00e7 }
            r6[r7] = r8     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzkk[] r6 = r5.zzbga     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbge     // Catch:{ all -> 0x00e7 }
            r6[r7] = r12     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzht[] r6 = r5.zzbgb     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbge     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzht r8 = r5.zzbgj     // Catch:{ all -> 0x00e7 }
            r6[r7] = r8     // Catch:{ all -> 0x00e7 }
            int[] r6 = r5.zzbfz     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbge     // Catch:{ all -> 0x00e7 }
            r6[r7] = r1     // Catch:{ all -> 0x00e7 }
            int r6 = r5.length     // Catch:{ all -> 0x00e7 }
            int r6 = r6 + r2
            r5.length = r6     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbfy     // Catch:{ all -> 0x00e7 }
            if (r6 != r7) goto L_0x00da
            int r6 = r5.zzbfy     // Catch:{ all -> 0x00e7 }
            int r6 = r6 + 1000
            int[] r7 = new int[r6]     // Catch:{ all -> 0x00e7 }
            long[] r8 = new long[r6]     // Catch:{ all -> 0x00e7 }
            long[] r9 = new long[r6]     // Catch:{ all -> 0x00e7 }
            int[] r10 = new int[r6]     // Catch:{ all -> 0x00e7 }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzkk[] r12 = new com.google.android.gms.internal.ads.zzkk[r6]     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzht[] r0 = new com.google.android.gms.internal.ads.zzht[r6]     // Catch:{ all -> 0x00e7 }
            int r2 = r5.zzbfy     // Catch:{ all -> 0x00e7 }
            int r3 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            int r2 = r2 - r3
            long[] r3 = r5.zzapf     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00e7 }
            long[] r3 = r5.zzaph     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00e7 }
            int[] r3 = r5.zzayv     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00e7 }
            int[] r3 = r5.zzape     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzkk[] r3 = r5.zzbga     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzht[] r3 = r5.zzbgb     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00e7 }
            int[] r3 = r5.zzbfz     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00e7 }
            int r3 = r5.zzbgd     // Catch:{ all -> 0x00e7 }
            long[] r4 = r5.zzapf     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00e7 }
            long[] r4 = r5.zzaph     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00e7 }
            int[] r4 = r5.zzayv     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00e7 }
            int[] r4 = r5.zzape     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzkk[] r4 = r5.zzbga     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzht[] r4 = r5.zzbgb     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00e7 }
            int[] r4 = r5.zzbfz     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00e7 }
            r5.zzapf = r8     // Catch:{ all -> 0x00e7 }
            r5.zzaph = r9     // Catch:{ all -> 0x00e7 }
            r5.zzayv = r10     // Catch:{ all -> 0x00e7 }
            r5.zzape = r11     // Catch:{ all -> 0x00e7 }
            r5.zzbga = r12     // Catch:{ all -> 0x00e7 }
            r5.zzbgb = r0     // Catch:{ all -> 0x00e7 }
            r5.zzbfz = r7     // Catch:{ all -> 0x00e7 }
            r5.zzbgd = r1     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbfy     // Catch:{ all -> 0x00e7 }
            r5.zzbge = r7     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbfy     // Catch:{ all -> 0x00e7 }
            r5.length = r7     // Catch:{ all -> 0x00e7 }
            r5.zzbfy = r6     // Catch:{ all -> 0x00e7 }
            monitor-exit(r5)
            return
        L_0x00da:
            int r6 = r5.zzbge     // Catch:{ all -> 0x00e7 }
            int r6 = r6 + r2
            r5.zzbge = r6     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbfy     // Catch:{ all -> 0x00e7 }
            if (r6 != r7) goto L_0x00e5
            r5.zzbge = r1     // Catch:{ all -> 0x00e7 }
        L_0x00e5:
            monitor-exit(r5)
            return
        L_0x00e7:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznk.zza(long, int, long, int, com.google.android.gms.internal.ads.zzkk):void");
    }

    public final synchronized void zzei(long j) {
        this.zzbgg = Math.max(this.zzbgg, j);
    }
}
