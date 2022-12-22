package com.google.android.gms.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0096, code lost:
        if (r2 >= r5) goto L_0x00b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.AdSize findClosestSize(android.content.Context r11, com.google.android.gms.ads.AdSize r12, java.util.List<com.google.android.gms.ads.AdSize> r13) {
        /*
            r0 = 0
            if (r13 == 0) goto L_0x00d7
            if (r12 != 0) goto L_0x0007
            goto L_0x00d7
        L_0x0007:
            boolean r1 = r12.zzdv()
            if (r1 != 0) goto L_0x0036
            boolean r1 = r12.zzdx()
            if (r1 != 0) goto L_0x0036
            android.content.res.Resources r1 = r11.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            int r2 = r12.getWidthInPixels(r11)
            float r2 = (float) r2
            float r2 = r2 / r1
            int r2 = java.lang.Math.round(r2)
            int r11 = r12.getHeightInPixels(r11)
            float r11 = (float) r11
            float r11 = r11 / r1
            int r11 = java.lang.Math.round(r11)
            com.google.android.gms.ads.AdSize r12 = new com.google.android.gms.ads.AdSize
            r12.<init>(r2, r11)
        L_0x0036:
            java.util.Iterator r11 = r13.iterator()
        L_0x003a:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x00d7
            java.lang.Object r13 = r11.next()
            com.google.android.gms.ads.AdSize r13 = (com.google.android.gms.ads.AdSize) r13
            r1 = 0
            if (r13 != 0) goto L_0x004b
            goto L_0x00b7
        L_0x004b:
            int r2 = r12.getWidth()
            int r3 = r13.getWidth()
            int r4 = r12.getHeight()
            int r5 = r13.getHeight()
            double r6 = (double) r2
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r6 = r6 * r8
            double r8 = (double) r3
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x00b7
            if (r2 >= r3) goto L_0x0068
            goto L_0x00b7
        L_0x0068:
            boolean r2 = r12.zzdx()
            if (r2 == 0) goto L_0x0099
            int r2 = r12.zzdy()
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r4 = com.google.android.gms.internal.ads.zzabq.zzdah
            com.google.android.gms.internal.ads.zzabm r6 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r4 = r6.zzd(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 > r3) goto L_0x00b7
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r3 = com.google.android.gms.internal.ads.zzabq.zzdai
            com.google.android.gms.internal.ads.zzabm r4 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 > r5) goto L_0x00b7
            if (r2 >= r5) goto L_0x00b6
            goto L_0x00b7
        L_0x0099:
            boolean r2 = r12.zzdv()
            if (r2 == 0) goto L_0x00a6
            int r2 = r12.zzdw()
            if (r2 >= r5) goto L_0x00b6
            goto L_0x00b7
        L_0x00a6:
            double r2 = (double) r4
            r6 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r2 = r2 * r6
            double r6 = (double) r5
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x00b7
            if (r4 >= r5) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r1 = 1
        L_0x00b7:
            if (r1 == 0) goto L_0x003a
            if (r0 != 0) goto L_0x00bc
            goto L_0x00d4
        L_0x00bc:
            int r1 = r0.getWidth()
            int r2 = r0.getHeight()
            int r1 = r1 * r2
            int r2 = r13.getWidth()
            int r3 = r13.getHeight()
            int r2 = r2 * r3
            if (r1 <= r2) goto L_0x00d4
            goto L_0x003a
        L_0x00d4:
            r0 = r13
            goto L_0x003a
        L_0x00d7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.MediationUtils.findClosestSize(android.content.Context, com.google.android.gms.ads.AdSize, java.util.List):com.google.android.gms.ads.AdSize");
    }
}
