package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbew extends zzbek implements zzpd<zzon> {
    private String url;
    private ByteBuffer zzamu;
    private final String zzbwe;
    private final int zzbwf;
    private final zzbcp zzepi;
    private boolean zzesi;
    private final zzbet zzeso = new zzbet();
    private final zzbec zzesp = new zzbec();
    private boolean zzesq;
    private final Object zzesr = new Object();
    private boolean zzess;

    public zzbew(zzbcs zzbcs, zzbcp zzbcp) {
        super(zzbcs);
        this.zzepi = zzbcp;
        this.zzbwe = zzbcs != null ? zzbcs.zzabz() : "";
        this.zzbwf = zzbcs != null ? zzbcs.zzaca() : 0;
    }

    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zzadj() {
        return this.zzess;
    }

    /* access modifiers changed from: protected */
    public final String zzfi(String str) {
        String valueOf = String.valueOf(super.zzfi(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    private final void zzabl() {
        int zzadh = (int) this.zzeso.zzadh();
        int zzq = (int) this.zzesp.zzq(this.zzamu);
        int position = this.zzamu.position();
        int round = Math.round(((float) zzq) * (((float) position) / ((float) zzadh)));
        boolean z = round > 0;
        int zzade = zzbdn.zzade();
        int zzadf = zzbdn.zzadf();
        String str = this.url;
        zza(str, zzfi(str), position, zzadh, (long) round, (long) zzq, z, zzade, zzadf);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.google.android.gms.internal.ads.zzou} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.internal.ads.zzou} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: com.google.android.gms.internal.ads.zzbdj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.google.android.gms.internal.ads.zzou} */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c9, code lost:
        if (r9.zzamu.remaining() > 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        zzabl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d2, code lost:
        if (r9.zzesi != false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d4, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dc, code lost:
        if ((r12 - r16) < r4) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00de, code lost:
        zzabl();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ea, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0111, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0112, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1 = r9.zzamu.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0137, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013e, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfh(java.lang.String r22) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            r9.url = r10
            java.lang.String r11 = r21.zzfi(r22)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zzou r0 = new com.google.android.gms.internal.ads.zzou     // Catch:{ Exception -> 0x0143 }
            java.lang.String r2 = r9.zzeiz     // Catch:{ Exception -> 0x0143 }
            r3 = 0
            com.google.android.gms.internal.ads.zzbcp r1 = r9.zzepi     // Catch:{ Exception -> 0x0143 }
            int r5 = r1.zzenk     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzbcp r1 = r9.zzepi     // Catch:{ Exception -> 0x0143 }
            int r6 = r1.zzenm     // Catch:{ Exception -> 0x0143 }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzbcp r1 = r9.zzepi     // Catch:{ Exception -> 0x0143 }
            boolean r1 = r1.zzenq     // Catch:{ Exception -> 0x0143 }
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzbdj r8 = new com.google.android.gms.internal.ads.zzbdj     // Catch:{ Exception -> 0x0039 }
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0039 }
            java.lang.String r4 = r9.zzbwe     // Catch:{ Exception -> 0x0039 }
            int r5 = r9.zzbwf     // Catch:{ Exception -> 0x0039 }
            r6 = 0
            r7 = 0
            r1 = r8
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0039 }
            r0 = r8
            goto L_0x003c
        L_0x0039:
            r0 = move-exception
            goto L_0x0146
        L_0x003c:
            android.net.Uri r1 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzos r2 = new com.google.android.gms.internal.ads.zzos     // Catch:{ Exception -> 0x0143 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0143 }
            r0.zza(r2)     // Catch:{ Exception -> 0x0143 }
            java.lang.ref.WeakReference r1 = r9.zzerx     // Catch:{ Exception -> 0x0143 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzbcs r1 = (com.google.android.gms.internal.ads.zzbcs) r1     // Catch:{ Exception -> 0x0143 }
            if (r1 == 0) goto L_0x0055
            r1.zza((java.lang.String) r11, (com.google.android.gms.internal.ads.zzbek) r9)     // Catch:{ Exception -> 0x0039 }
        L_0x0055:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzr.zzlc()     // Catch:{ Exception -> 0x0143 }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzabq.zzcnm     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzabm r5 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ Exception -> 0x0143 }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ Exception -> 0x0143 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0143 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzabq.zzcnl     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzabm r7 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ Exception -> 0x0143 }
            java.lang.Object r6 = r7.zzd(r6)     // Catch:{ Exception -> 0x0143 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0143 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzbcp r8 = r9.zzepi     // Catch:{ Exception -> 0x0143 }
            int r8 = r8.zzenj     // Catch:{ Exception -> 0x0143 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0143 }
            r9.zzamu = r8     // Catch:{ Exception -> 0x0143 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x0143 }
            r16 = r2
        L_0x008d:
            java.nio.ByteBuffer r14 = r9.zzamu     // Catch:{ Exception -> 0x0143 }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x0143 }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x0143 }
            int r14 = r0.read(r15, r13, r14)     // Catch:{ Exception -> 0x0143 }
            r8 = -1
            if (r14 != r8) goto L_0x00b0
            r8 = 1
            r9.zzess = r8     // Catch:{ Exception -> 0x0039 }
            com.google.android.gms.internal.ads.zzbec r0 = r9.zzesp     // Catch:{ Exception -> 0x0039 }
            java.nio.ByteBuffer r1 = r9.zzamu     // Catch:{ Exception -> 0x0039 }
            long r0 = r0.zzq(r1)     // Catch:{ Exception -> 0x0039 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0039 }
            long r0 = (long) r1     // Catch:{ Exception -> 0x0039 }
            r9.zzc(r10, r11, r0)     // Catch:{ Exception -> 0x0039 }
        L_0x00ae:
            r1 = 1
            goto L_0x00cf
        L_0x00b0:
            java.lang.Object r8 = r9.zzesr     // Catch:{ Exception -> 0x0143 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x0143 }
            boolean r13 = r9.zzesi     // Catch:{ all -> 0x0138 }
            if (r13 != 0) goto L_0x00c0
            java.nio.ByteBuffer r13 = r9.zzamu     // Catch:{ all -> 0x0138 }
            r18 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x0141 }
            goto L_0x00c2
        L_0x00c0:
            r18 = r12
        L_0x00c2:
            monitor-exit(r8)     // Catch:{ all -> 0x0141 }
            java.nio.ByteBuffer r8 = r9.zzamu     // Catch:{ Exception -> 0x013d }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x013d }
            if (r8 > 0) goto L_0x00d0
            r21.zzabl()     // Catch:{ Exception -> 0x013d }
            goto L_0x00ae
        L_0x00cf:
            return r1
        L_0x00d0:
            boolean r8 = r9.zzesi     // Catch:{ Exception -> 0x013d }
            if (r8 != 0) goto L_0x0112
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x013d }
            long r19 = r12 - r16
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00e3
            r21.zzabl()     // Catch:{ Exception -> 0x013d }
            r16 = r12
        L_0x00e3:
            long r12 = r12 - r2
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r6
            int r8 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r8 > 0) goto L_0x00f2
            r12 = r18
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x008d
        L_0x00f2:
            java.lang.String r12 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r1.append(r0)     // Catch:{ Exception -> 0x0039 }
            r1.append(r6)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0039 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0039 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0039 }
            throw r1     // Catch:{ Exception -> 0x0039 }
        L_0x0112:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0039 }
            java.nio.ByteBuffer r1 = r9.zzamu     // Catch:{ Exception -> 0x0039 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0039 }
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = "Precache abort at "
            r3.append(r2)     // Catch:{ Exception -> 0x0039 }
            r3.append(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = " bytes"
            r3.append(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0039 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0039 }
            throw r0     // Catch:{ Exception -> 0x0039 }
        L_0x0138:
            r0 = move-exception
            r18 = r12
        L_0x013b:
            monitor-exit(r8)     // Catch:{ all -> 0x0141 }
            throw r0     // Catch:{ Exception -> 0x013d }
        L_0x013d:
            r0 = move-exception
            r12 = r18
            goto L_0x0146
        L_0x0141:
            r0 = move-exception
            goto L_0x013b
        L_0x0143:
            r0 = move-exception
            r18 = r12
        L_0x0146:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = java.lang.String.valueOf(r22)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.zzez(r1)
            r9.zza(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbew.zzfh(java.lang.String):boolean");
    }

    public final void abort() {
        this.zzesi = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzesr) {
            if (this.zzamu != null && !this.zzesq) {
                this.zzamu.flip();
                this.zzesq = true;
            }
            this.zzesi = true;
        }
        return this.zzamu;
    }

    public final /* synthetic */ void zza(Object obj, zzos zzos) {
        zzon zzon = (zzon) obj;
        if (zzon instanceof zzou) {
            this.zzeso.zza((zzou) zzon);
        }
    }
}
