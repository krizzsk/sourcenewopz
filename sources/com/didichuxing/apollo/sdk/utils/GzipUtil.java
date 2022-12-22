package com.didichuxing.apollo.sdk.utils;

public class GzipUtil {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d A[SYNTHETIC, Splitter:B:14:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decompress(java.io.InputStream r2) throws java.lang.Exception {
        /*
            r0 = 0
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x001a }
            r1.<init>(r2)     // Catch:{ all -> 0x001a }
            java.lang.String r2 = org.apache.commons.p071io.IOUtils.toString((java.io.InputStream) r1)     // Catch:{ all -> 0x0017 }
            r1.close()     // Catch:{ IOException -> 0x000e }
            goto L_0x0016
        L_0x000e:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.didichuxing.apollo.sdk.log.LogUtils.m32690d(r0)
        L_0x0016:
            return r2
        L_0x0017:
            r2 = move-exception
            r0 = r1
            goto L_0x001b
        L_0x001a:
            r2 = move-exception
        L_0x001b:
            if (r0 == 0) goto L_0x0029
            r0.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0029
        L_0x0021:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.didichuxing.apollo.sdk.log.LogUtils.m32690d(r0)
        L_0x0029:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.apollo.sdk.utils.GzipUtil.decompress(java.io.InputStream):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028 A[SYNTHETIC, Splitter:B:14:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compress(byte[] r3) throws java.lang.Exception {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0025 }
            r1.<init>()     // Catch:{ all -> 0x0025 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0025 }
            r2.<init>(r1)     // Catch:{ all -> 0x0025 }
            r2.write(r3)     // Catch:{ all -> 0x0022 }
            r2.finish()     // Catch:{ all -> 0x0022 }
            byte[] r3 = r1.toByteArray()     // Catch:{ all -> 0x0022 }
            r2.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x0021
        L_0x0019:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.didichuxing.apollo.sdk.log.LogUtils.m32690d(r0)
        L_0x0021:
            return r3
        L_0x0022:
            r3 = move-exception
            r0 = r2
            goto L_0x0026
        L_0x0025:
            r3 = move-exception
        L_0x0026:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0034
        L_0x002c:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.didichuxing.apollo.sdk.log.LogUtils.m32690d(r0)
        L_0x0034:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.apollo.sdk.utils.GzipUtil.compress(byte[]):byte[]");
    }
}
