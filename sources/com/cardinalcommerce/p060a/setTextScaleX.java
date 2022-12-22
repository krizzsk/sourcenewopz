package com.cardinalcommerce.p060a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.cardinalcommerce.a.setTextScaleX */
public final class setTextScaleX implements Runnable {

    /* renamed from: e */
    private static int f3056e = 0;

    /* renamed from: f */
    private static int f3057f = 1;

    /* renamed from: a */
    final setFallbackLineSpacing f3058a;

    /* renamed from: b */
    private String f3059b;

    /* renamed from: c */
    private boolean f3060c;

    /* renamed from: d */
    private setTextMetricsParams f3061d = setTextMetricsParams.getSDKVersion();
    public final ExecutorService getInstance;

    public setTextScaleX(setFallbackLineSpacing setfallbacklinespacing, String str) {
        this.f3058a = setfallbacklinespacing;
        this.f3059b = str;
        this.f3060c = str.substring(0, 4).equalsIgnoreCase("http");
        this.getInstance = Executors.newFixedThreadPool(5);
    }

    /* renamed from: a */
    private boolean m2155a() {
        int i = f3056e;
        int i2 = i & 31;
        int i3 = i2 + ((i ^ 31) | i2);
        f3057f = i3 % 128;
        if ((i3 % 2 == 0 ? 18 : '6') == '6') {
            return this.getInstance.isShutdown();
        }
        boolean isShutdown = this.getInstance.isShutdown();
        Object[] objArr = null;
        int length = objArr.length;
        return isShutdown;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a5, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01a6, code lost:
        if (r1 == false) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r13 = r4.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01a9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01ac, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if ((r0 ? '=' : '2') != '2') goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0082, code lost:
        if ((r5 != null ? '8' : 15) != 15) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
        if ((r5 != null ? 30 : '%') != 30) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00be, code lost:
        r13 = f3057f;
        r2 = r13 ^ 21;
        r13 = ((r13 & 21) | r2) << 1;
        r2 = -r2;
        r6 = (r13 & r2) + (r13 | r2);
        f3056e = r6 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d1, code lost:
        if ((r6 % 2) == 0) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d3, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d5, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d9, code lost:
        if (r13 == true) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r13 = r12.f3058a.getWidth();
        r6 = r12.f3058a.getHeight();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00eb, code lost:
        if (r5.getByteCount() < 100000) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ee, code lost:
        r13 = r12.f3058a.getWidth();
        r6 = r12.f3058a.getHeight();
        r7 = r5.getByteCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r8 = r4.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ff, code lost:
        if (r7 < 100000) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r10 = new android.graphics.Matrix();
        r2 = ((float) r13) / ((float) r5.getWidth());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0112, code lost:
        r7 = ((float) r6) / ((float) r5.getHeight());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0116, code lost:
        if (r13 <= r6) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0118, code lost:
        r13 = 'V';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x011b, code lost:
        r13 = '5';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x011d, code lost:
        if (r13 == '5') goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x011f, code lost:
        r13 = f3057f;
        r6 = r13 & 117;
        r13 = ((r13 | 117) & (~r6)) + (r6 << 1);
        f3056e = r13 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012f, code lost:
        if ((r13 % 2) == 0) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0131, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0133, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0134, code lost:
        if (r13 == false) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        r10.postScale(r2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r10.postScale(r2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0142, code lost:
        r13 = f3056e;
        r2 = (r13 & 37) + (r13 | 37);
        f3057f = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r10.postScale(r7, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0152, code lost:
        r13 = f3056e + 41;
        f3057f = r13 % 128;
        r13 = r13 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        r5 = android.graphics.Bitmap.createBitmap(r5, 0, 0, r5.getWidth(), r5.getHeight(), r10, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x016b, code lost:
        r13 = f3056e;
        r0 = r13 & 1;
        r13 = (r13 ^ 1) | r0;
        r2 = (r0 & r13) + (r13 | r0);
        f3057f = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x017c, code lost:
        r13 = f3056e;
        r0 = r13 & 23;
        r0 = r0 + ((r13 ^ 23) | r0);
        f3057f = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r12.f3058a.post(new com.cardinalcommerce.p060a.setTextScaleX.C21055(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0194, code lost:
        r13 = f3056e;
        r0 = ((r13 | 91) << 1) - (r13 ^ 91);
        f3057f = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a2, code lost:
        if ((r0 % 2) != 0) goto L_0x01a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2154a(android.graphics.Bitmap r13) {
        /*
            r12 = this;
            int r0 = f3057f
            int r0 = r0 + 29
            r1 = 1
            int r0 = r0 - r1
            r2 = r0 & -1
            r0 = r0 | -1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f3056e = r0
            int r2 = r2 % 2
            r0 = 24
            if (r2 == 0) goto L_0x0018
            r2 = 24
            goto L_0x001a
        L_0x0018:
            r2 = 34
        L_0x001a:
            r3 = 0
            r4 = 0
            if (r2 == r0) goto L_0x002a
            boolean r0 = r12.m2155a()     // Catch:{ Exception -> 0x01b3 }
            if (r0 == 0) goto L_0x0026
            r0 = 0
            goto L_0x0027
        L_0x0026:
            r0 = 1
        L_0x0027:
            if (r0 == 0) goto L_0x003c
            goto L_0x0051
        L_0x002a:
            boolean r0 = r12.m2155a()     // Catch:{ Exception -> 0x01b3 }
            super.hashCode()     // Catch:{ all -> 0x01b1 }
            r2 = 50
            if (r0 == 0) goto L_0x0038
            r0 = 61
            goto L_0x003a
        L_0x0038:
            r0 = 50
        L_0x003a:
            if (r0 == r2) goto L_0x0051
        L_0x003c:
            int r13 = f3057f
            r0 = r13 ^ 99
            r13 = r13 & 99
            int r13 = r13 << r1
            int r13 = -r13
            int r13 = -r13
            r2 = r0 & r13
            r13 = r13 | r0
            int r2 = r2 + r13
            int r13 = r2 % 128
            f3056e = r13
            int r2 = r2 % 2
            r5 = r4
            goto L_0x0052
        L_0x0051:
            r5 = r13
        L_0x0052:
            com.cardinalcommerce.a.setFallbackLineSpacing r13 = r12.f3058a     // Catch:{ Exception -> 0x01b3 }
            if (r13 == 0) goto L_0x0058
            r13 = 1
            goto L_0x0059
        L_0x0058:
            r13 = 0
        L_0x0059:
            if (r13 == r1) goto L_0x005c
            goto L_0x00b2
        L_0x005c:
            int r13 = f3056e
            r0 = r13 & 13
            int r2 = ~r0
            r13 = r13 | 13
            r13 = r13 & r2
            int r0 = r0 << r1
            r2 = r13 | r0
            int r2 = r2 << r1
            r13 = r13 ^ r0
            int r2 = r2 - r13
            int r13 = r2 % 128
            f3057f = r13
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x0074
            r13 = 0
            goto L_0x0075
        L_0x0074:
            r13 = 1
        L_0x0075:
            r0 = 37
            if (r13 == 0) goto L_0x0085
            r13 = 15
            if (r5 == 0) goto L_0x0080
            r2 = 56
            goto L_0x0082
        L_0x0080:
            r2 = 15
        L_0x0082:
            if (r2 == r13) goto L_0x0093
            goto L_0x00be
        L_0x0085:
            r13 = 52
            int r13 = r13 / r3
            r13 = 30
            if (r5 == 0) goto L_0x008f
            r2 = 30
            goto L_0x0091
        L_0x008f:
            r2 = 37
        L_0x0091:
            if (r2 == r13) goto L_0x00be
        L_0x0093:
            com.cardinalcommerce.a.setTextMetricsParams r13 = r12.f3061d     // Catch:{ Exception -> 0x01b3 }
            java.lang.String r0 = "10613"
            java.lang.String r2 = "Error downloading image"
            r13.configure(r0, r2, r4)     // Catch:{ Exception -> 0x01b3 }
            com.cardinalcommerce.a.setFallbackLineSpacing r13 = r12.f3058a     // Catch:{ Exception -> 0x01b3 }
            r0 = 4
            r13.setVisibility(r0)     // Catch:{ Exception -> 0x01b3 }
            int r13 = f3056e
            int r13 = r13 + 43
            int r13 = r13 - r1
            r0 = r13 & -1
            r13 = r13 | -1
            int r0 = r0 + r13
            int r13 = r0 % 128
            f3057f = r13
            int r0 = r0 % 2
        L_0x00b2:
            int r13 = f3057f
            int r13 = r13 + 20
            int r13 = r13 - r1
            int r0 = r13 % 128
            f3056e = r0
            int r13 = r13 % 2
            return
        L_0x00be:
            int r13 = f3057f
            r2 = r13 ^ 21
            r13 = r13 & 21
            r13 = r13 | r2
            int r13 = r13 << r1
            int r2 = -r2
            r6 = r13 & r2
            r13 = r13 | r2
            int r6 = r6 + r13
            int r13 = r6 % 128
            f3056e = r13
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x00d5
            r13 = 1
            goto L_0x00d6
        L_0x00d5:
            r13 = 0
        L_0x00d6:
            r2 = 100000(0x186a0, float:1.4013E-40)
            if (r13 == r1) goto L_0x00ee
            com.cardinalcommerce.a.setFallbackLineSpacing r13 = r12.f3058a     // Catch:{ Exception -> 0x01b3 }
            int r13 = r13.getWidth()     // Catch:{ Exception -> 0x01b3 }
            com.cardinalcommerce.a.setFallbackLineSpacing r6 = r12.f3058a     // Catch:{ Exception -> 0x01b3 }
            int r6 = r6.getHeight()     // Catch:{ Exception -> 0x01b3 }
            int r7 = r5.getByteCount()     // Catch:{ Exception -> 0x01b3 }
            if (r7 < r2) goto L_0x017c
            goto L_0x0101
        L_0x00ee:
            com.cardinalcommerce.a.setFallbackLineSpacing r13 = r12.f3058a     // Catch:{ Exception -> 0x01b3 }
            int r13 = r13.getWidth()     // Catch:{ Exception -> 0x01b3 }
            com.cardinalcommerce.a.setFallbackLineSpacing r6 = r12.f3058a     // Catch:{ Exception -> 0x01b3 }
            int r6 = r6.getHeight()     // Catch:{ Exception -> 0x01b3 }
            int r7 = r5.getByteCount()     // Catch:{ Exception -> 0x01b3 }
            int r8 = r4.length     // Catch:{ all -> 0x01ad }
            if (r7 < r2) goto L_0x017c
        L_0x0101:
            android.graphics.Matrix r10 = new android.graphics.Matrix     // Catch:{ Exception -> 0x01b3 }
            r10.<init>()     // Catch:{ Exception -> 0x01b3 }
            float r2 = (float) r13     // Catch:{ Exception -> 0x01b3 }
            int r7 = r5.getWidth()     // Catch:{ Exception -> 0x01b3 }
            float r7 = (float) r7     // Catch:{ Exception -> 0x01b3 }
            float r2 = r2 / r7
            float r7 = (float) r6     // Catch:{ Exception -> 0x01b3 }
            int r8 = r5.getHeight()     // Catch:{ Exception -> 0x01b3 }
            float r8 = (float) r8
            float r7 = r7 / r8
            r8 = 53
            if (r13 <= r6) goto L_0x011b
            r13 = 86
            goto L_0x011d
        L_0x011b:
            r13 = 53
        L_0x011d:
            if (r13 == r8) goto L_0x014f
            int r13 = f3057f
            r6 = r13 & 117(0x75, float:1.64E-43)
            int r7 = ~r6
            r13 = r13 | 117(0x75, float:1.64E-43)
            r13 = r13 & r7
            int r6 = r6 << r1
            int r13 = r13 + r6
            int r6 = r13 % 128
            f3056e = r6
            int r13 = r13 % 2
            if (r13 == 0) goto L_0x0133
            r13 = 1
            goto L_0x0134
        L_0x0133:
            r13 = 0
        L_0x0134:
            if (r13 == 0) goto L_0x013f
            r10.postScale(r2, r2)     // Catch:{ Exception -> 0x01b3 }
            super.hashCode()     // Catch:{ all -> 0x013d }
            goto L_0x0142
        L_0x013d:
            r13 = move-exception
            throw r13
        L_0x013f:
            r10.postScale(r2, r2)     // Catch:{ Exception -> 0x01b3 }
        L_0x0142:
            int r13 = f3056e
            r2 = r13 & 37
            r13 = r13 | r0
            int r2 = r2 + r13
            int r13 = r2 % 128
            f3057f = r13
            int r2 = r2 % 2
            goto L_0x015c
        L_0x014f:
            r10.postScale(r7, r7)     // Catch:{ Exception -> 0x01b3 }
            int r13 = f3056e
            int r13 = r13 + 41
            int r0 = r13 % 128
            f3057f = r0
            int r13 = r13 % 2
        L_0x015c:
            r6 = 0
            r7 = 0
            int r8 = r5.getWidth()     // Catch:{ Exception -> 0x01b3 }
            int r9 = r5.getHeight()     // Catch:{ Exception -> 0x01b3 }
            r11 = 0
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x01b3 }
            int r13 = f3056e
            r0 = r13 & 1
            r13 = r13 ^ r1
            r13 = r13 | r0
            r2 = r0 & r13
            r13 = r13 | r0
            int r2 = r2 + r13
            int r13 = r2 % 128
            f3057f = r13
            int r2 = r2 % 2
            goto L_0x018a
        L_0x017c:
            int r13 = f3056e
            r0 = r13 & 23
            r13 = r13 ^ 23
            r13 = r13 | r0
            int r0 = r0 + r13
            int r13 = r0 % 128
            f3057f = r13
            int r0 = r0 % 2
        L_0x018a:
            com.cardinalcommerce.a.setFallbackLineSpacing r13 = r12.f3058a     // Catch:{ Exception -> 0x01b3 }
            com.cardinalcommerce.a.setTextScaleX$5 r0 = new com.cardinalcommerce.a.setTextScaleX$5     // Catch:{ Exception -> 0x01b3 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x01b3 }
            r13.post(r0)     // Catch:{ Exception -> 0x01b3 }
            int r13 = f3056e
            r0 = r13 | 91
            int r0 = r0 << r1
            r13 = r13 ^ 91
            int r0 = r0 - r13
            int r13 = r0 % 128
            f3057f = r13
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x01a5
            goto L_0x01a6
        L_0x01a5:
            r1 = 0
        L_0x01a6:
            if (r1 == 0) goto L_0x01ac
            int r13 = r4.length     // Catch:{ all -> 0x01aa }
            return
        L_0x01aa:
            r13 = move-exception
            throw r13
        L_0x01ac:
            return
        L_0x01ad:
            r13 = move-exception
            throw r13
        L_0x01af:
            r13 = move-exception
            throw r13
        L_0x01b1:
            r13 = move-exception
            throw r13
        L_0x01b3:
            r13 = move-exception
            com.cardinalcommerce.a.setTextMetricsParams r0 = r12.f3061d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error downloading bitmap for psImage/issuerImage"
            r1.<init>(r2)
            java.lang.String r13 = r13.getLocalizedMessage()
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            java.lang.String r1 = "13202"
            r0.configure(r1, r13, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextScaleX.m2154a(android.graphics.Bitmap):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v36, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r4v0, types: [android.graphics.Bitmap, java.lang.Object, java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x017a, code lost:
        if ((r6 != null ? '1' : 11) != '1') goto L_0x0189;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0207 A[SYNTHETIC, Splitter:B:123:0x0207] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            int r0 = f3056e
            r1 = r0 ^ 91
            r2 = r0 & 91
            r1 = r1 | r2
            r2 = 1
            int r1 = r1 << r2
            r3 = r0 & -92
            int r0 = ~r0
            r0 = r0 & 91
            r0 = r0 | r3
            int r1 = r1 - r0
            int r0 = r1 % 128
            f3057f = r0
            r0 = 2
            int r1 = r1 % r0
            r1 = 87
            r3 = 31
            r4 = 0
            r5 = 0
            boolean r6 = r13.f3060c     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            r7 = 9
            if (r6 != 0) goto L_0x0025
            r6 = 9
            goto L_0x0027
        L_0x0025:
            r6 = 76
        L_0x0027:
            if (r6 == r7) goto L_0x01a2
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            java.lang.String r7 = r13.f3059b     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            int r7 = r6.getResponseCode()     // Catch:{ Exception -> 0x019f, all -> 0x019b }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 == r8) goto L_0x0040
            r7 = 1
            goto L_0x0041
        L_0x0040:
            r7 = 0
        L_0x0041:
            if (r7 == r2) goto L_0x0147
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ Exception -> 0x019f, all -> 0x019b }
            r8 = 60
            if (r7 == 0) goto L_0x004e
            r9 = 60
            goto L_0x0050
        L_0x004e:
            r9 = 54
        L_0x0050:
            if (r9 == r8) goto L_0x00bb
            r1 = 25
            if (r6 == 0) goto L_0x0059
            r3 = 19
            goto L_0x005b
        L_0x0059:
            r3 = 25
        L_0x005b:
            if (r3 == r1) goto L_0x008c
            int r1 = f3057f
            r3 = r1 & 45
            int r8 = ~r3
            r1 = r1 | 45
            r1 = r1 & r8
            int r3 = r3 << r2
            int r3 = -r3
            int r3 = -r3
            r8 = r1 ^ r3
            r1 = r1 & r3
            int r1 = r1 << r2
            int r8 = r8 + r1
            int r1 = r8 % 128
            f3056e = r1
            int r8 = r8 % r0
            r6.disconnect()
            int r1 = f3056e
            r3 = r1 & -78
            int r6 = ~r1
            r6 = r6 & 77
            r3 = r3 | r6
            r1 = r1 & 77
            int r1 = r1 << r2
            int r1 = -r1
            int r1 = -r1
            r6 = r3 | r1
            int r6 = r6 << r2
            r1 = r1 ^ r3
            int r6 = r6 - r1
            int r1 = r6 % 128
            f3057f = r1
            int r6 = r6 % r0
        L_0x008c:
            r1 = 97
            if (r7 == 0) goto L_0x0093
            r3 = 69
            goto L_0x0095
        L_0x0093:
            r3 = 97
        L_0x0095:
            if (r3 == r1) goto L_0x028e
            int r1 = f3057f
            r3 = r1 & 34
            r1 = r1 | 34
            int r3 = r3 + r1
            int r3 = r3 - r5
            int r3 = r3 - r2
            int r1 = r3 % 128
            f3056e = r1
            int r3 = r3 % r0
            if (r3 == 0) goto L_0x00a9
            r1 = 0
            goto L_0x00aa
        L_0x00a9:
            r1 = 1
        L_0x00aa:
            if (r1 == r2) goto L_0x00b6
            r7.close()     // Catch:{ IOException -> 0x028a }
            r1 = 29
            int r1 = r1 / r5
            goto L_0x028e
        L_0x00b4:
            r0 = move-exception
            throw r0
        L_0x00b6:
            r7.close()     // Catch:{ IOException -> 0x028a }
            goto L_0x028e
        L_0x00bb:
            int r8 = f3057f
            r9 = r8 ^ 21
            r10 = r8 & 21
            r9 = r9 | r10
            int r9 = r9 << r2
            r10 = r8 & -22
            int r8 = ~r8
            r11 = 21
            r8 = r8 & r11
            r8 = r8 | r10
            int r8 = -r8
            r10 = r9 | r8
            int r10 = r10 << r2
            r8 = r8 ^ r9
            int r10 = r10 - r8
            int r8 = r10 % 128
            f3056e = r8
            int r10 = r10 % r0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r7)     // Catch:{ Exception -> 0x0144 }
            r13.m2154a(r8)     // Catch:{ Exception -> 0x0144 }
            if (r6 == 0) goto L_0x00e1
            r1 = 31
            goto L_0x00e3
        L_0x00e1:
            r1 = 13
        L_0x00e3:
            if (r1 == r3) goto L_0x00e6
            goto L_0x0103
        L_0x00e6:
            int r1 = f3056e
            int r1 = r1 + 72
            int r1 = r1 - r2
            int r3 = r1 % 128
            f3057f = r3
            int r1 = r1 % r0
            r3 = 48
            if (r1 != 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r11 = 48
        L_0x00f7:
            if (r11 == r3) goto L_0x0100
            r6.disconnect()
            int r1 = r4.length     // Catch:{ all -> 0x00fe }
            goto L_0x0103
        L_0x00fe:
            r0 = move-exception
            throw r0
        L_0x0100:
            r6.disconnect()
        L_0x0103:
            r1 = 84
            if (r7 == 0) goto L_0x010a
            r3 = 84
            goto L_0x010c
        L_0x010a:
            r3 = 30
        L_0x010c:
            if (r3 == r1) goto L_0x010f
            goto L_0x012b
        L_0x010f:
            int r1 = f3056e
            int r1 = r1 + 100
            int r1 = r1 - r2
            int r3 = r1 % 128
            f3057f = r3
            int r1 = r1 % r0
            r7.close()     // Catch:{ IOException -> 0x0127 }
            int r1 = f3056e
            int r1 = r1 + 36
            int r1 = r1 - r2
            int r2 = r1 % 128
            f3057f = r2
            int r1 = r1 % r0
            return
        L_0x0127:
            r1 = move-exception
            r1.printStackTrace()
        L_0x012b:
            int r1 = f3056e
            r3 = r1 ^ 123(0x7b, float:1.72E-43)
            r4 = r1 & 123(0x7b, float:1.72E-43)
            r3 = r3 | r4
            int r3 = r3 << r2
            int r4 = ~r4
            r1 = r1 | 123(0x7b, float:1.72E-43)
            r1 = r1 & r4
            int r1 = -r1
            r4 = r3 | r1
            int r2 = r4 << 1
            r1 = r1 ^ r3
            int r2 = r2 - r1
            int r1 = r2 % 128
            f3057f = r1
            int r2 = r2 % r0
            return
        L_0x0144:
            r8 = move-exception
            goto L_0x0205
        L_0x0147:
            int r7 = f3056e
            r8 = r7 & 87
            r7 = r7 ^ r1
            r7 = r7 | r8
            r9 = r8 ^ r7
            r7 = r7 & r8
            int r7 = r7 << r2
            int r9 = r9 + r7
            int r7 = r9 % 128
            f3057f = r7
            int r9 = r9 % r0
            if (r9 != 0) goto L_0x015b
            r7 = 1
            goto L_0x015c
        L_0x015b:
            r7 = 0
        L_0x015c:
            r8 = 32
            if (r7 == r2) goto L_0x016d
            r13.m2154a(r4)     // Catch:{ Exception -> 0x019f, all -> 0x019b }
            if (r6 == 0) goto L_0x0168
            r1 = 51
            goto L_0x016a
        L_0x0168:
            r1 = 32
        L_0x016a:
            if (r1 == r8) goto L_0x0189
            goto L_0x017d
        L_0x016d:
            r13.m2154a(r4)     // Catch:{ Exception -> 0x019f, all -> 0x019b }
            int r8 = r8 / r5
            r1 = 49
            if (r6 == 0) goto L_0x0178
            r3 = 49
            goto L_0x017a
        L_0x0178:
            r3 = 11
        L_0x017a:
            if (r3 == r1) goto L_0x017d
            goto L_0x0189
        L_0x017d:
            r6.disconnect()
            int r1 = f3056e
            int r1 = r1 + 47
            int r3 = r1 % 128
            f3057f = r3
            int r1 = r1 % r0
        L_0x0189:
            int r1 = f3057f
            int r1 = r1 + 115
            int r1 = r1 - r2
            r2 = r1 & -1
            r1 = r1 | -1
            int r2 = r2 + r1
            int r1 = r2 % 128
            f3056e = r1
            int r2 = r2 % r0
            return
        L_0x0199:
            r0 = move-exception
            throw r0
        L_0x019b:
            r3 = move-exception
            r7 = r4
            goto L_0x02a4
        L_0x019f:
            r8 = move-exception
            r7 = r4
            goto L_0x0205
        L_0x01a2:
            int r6 = f3056e
            r7 = r6 ^ 63
            r8 = r6 & 63
            r7 = r7 | r8
            int r7 = r7 << r2
            int r8 = ~r8
            r6 = r6 | 63
            r6 = r6 & r8
            int r6 = -r6
            int r6 = ~r6
            int r7 = r7 - r6
            int r7 = r7 - r2
            int r6 = r7 % 128
            f3057f = r6
            int r7 = r7 % r0
            if (r7 != 0) goto L_0x01bc
            r6 = 31
            goto L_0x01be
        L_0x01bc:
            r6 = 35
        L_0x01be:
            java.lang.String r7 = ","
            if (r6 == r3) goto L_0x01e5
            java.lang.String r6 = r13.f3059b     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            java.lang.String r8 = r13.f3059b     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            int r7 = r8.indexOf(r7)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            r8 = r7 & 1
            r7 = r7 ^ r2
            r7 = r7 | r8
            int r7 = -r7
            int r7 = -r7
            r9 = r8 & r7
            r7 = r7 | r8
            int r9 = r9 + r7
            java.lang.String r6 = r6.substring(r9)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            byte[] r6 = android.util.Base64.decode(r6, r5)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            int r7 = r6.length     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeByteArray(r6, r5, r7)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
        L_0x01e1:
            r13.m2154a(r6)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            goto L_0x01fc
        L_0x01e5:
            java.lang.String r6 = r13.f3059b     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            java.lang.String r8 = r13.f3059b     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            int r7 = r8.indexOf(r7)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            int r7 = r7 << r5
            java.lang.String r6 = r6.substring(r7)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            byte[] r6 = android.util.Base64.decode(r6, r5)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            int r7 = r6.length     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeByteArray(r6, r2, r7)     // Catch:{ Exception -> 0x0202, all -> 0x01fd }
            goto L_0x01e1
        L_0x01fc:
            return
        L_0x01fd:
            r3 = move-exception
            r6 = r4
            r7 = r6
            goto L_0x02a4
        L_0x0202:
            r8 = move-exception
            r6 = r4
            r7 = r6
        L_0x0205:
            if (r6 == 0) goto L_0x0216
            r6.disconnect()     // Catch:{ all -> 0x02a3 }
            int r9 = f3056e
            int r9 = r9 + 39
            int r9 = r9 - r2
            int r9 = r9 - r5
            int r9 = r9 - r2
            int r10 = r9 % 128
            f3057f = r10
            int r9 = r9 % r0
        L_0x0216:
            com.cardinalcommerce.a.setTextMetricsParams r9 = r13.f3061d     // Catch:{ all -> 0x02a3 }
            java.lang.String r10 = "13202"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a3 }
            java.lang.String r12 = "Error downloading bitmap for psImage/issuerImage"
            r11.<init>(r12)     // Catch:{ all -> 0x02a3 }
            java.lang.String r8 = r8.getLocalizedMessage()     // Catch:{ all -> 0x02a3 }
            r11.append(r8)     // Catch:{ all -> 0x02a3 }
            java.lang.String r8 = r11.toString()     // Catch:{ all -> 0x02a3 }
            r9.configure(r10, r8, r4)     // Catch:{ all -> 0x02a3 }
            r1 = 41
            if (r6 == 0) goto L_0x0236
            r8 = 41
            goto L_0x0238
        L_0x0236:
            r8 = 65
        L_0x0238:
            if (r8 == r1) goto L_0x023b
            goto L_0x0257
        L_0x023b:
            int r1 = f3057f
            int r1 = r1 + 15
            int r8 = r1 % 128
            f3056e = r8
            int r1 = r1 % r0
            if (r1 == 0) goto L_0x0249
            r1 = 31
            goto L_0x024b
        L_0x0249:
            r1 = 17
        L_0x024b:
            if (r1 == r3) goto L_0x0251
            r6.disconnect()
            goto L_0x0257
        L_0x0251:
            r6.disconnect()
            super.hashCode()     // Catch:{ all -> 0x02a1 }
        L_0x0257:
            r1 = 4
            if (r7 == 0) goto L_0x025c
            r3 = 4
            goto L_0x025e
        L_0x025c:
            r3 = 83
        L_0x025e:
            if (r3 == r1) goto L_0x0261
            goto L_0x028e
        L_0x0261:
            int r1 = f3057f
            r3 = r1 | 101(0x65, float:1.42E-43)
            int r3 = r3 << r2
            r6 = r1 & -102(0xffffffffffffff9a, float:NaN)
            int r1 = ~r1
            r1 = r1 & 101(0x65, float:1.42E-43)
            r1 = r1 | r6
            int r1 = -r1
            r6 = r3 | r1
            int r6 = r6 << r2
            r1 = r1 ^ r3
            int r6 = r6 - r1
            int r1 = r6 % 128
            f3056e = r1
            int r6 = r6 % r0
            if (r6 == 0) goto L_0x027a
            goto L_0x027b
        L_0x027a:
            r5 = 1
        L_0x027b:
            if (r5 == 0) goto L_0x0281
            r7.close()     // Catch:{ IOException -> 0x028a }
            goto L_0x028e
        L_0x0281:
            r7.close()     // Catch:{ IOException -> 0x028a }
            super.hashCode()     // Catch:{ all -> 0x0288 }
            goto L_0x028e
        L_0x0288:
            r0 = move-exception
            throw r0
        L_0x028a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x028e:
            r13.m2154a(r4)
            int r1 = f3056e
            r3 = r1 & 45
            r1 = r1 ^ 45
            r1 = r1 | r3
            int r1 = ~r1
            int r3 = r3 - r1
            int r3 = r3 - r2
            int r1 = r3 % 128
            f3057f = r1
            int r3 = r3 % r0
            return
        L_0x02a1:
            r0 = move-exception
            throw r0
        L_0x02a3:
            r3 = move-exception
        L_0x02a4:
            if (r6 == 0) goto L_0x02b5
            r6.disconnect()
            int r6 = f3057f
            r8 = r6 & 5
            r6 = r6 | 5
            int r8 = r8 + r6
            int r6 = r8 % 128
            f3056e = r6
            int r8 = r8 % r0
        L_0x02b5:
            if (r7 == 0) goto L_0x02b8
            goto L_0x02b9
        L_0x02b8:
            r1 = 2
        L_0x02b9:
            if (r1 == r0) goto L_0x02e2
            int r1 = f3056e
            int r1 = r1 + 47
            int r1 = r1 - r2
            int r1 = r1 - r5
            int r1 = r1 - r2
            int r2 = r1 % 128
            f3057f = r2
            int r1 = r1 % r0
            r0 = 56
            if (r1 != 0) goto L_0x02ce
            r1 = 56
            goto L_0x02d0
        L_0x02ce:
            r1 = 28
        L_0x02d0:
            if (r1 == r0) goto L_0x02d8
            r7.close()     // Catch:{ IOException -> 0x02d6 }
            goto L_0x02e2
        L_0x02d6:
            r0 = move-exception
            goto L_0x02df
        L_0x02d8:
            r7.close()     // Catch:{ IOException -> 0x02d6 }
            int r0 = r4.length     // Catch:{ all -> 0x02dd }
            goto L_0x02e2
        L_0x02dd:
            r0 = move-exception
            throw r0
        L_0x02df:
            r0.printStackTrace()
        L_0x02e2:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextScaleX.run():void");
    }
}
