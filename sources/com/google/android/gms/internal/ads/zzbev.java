package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbev extends zzbek implements zzbdx {
    private String zzemj;
    private boolean zzesi;
    private zzbdn zzesl;
    private Exception zzesm;
    private boolean zzesn;

    public zzbev(zzbcs zzbcs, zzbcp zzbcp) {
        super(zzbcs);
        zzbdn zzbdn = new zzbdn(zzbcs.getContext(), zzbcp, (zzbcs) this.zzerx.get());
        this.zzesl = zzbdn;
        zzbdn.zza((zzbdx) this);
    }

    public final void zzdy(int i) {
    }

    public final void zzp(int i, int i2) {
    }

    public final void zzb(boolean z, long j) {
        zzbcs zzbcs = (zzbcs) this.zzerx.get();
        if (zzbcs != null) {
            zzbat.zzeki.execute(new zzbey(zzbcs, z, j));
        }
    }

    public final void zzb(String str, Exception exc) {
        String str2 = (String) zzww.zzra().zzd(zzabq.zzcnd);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains("all") || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzesm = exc;
        zzd.zzd("Precache error", exc);
        zzfk(str);
    }

    public final void zzc(String str, Exception exc) {
        zzd.zzd("Precache exception", exc);
    }

    public final void zzdr(int i) {
        this.zzesl.zzadg().zzeb(i);
    }

    public final void zzdq(int i) {
        this.zzesl.zzadg().zzea(i);
    }

    public final void zzds(int i) {
        this.zzesl.zzadg().zzds(i);
    }

    public final void zzdt(int i) {
        this.zzesl.zzadg().zzdt(i);
    }

    public final void release() {
        zzbdn zzbdn = this.zzesl;
        if (zzbdn != null) {
            zzbdn.zza((zzbdx) null);
            this.zzesl.release();
        }
        super.release();
    }

    /* access modifiers changed from: protected */
    public final String zzfi(String str) {
        String valueOf = String.valueOf(super.zzfi(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    public final boolean zzfh(String str) {
        return zze(str, new String[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009f, code lost:
        if (r15.zzesm == null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a5, code lost:
        throw r15.zzesm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00af, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b1, code lost:
        r17 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bc, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0152, code lost:
        r5 = r45;
        r6 = r46;
        r7 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r5.zzc(r6, r7, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(java.lang.String r46, java.lang.String[] r47) {
        /*
            r45 = this;
            r15 = r45
            r13 = r46
            r0 = r47
            r15.zzemj = r13
            java.lang.String r14 = r45.zzfi(r46)
            java.lang.String r17 = "error"
            r18 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x01d8 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x01d8 }
            r2 = 0
        L_0x0014:
            int r3 = r0.length     // Catch:{ Exception -> 0x01d8 }
            if (r2 >= r3) goto L_0x0029
            r3 = r0[r2]     // Catch:{ Exception -> 0x0022 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0022 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0022 }
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0022:
            r0 = move-exception
            r1 = r0
            r6 = r13
            r7 = r14
            r5 = r15
            goto L_0x01dd
        L_0x0029:
            com.google.android.gms.internal.ads.zzbdn r0 = r15.zzesl     // Catch:{ Exception -> 0x01d8 }
            java.lang.String r2 = r15.zzeiz     // Catch:{ Exception -> 0x01d8 }
            r0.zza((android.net.Uri[]) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x01d8 }
            java.lang.ref.WeakReference r0 = r15.zzerx     // Catch:{ Exception -> 0x01d8 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01d8 }
            com.google.android.gms.internal.ads.zzbcs r0 = (com.google.android.gms.internal.ads.zzbcs) r0     // Catch:{ Exception -> 0x01d8 }
            if (r0 == 0) goto L_0x003d
            r0.zza((java.lang.String) r14, (com.google.android.gms.internal.ads.zzbek) r15)     // Catch:{ Exception -> 0x0022 }
        L_0x003d:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzr.zzlc()     // Catch:{ Exception -> 0x01d8 }
            long r19 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x01d8 }
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabq.zzcnm     // Catch:{ Exception -> 0x01d8 }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ Exception -> 0x01d8 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d8 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d8 }
            long r11 = r1.longValue()     // Catch:{ Exception -> 0x01d8 }
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabq.zzcnl     // Catch:{ Exception -> 0x01d8 }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ Exception -> 0x01d8 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d8 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d8 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x01d8 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r9 = r1 * r3
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabq.zzcnk     // Catch:{ Exception -> 0x01d8 }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ Exception -> 0x01d8 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d8 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01d8 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01d8 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x01d8 }
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabq.zzcsd     // Catch:{ Exception -> 0x01d8 }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ Exception -> 0x01d8 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d8 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x01d8 }
            boolean r21 = r1.booleanValue()     // Catch:{ Exception -> 0x01d8 }
            r22 = -1
            r1 = r22
        L_0x008e:
            monitor-enter(r45)     // Catch:{ Exception -> 0x01d8 }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x01ce }
            long r3 = r3 - r19
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x01a3
            boolean r3 = r15.zzesi     // Catch:{ all -> 0x01ce }
            if (r3 == 0) goto L_0x00b5
            java.lang.Exception r0 = r15.zzesm     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x00a6
            java.lang.String r1 = "badUrl"
            java.lang.Exception r0 = r15.zzesm     // Catch:{ all -> 0x00b0 }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00a6:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x00b0 }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            r17 = r1
            goto L_0x01cf
        L_0x00b5:
            boolean r3 = r15.zzesn     // Catch:{ all -> 0x01ce }
            r24 = 1
            if (r3 == 0) goto L_0x00bf
            monitor-exit(r45)     // Catch:{ all -> 0x01ce }
            r5 = r15
            goto L_0x0172
        L_0x00bf:
            com.google.android.gms.internal.ads.zzbdn r3 = r15.zzesl     // Catch:{ all -> 0x01ce }
            com.google.android.gms.internal.ads.zzhh r3 = r3.zzadd()     // Catch:{ all -> 0x01ce }
            if (r3 == 0) goto L_0x0196
            long r4 = r3.getDuration()     // Catch:{ all -> 0x01ce }
            r25 = 0
            int r8 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r8 <= 0) goto L_0x0176
            long r27 = r3.getBufferedPosition()     // Catch:{ all -> 0x01ce }
            int r3 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0145
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x00df
            r8 = 1
            goto L_0x00e0
        L_0x00df:
            r8 = 0
        L_0x00e0:
            if (r21 == 0) goto L_0x00eb
            com.google.android.gms.internal.ads.zzbdn r1 = r15.zzesl     // Catch:{ all -> 0x01ce }
            long r1 = r1.zzaba()     // Catch:{ all -> 0x01ce }
            r29 = r1
            goto L_0x00ed
        L_0x00eb:
            r29 = r22
        L_0x00ed:
            if (r21 == 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzbdn r1 = r15.zzesl     // Catch:{ all -> 0x01ce }
            long r1 = r1.zznh()     // Catch:{ all -> 0x01ce }
            r31 = r1
            goto L_0x00fa
        L_0x00f8:
            r31 = r22
        L_0x00fa:
            if (r21 == 0) goto L_0x0105
            com.google.android.gms.internal.ads.zzbdn r1 = r15.zzesl     // Catch:{ all -> 0x01ce }
            long r1 = r1.getTotalBytes()     // Catch:{ all -> 0x01ce }
            r33 = r1
            goto L_0x0107
        L_0x0105:
            r33 = r22
        L_0x0107:
            int r16 = com.google.android.gms.internal.ads.zzbdn.zzade()     // Catch:{ all -> 0x013d }
            int r35 = com.google.android.gms.internal.ads.zzbdn.zzadf()     // Catch:{ all -> 0x013d }
            r1 = r45
            r2 = r46
            r3 = r14
            r36 = r4
            r4 = r27
            r38 = r6
            r6 = r36
            r40 = r9
            r9 = r29
            r42 = r11
            r11 = r31
            r44 = r14
            r13 = r33
            r15 = r16
            r16 = r35
            r1.zza(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x0134 }
            r1 = r27
            r3 = r36
            goto L_0x014e
        L_0x0134:
            r0 = move-exception
            r5 = r45
            r6 = r46
            r7 = r44
            goto L_0x01d2
        L_0x013d:
            r0 = move-exception
            r5 = r45
            r6 = r46
            r7 = r14
            goto L_0x01d2
        L_0x0145:
            r38 = r6
            r40 = r9
            r42 = r11
            r44 = r14
            r3 = r4
        L_0x014e:
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x015d
            r5 = r45
            r6 = r46
            r7 = r44
            r5.zzc(r6, r7, r3)     // Catch:{ all -> 0x01d6 }
            monitor-exit(r45)     // Catch:{ all -> 0x01d6 }
            goto L_0x0172
        L_0x015d:
            r5 = r45
            r6 = r46
            r7 = r44
            com.google.android.gms.internal.ads.zzbdn r3 = r5.zzesl     // Catch:{ all -> 0x01d6 }
            long r3 = r3.getBytesTransferred()     // Catch:{ all -> 0x01d6 }
            int r8 = (r3 > r38 ? 1 : (r3 == r38 ? 0 : -1))
            if (r8 < 0) goto L_0x0173
            int r3 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x0173
            monitor-exit(r45)     // Catch:{ all -> 0x01d6 }
        L_0x0172:
            return r24
        L_0x0173:
            r3 = r42
            goto L_0x017e
        L_0x0176:
            r38 = r6
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            r3 = r11
        L_0x017e:
            r5.wait(r3)     // Catch:{ InterruptedException -> 0x018c }
            monitor-exit(r45)     // Catch:{ all -> 0x01d6 }
            r11 = r3
            r15 = r5
            r13 = r6
            r14 = r7
            r6 = r38
            r9 = r40
            goto L_0x008e
        L_0x018c:
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01ca }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x01ca }
            throw r0     // Catch:{ all -> 0x01ca }
        L_0x0196:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01ca }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x01ca }
            throw r0     // Catch:{ all -> 0x01ca }
        L_0x01a3:
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01ca }
            r2 = 47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ca }
            r3.<init>(r2)     // Catch:{ all -> 0x01ca }
            java.lang.String r2 = "Timeout reached. Limit: "
            r3.append(r2)     // Catch:{ all -> 0x01ca }
            r8 = r40
            r3.append(r8)     // Catch:{ all -> 0x01ca }
            java.lang.String r2 = " ms"
            r3.append(r2)     // Catch:{ all -> 0x01ca }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x01ca }
            r0.<init>(r2)     // Catch:{ all -> 0x01ca }
            throw r0     // Catch:{ all -> 0x01ca }
        L_0x01ca:
            r0 = move-exception
            r17 = r1
            goto L_0x01d2
        L_0x01ce:
            r0 = move-exception
        L_0x01cf:
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01d2:
            monitor-exit(r45)     // Catch:{ all -> 0x01d6 }
            throw r0     // Catch:{ Exception -> 0x01d4 }
        L_0x01d4:
            r0 = move-exception
            goto L_0x01dc
        L_0x01d6:
            r0 = move-exception
            goto L_0x01d2
        L_0x01d8:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01dc:
            r1 = r0
        L_0x01dd:
            r0 = r17
            java.lang.String r2 = r1.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r46)
            int r3 = r3.length()
            int r3 = r3 + 34
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Failed to preload url "
            r4.append(r3)
            r4.append(r6)
            java.lang.String r3 = " Exception: "
            r4.append(r3)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.google.android.gms.ads.internal.util.zzd.zzez(r2)
            r45.release()
            java.lang.String r1 = zzd(r0, r1)
            r5.zza(r6, r7, r0, r1)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbev.zze(java.lang.String, java.lang.String[]):boolean");
    }

    public final void abort() {
        zzfk((String) null);
    }

    private final void zzfk(String str) {
        synchronized (this) {
            this.zzesi = true;
            notify();
            release();
        }
        String str2 = this.zzemj;
        if (str2 != null) {
            String zzfi = zzfi(str2);
            Exception exc = this.zzesm;
            if (exc != null) {
                zza(this.zzemj, zzfi, "badUrl", zzd(str, exc));
            } else {
                zza(this.zzemj, zzfi, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final zzbdn zzadi() {
        synchronized (this) {
            this.zzesn = true;
            notify();
        }
        this.zzesl.zza((zzbdx) null);
        zzbdn zzbdn = this.zzesl;
        this.zzesl = null;
        return zzbdn;
    }

    private static String zzd(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
