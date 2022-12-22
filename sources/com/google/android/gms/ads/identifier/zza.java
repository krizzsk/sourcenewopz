package com.google.android.gms.ads.identifier;

import java.util.Map;

final class zza extends Thread {
    private final /* synthetic */ Map zzl;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzl = map;
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            java.lang.String r0 = ". "
            com.google.android.gms.ads.identifier.zzc r1 = new com.google.android.gms.ads.identifier.zzc
            r1.<init>()
            java.util.Map r1 = r11.zzl
            java.lang.String r2 = "https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps"
            android.net.Uri r2 = android.net.Uri.parse(r2)
            android.net.Uri$Builder r2 = r2.buildUpon()
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x001b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0031
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            r2.appendQueryParameter(r4, r5)
            goto L_0x001b
        L_0x0031:
            android.net.Uri r1 = r2.build()
            java.lang.String r1 = r1.toString()
            java.net.URL r2 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x00c2, IOException -> 0x0088, RuntimeException -> 0x0086 }
            r2.<init>(r1)     // Catch:{ IndexOutOfBoundsException -> 0x00c2, IOException -> 0x0088, RuntimeException -> 0x0086 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x00c2, IOException -> 0x0088, RuntimeException -> 0x0086 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IndexOutOfBoundsException -> 0x00c2, IOException -> 0x0088, RuntimeException -> 0x0086 }
            int r3 = r2.getResponseCode()     // Catch:{ all -> 0x0081 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 < r4) goto L_0x0050
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 < r4) goto L_0x007d
        L_0x0050:
            java.lang.String r6 = "HttpUrlPinger"
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0081 }
            int r4 = r4.length()     // Catch:{ all -> 0x0081 }
            int r4 = r4 + 65
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r5.<init>(r4)     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = "Received non-success response code "
            r5.append(r4)     // Catch:{ all -> 0x0081 }
            r5.append(r3)     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = " from pinging URL: "
            r5.append(r3)     // Catch:{ all -> 0x0081 }
            r5.append(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x0081 }
            r5 = 5
            r8 = 0
            java.lang.String r9 = "com.google.android.gms.ads.identifier.zza"
            r10 = -1
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0081 }
        L_0x007d:
            r2.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x00c2, IOException -> 0x0088, RuntimeException -> 0x0086 }
            return
        L_0x0081:
            r3 = move-exception
            r2.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x00c2, IOException -> 0x0088, RuntimeException -> 0x0086 }
            throw r3     // Catch:{ IndexOutOfBoundsException -> 0x00c2, IOException -> 0x0088, RuntimeException -> 0x0086 }
        L_0x0086:
            r2 = move-exception
            goto L_0x0089
        L_0x0088:
            r2 = move-exception
        L_0x0089:
            r6 = r2
            java.lang.String r2 = r6.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r3 = r3 + 27
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Error while pinging URL: "
        L_0x00a8:
            r4.append(r3)
            r4.append(r1)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r5 = r4.toString()
            r3 = 5
            r8 = -1
            java.lang.String r4 = "HttpUrlPinger"
            java.lang.String r7 = "com.google.android.gms.ads.identifier.zza"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            return
        L_0x00c2:
            r2 = move-exception
            r6 = r2
            java.lang.String r2 = r6.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r3 = r3 + 32
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Error while parsing ping URL: "
            goto L_0x00a8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.zza.run():void");
    }
}
