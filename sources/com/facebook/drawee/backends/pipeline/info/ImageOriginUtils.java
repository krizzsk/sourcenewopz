package com.facebook.drawee.backends.pipeline.info;

public class ImageOriginUtils {
    public static String toString(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "unknown" : "local" : "memory_bitmap" : "memory_encoded" : "disk" : "network";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int mapProducerNameToImageOrigin(java.lang.String r7) {
        /*
            int r0 = r7.hashCode()
            r1 = 1
            r2 = 6
            r3 = 2
            r4 = 3
            r5 = 4
            r6 = 5
            switch(r0) {
                case -1914072202: goto L_0x0077;
                case -1683996557: goto L_0x006d;
                case -1579985851: goto L_0x0063;
                case -1307634203: goto L_0x0059;
                case -1224383234: goto L_0x004f;
                case 656304759: goto L_0x0045;
                case 957714404: goto L_0x003b;
                case 1019542023: goto L_0x0030;
                case 1721672898: goto L_0x0026;
                case 1793127518: goto L_0x001b;
                case 2113652014: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0081
        L_0x000f:
            java.lang.String r0 = "LocalContentUriFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 9
            goto L_0x0082
        L_0x001b:
            java.lang.String r0 = "LocalContentUriThumbnailFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 10
            goto L_0x0082
        L_0x0026:
            java.lang.String r0 = "DataFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 5
            goto L_0x0082
        L_0x0030:
            java.lang.String r0 = "LocalAssetFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 8
            goto L_0x0082
        L_0x003b:
            java.lang.String r0 = "BitmapMemoryCacheProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 1
            goto L_0x0082
        L_0x0045:
            java.lang.String r0 = "DiskCacheProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 3
            goto L_0x0082
        L_0x004f:
            java.lang.String r0 = "NetworkFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 4
            goto L_0x0082
        L_0x0059:
            java.lang.String r0 = "EncodedMemoryCacheProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 2
            goto L_0x0082
        L_0x0063:
            java.lang.String r0 = "LocalFileFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 6
            goto L_0x0082
        L_0x006d:
            java.lang.String r0 = "LocalResourceFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 7
            goto L_0x0082
        L_0x0077:
            java.lang.String r0 = "BitmapMemoryCacheGetProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 0
            goto L_0x0082
        L_0x0081:
            r7 = -1
        L_0x0082:
            switch(r7) {
                case 0: goto L_0x008a;
                case 1: goto L_0x008a;
                case 2: goto L_0x0089;
                case 3: goto L_0x0088;
                case 4: goto L_0x0087;
                case 5: goto L_0x0086;
                case 6: goto L_0x0086;
                case 7: goto L_0x0086;
                case 8: goto L_0x0086;
                case 9: goto L_0x0086;
                case 10: goto L_0x0086;
                default: goto L_0x0085;
            }
        L_0x0085:
            return r1
        L_0x0086:
            return r2
        L_0x0087:
            return r3
        L_0x0088:
            return r4
        L_0x0089:
            return r5
        L_0x008a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.mapProducerNameToImageOrigin(java.lang.String):int");
    }

    private ImageOriginUtils() {
    }
}
