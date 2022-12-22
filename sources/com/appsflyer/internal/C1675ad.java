package com.appsflyer.internal;

import com.appsflyer.internal.model.event.BackgroundEvent;

/* renamed from: com.appsflyer.internal.ad */
public final class C1675ad implements Runnable {

    /* renamed from: Ι */
    private final BackgroundEvent f1895;

    public C1675ad(BackgroundEvent backgroundEvent) {
        this.f1895 = (BackgroundEvent) backgroundEvent.weakContext();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.net.URLConnection] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a3  */
    /* renamed from: ɩ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection mo16113() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ""
            com.appsflyer.internal.model.event.BackgroundEvent r0 = r1.f1895
            java.lang.String r3 = r0.urlString()
            com.appsflyer.internal.model.event.BackgroundEvent r0 = r1.f1895
            java.lang.String r0 = r0.body()
            com.appsflyer.internal.model.event.BackgroundEvent r4 = r1.f1895
            boolean r4 = r4.trackingStopped()
            com.appsflyer.internal.model.event.BackgroundEvent r5 = r1.f1895
            boolean r5 = r5.readResponse()
            com.appsflyer.internal.model.event.BackgroundEvent r6 = r1.f1895
            boolean r6 = r6.proxyMode()
            com.appsflyer.internal.model.event.BackgroundEvent r7 = r1.f1895
            boolean r7 = r7.isEncrypt()
            byte[] r8 = r0.getBytes()
            r9 = 0
            if (r4 == 0) goto L_0x0030
            return r9
        L_0x0030:
            r4 = 0
            r10 = 1
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x0187 }
            r11.<init>(r3)     // Catch:{ all -> 0x0187 }
            if (r6 == 0) goto L_0x0089
            com.appsflyer.internal.ai r12 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0187 }
            if (r12 != 0) goto L_0x0044
            com.appsflyer.internal.ai r12 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x0187 }
            r12.<init>()     // Catch:{ all -> 0x0187 }
            com.appsflyer.internal.C1683ai.f1911 = r12     // Catch:{ all -> 0x0187 }
        L_0x0044:
            com.appsflyer.internal.ai r12 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0187 }
            java.lang.String r13 = r11.toString()     // Catch:{ all -> 0x0187 }
            java.lang.String r14 = "server_request"
            java.lang.String[] r15 = new java.lang.String[r10]     // Catch:{ all -> 0x0187 }
            r15[r4] = r0     // Catch:{ all -> 0x0187 }
            r12.mo16117(r14, r13, r15)     // Catch:{ all -> 0x0187 }
            java.lang.String r12 = "UTF-8"
            byte[] r12 = r0.getBytes(r12)     // Catch:{ all -> 0x0187 }
            int r12 = r12.length     // Catch:{ all -> 0x0187 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            java.lang.String r14 = "call = "
            r13.<init>(r14)     // Catch:{ all -> 0x0187 }
            r13.append(r11)     // Catch:{ all -> 0x0187 }
            java.lang.String r14 = "; size = "
            r13.append(r14)     // Catch:{ all -> 0x0187 }
            r13.append(r12)     // Catch:{ all -> 0x0187 }
            java.lang.String r14 = " byte"
            r13.append(r14)     // Catch:{ all -> 0x0187 }
            if (r12 <= r10) goto L_0x0076
            java.lang.String r12 = "s"
            goto L_0x0077
        L_0x0076:
            r12 = r2
        L_0x0077:
            r13.append(r12)     // Catch:{ all -> 0x0187 }
            java.lang.String r12 = "; body = "
            r13.append(r12)     // Catch:{ all -> 0x0187 }
            r13.append(r0)     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x0187 }
            com.appsflyer.internal.C1682ah.m1629(r0)     // Catch:{ all -> 0x0187 }
        L_0x0089:
            java.lang.String r0 = "AppsFlyer"
            int r0 = r0.hashCode()     // Catch:{ all -> 0x0187 }
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x0187 }
            java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x0187 }
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x0187 }
            r0 = 30000(0x7530, float:4.2039E-41)
            r12.setReadTimeout(r0)     // Catch:{ all -> 0x0184 }
            r12.setConnectTimeout(r0)     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = "POST"
            r12.setRequestMethod(r0)     // Catch:{ all -> 0x0184 }
            r12.setDoInput(r10)     // Catch:{ all -> 0x0184 }
            r12.setDoOutput(r10)     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = "Content-Type"
            if (r7 == 0) goto L_0x00b3
            java.lang.String r13 = "application/octet-stream"
            goto L_0x00b5
        L_0x00b3:
            java.lang.String r13 = "application/json"
        L_0x00b5:
            r12.setRequestProperty(r0, r13)     // Catch:{ all -> 0x0184 }
            java.io.OutputStream r0 = r12.getOutputStream()     // Catch:{ all -> 0x0184 }
            if (r7 == 0) goto L_0x0112
            com.appsflyer.internal.model.event.BackgroundEvent r7 = r1.f1895     // Catch:{ all -> 0x0184 }
            java.lang.String r7 = r7.key()     // Catch:{ all -> 0x0184 }
            java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ all -> 0x0109 }
            r13[r4] = r7     // Catch:{ all -> 0x0109 }
            r7 = 24
            java.lang.Object r14 = com.appsflyer.internal.C1695d.m1671(r7, r4, r7)     // Catch:{ all -> 0x0109 }
            java.lang.Class r14 = (java.lang.Class) r14     // Catch:{ all -> 0x0109 }
            java.lang.String r15 = "ǃ"
            java.lang.Class[] r7 = new java.lang.Class[r10]     // Catch:{ all -> 0x0109 }
            java.lang.Class<java.lang.String> r16 = java.lang.String.class
            r7[r4] = r16     // Catch:{ all -> 0x0109 }
            java.lang.reflect.Method r7 = r14.getMethod(r15, r7)     // Catch:{ all -> 0x0109 }
            java.lang.Object r7 = r7.invoke(r9, r13)     // Catch:{ all -> 0x0109 }
            java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x0100 }
            r9[r4] = r8     // Catch:{ all -> 0x0100 }
            r8 = 24
            java.lang.Object r8 = com.appsflyer.internal.C1695d.m1671(r8, r4, r8)     // Catch:{ all -> 0x0100 }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x0100 }
            java.lang.String r13 = "ı"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x0100 }
            java.lang.Class<byte[]> r15 = byte[].class
            r14[r4] = r15     // Catch:{ all -> 0x0100 }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r13, r14)     // Catch:{ all -> 0x0100 }
            java.lang.Object r7 = r8.invoke(r7, r9)     // Catch:{ all -> 0x0100 }
            r8 = r7
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0100 }
            goto L_0x0112
        L_0x0100:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0184 }
            if (r4 == 0) goto L_0x0108
            throw r4     // Catch:{ all -> 0x0184 }
        L_0x0108:
            throw r0     // Catch:{ all -> 0x0184 }
        L_0x0109:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0184 }
            if (r4 == 0) goto L_0x0111
            throw r4     // Catch:{ all -> 0x0184 }
        L_0x0111:
            throw r0     // Catch:{ all -> 0x0184 }
        L_0x0112:
            r0.write(r8)     // Catch:{ all -> 0x0184 }
            r0.close()     // Catch:{ all -> 0x0184 }
            r12.connect()     // Catch:{ all -> 0x0184 }
            int r0 = r12.getResponseCode()     // Catch:{ all -> 0x0184 }
            if (r5 == 0) goto L_0x0129
            com.appsflyer.AppsFlyerLibCore r5 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x0184 }
            java.lang.String r2 = r5.mo16025((java.net.HttpURLConnection) r12)     // Catch:{ all -> 0x0184 }
        L_0x0129:
            if (r6 == 0) goto L_0x014c
            com.appsflyer.internal.ai r5 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0184 }
            if (r5 != 0) goto L_0x0136
            com.appsflyer.internal.ai r5 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x0184 }
            r5.<init>()     // Catch:{ all -> 0x0184 }
            com.appsflyer.internal.C1683ai.f1911 = r5     // Catch:{ all -> 0x0184 }
        L_0x0136:
            com.appsflyer.internal.ai r5 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0184 }
            java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x0184 }
            java.lang.String r7 = "server_response"
            r8 = 2
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x0184 }
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0184 }
            r8[r4] = r9     // Catch:{ all -> 0x0184 }
            r8[r10] = r2     // Catch:{ all -> 0x0184 }
            r5.mo16117(r7, r6, r8)     // Catch:{ all -> 0x0184 }
        L_0x014c:
            r5 = 200(0xc8, float:2.8E-43)
            if (r0 != r5) goto L_0x0196
            java.lang.String r0 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0184 }
            com.appsflyer.internal.model.event.BackgroundEvent r0 = r1.f1895     // Catch:{ all -> 0x0184 }
            android.content.Context r0 = r0.context()     // Catch:{ all -> 0x0184 }
            java.lang.String r5 = r11.toString()     // Catch:{ all -> 0x0184 }
            java.lang.String r6 = com.appsflyer.AppsFlyerLibCore.REGISTER_URL     // Catch:{ all -> 0x0184 }
            java.lang.String r6 = com.appsflyer.ServerConfigHandler.getUrl(r6)     // Catch:{ all -> 0x0184 }
            boolean r5 = r5.startsWith(r6)     // Catch:{ all -> 0x0184 }
            if (r5 == 0) goto L_0x0197
            if (r0 == 0) goto L_0x0197
            android.content.SharedPreferences r0 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r0)     // Catch:{ all -> 0x0184 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0184 }
            java.lang.String r5 = "sentRegisterRequestToAF"
            android.content.SharedPreferences$Editor r0 = r0.putBoolean(r5, r10)     // Catch:{ all -> 0x0184 }
            r0.apply()     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = "Successfully registered for Uninstall Tracking"
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x0184 }
            goto L_0x0197
        L_0x0184:
            r0 = move-exception
            r9 = r12
            goto L_0x0188
        L_0x0187:
            r0 = move-exception
        L_0x0188:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.afErrorLog(r3, r0)
            r12 = r9
        L_0x0196:
            r4 = 1
        L_0x0197:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Connection "
            r0.<init>(r3)
            if (r4 == 0) goto L_0x01a3
            java.lang.String r3 = "error"
            goto L_0x01a5
        L_0x01a3:
            java.lang.String r3 = "call succeeded"
        L_0x01a5:
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1675ad.mo16113():java.net.HttpURLConnection");
    }

    public final void run() {
        mo16113();
    }
}
