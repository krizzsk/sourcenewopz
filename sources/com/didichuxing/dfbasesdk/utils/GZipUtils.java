package com.didichuxing.dfbasesdk.utils;

public class GZipUtils {

    /* renamed from: a */
    private static final int f46735a = 1024;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|4|5|6|7|8|9|(2:10|(1:12)(1:45))|13|14|15|16|17|18|19|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0033 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004c A[SYNTHETIC, Splitter:B:32:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0053 A[SYNTHETIC, Splitter:B:36:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x005a A[SYNTHETIC, Splitter:B:40:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compress(byte[] r8) throws java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0045 }
            r1.<init>(r8)     // Catch:{ all -> 0x0045 }
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0042 }
            r8.<init>()     // Catch:{ all -> 0x0042 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x003d }
            r2.<init>(r8)     // Catch:{ all -> 0x003d }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r0]     // Catch:{ all -> 0x003b }
        L_0x0014:
            r4 = 0
            int r5 = r1.read(r3, r4, r0)     // Catch:{ all -> 0x003b }
            r6 = -1
            if (r5 == r6) goto L_0x0020
            r2.write(r3, r4, r5)     // Catch:{ all -> 0x003b }
            goto L_0x0014
        L_0x0020:
            r2.flush()     // Catch:{ all -> 0x003b }
            r2.finish()     // Catch:{ all -> 0x003b }
            byte[] r0 = r8.toByteArray()     // Catch:{ all -> 0x003b }
            r8.flush()     // Catch:{ all -> 0x003b }
            r2.close()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r8.close()     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r1.close()     // Catch:{ all -> 0x0037 }
            goto L_0x003a
        L_0x0037:
            r1.close()
        L_0x003a:
            return r0
        L_0x003b:
            r0 = move-exception
            goto L_0x004a
        L_0x003d:
            r2 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x004a
        L_0x0042:
            r8 = move-exception
            r2 = r0
            goto L_0x0048
        L_0x0045:
            r8 = move-exception
            r1 = r0
            r2 = r1
        L_0x0048:
            r0 = r8
            r8 = r2
        L_0x004a:
            if (r2 == 0) goto L_0x0051
            r2.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0051
        L_0x0050:
        L_0x0051:
            if (r8 == 0) goto L_0x0058
            r8.close()     // Catch:{ all -> 0x0057 }
            goto L_0x0058
        L_0x0057:
        L_0x0058:
            if (r1 == 0) goto L_0x0061
            r1.close()     // Catch:{ all -> 0x005e }
            goto L_0x0061
        L_0x005e:
            r1.close()
        L_0x0061:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.GZipUtils.compress(byte[]):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:8|9|(2:10|(1:12)(1:43))|13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0042 A[SYNTHETIC, Splitter:B:31:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0049 A[SYNTHETIC, Splitter:B:35:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0050 A[SYNTHETIC, Splitter:B:39:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decompress(byte[] r8) throws java.lang.Exception {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x003b }
            r1.<init>(r8)     // Catch:{ all -> 0x003b }
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0038 }
            r8.<init>()     // Catch:{ all -> 0x0038 }
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0033 }
            r2.<init>(r1)     // Catch:{ all -> 0x0033 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r0]     // Catch:{ all -> 0x0031 }
        L_0x0014:
            r4 = 0
            int r5 = r2.read(r3, r4, r0)     // Catch:{ all -> 0x0031 }
            r6 = -1
            if (r5 == r6) goto L_0x0020
            r8.write(r3, r4, r5)     // Catch:{ all -> 0x0031 }
            goto L_0x0014
        L_0x0020:
            byte[] r0 = r8.toByteArray()     // Catch:{ all -> 0x0031 }
            r8.flush()     // Catch:{ all -> 0x0031 }
            r8.close()     // Catch:{ all -> 0x002a }
        L_0x002a:
            r2.close()     // Catch:{ all -> 0x002d }
        L_0x002d:
            r1.close()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            return r0
        L_0x0031:
            r0 = move-exception
            goto L_0x0040
        L_0x0033:
            r2 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x0040
        L_0x0038:
            r8 = move-exception
            r2 = r0
            goto L_0x003e
        L_0x003b:
            r8 = move-exception
            r1 = r0
            r2 = r1
        L_0x003e:
            r0 = r8
            r8 = r2
        L_0x0040:
            if (r8 == 0) goto L_0x0047
            r8.close()     // Catch:{ all -> 0x0046 }
            goto L_0x0047
        L_0x0046:
        L_0x0047:
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ all -> 0x004d }
            goto L_0x004e
        L_0x004d:
        L_0x004e:
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ all -> 0x0053 }
        L_0x0053:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.GZipUtils.decompress(byte[]):byte[]");
    }
}
