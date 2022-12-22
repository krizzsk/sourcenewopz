package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcqq implements zzdsr<zzcqt, zzcqs> {
    private final Context context;
    private final String zzdwh;
    private final zzauw zzgrz;
    private final String zzgsl;
    private final int zzgsm;

    public zzcqq(Context context2, String str, zzauw zzauw, String str2, int i) {
        this.context = context2;
        this.zzgsl = str;
        this.zzgrz = zzauw;
        this.zzdwh = str2;
        this.zzgsm = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r2 = new java.io.InputStreamReader(r14.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        com.google.android.gms.ads.internal.zzr.zzkv();
        r0 = com.google.android.gms.ads.internal.util.zzj.zza(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r11.zzeu(r0);
        r6.zzdxg = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b8, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ca, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcxf)).booleanValue() == false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d4, code lost:
        throw new com.google.android.gms.internal.ads.zzcnp(com.google.android.gms.internal.ads.zzdqj.NO_FILL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d5, code lost:
        r6.zzgss = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r14.disconnect();
        r1.zzgrz.zzxf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01e9, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ea, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01eb, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0290 A[Catch:{ all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02a5 A[SYNTHETIC, Splitter:B:128:0x02a5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzcqs zza(java.lang.String r21, com.google.android.gms.internal.ads.zzaup r22, org.json.JSONObject r23, java.lang.String r24) throws com.google.android.gms.internal.ads.zzcnp {
        /*
            r20 = this;
            r1 = r20
            r0 = r23
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.String r3 = "doritos_v2"
            java.lang.String r4 = "doritos"
            java.lang.String r5 = "http_timeout_millis"
            r6 = 60000(0xea60, float:8.4078E-41)
            int r5 = r0.optInt(r5, r6)     // Catch:{ IOException -> 0x02b0 }
            int r6 = r22.getErrorCode()     // Catch:{ IOException -> 0x02b0 }
            r7 = -2
            r14 = 1
            if (r6 == r7) goto L_0x0046
            int r0 = r22.getErrorCode()     // Catch:{ IOException -> 0x02b0 }
            if (r0 != r14) goto L_0x003e
            java.util.List r0 = r22.zzww()     // Catch:{ IOException -> 0x02b0 }
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = ", "
            java.util.List r2 = r22.zzww()     // Catch:{ IOException -> 0x02b0 }
            java.lang.String r0 = android.text.TextUtils.join(r0, r2)     // Catch:{ IOException -> 0x02b0 }
            com.google.android.gms.ads.internal.util.zzd.zzex(r0)     // Catch:{ IOException -> 0x02b0 }
        L_0x0034:
            com.google.android.gms.internal.ads.zzcnp r0 = new com.google.android.gms.internal.ads.zzcnp     // Catch:{ IOException -> 0x02b0 }
            com.google.android.gms.internal.ads.zzdqj r2 = com.google.android.gms.internal.ads.zzdqj.INVALID_REQUEST     // Catch:{ IOException -> 0x02b0 }
            java.lang.String r3 = "Error building request URL."
            r0.<init>(r2, r3)     // Catch:{ IOException -> 0x02b0 }
            throw r0     // Catch:{ IOException -> 0x02b0 }
        L_0x003e:
            com.google.android.gms.internal.ads.zzcnp r0 = new com.google.android.gms.internal.ads.zzcnp     // Catch:{ IOException -> 0x02b0 }
            com.google.android.gms.internal.ads.zzdqj r2 = com.google.android.gms.internal.ads.zzdqj.INTERNAL_ERROR     // Catch:{ IOException -> 0x02b0 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x02b0 }
            throw r0     // Catch:{ IOException -> 0x02b0 }
        L_0x0046:
            com.google.android.gms.internal.ads.zzcqs r6 = new com.google.android.gms.internal.ads.zzcqs     // Catch:{ IOException -> 0x02b0 }
            r6.<init>()     // Catch:{ IOException -> 0x02b0 }
            java.lang.String r7 = "SDK version: "
            java.lang.String r8 = r1.zzgsl     // Catch:{ IOException -> 0x02b0 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x02b0 }
            int r9 = r8.length()     // Catch:{ IOException -> 0x02b0 }
            if (r9 == 0) goto L_0x005e
            java.lang.String r7 = r7.concat(r8)     // Catch:{ IOException -> 0x02b0 }
            goto L_0x0064
        L_0x005e:
            java.lang.String r8 = new java.lang.String     // Catch:{ IOException -> 0x02b0 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x02b0 }
            r7 = r8
        L_0x0064:
            com.google.android.gms.ads.internal.util.zzd.zzey(r7)     // Catch:{ IOException -> 0x02b0 }
            java.lang.String r7 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r8 = java.lang.String.valueOf(r21)     // Catch:{ IOException -> 0x02b0 }
            int r9 = r8.length()     // Catch:{ IOException -> 0x02b0 }
            if (r9 == 0) goto L_0x0078
            java.lang.String r7 = r7.concat(r8)     // Catch:{ IOException -> 0x02b0 }
            goto L_0x007e
        L_0x0078:
            java.lang.String r8 = new java.lang.String     // Catch:{ IOException -> 0x02b0 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x02b0 }
            r7 = r8
        L_0x007e:
            com.google.android.gms.ads.internal.util.zzd.zzdz(r7)     // Catch:{ IOException -> 0x02b0 }
            java.net.URL r7 = new java.net.URL     // Catch:{ IOException -> 0x02b0 }
            r8 = r21
            r7.<init>(r8)     // Catch:{ IOException -> 0x02b0 }
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ IOException -> 0x02b0 }
            r15.<init>()     // Catch:{ IOException -> 0x02b0 }
            r8 = 0
            com.google.android.gms.common.util.Clock r9 = com.google.android.gms.ads.internal.zzr.zzlc()     // Catch:{ IOException -> 0x02b0 }
            long r16 = r9.elapsedRealtime()     // Catch:{ IOException -> 0x02b0 }
            r18 = 0
        L_0x0098:
            com.google.android.gms.internal.ads.zzauw r8 = r1.zzgrz     // Catch:{ IOException -> 0x02b0 }
            int r9 = r1.zzgsm     // Catch:{ IOException -> 0x02b0 }
            r8.zzdf(r9)     // Catch:{ IOException -> 0x02b0 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ IOException -> 0x02b0 }
            r13 = r7
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x02b0 }
            com.google.android.gms.ads.internal.util.zzj r7 = com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ zzcnp -> 0x027c, all -> 0x0279 }
            android.content.Context r8 = r1.context     // Catch:{ zzcnp -> 0x027c, all -> 0x0279 }
            java.lang.String r9 = r1.zzgsl     // Catch:{ zzcnp -> 0x027c, all -> 0x0279 }
            r10 = 0
            r12 = 0
            r11 = r13
            r14 = r13
            r13 = r5
            r7.zza(r8, r9, r10, r11, r12, r13)     // Catch:{ zzcnp -> 0x0277 }
            boolean r7 = r22.zzxa()     // Catch:{ zzcnp -> 0x0277 }
            if (r7 == 0) goto L_0x00ca
            boolean r7 = android.text.TextUtils.isEmpty(r24)     // Catch:{ zzcnp -> 0x0277 }
            if (r7 != 0) goto L_0x00ca
            java.lang.String r7 = "Cookie"
            r8 = r24
            r14.addRequestProperty(r7, r8)     // Catch:{ zzcnp -> 0x0277 }
            goto L_0x00cc
        L_0x00ca:
            r8 = r24
        L_0x00cc:
            boolean r7 = r22.zzwz()     // Catch:{ zzcnp -> 0x0277 }
            java.lang.String r9 = ""
            if (r7 == 0) goto L_0x0108
            java.lang.String r7 = "pii"
            org.json.JSONObject r7 = r0.optJSONObject(r7)     // Catch:{ zzcnp -> 0x0277 }
            if (r7 == 0) goto L_0x0103
            java.lang.String r10 = r7.optString(r4, r9)     // Catch:{ zzcnp -> 0x0277 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ zzcnp -> 0x0277 }
            if (r10 != 0) goto L_0x00ef
            java.lang.String r10 = "x-afma-drt-cookie"
            java.lang.String r11 = r7.optString(r4, r9)     // Catch:{ zzcnp -> 0x0277 }
            r14.addRequestProperty(r10, r11)     // Catch:{ zzcnp -> 0x0277 }
        L_0x00ef:
            java.lang.String r10 = r7.optString(r3, r9)     // Catch:{ zzcnp -> 0x0277 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ zzcnp -> 0x0277 }
            if (r10 != 0) goto L_0x0108
            java.lang.String r10 = "x-afma-drt-v2-cookie"
            java.lang.String r7 = r7.optString(r3, r9)     // Catch:{ zzcnp -> 0x0277 }
            r14.addRequestProperty(r10, r7)     // Catch:{ zzcnp -> 0x0277 }
            goto L_0x0108
        L_0x0103:
            java.lang.String r7 = "DSID signal does not exist."
            com.google.android.gms.ads.internal.util.zzd.zzed(r7)     // Catch:{ zzcnp -> 0x0277 }
        L_0x0108:
            if (r22 == 0) goto L_0x013d
            java.lang.String r10 = r22.zzwy()     // Catch:{ zzcnp -> 0x0277 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ zzcnp -> 0x0277 }
            if (r10 != 0) goto L_0x013d
            r10 = 1
            r14.setDoOutput(r10)     // Catch:{ zzcnp -> 0x0277 }
            java.lang.String r10 = r22.zzwy()     // Catch:{ zzcnp -> 0x0277 }
            byte[] r10 = r10.getBytes()     // Catch:{ zzcnp -> 0x0277 }
            int r11 = r10.length     // Catch:{ zzcnp -> 0x0277 }
            r14.setFixedLengthStreamingMode(r11)     // Catch:{ zzcnp -> 0x0277 }
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0137 }
            java.io.OutputStream r12 = r14.getOutputStream()     // Catch:{ all -> 0x0137 }
            r11.<init>(r12)     // Catch:{ all -> 0x0137 }
            r11.write(r10)     // Catch:{ all -> 0x0134 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r11)     // Catch:{ zzcnp -> 0x0277 }
            goto L_0x013e
        L_0x0134:
            r0 = move-exception
            r7 = r11
            goto L_0x0139
        L_0x0137:
            r0 = move-exception
            r7 = 0
        L_0x0139:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ zzcnp -> 0x0277 }
            throw r0     // Catch:{ zzcnp -> 0x0277 }
        L_0x013d:
            r10 = 0
        L_0x013e:
            com.google.android.gms.internal.ads.zzbai r11 = new com.google.android.gms.internal.ads.zzbai     // Catch:{ zzcnp -> 0x0277 }
            r11.<init>()     // Catch:{ zzcnp -> 0x0277 }
            r11.zza((java.net.HttpURLConnection) r14, (byte[]) r10)     // Catch:{ zzcnp -> 0x0277 }
            int r10 = r14.getResponseCode()     // Catch:{ zzcnp -> 0x0277 }
            java.util.Map r12 = r14.getHeaderFields()     // Catch:{ zzcnp -> 0x0277 }
            java.util.Set r12 = r12.entrySet()     // Catch:{ zzcnp -> 0x0277 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ zzcnp -> 0x0277 }
        L_0x0156:
            boolean r13 = r12.hasNext()     // Catch:{ zzcnp -> 0x0277 }
            if (r13 == 0) goto L_0x018b
            java.lang.Object r13 = r12.next()     // Catch:{ zzcnp -> 0x0277 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ zzcnp -> 0x0277 }
            java.lang.Object r19 = r13.getKey()     // Catch:{ zzcnp -> 0x0277 }
            r7 = r19
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ zzcnp -> 0x0277 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ zzcnp -> 0x0277 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ zzcnp -> 0x0277 }
            boolean r19 = r15.containsKey(r7)     // Catch:{ zzcnp -> 0x0277 }
            if (r19 == 0) goto L_0x0180
            java.lang.Object r7 = r15.get(r7)     // Catch:{ zzcnp -> 0x0277 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ zzcnp -> 0x0277 }
            r7.addAll(r13)     // Catch:{ zzcnp -> 0x0277 }
            goto L_0x0156
        L_0x0180:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ zzcnp -> 0x0277 }
            r0.<init>(r13)     // Catch:{ zzcnp -> 0x0277 }
            r15.put(r7, r0)     // Catch:{ zzcnp -> 0x0277 }
            r0 = r23
            goto L_0x0156
        L_0x018b:
            r11.zza((java.net.HttpURLConnection) r14, (int) r10)     // Catch:{ zzcnp -> 0x0277 }
            r6.zzgsr = r10     // Catch:{ zzcnp -> 0x0277 }
            r6.zzaj = r15     // Catch:{ zzcnp -> 0x0277 }
            r6.zzdxg = r9     // Catch:{ zzcnp -> 0x0277 }
            r0 = 200(0xc8, float:2.8E-43)
            r7 = 300(0x12c, float:4.2E-43)
            if (r10 < r0) goto L_0x01f3
            if (r10 >= r7) goto L_0x01f3
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x01ed }
            java.io.InputStream r0 = r14.getInputStream()     // Catch:{ all -> 0x01ed }
            r2.<init>(r0)     // Catch:{ all -> 0x01ed }
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x01ea }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzj.zza((java.io.InputStreamReader) r2)     // Catch:{ all -> 0x01ea }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzcnp -> 0x0277 }
            r11.zzeu(r0)     // Catch:{ zzcnp -> 0x0277 }
            r6.zzdxg = r0     // Catch:{ zzcnp -> 0x0277 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzcnp -> 0x0277 }
            if (r0 == 0) goto L_0x01d5
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcxf     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ zzcnp -> 0x0277 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ zzcnp -> 0x0277 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzcnp -> 0x0277 }
            boolean r0 = r0.booleanValue()     // Catch:{ zzcnp -> 0x0277 }
            if (r0 == 0) goto L_0x01cd
            goto L_0x01d5
        L_0x01cd:
            com.google.android.gms.internal.ads.zzcnp r0 = new com.google.android.gms.internal.ads.zzcnp     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzdqj r2 = com.google.android.gms.internal.ads.zzdqj.NO_FILL     // Catch:{ zzcnp -> 0x0277 }
            r0.<init>(r2)     // Catch:{ zzcnp -> 0x0277 }
            throw r0     // Catch:{ zzcnp -> 0x0277 }
        L_0x01d5:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzr.zzlc()     // Catch:{ zzcnp -> 0x0277 }
            long r2 = r0.elapsedRealtime()     // Catch:{ zzcnp -> 0x0277 }
            long r2 = r2 - r16
            r6.zzgss = r2     // Catch:{ zzcnp -> 0x0277 }
            r14.disconnect()     // Catch:{ IOException -> 0x02b0 }
            com.google.android.gms.internal.ads.zzauw r0 = r1.zzgrz     // Catch:{ IOException -> 0x02b0 }
            r0.zzxf()     // Catch:{ IOException -> 0x02b0 }
            return r6
        L_0x01ea:
            r0 = move-exception
            r7 = r2
            goto L_0x01ef
        L_0x01ed:
            r0 = move-exception
            r7 = 0
        L_0x01ef:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ zzcnp -> 0x0277 }
            throw r0     // Catch:{ zzcnp -> 0x0277 }
        L_0x01f3:
            if (r10 < r7) goto L_0x024c
            r0 = 400(0x190, float:5.6E-43)
            if (r10 >= r0) goto L_0x024c
            java.lang.String r0 = "Location"
            java.lang.String r0 = r14.getHeaderField(r0)     // Catch:{ zzcnp -> 0x0277 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzcnp -> 0x0277 }
            if (r7 != 0) goto L_0x023d
            java.net.URL r7 = new java.net.URL     // Catch:{ zzcnp -> 0x0277 }
            r7.<init>(r0)     // Catch:{ zzcnp -> 0x0277 }
            r0 = 1
            int r9 = r18 + 1
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r10 = com.google.android.gms.internal.ads.zzabq.zzcwg     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzabm r11 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ zzcnp -> 0x0277 }
            java.lang.Object r10 = r11.zzd(r10)     // Catch:{ zzcnp -> 0x0277 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ zzcnp -> 0x0277 }
            int r10 = r10.intValue()     // Catch:{ zzcnp -> 0x0277 }
            if (r9 > r10) goto L_0x022e
            r14.disconnect()     // Catch:{ IOException -> 0x02b0 }
            com.google.android.gms.internal.ads.zzauw r10 = r1.zzgrz     // Catch:{ IOException -> 0x02b0 }
            r10.zzxf()     // Catch:{ IOException -> 0x02b0 }
            r0 = r23
            r18 = r9
            r14 = 1
            goto L_0x0098
        L_0x022e:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzcnp r0 = new com.google.android.gms.internal.ads.zzcnp     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzdqj r2 = com.google.android.gms.internal.ads.zzdqj.INTERNAL_ERROR     // Catch:{ zzcnp -> 0x0277 }
            java.lang.String r3 = "Too many redirects"
            r0.<init>(r2, r3)     // Catch:{ zzcnp -> 0x0277 }
            throw r0     // Catch:{ zzcnp -> 0x0277 }
        L_0x023d:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzcnp r0 = new com.google.android.gms.internal.ads.zzcnp     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzdqj r2 = com.google.android.gms.internal.ads.zzdqj.INTERNAL_ERROR     // Catch:{ zzcnp -> 0x0277 }
            java.lang.String r3 = "No location header to follow redirect"
            r0.<init>(r2, r3)     // Catch:{ zzcnp -> 0x0277 }
            throw r0     // Catch:{ zzcnp -> 0x0277 }
        L_0x024c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ zzcnp -> 0x0277 }
            r3 = 46
            r0.<init>(r3)     // Catch:{ zzcnp -> 0x0277 }
            r0.append(r2)     // Catch:{ zzcnp -> 0x0277 }
            r0.append(r10)     // Catch:{ zzcnp -> 0x0277 }
            java.lang.String r0 = r0.toString()     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzcnp r0 = new com.google.android.gms.internal.ads.zzcnp     // Catch:{ zzcnp -> 0x0277 }
            com.google.android.gms.internal.ads.zzdqj r4 = com.google.android.gms.internal.ads.zzdqj.INTERNAL_ERROR     // Catch:{ zzcnp -> 0x0277 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ zzcnp -> 0x0277 }
            r5.<init>(r3)     // Catch:{ zzcnp -> 0x0277 }
            r5.append(r2)     // Catch:{ zzcnp -> 0x0277 }
            r5.append(r10)     // Catch:{ zzcnp -> 0x0277 }
            java.lang.String r2 = r5.toString()     // Catch:{ zzcnp -> 0x0277 }
            r0.<init>(r4, r2)     // Catch:{ zzcnp -> 0x0277 }
            throw r0     // Catch:{ zzcnp -> 0x0277 }
        L_0x0277:
            r0 = move-exception
            goto L_0x027e
        L_0x0279:
            r0 = move-exception
            r14 = r13
            goto L_0x02a7
        L_0x027c:
            r0 = move-exception
            r14 = r13
        L_0x027e:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabq.zzdba     // Catch:{ all -> 0x02a6 }
            com.google.android.gms.internal.ads.zzabm r3 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x02a6 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ all -> 0x02a6 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x02a6 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x02a6 }
            if (r2 == 0) goto L_0x02a5
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzr.zzlc()     // Catch:{ all -> 0x02a6 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x02a6 }
            long r2 = r2 - r16
            r6.zzgss = r2     // Catch:{ all -> 0x02a6 }
            r14.disconnect()     // Catch:{ IOException -> 0x02b0 }
            com.google.android.gms.internal.ads.zzauw r0 = r1.zzgrz     // Catch:{ IOException -> 0x02b0 }
            r0.zzxf()     // Catch:{ IOException -> 0x02b0 }
            return r6
        L_0x02a5:
            throw r0     // Catch:{ all -> 0x02a6 }
        L_0x02a6:
            r0 = move-exception
        L_0x02a7:
            r14.disconnect()     // Catch:{ IOException -> 0x02b0 }
            com.google.android.gms.internal.ads.zzauw r2 = r1.zzgrz     // Catch:{ IOException -> 0x02b0 }
            r2.zzxf()     // Catch:{ IOException -> 0x02b0 }
            throw r0     // Catch:{ IOException -> 0x02b0 }
        L_0x02b0:
            r0 = move-exception
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.String r3 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x02c6
            java.lang.String r2 = r2.concat(r3)
            goto L_0x02cc
        L_0x02c6:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x02cc:
            com.google.android.gms.ads.internal.util.zzd.zzez(r2)
            com.google.android.gms.internal.ads.zzcnp r3 = new com.google.android.gms.internal.ads.zzcnp
            com.google.android.gms.internal.ads.zzdqj r4 = com.google.android.gms.internal.ads.zzdqj.INTERNAL_ERROR
            r3.<init>(r4, r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqq.zza(java.lang.String, com.google.android.gms.internal.ads.zzaup, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzcqs");
    }

    public final /* synthetic */ Object apply(Object obj) throws Exception {
        zzcqt zzcqt = (zzcqt) obj;
        return zza(zzcqt.zzgsg.getUrl(), zzcqt.zzgsg, zzcqt.zzgsh, this.zzdwh);
    }
}
