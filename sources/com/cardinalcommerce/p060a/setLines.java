package com.cardinalcommerce.p060a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import java.nio.charset.StandardCharsets;

/* renamed from: com.cardinalcommerce.a.setLines */
public final class setLines {

    /* renamed from: a */
    private static setLines f2861a = null;

    /* renamed from: c */
    private static setTextMetricsParams f2862c = null;

    /* renamed from: d */
    private static int f2863d = 0;

    /* renamed from: e */
    private static int f2864e = 1;

    /* renamed from: b */
    private final SharedPreferences f2865b;

    private setLines(Context context) {
        this.f2865b = SystemUtils.getSharedPreferences(context, "com.cardinalcommerce.cardinalmobilesdkcmsdk", 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r2 == null) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.cardinalcommerce.p060a.setLines init(android.content.Context r6) {
        /*
            java.lang.Class<com.cardinalcommerce.a.setLines> r0 = com.cardinalcommerce.p060a.setLines.class
            monitor-enter(r0)
            int r1 = f2864e     // Catch:{ all -> 0x0081 }
            r2 = 93
            r3 = r1 ^ 93
            r4 = r1 & 93
            r3 = r3 | r4
            r4 = 1
            int r3 = r3 << r4
            r5 = r1 & -94
            int r1 = ~r1     // Catch:{ all -> 0x0081 }
            r1 = r1 & r2
            r1 = r1 | r5
            int r1 = -r1
            r2 = r3 & r1
            r1 = r1 | r3
            int r2 = r2 + r1
            int r1 = r2 % 128
            f2863d = r1     // Catch:{ all -> 0x0081 }
            int r2 = r2 % 2
            r1 = 0
            if (r2 == 0) goto L_0x0023
            r2 = 1
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            if (r2 == r4) goto L_0x0031
            com.cardinalcommerce.a.setTextMetricsParams r2 = com.cardinalcommerce.p060a.setTextMetricsParams.getSDKVersion()     // Catch:{ all -> 0x0081 }
            f2862c = r2     // Catch:{ all -> 0x0081 }
            com.cardinalcommerce.a.setLines r2 = f2861a     // Catch:{ all -> 0x0081 }
            if (r2 != 0) goto L_0x0052
            goto L_0x003d
        L_0x0031:
            com.cardinalcommerce.a.setTextMetricsParams r2 = com.cardinalcommerce.p060a.setTextMetricsParams.getSDKVersion()     // Catch:{ all -> 0x0081 }
            f2862c = r2     // Catch:{ all -> 0x0081 }
            com.cardinalcommerce.a.setLines r2 = f2861a     // Catch:{ all -> 0x0081 }
            r3 = 0
            int r3 = r3.length     // Catch:{ all -> 0x007f }
            if (r2 != 0) goto L_0x0052
        L_0x003d:
            com.cardinalcommerce.a.setLines r2 = new com.cardinalcommerce.a.setLines     // Catch:{ all -> 0x0081 }
            r2.<init>(r6)     // Catch:{ all -> 0x0081 }
            f2861a = r2     // Catch:{ all -> 0x0081 }
            int r6 = f2864e     // Catch:{ all -> 0x0081 }
            r2 = r6 ^ 115(0x73, float:1.61E-43)
            r6 = r6 & 115(0x73, float:1.61E-43)
            int r6 = r6 << r4
            int r2 = r2 + r6
            int r6 = r2 % 128
            f2863d = r6     // Catch:{ all -> 0x0081 }
            int r2 = r2 % 2
        L_0x0052:
            com.cardinalcommerce.a.setLines r6 = f2861a     // Catch:{ all -> 0x0081 }
            int r2 = f2863d     // Catch:{ all -> 0x0081 }
            r3 = r2 ^ 1
            r5 = r2 & 1
            r3 = r3 | r5
            int r3 = r3 << r4
            r5 = r2 & -2
            int r2 = ~r2     // Catch:{ all -> 0x0081 }
            r2 = r2 & r4
            r2 = r2 | r5
            int r2 = -r2
            r4 = r3 & r2
            r2 = r2 | r3
            int r4 = r4 + r2
            int r2 = r4 % 128
            f2864e = r2     // Catch:{ all -> 0x0081 }
            int r4 = r4 % 2
            r2 = 22
            if (r4 != 0) goto L_0x0072
            r3 = 0
            goto L_0x0074
        L_0x0072:
            r3 = 22
        L_0x0074:
            if (r3 == r2) goto L_0x007d
            r2 = 67
            int r2 = r2 / r1
            monitor-exit(r0)
            return r6
        L_0x007b:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0081 }
        L_0x007d:
            monitor-exit(r0)
            return r6
        L_0x007f:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setLines.init(android.content.Context):com.cardinalcommerce.a.setLines");
    }

    public final synchronized void Cardinal(String str, String str2) {
        int i = f2864e;
        int i2 = i & 11;
        int i3 = ((((i ^ 11) | i2) << 1) - (~(-((i | 11) & (~i2))))) - 1;
        f2863d = i3 % 128;
        int i4 = i3 % 2;
        String str3 = null;
        try {
            this.f2865b.edit().putString(str, Base64.encodeToString(str2.getBytes(StandardCharsets.UTF_8), 0)).apply();
            int i5 = f2863d;
            int i6 = ((i5 | 109) << 1) - (i5 ^ 109);
            f2864e = i6 % 128;
            if ((i6 % 2 == 0 ? (char) 7 : 27) != 27) {
                super.hashCode();
            }
        } catch (Exception e) {
            setTextMetricsParams settextmetricsparams = f2862c;
            StringBuilder sb = new StringBuilder("Error while saving/retrieving data from shared preferences for \n");
            sb.append(str);
            sb.append(e.getLocalizedMessage());
            settextmetricsparams.configure("10706", sb.toString(), str3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        if ((r8.equals("SDKAppID") ? 'I' : kotlin.text.Typography.quote) != 'I') goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String cca_continue(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = f2864e     // Catch:{ all -> 0x00c1 }
            r1 = r0 ^ 61
            r0 = r0 & 61
            r2 = 1
            int r0 = r0 << r2
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0     // Catch:{ all -> 0x00c1 }
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            f2863d = r0     // Catch:{ all -> 0x00c1 }
            int r1 = r1 % 2
            r0 = 54
            if (r1 == 0) goto L_0x001b
            r1 = 54
            goto L_0x001d
        L_0x001b:
            r1 = 33
        L_0x001d:
            r3 = 0
            r4 = 0
            if (r1 == r0) goto L_0x003b
            android.content.SharedPreferences r0 = r7.f2865b     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = r0.getString(r8, r9)     // Catch:{ Exception -> 0x0039 }
            byte[] r0 = android.util.Base64.decode(r0, r4)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = "SDKAppID"
            boolean r1 = r8.equals(r1)     // Catch:{ Exception -> 0x0039 }
            if (r1 == 0) goto L_0x0035
            r1 = 0
            goto L_0x0036
        L_0x0035:
            r1 = 1
        L_0x0036:
            if (r1 == r2) goto L_0x0090
            goto L_0x0057
        L_0x0039:
            r0 = move-exception
            goto L_0x00a3
        L_0x003b:
            android.content.SharedPreferences r0 = r7.f2865b     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = r0.getString(r8, r9)     // Catch:{ Exception -> 0x0039 }
            byte[] r0 = android.util.Base64.decode(r0, r4)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = "SDKAppID"
            boolean r1 = r8.equals(r1)     // Catch:{ Exception -> 0x0039 }
            r5 = 73
            if (r1 == 0) goto L_0x0052
            r1 = 73
            goto L_0x0054
        L_0x0052:
            r1 = 34
        L_0x0054:
            if (r1 == r5) goto L_0x0057
            goto L_0x0090
        L_0x0057:
            r1 = 96
            if (r0 != 0) goto L_0x005e
            r5 = 23
            goto L_0x0060
        L_0x005e:
            r5 = 96
        L_0x0060:
            if (r5 == r1) goto L_0x0090
            int r1 = f2864e     // Catch:{ all -> 0x00c1 }
            r5 = r1 | 104(0x68, float:1.46E-43)
            int r5 = r5 << r2
            r1 = r1 ^ 104(0x68, float:1.46E-43)
            int r5 = r5 - r1
            int r5 = r5 - r2
            int r1 = r5 % 128
            f2863d = r1     // Catch:{ all -> 0x00c1 }
            int r5 = r5 % 2
            com.cardinalcommerce.a.setTextMetricsParams r1 = f2862c     // Catch:{ Exception -> 0x0039 }
            java.lang.String r5 = "CardinalConfigure"
            java.lang.String r6 = "SdkAppId is unavailable. \n"
            r1.init(r5, r6, r3)     // Catch:{ Exception -> 0x0039 }
            int r1 = f2864e     // Catch:{ all -> 0x00c1 }
            r5 = r1 ^ 31
            r6 = r1 & 31
            r5 = r5 | r6
            int r5 = r5 << r2
            int r6 = ~r6     // Catch:{ all -> 0x00c1 }
            r1 = r1 | 31
            r1 = r1 & r6
            int r5 = r5 - r1
            int r1 = r5 % 128
            f2863d = r1     // Catch:{ all -> 0x00c1 }
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0090
            r4 = 1
        L_0x0090:
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x0039 }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x0039 }
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x0039 }
            int r8 = f2864e     // Catch:{ all -> 0x00c1 }
            int r8 = r8 + 45
            int r9 = r8 % 128
            f2863d = r9     // Catch:{ all -> 0x00c1 }
            int r8 = r8 % 2
            monitor-exit(r7)
            return r1
        L_0x00a3:
            com.cardinalcommerce.a.setTextMetricsParams r1 = f2862c     // Catch:{ all -> 0x00c1 }
            java.lang.String r2 = "10704"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
            java.lang.String r5 = "Error while saving/retrieving data from shared preferences for \n"
            r4.<init>(r5)     // Catch:{ all -> 0x00c1 }
            r4.append(r8)     // Catch:{ all -> 0x00c1 }
            java.lang.String r8 = r0.getLocalizedMessage()     // Catch:{ all -> 0x00c1 }
            r4.append(r8)     // Catch:{ all -> 0x00c1 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00c1 }
            r1.configure(r2, r8, r3)     // Catch:{ all -> 0x00c1 }
            monitor-exit(r7)
            return r9
        L_0x00c1:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setLines.cca_continue(java.lang.String, java.lang.String):java.lang.String");
    }

    public final synchronized void configure(String str, long j) {
        int i = f2863d;
        int i2 = ((i | 103) << 1) - (i ^ 103);
        f2864e = i2 % 128;
        int i3 = i2 % 2;
        try {
            Cardinal(str, Long.toString(j));
            int i4 = f2863d;
            int i5 = i4 & 79;
            int i6 = i5 + ((i4 ^ 79) | i5);
            f2864e = i6 % 128;
            int i7 = i6 % 2;
        } catch (Exception e) {
            setTextMetricsParams settextmetricsparams = f2862c;
            StringBuilder sb = new StringBuilder("Error while saving/retrieving data from shared preferences for \n");
            sb.append(str);
            sb.append(e.getLocalizedMessage());
            settextmetricsparams.configure("10706", sb.toString(), (String) null);
        }
    }

    public final synchronized long getInstance(String str) {
        String cca_continue;
        long parseLong;
        int i = f2863d;
        int i2 = i & 117;
        int i3 = (i2 - (~((i ^ 117) | i2))) - 1;
        f2864e = i3 % 128;
        if ((i3 % 2 == 0 ? ';' : '$') != ';') {
            try {
                cca_continue = cca_continue(str, Long.toString(0));
            } catch (Exception e) {
                setTextMetricsParams settextmetricsparams = f2862c;
                StringBuilder sb = new StringBuilder("Error while parsing retrieving data from shared preferences for \n");
                sb.append(str);
                sb.append(e.getLocalizedMessage());
                settextmetricsparams.configure("10704", sb.toString(), (String) null);
                return 0;
            }
        } else {
            cca_continue = cca_continue(str, Long.toString(0));
        }
        parseLong = Long.parseLong(cca_continue);
        int i4 = f2864e;
        int i5 = ((i4 ^ 2) + ((i4 & 2) << 1)) - 1;
        f2863d = i5 % 128;
        int i6 = i5 % 2;
        return parseLong;
    }
}
