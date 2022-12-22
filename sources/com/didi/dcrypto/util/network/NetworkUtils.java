package com.didi.dcrypto.util.network;

public class NetworkUtils {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f A[SYNTHETIC, Splitter:B:20:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0039 A[SYNTHETIC, Splitter:B:26:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004d A[SYNTHETIC, Splitter:B:35:0x004d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0034=Splitter:B:23:0x0034, B:17:0x002a=Splitter:B:17:0x002a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readStream(java.io.InputStream r4) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0033, Exception -> 0x0029 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0033, Exception -> 0x0029 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0033, Exception -> 0x0029 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0033, Exception -> 0x0029 }
        L_0x0010:
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0024, Exception -> 0x0021, all -> 0x001e }
            if (r4 == 0) goto L_0x001a
            r0.append(r4)     // Catch:{ IOException -> 0x0024, Exception -> 0x0021, all -> 0x001e }
            goto L_0x0010
        L_0x001a:
            r2.close()     // Catch:{ IOException -> 0x0042, Exception -> 0x003d }
            goto L_0x0046
        L_0x001e:
            r4 = move-exception
            r1 = r2
            goto L_0x004b
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x002a
        L_0x0024:
            r4 = move-exception
            r1 = r2
            goto L_0x0034
        L_0x0027:
            r4 = move-exception
            goto L_0x004b
        L_0x0029:
            r4 = move-exception
        L_0x002a:
            r4.printStackTrace()     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ IOException -> 0x0042, Exception -> 0x003d }
            goto L_0x0046
        L_0x0033:
            r4 = move-exception
        L_0x0034:
            r4.printStackTrace()     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ IOException -> 0x0042, Exception -> 0x003d }
            goto L_0x0046
        L_0x003d:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0046:
            java.lang.String r4 = r0.toString()
            return r4
        L_0x004b:
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ IOException -> 0x0056, Exception -> 0x0051 }
            goto L_0x005a
        L_0x0051:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x005a
        L_0x0056:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dcrypto.util.network.NetworkUtils.readStream(java.io.InputStream):java.lang.String");
    }
}
