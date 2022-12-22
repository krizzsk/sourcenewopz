package com.didi.global.ninja.utils;

public class Utils {
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0047 A[SYNTHETIC, Splitter:B:32:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0051 A[SYNTHETIC, Splitter:B:37:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005d A[SYNTHETIC, Splitter:B:44:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0067 A[SYNTHETIC, Splitter:B:49:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readAssetFile(android.content.Context r4, java.lang.String r5) {
        /*
            android.content.res.AssetManager r4 = r4.getAssets()
            r0 = 0
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ IOException -> 0x003f, all -> 0x003a }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0037, all -> 0x0032 }
            r5.<init>()     // Catch:{ IOException -> 0x0037, all -> 0x0032 }
        L_0x000e:
            int r1 = r4.read()     // Catch:{ IOException -> 0x0030 }
            r2 = -1
            if (r1 == r2) goto L_0x0019
            r5.write(r1)     // Catch:{ IOException -> 0x0030 }
            goto L_0x000e
        L_0x0019:
            java.lang.String r0 = r5.toString()     // Catch:{ IOException -> 0x0030 }
            r5.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0025:
            if (r4 == 0) goto L_0x002f
            r4.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002f:
            return r0
        L_0x0030:
            r1 = move-exception
            goto L_0x0042
        L_0x0032:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x005b
        L_0x0037:
            r1 = move-exception
            r5 = r0
            goto L_0x0042
        L_0x003a:
            r4 = move-exception
            r5 = r0
            r0 = r4
            r4 = r5
            goto L_0x005b
        L_0x003f:
            r1 = move-exception
            r4 = r0
            r5 = r4
        L_0x0042:
            r1.printStackTrace()     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x004f
            r5.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004f:
            if (r4 == 0) goto L_0x0059
            r4.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0059:
            return r0
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            if (r5 == 0) goto L_0x0065
            r5.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0065:
            if (r4 == 0) goto L_0x006f
            r4.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.ninja.utils.Utils.readAssetFile(android.content.Context, java.lang.String):java.lang.String");
    }
}
